package com.terraformersmc.cinderscapes.init;

import com.google.common.base.Preconditions;
import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.block.PolypiteQuartzBlock;
import com.terraformersmc.cinderscapes.feature.config.*;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.feature.ReplaceBlobsFeatureConfig;

import java.util.Arrays;
import java.util.List;

public final class CinderscapesConfiguredFeatures {

    public static void init() {
    }

    public static final RegistryEntry<ConfiguredFeature<DefaultFeatureConfig, ?>> BLACKSTONE_SHALE_WEEPING_VINES = register("blackstone_shales_weeping_vines", Feature.WEEPING_VINES, FeatureConfig.DEFAULT);

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_DEBRIS_LARGE_ASHY_SHOALS = register("ore_debris_large_ashy_shoals", Feature.ORE, new OreFeatureConfig(List.of(OreFeatureConfig.createTarget(OreConfiguredFeatures.BASE_STONE_NETHER, Blocks.ANCIENT_DEBRIS.getDefaultState())), 3, 1.0f)
    );
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_DEBRIS_SMALL_ASHY_SHOALS = register("ore_debris_small_ashy_shoals", Feature.ORE, new OreFeatureConfig(List.of(OreFeatureConfig.createTarget(OreConfiguredFeatures.BASE_STONE_NETHER, Blocks.ANCIENT_DEBRIS.getDefaultState())), 2, 1.0f)
    );
    public static final RegistryEntry<ConfiguredFeature<DefaultFeatureConfig, ?>> ASH_PILES = register("ash_piles", CinderscapesFeatures.ASH_PILE, FeatureConfig.DEFAULT
            //.decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(10, 10, 128)))
    );
    public static final RegistryEntry<ConfiguredFeature<VegetationFeatureConfig, ?>> VEGETATION_ASHY_SHOALS = register("vegetation_ashy_shoals",
            CinderscapesFeatures.VEGETATION, CinderscapesFeatures.ASHY_SHOALS_VEGETATION_CONFIG
    );
    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> BRAMBLE_BERRY_BUSHES = register("bramble_berry_bushes",
            Feature.RANDOM_PATCH, CinderscapesFeatures.BRAMBLE_BERRY_BUSH_CONFIG
    );

    public static final RegistryEntry<ConfiguredFeature<ReplaceBlobsFeatureConfig, ?>> SOUL_SAND_ASHY_SHOALS = register("soul_sand_ashy_shoals",
            Feature.NETHERRACK_REPLACE_BLOBS, CinderscapesFeatures.SOUL_SAND_REPLACE_CONFIG);
    public static final RegistryEntry<ConfiguredFeature<ReplaceBlobsFeatureConfig, ?>> SOUL_SOIL_ASHY_SHOALS = register("soul_soil_ashy_shoals", Feature.NETHERRACK_REPLACE_BLOBS, CinderscapesFeatures.SOUL_SOIL_REPLACE_CONFIG);
    public static final RegistryEntry<ConfiguredFeature<ReplaceBlobsFeatureConfig, ?>> GRAVEL_ASHY_SHOALS = register("gravel_ashy_shoals", Feature.NETHERRACK_REPLACE_BLOBS, CinderscapesFeatures.GRAVEL_REPLACE_CONFIG);

    public static final RegistryEntry<ConfiguredFeature<DefaultFeatureConfig, ?>> ASH_TOP_LAYER = register("ash_top_layer", CinderscapesFeatures.ASH_TOP_LAYER, FeatureConfig.DEFAULT);

    private static final List<BlockState> DEAD_TREE_SAFELIST = Arrays.asList(Blocks.NETHERRACK.getDefaultState(), Blocks.GRAVEL.getDefaultState(), CinderscapesBlocks.ASH.getDefaultState(), Blocks.SOUL_SAND.getDefaultState(), Blocks.SOUL_SOIL.getDefaultState());

