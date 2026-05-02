package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.block.PolypiteQuartzBlock;
import com.terraformersmc.cinderscapes.feature.config.CrystalShardFeatureConfig;
import com.terraformersmc.cinderscapes.feature.config.PolypiteQuartzFeatureConfig;
import com.terraformersmc.cinderscapes.feature.config.ShaleFeatureConfig;
import com.terraformersmc.cinderscapes.init.helpers.CinderscapesRegistry;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.core.HolderGetter;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.HolderSet;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraft.resources.Identifier;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleRandomFeatureConfiguration;

import java.util.List;

public final class CinderscapesConfiguredFeatures {
    /* ASHY SHOALS */
    private static final RuleTest RULE_TEST_BASE_STONE_NETHER = new TagMatchTest(BlockTags.BASE_STONE_NETHER);
    private static final RuleTest RULE_TEST_NETHERRACK = new BlockMatchTest(Blocks.NETHERRACK);

    public static final ResourceKey<ConfiguredFeature<?, ?>> DEBRIS_ORE_LARGE = createRegistryKey("ashy_shoals/debris_ore_large");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEBRIS_ORE_SMALL = createRegistryKey("ashy_shoals/debris_ore_small");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ASH_PILE = createRegistryKey("ashy_shoals/ash_pile");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASHY_VEGETATION = createRegistryKey("ashy_shoals/vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BRAMBLE_BERRY_BUSHES = createRegistryKey("ashy_shoals/bramble_berry_bushes");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ASHY_SOUL_SAND = createRegistryKey("ashy_shoals/soul_sand");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASHY_SOUL_SOIL = createRegistryKey("ashy_shoals/soul_soil");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASHY_GRAVEL = createRegistryKey("ashy_shoals/gravel");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASH_TOP_LAYER = createRegistryKey("ashy_shoals/ash_top_layer");

    public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_TREE = createRegistryKey("ashy_shoals/dead_tree");

    /* BLACKSTONE SHALES */
    public static final ResourceKey<ConfiguredFeature<?, ?>> WEEPING_VINE = createRegistryKey("blackstone_shales/weeping_vine");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SHALES_SOUL_SAND = createRegistryKey("blackstone_shales/soul_sand");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SHALES_SOUL_SOIL = createRegistryKey("blackstone_shales/soul_soil");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SHALE = createRegistryKey("blackstone_shales/shale");

    /* LUMINOUS GROVE */
    public static final ResourceKey<ConfiguredFeature<?, ?>> SHROOMLIGHT_BUSH = createRegistryKey("luminous_grove/shroomlight_bush");
    public static final ResourceKey<ConfiguredFeature<?, ?>> UMBRAL_VINE = createRegistryKey("luminous_grove/umbral_vine");

    public static final ResourceKey<ConfiguredFeature<?, ?>> LUMINOUS_VEGETATION = createRegistryKey("luminous_grove/vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LUMINOUS_POD = createRegistryKey("luminous_grove/luminous_pod");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_PHOTOFERN = createRegistryKey("luminous_grove/tall_photofern");

    public static final ResourceKey<ConfiguredFeature<?, ?>> CANOPIED_HUGE_FUNGUS = createRegistryKey("luminous_grove/canopied_huge_fungus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CANOPIED_HUGE_FUNGUS_PLANTED = createRegistryKey("luminous_grove/canopied_huge_fungus_planted");

    /* QUARTZ CAVERN */
    public static final ResourceKey<ConfiguredFeature<?, ?>> QUARTZ_VEGETATION = createRegistryKey("quartz_cavern/vegetation");

    public static final ResourceKey<ConfiguredFeature<?, ?>> QUARTZ_ORE = createRegistryKey("quartz_cavern/quartz_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SULFUR_QUARTZ_ORE = createRegistryKey("quartz_cavern/sulfur_quartz_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ROSE_QUARTZ_ORE = createRegistryKey("quartz_cavern/rose_quartz_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMOKY_QUARTZ_ORE = createRegistryKey("quartz_cavern/smoky_quartz_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GOLD_ORE = createRegistryKey("quartz_cavern/gold_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SULFUR_ORE = createRegistryKey("quartz_cavern/sulfur_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> CEILING_SHARD_QUARTZ = createRegistryKey("quartz_cavern/ceiling_shard_quartz");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CEILING_SHARD_SULFUR_QUARTZ = createRegistryKey("quartz_cavern/ceiling_shard_sulfur_quartz");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CEILING_SHARD_ROSE_QUARTZ = createRegistryKey("quartz_cavern/ceiling_shard_rose_quartz");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CEILING_SHARD_SMOKY_QUARTZ = createRegistryKey("quartz_cavern/ceiling_shard_smoky_quartz");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CEILING_SHARDS = createRegistryKey("quartz_cavern/ceiling_shards");

    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOOR_SHARD_QUARTZ = createRegistryKey("quartz_cavern/floor_shard_quartz");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOOR_SHARD_SULFUR_QUARTZ = createRegistryKey("quartz_cavern/floor_shard_sulfur_quartz");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOOR_SHARD_ROSE_QUARTZ = createRegistryKey("quartz_cavern/floor_shard_rose_quartz");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOOR_SHARD_SMOKY_QUARTZ = createRegistryKey("quartz_cavern/floor_shard_smoky_quartz");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOOR_SHARDS = createRegistryKey("quartz_cavern/floor_shards");

    public static final ResourceKey<ConfiguredFeature<?, ?>> POLYPITE_QUARTZ = createRegistryKey("quartz_cavern/polypite_quartz");
    public static final ResourceKey<ConfiguredFeature<?, ?>> POLYPITE_SULFUR_QUARTZ = createRegistryKey("quartz_cavern/polypite_sulfur_quartz");
    public static final ResourceKey<ConfiguredFeature<?, ?>> POLYPITE_ROSE_QUARTZ = createRegistryKey("quartz_cavern/polypite_rose_quartz");
    public static final ResourceKey<ConfiguredFeature<?, ?>> POLYPITE_SMOKY_QUARTZ = createRegistryKey("quartz_cavern/polypite_smoky_quartz");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> registerable) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = registerable.lookup(Registries.CONFIGURED_FEATURE);
        HolderGetter<PlacedFeature> placedFeatures = registerable.lookup(Registries.PLACED_FEATURE);

        /* ASHY SHOALS */
        CinderscapesRegistry.register(registerable, DEBRIS_ORE_LARGE, Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(RULE_TEST_BASE_STONE_NETHER, Blocks.ANCIENT_DEBRIS.defaultBlockState())), 3, 1.0f));
        CinderscapesRegistry.register(registerable, DEBRIS_ORE_SMALL, Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(RULE_TEST_BASE_STONE_NETHER, Blocks.ANCIENT_DEBRIS.defaultBlockState())), 2, 1.0f));

        CinderscapesRegistry.register(registerable, ASH_PILE, CinderscapesFeatures.ASH_PILE, FeatureConfiguration.NONE);
        CinderscapesRegistry.register(registerable, ASHY_VEGETATION, CinderscapesFeatures.VEGETATION, CinderscapesFeatures.ASHY_SHOALS_VEGETATION_CONFIG);
        CinderscapesRegistry.register(registerable, BRAMBLE_BERRY_BUSHES, Feature.RANDOM_PATCH, CinderscapesFeatures.BRAMBLE_BERRY_BUSH_CONFIG);

        CinderscapesRegistry.register(registerable, ASHY_SOUL_SAND, Feature.REPLACE_BLOBS, CinderscapesFeatures.SOUL_SAND_REPLACE_CONFIG);
        CinderscapesRegistry.register(registerable, ASHY_SOUL_SOIL, Feature.REPLACE_BLOBS, CinderscapesFeatures.SOUL_SOIL_REPLACE_CONFIG);
        CinderscapesRegistry.register(registerable, ASHY_GRAVEL, Feature.REPLACE_BLOBS, CinderscapesFeatures.GRAVEL_REPLACE_CONFIG);
        CinderscapesRegistry.register(registerable, ASH_TOP_LAYER, CinderscapesFeatures.ASH_TOP_LAYER, FeatureConfiguration.NONE);

        CinderscapesRegistry.register(registerable, DEAD_TREE, CinderscapesFeatures.DEAD_TREE, FeatureConfiguration.NONE);

        /* BLACKSTONE SHALES */
        CinderscapesRegistry.register(registerable, WEEPING_VINE, Feature.WEEPING_VINES, FeatureConfiguration.NONE);

        CinderscapesRegistry.register(registerable, SHALES_SOUL_SAND, Feature.REPLACE_BLOBS, CinderscapesFeatures.SOUL_SAND_REPLACE_CONFIG);
        CinderscapesRegistry.register(registerable, SHALES_SOUL_SOIL, Feature.REPLACE_BLOBS, CinderscapesFeatures.SOUL_SOIL_REPLACE_CONFIG);

        CinderscapesRegistry.register(registerable, SHALE, CinderscapesFeatures.SHALE_FEATURE, new ShaleFeatureConfig(Blocks.BLACKSTONE.defaultBlockState(), 7, 12));

        /* LUMINOUS GROVE */
        CinderscapesRegistry.register(registerable, SHROOMLIGHT_BUSH, CinderscapesFeatures.SHROOMLIGHT_BUSH, FeatureConfiguration.NONE);
        CinderscapesRegistry.register(registerable, UMBRAL_VINE, CinderscapesFeatures.UMBRAL_VINE, FeatureConfiguration.NONE);

        CinderscapesRegistry.register(registerable, LUMINOUS_VEGETATION, CinderscapesFeatures.VEGETATION, CinderscapesFeatures.LUMINOUS_GROVE_VEGETATION_CONFIG);
        CinderscapesRegistry.register(registerable, LUMINOUS_POD, Feature.RANDOM_PATCH, CinderscapesFeatures.LUMINOUS_POD_CONFIG);
        CinderscapesRegistry.register(registerable, TALL_PHOTOFERN, Feature.RANDOM_PATCH, CinderscapesFeatures.TALL_PHOTOFERN_CONFIG);

        CinderscapesRegistry.register(registerable, CANOPIED_HUGE_FUNGUS, CinderscapesFeatures.CANOPIED_HUGE_FUNGUS, CinderscapesFeatures.UMBRAL_FUNGUS_NOT_PLANTED_CONFIG);
        CinderscapesRegistry.register(registerable, CANOPIED_HUGE_FUNGUS_PLANTED, CinderscapesFeatures.CANOPIED_HUGE_FUNGUS, CinderscapesFeatures.UMBRAL_FUNGUS_CONFIG);

        /* QUARTZ CAVERN */
        CinderscapesRegistry.register(registerable, QUARTZ_VEGETATION, CinderscapesFeatures.VEGETATION, CinderscapesFeatures.QUARTZ_CAVERN_VEGETATION_CONFIG);

        CinderscapesRegistry.register(registerable, QUARTZ_ORE, Feature.ORE, new OreConfiguration(RULE_TEST_NETHERRACK, Blocks.NETHER_QUARTZ_ORE.defaultBlockState(), 14));
        CinderscapesRegistry.register(registerable, SULFUR_QUARTZ_ORE, Feature.ORE, new OreConfiguration(RULE_TEST_NETHERRACK, CinderscapesBlocks.SULFUR_QUARTZ_ORE.defaultBlockState(), 14));
        CinderscapesRegistry.register(registerable, ROSE_QUARTZ_ORE, Feature.ORE, new OreConfiguration(RULE_TEST_NETHERRACK, CinderscapesBlocks.ROSE_QUARTZ_ORE.defaultBlockState(), 14));
        CinderscapesRegistry.register(registerable, SMOKY_QUARTZ_ORE, Feature.ORE, new OreConfiguration(RULE_TEST_NETHERRACK, CinderscapesBlocks.SMOKY_QUARTZ_ORE.defaultBlockState(), 14));
        CinderscapesRegistry.register(registerable, GOLD_ORE, Feature.ORE, new OreConfiguration(RULE_TEST_NETHERRACK, Blocks.NETHER_GOLD_ORE.defaultBlockState(), 10));
        CinderscapesRegistry.register(registerable, SULFUR_ORE, Feature.ORE, new OreConfiguration(RULE_TEST_NETHERRACK, CinderscapesBlocks.SULFUR_ORE.defaultBlockState(), 14));

        final List<BlockState> SHARD_WHITELIST = List.of(
                Blocks.AIR.defaultBlockState(),
                Blocks.GRAVEL.defaultBlockState(),
                Blocks.NETHERRACK.defaultBlockState(),
                Blocks.SOUL_SAND.defaultBlockState(),
                Blocks.NETHER_QUARTZ_ORE.defaultBlockState(),
                CinderscapesBlocks.ROSE_QUARTZ_ORE.defaultBlockState(),
                CinderscapesBlocks.SMOKY_QUARTZ_ORE.defaultBlockState(),
                CinderscapesBlocks.SULFUR_QUARTZ_ORE.defaultBlockState(),
                CinderscapesBlocks.SULFUR_ORE.defaultBlockState()
        );

        CinderscapesRegistry.register(registerable, CEILING_SHARD_QUARTZ, CinderscapesFeatures.CRYSTAL_SHARD_FEATURE, new CrystalShardFeatureConfig(CinderscapesBlocks.CRYSTALLINE_QUARTZ.defaultBlockState(), Direction.DOWN, SHARD_WHITELIST));
        CinderscapesRegistry.register(registerable, CEILING_SHARD_SULFUR_QUARTZ, CinderscapesFeatures.CRYSTAL_SHARD_FEATURE, new CrystalShardFeatureConfig(CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ.defaultBlockState(), Direction.DOWN, SHARD_WHITELIST));
        CinderscapesRegistry.register(registerable, CEILING_SHARD_ROSE_QUARTZ, CinderscapesFeatures.CRYSTAL_SHARD_FEATURE, new CrystalShardFeatureConfig(CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ.defaultBlockState(), Direction.DOWN, SHARD_WHITELIST));
        CinderscapesRegistry.register(registerable, CEILING_SHARD_SMOKY_QUARTZ, CinderscapesFeatures.CRYSTAL_SHARD_FEATURE, new CrystalShardFeatureConfig(CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ.defaultBlockState(), Direction.DOWN, SHARD_WHITELIST));
        CinderscapesRegistry.register(registerable, CEILING_SHARDS,
                Feature.SIMPLE_RANDOM_SELECTOR,
                new SimpleRandomFeatureConfiguration(
                        HolderSet.direct(
                                placedFeatures.getOrThrow(CinderscapesPlacedFeatures.CEILING_SHARD_QUARTZ),
                                placedFeatures.getOrThrow(CinderscapesPlacedFeatures.CEILING_SHARD_ROSE_QUARTZ),
                                placedFeatures.getOrThrow(CinderscapesPlacedFeatures.CEILING_SHARD_SMOKY_QUARTZ),
                                placedFeatures.getOrThrow(CinderscapesPlacedFeatures.CEILING_SHARD_SULFUR_QUARTZ)
                        )
                )
        );

        CinderscapesRegistry.register(registerable, FLOOR_SHARD_QUARTZ, CinderscapesFeatures.CRYSTAL_SHARD_FEATURE, new CrystalShardFeatureConfig(CinderscapesBlocks.CRYSTALLINE_QUARTZ.defaultBlockState(), Direction.UP, SHARD_WHITELIST));
        CinderscapesRegistry.register(registerable, FLOOR_SHARD_SULFUR_QUARTZ, CinderscapesFeatures.CRYSTAL_SHARD_FEATURE, new CrystalShardFeatureConfig(CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ.defaultBlockState(), Direction.UP, SHARD_WHITELIST));
        CinderscapesRegistry.register(registerable, FLOOR_SHARD_ROSE_QUARTZ, CinderscapesFeatures.CRYSTAL_SHARD_FEATURE, new CrystalShardFeatureConfig(CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ.defaultBlockState(), Direction.UP, SHARD_WHITELIST));
        CinderscapesRegistry.register(registerable, FLOOR_SHARD_SMOKY_QUARTZ, CinderscapesFeatures.CRYSTAL_SHARD_FEATURE, new CrystalShardFeatureConfig(CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ.defaultBlockState(), Direction.UP, SHARD_WHITELIST));
        CinderscapesRegistry.register(registerable, FLOOR_SHARDS,
                Feature.SIMPLE_RANDOM_SELECTOR,
                new SimpleRandomFeatureConfiguration(
                        HolderSet.direct(
                                placedFeatures.getOrThrow(CinderscapesPlacedFeatures.FLOOR_SHARD_QUARTZ),
                                placedFeatures.getOrThrow(CinderscapesPlacedFeatures.FLOOR_SHARD_ROSE_QUARTZ),
                                placedFeatures.getOrThrow(CinderscapesPlacedFeatures.FLOOR_SHARD_SMOKY_QUARTZ),
                                placedFeatures.getOrThrow(CinderscapesPlacedFeatures.FLOOR_SHARD_SULFUR_QUARTZ)
                        )
                )
        );

        registerPolypite(registerable, POLYPITE_QUARTZ, (PolypiteQuartzBlock) CinderscapesBlocks.POLYPITE_QUARTZ);
        registerPolypite(registerable, POLYPITE_SULFUR_QUARTZ, (PolypiteQuartzBlock) CinderscapesBlocks.POLYPITE_SULFUR_QUARTZ);
        registerPolypite(registerable, POLYPITE_ROSE_QUARTZ, (PolypiteQuartzBlock) CinderscapesBlocks.POLYPITE_ROSE_QUARTZ);
        registerPolypite(registerable, POLYPITE_SMOKY_QUARTZ, (PolypiteQuartzBlock) CinderscapesBlocks.POLYPITE_SMOKY_QUARTZ);
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> createRegistryKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, name));
    }

    private static void registerPolypite(BootstrapContext<ConfiguredFeature<?, ?>> registerable, ResourceKey<ConfiguredFeature<?, ?>> key, PolypiteQuartzBlock block) {
        CinderscapesRegistry.register(registerable, key, CinderscapesFeatures.POLYPITE_QUARTZ, new PolypiteQuartzFeatureConfig(block));
    }
}
