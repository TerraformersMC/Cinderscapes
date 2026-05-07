package com.terraformersmc.cinderscapes.block;

import com.terraformersmc.cinderscapes.init.CinderscapesItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class BrambleBerryBushBlock extends SweetBerryBushBlock {
    private static final VoxelShape SMALL_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
    private static final VoxelShape MEDIUM_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 13.0D, 13.0D);
    private static final VoxelShape LARGE_SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D);

    public BrambleBerryBushBlock(Properties settings) {
        super(settings);
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean includeData) {
        return new ItemStack(CinderscapesItems.BRAMBLE_BERRIES);
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier handler, boolean initial) {
        if (entity instanceof LivingEntity && entity.getType() != EntityType.HOGLIN && entity.getType() != EntityType.ZOGLIN) {
            entity.makeStuckInBlock(state, new Vec3(0.800000011920929D, 0.75D, 0.800000011920929D));
            if (!level.isClientSide() && state.getValue(AGE) > 0 && (entity.xOld != entity.getX() || entity.zOld != entity.getZ())) {
                double d = Math.abs(entity.getX() - entity.xOld);
                double e = Math.abs(entity.getZ() - entity.zOld);
                if (level instanceof ServerLevel serverLevel && (d >= 0.003000000026077032D || e >= 0.003000000026077032D)) {
                    entity.hurtServer(serverLevel, level.damageSources().sweetBerryBush(), 1.0f);
                }
            }
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(AGE)) {
            case 0 -> SMALL_SHAPE;
            case 1 -> MEDIUM_SHAPE;
            default -> LARGE_SHAPE;
        };
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        int age = state.getValue(AGE);

        if (age > 1) {
            int count = age - 1 + level.getRandom().nextInt(2);
            popResource(level, pos, new ItemStack(CinderscapesItems.BRAMBLE_BERRIES, count));
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0f, 0.8f + level.getRandom().nextFloat() * 0.4f);
            BlockState newState = state.setValue(AGE, 1);
            level.setBlock(pos, newState, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, newState));

            return InteractionResult.SUCCESS;
        }

        return super.useWithoutItem(state, level, pos, player, hit);
    }

    @Override
    protected boolean mayPlaceOn(BlockState floor, BlockGetter level, BlockPos pos) {
        return floor.is(Blocks.NETHERRACK) || floor.is(Blocks.SOUL_SOIL) || floor.is(Blocks.SOUL_SAND) || floor.is(Blocks.GRAVEL);
    }

    public BlockState getGenerationState() {
        return this.defaultBlockState().setValue(AGE, AGE.getPossibleValues().stream().max(Integer::compare).orElse(0));
    }
}