    public static final RegistryEntry<ConfiguredFeature<DefaultFeatureConfig, ?>> DEAD_TREE = register("dead_tree", CinderscapesFeatures.DEAD_TREE, FeatureConfig.DEFAULT);

    /******* BLACKSTONE SHALES *********/

    // TODO: Up until "repeat(x)" could be refactored into a separate configured feature and reused by both ashy shoals and blackstone shales
    public static final RegistryEntry<ConfiguredFeature<ReplaceBlobsFeatureConfig, ?>> SOUL_SAND_BLACKSTONE_SHALES = register("soul_sand_blackstone_shales",
            Feature.NETHERRACK_REPLACE_BLOBS, CinderscapesFeatures.SOUL_SAND_REPLACE_CONFIG
    );

    public static final RegistryEntry<ConfiguredFeature<ReplaceBlobsFeatureConfig, ?>> SOUL_SOIL_BLACKSTONE_SHALES = register("soul_soil_blackstone_shales",
            Feature.NETHERRACK_REPLACE_BLOBS, CinderscapesFeatures.SOUL_SOIL_REPLACE_CONFIG
    );

    public static final RegistryEntry<ConfiguredFeature<ShaleFeatureConfig, ?>> BLACKSTONE_SHALES = register("blackstone_shales",
            CinderscapesFeatures.SHALE_FEATURE, new ShaleFeatureConfig(Blocks.BLACKSTONE.getDefaultState(), 7, 12)
    );

    /******* LUMINOUS GROVE *********/
    public static final RegistryEntry<ConfiguredFeature<DefaultFeatureConfig, ?>> GLOWSTONE = register("luminous_grove/glowstone",
            Feature.GLOWSTONE_BLOB, FeatureConfig.DEFAULT
    );

    public static final RegistryEntry<ConfiguredFeature<DefaultFeatureConfig, ?>> SHROOMLIGHT_BUSH = register("luminous_grove/shroomlight_bush",
            CinderscapesFeatures.SHROOMLIGHT_BUSH, FeatureConfig.DEFAULT
    );

    public static final RegistryEntry<ConfiguredFeature<VegetationFeatureConfig, ?>> VEGETATION_LUMINOUS_GROWTH = register("luminous_growth/vegetation",
            CinderscapesFeatures.VEGETATION, CinderscapesFeatures.LUMINOUS_GROVE_VEGETATION_CONFIG
    );

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> LUMINOUS_POD = register("luminous_growth/luminous_pod",
            Feature.RANDOM_PATCH, CinderscapesFeatures.LUMINOUS_POD_CONFIG
    );

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> TALL_PHOTOFERN = register("luminous_growth/tall_photofern",
            Feature.RANDOM_PATCH, CinderscapesFeatures.TALL_PHOTOFERN_CONFIG
    );

    public static final RegistryEntry<ConfiguredFeature<DefaultFeatureConfig, ?>> UMBRAL_VINE = register("luminous_growth/umbral_vine",
            CinderscapesFeatures.UMBRAL_VINE, FeatureConfig.DEFAULT
    );

    public static final List<BlockState> CANOPIED_HUGE_FUNGUS_SAFELIST = List.of(CinderscapesBlocks.UMBRAL_NYLIUM.getDefaultState(), Blocks.NETHERRACK.getDefaultState());

    public static final RegistryEntry<ConfiguredFeature<CanopiedHugeFungusFeatureConfig, ?>> CANOPIED_HUGE_FUNGUS = register("canopied_huge_fungus", CinderscapesFeatures.CANOPIED_HUGE_FUNGUS, CinderscapesFeatures.UMBRAL_FUNGUS_NOT_PLANTED_CONFIG);

    public static final RegistryEntry<ConfiguredFeature<CanopiedHugeFungusFeatureConfig,?>> CANOPIED_HUGE_FUNGUS_PLANTED = register("canopied_huge_fungus_not_planted", CinderscapesFeatures.CANOPIED_HUGE_FUNGUS, CinderscapesFeatures.UMBRAL_FUNGUS_CONFIG);

