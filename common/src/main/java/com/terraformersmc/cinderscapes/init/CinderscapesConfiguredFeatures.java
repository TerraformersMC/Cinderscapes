package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.block.PolypiteQuartzBlock;
import com.terraformersmc.cinderscapes.feature.config.*;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

@SuppressWarnings("UnstableApiUsage")
public final class CinderscapesConfiguredFeatures {
    /* ASHY SHOALS */
    private static final RuleTest RULE_TEST_BASE_STONE_NETHER = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
    private static final RuleTest RULE_TEST_NETHERRACK = new BlockMatchRuleTest(Blocks.NETHERRACK);

    public static final RegistryKey<ConfiguredFeature<?, ?>> DEBRIS_ORE_LARGE = createRegistryKey("ashy_shoals/debris_ore_large");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DEBRIS_ORE_SMALL = createRegistryKey("ashy_shoals/debris_ore_small");

    public static final RegistryKey<ConfiguredFeature<?, ?>> ASH_PILE = createRegistryKey("ashy_shoals/ash_pile");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ASHY_VEGETATION = createRegistryKey("ashy_shoals/vegetation");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BRAMBLE_BERRY_BUSHES = createRegistryKey("ashy_shoals/bramble_berry_bushes");

    public static final RegistryKey<ConfiguredFeature<?, ?>> ASHY_SOUL_SAND = createRegistryKey("ashy_shoals/soul_sand");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ASHY_SOUL_SOIL = createRegistryKey("ashy_shoals/soul_soil");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ASHY_GRAVEL = createRegistryKey("ashy_shoals/gravel");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ASH_TOP_LAYER = createRegistryKey("ashy_shoals/ash_top_layer");

    public static final RegistryKey<ConfiguredFeature<?, ?>> DEAD_TREE = createRegistryKey("ashy_shoals/dead_tree");

    /* BLACKSTONE SHALES */
    public static final RegistryKey<ConfiguredFeature<?, ?>> WEEPING_VINE = createRegistryKey("blackstone_shales/weeping_vine");

    public static final RegistryKey<ConfiguredFeature<?, ?>> SHALES_SOUL_SAND = createRegistryKey("blackstone_shales/soul_sand");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SHALES_SOUL_SOIL = createRegistryKey("blackstone_shales/soul_soil");

    public static final RegistryKey<ConfiguredFeature<?, ?>> SHALE = createRegistryKey("blackstone_shales/shale");

    /* LUMINOUS GROVE */
    public static final RegistryKey<ConfiguredFeature<?, ?>> SHROOMLIGHT_BUSH = createRegistryKey("luminous_grove/shroomlight_bush");
    public static final RegistryKey<ConfiguredFeature<?, ?>> UMBRAL_VINE = createRegistryKey("luminous_grove/umbral_vine");

    public static final RegistryKey<ConfiguredFeature<?, ?>> LUMINOUS_VEGETATION = createRegistryKey("luminous_grove/vegetation");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LUMINOUS_POD = createRegistryKey("luminous_grove/luminous_pod");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TALL_PHOTOFERN = createRegistryKey("luminous_grove/tall_photofern");

    public static final RegistryKey<ConfiguredFeature<?, ?>> CANOPIED_HUGE_FUNGUS = createRegistryKey("luminous_grove/canopied_huge_fungus");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CANOPIED_HUGE_FUNGUS_PLANTED = createRegistryKey("luminous_grove/canopied_huge_fungus_planted");

    /* QUARTZ CAVERN */
    public static final RegistryKey<ConfiguredFeature<?, ?>> QUARTZ_VEGETATION = createRegistryKey("quartz_cavern/vegetation");

