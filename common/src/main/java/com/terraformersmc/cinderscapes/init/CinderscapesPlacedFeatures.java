package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.init.helpers.CinderscapesRegistry;
import com.terraformersmc.cinderscapes.placementmodifier.SafelistRangeCeilingPlacementModifier;
import com.terraformersmc.cinderscapes.placementmodifier.SafelistRangeFloorPlacementModifier;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

@SuppressWarnings("deprecation")
public class CinderscapesPlacedFeatures {
    /* ASHY SHOALS */
    public static final RegistryKey<PlacedFeature> DEBRIS_ORE_LARGE = createRegistryKey("ashy_shoals/debris_ore_large");
    public static final RegistryKey<PlacedFeature> DEBRIS_ORE_SMALL = createRegistryKey("ashy_shoals/debris_ore_small");

    public static final RegistryKey<PlacedFeature> ASH_PILES = createRegistryKey("ashy_shoals/ash_piles");
    public static final RegistryKey<PlacedFeature> ASHY_VEGETATION = createRegistryKey("ashy_shoals/vegetation");
    public static final RegistryKey<PlacedFeature> BRAMBLE_BERRY_BUSHES = createRegistryKey("ashy_shoals/bramble_berry_bushes");

    public static final RegistryKey<PlacedFeature> ASHY_SOUL_SAND = createRegistryKey("ashy_shoals/soul_sand");
    public static final RegistryKey<PlacedFeature> ASHY_SOUL_SOIL = createRegistryKey("ashy_shoals/soul_soil");
    public static final RegistryKey<PlacedFeature> ASHY_GRAVEL = createRegistryKey("ashy_shoals/gravel");
    public static final RegistryKey<PlacedFeature> ASH_TOP_LAYER = createRegistryKey("ashy_shoals/ash_top_layer");

    public static final RegistryKey<PlacedFeature> DEAD_TREES = createRegistryKey("ashy_shoals/dead_trees");

    /* BLACKSTONE SHALES */
    public static final RegistryKey<PlacedFeature> WEEPING_VINES = createRegistryKey("blackstone_shales/weeping_vines");
    public static final RegistryKey<PlacedFeature> PATCH_CRIMSON_ROOTS = createRegistryKey("blackstone_shales/patch_crimson_roots");

    public static final RegistryKey<PlacedFeature> SHALES_SOUL_SAND = createRegistryKey("blackstone_shales/soul_sand");
    public static final RegistryKey<PlacedFeature> SHALES_SOUL_SOIL = createRegistryKey("blackstone_shales/soul_soil");

    public static final RegistryKey<PlacedFeature> SHALES = createRegistryKey("blackstone_shales/shales");

    /* LUMINOUS GROVE */
    public static final RegistryKey<PlacedFeature> SHROOMLIGHT_BUSHES = createRegistryKey("luminous_grove/shroomlight_bushes");
    public static final RegistryKey<PlacedFeature> UMBRAL_VINES = createRegistryKey("luminous_grove/umbral_vines");

    public static final RegistryKey<PlacedFeature> LUMINOUS_VEGETATION = createRegistryKey("luminous_grove/vegetation");
    public static final RegistryKey<PlacedFeature> LUMINOUS_PODS = createRegistryKey("luminous_grove/luminous_pods");
    public static final RegistryKey<PlacedFeature> TALL_PHOTOFERNS = createRegistryKey("luminous_grove/tall_photoferns");

    public static final RegistryKey<PlacedFeature> CANOPIED_HUGE_FUNGUS = createRegistryKey("luminous_grove/canopied_huge_fungus");

    /* QUARTZ CAVERN */
    public static final RegistryKey<PlacedFeature> QUARTZ_VEGETATION = createRegistryKey("quartz_cavern/vegetation");

