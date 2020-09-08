package com.terraformersmc.cinderscapes.surfacebuilder;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import java.util.Random;

public class AshyShoalsSurfaceBuilder extends SurfaceBuilder<TernarySurfaceConfig> {
    public AshyShoalsSurfaceBuilder() {
        super(TernarySurfaceConfig.CODEC);
    }

    @Override
    public void generate(Random random, Chunk chunk, Biome biome, int x, int z, int height, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, TernarySurfaceConfig surfaceBlocks) {
        for (int y = 0; y < 256; y++) {
            BlockPos pos = new BlockPos(x & 15, y, z & 15);
            BlockState state = chunk.getBlockState(pos);
            if (state.getBlock() == defaultBlock.getBlock()) {
                chunk.setBlockState(pos, Blocks.NETHERRACK.getDefaultState(), false);
            } else if (state.getBlock() == defaultFluid.getBlock()) {
                if (chunk.getBlockState(pos.up()).isAir() || (random.nextBoolean() && chunk.getBlockState(pos.up(2)).isAir())) {
                    chunk.setBlockState(pos, Blocks.MAGMA_BLOCK.getDefaultState(), false);
                } else {
                    chunk.setBlockState(pos, Blocks.NETHERRACK.getDefaultState(), false);
                }
            }
        }
    }
}
