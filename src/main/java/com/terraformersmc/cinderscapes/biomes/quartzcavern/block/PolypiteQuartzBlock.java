package com.terraformersmc.cinderscapes.biomes.quartzcavern.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class PolypiteQuartzBlock extends Block {

    public static final EnumProperty<Direction> DIRECTION = EnumProperty.of("direction", Direction.class);

    private static final Map<Direction, VoxelShape> DIRECTION_TO_SHAPE = new HashMap<>();

    public PolypiteQuartzBlock(Settings settings) {
        super(settings.luminance((state) -> 4));
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction direction = state.get(DIRECTION);
        BlockPos blockPos = pos.offset(direction.getOpposite());
        return world.getBlockState(blockPos).isSideSolidFullSquare(world, blockPos, direction);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(DIRECTION, Properties.WATERLOGGED);
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        if (state.get(Properties.WATERLOGGED)) {
            world.getFluidTickScheduler().schedule(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return direction == state.get(DIRECTION).getOpposite() && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext context) {
        WorldAccess worldAccess = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        return this.getDefaultState().with(Properties.WATERLOGGED, worldAccess.getFluidState(blockPos).getFluid() == Fluids.WATER).with(DIRECTION, context.getSide());
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return DIRECTION_TO_SHAPE.get(state.get(DIRECTION));
    }

    public BlockState stateOf(Direction dir) {
        return this.getDefaultState().with(DIRECTION, dir);
    }

    public FluidState getFluidState(BlockState state) {
        return state.get(Properties.WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    public PistonBehavior getPistonBehavior(BlockState state) {
        return PistonBehavior.DESTROY;
    }

    static {
        DIRECTION_TO_SHAPE.put(Direction.UP, Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 4.0D, 14.0D));
        DIRECTION_TO_SHAPE.put(Direction.DOWN, Block.createCuboidShape(2.0D, 12.0D, 2.0D, 14.0D, 16.0D, 14.0D));
        DIRECTION_TO_SHAPE.put(Direction.NORTH, Block.createCuboidShape(3.0D, 5.0D, 6.0D, 13.0D, 13.0D, 16.0D));
        DIRECTION_TO_SHAPE.put(Direction.SOUTH, Block.createCuboidShape(3.0D, 5.0D, 0.0D, 13.0D, 13.0D, 10.0D));
        DIRECTION_TO_SHAPE.put(Direction.WEST, Block.createCuboidShape(6.0D, 5.0D, 3.0D, 16.0D, 13.0D, 13.0D));
        DIRECTION_TO_SHAPE.put(Direction.EAST, Block.createCuboidShape(0.0D, 5.0D, 3.0D, 10.0D, 13.0D, 13.0D));
    }
}