    /******* QUARTZ CANYON *******/

    public static final RegistryEntry<ConfiguredFeature<VegetationFeatureConfig, ?>> VEGETATION_QUARTZ_CANYON = register("quartz_canyon/vegetation", CinderscapesFeatures.VEGETATION, CinderscapesFeatures.QUARTZ_CANYON_VEGETATION_CONFIG);

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_QUARTZ_QUARTZ_CANYON = register("quartz_canyon/quartz_ore", Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.NETHERRACK, Blocks.NETHER_QUARTZ_ORE.getDefaultState(), 14));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_SULFUR_QUARTZ_CANYON = register("quartz_canyon/sulfur_ore", Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.NETHERRACK, CinderscapesBlocks.SULFUR_ORE.getDefaultState(), 14));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_GOLD_QUARTZ_CANYON = register("quartz_canyon/gold_ore", Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.NETHERRACK, Blocks.NETHER_GOLD_ORE.getDefaultState(), 10));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_SMOKY_QUARTZ_QUARTZ_CANYON = register("quartz_canyon/smoky_quartz_ore", Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.NETHERRACK, CinderscapesBlocks.SMOKY_QUARTZ_ORE.getDefaultState(), 14));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_ROSE_QUARTZ_QUARTZ_CANYON = register("quartz_canyon/rose_quartz_ore", Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.NETHERRACK, CinderscapesBlocks.ROSE_QUARTZ_ORE.getDefaultState(), 14));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_SULFUR_QUARTZ_QUARTZ_CANYON = register("quartz_canyon/sulfur_quartz_ore", Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.NETHERRACK, CinderscapesBlocks.SULFUR_QUARTZ_ORE.getDefaultState(), 14));

    public static final List<BlockState> SHARD_WHITELIST = List.of(Blocks.NETHERRACK.getDefaultState(), Blocks.AIR.getDefaultState(), Blocks.GRAVEL.getDefaultState(), Blocks.NETHER_QUARTZ_ORE.getDefaultState(), Blocks.SOUL_SAND.getDefaultState());
    public static final List<BlockState> SHARED_SAFELIST = List.of(Blocks.NETHERRACK.getDefaultState(), Blocks.NETHER_QUARTZ_ORE.getDefaultState());

    public static final RegistryEntry<ConfiguredFeature<SimpleStateFeatureConfig, ?>> CEILING_SHARD_QUARTZ = register("quartz_canyon/ceiling_shard_quartz", CinderscapesFeatures.CEILING_SHARD, new SimpleStateFeatureConfig(CinderscapesBlocks.CRYSTALLINE_QUARTZ.getDefaultState(), SHARD_WHITELIST));
    public static final RegistryEntry<ConfiguredFeature<SimpleStateFeatureConfig, ?>> FLOOR_SHARD_QUARTZ = register("quartz_canyon/floor_shard_quartz", CinderscapesFeatures.FLOOR_SHARD, new SimpleStateFeatureConfig(CinderscapesBlocks.CRYSTALLINE_QUARTZ.getDefaultState(), SHARD_WHITELIST));
    public static final RegistryEntry<ConfiguredFeature<SimpleStateFeatureConfig, ?>> CEILING_SHARD_ROSE_QUARTZ = register("quartz_canyon/ceiling_shard_rose_quartz", CinderscapesFeatures.CEILING_SHARD, new SimpleStateFeatureConfig(CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ.getDefaultState(), SHARD_WHITELIST));
    public static final RegistryEntry<ConfiguredFeature<SimpleStateFeatureConfig, ?>> FLOOR_SHARD_ROSE_QUARTZ = register("quartz_canyon/floor_shard_rose_quartz", CinderscapesFeatures.FLOOR_SHARD, new SimpleStateFeatureConfig(CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ.getDefaultState(), SHARD_WHITELIST));
    public static final RegistryEntry<ConfiguredFeature<SimpleStateFeatureConfig, ?>> CEILING_SHARD_SMOKY_QUARTZ = register("quartz_canyon/ceiling_shard_smoky_quartz", CinderscapesFeatures.CEILING_SHARD, new SimpleStateFeatureConfig(CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ.getDefaultState(), SHARD_WHITELIST));
    public static final RegistryEntry<ConfiguredFeature<SimpleStateFeatureConfig, ?>> FLOOR_SHARD_SMOKY_QUARTZ = register("quartz_canyon/floor_shard_smoky_quartz", CinderscapesFeatures.FLOOR_SHARD, new SimpleStateFeatureConfig(CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ.getDefaultState(), SHARD_WHITELIST));
    public static final RegistryEntry<ConfiguredFeature<SimpleStateFeatureConfig, ?>> CEILING_SHARD_SULFUR_QUARTZ = register("quartz_canyon/ceiling_shard_sulfur_quartz", CinderscapesFeatures.CEILING_SHARD, new SimpleStateFeatureConfig(CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ.getDefaultState(), SHARD_WHITELIST));
    public static final RegistryEntry<ConfiguredFeature<SimpleStateFeatureConfig, ?>> FLOOR_SHARD_SULFUR_QUARTZ = register("quartz_canyon/floor_shard_sulfur_quartz", CinderscapesFeatures.FLOOR_SHARD, new SimpleStateFeatureConfig(CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ.getDefaultState(), SHARD_WHITELIST));

    public static final RegistryEntry<ConfiguredFeature<PolypiteQuartzFeatureConfig, ?>> POLYPITE_QUARTZ = register("quartz_canyon/polypite_quartz", configurePolypiteQuartz((PolypiteQuartzBlock) CinderscapesBlocks.POLYPITE_QUARTZ));
    public static final RegistryEntry<ConfiguredFeature<PolypiteQuartzFeatureConfig, ?>> POLYPITE_SULFUR_QUARTZ = register("quartz_canyon/polypite_sulfur_quartz", configurePolypiteQuartz((PolypiteQuartzBlock) CinderscapesBlocks.POLYPITE_SULFUR_QUARTZ));
    public static final RegistryEntry<ConfiguredFeature<PolypiteQuartzFeatureConfig, ?>> POLYPITE_ROSE_QUARTZ = register("quartz_canyon/polypite_rose_quartz", configurePolypiteQuartz((PolypiteQuartzBlock) CinderscapesBlocks.POLYPITE_ROSE_QUARTZ));
    public static final RegistryEntry<ConfiguredFeature<PolypiteQuartzFeatureConfig, ?>> POLYPITE_SMOKY_QUARTZ = register("quartz_canyon/polypite_smoky_quartz", configurePolypiteQuartz((PolypiteQuartzBlock) CinderscapesBlocks.POLYPITE_SMOKY_QUARTZ));

    private static ConfiguredFeature<PolypiteQuartzFeatureConfig, ?> configurePolypiteQuartz(PolypiteQuartzBlock block) {
        return new ConfiguredFeature<>(CinderscapesFeatures.POLYPITE_QUARTZ, new PolypiteQuartzFeatureConfig(block));
    }

    private CinderscapesConfiguredFeatures() {
    }

    private static  <FC extends FeatureConfig, F extends Feature<FC>> RegistryEntry<ConfiguredFeature<FC, ?>> register(String id, F feature, FC config) {
        return register(id, new ConfiguredFeature<>(feature, config));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> RegistryEntry<ConfiguredFeature<FC, ?>> register(String id, ConfiguredFeature<FC, F> cf) {
        Identifier realId = Cinderscapes.id(id);
        Preconditions.checkState(!BuiltinRegistries.CONFIGURED_FEATURE.getIds().contains(realId), "Duplicate ID: %s", id);
        return BuiltinRegistries.method_40360(BuiltinRegistries.CONFIGURED_FEATURE, realId.toString(), cf);
    }

}
