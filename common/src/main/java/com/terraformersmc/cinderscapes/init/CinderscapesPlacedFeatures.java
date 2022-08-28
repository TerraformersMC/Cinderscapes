package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.placementmodifier.SafelistRangeCeilingPlacementModifier;
import com.terraformersmc.cinderscapes.placementmodifier.SafelistRangeFloorPlacementModifier;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryEntryList;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CinderscapesPlacedFeatures {

    public static final List<BlockState> SHARED_SAFELIST = List.of(
            Blocks.NETHERRACK.getDefaultState(),
            Blocks.SOUL_SAND.getDefaultState(),
            Blocks.NETHER_QUARTZ_ORE.getDefaultState(),
            CinderscapesBlocks.ROSE_QUARTZ_ORE.getDefaultState(),
            CinderscapesBlocks.SMOKY_QUARTZ_ORE.getDefaultState(),
            CinderscapesBlocks.SULFUR_QUARTZ_ORE.getDefaultState(),
            CinderscapesBlocks.SULFUR_ORE.getDefaultState()
    );

    /******* ASHY SHOALS *********/
    public static final RegistryEntry<PlacedFeature> ORE_DEBRIS_LARGE_ASHY_SHOALS = createPlacedFeature("ore_debris_large_ashy_shoals", CinderscapesConfiguredFeatures.ORE_DEBRIS_LARGE_ASHY_SHOALS, HeightRangePlacementModifier.trapezoid(YOffset.fixed(8), YOffset.fixed(24)), CountPlacementModifier.of(4), SquarePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> ORE_DEBRIS_SMALL_ASHY_SHOALS = createPlacedFeature("ore_debris_small_ashy_shoals", CinderscapesConfiguredFeatures.ORE_DEBRIS_SMALL_ASHY_SHOALS, PlacedFeatures.EIGHT_ABOVE_AND_BELOW_RANGE, CountPlacementModifier.of(4), SquarePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> ASH_PILES = createPlacedFeature("ash_piles", CinderscapesConfiguredFeatures.ASH_PILES, CountMultilayerPlacementModifier.of(2));
    public static final RegistryEntry<PlacedFeature> VEGETATION_ASHY_SHOALS = createPlacedFeature("vegetation_ashy_shoals", CinderscapesConfiguredFeatures.VEGETATION_ASHY_SHOALS, CountMultilayerPlacementModifier.of(16));
    public static final RegistryEntry<PlacedFeature> BRAMBLE_BERRY_BUSHES = createPlacedFeature("bramble_berry_bushes", CinderscapesConfiguredFeatures.BRAMBLE_BERRY_BUSHES, CountMultilayerPlacementModifier.of(1));

    public static final RegistryEntry<PlacedFeature> SOUL_SAND_ASHY_SHOALS = createPlacedFeature("soul_sand_ashy_shoals", CinderscapesConfiguredFeatures.SOUL_SAND_ASHY_SHOALS, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64)), CountPlacementModifier.of(5), SquarePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> SOUL_SOIL_ASHY_SHOALS = createPlacedFeature("soul_soil_ashy_shoals", CinderscapesConfiguredFeatures.SOUL_SOIL_ASHY_SHOALS, PlacedFeatures.BOTTOM_TO_TOP_RANGE, CountPlacementModifier.of(10), SquarePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> GRAVEL_ASHY_SHOALS = createPlacedFeature("gravel_ashy_shoals", CinderscapesConfiguredFeatures.GRAVEL_ASHY_SHOALS, PlacedFeatures.BOTTOM_TO_TOP_RANGE, CountPlacementModifier.of(5), SquarePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> ASH_TOP_LAYER = createPlacedFeature("ash_top_layer", CinderscapesConfiguredFeatures.ASH_TOP_LAYER);
    private static final List<Block> DEAD_TREE_SAFELIST = Arrays.asList(
            Blocks.NETHERRACK, Blocks.GRAVEL,
            CinderscapesBlocks.ASH,
            Blocks.SOUL_SAND,
            Blocks.SOUL_SOIL
    );
    public static final RegistryEntry<PlacedFeature> DEAD_TREES = createPlacedFeature("dead_trees", CinderscapesConfiguredFeatures.DEAD_TREE,
            CountMultilayerPlacementModifier.of(12),
            BlockFilterPlacementModifier.of(BlockPredicate.matchingBlocks(DEAD_TREE_SAFELIST, Direction.DOWN.getVector()))
    );

    /******* BLACKSTONE SHALES *********/
    public static final RegistryEntry<PlacedFeature> BLACKSTONE_SHALE_WEEPING_VINES = createPlacedFeature("blackstone_shales_weeping_vine", CinderscapesConfiguredFeatures.BLACKSTONE_SHALE_WEEPING_VINES, CountMultilayerPlacementModifier.of(16));
    public static final RegistryEntry<PlacedFeature> SOUL_SAND_BLACKSTONE_SHALES = createPlacedFeature("soul_sand_blackstone_shales", CinderscapesConfiguredFeatures.SOUL_SAND_ASHY_SHOALS, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64)), CountPlacementModifier.of(10), SquarePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> SOUL_SOIL_BLACKSTONE_SHALES = createPlacedFeature("soul_soil_blackstone_shales", CinderscapesConfiguredFeatures.SOUL_SOIL_ASHY_SHOALS, PlacedFeatures.BOTTOM_TO_TOP_RANGE, CountPlacementModifier.of(30), SquarePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> PATCH_CRIMSON_ROOTS = createPlacedFeature("patch_crimson_roots_blackstone_shales", NetherConfiguredFeatures.PATCH_CRIMSON_ROOTS, CountMultilayerPlacementModifier.of(12));

    public static final List<Block> SHALE_SAFELIST = List.of(Blocks.CRIMSON_ROOTS, Blocks.NETHERRACK, Blocks.BLACKSTONE, Blocks.SOUL_SOIL, Blocks.SOUL_SAND);
    public static final RegistryEntry<PlacedFeature> SHALES = createPlacedFeature("shales", CinderscapesConfiguredFeatures.BLACKSTONE_SHALES,
            CountMultilayerPlacementModifier.of(10), SquarePlacementModifier.of(),
            HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(12), YOffset.belowTop(20)),
            BlockFilterPlacementModifier.of(BlockPredicate.matchingBlocks(SHALE_SAFELIST, Direction.DOWN.getVector()))
    );


    /******* LUMINOUS GROVE *********/
    public static final RegistryEntry<PlacedFeature> SHROOMLIGHT_BUSH = createPlacedFeature("luminous_grove/shroomlight_bush", CinderscapesConfiguredFeatures.SHROOMLIGHT_BUSH, CountMultilayerPlacementModifier.of(2), BlockFilterPlacementModifier.of(BlockPredicate.matchingBlock(CinderscapesBlocks.UMBRAL_NYLIUM, Direction.DOWN.getVector())));
    public static final RegistryEntry<PlacedFeature> VEGETATION_LUMINOUS_GROWTH = createPlacedFeature("luminous_growth/vegetation", CinderscapesConfiguredFeatures.VEGETATION_LUMINOUS_GROWTH, CountMultilayerPlacementModifier.of(8));
    public static final RegistryEntry<PlacedFeature> LUMINOUS_POD = createPlacedFeature("luminous_growth/luminous_pod", CinderscapesConfiguredFeatures.LUMINOUS_POD, CountMultilayerPlacementModifier.of(7), RarityFilterPlacementModifier.of(32));
    public static final RegistryEntry<PlacedFeature> TALL_PHOTOFERN = createPlacedFeature("luminous_growth/tall_photofern", CinderscapesConfiguredFeatures.TALL_PHOTOFERN, CountMultilayerPlacementModifier.of(7), RarityFilterPlacementModifier.of(32));
    public static final RegistryEntry<PlacedFeature> UMBRAL_VINE = createPlacedFeature("luminous_growth/umbral_vine", CinderscapesConfiguredFeatures.UMBRAL_VINE, CountMultilayerPlacementModifier.of(5));
    public static final RegistryEntry<PlacedFeature> CANOPIED_HUGE_FUNGUS = createPlacedFeatureStrict("luminous_growth/canopied_huge_fungus", CinderscapesConfiguredFeatures.CANOPIED_HUGE_FUNGUS,
            CountMultilayerPlacementModifier.of(8),
            new SafelistRangeFloorPlacementModifier(YOffset.aboveBottom(20), YOffset.belowTop(20),
                    CinderscapesConfiguredFeatures.CANOPIED_HUGE_FUNGUS_SAFELIST)
    );


    /******* QUARTZ CAVERN *******/
    public static final RegistryEntry<PlacedFeature> VEGETATION_QUARTZ_CAVERN = createPlacedFeature("quartz_cavern/vegetation", CinderscapesConfiguredFeatures.VEGETATION_QUARTZ_CAVERN, CountMultilayerPlacementModifier.of(1));
    public static final RegistryEntry<PlacedFeature> ORE_QUARTZ_QUARTZ_CAVERN = createPlacedFeature("quartz_cavern/quartz_ore", CinderscapesConfiguredFeatures.ORE_QUARTZ_QUARTZ_CAVERN, CountPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE);
    public static final RegistryEntry<PlacedFeature> ORE_SULFUR_QUARTZ_CAVERN = createPlacedFeature("quartz_cavern/sulfur_ore", CinderscapesConfiguredFeatures.ORE_SULFUR_QUARTZ_CAVERN, CountPlacementModifier.of(16), SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_TOP_RANGE);
    public static final RegistryEntry<PlacedFeature> ORE_GOLD_QUARTZ_CAVERN = createPlacedFeature("quartz_cavern/gold_ore", CinderscapesConfiguredFeatures.ORE_GOLD_QUARTZ_CAVERN, CountPlacementModifier.of(20), PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE);
    public static final RegistryEntry<PlacedFeature> ORE_SMOKY_QUARTZ_QUARTZ_CAVERN = createPlacedFeature("quartz_cavern/smoky_quartz_ore", CinderscapesConfiguredFeatures.ORE_SMOKY_QUARTZ_QUARTZ_CAVERN, CountPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_TOP_RANGE);
    public static final RegistryEntry<PlacedFeature> ORE_ROSE_QUARTZ_QUARTZ_CAVERN = createPlacedFeature("quartz_cavern/rose_quartz_ore", CinderscapesConfiguredFeatures.ORE_ROSE_QUARTZ_QUARTZ_CAVERN, CountPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_TOP_RANGE);
    public static final RegistryEntry<PlacedFeature> ORE_SULFUR_QUARTZ_QUARTZ_CAVERN = createPlacedFeature("quartz_cavern/sulfur_quartz_ore", CinderscapesConfiguredFeatures.ORE_SULFUR_QUARTZ_QUARTZ_CAVERN, CountPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_TOP_RANGE);

    private static final RegistryEntry<ConfiguredFeature<SimpleRandomFeatureConfig, ?>> CEILING_SHARDS_CONFIGURED = CinderscapesConfiguredFeatures.register("quartz_cavern/ceiling_shards", Feature.SIMPLE_RANDOM_SELECTOR,
            new SimpleRandomFeatureConfig(RegistryEntryList.of(
                    createPlacedFeatureWithoutBiomeFilter("quartz_cavern/shard_quartz_ceiling", CinderscapesConfiguredFeatures.SHARD_QUARTZ_CEILING),
                    createPlacedFeatureWithoutBiomeFilter("quartz_cavern/shard_rose_quartz_ceiling", CinderscapesConfiguredFeatures.SHARD_ROSE_QUARTZ_CEILING),
                    createPlacedFeatureWithoutBiomeFilter("quartz_cavern/shard_smoky_quartz_ceiling", CinderscapesConfiguredFeatures.SHARD_SMOKY_QUARTZ_CEILING),
                    createPlacedFeatureWithoutBiomeFilter("quartz_cavern/shard_sulfur_quartz_ceiling", CinderscapesConfiguredFeatures.SHARD_SULFUR_QUARTZ_CEILING)
            )));
    public static final RegistryEntry<PlacedFeature> CEILING_SHARDS = createPlacedFeature("quartz_cavern/ceiling_shards", CEILING_SHARDS_CONFIGURED, PlacedFeatures.createCountExtraModifier(1, 0.5f, 1), new SafelistRangeCeilingPlacementModifier(YOffset.aboveBottom(20), YOffset.belowTop(20), SHARED_SAFELIST));

    private static final RegistryEntry<ConfiguredFeature<SimpleRandomFeatureConfig, ?>> FLOOR_SHARDS_CONFIGURED = CinderscapesConfiguredFeatures.register("quartz_cavern/floor_shards", Feature.SIMPLE_RANDOM_SELECTOR,
            new SimpleRandomFeatureConfig(RegistryEntryList.of(
                    createPlacedFeatureWithoutBiomeFilter("quartz_cavern/shard_quartz_floor", CinderscapesConfiguredFeatures.SHARD_QUARTZ_FLOOR),
                    createPlacedFeatureWithoutBiomeFilter("quartz_cavern/shard_rose_quartz_floor", CinderscapesConfiguredFeatures.SHARD_ROSE_QUARTZ_FLOOR),
                    createPlacedFeatureWithoutBiomeFilter("quartz_cavern/shard_smoky_quartz_floor", CinderscapesConfiguredFeatures.SHARD_SMOKY_QUARTZ_FLOOR),
                    createPlacedFeatureWithoutBiomeFilter("quartz_cavern/shard_sulfur_quartz_floor", CinderscapesConfiguredFeatures.SHARD_SULFUR_QUARTZ_FLOOR)
            )));
    public static final RegistryEntry<PlacedFeature> FLOOR_SHARDS = createPlacedFeature("quartz_cavern/floor_shards", FLOOR_SHARDS_CONFIGURED, PlacedFeatures.createCountExtraModifier(1, 0.5f, 1), new SafelistRangeFloorPlacementModifier(YOffset.aboveBottom(20), YOffset.belowTop(20), SHARED_SAFELIST));

    public static final RegistryEntry<PlacedFeature> POLYPITE_QUARTZ = createPlacedFeature("quartz_cavern/polypite_quartz", CinderscapesConfiguredFeatures.POLYPITE_QUARTZ, CountPlacementModifier.of(128), PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE, RandomOffsetPlacementModifier.of(UniformIntProvider.create(9, 15), UniformIntProvider.create(4, 7)));
    public static final RegistryEntry<PlacedFeature> POLYPITE_SULFUR_QUARTZ = createPlacedFeature("quartz_cavern/polypite_sulfur_quartz", CinderscapesConfiguredFeatures.POLYPITE_SULFUR_QUARTZ, CountPlacementModifier.of(128), PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE, RandomOffsetPlacementModifier.of(UniformIntProvider.create(9, 15), UniformIntProvider.create(4, 7)));
    public static final RegistryEntry<PlacedFeature> POLYPITE_ROSE_QUARTZ = createPlacedFeature("quartz_cavern/polypite_rose_quartz", CinderscapesConfiguredFeatures.POLYPITE_ROSE_QUARTZ, CountPlacementModifier.of(128), PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE, RandomOffsetPlacementModifier.of(UniformIntProvider.create(9, 15), UniformIntProvider.create(4, 7)));
    public static final RegistryEntry<PlacedFeature> POLYPITE_SMOKY_QUARTZ = createPlacedFeature("quartz_cavern/polypite_smoky_quartz", CinderscapesConfiguredFeatures.POLYPITE_SMOKY_QUARTZ, CountPlacementModifier.of(128), PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE, RandomOffsetPlacementModifier.of(UniformIntProvider.create(9, 15), UniformIntProvider.create(4, 7)));

    public static <FC extends FeatureConfig> RegistryEntry<PlacedFeature> createPlacedFeature(String id, RegistryEntry<ConfiguredFeature<FC, ?>> feature, PlacementModifier... placementModifiers) {
        List<PlacementModifier> list = new ArrayList<>(List.of(placementModifiers));
        list.add(BiomePlacementModifier.of());
        return createPlacedFeature(id, feature, list);
    }

    public static <FC extends FeatureConfig> RegistryEntry<PlacedFeature> createPlacedFeatureWithoutBiomeFilter(String id, RegistryEntry<ConfiguredFeature<FC, ?>> feature, PlacementModifier... placementModifiers) {
        List<PlacementModifier> list = new ArrayList<>(List.of(placementModifiers));
        return createPlacedFeature(id, feature, list);
    }

    public static <FC extends FeatureConfig> RegistryEntry<PlacedFeature> createPlacedFeature(String id, RegistryEntry<ConfiguredFeature<FC, ?>> feature, List<PlacementModifier> placementModifiers) {
        Identifier realID = Cinderscapes.id(id);
        if (BuiltinRegistries.PLACED_FEATURE.getIds().contains(realID))
            throw new IllegalStateException("Placed Feature ID: \"" + realID.toString() + "\" already exists in the Placed Features registry!");

        return BuiltinRegistries.add(BuiltinRegistries.PLACED_FEATURE, realID, new PlacedFeature(RegistryEntry.upcast(feature), List.copyOf(placementModifiers)));
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>> RegistryEntry<PlacedFeature> createPlacedFeatureStrict(String id, RegistryEntry<ConfiguredFeature<FC, F>> feature, PlacementModifier... placementModifiers) {
        List<PlacementModifier> list = new ArrayList<>(List.of(placementModifiers));
        list.add(BiomePlacementModifier.of());
        return createPlacedFeatureStrict(id, feature, list);
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>> RegistryEntry<PlacedFeature> createPlacedFeatureStrict(String id, RegistryEntry<ConfiguredFeature<FC, F>> feature, List<PlacementModifier> placementModifiers) {
        Identifier realID = Cinderscapes.id(id);
        if (BuiltinRegistries.PLACED_FEATURE.getIds().contains(realID))
            throw new IllegalStateException("Placed Feature ID: \"" + realID.toString() + "\" already exists in the Placed Features registry!");

        return BuiltinRegistries.add(BuiltinRegistries.PLACED_FEATURE, realID, new PlacedFeature(RegistryEntry.upcast(feature), List.copyOf(placementModifiers)));
    }
}
