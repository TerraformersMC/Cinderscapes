package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.feature.BlackstoneShaleFeature;
import com.terraformersmc.cinderscapes.feature.BlackstoneWeepingVinesFeature;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class CinderscapesFeatures {
    public static Feature<DefaultFeatureConfig> BLACKSTONE_SHALE;
    public static Feature<DefaultFeatureConfig> BLACKSTONE_WEEPING_VINES;

    public static void init() {
        BLACKSTONE_SHALE = Registry.register(Registry.FEATURE, Cinderscapes.id("blackstone_shale"), new BlackstoneShaleFeature(DefaultFeatureConfig::deserialize));
        BLACKSTONE_WEEPING_VINES = Registry.register(Registry.FEATURE, Cinderscapes.id("blackstone_weeping_vines"), new BlackstoneWeepingVinesFeature(DefaultFeatureConfig::deserialize));
    }
}
