package com.terraformersmc.cinderscapes.surfacebuilder;

import java.util.Random;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class IvoryShallowsSurfaceBuilder extends SurfaceBuilder<TernarySurfaceConfig> {

	public IvoryShallowsSurfaceBuilder() {
		super(TernarySurfaceConfig.CODEC);

	}

	@Override
	public void generate(Random random, Chunk chunk, Biome biome, int x, int z, int height, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed,
			TernarySurfaceConfig surfaceBlocks) {
		for (int y = 0; y < 256; y++) {
			BlockPos pos = new BlockPos(x & 15, y, z & 15);
			BlockState state = chunk.getBlockState(pos);
			if (state.getBlock() == defaultBlock.getBlock()) {
				chunk.setBlockState(pos, CinderscapesBlocks.IVORY_BLOCK.getDefaultState(), false);
			}
		}

	}

}
