package com.terraformersmc.cinderscapes.block;

import com.terraformersmc.cinderscapes.util.StateShapeSupplier;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class GhastlyEctoplasmBlock extends Block {
    public static final EnumProperty<GhastlyEctoplasmBlock.Type> TYPE = EnumProperty.of("type", GhastlyEctoplasmBlock.Type.class);

    public GhastlyEctoplasmBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(TYPE, Type.BOTTOM));
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(GhastlyEctoplasmBlock.TYPE) == GhastlyEctoplasmBlock.Type.BOTTOM ? Block.createCuboidShape(3.0D, 2.5D, 3.0D, 13.0D, 16.0D, 13.0D) : Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
    }

    @Deprecated
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState aboveState = world.getBlockState(pos.up());
        return (!world.isAir(pos.up()) && Block.isFaceFullSquare(aboveState.getCollisionShape(world, pos.up()), Direction.DOWN)) || aboveState.getBlock() == this;
    }

    @Deprecated
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        world.setBlockState(pos, evaluateState(state, pos, world));
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        return evaluateState(state, pos, world);
    }

    public BlockState evaluateState(BlockState currentState, BlockPos currentPos, WorldAccess world) {
        BlockState aboveState = world.getBlockState(currentPos.up());
        BlockState belowState = world.getBlockState(currentPos.down());
        BlockState twoBelowState = world.getBlockState(currentPos.down(2));
        if (!canPlaceAt(currentState, world, currentPos)) {
            return Blocks.AIR.getDefaultState();
        }
        if (aboveState.getBlock() != this && belowState.getBlock() == this && twoBelowState.getBlock() == this) {
            return currentState.with(TYPE, Type.TOP);
        }
        if (belowState.getBlock() != this) {
            return currentState.with(TYPE, Type.BOTTOM);
        } else {
            return currentState.with(TYPE, Type.MIDDLE);
        }
    }

    public BlockState typeOf(Type type) {
        return getDefaultState().with(TYPE, type);
    }

    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TYPE);
    }

    public enum Type implements StringIdentifiable {
        TOP,
        MIDDLE,
        BOTTOM;

        @Override
        public String asString() {
            return this.toString().toLowerCase();
        }
    }
}
