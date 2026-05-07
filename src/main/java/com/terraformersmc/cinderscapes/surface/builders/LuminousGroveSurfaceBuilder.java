package com.terraformersmc.cinderscapes.surface.builders;

import com.terraformersmc.biolith.api.surface.BiolithSurfaceBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.BlockColumn;
import net.minecraft.world.level.chunk.ChunkAccess;

public class LuminousGroveSurfaceBuilder extends BiolithSurfaceBuilder {
	private final BlockState topMaterial;
	private final BlockState midMaterial;
	private final BlockState lowMaterial;

    public LuminousGroveSurfaceBuilder(BlockState topMaterial, BlockState midMaterial, BlockState lowMaterial) {
        this.topMaterial = topMaterial;
        this.midMaterial = midMaterial;
        this.lowMaterial = lowMaterial;
    }

    @Override
    public void generate(BiomeManager biomeAccess, BlockColumn column, RandomSource rand, ChunkAccess chunk, Biome biome, int x, int z, int vHeight, int seaLevel) {
        BlockPos pos = new BlockPos(x, -128, z);
        boolean inAir = false;

        // Set in-biome netherrack
        // TODO: It would be nicer to make this start below the ceiling bedrock.
        for (int y = chunk.getMaxY(); y >= seaLevel - 1; --y) {
            BlockState state = column.getBlock(y);
            if (state.isAir()) {
                inAir = true;
            } else {
                if (inAir && state.is(lowMaterial.getBlock()) && super.filterBiome(biomeAccess.getBiome(pos.atY(y)))) {
                    column.setBlock(y, rand.nextFloat() < 0.99f ? topMaterial : midMaterial);
                }
                inAir = false;
            }
        }
    }

    @Override
    public boolean filterBiome(Holder<Biome> biome) {
        return biome.is(BiomeTags.IS_NETHER);
    }
}
