package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.feature.*;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class CinderscapesFeatures {
    public static Feature<DefaultFeatureConfig> BLACKSTONE_SHALE;
    public static Feature<DefaultFeatureConfig> BLACKSTONE_LAVA_SHALE;
    public static Feature<DefaultFeatureConfig> BLACKSTONE_WEEPING_VINES;
    public static Feature<DefaultFeatureConfig> QUARTZ_PILLAR;
    public static Feature<DefaultFeatureConfig> QUARTZ_PILLAR_FLOOR;
    public static Feature<DefaultFeatureConfig> SULFUROUS_PILE;

    public static void init() {
        BLACKSTONE_SHALE = Registry.register(Registry.FEATURE, Cinderscapes.id("blackstone_shale"), new BlackstoneShaleFeature(DefaultFeatureConfig::deserialize));
        BLACKSTONE_LAVA_SHALE = Registry.register(Registry.FEATURE, Cinderscapes.id("blackstone_lava_shale"), new BlackstoneLavaShaleFeature(DefaultFeatureConfig::deserialize));
        BLACKSTONE_WEEPING_VINES = Registry.register(Registry.FEATURE, Cinderscapes.id("blackstone_weeping_vines"), new BlackstoneWeepingVinesFeature(DefaultFeatureConfig::deserialize));
        QUARTZ_PILLAR = Registry.register(Registry.FEATURE, Cinderscapes.id("quartz_pillar"), new QuartzPillarFeature(DefaultFeatureConfig::deserialize));
        QUARTZ_PILLAR_FLOOR = Registry.register(Registry.FEATURE, Cinderscapes.id("quartz_pillar_floor"), new FloorQuartzPillarFeature(DefaultFeatureConfig::deserialize));
        SULFUROUS_PILE = Registry.register(Registry.FEATURE, Cinderscapes.id("sulfurous_pile"), new SulfurousPileFeature());
    }
}
