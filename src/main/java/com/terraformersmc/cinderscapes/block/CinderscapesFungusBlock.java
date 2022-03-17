package com.terraformersmc.cinderscapes.block;

import net.minecraft.block.FungusBlock;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.HugeFungusFeatureConfig;

import java.util.function.Supplier;

public class CinderscapesFungusBlock extends FungusBlock {
    public CinderscapesFungusBlock(Settings settings, Supplier<RegistryEntry<ConfiguredFeature<HugeFungusFeatureConfig, ?>>> supplier) {
        super(settings, supplier);
    }
}
