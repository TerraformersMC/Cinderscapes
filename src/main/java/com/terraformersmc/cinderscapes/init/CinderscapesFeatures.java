package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.feature.*;
import com.terraformersmc.cinderscapes.feature.config.CanopiedHugeFungusFeatureConfig;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placer.DoublePlantPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

// TODO: Check
public class CinderscapesFeatures {

    public static final BlockPileFeatureConfig RADIANT_ROOTS_CONFIG = new BlockPileFeatureConfig((new WeightedBlockStateProvider()).addState(CinderscapesBlocks.RADIANT_ROOTS.getDefaultState(), 85).addState(Blocks.WARPED_ROOTS.getDefaultState(), 1).addState(CinderscapesBlocks.WITHERED_FUNGUS.getDefaultState(), 13).addState(Blocks.WARPED_FUNGUS.getDefaultState(), 2).addState(Blocks.CRIMSON_FUNGUS.getDefaultState(), 1));
    public static final BlockPileFeatureConfig FLAY_CONFIG = new BlockPileFeatureConfig(new SimpleBlockStateProvider(CinderscapesBlocks.FLAY.getDefaultState()));

    public static Feature<DefaultFeatureConfig> BLACKSTONE_SHALE;
    public static Feature<DefaultFeatureConfig> BLACKSTONE_LAVA_SHALE;
    public static Feature<DefaultFeatureConfig> BLACKSTONE_WEEPING_VINES;
    public static Feature<DefaultFeatureConfig> QUARTZ_PILLAR;
    public static Feature<DefaultFeatureConfig> QUARTZ_PILLAR_FLOOR;
    public static Feature<DefaultFeatureConfig> SULFUROUS_PILE;

    public static Feature<CanopiedHugeFungusFeatureConfig> CANOPIED_HUGE_FUNGUS;

    public static HugeFungusFeatureConfig UMBRAL_FUNGUS_CONFIG;
    public static HugeFungusFeatureConfig UMBRAL_FUNGUS_NOT_PLANTED_CONFIG;
    public static Feature<DefaultFeatureConfig> SHROOMLIGHT_BUSH;
    public static Feature<DefaultFeatureConfig> UMBRAL_VINE;

    public static BlockPileFeatureConfig LUMINOUS_GROVE_VEGETATION_CONFIG;

    public static RandomPatchFeatureConfig TALL_PHOTOFERN_CONFIG;
    public static RandomPatchFeatureConfig LUMINOUS_POD_CONFIG;

    public static void init() {
        UMBRAL_FUNGUS_CONFIG = new HugeFungusFeatureConfig(CinderscapesBlocks.UMBRAL_NYLIUM.getDefaultState(), CinderscapesBlocks.UMBRAL_STEM.getDefaultState(), CinderscapesBlocks.UMBRAL_WART_BLOCK.getDefaultState(), Blocks.SHROOMLIGHT.getDefaultState(), true);
        UMBRAL_FUNGUS_NOT_PLANTED_CONFIG = new HugeFungusFeatureConfig(UMBRAL_FUNGUS_CONFIG.validBaseBlock, UMBRAL_FUNGUS_CONFIG.stemState, UMBRAL_FUNGUS_CONFIG.hatState, UMBRAL_FUNGUS_CONFIG.decorationState, false);

        CANOPIED_HUGE_FUNGUS = Registry.register(Registry.FEATURE, Cinderscapes.id("canopied_huge_fungus"), new CanopiedHugeFungusFeature());

        SHROOMLIGHT_BUSH = Registry.register(Registry.FEATURE, Cinderscapes.id("shroomlight_bush"), new ShroomlightBushFeature());
        UMBRAL_VINE = Registry.register(Registry.FEATURE, Cinderscapes.id("umbral_vine"), new UmbralVineFeature(DefaultFeatureConfig::deserialize));

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

        BLACKSTONE_SHALE = Registry.register(Registry.FEATURE, Cinderscapes.id("blackstone_shale"), new BlackstoneShaleFeature());
        BLACKSTONE_LAVA_SHALE = Registry.register(Registry.FEATURE, Cinderscapes.id("blackstone_lava_shale"), new BlackstoneLavaShaleFeature(DefaultFeatureConfig::deserialize));
        BLACKSTONE_WEEPING_VINES = Registry.register(Registry.FEATURE, Cinderscapes.id("blackstone_weeping_vines"), new BlackstoneWeepingVinesFeature(DefaultFeatureConfig::deserialize));

        QUARTZ_PILLAR = Registry.register(Registry.FEATURE, Cinderscapes.id("quartz_pillar"), new QuartzPillarFeature(DefaultFeatureConfig::deserialize));
        QUARTZ_PILLAR_FLOOR = Registry.register(Registry.FEATURE, Cinderscapes.id("quartz_pillar_floor"), new FloorQuartzPillarFeature(DefaultFeatureConfig::deserialize));
        SULFUROUS_PILE = Registry.register(Registry.FEATURE, Cinderscapes.id("sulfurous_pile"), new SulfurousPileFeature());
    }
}
