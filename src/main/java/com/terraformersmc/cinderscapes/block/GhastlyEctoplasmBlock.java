package com.terraformersmc.cinderscapes.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.NullMarked;

import java.util.Locale;

@NullMarked
public class GhastlyEctoplasmBlock extends Block {
    public static final EnumProperty<GhastlyEctoplasmBlock.Type> TYPE = EnumProperty.create("type", GhastlyEctoplasmBlock.Type.class);

    public GhastlyEctoplasmBlock(Properties settings) {
        super(settings);
        registerDefaultState(defaultBlockState().setValue(TYPE, Type.BOTTOM));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return state.getValue(GhastlyEctoplasmBlock.TYPE) == GhastlyEctoplasmBlock.Type.BOTTOM ? Block.box(3.0D, 2.5D, 3.0D, 13.0D, 16.0D, 13.0D) : Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
    }

    @Override
    @Deprecated
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        BlockState aboveState = world.getBlockState(pos.above());
        return (!world.isEmptyBlock(pos.above()) && Block.isFaceFull(aboveState.getCollisionShape(world, pos.above()), Direction.DOWN)) || aboveState.getBlock() == this;
    }

    @Override
    @Deprecated
    public void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean notify) {
        world.setBlockAndUpdate(pos, evaluateState(state, pos, world));
    }

    @Override
    public BlockState updateShape(BlockState state, LevelReader world, ScheduledTickAccess tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        return evaluateState(state, pos, world);
    }

    public BlockState evaluateState(BlockState currentState, BlockPos currentPos, LevelReader world) {
        BlockState aboveState = world.getBlockState(currentPos.above());
        BlockState belowState = world.getBlockState(currentPos.below());
        BlockState twoBelowState = world.getBlockState(currentPos.below(2));
        if (!canSurvive(currentState, world, currentPos)) {
            return Blocks.AIR.defaultBlockState();
        }
        if (aboveState.getBlock() != this && belowState.getBlock() == this && twoBelowState.getBlock() == this) {
            return currentState.setValue(TYPE, Type.TOP);
        }
        if (belowState.getBlock() != this) {
            return currentState.setValue(TYPE, Type.BOTTOM);
        } else {
            return currentState.setValue(TYPE, Type.MIDDLE);
        }
    }

    public BlockState typeOf(Type type) {
        return defaultBlockState().setValue(TYPE, type);
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TYPE);
    }

    public enum Type implements StringRepresentable {
        TOP,
        MIDDLE,
        BOTTOM;

        @Override
        public String getSerializedName() {
            return this.toString().toLowerCase(Locale.ROOT);
        }
    }
}
