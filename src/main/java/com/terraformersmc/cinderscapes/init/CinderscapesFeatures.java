package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.feature.FloorQuartzPillarFeature;
import com.terraformersmc.cinderscapes.feature.QuartzPillarFeature;
import com.terraformersmc.cinderscapes.feature.ShroomlightBushFeature;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeFungusFeatureConfig;

public class CinderscapesFeatures {
    public static Feature<DefaultFeatureConfig> QUARTZ_PILLAR;
    public static Feature<DefaultFeatureConfig> QUARTZ_PILLAR_FLOOR;

    public static HugeFungusFeatureConfig LUMINOUS_FUNGUS_CONFIG;
    public static HugeFungusFeatureConfig LUMINOUS_FUNGUS_NOT_PLANTED_CONFIG;
    public static Feature<DefaultFeatureConfig> SHROOMLIGHT_BUSH;

    public static void init() {
        QUARTZ_PILLAR = Registry.register(Registry.FEATURE, new Identifier("cinderscapes", "quartz_pillar"), new QuartzPillarFeature(DefaultFeatureConfig::deserialize));
        QUARTZ_PILLAR_FLOOR = Registry.register(Registry.FEATURE, new Identifier("cinderscapes", "quartz_pillar_floor"), new FloorQuartzPillarFeature(DefaultFeatureConfig::deserialize));

        LUMINOUS_FUNGUS_CONFIG = new HugeFungusFeatureConfig(CinderscapesBlocks.LUMINOUS_NYLIUM.getDefaultState(), CinderscapesBlocks.LUMINOUS_STEM.getDefaultState(), CinderscapesBlocks.LUMINOUS_WART_BLOCK.getDefaultState(), Blocks.SHROOMLIGHT.getDefaultState(), true);
        LUMINOUS_FUNGUS_NOT_PLANTED_CONFIG = new HugeFungusFeatureConfig(LUMINOUS_FUNGUS_CONFIG.validBaseBlock, LUMINOUS_FUNGUS_CONFIG.stemState, LUMINOUS_FUNGUS_CONFIG.hatState, LUMINOUS_FUNGUS_CONFIG.decorationState, false);

        SHROOMLIGHT_BUSH = Registry.register(Registry.FEATURE, new Identifier("cinderscapes", "shroomlight_bush"), new ShroomlightBushFeature(DefaultFeatureConfig::deserialize));
    }
}
