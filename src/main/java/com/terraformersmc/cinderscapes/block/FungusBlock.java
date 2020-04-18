package com.terraformersmc.cinderscapes.block;

import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.HugeFungusFeatureConfig;

import java.util.function.Supplier;

// Empty shell to bypass protected constructor
public class FungusBlock extends net.minecraft.block.FungusBlock {
    public FungusBlock(Settings settings, Supplier<ConfiguredFeature<HugeFungusFeatureConfig, ?>> supplier) {
        super(settings, supplier);
    }
}
