package com.terraformersmc.cinderscapes.init;

import com.google.common.base.Preconditions;
import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.block.PolypiteQuartzBlock;
import com.terraformersmc.cinderscapes.decorator.config.CountSafelistRangeDecoratorConfig;
import com.terraformersmc.cinderscapes.feature.config.PolypiteQuartzFeatureConfig;
import com.terraformersmc.cinderscapes.feature.config.SimpleStateFeatureConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.CountConfig;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.Arrays;
import java.util.List;

public final class CinderscapeConfiguredFeatures {

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
    public static final ConfiguredFeature<?, ?> VEGETATION_ASHY_SHOALS = register("vegetation_ashy_shoals",
            CinderscapesFeatures.VEGETATION
                    .configure(CinderscapesFeatures.ASHY_SHOALS_VEGETATION_CONFIG)
                    .decorate(Decorator.COUNT_MULTILAYER.configure(new CountConfig(8)))
    );
    public static final ConfiguredFeature<?, ?> BRAMBLE_BERRY_BUSHES = register("bramble_berry_bushes",
            Feature.RANDOM_PATCH
                    .configure(CinderscapesFeatures.BRAMBLE_BERRY_BUSH_CONFIG)
                    .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE)
                    .repeat(8)
    );

    public static final ConfiguredFeature<?, ?> SOUL_SAND_ASHY_SHOALS = register("soul_sand_ashy_shoals",
            Feature.NETHERRACK_REPLACE_BLOBS.configure(CinderscapesFeatures.SOUL_SAND_REPLACE_CONFIG)
                    .method_30377(64)
                    .spreadHorizontally()
                    .repeat(5)
    );
    public static final ConfiguredFeature<?, ?> SOUL_SOIL_ASHY_SHOALS = register("soul_soil_ashy_shoals", Feature.NETHERRACK_REPLACE_BLOBS.configure(CinderscapesFeatures.SOUL_SOIL_REPLACE_CONFIG)
            .method_30377(128)
            .spreadHorizontally()
            .repeat(10));
    public static final ConfiguredFeature<?, ?> GRAVEL_ASHY_SHOALS = register("gravel_ashy_shoals", Feature.NETHERRACK_REPLACE_BLOBS.configure(CinderscapesFeatures.GRAVEL_REPLACE_CONFIG)
            .method_30377(128)
            .spreadHorizontally()
            .repeat(5)
    );

    public static final ConfiguredFeature<?, ?> ASH_TOP_LAYER = register("ash_top_layer", CinderscapesFeatures.ASH_TOP_LAYER.configure(FeatureConfig.DEFAULT));

    private static final List<BlockState> DEAD_TREE_SAFELIST = Arrays.asList(Blocks.NETHERRACK.getDefaultState(), Blocks.GRAVEL.getDefaultState(), CinderscapesBlocks.ASH.getDefaultState(), Blocks.SOUL_SAND.getDefaultState(), Blocks.SOUL_SOIL.getDefaultState());

    public static final ConfiguredFeature<?, ?> DEAD_TREE = register("dead_tree", CinderscapesFeatures.DEAD_TREE.configure(FeatureConfig.DEFAULT).decorate(CinderscapesDecorators.COUNT_FLOOR.configure(new CountSafelistRangeDecoratorConfig(10, 20, 20, 128, DEAD_TREE_SAFELIST))));

    /******* BLACKSTONE SHALES *********/

    // TODO: Up until "repeat(x)" could be refactored into a separate configured feature and reused by both ashy shoals and blackstone shales
    public static final ConfiguredFeature<?, ?> SOUL_SAND_BLACKSTONE_SHALES = register("soul_sand_blackstone_shales",
            Feature.NETHERRACK_REPLACE_BLOBS.configure(CinderscapesFeatures.SOUL_SAND_REPLACE_CONFIG)
                    .method_30377(64)
                    .spreadHorizontally()
                    .repeat(10)
    );

    public static final ConfiguredFeature<?, ?> SOUL_SOIL_BLACKSTONE_SHALES = register("soul_soil_blackstone_shales",
            Feature.NETHERRACK_REPLACE_BLOBS.configure(CinderscapesFeatures.SOUL_SOIL_REPLACE_CONFIG)
                .method_30377(128)
                .spreadHorizontally()
                .repeat(30)
    );

    public static final ConfiguredFeature<?, ?> PATCH_CRIMSON_ROOTS = register("patch_crimson_roots_blackstone_shales",
            ConfiguredFeatures.PATCH_CRIMSON_ROOTS.repeat(128)
            // TODO: Does this need spreadHorizontally? Probably not, vanilla doesn't use it
    );

    private static final List<BlockState> SHALE_SAFELIST = Arrays.asList(Blocks.CRIMSON_ROOTS.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), Blocks.BLACKSTONE.getDefaultState(), Blocks.SOUL_SOIL.getDefaultState(), Blocks.SOUL_SAND.getDefaultState());

    public static final ConfiguredFeature<?, ?> SHALES = register("shales",
            CinderscapesFeatures.SHALE_FEATURE.configure(new SimpleStateFeatureConfig(Blocks.BLACKSTONE.getDefaultState(), SHALE_SAFELIST)).decorate(CinderscapesDecorators.COUNT_FLOOR.configure(new CountSafelistRangeDecoratorConfig(2, 20, 20, 128, SHALE_SAFELIST)))
    );

    private static final List<BlockState> LAVA_SHALE_SAFELIST = Arrays.asList(Blocks.LAVA.getDefaultState());

    public static final ConfiguredFeature<?, ?> LAVA_SHALES = register("lava_shales",
            CinderscapesFeatures.SHALE_FEATURE.configure(new SimpleStateFeatureConfig(Blocks.BLACKSTONE.getDefaultState(), SHALE_SAFELIST)).decorate(CinderscapesDecorators.COUNT_FLOOR.configure(new CountSafelistRangeDecoratorConfig(2, 20, 20, 128, LAVA_SHALE_SAFELIST)))
    );

    /******* LUMINOUS GROVE *********/
    public static final ConfiguredFeature<?, ?> GLOWSTONE_EXTRA = register("luminous_grove/glowstone_extra",
            Feature.GLOWSTONE_BLOB.configure(FeatureConfig.DEFAULT)
                    .decorate(Decorator.GLOWSTONE.configure(new CountConfig(40)))
    );
    public static final ConfiguredFeature<?, ?> GLOWSTONE = register("luminous_grove/glowstone",
            Feature.GLOWSTONE_BLOB.configure(FeatureConfig.DEFAULT).method_30377(128)
                    .spreadHorizontally()
                    .repeat(40)
    );

    public static final ConfiguredFeature<?, ?> SHROOMLIGHT_BUSH = register("luminous_grove/shroomlight_bush",
            CinderscapesFeatures.SHROOMLIGHT_BUSH.configure(FeatureConfig.DEFAULT)
                    .method_30377(128)
                    .spreadHorizontally()
                    .repeat(5)
    );

    public static final ConfiguredFeature<?, ?> VEGETATION_LUMINOUS_GROWTH = register("luminous_growth/vegetation",
            CinderscapesFeatures.VEGETATION.configure(CinderscapesFeatures.LUMINOUS_GROVE_VEGETATION_CONFIG).decorate(Decorator.COUNT_MULTILAYER.configure(new CountConfig(8)))
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

    public static final ConfiguredFeature<?, ?> UMBRAL_VINE = register("luminous_growth/umbral_vine",
            CinderscapesFeatures.UMBRAL_VINE.configure(FeatureConfig.DEFAULT)
                    .method_30377(128)
                    .spreadHorizontally()
                    .repeat(20)
    );

    private static final List<BlockState> CANOPIED_HUGE_FUNGUS_SAFELIST = Arrays.asList(CinderscapesBlocks.UMBRAL_NYLIUM.getDefaultState(), Blocks.NETHERRACK.getDefaultState());

    public static final ConfiguredFeature<?, ?> CANOPIED_HUGE_FUNGUS = register("canopied_huge_fungus", CinderscapesFeatures.CANOPIED_HUGE_FUNGUS.configure(CinderscapesFeatures.UMBRAL_FUNGUS_NOT_PLANTED_CONFIG).decorate(CinderscapesDecorators.COUNT_FLOOR.configure(new CountSafelistRangeDecoratorConfig(32, 20, 20, 128, CANOPIED_HUGE_FUNGUS_SAFELIST))));

    /******* QUARTZ CANYON *******/

    public static final ConfiguredFeature<?, ?> VEGETATION_QUARTZ_CANYON = register("quartz_canyon/vegetation", CinderscapesFeatures.VEGETATION.configure(CinderscapesFeatures.QUARTZ_CANYON_VEGETATION_CONFIG).decorate(Decorator.COUNT.configure(new CountConfig(8))));

    public static final ConfiguredFeature<?, ?> ORE_QUARTZ_QUARTZ_CANYON = register("quartz_canyon/quartz_ore", Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.NETHERRACK, Blocks.NETHER_QUARTZ_ORE.getDefaultState(), 14)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(10, 20, 128))).spreadHorizontally().repeat(32));
    public static final ConfiguredFeature<?, ?> ORE_SULFUR_QUARTZ_CANYON = register("quartz_canyon/sulfur_ore", Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.NETHERRACK, CinderscapesBlocks.SULFUR_ORE.getDefaultState(), 14)).method_30377(128).spreadHorizontally().repeat(16));
    public static final ConfiguredFeature<?, ?> ORE_GOLD_QUARTZ_CANYON = register("quartz_canyon/gold_ore", Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.NETHERRACK, Blocks.NETHER_GOLD_ORE.getDefaultState(), 10)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(10, 20, 128))).spreadHorizontally().repeat(20));
    public static final ConfiguredFeature<?, ?> ORE_SMOKY_QUARTZ_QUARTZ_CANYON = register("quartz_canyon/smoky_quartz_ore", Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.NETHERRACK, CinderscapesBlocks.SMOKY_QUARTZ_ORE.getDefaultState(), 14)).method_30377(128).spreadHorizontally().repeat(32));
    public static final ConfiguredFeature<?, ?> ORE_ROSE_QUARTZ_QUARTZ_CANYON = register("quartz_canyon/rose_quartz_ore", Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.NETHERRACK, CinderscapesBlocks.ROSE_QUARTZ_ORE.getDefaultState(), 14)).method_30377(128).spreadHorizontally().repeat(32));
    public static final ConfiguredFeature<?, ?> ORE_SULFUR_QUARTZ_QUARTZ_CANYON = register("quartz_canyon/sulfur_quartz_ore", Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.NETHERRACK, CinderscapesBlocks.SULFUR_QUARTZ_ORE.getDefaultState(), 14)).method_30377(128).spreadHorizontally().repeat(32));

    private static final List<BlockState> SHARD_WHITELIST = Arrays.asList(Blocks.NETHERRACK.getDefaultState(), Blocks.AIR.getDefaultState(), Blocks.GRAVEL.getDefaultState(), Blocks.NETHER_QUARTZ_ORE.getDefaultState(), Blocks.SOUL_SAND.getDefaultState());
    private static final List<BlockState> SHARED_SAFELIST = Arrays.asList(Blocks.NETHERRACK.getDefaultState(), Blocks.NETHER_QUARTZ_ORE.getDefaultState());

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

    /******* IVORY SHALLOWS *********/
    public static final ConfiguredFeature<?, ?> IVORY_PILLAR = register("ivory_shallows/ivory_pillar",
            CinderscapesFeatures.IVORY_PILLAR.configure(FeatureConfig.DEFAULT)
                    .method_30377(128)
                    .spreadHorizontally()
                    .repeat(20)
    );
    
    public static final ConfiguredFeature<?, ?> CEILING_IVORY_TUSK = register("ivory_shallows/ceiling_ivory_tusk",
    		CinderscapesFeatures.CEILING_IVORY_TUSK.configure(FeatureConfig.DEFAULT)
    		.decorate(CinderscapesDecorators.COUNT_CEILING
    				.configure(new CountSafelistRangeDecoratorConfig(1, 20, 20, 128, Arrays.asList(CinderscapesBlocks.IVORY_BLOCK.getDefaultState(), Blocks.AIR.getDefaultState())))));
    
    public static final ConfiguredFeature<?, ?> FLOOR_IVORY_TUSK = register("ivory_shallows/floor_ivory_tusk",
    		CinderscapesFeatures.FLOOR_IVORY_TUSK.configure(FeatureConfig.DEFAULT)
    		.decorate(CinderscapesDecorators.COUNT_FLOOR
    				.configure(new CountSafelistRangeDecoratorConfig(2, 20, 20, 128, Arrays.asList(CinderscapesBlocks.IVORY_BLOCK.getDefaultState(), Blocks.AIR.getDefaultState())))));
    
    public static final ConfiguredFeature<?, ?> IVORY_TOOTH = register("ivory_shallows/ivory_tooth",
    		CinderscapesFeatures.IVORY_TOOTH.configure(new DefaultFeatureConfig())
    		.decorate(Decorator.RANGE
    				.configure(new RangeDecoratorConfig(5, 15, 128))).spreadHorizontally().repeat(128));
    
    public static final ConfiguredFeature<?, ?> IVORY_SPIKE_SHORT = register("ivory_shallows/ivory_spike_short",
            CinderscapesFeatures.VEGETATION.configure(CinderscapesFeatures.IVORY_SPIKE_SHORT_CONFIG).decorate(Decorator.FIRE
    				.configure(new CountConfig(8)))
    );
    
    private static ConfiguredFeature<?, ?> configurePolypiteQuartz(PolypiteQuartzBlock block) {
        return CinderscapesFeatures.POLYPITE_QUARTZ.configure(new PolypiteQuartzFeatureConfig(block)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(10, 20, 128))).spreadHorizontally().repeat(128);
    }

    private CinderscapeConfiguredFeatures() {
    }

    private static ConfiguredFeature<?, ?> register(String id, ConfiguredFeature<?, ?> cf) {
        Identifier realId = Cinderscapes.id(id);
        Preconditions.checkState(!BuiltinRegistries.CONFIGURED_FEATURE.getIds().contains(realId), "Duplicate ID: %s", id);
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, realId, cf);
    }

}
