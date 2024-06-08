package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.block.BrambleBerryBushBlock;
import com.terraformersmc.cinderscapes.feature.*;
import com.terraformersmc.cinderscapes.feature.config.*;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.feature.ReplaceBlobsFeatureConfig;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// TODO: Check
public class CinderscapesFeatures {

    public static Feature<DefaultFeatureConfig> ASH_TOP_LAYER;
    public static Feature<ShaleFeatureConfig> SHALE_FEATURE;

    public static Feature<DefaultFeatureConfig> BLACKSTONE_WEEPING_VINES;
    public static Feature<CrystalShardFeatureConfig> CRYSTAL_SHARD_FEATURE;
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
    public static VegetationFeatureConfig QUARTZ_CAVERN_VEGETATION_CONFIG;

    public static RandomPatchFeatureConfig TALL_PHOTOFERN_CONFIG;
    public static RandomPatchFeatureConfig LUMINOUS_POD_CONFIG;

    public static RandomPatchFeatureConfig BRAMBLE_BERRY_BUSH_CONFIG;

    public static ReplaceBlobsFeatureConfig SOUL_SAND_REPLACE_CONFIG;
    public static ReplaceBlobsFeatureConfig SOUL_SOIL_REPLACE_CONFIG;
    public static ReplaceBlobsFeatureConfig GRAVEL_REPLACE_CONFIG;
    public static ReplaceBlobsFeatureConfig CRIMSON_NYLIUM_REPLACE_CONFIG;
    public static ReplaceBlobsFeatureConfig BLACKSTONE_REPLACE_CONFIG;

    public static void init() {

        ASH_TOP_LAYER = Registry.register(Registries.FEATURE, Identifier.of(Cinderscapes.MOD_ID, "ash_top_layer"), new AshTopLayerFeature());

        UMBRAL_FUNGUS_CONFIG = new CanopiedHugeFungusFeatureConfig(CinderscapesBlocks.UMBRAL_NYLIUM.getDefaultState(), CinderscapesBlocks.UMBRAL_HYPHAE.getDefaultState(), CinderscapesBlocks.UMBRAL_STEM.getDefaultState(), CinderscapesBlocks.UMBRAL_WART_BLOCK.getDefaultState(), CinderscapesBlocks.UMBRAL_FLESH_BLOCK.getDefaultState(), Blocks.SHROOMLIGHT.getDefaultState(), true);
        UMBRAL_FUNGUS_NOT_PLANTED_CONFIG = UMBRAL_FUNGUS_CONFIG.withPlanted(false);

        CANOPIED_HUGE_FUNGUS = Registry.register(Registries.FEATURE, Identifier.of(Cinderscapes.MOD_ID, "canopied_huge_fungus"), new CanopiedHugeFungusFeature());

        SHROOMLIGHT_BUSH = Registry.register(Registries.FEATURE, Identifier.of(Cinderscapes.MOD_ID, "shroomlight_bush"), new ShroomlightBushFeature());
        UMBRAL_VINE = Registry.register(Registries.FEATURE, Identifier.of(Cinderscapes.MOD_ID, "umbral_vine"), new UmbralVineFeature());

        VEGETATION = Registry.register(Registries.FEATURE, Identifier.of(Cinderscapes.MOD_ID, "vegetation"), new VegetationFeature());

        LUMINOUS_GROVE_VEGETATION_CONFIG = new VegetationFeatureConfig(
                new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                        .add(Blocks.WARPED_ROOTS.getDefaultState(), 1)
                        .add(Blocks.NETHER_SPROUTS.getDefaultState(), 1)
                        .add(Blocks.WARPED_FUNGUS.getDefaultState(), 1)
                        .add(CinderscapesBlocks.PHOTOFERN.getDefaultState(), 2)
                        .add(CinderscapesBlocks.TWILIGHT_FESCUES.getDefaultState(), 5)
                        .add(CinderscapesBlocks.TWILIGHT_TENDRILS.getDefaultState(), 5)
                        .add(CinderscapesBlocks.UMBRAL_FUNGUS.getDefaultState(), 2).build()),
                Collections.singletonList(
                        CinderscapesBlocks.UMBRAL_NYLIUM.getDefaultState()
                )
        );

        QUARTZ_CAVERN_VEGETATION_CONFIG = new VegetationFeatureConfig(
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
        BRAMBLE_BERRY_BUSH_CONFIG = ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(((BrambleBerryBushBlock) CinderscapesBlocks.BRAMBLE_BERRY_BUSH).getGenerationState())), List.of(), 64);

        SHALE_FEATURE = Registry.register(Registries.FEATURE, Identifier.of(Cinderscapes.MOD_ID, "shale"), new ShaleFeature());

        BLACKSTONE_WEEPING_VINES = Registry.register(Registries.FEATURE, Identifier.of(Cinderscapes.MOD_ID, "blackstone_weeping_vines"), new BlackstoneWeepingVinesFeature());

        CRYSTAL_SHARD_FEATURE = Registry.register(Registries.FEATURE, Identifier.of(Cinderscapes.MOD_ID, "crystal_shard"), new CrystalShardFeature());

        POLYPITE_QUARTZ = Registry.register(Registries.FEATURE, Identifier.of(Cinderscapes.MOD_ID, "polypite_quartz"), new PolypiteQuartzFeature());

        ASH_PILE = Registry.register(Registries.FEATURE, Identifier.of(Cinderscapes.MOD_ID, "ash_pile"), new AshPileFeature());

        DEAD_TREE = Registry.register(Registries.FEATURE, Identifier.of(Cinderscapes.MOD_ID, "dead_tree"), new DeadTreeFeature());

        IntProvider spread = UniformIntProvider.create(3, 7);
        SOUL_SAND_REPLACE_CONFIG = new ReplaceBlobsFeatureConfig(Blocks.NETHERRACK.getDefaultState(), Blocks.SOUL_SAND.getDefaultState(), spread);
        SOUL_SOIL_REPLACE_CONFIG = new ReplaceBlobsFeatureConfig(Blocks.NETHERRACK.getDefaultState(), Blocks.SOUL_SOIL.getDefaultState(), spread);
        GRAVEL_REPLACE_CONFIG = new ReplaceBlobsFeatureConfig(Blocks.NETHERRACK.getDefaultState(), Blocks.GRAVEL.getDefaultState(), spread);
        CRIMSON_NYLIUM_REPLACE_CONFIG = new ReplaceBlobsFeatureConfig(Blocks.NETHERRACK.getDefaultState(), Blocks.CRIMSON_NYLIUM.getDefaultState(), spread);
        BLACKSTONE_REPLACE_CONFIG = new ReplaceBlobsFeatureConfig(Blocks.NETHERRACK.getDefaultState(), Blocks.BLACKSTONE.getDefaultState(), spread);
    }
}
