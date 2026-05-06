package com.terraformersmc.cinderscapes.surfacebuilders;

import com.terraformersmc.biolith.api.surface.BiolithSurfaceBuilder;
import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.BlockColumn;

public class AshyShoalsSurfaceBuilder extends BiolithSurfaceBuilder {
	private final BlockState topMaterial;
	private final BlockState midMaterial;
	private final BlockState lowMaterial;

    public AshyShoalsSurfaceBuilder(BlockState topMaterial, BlockState midMaterial, BlockState lowMaterial) {
        this.topMaterial = topMaterial;
        this.midMaterial = midMaterial;
        this.lowMaterial = lowMaterial;
    }

    @Override
    public void generate(BiomeManager biomeAccess, BlockColumn column, RandomSource rand, ChunkAccess chunk, Biome biome, int x, int z, int vHeight, int seaLevel) {
        if (!biomeAccess.getBiome(new BlockPos(x, seaLevel, z)).is(CinderscapesBiomes.ASHY_SHOALS)) {
            // We care most about sea level.
            return;
        }

        for (int y = chunk.getMinY(); y < seaLevel + 8; ++y) {
            BlockState state = column.getBlock(y);
            if (state.isAir() && column.getBlock(y - 1).equals(midMaterial)) {
                column.setBlock(y, topMaterial);
            } else if (state.is(Blocks.LAVA) && state.getFluidState().isSource()) {
                if (column.getBlock(y + 1).isAir() || rand.nextBoolean() && column.getBlock(y + 2).isAir()) {
                    column.setBlock(y, midMaterial);
                } else {
                    column.setBlock(y, lowMaterial);
                }
            }
        }
    }
}
