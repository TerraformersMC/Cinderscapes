package com.terraformersmc.cinderscapes.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class IvoryTeethBlock extends Block {
	public static final EnumProperty<IvoryTeethBlock.Type> TYPE = EnumProperty.of("type", IvoryTeethBlock.Type.class);

	public IvoryTeethBlock(Settings settings) {
		super(settings);
		setDefaultState(getDefaultState().with(TYPE, Type.BOTTOM));
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
	}

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState belowState = world.getBlockState(pos.down());
        return (!world.isAir(pos.down()) && Block.isFaceFullSquare(belowState.getCollisionShape(world, pos.down()), Direction.UP)) || belowState.getBlock() == this;
    }

    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        world.setBlockState(pos, evaluateState(state, pos, world));
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        return evaluateState(state, pos, world);
    }

    public BlockState evaluateState(BlockState currentState, BlockPos currentPos, WorldAccess world) {
        BlockState aboveState = world.getBlockState(currentPos.up());
        BlockState belowState = world.getBlockState(currentPos.down());
        BlockState twoAboveState = world.getBlockState(currentPos.up(2));
        if (!canPlaceAt(currentState, world, currentPos)) {
            return Blocks.AIR.getDefaultState();
        }
        if (belowState.getBlock() != this && aboveState.getBlock() == this && twoAboveState.getBlock() == this) {
            return currentState.with(TYPE, Type.BOTTOM);
        }
        if (aboveState.getBlock() != this) {
            return currentState.with(TYPE, Type.TOP);
        } else if (belowState.getBlock() != this) {
            return currentState.with(TYPE, Type.BOTTOM);
        } else {
        	return currentState.with(TYPE, Type.MIDDLE);
        }
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
    	return evaluateState(getDefaultState(), ctx.getBlockPos(), ctx.getWorld());
    }

	public BlockState typeOf(Type type) {
		return getDefaultState().with(TYPE, type);
	}

	public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(TYPE);
	}

	public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
		entity.damage(DamageSource.CACTUS, 1.0F);
	}

	public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
		return false;
	}
	
	public OffsetType getOffsetType() {
		return OffsetType.XZ;
	}

	@Environment(EnvType.CLIENT)
	public long getRenderingSeed(BlockState state, BlockPos pos) {
		return MathHelper.hashCode(pos.getX(), 0, pos.getZ());
	}

	public enum Type implements StringIdentifiable {
		TOP, MIDDLE, BOTTOM;

		@Override
		public String asString() {
			return this.toString().toLowerCase();
		}
	}
}
