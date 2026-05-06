package com.terraformersmc.cinderscapes.block;

import com.terraformersmc.cinderscapes.config.CinderscapesConfig;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class PolypiteQuartzBlock extends Block {
    public static final EnumProperty<Direction> DIRECTION = EnumProperty.create("direction", Direction.class);

    private static final Map<Direction, VoxelShape> DIRECTION_TO_SHAPE = new HashMap<>();

    public PolypiteQuartzBlock(Properties settings) {
        super(settings.lightLevel((state) -> CinderscapesConfig.INSTANCE.polypiteLuminance));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DIRECTION);
    }

    @Override
    public BlockState updateShape(BlockState state, LevelReader world, ScheduledTickAccess tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        Direction placementSide = state.getValue(DIRECTION);
        if (!Block.isFaceFull(world.getBlockState(pos.relative(placementSide)).getCollisionShape(world, pos.relative(placementSide)), placementSide.getOpposite())) {
            return Blocks.AIR.defaultBlockState();
        }
        return state;
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction placeSide = context.getClickedFace();
        BlockPos placeOnPos = context.getClickedPos().relative(placeSide.getOpposite());
        BlockState placeOnState = context.getLevel().getBlockState(placeOnPos);
        return Block.isFaceFull(placeOnState.getCollisionShape(context.getLevel(), placeOnPos), placeSide) ? this.defaultBlockState().setValue(DIRECTION, placeSide.getOpposite()) : Blocks.AIR.defaultBlockState();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return DIRECTION_TO_SHAPE.get(state.getValue(DIRECTION));
    }

    public BlockState stateOf(Direction dir) {
        return this.defaultBlockState().setValue(DIRECTION, dir);
    }

    static {
        DIRECTION_TO_SHAPE.put(Direction.DOWN, Block.box(2.0D, 0.0D, 2.0D, 14.0D, 4.0D, 14.0D));
        DIRECTION_TO_SHAPE.put(Direction.UP, Block.box(2.0D, 12.0D, 2.0D, 14.0D, 16.0D, 14.0D));
        DIRECTION_TO_SHAPE.put(Direction.SOUTH, Block.box(3.0D, 5.0D, 6.0D, 13.0D, 13.0D, 16.0D));
        DIRECTION_TO_SHAPE.put(Direction.NORTH, Block.box(3.0D, 5.0D, 0.0D, 13.0D, 13.0D, 10.0D));
        DIRECTION_TO_SHAPE.put(Direction.EAST, Block.box(6.0D, 5.0D, 3.0D, 16.0D, 13.0D, 13.0D));
        DIRECTION_TO_SHAPE.put(Direction.WEST, Block.box(0.0D, 5.0D, 3.0D, 10.0D, 13.0D, 13.0D));
    }
}
