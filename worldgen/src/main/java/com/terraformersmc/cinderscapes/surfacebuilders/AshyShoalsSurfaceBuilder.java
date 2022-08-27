package com.terraformersmc.cinderscapes.surfacebuilders;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeAccess;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.chunk.BlockColumn;
import net.minecraft.world.gen.random.AbstractRandom;

public class AshyShoalsSurfaceBuilder extends CinderscapesSurfaceBuilder {
	private final BlockState topMaterial;
	private final BlockState midMaterial;
	private final BlockState lowMaterial;

    public AshyShoalsSurfaceBuilder(BlockState topMaterial, BlockState midMaterial, BlockState lowMaterial) {
        this.topMaterial = topMaterial;
        this.midMaterial = midMaterial;
        this.lowMaterial = lowMaterial;
    }

    @Override
    public void generate(BiomeAccess biomeAccess, BlockColumn column, AbstractRandom rand, Chunk chunk, Biome biome, int x, int z, int vHeight, int seaLevel) {
        if (!biomeAccess.getBiome(new BlockPos(x, seaLevel, z)).value().equals(biome)) {
            // We care most about sea level.
            return;
        }

        for (int y = 1; y < 40; y++) {
            BlockState state = column.getState(y);
            if (state.isAir() && column.getState(y - 1).equals(midMaterial)) {
                column.setState(y, topMaterial);
            } else if (state.isOf(Blocks.LAVA) && state.getFluidState().isStill()) {
                if (column.getState(y + 1).isAir() || rand.nextBoolean() && column.getState(y + 2).isAir()) {
                    column.setState(y, midMaterial);
                } else {
                    column.setState(y, lowMaterial);
                }
            }
        }
    }
}
