package com.terraformersmc.cinderscapes.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

import java.util.function.Function;

/**
 * A function that accepts a block state and returns a voxel shape
 * Used for inline definitions of the block voxel shapes by passing the block state through to return a voxel shape
 *
 * @see Block#getOutlineShape(BlockState, BlockView, BlockPos, ShapeContext)
 */
public interface StateShapeSupplier extends Function<BlockState, VoxelShape> {  }
