package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.feature.QuartzPillarFeature;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class CinderscapesFeatures {
    public static Feature<DefaultFeatureConfig> QUARTZ_PILLAR;

    public static void init() {
        QUARTZ_PILLAR = Registry.register(Registry.FEATURE, new Identifier("cinderscapes", "quartz_pillar"), new QuartzPillarFeature(DefaultFeatureConfig::deserialize));
    }
}
