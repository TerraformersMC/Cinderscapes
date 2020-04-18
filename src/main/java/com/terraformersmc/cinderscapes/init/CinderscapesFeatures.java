package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.feature.FloorQuartzPillarFeature;
import com.terraformersmc.cinderscapes.feature.QuartzPillarFeature;
import com.terraformersmc.cinderscapes.feature.ShroomlightBushFeature;
import com.terraformersmc.cinderscapes.feature.UmbralVineFeature;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placer.DoublePlantPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

public class CinderscapesFeatures {
    public static Feature<DefaultFeatureConfig> QUARTZ_PILLAR;
    public static Feature<DefaultFeatureConfig> QUARTZ_PILLAR_FLOOR;

    public static HugeFungusFeatureConfig UMBRAL_FUNGUS_CONFIG;
    public static HugeFungusFeatureConfig UMBRAL_FUNGUS_NOT_PLANTED_CONFIG;
    public static Feature<DefaultFeatureConfig> SHROOMLIGHT_BUSH;
    public static Feature<DefaultFeatureConfig> UMBRAL_VINE;

    public static BlockPileFeatureConfig LUMINOUS_GROVE_VEGETATION_CONFIG;

    public static RandomPatchFeatureConfig TALL_PHOTOFERN_CONFIG;
    public static RandomPatchFeatureConfig LUMINOUS_POD_CONFIG;

    public static void init() {
        QUARTZ_PILLAR = Registry.register(Registry.FEATURE, new Identifier("cinderscapes", "quartz_pillar"), new QuartzPillarFeature(DefaultFeatureConfig::deserialize));
        QUARTZ_PILLAR_FLOOR = Registry.register(Registry.FEATURE, new Identifier("cinderscapes", "quartz_pillar_floor"), new FloorQuartzPillarFeature(DefaultFeatureConfig::deserialize));

        UMBRAL_FUNGUS_CONFIG = new HugeFungusFeatureConfig(CinderscapesBlocks.UMBRAL_NYLIUM.getDefaultState(), CinderscapesBlocks.UMBRAL_STEM.getDefaultState(), CinderscapesBlocks.UMBRAL_WART_BLOCK.getDefaultState(), Blocks.SHROOMLIGHT.getDefaultState(), true);
        UMBRAL_FUNGUS_NOT_PLANTED_CONFIG = new HugeFungusFeatureConfig(UMBRAL_FUNGUS_CONFIG.validBaseBlock, UMBRAL_FUNGUS_CONFIG.stemState, UMBRAL_FUNGUS_CONFIG.hatState, UMBRAL_FUNGUS_CONFIG.decorationState, false);

        SHROOMLIGHT_BUSH = Registry.register(Registry.FEATURE, new Identifier("cinderscapes", "shroomlight_bush"), new ShroomlightBushFeature(DefaultFeatureConfig::deserialize));
        UMBRAL_VINE = Registry.register(Registry.FEATURE, new Identifier("cinderscapes", "umbral_vine"), new UmbralVineFeature(DefaultFeatureConfig::deserialize));

        LUMINOUS_GROVE_VEGETATION_CONFIG = new BlockPileFeatureConfig((new WeightedBlockStateProvider())
                .addState(Blocks.WARPED_ROOTS.getDefaultState(), 10)
                .addState(Blocks.NETHER_SPROUTS.getDefaultState(), 10)
                .addState(Blocks.WARPED_FUNGUS.getDefaultState(), 10)
                .addState(CinderscapesBlocks.PHOTOFERN.getDefaultState(), 10)
                .addState(CinderscapesBlocks.TWILIGHT_FESCUES.getDefaultState(), 10)
                .addState(CinderscapesBlocks.TWILIGHT_TENDRILS.getDefaultState(), 10)
                .addState(CinderscapesBlocks.UMBRAL_FUNGUS.getDefaultState(), 10));

        TALL_PHOTOFERN_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(CinderscapesBlocks.TALL_PHOTOFERN.getDefaultState()), new DoublePlantPlacer())).tries(64).cannotProject().build();
        LUMINOUS_POD_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(CinderscapesBlocks.LUMINOUS_POD.getDefaultState()), new DoublePlantPlacer())).tries(64).cannotProject().build();
    }
}
