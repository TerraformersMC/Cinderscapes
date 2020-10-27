package com.terraformersmc.cinderscapes.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class IvorySpikeBlock extends Block {
	public static final EnumProperty<DoubleBlockHalf> HALF = Properties.DOUBLE_BLOCK_HALF;

	public IvorySpikeBlock(Settings settings) {
		super(settings);
		setDefaultState(getDefaultState().with(HALF, DoubleBlockHalf.UPPER));
	}
	
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return state.get(HALF).equals(DoubleBlockHalf.LOWER) ? Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D) : Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);
	}

	public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
		BlockState belowState = world.getBlockState(pos.down());
		BlockState twoBelowState = world.getBlockState(pos.down(2));
		if (belowState.isSideSolidFullSquare(world, pos.down(), Direction.UP) || (!twoBelowState.isOf(this) && belowState.isOf(this))) {
			if (belowState.isOf(this) && (state.get(HALF).equals(DoubleBlockHalf.LOWER) && belowState.get(HALF).equals(DoubleBlockHalf.LOWER))) {
				return false;
			}
			return true;
		} else {
			return false;
		}
	}

	public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
		world.setBlockState(pos, evaluateState(state, pos, world));
	}

	public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState,
			WorldAccess world, BlockPos pos, BlockPos posFrom) {
		return evaluateState(state, pos, world);
	}

	public BlockState evaluateState(BlockState currentState, BlockPos currentPos, WorldAccess world) {
		BlockState aboveState = world.getBlockState(currentPos.up());
		BlockState belowState = world.getBlockState(currentPos.down());
		if (!canPlaceAt(currentState, world, currentPos)) {
			return Blocks.AIR.getDefaultState();
		}
		if (aboveState.isOf(this)) {
			if (aboveState.get(HALF).equals(DoubleBlockHalf.LOWER)) {
				world.setBlockState(currentPos.up(), getDefaultState().with(HALF, DoubleBlockHalf.UPPER), 2);
			}
			return getDefaultState().with(HALF, DoubleBlockHalf.LOWER);
		} else if (belowState.isOf(this)) {
			if (belowState.get(HALF).equals(DoubleBlockHalf.UPPER)) {
				world.setBlockState(currentPos.down(), getDefaultState().with(HALF, DoubleBlockHalf.LOWER), 2);
			}
			return getDefaultState().with(HALF, DoubleBlockHalf.UPPER);
		} else {
			return getDefaultState().with(HALF, DoubleBlockHalf.UPPER);
		}
	}

	public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
		entity.damage(DamageSource.CACTUS, 1.0F);
	}

	public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
		return false;
	}
	
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(HALF);
	}

	public OffsetType getOffsetType() {
		return OffsetType.XZ;
	}

	@Environment(EnvType.CLIENT)
	public long getRenderingSeed(BlockState state, BlockPos pos) {
		return MathHelper.hashCode(pos.getX(), pos.down(state.get(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), pos.getZ());
	}
}
