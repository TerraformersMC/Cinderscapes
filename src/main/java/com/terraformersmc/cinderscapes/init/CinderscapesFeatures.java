package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.block.BrambleBerryBushBlock;
import com.terraformersmc.cinderscapes.feature.AshPileFeature;
import com.terraformersmc.cinderscapes.feature.AshTopLayerFeature;
import com.terraformersmc.cinderscapes.feature.BlackstoneLavaShaleFeature;
import com.terraformersmc.cinderscapes.feature.BlackstoneShaleFeature;
import com.terraformersmc.cinderscapes.feature.BlackstoneWeepingVinesFeature;
import com.terraformersmc.cinderscapes.feature.CanopiedHugeFungusFeature;
import com.terraformersmc.cinderscapes.feature.CeilingShardFeature;
import com.terraformersmc.cinderscapes.feature.DeadTreeFeature;
import com.terraformersmc.cinderscapes.feature.FloorShardFeature;
import com.terraformersmc.cinderscapes.feature.PolypiteQuartzFeature;
import com.terraformersmc.cinderscapes.feature.ShaleFeature;
import com.terraformersmc.cinderscapes.feature.ShroomlightBushFeature;
import com.terraformersmc.cinderscapes.feature.UmbralVineFeature;
import com.terraformersmc.cinderscapes.feature.VegetationFeature;
import com.terraformersmc.cinderscapes.feature.config.CanopiedHugeFungusFeatureConfig;
import com.terraformersmc.cinderscapes.feature.config.PolypiteQuartzFeatureConfig;
import com.terraformersmc.cinderscapes.feature.config.SimpleStateFeatureConfig;
import com.terraformersmc.cinderscapes.feature.config.VegetationFeatureConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.feature.ReplaceBlobsFeatureConfig;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

import java.util.Arrays;
import java.util.List;

// TODO: Check
public class CinderscapesFeatures {

    public static Feature<DefaultFeatureConfig> ASH_TOP_LAYER;
    public static Feature<SimpleStateFeatureConfig> SHALE_FEATURE;

    public static Feature<DefaultFeatureConfig> BLACKSTONE_SHALE;
    public static Feature<DefaultFeatureConfig> BLACKSTONE_LAVA_SHALE;
    public static Feature<DefaultFeatureConfig> BLACKSTONE_WEEPING_VINES;
    public static Feature<SimpleStateFeatureConfig> CEILING_SHARD;
    public static Feature<SimpleStateFeatureConfig> FLOOR_SHARD;
    public static Feature<DefaultFeatureConfig> ASH_PILE;

    public static Feature<CanopiedHugeFungusFeatureConfig> CANOPIED_HUGE_FUNGUS;

    public static CanopiedHugeFungusFeatureConfig UMBRAL_FUNGUS_CONFIG;
    public static CanopiedHugeFungusFeatureConfig UMBRAL_FUNGUS_NOT_PLANTED_CONFIG;
    public static Feature<DefaultFeatureConfig> SHROOMLIGHT_BUSH;
    public static Feature<DefaultFeatureConfig> UMBRAL_VINE;

    public static Feature<DefaultFeatureConfig> DEAD_TREE;

    public static Feature<PolypiteQuartzFeatureConfig> POLYPITE_QUARTZ;

    public static Feature<VegetationFeatureConfig> VEGETATION;
    public static VegetationFeatureConfig LUMINOUS_GROVE_VEGETATION_CONFIG;
    public static VegetationFeatureConfig ASHY_SHOALS_VEGETATION_CONFIG;
    public static VegetationFeatureConfig QUARTZ_CANYON_VEGETATION_CONFIG;

    public static RandomPatchFeatureConfig TALL_PHOTOFERN_CONFIG;
    public static RandomPatchFeatureConfig LUMINOUS_POD_CONFIG;

    public static RandomPatchFeatureConfig BRAMBLE_BERRY_BUSH_CONFIG;

    public static ReplaceBlobsFeatureConfig SOUL_SAND_REPLACE_CONFIG;
    public static ReplaceBlobsFeatureConfig SOUL_SOIL_REPLACE_CONFIG;
    public static ReplaceBlobsFeatureConfig GRAVEL_REPLACE_CONFIG;
    public static ReplaceBlobsFeatureConfig CRIMSON_NYLIUM_REPLACE_CONFIG;
    public static ReplaceBlobsFeatureConfig BLACKSTONE_REPLACE_CONFIG;

