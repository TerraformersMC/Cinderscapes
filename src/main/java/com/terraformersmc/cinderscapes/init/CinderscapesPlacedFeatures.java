package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.placementModifier.SafelistRangeCeilingPlacementModifier;
import com.terraformersmc.cinderscapes.placementModifier.SafelistRangeFloorPlacementModifier;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.BiasedToBottomIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.NetherConfiguredFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountMultilayerPlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.NoiseThresholdCountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CinderscapesPlacedFeatures {

    public static final RegistryEntry<PlacedFeature> BLACKSTONE_SHALE_WEEPING_VINES = createPlacedFeature("blackstone_shales_weeping_vine", CinderscapesConfiguredFeatures.BLACKSTONE_SHALE_WEEPING_VINES, CountPlacementModifier.of(10), SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_TOP_RANGE);
    public static final RegistryEntry<PlacedFeature> ORE_DEBRIS_LARGE_ASHY_SHOALS = createPlacedFeature("ore_debris_large_ashy_shoals", CinderscapesConfiguredFeatures.ORE_DEBRIS_LARGE_ASHY_SHOALS, HeightRangePlacementModifier.trapezoid(YOffset.fixed(8), YOffset.fixed(24)), CountPlacementModifier.of(4), SquarePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> ORE_DEBRIS_SMALL_ASHY_SHOALS = createPlacedFeature("ore_debris_small_ashy_shoals", CinderscapesConfiguredFeatures.ORE_DEBRIS_SMALL_ASHY_SHOALS, PlacedFeatures.EIGHT_ABOVE_AND_BELOW_RANGE, CountPlacementModifier.of(4), SquarePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> ASH_PILES = createPlacedFeature("ash_piles", CinderscapesConfiguredFeatures.ASH_PILES, HeightRangePlacementModifier.uniform(YOffset.fixed(10), YOffset.getTop()), CountPlacementModifier.of(5), SquarePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> VEGETATION_ASHY_SHOALS = createPlacedFeature("vegetation_ashy_shoals", CinderscapesConfiguredFeatures.VEGETATION_ASHY_SHOALS, CountMultilayerPlacementModifier.of(8));
    public static final RegistryEntry<PlacedFeature> BRAMBLE_BERRY_BUSHES = createPlacedFeature("bramble_berry_bushes", CinderscapesConfiguredFeatures.BRAMBLE_BERRY_BUSHES, VegetationPlacedFeatures.modifiers(8));

    public static final RegistryEntry<PlacedFeature> SOUL_SAND_ASHY_SHOALS = createPlacedFeature("soul_sand_ashy_shoals", CinderscapesConfiguredFeatures.SOUL_SAND_ASHY_SHOALS, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64)), CountPlacementModifier.of(5), SquarePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> SOUL_SOIL_ASHY_SHOALS = createPlacedFeature("soul_soil_ashy_shoals", CinderscapesConfiguredFeatures.SOUL_SOIL_ASHY_SHOALS, PlacedFeatures.BOTTOM_TO_TOP_RANGE, CountPlacementModifier.of(10), SquarePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> GRAVEL_ASHY_SHOALS = createPlacedFeature("gravel_ashy_shoals", CinderscapesConfiguredFeatures.GRAVEL_ASHY_SHOALS, PlacedFeatures.BOTTOM_TO_TOP_RANGE, CountPlacementModifier.of(5), SquarePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> ASH_TOP_LAYER = createPlacedFeature("ash_top_layer", CinderscapesConfiguredFeatures.ASH_TOP_LAYER);
    private static final List<BlockState> DEAD_TREE_SAFELIST = Arrays.asList(Blocks.NETHERRACK.getDefaultState(), Blocks.GRAVEL.getDefaultState(), CinderscapesBlocks.ASH.getDefaultState(), Blocks.SOUL_SAND.getDefaultState(), Blocks.SOUL_SOIL.getDefaultState());
    public static final RegistryEntry<PlacedFeature> DEAD_TREE = createPlacedFeature("dead_tree", CinderscapesConfiguredFeatures.DEAD_TREE,
            new SafelistRangeFloorPlacementModifier(YOffset.aboveBottom(20), YOffset.belowTop(20), DEAD_TREE_SAFELIST),
            CountPlacementModifier.of(10)
    );

    /******* BLACKSTONE SHALES *********/
    public static final RegistryEntry<PlacedFeature> SOUL_SAND_BLACKSTONE_SHALES = createPlacedFeature("soul_sand_blackstone_shales", CinderscapesConfiguredFeatures.SOUL_SAND_ASHY_SHOALS, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64)), CountPlacementModifier.of(10), SquarePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> SOUL_SOIL_BLACKSTONE_SHALES = createPlacedFeature("soul_soil_blackstone_shales", CinderscapesConfiguredFeatures.SOUL_SOIL_ASHY_SHOALS, PlacedFeatures.BOTTOM_TO_TOP_RANGE, CountPlacementModifier.of(30), SquarePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> PATCH_CRIMSON_ROOTS = createPlacedFeature("patch_crimson_roots_blackstone_shales", NetherConfiguredFeatures.PATCH_CRIMSON_ROOTS, CountPlacementModifier.of(128));

    public static final RegistryEntry<PlacedFeature> SHALES = createPlacedFeature("shales", CinderscapesConfiguredFeatures.SHALES,
            new SafelistRangeFloorPlacementModifier(YOffset.aboveBottom(20), YOffset.belowTop(20), CinderscapesConfiguredFeatures.SHALE_SAFELIST),
            CountPlacementModifier.of(2)
    );

    public static final RegistryEntry<PlacedFeature> LAVA_SHALES = createPlacedFeature("lava_shales", CinderscapesConfiguredFeatures.LAVA_SHALES,
            new SafelistRangeFloorPlacementModifier(YOffset.aboveBottom(20), YOffset.belowTop(20), CinderscapesConfiguredFeatures.LAVA_SHALE_SAFELIST),
            CountPlacementModifier.of(2)
    );


    /******* LUMINOUS GROVE *********/
    public static final RegistryEntry<PlacedFeature> GLOWSTONE_EXTRA = createPlacedFeature("luminous_grove/glowstone_extra", CinderscapesConfiguredFeatures.GLOWSTONE, CountPlacementModifier.of(BiasedToBottomIntProvider.create(0, 40)), SquarePlacementModifier.of(), PlacedFeatures.FOUR_ABOVE_AND_BELOW_RANGE);
    public static final RegistryEntry<PlacedFeature> GLOWSTONE = createPlacedFeature("luminous_grove/glowstone", CinderscapesConfiguredFeatures.GLOWSTONE, PlacedFeatures.BOTTOM_TO_TOP_RANGE, CountPlacementModifier.of(40), SquarePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> SHROOMLIGHT_BUSH = createPlacedFeature("luminous_grove/shroomlight_bush", CinderscapesConfiguredFeatures.SHROOMLIGHT_BUSH, PlacedFeatures.BOTTOM_TO_TOP_RANGE, CountPlacementModifier.of(5), SquarePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> VEGETATION_LUMINOUS_GROWTH = createPlacedFeature("luminous_growth/vegetation", CinderscapesConfiguredFeatures.VEGETATION_LUMINOUS_GROWTH, CountMultilayerPlacementModifier.of(8));
    public static final RegistryEntry<PlacedFeature> LUMINOUS_POD = createPlacedFeature("luminous_growth/luminous_pod", CinderscapesConfiguredFeatures.LUMINOUS_POD, NoiseThresholdCountPlacementModifier.of(-0.8, 0, 7), RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP);
    public static final RegistryEntry<PlacedFeature> TALL_PHOTOFERN = createPlacedFeature("luminous_growth/tall_photofern", CinderscapesConfiguredFeatures.TALL_PHOTOFERN, NoiseThresholdCountPlacementModifier.of(-0.8, 0, 7), RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP);
    public static final RegistryEntry<PlacedFeature> UMBRAL_VINE = createPlacedFeature("luminous_growth/umbral_vine", CinderscapesConfiguredFeatures.UMBRAL_VINE, PlacedFeatures.BOTTOM_TO_TOP_RANGE, SquarePlacementModifier.of(), CountPlacementModifier.of(20));
    public static final RegistryEntry<PlacedFeature> CANOPIED_HUGE_FUNGUS = createPlacedFeature("canopied_huge_fungus", CinderscapesConfiguredFeatures.CANOPIED_HUGE_FUNGUS, CountMultilayerPlacementModifier.of(8), new SafelistRangeFloorPlacementModifier(YOffset.aboveBottom(20), YOffset.belowTop(20), CinderscapesConfiguredFeatures.CANOPIED_HUGE_FUNGUS_SAFELIST));

    /******* QUARTZ CANYON *******/
    public static final RegistryEntry<PlacedFeature> VEGETATION_QUARTZ_CANYON = createPlacedFeature("quartz_canyon/vegetation", CinderscapesConfiguredFeatures.VEGETATION_QUARTZ_CANYON, CountMultilayerPlacementModifier.of(1));
    public static final RegistryEntry<PlacedFeature> ORE_QUARTZ_QUARTZ_CANYON = createPlacedFeature("quartz_canyon/quartz_ore", CinderscapesConfiguredFeatures.ORE_QUARTZ_QUARTZ_CANYON, CountPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE);
    public static final RegistryEntry<PlacedFeature> ORE_SULFUR_QUARTZ_CANYON = createPlacedFeature("quartz_canyon/sulfur_ore", CinderscapesConfiguredFeatures.ORE_SULFUR_QUARTZ_CANYON, CountPlacementModifier.of(16), SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_TOP_RANGE);
    public static final RegistryEntry<PlacedFeature> ORE_GOLD_QUARTZ_CANYON = createPlacedFeature("quartz_canyon/gold_ore", CinderscapesConfiguredFeatures.ORE_GOLD_QUARTZ_CANYON, CountPlacementModifier.of(20), PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE);
    public static final RegistryEntry<PlacedFeature> ORE_SMOKY_QUARTZ_QUARTZ_CANYON = createPlacedFeature("quartz_canyon/smoky_quartz_ore", CinderscapesConfiguredFeatures.ORE_SMOKY_QUARTZ_QUARTZ_CANYON, CountPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_TOP_RANGE);
    public static final RegistryEntry<PlacedFeature> ORE_ROSE_QUARTZ_QUARTZ_CANYON = createPlacedFeature("quartz_canyon/rose_quartz_ore", CinderscapesConfiguredFeatures.ORE_ROSE_QUARTZ_QUARTZ_CANYON, CountPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_TOP_RANGE);
    public static final RegistryEntry<PlacedFeature> ORE_SULFUR_QUARTZ_QUARTZ_CANYON = createPlacedFeature("quartz_canyon/sulfur_quartz_ore", CinderscapesConfiguredFeatures.ORE_SULFUR_QUARTZ_QUARTZ_CANYON, CountPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_TOP_RANGE);

    public static final RegistryEntry<PlacedFeature> CEILING_SHARD_QUARTZ = createPlacedFeature("quartz_canyon/ceiling_shard_quartz", CinderscapesConfiguredFeatures.CEILING_SHARD_QUARTZ, new SafelistRangeCeilingPlacementModifier(YOffset.aboveBottom(20), YOffset.belowTop(20), CinderscapesConfiguredFeatures.SHARED_SAFELIST));
    public static final RegistryEntry<PlacedFeature> FLOOR_SHARD_QUARTZ = createPlacedFeature("quartz_canyon/floor_shard_quartz", CinderscapesConfiguredFeatures.FLOOR_SHARD_QUARTZ, new SafelistRangeFloorPlacementModifier(YOffset.aboveBottom(20), YOffset.belowTop(20), CinderscapesConfiguredFeatures.SHARED_SAFELIST));
    public static final RegistryEntry<PlacedFeature> CEILING_SHARD_ROSE_QUARTZ = createPlacedFeature("quartz_canyon/ceiling_shard_rose_quartz", CinderscapesConfiguredFeatures.CEILING_SHARD_ROSE_QUARTZ, new SafelistRangeCeilingPlacementModifier(YOffset.aboveBottom(20), YOffset.belowTop(20), CinderscapesConfiguredFeatures.SHARED_SAFELIST));
    public static final RegistryEntry<PlacedFeature> FLOOR_SHARD_ROSE_QUARTZ = createPlacedFeature("quartz_canyon/floor_shard_rose_quartz", CinderscapesConfiguredFeatures.FLOOR_SHARD_ROSE_QUARTZ, new SafelistRangeFloorPlacementModifier(YOffset.aboveBottom(20), YOffset.belowTop(20), CinderscapesConfiguredFeatures.SHARED_SAFELIST));
    public static final RegistryEntry<PlacedFeature> CEILING_SHARD_SMOKY_QUARTZ = createPlacedFeature("quartz_canyon/ceiling_shard_smoky_quartz", CinderscapesConfiguredFeatures.CEILING_SHARD_SMOKY_QUARTZ, new SafelistRangeCeilingPlacementModifier(YOffset.aboveBottom(20), YOffset.belowTop(20), CinderscapesConfiguredFeatures.SHARED_SAFELIST));
    public static final RegistryEntry<PlacedFeature> FLOOR_SHARD_SMOKY_QUARTZ = createPlacedFeature("quartz_canyon/floor_shard_smoky_quartz", CinderscapesConfiguredFeatures.FLOOR_SHARD_SMOKY_QUARTZ, new SafelistRangeFloorPlacementModifier(YOffset.aboveBottom(20), YOffset.belowTop(20), CinderscapesConfiguredFeatures.SHARED_SAFELIST));
    public static final RegistryEntry<PlacedFeature> CEILING_SHARD_SULFUR_QUARTZ = createPlacedFeature("quartz_canyon/ceiling_shard_sulfur_quartz", CinderscapesConfiguredFeatures.CEILING_SHARD_SULFUR_QUARTZ, new SafelistRangeCeilingPlacementModifier(YOffset.aboveBottom(20), YOffset.belowTop(20), CinderscapesConfiguredFeatures.SHARED_SAFELIST));
    public static final RegistryEntry<PlacedFeature> FLOOR_SHARD_SULFUR_QUARTZ = createPlacedFeature("quartz_canyon/floor_shard_sulfur_quartz", CinderscapesConfiguredFeatures.FLOOR_SHARD_SULFUR_QUARTZ, new SafelistRangeFloorPlacementModifier(YOffset.aboveBottom(20), YOffset.belowTop(20), CinderscapesConfiguredFeatures.SHARED_SAFELIST));

    public static final RegistryEntry<PlacedFeature> POLYPITE_QUARTZ = createPlacedFeature("quartz_canyon/polypite_quartz", CinderscapesConfiguredFeatures.POLYPITE_QUARTZ, SquarePlacementModifier.of(), CountPlacementModifier.of(128), PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE);
    public static final RegistryEntry<PlacedFeature> POLYPITE_SULFUR_QUARTZ = createPlacedFeature("quartz_canyon/polypite_sulfur_quartz", CinderscapesConfiguredFeatures.POLYPITE_SULFUR_QUARTZ, SquarePlacementModifier.of(), CountPlacementModifier.of(128), PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE);
    public static final RegistryEntry<PlacedFeature> POLYPITE_ROSE_QUARTZ = createPlacedFeature("quartz_canyon/polypite_rose_quartz", CinderscapesConfiguredFeatures.POLYPITE_ROSE_QUARTZ, SquarePlacementModifier.of(), CountPlacementModifier.of(128), PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE);
    public static final RegistryEntry<PlacedFeature> POLYPITE_SMOKY_QUARTZ = createPlacedFeature("quartz_canyon/polypite_smoky_quartz", CinderscapesConfiguredFeatures.POLYPITE_SMOKY_QUARTZ, SquarePlacementModifier.of(), CountPlacementModifier.of(128), PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE);

    public static <FC extends FeatureConfig> RegistryEntry<PlacedFeature> createPlacedFeature(String id, RegistryEntry<ConfiguredFeature<FC, ?>> feature, PlacementModifier... placementModifiers) {
        List<PlacementModifier> list = new ArrayList<>(List.of(placementModifiers));
        list.add(BiomePlacementModifier.of());
        return createPlacedFeature(id, feature, list);
    }

    public static <FC extends FeatureConfig> RegistryEntry<PlacedFeature> createPlacedFeature(String id, RegistryEntry<ConfiguredFeature<FC, ?>> feature, List<PlacementModifier> placementModifiers) {
        Identifier realID = Cinderscapes.id(id);
        if (BuiltinRegistries.PLACED_FEATURE.getIds().contains(realID))
            throw new IllegalStateException("Placed Feature ID: \"" + realID.toString() + "\" already exists in the Placed Features registry!");

        return BuiltinRegistries.add(BuiltinRegistries.PLACED_FEATURE, realID, new PlacedFeature(RegistryEntry.upcast(feature), List.copyOf(placementModifiers)));
    }

}
