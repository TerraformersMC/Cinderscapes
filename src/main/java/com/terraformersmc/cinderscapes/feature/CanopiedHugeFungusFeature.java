package com.terraformersmc.cinderscapes.feature;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class CanopiedHugeFungusFeature extends Feature<CanopiedHugeFungusFeatureConfig> {

    public CanopiedHugeFungusFeature() {
        super(CanopiedHugeFungusFeatureConfig::deserialize);
    }

    @Override
    public boolean generate(IWorld world, StructureAccessor accessor, ChunkGenerator<? extends ChunkGeneratorConfig> generator, Random random, BlockPos pos, CanopiedHugeFungusFeatureConfig config) {
        return false;
    }
}
