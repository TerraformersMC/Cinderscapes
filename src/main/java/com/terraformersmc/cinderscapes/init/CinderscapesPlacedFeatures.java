package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
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
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CinderscapesPlacedFeatures {

    public static final RegistryEntry<PlacedFeature> BLACKSTONE_SHALE_WEEPING_VINES = createPlacedFeature("blackstone_shales_weeping_vine", CinderscapesConfiguredFeatures.BLACKSTONE_SHALE_WEEPING_VINES, CountPlacementModifier.of(10), SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_TOP_RANGE, BiomePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> ORE_DEBRIS_LARGE_ASHY_SHOALS = createPlacedFeature("ore_debris_large_ashy_shoals", CinderscapesConfiguredFeatures.ORE_DEBRIS_LARGE_ASHY_SHOALS, HeightRangePlacementModifier.trapezoid(YOffset.fixed(16), YOffset.fixed(8)), CountPlacementModifier.of(4), SquarePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> ORE_DEBRIS_SMALL_ASHY_SHOALS = createPlacedFeature("ore_debris_small_ashy_shoals", CinderscapesConfiguredFeatures.ORE_DEBRIS_SMALL_ASHY_SHOALS, HeightRangePlacementModifier.uniform(YOffset.fixed(8), YOffset.fixed(16)), CountPlacementModifier.of(4), SquarePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> ASH_PILES = createPlacedFeature("ash_piles", CinderscapesConfiguredFeatures.ASH_PILES, HeightRangePlacementModifier.uniform(YOffset.fixed(10), YOffset.fixed(10)), CountPlacementModifier.of(5), SquarePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> VEGETATION_ASHY_SHOALS = createPlacedFeature("vegetation_ashy_shoals", CinderscapesConfiguredFeatures.VEGETATION_ASHY_SHOALS, CountMultilayerPlacementModifier.of(8));
    public static final RegistryEntry<PlacedFeature> BRAMBLE_BERRY_BUSHES = createPlacedFeature("bramble_berry_bushes", CinderscapesConfiguredFeatures.BRAMBLE_BERRY_BUSHES, VegetationPlacedFeatures.modifiers(8));

    public static final RegistryEntry<PlacedFeature> SOUL_SAND_ASHY_SHOALS = createPlacedFeature("soul_sand_ashy_shoals", CinderscapesConfiguredFeatures.SOUL_SAND_ASHY_SHOALS, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64)), CountPlacementModifier.of(5), SquarePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> SOUL_SOIL_ASHY_SHOALS = createPlacedFeature("soul_soil_ashy_shoals", CinderscapesConfiguredFeatures.SOUL_SOIL_ASHY_SHOALS, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(128)), CountPlacementModifier.of(10), SquarePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> GRAVEL_ASHY_SHOALS = createPlacedFeature("gravel_ashy_shoals", CinderscapesConfiguredFeatures.GRAVEL_ASHY_SHOALS, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(128)), CountPlacementModifier.of(5), SquarePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> ASH_TOP_LAYER = createPlacedFeature("ash_top_layer", CinderscapesConfiguredFeatures.ASH_TOP_LAYER);
    private static final List<BlockState> DEAD_TREE_SAFELIST = Arrays.asList(Blocks.NETHERRACK.getDefaultState(), Blocks.GRAVEL.getDefaultState(), CinderscapesBlocks.ASH.getDefaultState(), Blocks.SOUL_SAND.getDefaultState(), Blocks.SOUL_SOIL.getDefaultState());
    public static final RegistryEntry<PlacedFeature> DEAD_TREE = createPlacedFeature("dead_tree", CinderscapesConfiguredFeatures.DEAD_TREE,
            //todo figure this out, original code is .decorate(CinderscapesDecorators.COUNT_FLOOR.configure(new CountSafelistRangeDecoratorConfig(10, 20, 20, 128, DEAD_TREE_SAFELIST)))
            //HeightRangePlacementModifier.uniform(YOffset.fixed(20), YOffset.fixed(20), YOffset.fixed(128))
            CountPlacementModifier.of(10)
    );
    public static final RegistryEntry<PlacedFeature> SOUL_SAND_BLACKSTONE_SHALES = createPlacedFeature("soul_sand_blackstone_shales", CinderscapesConfiguredFeatures.SOUL_SAND_ASHY_SHOALS, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64)), CountPlacementModifier.of(10), SquarePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> SOUL_SOIL_BLACKSTONE_SHALES = createPlacedFeature("soul_soil_blackstone_shales", CinderscapesConfiguredFeatures.SOUL_SOIL_ASHY_SHOALS, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(128)), CountPlacementModifier.of(30), SquarePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> PATCH_CRIMSON_ROOTS = createPlacedFeature("patch_crimson_roots_blackstone_shales", NetherConfiguredFeatures.PATCH_CRIMSON_ROOTS, CountPlacementModifier.of(128));

    public static final RegistryEntry<PlacedFeature> SHALES = createPlacedFeature("shales", CinderscapesConfiguredFeatures.SHALES,
            //todo figure this out, original code is .decorate(CinderscapesDecorators.COUNT_FLOOR.configure(new CountSafelistRangeDecoratorConfig(2, 20, 20, 128, SHALE_SAFELIST)))
            //HeightRangePlacementModifier.uniform(YOffset.fixed(20), YOffset.fixed(20), YOffset.fixed(128))
            CountPlacementModifier.of(2)
    );

    public static final RegistryEntry<PlacedFeature> LAVA_SHALES = createPlacedFeature("lava_shales", CinderscapesConfiguredFeatures.LAVA_SHALES,
            //todo figure this out, original code is .decorate(CinderscapesDecorators.COUNT_FLOOR.configure(new CountSafelistRangeDecoratorConfig(2, 20, 20, 128, LAVA_SHALE_SAFELIST)))
            //HeightRangePlacementModifier.uniform(YOffset.fixed(20), YOffset.fixed(20), YOffset.fixed(128))
            CountPlacementModifier.of(2)
    );


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
