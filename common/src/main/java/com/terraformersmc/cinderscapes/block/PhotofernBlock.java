package com.terraformersmc.cinderscapes.block;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class PhotofernBlock extends CinderscapesNetherPlantBlock implements Fertilizable {

	public PhotofernBlock() {
		super(FabricBlockSettings.copyOf(Blocks.WARPED_ROOTS).mapColor(MapColor.PURPLE), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0));
	}

	@Override
	public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
		return true;
	}

	@Override
	public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
		return true;
	}

	@Override
	public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
		CinderscapesNetherTallPlantBlock tallPhotofern = (CinderscapesNetherTallPlantBlock) CinderscapesBlocks.TALL_PHOTOFERN;
		if (tallPhotofern.getDefaultState().canPlaceAt(world, pos) && world.isAir(pos.up())) {
			TallPlantBlock.placeAt(world, tallPhotofern.getDefaultState(), pos, 2);
		}
	}
}