    public static final RegistryKey<PlacedFeature> QUARTZ_ORE = createRegistryKey("quartz_cavern/quartz_ore");
    public static final RegistryKey<PlacedFeature> SULFUR_QUARTZ_ORE = createRegistryKey("quartz_cavern/sulfur_quartz_ore");
    public static final RegistryKey<PlacedFeature> ROSE_QUARTZ_ORE = createRegistryKey("quartz_cavern/rose_quartz_ore");
    public static final RegistryKey<PlacedFeature> SMOKY_QUARTZ_ORE = createRegistryKey("quartz_cavern/smoky_quartz_ore");
    public static final RegistryKey<PlacedFeature> GOLD_ORE = createRegistryKey("quartz_cavern/gold_ore");
    public static final RegistryKey<PlacedFeature> SULFUR_ORE = createRegistryKey("quartz_cavern/sulfur_ore");

    public static final RegistryKey<PlacedFeature> CEILING_SHARD_QUARTZ = createRegistryKey("quartz_cavern/ceiling_shard_quartz");
    public static final RegistryKey<PlacedFeature> CEILING_SHARD_SULFUR_QUARTZ = createRegistryKey("quartz_cavern/ceiling_shard_sulfur_quartz");
    public static final RegistryKey<PlacedFeature> CEILING_SHARD_ROSE_QUARTZ = createRegistryKey("quartz_cavern/ceiling_shard_rose_quartz");
    public static final RegistryKey<PlacedFeature> CEILING_SHARD_SMOKY_QUARTZ = createRegistryKey("quartz_cavern/ceiling_shard_smoky_quartz");
    public static final RegistryKey<PlacedFeature> CEILING_SHARDS = createRegistryKey("quartz_cavern/ceiling_shards");

    public static final RegistryKey<PlacedFeature> FLOOR_SHARD_QUARTZ = createRegistryKey("quartz_cavern/floor_shard_quartz");
    public static final RegistryKey<PlacedFeature> FLOOR_SHARD_SULFUR_QUARTZ = createRegistryKey("quartz_cavern/floor_shard_sulfur_quartz");
    public static final RegistryKey<PlacedFeature> FLOOR_SHARD_ROSE_QUARTZ = createRegistryKey("quartz_cavern/floor_shard_rose_quartz");
    public static final RegistryKey<PlacedFeature> FLOOR_SHARD_SMOKY_QUARTZ = createRegistryKey("quartz_cavern/floor_shard_smoky_quartz");
    public static final RegistryKey<PlacedFeature> FLOOR_SHARDS = createRegistryKey("quartz_cavern/floor_shards");

    public static final RegistryKey<PlacedFeature> POLYPITE_QUARTZ = createRegistryKey("quartz_cavern/polypite_quartz");
    public static final RegistryKey<PlacedFeature> POLYPITE_SULFUR_QUARTZ = createRegistryKey("quartz_cavern/polypite_sulfur_quartz");
    public static final RegistryKey<PlacedFeature> POLYPITE_ROSE_QUARTZ = createRegistryKey("quartz_cavern/polypite_rose_quartz");
    public static final RegistryKey<PlacedFeature> POLYPITE_SMOKY_QUARTZ = createRegistryKey("quartz_cavern/polypite_smoky_quartz");

    public static void bootstrap(Registerable<PlacedFeature> registerable) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> configuredFeatures = registerable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        /* ASHY SHOALS */
        CinderscapesRegistry.register(registerable, DEBRIS_ORE_LARGE, CinderscapesConfiguredFeatures.DEBRIS_ORE_LARGE, HeightRangePlacementModifier.trapezoid(YOffset.fixed(8), YOffset.fixed(24)), CountPlacementModifier.of(4), SquarePlacementModifier.of(), BiomePlacementModifier.of());
        CinderscapesRegistry.register(registerable, DEBRIS_ORE_SMALL, CinderscapesConfiguredFeatures.DEBRIS_ORE_SMALL, PlacedFeatures.EIGHT_ABOVE_AND_BELOW_RANGE, CountPlacementModifier.of(4), SquarePlacementModifier.of(), BiomePlacementModifier.of());

        CinderscapesRegistry.register(registerable, ASH_PILES, CinderscapesConfiguredFeatures.ASH_PILE, CountMultilayerPlacementModifier.of(2), BiomePlacementModifier.of());
        CinderscapesRegistry.register(registerable, ASHY_VEGETATION, CinderscapesConfiguredFeatures.ASHY_VEGETATION, CountMultilayerPlacementModifier.of(16), BiomePlacementModifier.of());
        CinderscapesRegistry.register(registerable, BRAMBLE_BERRY_BUSHES, CinderscapesConfiguredFeatures.BRAMBLE_BERRY_BUSHES, CountMultilayerPlacementModifier.of(1), BiomePlacementModifier.of());

