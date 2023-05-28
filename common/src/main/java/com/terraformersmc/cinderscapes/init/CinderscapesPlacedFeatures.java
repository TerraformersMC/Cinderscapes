package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.placementmodifier.SafelistRangeCeilingPlacementModifier;
import com.terraformersmc.cinderscapes.placementmodifier.SafelistRangeFloorPlacementModifier;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("UnstableApiUsage")
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

    private static final RegistryKey<PlacedFeature> CEILING_SHARD_QUARTZ = createRegistryKey("quartz_cavern/ceiling_shard_quartz");
    private static final RegistryKey<PlacedFeature> CEILING_SHARD_SULFUR_QUARTZ = createRegistryKey("quartz_cavern/ceiling_shard_sulfur_quartz");
    private static final RegistryKey<PlacedFeature> CEILING_SHARD_ROSE_QUARTZ = createRegistryKey("quartz_cavern/ceiling_shard_rose_quartz");
    private static final RegistryKey<PlacedFeature> CEILING_SHARD_SMOKY_QUARTZ = createRegistryKey("quartz_cavern/ceiling_shard_smoky_quartz");
    private static final RegistryKey<ConfiguredFeature<?, ?>> CEILING_SHARDS_CONFIGURED = CinderscapesConfiguredFeatures.createRegistryKey("quartz_cavern/ceiling_shards");
    public static final RegistryKey<PlacedFeature> CEILING_SHARDS = createRegistryKey("quartz_cavern/ceiling_shards");

    private static final RegistryKey<PlacedFeature> FLOOR_SHARD_QUARTZ = createRegistryKey("quartz_cavern/floor_shard_quartz");
    private static final RegistryKey<PlacedFeature> FLOOR_SHARD_SULFUR_QUARTZ = createRegistryKey("quartz_cavern/floor_shard_sulfur_quartz");
    private static final RegistryKey<PlacedFeature> FLOOR_SHARD_ROSE_QUARTZ = createRegistryKey("quartz_cavern/floor_shard_rose_quartz");
    private static final RegistryKey<PlacedFeature> FLOOR_SHARD_SMOKY_QUARTZ = createRegistryKey("quartz_cavern/floor_shard_smoky_quartz");
    private static final RegistryKey<ConfiguredFeature<?, ?>> FLOOR_SHARDS_CONFIGURED = CinderscapesConfiguredFeatures.createRegistryKey("quartz_cavern/floor_shards");
    public static final RegistryKey<PlacedFeature> FLOOR_SHARDS = createRegistryKey("quartz_cavern/floor_shards");

    public static final RegistryKey<PlacedFeature> POLYPITE_QUARTZ = createRegistryKey("quartz_cavern/polypite_quartz");
    public static final RegistryKey<PlacedFeature> POLYPITE_SULFUR_QUARTZ = createRegistryKey("quartz_cavern/polypite_sulfur_quartz");
    public static final RegistryKey<PlacedFeature> POLYPITE_ROSE_QUARTZ = createRegistryKey("quartz_cavern/polypite_rose_quartz");
    public static final RegistryKey<PlacedFeature> POLYPITE_SMOKY_QUARTZ = createRegistryKey("quartz_cavern/polypite_smoky_quartz");

    public static void populate(FabricDynamicRegistryProvider.Entries entries) {
        /* ASHY SHOALS */
        entries.add(DEBRIS_ORE_LARGE, placeFeature(entries, CinderscapesConfiguredFeatures.DEBRIS_ORE_LARGE, HeightRangePlacementModifier.trapezoid(YOffset.fixed(8), YOffset.fixed(24)), CountPlacementModifier.of(4), SquarePlacementModifier.of()));
        entries.add(DEBRIS_ORE_SMALL, placeFeature(entries, CinderscapesConfiguredFeatures.DEBRIS_ORE_SMALL, PlacedFeatures.EIGHT_ABOVE_AND_BELOW_RANGE, CountPlacementModifier.of(4), SquarePlacementModifier.of()));

        entries.add(ASH_PILES, placeFeature(entries, CinderscapesConfiguredFeatures.ASH_PILE, CountMultilayerPlacementModifier.of(2)));
        entries.add(ASHY_VEGETATION, placeFeature(entries, CinderscapesConfiguredFeatures.ASHY_VEGETATION, CountMultilayerPlacementModifier.of(16)));
        entries.add(BRAMBLE_BERRY_BUSHES, placeFeature(entries, CinderscapesConfiguredFeatures.BRAMBLE_BERRY_BUSHES, CountMultilayerPlacementModifier.of(1)));

        entries.add(ASHY_SOUL_SAND, placeFeature(entries, CinderscapesConfiguredFeatures.ASHY_SOUL_SAND, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64)), CountPlacementModifier.of(5), SquarePlacementModifier.of()));
        entries.add(ASHY_SOUL_SOIL, placeFeature(entries, CinderscapesConfiguredFeatures.ASHY_SOUL_SOIL, PlacedFeatures.BOTTOM_TO_TOP_RANGE, CountPlacementModifier.of(10), SquarePlacementModifier.of()));
        entries.add(ASHY_GRAVEL, placeFeature(entries, CinderscapesConfiguredFeatures.ASHY_GRAVEL, PlacedFeatures.BOTTOM_TO_TOP_RANGE, CountPlacementModifier.of(5), SquarePlacementModifier.of()));
        entries.add(ASH_TOP_LAYER, placeFeature(entries, CinderscapesConfiguredFeatures.ASH_TOP_LAYER));

        final List<Block> DEAD_TREE_SAFELIST = List.of(
                CinderscapesBlocks.ASH,
                Blocks.GRAVEL,
                Blocks.NETHERRACK,
                Blocks.SOUL_SAND,
                Blocks.SOUL_SOIL
        );
        entries.add(DEAD_TREES, placeFeature(entries, CinderscapesConfiguredFeatures.DEAD_TREE,
                CountMultilayerPlacementModifier.of(12),
                BlockFilterPlacementModifier.of(BlockPredicate.matchingBlocks(Direction.DOWN.getVector(), DEAD_TREE_SAFELIST))
        ));

        /* BLACKSTONE SHALES */
        entries.add(WEEPING_VINES, placeFeature(entries, CinderscapesConfiguredFeatures.WEEPING_VINE, CountMultilayerPlacementModifier.of(16)));
        entries.add(PATCH_CRIMSON_ROOTS, placeFeature(entries, NetherConfiguredFeatures.PATCH_CRIMSON_ROOTS, CountMultilayerPlacementModifier.of(12)));

        entries.add(SHALES_SOUL_SAND, placeFeature(entries, CinderscapesConfiguredFeatures.ASHY_SOUL_SAND, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64)), CountPlacementModifier.of(10), SquarePlacementModifier.of()));
        entries.add(SHALES_SOUL_SOIL, placeFeature(entries, CinderscapesConfiguredFeatures.ASHY_SOUL_SOIL, PlacedFeatures.BOTTOM_TO_TOP_RANGE, CountPlacementModifier.of(30), SquarePlacementModifier.of()));

        final List<Block> SHALE_SAFELIST = List.of(
                Blocks.BLACKSTONE,
                Blocks.CRIMSON_ROOTS,
                Blocks.NETHERRACK,
                Blocks.SOUL_SAND,
                Blocks.SOUL_SOIL
        );
        entries.add(SHALES, placeFeature(entries, CinderscapesConfiguredFeatures.SHALE,
                CountMultilayerPlacementModifier.of(16),
                HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(12), YOffset.belowTop(20)),
                BlockFilterPlacementModifier.of(BlockPredicate.matchingBlocks(Direction.DOWN.getVector(), SHALE_SAFELIST))
        ));

        /* LUMINOUS GROVE */
        entries.add(SHROOMLIGHT_BUSHES, placeFeature(entries, CinderscapesConfiguredFeatures.SHROOMLIGHT_BUSH, CountMultilayerPlacementModifier.of(2), BlockFilterPlacementModifier.of(BlockPredicate.matchingBlocks(Direction.DOWN.getVector(), CinderscapesBlocks.UMBRAL_NYLIUM))));
        entries.add(UMBRAL_VINES, placeFeature(entries, CinderscapesConfiguredFeatures.UMBRAL_VINE, CountMultilayerPlacementModifier.of(5)));

        entries.add(LUMINOUS_VEGETATION, placeFeature(entries, CinderscapesConfiguredFeatures.LUMINOUS_VEGETATION, CountMultilayerPlacementModifier.of(8)));
        entries.add(LUMINOUS_PODS, placeFeature(entries, CinderscapesConfiguredFeatures.LUMINOUS_POD, CountMultilayerPlacementModifier.of(7), RarityFilterPlacementModifier.of(32)));
        entries.add(TALL_PHOTOFERNS, placeFeature(entries, CinderscapesConfiguredFeatures.TALL_PHOTOFERN, CountMultilayerPlacementModifier.of(7), RarityFilterPlacementModifier.of(32)));

        final List<BlockState> CANOPIED_HUGE_FUNGUS_SAFELIST = List.of(
                CinderscapesBlocks.UMBRAL_NYLIUM.getDefaultState(),
                Blocks.NETHERRACK.getDefaultState()
        );
        entries.add(CANOPIED_HUGE_FUNGUS, placeFeature(entries, CinderscapesConfiguredFeatures.CANOPIED_HUGE_FUNGUS,
                CountMultilayerPlacementModifier.of(8),
                new SafelistRangeFloorPlacementModifier(YOffset.aboveBottom(20), YOffset.belowTop(20), CANOPIED_HUGE_FUNGUS_SAFELIST)
        ));

        /* QUARTZ CAVERN */
        entries.add(QUARTZ_VEGETATION, placeFeature(entries, CinderscapesConfiguredFeatures.QUARTZ_VEGETATION, CountMultilayerPlacementModifier.of(1)));

        entries.add(QUARTZ_ORE, placeFeature(entries, CinderscapesConfiguredFeatures.QUARTZ_ORE, CountPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE));
        entries.add(SULFUR_QUARTZ_ORE, placeFeature(entries, CinderscapesConfiguredFeatures.SULFUR_QUARTZ_ORE, CountPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_TOP_RANGE));
        entries.add(ROSE_QUARTZ_ORE, placeFeature(entries, CinderscapesConfiguredFeatures.ROSE_QUARTZ_ORE, CountPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_TOP_RANGE));
        entries.add(SMOKY_QUARTZ_ORE, placeFeature(entries, CinderscapesConfiguredFeatures.SMOKY_QUARTZ_ORE, CountPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_TOP_RANGE));
        entries.add(GOLD_ORE, placeFeature(entries, CinderscapesConfiguredFeatures.GOLD_ORE, CountPlacementModifier.of(20), PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE));
        entries.add(SULFUR_ORE, placeFeature(entries, CinderscapesConfiguredFeatures.SULFUR_ORE, CountPlacementModifier.of(16), SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_TOP_RANGE));

        final List<BlockState> SHARD_SAFELIST = List.of(
                Blocks.NETHERRACK.getDefaultState(),
                Blocks.SOUL_SAND.getDefaultState(),
                Blocks.NETHER_QUARTZ_ORE.getDefaultState(),
                CinderscapesBlocks.ROSE_QUARTZ_ORE.getDefaultState(),
                CinderscapesBlocks.SMOKY_QUARTZ_ORE.getDefaultState(),
                CinderscapesBlocks.SULFUR_QUARTZ_ORE.getDefaultState(),
                CinderscapesBlocks.SULFUR_ORE.getDefaultState()
        );

        entries.add(CEILING_SHARD_QUARTZ, placeFeatureWithoutBiomeFilter(entries, CinderscapesConfiguredFeatures.CEILING_SHARD_QUARTZ));
        entries.add(CEILING_SHARD_SULFUR_QUARTZ, placeFeatureWithoutBiomeFilter(entries, CinderscapesConfiguredFeatures.CEILING_SHARD_SULFUR_QUARTZ));
        entries.add(CEILING_SHARD_ROSE_QUARTZ, placeFeatureWithoutBiomeFilter(entries, CinderscapesConfiguredFeatures.CEILING_SHARD_ROSE_QUARTZ));
        entries.add(CEILING_SHARD_SMOKY_QUARTZ, placeFeatureWithoutBiomeFilter(entries, CinderscapesConfiguredFeatures.CEILING_SHARD_SMOKY_QUARTZ));
        entries.add(CEILING_SHARDS_CONFIGURED, CinderscapesConfiguredFeatures.configureFeature(
                Feature.SIMPLE_RANDOM_SELECTOR,
                new SimpleRandomFeatureConfig(
                        RegistryEntryList.of(
                                entries.ref(CEILING_SHARD_QUARTZ),
                                entries.ref(CEILING_SHARD_ROSE_QUARTZ),
                                entries.ref(CEILING_SHARD_SMOKY_QUARTZ),
                                entries.ref(CEILING_SHARD_SULFUR_QUARTZ)
                        )
                )
        ));
        entries.add(CEILING_SHARDS, placeFeature(entries, CEILING_SHARDS_CONFIGURED, PlacedFeatures.createCountExtraModifier(1, 0.5f, 1), new SafelistRangeCeilingPlacementModifier(YOffset.aboveBottom(20), YOffset.belowTop(20), SHARD_SAFELIST)));

        entries.add(FLOOR_SHARD_QUARTZ, placeFeatureWithoutBiomeFilter(entries, CinderscapesConfiguredFeatures.FLOOR_SHARD_QUARTZ));
        entries.add(FLOOR_SHARD_SULFUR_QUARTZ, placeFeatureWithoutBiomeFilter(entries, CinderscapesConfiguredFeatures.FLOOR_SHARD_SULFUR_QUARTZ));
        entries.add(FLOOR_SHARD_ROSE_QUARTZ, placeFeatureWithoutBiomeFilter(entries, CinderscapesConfiguredFeatures.FLOOR_SHARD_ROSE_QUARTZ));
        entries.add(FLOOR_SHARD_SMOKY_QUARTZ, placeFeatureWithoutBiomeFilter(entries, CinderscapesConfiguredFeatures.FLOOR_SHARD_SMOKY_QUARTZ));
        entries.add(FLOOR_SHARDS_CONFIGURED, CinderscapesConfiguredFeatures.configureFeature(
                Feature.SIMPLE_RANDOM_SELECTOR,
                new SimpleRandomFeatureConfig(
                        RegistryEntryList.of(
                                entries.ref(FLOOR_SHARD_QUARTZ),
                                entries.ref(FLOOR_SHARD_ROSE_QUARTZ),
                                entries.ref(FLOOR_SHARD_SMOKY_QUARTZ),
                                entries.ref(FLOOR_SHARD_SULFUR_QUARTZ)
                        )
                )
        ));
        entries.add(FLOOR_SHARDS, placeFeature(entries, FLOOR_SHARDS_CONFIGURED, PlacedFeatures.createCountExtraModifier(1, 0.5f, 1), new SafelistRangeFloorPlacementModifier(YOffset.aboveBottom(20), YOffset.belowTop(20), SHARD_SAFELIST)));

        entries.add(POLYPITE_QUARTZ, placeFeature(entries, CinderscapesConfiguredFeatures.POLYPITE_QUARTZ, CountPlacementModifier.of(128), PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE, RandomOffsetPlacementModifier.of(UniformIntProvider.create(9, 15), UniformIntProvider.create(4, 7))));
        entries.add(POLYPITE_SULFUR_QUARTZ, placeFeature(entries, CinderscapesConfiguredFeatures.POLYPITE_SULFUR_QUARTZ, CountPlacementModifier.of(128), PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE, RandomOffsetPlacementModifier.of(UniformIntProvider.create(9, 15), UniformIntProvider.create(4, 7))));
        entries.add(POLYPITE_ROSE_QUARTZ, placeFeature(entries, CinderscapesConfiguredFeatures.POLYPITE_ROSE_QUARTZ, CountPlacementModifier.of(128), PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE, RandomOffsetPlacementModifier.of(UniformIntProvider.create(9, 15), UniformIntProvider.create(4, 7))));
        entries.add(POLYPITE_SMOKY_QUARTZ, placeFeature(entries, CinderscapesConfiguredFeatures.POLYPITE_SMOKY_QUARTZ, CountPlacementModifier.of(128), PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE, RandomOffsetPlacementModifier.of(UniformIntProvider.create(9, 15), UniformIntProvider.create(4, 7))));
    }

    public static RegistryKey<PlacedFeature> createRegistryKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Cinderscapes.NAMESPACE, name));
    }

    private static PlacedFeature placeFeature(FabricDynamicRegistryProvider.Entries entries, RegistryKey<ConfiguredFeature<?, ?>> feature, PlacementModifier... placementModifiers) {
        List<PlacementModifier> list = new ArrayList<>(List.of(placementModifiers));
        list.add(BiomePlacementModifier.of());
        return placeFeature(entries, feature, list);

    }

    private static PlacedFeature placeFeatureWithoutBiomeFilter(FabricDynamicRegistryProvider.Entries entries, RegistryKey<ConfiguredFeature<?, ?>> feature, PlacementModifier... placementModifiers) {
        List<PlacementModifier> list = new ArrayList<>(List.of(placementModifiers));
        return placeFeature(entries, feature, list);
    }

    private static PlacedFeature placeFeature(FabricDynamicRegistryProvider.Entries entries, RegistryKey<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> list) {
        return new PlacedFeature(entries.ref(feature), list);
    }

    public static void init() {
        // This just creates the registry keys.  Placed Features are requested and consumed by datagen now.
    }
}
