package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.init.helpers.CinderscapesRegistry;
import com.terraformersmc.cinderscapes.placementmodifier.SafelistRangeCeilingPlacementModifier;
import com.terraformersmc.cinderscapes.placementmodifier.SafelistRangeFloorPlacementModifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.core.HolderGetter;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.data.worldgen.features.NetherFeatures;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.CountOnEveryLayerPlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;

import java.util.List;

@SuppressWarnings("deprecation")
public class CinderscapesPlacedFeatures {
    /* ASHY SHOALS */
    public static final ResourceKey<PlacedFeature> DEBRIS_ORE_LARGE = createRegistryKey("ashy_shoals/debris_ore_large");
    public static final ResourceKey<PlacedFeature> DEBRIS_ORE_SMALL = createRegistryKey("ashy_shoals/debris_ore_small");

    public static final ResourceKey<PlacedFeature> ASH_PILES = createRegistryKey("ashy_shoals/ash_piles");
    public static final ResourceKey<PlacedFeature> ASHY_VEGETATION = createRegistryKey("ashy_shoals/vegetation");
    public static final ResourceKey<PlacedFeature> BRAMBLE_BERRY_BUSHES = createRegistryKey("ashy_shoals/bramble_berry_bushes");

    public static final ResourceKey<PlacedFeature> ASHY_SOUL_SAND = createRegistryKey("ashy_shoals/soul_sand");
    public static final ResourceKey<PlacedFeature> ASHY_SOUL_SOIL = createRegistryKey("ashy_shoals/soul_soil");
    public static final ResourceKey<PlacedFeature> ASHY_GRAVEL = createRegistryKey("ashy_shoals/gravel");
    public static final ResourceKey<PlacedFeature> ASH_TOP_LAYER = createRegistryKey("ashy_shoals/ash_top_layer");

    public static final ResourceKey<PlacedFeature> DEAD_TREES = createRegistryKey("ashy_shoals/dead_trees");

    /* BLACKSTONE SHALES */
    public static final ResourceKey<PlacedFeature> WEEPING_VINES = createRegistryKey("blackstone_shales/weeping_vines");
    public static final ResourceKey<PlacedFeature> PATCH_CRIMSON_ROOTS = createRegistryKey("blackstone_shales/patch_crimson_roots");

    public static final ResourceKey<PlacedFeature> SHALES_SOUL_SAND = createRegistryKey("blackstone_shales/soul_sand");
    public static final ResourceKey<PlacedFeature> SHALES_SOUL_SOIL = createRegistryKey("blackstone_shales/soul_soil");

    public static final ResourceKey<PlacedFeature> SHALES = createRegistryKey("blackstone_shales/shales");

    /* LUMINOUS GROVE */
    public static final ResourceKey<PlacedFeature> SHROOMLIGHT_BUSHES = createRegistryKey("luminous_grove/shroomlight_bushes");
    public static final ResourceKey<PlacedFeature> UMBRAL_VINES = createRegistryKey("luminous_grove/umbral_vines");

    public static final ResourceKey<PlacedFeature> LUMINOUS_VEGETATION = createRegistryKey("luminous_grove/vegetation");
    public static final ResourceKey<PlacedFeature> LUMINOUS_PODS = createRegistryKey("luminous_grove/luminous_pods");
    public static final ResourceKey<PlacedFeature> TALL_PHOTOFERNS = createRegistryKey("luminous_grove/tall_photoferns");

    public static final ResourceKey<PlacedFeature> CANOPIED_HUGE_FUNGUS = createRegistryKey("luminous_grove/canopied_huge_fungus");

    /* QUARTZ CAVERN */
    public static final ResourceKey<PlacedFeature> QUARTZ_VEGETATION = createRegistryKey("quartz_cavern/vegetation");