        CinderscapesRegistry.register(registerable, ASHY_SOUL_SAND, CinderscapesConfiguredFeatures.ASHY_SOUL_SAND, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64)), CountPlacementModifier.of(5), SquarePlacementModifier.of(), BiomePlacementModifier.of());
        CinderscapesRegistry.register(registerable, ASHY_SOUL_SOIL, CinderscapesConfiguredFeatures.ASHY_SOUL_SOIL, PlacedFeatures.BOTTOM_TO_TOP_RANGE, CountPlacementModifier.of(10), SquarePlacementModifier.of(), BiomePlacementModifier.of());
        CinderscapesRegistry.register(registerable, ASHY_GRAVEL, CinderscapesConfiguredFeatures.ASHY_GRAVEL, PlacedFeatures.BOTTOM_TO_TOP_RANGE, CountPlacementModifier.of(5), SquarePlacementModifier.of(), BiomePlacementModifier.of());
        CinderscapesRegistry.register(registerable, ASH_TOP_LAYER, CinderscapesConfiguredFeatures.ASH_TOP_LAYER, BiomePlacementModifier.of());

        final List<Block> DEAD_TREE_SAFELIST = List.of(
                CinderscapesBlocks.ASH,
                Blocks.GRAVEL,
                Blocks.NETHERRACK,
                Blocks.SOUL_SAND,
                Blocks.SOUL_SOIL
        );
        CinderscapesRegistry.register(registerable, DEAD_TREES, CinderscapesConfiguredFeatures.DEAD_TREE,
                CountMultilayerPlacementModifier.of(12),
                BlockFilterPlacementModifier.of(BlockPredicate.matchingBlocks(Direction.DOWN.getVector(), DEAD_TREE_SAFELIST)),
                BiomePlacementModifier.of()
        );

        /* BLACKSTONE SHALES */
        CinderscapesRegistry.register(registerable, WEEPING_VINES, CinderscapesConfiguredFeatures.WEEPING_VINE, CountMultilayerPlacementModifier.of(16), BiomePlacementModifier.of());
        CinderscapesRegistry.register(registerable, PATCH_CRIMSON_ROOTS, NetherConfiguredFeatures.PATCH_CRIMSON_ROOTS, CountMultilayerPlacementModifier.of(12), BiomePlacementModifier.of());

        CinderscapesRegistry.register(registerable, SHALES_SOUL_SAND, CinderscapesConfiguredFeatures.ASHY_SOUL_SAND, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64)), CountPlacementModifier.of(10), SquarePlacementModifier.of(), BiomePlacementModifier.of());
        CinderscapesRegistry.register(registerable, SHALES_SOUL_SOIL, CinderscapesConfiguredFeatures.ASHY_SOUL_SOIL, PlacedFeatures.BOTTOM_TO_TOP_RANGE, CountPlacementModifier.of(30), SquarePlacementModifier.of(), BiomePlacementModifier.of());

        final List<Block> SHALE_SAFELIST = List.of(
                Blocks.BLACKSTONE,
                Blocks.CRIMSON_ROOTS,
                Blocks.NETHERRACK,
                Blocks.SOUL_SAND,
                Blocks.SOUL_SOIL
        );
        CinderscapesRegistry.register(registerable, SHALES, CinderscapesConfiguredFeatures.SHALE,
                CountMultilayerPlacementModifier.of(16),
                HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(12), YOffset.belowTop(20)),
                BlockFilterPlacementModifier.of(BlockPredicate.matchingBlocks(Direction.DOWN.getVector(), SHALE_SAFELIST)),
                BiomePlacementModifier.of()
        );

        /* LUMINOUS GROVE */
        CinderscapesRegistry.register(registerable, SHROOMLIGHT_BUSHES, CinderscapesConfiguredFeatures.SHROOMLIGHT_BUSH, CountMultilayerPlacementModifier.of(2), BlockFilterPlacementModifier.of(BlockPredicate.matchingBlocks(Direction.DOWN.getVector(), CinderscapesBlocks.UMBRAL_NYLIUM)), BiomePlacementModifier.of());
        CinderscapesRegistry.register(registerable, UMBRAL_VINES, CinderscapesConfiguredFeatures.UMBRAL_VINE, CountMultilayerPlacementModifier.of(5), BiomePlacementModifier.of());

        CinderscapesRegistry.register(registerable, LUMINOUS_VEGETATION, CinderscapesConfiguredFeatures.LUMINOUS_VEGETATION, CountMultilayerPlacementModifier.of(8), BiomePlacementModifier.of());
        CinderscapesRegistry.register(registerable, LUMINOUS_PODS, CinderscapesConfiguredFeatures.LUMINOUS_POD, CountMultilayerPlacementModifier.of(7), RarityFilterPlacementModifier.of(32), BiomePlacementModifier.of());
        CinderscapesRegistry.register(registerable, TALL_PHOTOFERNS, CinderscapesConfiguredFeatures.TALL_PHOTOFERN, CountMultilayerPlacementModifier.of(7), RarityFilterPlacementModifier.of(32), BiomePlacementModifier.of());

        final List<BlockState> CANOPIED_HUGE_FUNGUS_SAFELIST = List.of(
                CinderscapesBlocks.UMBRAL_NYLIUM.getDefaultState(),
                Blocks.NETHERRACK.getDefaultState()
        );
        CinderscapesRegistry.register(registerable, CANOPIED_HUGE_FUNGUS, CinderscapesConfiguredFeatures.CANOPIED_HUGE_FUNGUS,
                CountMultilayerPlacementModifier.of(8),
                new SafelistRangeFloorPlacementModifier(YOffset.aboveBottom(20), YOffset.belowTop(20), CANOPIED_HUGE_FUNGUS_SAFELIST),
                BiomePlacementModifier.of()
        );

        /* QUARTZ CAVERN */
        CinderscapesRegistry.register(registerable, QUARTZ_VEGETATION, CinderscapesConfiguredFeatures.QUARTZ_VEGETATION, CountMultilayerPlacementModifier.of(1), BiomePlacementModifier.of());

        CinderscapesRegistry.register(registerable, QUARTZ_ORE, CinderscapesConfiguredFeatures.QUARTZ_ORE, CountPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE, BiomePlacementModifier.of());
        CinderscapesRegistry.register(registerable, SULFUR_QUARTZ_ORE, CinderscapesConfiguredFeatures.SULFUR_QUARTZ_ORE, CountPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_TOP_RANGE, BiomePlacementModifier.of());
        CinderscapesRegistry.register(registerable, ROSE_QUARTZ_ORE, CinderscapesConfiguredFeatures.ROSE_QUARTZ_ORE, CountPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_TOP_RANGE, BiomePlacementModifier.of());
        CinderscapesRegistry.register(registerable, SMOKY_QUARTZ_ORE, CinderscapesConfiguredFeatures.SMOKY_QUARTZ_ORE, CountPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_TOP_RANGE, BiomePlacementModifier.of());
        CinderscapesRegistry.register(registerable, GOLD_ORE, CinderscapesConfiguredFeatures.GOLD_ORE, CountPlacementModifier.of(20), PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE, BiomePlacementModifier.of());
        CinderscapesRegistry.register(registerable, SULFUR_ORE, CinderscapesConfiguredFeatures.SULFUR_ORE, CountPlacementModifier.of(16), SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_TOP_RANGE, BiomePlacementModifier.of());

        final List<BlockState> SHARD_SAFELIST = List.of(
                Blocks.NETHERRACK.getDefaultState(),
                Blocks.SOUL_SAND.getDefaultState(),
                Blocks.NETHER_QUARTZ_ORE.getDefaultState(),
                CinderscapesBlocks.ROSE_QUARTZ_ORE.getDefaultState(),
                CinderscapesBlocks.SMOKY_QUARTZ_ORE.getDefaultState(),
                CinderscapesBlocks.SULFUR_QUARTZ_ORE.getDefaultState(),
                CinderscapesBlocks.SULFUR_ORE.getDefaultState()
        );

        CinderscapesRegistry.register(registerable, CEILING_SHARD_QUARTZ, CinderscapesConfiguredFeatures.CEILING_SHARD_QUARTZ);
        CinderscapesRegistry.register(registerable, CEILING_SHARD_SULFUR_QUARTZ, CinderscapesConfiguredFeatures.CEILING_SHARD_SULFUR_QUARTZ);
        CinderscapesRegistry.register(registerable, CEILING_SHARD_ROSE_QUARTZ, CinderscapesConfiguredFeatures.CEILING_SHARD_ROSE_QUARTZ);
        CinderscapesRegistry.register(registerable, CEILING_SHARD_SMOKY_QUARTZ, CinderscapesConfiguredFeatures.CEILING_SHARD_SMOKY_QUARTZ);
        CinderscapesRegistry.register(registerable, CEILING_SHARDS, CinderscapesConfiguredFeatures.CEILING_SHARDS, PlacedFeatures.createCountExtraModifier(1, 0.5f, 1), new SafelistRangeCeilingPlacementModifier(YOffset.aboveBottom(20), YOffset.belowTop(20), SHARD_SAFELIST), BiomePlacementModifier.of());

        CinderscapesRegistry.register(registerable, FLOOR_SHARD_QUARTZ, CinderscapesConfiguredFeatures.FLOOR_SHARD_QUARTZ);
        CinderscapesRegistry.register(registerable, FLOOR_SHARD_SULFUR_QUARTZ, CinderscapesConfiguredFeatures.FLOOR_SHARD_SULFUR_QUARTZ);
        CinderscapesRegistry.register(registerable, FLOOR_SHARD_ROSE_QUARTZ, CinderscapesConfiguredFeatures.FLOOR_SHARD_ROSE_QUARTZ);
        CinderscapesRegistry.register(registerable, FLOOR_SHARD_SMOKY_QUARTZ, CinderscapesConfiguredFeatures.FLOOR_SHARD_SMOKY_QUARTZ);
        CinderscapesRegistry.register(registerable, FLOOR_SHARDS, CinderscapesConfiguredFeatures.FLOOR_SHARDS, PlacedFeatures.createCountExtraModifier(1, 0.5f, 1), new SafelistRangeFloorPlacementModifier(YOffset.aboveBottom(20), YOffset.belowTop(20), SHARD_SAFELIST), BiomePlacementModifier.of());

        CinderscapesRegistry.register(registerable, POLYPITE_QUARTZ, CinderscapesConfiguredFeatures.POLYPITE_QUARTZ, CountPlacementModifier.of(128), PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE, RandomOffsetPlacementModifier.of(UniformIntProvider.create(9, 15), UniformIntProvider.create(4, 7)), BiomePlacementModifier.of());
        CinderscapesRegistry.register(registerable, POLYPITE_SULFUR_QUARTZ, CinderscapesConfiguredFeatures.POLYPITE_SULFUR_QUARTZ, CountPlacementModifier.of(128), PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE, RandomOffsetPlacementModifier.of(UniformIntProvider.create(9, 15), UniformIntProvider.create(4, 7)), BiomePlacementModifier.of());
        CinderscapesRegistry.register(registerable, POLYPITE_ROSE_QUARTZ, CinderscapesConfiguredFeatures.POLYPITE_ROSE_QUARTZ, CountPlacementModifier.of(128), PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE, RandomOffsetPlacementModifier.of(UniformIntProvider.create(9, 15), UniformIntProvider.create(4, 7)), BiomePlacementModifier.of());
        CinderscapesRegistry.register(registerable, POLYPITE_SMOKY_QUARTZ, CinderscapesConfiguredFeatures.POLYPITE_SMOKY_QUARTZ, CountPlacementModifier.of(128), PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE, RandomOffsetPlacementModifier.of(UniformIntProvider.create(9, 15), UniformIntProvider.create(4, 7)), BiomePlacementModifier.of());
    }

    private static RegistryKey<PlacedFeature> createRegistryKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Cinderscapes.MOD_ID, name));
    }
}
