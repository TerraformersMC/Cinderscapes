package com.terraformersmc.cinderscapes.surfacebuilders;

import net.minecraft.block.BlockState;
import net.minecraft.tag.BiomeTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeAccess;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.chunk.BlockColumn;
import net.minecraft.world.gen.random.AbstractRandom;

public class LuminousGroveSurfaceBuilder extends CinderscapesSurfaceBuilder {
	private final BlockState topMaterial;
	private final BlockState midMaterial;
	private final BlockState lowMaterial;

    public LuminousGroveSurfaceBuilder(BlockState topMaterial, BlockState midMaterial, BlockState lowMaterial) {
        this.topMaterial = topMaterial;
        this.midMaterial = midMaterial;
        this.lowMaterial = lowMaterial;
    }

    @Override
    public void generate(BiomeAccess biomeAccess, BlockColumn column, AbstractRandom rand, Chunk chunk, Biome biome, int x, int z, int vHeight, int seaLevel) {
        BlockPos pos = new BlockPos(x, -128, z);
        boolean inAir = false;

        // Set in-biome netherrack
        for (int y = chunk.getTopY() - 6; y >= seaLevel - 1; --y) {
            BlockState state = column.getState(y);
            if (state.isAir()) {
                inAir = true;
            } else {
                if (inAir && state.isOf(lowMaterial.getBlock()) && biomeAccess.getBiome(pos.withY(y)).matchesKey(biomeKey)) {
                    column.setState(y, rand.nextFloat() < 0.99f ? topMaterial : midMaterial);
                }
                inAir = false;
            }
        }
    }

    @Override
    public boolean filterBiome(RegistryEntry<Biome> biome) {
        return biome.isIn(BiomeTags.IS_NETHER);
    }
}
