package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ReplaceBlobsFeatureConfig;

public class CinderscapesFeatures {
    public static final ConfiguredFeature<?, ?> SOUL_SAND_BLOBS = Cinderscapes.REGISTRATION_HELPER
            .register(Feature.NETHERRACK_REPLACE_BLOBS
                .configure(new ReplaceBlobsFeatureConfig(Blocks.NETHERRACK.getDefaultState(), Blocks.SOUL_SAND.getDefaultState(), UniformIntProvider.create(3, 7)))
                .range(ConfiguredFeatures.Decorators.BOTTOM_TO_TOP)
                .spreadHorizontally(), "soul_sand_blobs");

    public static final ConfiguredFeature<?, ?> SOUL_SOIL_BLOBS = Cinderscapes.REGISTRATION_HELPER
            .register(Feature.NETHERRACK_REPLACE_BLOBS
                    .configure(new ReplaceBlobsFeatureConfig(Blocks.NETHERRACK.getDefaultState(), Blocks.SOUL_SOIL.getDefaultState(), UniformIntProvider.create(3, 7)))
                    .range(ConfiguredFeatures.Decorators.BOTTOM_TO_TOP)
                    .spreadHorizontally(), "soul_soil_blobs");

    public static final ConfiguredFeature<?, ?> BLACKSTONE_BLOBS = Cinderscapes.REGISTRATION_HELPER
            .register(Feature.NETHERRACK_REPLACE_BLOBS
                    .configure(new ReplaceBlobsFeatureConfig(Blocks.NETHERRACK.getDefaultState(), Blocks.BLACKSTONE.getDefaultState(), UniformIntProvider.create(3, 7)))
                    .range(ConfiguredFeatures.Decorators.BOTTOM_TO_TOP)
                    .spreadHorizontally(), "blackstone_blobs");

    public static final ConfiguredFeature<?, ?> BASALT_BLOBS = Cinderscapes.REGISTRATION_HELPER
            .register(Feature.NETHERRACK_REPLACE_BLOBS
                    .configure(new ReplaceBlobsFeatureConfig(Blocks.NETHERRACK.getDefaultState(), Blocks.BASALT.getDefaultState(), UniformIntProvider.create(3, 7)))
                    .range(ConfiguredFeatures.Decorators.BOTTOM_TO_TOP)
                    .spreadHorizontally(), "basalt_blobs");
}
