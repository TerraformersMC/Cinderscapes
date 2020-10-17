package com.terraformersmc.cinderscapes.block;

import com.terraformersmc.cinderscapes.init.CinderscapesItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class BrambleBerryBushBlock extends SweetBerryBushBlock {
    private static final VoxelShape SMALL_SHAPE = Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
    private static final VoxelShape MEDIUM_SHAPE = Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 13.0D, 13.0D);
    private static final VoxelShape LARGE_SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D);

    public BrambleBerryBushBlock(Settings settings) {
        super(settings);
    }

    @Environment(EnvType.CLIENT)
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(CinderscapesItems.BRAMBLE_BERRIES);
    }

    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity && entity.getType() != EntityType.HOGLIN && entity.getType() != EntityType.ZOGLIN) {
            entity.slowMovement(state, new Vec3d(0.800000011920929D, 0.75D, 0.800000011920929D));
            if (!world.isClient && (Integer) state.get(AGE) > 0 && (entity.lastRenderX != entity.getX() || entity.lastRenderZ != entity.getZ())) {
                double d = Math.abs(entity.getX() - entity.lastRenderX);
                double e = Math.abs(entity.getZ() - entity.lastRenderZ);
                if (d >= 0.003000000026077032D || e >= 0.003000000026077032D) {
                    entity.damage(DamageSource.SWEET_BERRY_BUSH, 1.0F);
                }
            }

        }
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch(state.get(AGE)) {
            case 0:
                return SMALL_SHAPE;
            case 1:
                return MEDIUM_SHAPE;
            default:
                return LARGE_SHAPE;
        }
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int i = state.get(AGE);
        boolean bl = i == 3;
        if (!bl && player.getStackInHand(hand).getItem() == Items.BONE_MEAL) {
            return ActionResult.PASS;
        } else if (i > 1) {
            int j = 1 + world.random.nextInt(2);
            dropStack(world, pos, new ItemStack(CinderscapesItems.BRAMBLE_BERRIES, j + (bl ? 1 : 0)));
            world.playSound(null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
            world.setBlockState(pos, state.with(AGE, 1), 2);
            return ActionResult.SUCCESS;
        } else {
            return super.onUse(state, world, pos, player, hand, hit);
        }
    }

    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.NETHERRACK) || floor.isOf(Blocks.SOUL_SOIL) || floor.isOf(Blocks.SOUL_SAND) || floor.isOf(Blocks.GRAVEL);
    }

    public BlockState getGenerationState() {
        return this.getDefaultState().with(AGE, AGE.getValues().stream().max(Integer::compare).orElse(0));
    }
}
