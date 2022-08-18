package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.HashSet;
import java.util.Set;

public class AshTopLayerFeature extends Feature<DefaultFeatureConfig> {
    public AshTopLayerFeature() {
        super(DefaultFeatureConfig.CODEC);
    }

    private static Set<Biome> VALID_BIOMES = null;

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        BlockPos pos = context.getOrigin();
        StructureWorldAccess world = context.getWorld();
        if (VALID_BIOMES == null) {
            VALID_BIOMES = new HashSet<>();
            VALID_BIOMES.add(world.getRegistryManager().get(Registry.BIOME_KEY).get(CinderscapesBiomes.ASHY_SHOALS));
            // TODO: fix this or figure out better system
            /*world.getRegistryManager().get(Registry.BIOME_KEY).stream()
                    .filter(biome -> biome.getGenerationSettings().isFeatureAllowed(CinderscapesPlacedFeatures.ASH_TOP_LAYER.value()))
                    .forEach(biome -> VALID_BIOMES.add(biome));*/
        }

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = 0; y < 128; y++) {
                    BlockPos testPosition = pos.add(x, y, z);
                    BlockState testState = world.getBlockState(testPosition);

                    if (!testState.isOf(Blocks.MAGMA_BLOCK) && testState.isSideSolidFullSquare(world, testPosition, Direction.UP) && world.isAir(testPosition.up()) && VALID_BIOMES.contains(world.getBiome(testPosition).value())) {
                        world.setBlockState(testPosition.up(), CinderscapesBlocks.ASH.getDefaultState(), 2);
                    }
                }
            }
        }

        return true;
    }
}
