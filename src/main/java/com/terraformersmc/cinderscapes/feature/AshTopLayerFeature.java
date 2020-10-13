package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class AshTopLayerFeature extends Feature<DefaultFeatureConfig> {
    public AshTopLayerFeature() {
        super(DefaultFeatureConfig.CODEC);
    }

    private static Set<Biome> VALID_BIOMES = null;
    private static Identifier ASH_LAYER_ID = new Identifier("cinderscapes:ash_top_layer");

    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator chunkGenerator, Random random, BlockPos pos, DefaultFeatureConfig featureConfig) {
        if (VALID_BIOMES == null) {
            VALID_BIOMES = new HashSet<>();
            world.getRegistryManager().get(Registry.BIOME_KEY).stream()
                    .filter(biome -> biome.getGenerationSettings().getFeatures().stream()
                            .flatMap(List::stream)
                            .anyMatch(feature -> ASH_LAYER_ID.equals(world.getRegistryManager()
                                    .get(Registry.CONFIGURED_FEATURE_WORLDGEN).getId(feature.get()))))
                    .forEach(biome -> VALID_BIOMES.add(biome));
        }

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = 0; y < 128; y++) {
                    BlockPos testPosition = pos.add(x, y, z);
                    BlockState testState = world.getBlockState(testPosition);

                    if (!testState.isOf(Blocks.MAGMA_BLOCK) && testState.isSideSolidFullSquare(world, testPosition, Direction.UP) && world.isAir(testPosition.up()) && VALID_BIOMES.contains(world.getBiome(testPosition))) {
                        world.setBlockState(testPosition.up(), CinderscapesBlocks.ASH.getDefaultState(), 2);
                    }
                }
            }
        }
        return true;
    }
}
