package com.terraformersmc.cinderscapes.init;

import com.google.common.base.Preconditions;
import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.block.PolypiteQuartzBlock;
import com.terraformersmc.cinderscapes.decorator.config.CountSafelistRangeDecoratorConfig;
import com.terraformersmc.cinderscapes.feature.config.PolypiteQuartzFeatureConfig;
import com.terraformersmc.cinderscapes.feature.config.SimpleStateFeatureConfig;
import com.terraformersmc.cinderscapes.feature.config.VegetationFeatureConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
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

    public static void init(){}

    public static final RegistryEntry<ConfiguredFeature<DefaultFeatureConfig, ?>> BLACKSTONE_SHALE_WEEPING_VINES = register("blackstone_shales_weeping_vines", Feature.WEEPING_VINES, FeatureConfig.DEFAULT);

    public static final ConfiguredFeature<?, ?> ORE_DEBRIS_LARGE_ASHY_SHOALS = register("ore_debris_large_ashy_shoals", Feature.NO_SURFACE_ORE
            .configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_NETHER, Blocks.ANCIENT_DEBRIS.getDefaultState(), 3))
            .decorate(Decorator.DEPTH_AVERAGE.configure(new DepthAverageDecoratorConfig(16, 8)))
            .spreadHorizontally()
            .repeat(4)
    );
    public static final ConfiguredFeature<?, ?> ORE_DEBRIS_SMALL_ASHY_SHOALS = register("ore_debris_small_ashy_shoals", Feature.NO_SURFACE_ORE
            .configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_NETHER, Blocks.ANCIENT_DEBRIS.getDefaultState(), 2))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(8, 16, 128)))
            .spreadHorizontally()
            .repeat(4)
    );
    public static final ConfiguredFeature<?, ?> ASH_PILES = register("ash_piles", CinderscapesFeatures.ASH_PILE
            .configure(FeatureConfig.DEFAULT)
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(10, 10, 128)))
            .spreadHorizontally()
            .repeat(5)
    );
    public static final RegistryEntry<ConfiguredFeature<VegetationFeatureConfig, ?>> VEGETATION_ASHY_SHOALS = register("vegetation_ashy_shoals",
            CinderscapesFeatures.VEGETATION, CinderscapesFeatures.ASHY_SHOALS_VEGETATION_CONFIG
    );
    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> BRAMBLE_BERRY_BUSHES = register("bramble_berry_bushes",
            Feature.RANDOM_PATCH, CinderscapesFeatures.BRAMBLE_BERRY_BUSH_CONFIG
    );

    public static final RegistryEntry<ConfiguredFeature<ReplaceBlobsFeatureConfig, ?>> SOUL_SAND_ASHY_SHOALS = register("soul_sand_ashy_shoals",
            Feature.NETHERRACK_REPLACE_BLOBS, CinderscapesFeatures.SOUL_SAND_REPLACE_CONFIG);
    public static final RegistryEntry<ConfiguredFeature<ReplaceBlobsFeatureConfig, ?>> SOUL_SOIL_ASHY_SHOALS = register("soul_soil_ashy_shoals", Feature.NETHERRACK_REPLACE_BLOBS, CinderscapesFeatures.SOUL_SOIL_REPLACE_CONFIG));
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

    public static final List<BlockState> SHALE_SAFELIST = List.of(Blocks.CRIMSON_ROOTS.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), Blocks.BLACKSTONE.getDefaultState(), Blocks.SOUL_SOIL.getDefaultState(), Blocks.SOUL_SAND.getDefaultState());

    public static final RegistryEntry<ConfiguredFeature<SimpleStateFeatureConfig, ?>> SHALES = register("shales",
            CinderscapesFeatures.SHALE_FEATURE, new SimpleStateFeatureConfig(Blocks.BLACKSTONE.getDefaultState(), SHALE_SAFELIST)
    );

    public static final List<BlockState> LAVA_SHALE_SAFELIST = List.of(Blocks.LAVA.getDefaultState());

    public static final RegistryEntry<ConfiguredFeature<SimpleStateFeatureConfig, ?>> LAVA_SHALES = register("lava_shales",
            CinderscapesFeatures.SHALE_FEATURE, new SimpleStateFeatureConfig(Blocks.BLACKSTONE.getDefaultState(), SHALE_SAFELIST)
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

    public static final ConfiguredFeature<?, ?> LUMINOUS_POD = register("luminous_growth/luminous_pod",
            Feature.RANDOM_PATCH.configure(CinderscapesFeatures.LUMINOUS_POD_CONFIG)
                    // The following is the same as vanilla tall grass patches
                    .decorate(ConfiguredFeatures.Decorators.SPREAD_32_ABOVE)
                    .decorate(ConfiguredFeatures.Decorators.HEIGHTMAP)
                    .spreadHorizontally()
                    .decorate(Decorator.COUNT_NOISE.configure(new CountNoiseDecoratorConfig(-0.8D, 0, 7)))
    );

    public static final ConfiguredFeature<?, ?> TALL_PHOTOFERN = register("luminous_growth/tall_photofern",
            Feature.RANDOM_PATCH.configure(CinderscapesFeatures.TALL_PHOTOFERN_CONFIG)
                    // The following is the same as vanilla tall grass patches
                    .decorate(ConfiguredFeatures.Decorators.SPREAD_32_ABOVE)
                    .decorate(ConfiguredFeatures.Decorators.HEIGHTMAP)
                    .spreadHorizontally()
                    .decorate(Decorator.COUNT_NOISE.configure(new CountNoiseDecoratorConfig(-0.8D, 0, 7)))
    );

    public static final RegistryEntry<ConfiguredFeature<DefaultFeatureConfig, ?>> UMBRAL_VINE = register("luminous_growth/umbral_vine",
            CinderscapesFeatures.UMBRAL_VINE, FeatureConfig.DEFAULT
    );

    public static final List<BlockState> CANOPIED_HUGE_FUNGUS_SAFELIST = List.of(CinderscapesBlocks.UMBRAL_NYLIUM.getDefaultState(), Blocks.NETHERRACK.getDefaultState());

    public static final ConfiguredFeature<?, ?> CANOPIED_HUGE_FUNGUS = register("canopied_huge_fungus", CinderscapesFeatures.CANOPIED_HUGE_FUNGUS.configure(CinderscapesFeatures.UMBRAL_FUNGUS_NOT_PLANTED_CONFIG).decorate(CinderscapesDecorators.COUNT_FLOOR.configure(new CountSafelistRangeDecoratorConfig(32, 20, 20, 128, CANOPIED_HUGE_FUNGUS_SAFELIST))));

    /******* QUARTZ CANYON *******/

    public static final RegistryEntry<ConfiguredFeature<VegetationFeatureConfig, ?>> VEGETATION_QUARTZ_CANYON = register("quartz_canyon/vegetation", CinderscapesFeatures.VEGETATION, CinderscapesFeatures.QUARTZ_CANYON_VEGETATION_CONFIG);

    public static final ConfiguredFeature<?, ?> ORE_QUARTZ_QUARTZ_CANYON = register("quartz_canyon/quartz_ore", Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.NETHERRACK, Blocks.NETHER_QUARTZ_ORE.getDefaultState(), 14)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(10, 20, 128))).spreadHorizontally().repeat(32));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_SULFUR_QUARTZ_CANYON = register("quartz_canyon/sulfur_ore", Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.NETHERRACK, CinderscapesBlocks.SULFUR_ORE.getDefaultState(), 14));
    public static final ConfiguredFeature<?, ?> ORE_GOLD_QUARTZ_CANYON = register("quartz_canyon/gold_ore", Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.NETHERRACK, Blocks.NETHER_GOLD_ORE.getDefaultState(), 10)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(10, 20, 128))).spreadHorizontally().repeat(20));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_SMOKY_QUARTZ_QUARTZ_CANYON = register("quartz_canyon/smoky_quartz_ore", Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.NETHERRACK, CinderscapesBlocks.SMOKY_QUARTZ_ORE.getDefaultState(), 14));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_ROSE_QUARTZ_QUARTZ_CANYON = register("quartz_canyon/rose_quartz_ore", Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.NETHERRACK, CinderscapesBlocks.ROSE_QUARTZ_ORE.getDefaultState(), 14));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_SULFUR_QUARTZ_QUARTZ_CANYON = register("quartz_canyon/sulfur_quartz_ore", Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.NETHERRACK, CinderscapesBlocks.SULFUR_QUARTZ_ORE.getDefaultState(), 14));

    public static final List<BlockState> SHARD_WHITELIST = List.of(Blocks.NETHERRACK.getDefaultState(), Blocks.AIR.getDefaultState(), Blocks.GRAVEL.getDefaultState(), Blocks.NETHER_QUARTZ_ORE.getDefaultState(), Blocks.SOUL_SAND.getDefaultState());
    public static final List<BlockState> SHARED_SAFELIST = List.of(Blocks.NETHERRACK.getDefaultState(), Blocks.NETHER_QUARTZ_ORE.getDefaultState());

    public static final ConfiguredFeature<?, ?> CEILING_SHARD_QUARTZ = register("quartz_canyon/ceiling_shard_quartz", CinderscapesFeatures.CEILING_SHARD.configure(new SimpleStateFeatureConfig(CinderscapesBlocks.CRYSTALLINE_QUARTZ.getDefaultState(), SHARD_WHITELIST)).decorate(CinderscapesDecorators.COUNT_CEILING.configure(new CountSafelistRangeDecoratorConfig(1, 20, 20, 128, SHARED_SAFELIST))));
    public static final ConfiguredFeature<?, ?> FLOOR_SHARD_QUARTZ = register("quartz_canyon/floor_shard_quartz", CinderscapesFeatures.FLOOR_SHARD.configure(new SimpleStateFeatureConfig(CinderscapesBlocks.CRYSTALLINE_QUARTZ.getDefaultState(), SHARD_WHITELIST)).decorate(CinderscapesDecorators.COUNT_FLOOR.configure(new CountSafelistRangeDecoratorConfig(1, 20, 20, 128, SHARED_SAFELIST))));
    public static final ConfiguredFeature<?, ?> CEILING_SHARD_ROSE_QUARTZ = register("quartz_canyon/ceiling_shard_rose_quartz", CinderscapesFeatures.CEILING_SHARD.configure(new SimpleStateFeatureConfig(CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ.getDefaultState(), SHARD_WHITELIST)).decorate(CinderscapesDecorators.COUNT_CEILING.configure(new CountSafelistRangeDecoratorConfig(1, 20, 20, 128, SHARED_SAFELIST))));
    public static final ConfiguredFeature<?, ?> FLOOR_SHARD_ROSE_QUARTZ = register("quartz_canyon/floor_shard_rose_quartz", CinderscapesFeatures.FLOOR_SHARD.configure(new SimpleStateFeatureConfig(CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ.getDefaultState(), SHARD_WHITELIST)).decorate(CinderscapesDecorators.COUNT_FLOOR.configure(new CountSafelistRangeDecoratorConfig(1, 20, 20, 128, SHARED_SAFELIST))));
    public static final ConfiguredFeature<?, ?> CEILING_SHARD_SMOKY_QUARTZ = register("quartz_canyon/ceiling_shard_smoky_quartz", CinderscapesFeatures.CEILING_SHARD.configure(new SimpleStateFeatureConfig(CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ.getDefaultState(), SHARD_WHITELIST)).decorate(CinderscapesDecorators.COUNT_CEILING.configure(new CountSafelistRangeDecoratorConfig(1, 20, 20, 128, SHARED_SAFELIST))));
    public static final ConfiguredFeature<?, ?> FLOOR_SHARD_SMOKY_QUARTZ = register("quartz_canyon/floor_shard_smoky_quartz", CinderscapesFeatures.FLOOR_SHARD.configure(new SimpleStateFeatureConfig(CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ.getDefaultState(), SHARD_WHITELIST)).decorate(CinderscapesDecorators.COUNT_FLOOR.configure(new CountSafelistRangeDecoratorConfig(1, 20, 20, 128, SHARED_SAFELIST))));
    public static final ConfiguredFeature<?, ?> CEILING_SHARD_SULFUR_QUARTZ = register("quartz_canyon/ceiling_shard_sulfur_quartz", CinderscapesFeatures.CEILING_SHARD.configure(new SimpleStateFeatureConfig(CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ.getDefaultState(), SHARD_WHITELIST)).decorate(CinderscapesDecorators.COUNT_CEILING.configure(new CountSafelistRangeDecoratorConfig(1, 20, 20, 128, SHARED_SAFELIST))));
    public static final ConfiguredFeature<?, ?> FLOOR_SHARD_SULFUR_QUARTZ = register("quartz_canyon/floor_shard_sulfur_quartz", CinderscapesFeatures.FLOOR_SHARD.configure(new SimpleStateFeatureConfig(CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ.getDefaultState(), SHARD_WHITELIST)).decorate(CinderscapesDecorators.COUNT_FLOOR.configure(new CountSafelistRangeDecoratorConfig(1, 20, 20, 128, SHARED_SAFELIST))));

    public static final ConfiguredFeature<?, ?> POLYPITE_QUARTZ = register("quartz_canyon/polypite_quartz", configurePolypiteQuartz((PolypiteQuartzBlock) CinderscapesBlocks.POLYPITE_QUARTZ));
    public static final ConfiguredFeature<?, ?> POLYPITE_SULFUR_QUARTZ = register("quartz_canyon/polypite_sulfur_quartz", configurePolypiteQuartz((PolypiteQuartzBlock) CinderscapesBlocks.POLYPITE_SULFUR_QUARTZ));
    public static final ConfiguredFeature<?, ?> POLYPITE_ROSE_QUARTZ = register("quartz_canyon/polypite_rose_quartz", configurePolypiteQuartz((PolypiteQuartzBlock) CinderscapesBlocks.POLYPITE_ROSE_QUARTZ));
    public static final ConfiguredFeature<?, ?> POLYPITE_SMOKY_QUARTZ = register("quartz_canyon/polypite_smoky_quartz", configurePolypiteQuartz((PolypiteQuartzBlock) CinderscapesBlocks.POLYPITE_SMOKY_QUARTZ));

    private static ConfiguredFeature<?, ?> configurePolypiteQuartz(PolypiteQuartzBlock block) {
        return CinderscapesFeatures.POLYPITE_QUARTZ.configure(new PolypiteQuartzFeatureConfig(block)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(10, 20, 128))).spreadHorizontally().repeat(128);
    }

    private CinderscapesConfiguredFeatures() {
    }

    private static  <FC extends FeatureConfig, F extends Feature<FC>> RegistryEntry<ConfiguredFeature<FC, ?>> register(String id, F feature, FC config) {
        Identifier realId = Cinderscapes.id(id);
        Preconditions.checkState(!BuiltinRegistries.CONFIGURED_FEATURE.getIds().contains(realId), "Duplicate ID: %s", id);
        return BuiltinRegistries.method_40360(BuiltinRegistries.CONFIGURED_FEATURE, realId.toString(), new ConfiguredFeature<>(feature, config));
    }

    private static ConfiguredFeature<?, ?> register(String id, ConfiguredFeature<?, ?> cf) {
        Identifier realId = Cinderscapes.id(id);
        Preconditions.checkState(!BuiltinRegistries.CONFIGURED_FEATURE.getIds().contains(realId), "Duplicate ID: %s", id);
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, realId, cf);
    }

}