    public static void init() {

        ASH_TOP_LAYER = Registry.register(Registry.FEATURE, Cinderscapes.id("ash_top_layer"), new AshTopLayerFeature());

        UMBRAL_FUNGUS_CONFIG = new CanopiedHugeFungusFeatureConfig(CinderscapesBlocks.UMBRAL_NYLIUM.getDefaultState(), CinderscapesBlocks.UMBRAL_STEM.getDefaultState(), CinderscapesBlocks.UMBRAL_WART_BLOCK.getDefaultState(), CinderscapesBlocks.UMBRAL_FLESH_BLOCK.getDefaultState(), Blocks.SHROOMLIGHT.getDefaultState(), true);
        UMBRAL_FUNGUS_NOT_PLANTED_CONFIG = new CanopiedHugeFungusFeatureConfig(UMBRAL_FUNGUS_CONFIG.soilBlock, UMBRAL_FUNGUS_CONFIG.stemBlock, UMBRAL_FUNGUS_CONFIG.canopyBlock, UMBRAL_FUNGUS_CONFIG.fleshBlock, UMBRAL_FUNGUS_CONFIG.decorationBlock, false);

        CANOPIED_HUGE_FUNGUS = Registry.register(Registry.FEATURE, Cinderscapes.id("canopied_huge_fungus"), new CanopiedHugeFungusFeature());

        SHROOMLIGHT_BUSH = Registry.register(Registry.FEATURE, Cinderscapes.id("shroomlight_bush"), new ShroomlightBushFeature());
        UMBRAL_VINE = Registry.register(Registry.FEATURE, Cinderscapes.id("umbral_vine"), new UmbralVineFeature());

        VEGETATION = Registry.register(Registry.FEATURE, Cinderscapes.id("vegetation"), new VegetationFeature());

        LUMINOUS_GROVE_VEGETATION_CONFIG = new VegetationFeatureConfig(
                new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                        .add(Blocks.WARPED_ROOTS.getDefaultState(), 1)
                        .add(Blocks.NETHER_SPROUTS.getDefaultState(), 1)
                        .add(Blocks.WARPED_FUNGUS.getDefaultState(), 1)
                        .add(CinderscapesBlocks.PHOTOFERN.getDefaultState(), 2)
                        .add(CinderscapesBlocks.TWILIGHT_FESCUES.getDefaultState(), 5)
                        .add(CinderscapesBlocks.TWILIGHT_TENDRILS.getDefaultState(), 5)
                        .add(CinderscapesBlocks.UMBRAL_FUNGUS.getDefaultState(), 2).build()),
                Arrays.asList(
                        CinderscapesBlocks.UMBRAL_NYLIUM.getDefaultState()
                )
        );

        QUARTZ_CANYON_VEGETATION_CONFIG = new VegetationFeatureConfig(
                new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                        .add(CinderscapesBlocks.CRYSTINIUM.getDefaultState(), 1).build()),
                Arrays.asList(
                        Blocks.NETHERRACK.getDefaultState()
                )
        );

        ASHY_SHOALS_VEGETATION_CONFIG = new VegetationFeatureConfig(
                new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                        .add(CinderscapesBlocks.SCORCHED_SHRUB.getDefaultState(), 2)
                        .add(CinderscapesBlocks.SCORCHED_SPROUTS.getDefaultState(), 5)
                        .add(CinderscapesBlocks.SCORCHED_TENDRILS.getDefaultState(), 5)
                        .add(CinderscapesBlocks.PYRACINTH.getDefaultState(), 1).build()),
                Arrays.asList(
                        Blocks.NETHERRACK.getDefaultState(),
                        Blocks.GRAVEL.getDefaultState(),
                        Blocks.BLACKSTONE.getDefaultState(),
                        Blocks.SOUL_SOIL.getDefaultState(),
                        Blocks.BASALT.getDefaultState()
                ),
                Arrays.asList(
                        CinderscapesBlocks.ASH.getDefaultState()
                )
        );

        TALL_PHOTOFERN_CONFIG = ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(CinderscapesBlocks.TALL_PHOTOFERN.getDefaultState())), List.of(), 64);
        LUMINOUS_POD_CONFIG = ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(CinderscapesBlocks.LUMINOUS_POD.getDefaultState())), List.of(), 64);
        BRAMBLE_BERRY_BUSH_CONFIG = ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(((BrambleBerryBushBlock)CinderscapesBlocks.BRAMBLE_BERRY_BUSH).getGenerationState())), List.of(), 64);

        BLACKSTONE_SHALE = Registry.register(Registry.FEATURE, Cinderscapes.id("blackstone_shale"), new BlackstoneShaleFeature());
        BLACKSTONE_LAVA_SHALE = Registry.register(Registry.FEATURE, Cinderscapes.id("blackstone_lava_shale"), new BlackstoneLavaShaleFeature());

        SHALE_FEATURE = Registry.register(Registry.FEATURE, Cinderscapes.id("shale"), new ShaleFeature());

        BLACKSTONE_WEEPING_VINES = Registry.register(Registry.FEATURE, Cinderscapes.id("blackstone_weeping_vines"), new BlackstoneWeepingVinesFeature());

        CEILING_SHARD = Registry.register(Registry.FEATURE, Cinderscapes.id("ceiling_shard"), new CeilingShardFeature());
        FLOOR_SHARD = Registry.register(Registry.FEATURE, Cinderscapes.id("floor_shard"), new FloorShardFeature());

        POLYPITE_QUARTZ = Registry.register(Registry.FEATURE, Cinderscapes.id("polypite_quartz"), new PolypiteQuartzFeature());

        ASH_PILE = Registry.register(Registry.FEATURE, Cinderscapes.id("ash_pile"), new AshPileFeature());

        DEAD_TREE = Registry.register(Registry.FEATURE, Cinderscapes.id("dead_tree"), new DeadTreeFeature());

        IntProvider spread = UniformIntProvider.create(3, 4); // 3-7
        SOUL_SAND_REPLACE_CONFIG = new ReplaceBlobsFeatureConfig(Blocks.NETHERRACK.getDefaultState(), Blocks.SOUL_SAND.getDefaultState(), spread);
        SOUL_SOIL_REPLACE_CONFIG = new ReplaceBlobsFeatureConfig(Blocks.NETHERRACK.getDefaultState(), Blocks.SOUL_SOIL.getDefaultState(), spread);
        GRAVEL_REPLACE_CONFIG = new ReplaceBlobsFeatureConfig(Blocks.NETHERRACK.getDefaultState(), Blocks.GRAVEL.getDefaultState(), spread);
        CRIMSON_NYLIUM_REPLACE_CONFIG = new ReplaceBlobsFeatureConfig(Blocks.NETHERRACK.getDefaultState(), Blocks.CRIMSON_NYLIUM.getDefaultState(), spread);
        BLACKSTONE_REPLACE_CONFIG = new ReplaceBlobsFeatureConfig(Blocks.NETHERRACK.getDefaultState(), Blocks.BLACKSTONE.getDefaultState(), spread);
    }
}
