package com.terraformersmc.cinderscapes.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Function;

/**
 * A function that accepts a block state and returns a voxel shape
 * Used for inline definitions of the block voxel shapes by passing the block state through to return a voxel shape
 *
 * @see Block#getShape(BlockState, BlockGetter, BlockPos, CollisionContext)
 */
public interface StateShapeSupplier extends Function<BlockState, VoxelShape> {  }
