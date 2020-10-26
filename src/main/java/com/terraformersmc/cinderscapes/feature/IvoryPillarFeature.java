package com.terraformersmc.cinderscapes.feature;

import java.util.Random;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class IvoryPillarFeature extends Feature<DefaultFeatureConfig> {
	public IvoryPillarFeature() {
		super(DefaultFeatureConfig.CODEC);
	}

	@Override
	public boolean generate(StructureWorldAccess world, ChunkGenerator generator, Random random, BlockPos pos,
			DefaultFeatureConfig config) {
		BlockState polished_ivory = CinderscapesBlocks.POLISHED_IVORY_BLOCK.getDefaultState();
		BlockState ivory_pillar = CinderscapesBlocks.IVORY_PILLAR_BLOCK.getDefaultState();
		if (pos.getY() < 128 && !world.getBlockState(pos.down()).isOf(Blocks.LAVA) && world.getBlockState(pos.down()).isOf(CinderscapesBlocks.IVORY_BLOCK) && world.getBlockState(pos).isOf(Blocks.AIR)) {

			world.setBlockState(pos.north(), polished_ivory, 2);
			world.setBlockState(pos.north().east(), polished_ivory, 2);
			world.setBlockState(pos.east(), polished_ivory, 2);
			world.setBlockState(pos.east().south(), polished_ivory, 2);
			world.setBlockState(pos.south(), polished_ivory, 2);
			world.setBlockState(pos.south().west(), polished_ivory, 2);
			world.setBlockState(pos.west(), polished_ivory, 2);
			world.setBlockState(pos.west().north(), polished_ivory, 2);
			world.setBlockState(pos, polished_ivory, 2);
			pos = pos.up();

			while (pos.getY() < 128 && world.getBlockState(pos.up()).isOf(Blocks.AIR) && (world.getBlockState(pos.down()).isOf(CinderscapesBlocks.IVORY_PILLAR_BLOCK) || world.getBlockState(pos.down()).isOf(CinderscapesBlocks.POLISHED_IVORY_BLOCK))) {
				world.setBlockState(pos, ivory_pillar, 2);
				world.setBlockState(pos.north(), ivory_pillar, 2);
				world.setBlockState(pos.east(), ivory_pillar, 2);
				world.setBlockState(pos.south(), ivory_pillar, 2);
				world.setBlockState(pos.west(), ivory_pillar, 2);
				pos = pos.up();
			}

			world.setBlockState(pos.north(), polished_ivory, 2);
			world.setBlockState(pos.north().east(), polished_ivory, 2);
			world.setBlockState(pos.east(), polished_ivory, 2);
			world.setBlockState(pos.east().south(), polished_ivory, 2);
			world.setBlockState(pos.south(), polished_ivory, 2);
			world.setBlockState(pos.south().west(), polished_ivory, 2);
			world.setBlockState(pos.west(), polished_ivory, 2);
			world.setBlockState(pos.west().north(), polished_ivory, 2);
			world.setBlockState(pos, polished_ivory, 2);

			return true;
		}
		return false;
	}

}
