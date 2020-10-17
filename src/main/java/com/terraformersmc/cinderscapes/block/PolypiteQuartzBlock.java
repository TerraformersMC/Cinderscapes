package com.terraformersmc.cinderscapes.block;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class PolypiteQuartzBlock extends Block {

    public static final EnumProperty<Direction> DIRECTION = EnumProperty.of("direction", Direction.class);

    private static final Map<Direction, VoxelShape> DIRECTION_TO_SHAPE = new HashMap<>();

    public PolypiteQuartzBlock(Settings settings) {
        super(settings.luminance((state) -> 4));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(DIRECTION);
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        Direction placementSide = state.get(DIRECTION);
        if (!Block.isFaceFullSquare(world.getBlockState(pos.offset(placementSide)).getCollisionShape(world, pos.offset(placementSide)), placementSide.getOpposite())) {
            return Blocks.AIR.getDefaultState();
        }
        return state;
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext context) {
        Direction placeSide = context.getSide();
        BlockPos placeOnPos = context.getBlockPos().offset(placeSide.getOpposite());
        BlockState placeOnState = context.getWorld().getBlockState(placeOnPos);
        return Block.isFaceFullSquare(placeOnState.getCollisionShape(context.getWorld(), placeOnPos), placeSide) ? this.getDefaultState().with(DIRECTION, placeSide.getOpposite()) : Blocks.AIR.getDefaultState();
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return DIRECTION_TO_SHAPE.get(state.get(DIRECTION));
    }

    public BlockState stateOf(Direction dir) {
        return this.getDefaultState().with(DIRECTION, dir);
    }

    static {
        DIRECTION_TO_SHAPE.put(Direction.DOWN, Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 4.0D, 14.0D));
        DIRECTION_TO_SHAPE.put(Direction.UP, Block.createCuboidShape(2.0D, 12.0D, 2.0D, 14.0D, 16.0D, 14.0D));
        DIRECTION_TO_SHAPE.put(Direction.SOUTH, Block.createCuboidShape(3.0D, 5.0D, 6.0D, 13.0D, 13.0D, 16.0D));
        DIRECTION_TO_SHAPE.put(Direction.NORTH, Block.createCuboidShape(3.0D, 5.0D, 0.0D, 13.0D, 13.0D, 10.0D));
        DIRECTION_TO_SHAPE.put(Direction.EAST, Block.createCuboidShape(6.0D, 5.0D, 3.0D, 16.0D, 13.0D, 13.0D));
        DIRECTION_TO_SHAPE.put(Direction.WEST, Block.createCuboidShape(0.0D, 5.0D, 3.0D, 10.0D, 13.0D, 13.0D));
    }
}