    public static final ResourceKey<PlacedFeature> QUARTZ_ORE = createRegistryKey("quartz_cavern/quartz_ore");
    public static final ResourceKey<PlacedFeature> SULFUR_QUARTZ_ORE = createRegistryKey("quartz_cavern/sulfur_quartz_ore");
    public static final ResourceKey<PlacedFeature> ROSE_QUARTZ_ORE = createRegistryKey("quartz_cavern/rose_quartz_ore");
    public static final ResourceKey<PlacedFeature> SMOKY_QUARTZ_ORE = createRegistryKey("quartz_cavern/smoky_quartz_ore");
    public static final ResourceKey<PlacedFeature> GOLD_ORE = createRegistryKey("quartz_cavern/gold_ore");
    public static final ResourceKey<PlacedFeature> SULFUR_ORE = createRegistryKey("quartz_cavern/sulfur_ore");

    public static final ResourceKey<PlacedFeature> CEILING_SHARD_QUARTZ = createRegistryKey("quartz_cavern/ceiling_shard_quartz");
    public static final ResourceKey<PlacedFeature> CEILING_SHARD_SULFUR_QUARTZ = createRegistryKey("quartz_cavern/ceiling_shard_sulfur_quartz");
    public static final ResourceKey<PlacedFeature> CEILING_SHARD_ROSE_QUARTZ = createRegistryKey("quartz_cavern/ceiling_shard_rose_quartz");
    public static final ResourceKey<PlacedFeature> CEILING_SHARD_SMOKY_QUARTZ = createRegistryKey("quartz_cavern/ceiling_shard_smoky_quartz");
    public static final ResourceKey<PlacedFeature> CEILING_SHARDS = createRegistryKey("quartz_cavern/ceiling_shards");

    public static final ResourceKey<PlacedFeature> FLOOR_SHARD_QUARTZ = createRegistryKey("quartz_cavern/floor_shard_quartz");
    public static final ResourceKey<PlacedFeature> FLOOR_SHARD_SULFUR_QUARTZ = createRegistryKey("quartz_cavern/floor_shard_sulfur_quartz");
    public static final ResourceKey<PlacedFeature> FLOOR_SHARD_ROSE_QUARTZ = createRegistryKey("quartz_cavern/floor_shard_rose_quartz");
    public static final ResourceKey<PlacedFeature> FLOOR_SHARD_SMOKY_QUARTZ = createRegistryKey("quartz_cavern/floor_shard_smoky_quartz");
    public static final ResourceKey<PlacedFeature> FLOOR_SHARDS = createRegistryKey("quartz_cavern/floor_shards");

    public static final ResourceKey<PlacedFeature> POLYPITE_QUARTZ = createRegistryKey("quartz_cavern/polypite_quartz");
    public static final ResourceKey<PlacedFeature> POLYPITE_SULFUR_QUARTZ = createRegistryKey("quartz_cavern/polypite_sulfur_quartz");
    public static final ResourceKey<PlacedFeature> POLYPITE_ROSE_QUARTZ = createRegistryKey("quartz_cavern/polypite_rose_quartz");
    public static final ResourceKey<PlacedFeature> POLYPITE_SMOKY_QUARTZ = createRegistryKey("quartz_cavern/polypite_smoky_quartz");

    public static void bootstrap(BootstrapContext<PlacedFeature> registerable) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = registerable.lookup(Registries.CONFIGURED_FEATURE);

        /* ASHY SHOALS */
        CinderscapesRegistry.register(registerable, DEBRIS_ORE_LARGE, CinderscapesConfiguredFeatures.DEBRIS_ORE_LARGE, HeightRangePlacement.triangle(VerticalAnchor.absolute(8), VerticalAnchor.absolute(24)), CountPlacement.of(4), InSquarePlacement.spread(), BiomeFilter.biome());
        CinderscapesRegistry.register(registerable, DEBRIS_ORE_SMALL, CinderscapesConfiguredFeatures.DEBRIS_ORE_SMALL, PlacementUtils.RANGE_8_8, CountPlacement.of(4), InSquarePlacement.spread(), BiomeFilter.biome());