    public static final RegistryKey<ConfiguredFeature<?, ?>> QUARTZ_ORE = createRegistryKey("quartz_cavern/quartz_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SULFUR_QUARTZ_ORE = createRegistryKey("quartz_cavern/sulfur_quartz_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ROSE_QUARTZ_ORE = createRegistryKey("quartz_cavern/rose_quartz_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SMOKY_QUARTZ_ORE = createRegistryKey("quartz_cavern/smoky_quartz_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GOLD_ORE = createRegistryKey("quartz_cavern/gold_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SULFUR_ORE = createRegistryKey("quartz_cavern/sulfur_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> CEILING_SHARD_QUARTZ = createRegistryKey("quartz_cavern/ceiling_shard_quartz");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CEILING_SHARD_SULFUR_QUARTZ = createRegistryKey("quartz_cavern/ceiling_shard_sulfur_quartz");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CEILING_SHARD_ROSE_QUARTZ = createRegistryKey("quartz_cavern/ceiling_shard_rose_quartz");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CEILING_SHARD_SMOKY_QUARTZ = createRegistryKey("quartz_cavern/ceiling_shard_smoky_quartz");

    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOOR_SHARD_QUARTZ = createRegistryKey("quartz_cavern/floor_shard_quartz");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOOR_SHARD_SULFUR_QUARTZ = createRegistryKey("quartz_cavern/floor_shard_sulfur_quartz");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOOR_SHARD_ROSE_QUARTZ = createRegistryKey("quartz_cavern/floor_shard_rose_quartz");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOOR_SHARD_SMOKY_QUARTZ = createRegistryKey("quartz_cavern/floor_shard_smoky_quartz");

    public static final RegistryKey<ConfiguredFeature<?, ?>> POLYPITE_QUARTZ = createRegistryKey("quartz_cavern/polypite_quartz");
    public static final RegistryKey<ConfiguredFeature<?, ?>> POLYPITE_SULFUR_QUARTZ = createRegistryKey("quartz_cavern/polypite_sulfur_quartz");
    public static final RegistryKey<ConfiguredFeature<?, ?>> POLYPITE_ROSE_QUARTZ = createRegistryKey("quartz_cavern/polypite_rose_quartz");
    public static final RegistryKey<ConfiguredFeature<?, ?>> POLYPITE_SMOKY_QUARTZ = createRegistryKey("quartz_cavern/polypite_smoky_quartz");

    public static void populate(FabricDynamicRegistryProvider.Entries entries) {
        /* ASHY SHOALS */
        entries.add(DEBRIS_ORE_LARGE, configureFeature(Feature.ORE, new OreFeatureConfig(List.of(OreFeatureConfig.createTarget(RULE_TEST_BASE_STONE_NETHER, Blocks.ANCIENT_DEBRIS.getDefaultState())), 3, 1.0f)));
        entries.add(DEBRIS_ORE_SMALL, configureFeature(Feature.ORE, new OreFeatureConfig(List.of(OreFeatureConfig.createTarget(RULE_TEST_BASE_STONE_NETHER, Blocks.ANCIENT_DEBRIS.getDefaultState())), 2, 1.0f)));

        entries.add(ASH_PILE, configureFeature(CinderscapesFeatures.ASH_PILE, FeatureConfig.DEFAULT));
        entries.add(ASHY_VEGETATION, configureFeature(CinderscapesFeatures.VEGETATION, CinderscapesFeatures.ASHY_SHOALS_VEGETATION_CONFIG));
        entries.add(BRAMBLE_BERRY_BUSHES, configureFeature(Feature.RANDOM_PATCH, CinderscapesFeatures.BRAMBLE_BERRY_BUSH_CONFIG));

        entries.add(ASHY_SOUL_SAND, configureFeature(Feature.NETHERRACK_REPLACE_BLOBS, CinderscapesFeatures.SOUL_SAND_REPLACE_CONFIG));
        entries.add(ASHY_SOUL_SOIL, configureFeature(Feature.NETHERRACK_REPLACE_BLOBS, CinderscapesFeatures.SOUL_SOIL_REPLACE_CONFIG));
        entries.add(ASHY_GRAVEL, configureFeature(Feature.NETHERRACK_REPLACE_BLOBS, CinderscapesFeatures.GRAVEL_REPLACE_CONFIG));
        entries.add(ASH_TOP_LAYER, configureFeature(CinderscapesFeatures.ASH_TOP_LAYER, FeatureConfig.DEFAULT));

        entries.add(DEAD_TREE, configureFeature(CinderscapesFeatures.DEAD_TREE, FeatureConfig.DEFAULT));

        /* BLACKSTONE SHALES */
        entries.add(WEEPING_VINE, configureFeature(Feature.WEEPING_VINES, FeatureConfig.DEFAULT));

        entries.add(SHALES_SOUL_SAND, configureFeature(Feature.NETHERRACK_REPLACE_BLOBS, CinderscapesFeatures.SOUL_SAND_REPLACE_CONFIG));
        entries.add(SHALES_SOUL_SOIL, configureFeature(Feature.NETHERRACK_REPLACE_BLOBS, CinderscapesFeatures.SOUL_SOIL_REPLACE_CONFIG));

        entries.add(SHALE, configureFeature(CinderscapesFeatures.SHALE_FEATURE, new ShaleFeatureConfig(Blocks.BLACKSTONE.getDefaultState(), 7, 12)));

        /* LUMINOUS GROVE */
        entries.add(SHROOMLIGHT_BUSH, configureFeature(CinderscapesFeatures.SHROOMLIGHT_BUSH, FeatureConfig.DEFAULT));
        entries.add(UMBRAL_VINE, configureFeature(CinderscapesFeatures.UMBRAL_VINE, FeatureConfig.DEFAULT));

        entries.add(LUMINOUS_VEGETATION, configureFeature(CinderscapesFeatures.VEGETATION, CinderscapesFeatures.LUMINOUS_GROVE_VEGETATION_CONFIG));
        entries.add(LUMINOUS_POD, configureFeature(Feature.RANDOM_PATCH, CinderscapesFeatures.LUMINOUS_POD_CONFIG));
        entries.add(TALL_PHOTOFERN, configureFeature(Feature.RANDOM_PATCH, CinderscapesFeatures.TALL_PHOTOFERN_CONFIG));

        entries.add(CANOPIED_HUGE_FUNGUS, configureFeature(CinderscapesFeatures.CANOPIED_HUGE_FUNGUS, CinderscapesFeatures.UMBRAL_FUNGUS_NOT_PLANTED_CONFIG));
        entries.add(CANOPIED_HUGE_FUNGUS_PLANTED, configureFeature(CinderscapesFeatures.CANOPIED_HUGE_FUNGUS, CinderscapesFeatures.UMBRAL_FUNGUS_CONFIG));

        /* QUARTZ CAVERN */
        entries.add(QUARTZ_VEGETATION, configureFeature(CinderscapesFeatures.VEGETATION, CinderscapesFeatures.QUARTZ_CAVERN_VEGETATION_CONFIG));

        entries.add(QUARTZ_ORE, configureFeature(Feature.ORE, new OreFeatureConfig(RULE_TEST_NETHERRACK, Blocks.NETHER_QUARTZ_ORE.getDefaultState(), 14)));
        entries.add(SULFUR_QUARTZ_ORE, configureFeature(Feature.ORE, new OreFeatureConfig(RULE_TEST_NETHERRACK, CinderscapesBlocks.SULFUR_QUARTZ_ORE.getDefaultState(), 14)));
        entries.add(ROSE_QUARTZ_ORE, configureFeature(Feature.ORE, new OreFeatureConfig(RULE_TEST_NETHERRACK, CinderscapesBlocks.ROSE_QUARTZ_ORE.getDefaultState(), 14)));
        entries.add(SMOKY_QUARTZ_ORE, configureFeature(Feature.ORE, new OreFeatureConfig(RULE_TEST_NETHERRACK, CinderscapesBlocks.SMOKY_QUARTZ_ORE.getDefaultState(), 14)));
        entries.add(GOLD_ORE, configureFeature(Feature.ORE, new OreFeatureConfig(RULE_TEST_NETHERRACK, Blocks.NETHER_GOLD_ORE.getDefaultState(), 10)));
        entries.add(SULFUR_ORE, configureFeature(Feature.ORE, new OreFeatureConfig(RULE_TEST_NETHERRACK, CinderscapesBlocks.SULFUR_ORE.getDefaultState(), 14)));

        final List<BlockState> SHARD_WHITELIST = List.of(
                Blocks.AIR.getDefaultState(),
                Blocks.GRAVEL.getDefaultState(),
                Blocks.NETHERRACK.getDefaultState(),
                Blocks.SOUL_SAND.getDefaultState(),
                Blocks.NETHER_QUARTZ_ORE.getDefaultState(),
                CinderscapesBlocks.ROSE_QUARTZ_ORE.getDefaultState(),
                CinderscapesBlocks.SMOKY_QUARTZ_ORE.getDefaultState(),
                CinderscapesBlocks.SULFUR_QUARTZ_ORE.getDefaultState(),
                CinderscapesBlocks.SULFUR_ORE.getDefaultState()
        );

        entries.add(CEILING_SHARD_QUARTZ, configureFeature(CinderscapesFeatures.CRYSTAL_SHARD_FEATURE, new CrystalShardFeatureConfig(CinderscapesBlocks.CRYSTALLINE_QUARTZ.getDefaultState(), Direction.DOWN, SHARD_WHITELIST)));
        entries.add(CEILING_SHARD_SULFUR_QUARTZ, configureFeature(CinderscapesFeatures.CRYSTAL_SHARD_FEATURE, new CrystalShardFeatureConfig(CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ.getDefaultState(), Direction.DOWN, SHARD_WHITELIST)));
        entries.add(CEILING_SHARD_ROSE_QUARTZ, configureFeature(CinderscapesFeatures.CRYSTAL_SHARD_FEATURE, new CrystalShardFeatureConfig(CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ.getDefaultState(), Direction.DOWN, SHARD_WHITELIST)));
        entries.add(CEILING_SHARD_SMOKY_QUARTZ, configureFeature(CinderscapesFeatures.CRYSTAL_SHARD_FEATURE, new CrystalShardFeatureConfig(CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ.getDefaultState(), Direction.DOWN, SHARD_WHITELIST)));

        entries.add(FLOOR_SHARD_QUARTZ, configureFeature(CinderscapesFeatures.CRYSTAL_SHARD_FEATURE, new CrystalShardFeatureConfig(CinderscapesBlocks.CRYSTALLINE_QUARTZ.getDefaultState(), Direction.UP, SHARD_WHITELIST)));
        entries.add(FLOOR_SHARD_SULFUR_QUARTZ, configureFeature(CinderscapesFeatures.CRYSTAL_SHARD_FEATURE, new CrystalShardFeatureConfig(CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ.getDefaultState(), Direction.UP, SHARD_WHITELIST)));
        entries.add(FLOOR_SHARD_ROSE_QUARTZ, configureFeature(CinderscapesFeatures.CRYSTAL_SHARD_FEATURE, new CrystalShardFeatureConfig(CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ.getDefaultState(), Direction.UP, SHARD_WHITELIST)));
        entries.add(FLOOR_SHARD_SMOKY_QUARTZ, configureFeature(CinderscapesFeatures.CRYSTAL_SHARD_FEATURE, new CrystalShardFeatureConfig(CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ.getDefaultState(), Direction.UP, SHARD_WHITELIST)));

        entries.add(POLYPITE_QUARTZ, configurePolypiteQuartz((PolypiteQuartzBlock) CinderscapesBlocks.POLYPITE_QUARTZ));
        entries.add(POLYPITE_SULFUR_QUARTZ, configurePolypiteQuartz((PolypiteQuartzBlock) CinderscapesBlocks.POLYPITE_SULFUR_QUARTZ));
        entries.add(POLYPITE_ROSE_QUARTZ, configurePolypiteQuartz((PolypiteQuartzBlock) CinderscapesBlocks.POLYPITE_ROSE_QUARTZ));
        entries.add(POLYPITE_SMOKY_QUARTZ, configurePolypiteQuartz((PolypiteQuartzBlock) CinderscapesBlocks.POLYPITE_SMOKY_QUARTZ));
    }

    private static ConfiguredFeature<PolypiteQuartzFeatureConfig, ?> configurePolypiteQuartz(PolypiteQuartzBlock block) {
        return new ConfiguredFeature<>(CinderscapesFeatures.POLYPITE_QUARTZ, new PolypiteQuartzFeatureConfig(block));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> createRegistryKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Cinderscapes.NAMESPACE, name));
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>> ConfiguredFeature<FC, ?> configureFeature(F feature, FC config) {
        return new ConfiguredFeature<>(feature, config);
    }

    public static void init() {
        // This just creates the registry keys.  Configured Features are requested and consumed by datagen now.
    }
}