        CinderscapesRegistry.register(registerable, ASH_PILES, CinderscapesConfiguredFeatures.ASH_PILE, CountOnEveryLayerPlacement.of(2), BiomeFilter.biome());
        CinderscapesRegistry.register(registerable, ASHY_VEGETATION, CinderscapesConfiguredFeatures.ASHY_VEGETATION, CountOnEveryLayerPlacement.of(16), BiomeFilter.biome());
        CinderscapesRegistry.register(registerable, BRAMBLE_BERRY_BUSHES, CinderscapesConfiguredFeatures.BRAMBLE_BERRY_BUSHES, CountOnEveryLayerPlacement.of(1), BiomeFilter.biome());

        CinderscapesRegistry.register(registerable, ASHY_SOUL_SAND, CinderscapesConfiguredFeatures.ASHY_SOUL_SAND, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64)), CountPlacement.of(5), InSquarePlacement.spread(), BiomeFilter.biome());
        CinderscapesRegistry.register(registerable, ASHY_SOUL_SOIL, CinderscapesConfiguredFeatures.ASHY_SOUL_SOIL, PlacementUtils.FULL_RANGE, CountPlacement.of(10), InSquarePlacement.spread(), BiomeFilter.biome());
        CinderscapesRegistry.register(registerable, ASHY_GRAVEL, CinderscapesConfiguredFeatures.ASHY_GRAVEL, PlacementUtils.FULL_RANGE, CountPlacement.of(5), InSquarePlacement.spread(), BiomeFilter.biome());
        CinderscapesRegistry.register(registerable, ASH_TOP_LAYER, CinderscapesConfiguredFeatures.ASH_TOP_LAYER);

        final List<Block> DEAD_TREE_SAFELIST = List.of(
                CinderscapesBlocks.ASH,
                Blocks.GRAVEL,
                Blocks.NETHERRACK,
                Blocks.SOUL_SAND,
                Blocks.SOUL_SOIL
        );
        CinderscapesRegistry.register(registerable, DEAD_TREES, CinderscapesConfiguredFeatures.DEAD_TREE,
                CountOnEveryLayerPlacement.of(12),
                BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(Direction.DOWN.getUnitVec3i(), DEAD_TREE_SAFELIST)),
                BiomeFilter.biome()
        );

        /* BLACKSTONE SHALES */
        CinderscapesRegistry.register(registerable, WEEPING_VINES, CinderscapesConfiguredFeatures.WEEPING_VINE, CountOnEveryLayerPlacement.of(16), BiomeFilter.biome());
        CinderscapesRegistry.register(registerable, PATCH_CRIMSON_ROOTS, NetherFeatures.CRIMSON_ROOTS, CountOnEveryLayerPlacement.of(12), BiomeFilter.biome());

        CinderscapesRegistry.register(registerable, SHALES_SOUL_SAND, CinderscapesConfiguredFeatures.ASHY_SOUL_SAND, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64)), CountPlacement.of(10), InSquarePlacement.spread(), BiomeFilter.biome());
        CinderscapesRegistry.register(registerable, SHALES_SOUL_SOIL, CinderscapesConfiguredFeatures.ASHY_SOUL_SOIL, PlacementUtils.FULL_RANGE, CountPlacement.of(30), InSquarePlacement.spread(), BiomeFilter.biome());

        final List<Block> SHALE_SAFELIST = List.of(
                Blocks.BLACKSTONE,
                Blocks.CRIMSON_ROOTS,
                Blocks.NETHERRACK,
                Blocks.SOUL_SAND,
                Blocks.SOUL_SOIL
        );
        CinderscapesRegistry.register(registerable, SHALES, CinderscapesConfiguredFeatures.SHALE,
                CountOnEveryLayerPlacement.of(16),
                HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(12), VerticalAnchor.belowTop(20)),
                BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(Direction.DOWN.getUnitVec3i(), SHALE_SAFELIST)),
                BiomeFilter.biome()
        );

        /* LUMINOUS GROVE */
        CinderscapesRegistry.register(registerable, SHROOMLIGHT_BUSHES, CinderscapesConfiguredFeatures.SHROOMLIGHT_BUSH, CountOnEveryLayerPlacement.of(2), BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(Direction.DOWN.getUnitVec3i(), CinderscapesBlocks.UMBRAL_NYLIUM)), BiomeFilter.biome());
        CinderscapesRegistry.register(registerable, UMBRAL_VINES, CinderscapesConfiguredFeatures.UMBRAL_VINE, CountOnEveryLayerPlacement.of(5), BiomeFilter.biome());

        CinderscapesRegistry.register(registerable, LUMINOUS_VEGETATION, CinderscapesConfiguredFeatures.LUMINOUS_VEGETATION, CountOnEveryLayerPlacement.of(8), BiomeFilter.biome());
        CinderscapesRegistry.register(registerable, LUMINOUS_PODS, CinderscapesConfiguredFeatures.LUMINOUS_POD, CountOnEveryLayerPlacement.of(7), RarityFilter.onAverageOnceEvery(32), BiomeFilter.biome());
        CinderscapesRegistry.register(registerable, TALL_PHOTOFERNS, CinderscapesConfiguredFeatures.TALL_PHOTOFERN, CountOnEveryLayerPlacement.of(7), RarityFilter.onAverageOnceEvery(32), BiomeFilter.biome());

        final List<BlockState> CANOPIED_HUGE_FUNGUS_SAFELIST = List.of(
                CinderscapesBlocks.UMBRAL_NYLIUM.defaultBlockState(),
                Blocks.NETHERRACK.defaultBlockState()
        );
        CinderscapesRegistry.register(registerable, CANOPIED_HUGE_FUNGUS, CinderscapesConfiguredFeatures.CANOPIED_HUGE_FUNGUS,
                CountOnEveryLayerPlacement.of(8),
                new SafelistRangeFloorPlacementModifier(VerticalAnchor.aboveBottom(20), VerticalAnchor.belowTop(20), CANOPIED_HUGE_FUNGUS_SAFELIST),
                BiomeFilter.biome()
        );

        /* QUARTZ CAVERN */
        CinderscapesRegistry.register(registerable, QUARTZ_VEGETATION, CinderscapesConfiguredFeatures.QUARTZ_VEGETATION, CountOnEveryLayerPlacement.of(1), BiomeFilter.biome());

        CinderscapesRegistry.register(registerable, QUARTZ_ORE, CinderscapesConfiguredFeatures.QUARTZ_ORE, CountPlacement.of(32), InSquarePlacement.spread(), PlacementUtils.RANGE_10_10, BiomeFilter.biome());
        CinderscapesRegistry.register(registerable, SULFUR_QUARTZ_ORE, CinderscapesConfiguredFeatures.SULFUR_QUARTZ_ORE, CountPlacement.of(32), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
        CinderscapesRegistry.register(registerable, ROSE_QUARTZ_ORE, CinderscapesConfiguredFeatures.ROSE_QUARTZ_ORE, CountPlacement.of(32), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
        CinderscapesRegistry.register(registerable, SMOKY_QUARTZ_ORE, CinderscapesConfiguredFeatures.SMOKY_QUARTZ_ORE, CountPlacement.of(32), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
        CinderscapesRegistry.register(registerable, GOLD_ORE, CinderscapesConfiguredFeatures.GOLD_ORE, CountPlacement.of(20), PlacementUtils.RANGE_10_10, BiomeFilter.biome());
        CinderscapesRegistry.register(registerable, SULFUR_ORE, CinderscapesConfiguredFeatures.SULFUR_ORE, CountPlacement.of(16), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());

        final List<BlockState> SHARD_SAFELIST = List.of(
                Blocks.NETHERRACK.defaultBlockState(),
                Blocks.SOUL_SAND.defaultBlockState(),
                Blocks.NETHER_QUARTZ_ORE.defaultBlockState(),
                CinderscapesBlocks.ROSE_QUARTZ_ORE.defaultBlockState(),
                CinderscapesBlocks.SMOKY_QUARTZ_ORE.defaultBlockState(),
                CinderscapesBlocks.SULFUR_QUARTZ_ORE.defaultBlockState(),
                CinderscapesBlocks.SULFUR_ORE.defaultBlockState()
        );

        CinderscapesRegistry.register(registerable, CEILING_SHARD_QUARTZ, CinderscapesConfiguredFeatures.CEILING_SHARD_QUARTZ);
        CinderscapesRegistry.register(registerable, CEILING_SHARD_SULFUR_QUARTZ, CinderscapesConfiguredFeatures.CEILING_SHARD_SULFUR_QUARTZ);
        CinderscapesRegistry.register(registerable, CEILING_SHARD_ROSE_QUARTZ, CinderscapesConfiguredFeatures.CEILING_SHARD_ROSE_QUARTZ);
        CinderscapesRegistry.register(registerable, CEILING_SHARD_SMOKY_QUARTZ, CinderscapesConfiguredFeatures.CEILING_SHARD_SMOKY_QUARTZ);
        CinderscapesRegistry.register(registerable, CEILING_SHARDS, CinderscapesConfiguredFeatures.CEILING_SHARDS, PlacementUtils.countExtra(1, 0.5f, 1), new SafelistRangeCeilingPlacementModifier(VerticalAnchor.aboveBottom(20), VerticalAnchor.belowTop(20), SHARD_SAFELIST), BiomeFilter.biome());

        CinderscapesRegistry.register(registerable, FLOOR_SHARD_QUARTZ, CinderscapesConfiguredFeatures.FLOOR_SHARD_QUARTZ);
        CinderscapesRegistry.register(registerable, FLOOR_SHARD_SULFUR_QUARTZ, CinderscapesConfiguredFeatures.FLOOR_SHARD_SULFUR_QUARTZ);
        CinderscapesRegistry.register(registerable, FLOOR_SHARD_ROSE_QUARTZ, CinderscapesConfiguredFeatures.FLOOR_SHARD_ROSE_QUARTZ);
        CinderscapesRegistry.register(registerable, FLOOR_SHARD_SMOKY_QUARTZ, CinderscapesConfiguredFeatures.FLOOR_SHARD_SMOKY_QUARTZ);
        CinderscapesRegistry.register(registerable, FLOOR_SHARDS, CinderscapesConfiguredFeatures.FLOOR_SHARDS, PlacementUtils.countExtra(1, 0.5f, 1), new SafelistRangeFloorPlacementModifier(VerticalAnchor.aboveBottom(20), VerticalAnchor.belowTop(20), SHARD_SAFELIST), BiomeFilter.biome());

        CinderscapesRegistry.register(registerable, POLYPITE_QUARTZ, CinderscapesConfiguredFeatures.POLYPITE_QUARTZ, CountPlacement.of(128), PlacementUtils.RANGE_10_10, RandomOffsetPlacement.of(UniformInt.of(9, 15), UniformInt.of(4, 7)), BiomeFilter.biome());
        CinderscapesRegistry.register(registerable, POLYPITE_SULFUR_QUARTZ, CinderscapesConfiguredFeatures.POLYPITE_SULFUR_QUARTZ, CountPlacement.of(128), PlacementUtils.RANGE_10_10, RandomOffsetPlacement.of(UniformInt.of(9, 15), UniformInt.of(4, 7)), BiomeFilter.biome());
        CinderscapesRegistry.register(registerable, POLYPITE_ROSE_QUARTZ, CinderscapesConfiguredFeatures.POLYPITE_ROSE_QUARTZ, CountPlacement.of(128), PlacementUtils.RANGE_10_10, RandomOffsetPlacement.of(UniformInt.of(9, 15), UniformInt.of(4, 7)), BiomeFilter.biome());
        CinderscapesRegistry.register(registerable, POLYPITE_SMOKY_QUARTZ, CinderscapesConfiguredFeatures.POLYPITE_SMOKY_QUARTZ, CountPlacement.of(128), PlacementUtils.RANGE_10_10, RandomOffsetPlacement.of(UniformInt.of(9, 15), UniformInt.of(4, 7)), BiomeFilter.biome());
    }

    private static ResourceKey<PlacedFeature> createRegistryKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, name));
    }
}
