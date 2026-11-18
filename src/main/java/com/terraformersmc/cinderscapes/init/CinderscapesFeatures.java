package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.block.BrambleBerryBushBlock;
import com.terraformersmc.cinderscapes.feature.*;
import com.terraformersmc.cinderscapes.init.helpers.CinderscapesRegistry;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public final class CinderscapesFeatures {
    /* ASHY SHOALS */
    private static final RuleTest RULE_TEST_BASE_STONE_NETHER = new TagMatchTest(BlockTags.BASE_STONE_NETHER);
    private static final RuleTest RULE_TEST_NETHERRACK = new BlockMatchTest(Blocks.NETHERRACK);

    public static final ResourceKey<Feature> DEBRIS_ORE_LARGE = resourceKey("ashy_shoals/debris_ore_large");
    public static final ResourceKey<Feature> DEBRIS_ORE_SMALL = resourceKey("ashy_shoals/debris_ore_small");

    public static final ResourceKey<Feature> ASH_PILE = resourceKey("ashy_shoals/ash_pile");
    public static final ResourceKey<Feature> ASHY_VEGETATION = resourceKey("ashy_shoals/vegetation");
    public static final ResourceKey<Feature> BRAMBLE_BERRY_BUSHES = resourceKey("ashy_shoals/bramble_berry_bushes");

    public static final ResourceKey<Feature> ASHY_SOUL_SAND = resourceKey("ashy_shoals/soul_sand");
    public static final ResourceKey<Feature> ASHY_SOUL_SOIL = resourceKey("ashy_shoals/soul_soil");
    public static final ResourceKey<Feature> ASHY_GRAVEL = resourceKey("ashy_shoals/gravel");
    public static final ResourceKey<Feature> ASH_TOP_LAYER = resourceKey("ashy_shoals/ash_top_layer");

    public static final ResourceKey<Feature> DEAD_TREE = resourceKey("ashy_shoals/dead_tree");

    /* BLACKSTONE SHALES */
    public static final ResourceKey<Feature> BLACKSTONE_WEEPING_VINES = resourceKey("blackstone_shales/weeping_vines");

    public static final ResourceKey<Feature> SHALES_SOUL_SAND = resourceKey("blackstone_shales/soul_sand");
    public static final ResourceKey<Feature> SHALES_SOUL_SOIL = resourceKey("blackstone_shales/soul_soil");

    public static final ResourceKey<Feature> SHALE = resourceKey("blackstone_shales/shale");

    /* LUMINOUS GROVE */
    public static final ResourceKey<Feature> SHROOMLIGHT_BUSH = resourceKey("luminous_grove/shroomlight_bush");
    public static final ResourceKey<Feature> UMBRAL_VINE = resourceKey("luminous_grove/umbral_vine");

    public static final ResourceKey<Feature> LUMINOUS_VEGETATION = resourceKey("luminous_grove/vegetation");
    public static final ResourceKey<Feature> UMBRAL_NYLIUM_BONEMEAL = resourceKey("luminous_grove/umbral_nylium_bonemeal");
    public static final ResourceKey<Feature> LUMINOUS_POD = resourceKey("luminous_grove/luminous_pod");
    public static final ResourceKey<Feature> TALL_PHOTOFERN = resourceKey("luminous_grove/tall_photofern");

    public static final ResourceKey<Feature> CANOPIED_HUGE_FUNGUS = resourceKey("luminous_grove/canopied_huge_fungus");
    public static final ResourceKey<Feature> CANOPIED_HUGE_FUNGUS_PLANTED = resourceKey("luminous_grove/canopied_huge_fungus_planted");

    /* QUARTZ CAVERN */
    public static final ResourceKey<Feature> QUARTZ_VEGETATION = resourceKey("quartz_cavern/vegetation");

    public static final ResourceKey<Feature> QUARTZ_ORE = resourceKey("quartz_cavern/quartz_ore");
    public static final ResourceKey<Feature> SULFUR_QUARTZ_ORE = resourceKey("quartz_cavern/sulfur_quartz_ore");
    public static final ResourceKey<Feature> ROSE_QUARTZ_ORE = resourceKey("quartz_cavern/rose_quartz_ore");
    public static final ResourceKey<Feature> SMOKY_QUARTZ_ORE = resourceKey("quartz_cavern/smoky_quartz_ore");
    public static final ResourceKey<Feature> GOLD_ORE = resourceKey("quartz_cavern/gold_ore");
    public static final ResourceKey<Feature> SULFUR_ORE = resourceKey("quartz_cavern/sulfur_ore");

    public static final ResourceKey<Feature> CEILING_SHARD_QUARTZ = resourceKey("quartz_cavern/ceiling_shard_quartz");
    public static final ResourceKey<Feature> CEILING_SHARD_SULFUR_QUARTZ = resourceKey("quartz_cavern/ceiling_shard_sulfur_quartz");
    public static final ResourceKey<Feature> CEILING_SHARD_ROSE_QUARTZ = resourceKey("quartz_cavern/ceiling_shard_rose_quartz");
    public static final ResourceKey<Feature> CEILING_SHARD_SMOKY_QUARTZ = resourceKey("quartz_cavern/ceiling_shard_smoky_quartz");
    public static final ResourceKey<Feature> CEILING_SHARDS = resourceKey("quartz_cavern/ceiling_shards");

    public static final ResourceKey<Feature> FLOOR_SHARD_QUARTZ = resourceKey("quartz_cavern/floor_shard_quartz");
    public static final ResourceKey<Feature> FLOOR_SHARD_SULFUR_QUARTZ = resourceKey("quartz_cavern/floor_shard_sulfur_quartz");
    public static final ResourceKey<Feature> FLOOR_SHARD_ROSE_QUARTZ = resourceKey("quartz_cavern/floor_shard_rose_quartz");
    public static final ResourceKey<Feature> FLOOR_SHARD_SMOKY_QUARTZ = resourceKey("quartz_cavern/floor_shard_smoky_quartz");
    public static final ResourceKey<Feature> FLOOR_SHARDS = resourceKey("quartz_cavern/floor_shards");

    public static final ResourceKey<Feature> POLYPITE_QUARTZ = resourceKey("quartz_cavern/polypite_quartz");
    public static final ResourceKey<Feature> POLYPITE_SULFUR_QUARTZ = resourceKey("quartz_cavern/polypite_sulfur_quartz");
    public static final ResourceKey<Feature> POLYPITE_ROSE_QUARTZ = resourceKey("quartz_cavern/polypite_rose_quartz");
    public static final ResourceKey<Feature> POLYPITE_SMOKY_QUARTZ = resourceKey("quartz_cavern/polypite_smoky_quartz");

    public static void bootstrap(BootstrapContext<Feature> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<BlockStateProvider> blockStateProviders = context.lookup(Registries.BLOCK_STATE_PROVIDER);

        /* ASHY SHOALS */
        CinderscapesRegistry.register(context, DEBRIS_ORE_LARGE, new OreFeature(List.of(BlockReplacement.replace(RULE_TEST_BASE_STONE_NETHER, Blocks.ANCIENT_DEBRIS.defaultBlockState())), 3, 1.0f));
        CinderscapesRegistry.register(context, DEBRIS_ORE_SMALL, new OreFeature(List.of(BlockReplacement.replace(RULE_TEST_BASE_STONE_NETHER, Blocks.ANCIENT_DEBRIS.defaultBlockState())), 2, 1.0f));

        CinderscapesRegistry.register(context, ASH_PILE, new AshPileFeature());
        CinderscapesRegistry.register(context, ASHY_VEGETATION, VegetationFeature.of(
                new WeightedStateProvider(WeightedList.<BlockState>builder()
                        .add(CinderscapesBlocks.SCORCHED_SHRUB.defaultBlockState(), 2)
                        .add(CinderscapesBlocks.SCORCHED_SPROUTS.defaultBlockState(), 5)
                        .add(CinderscapesBlocks.SCORCHED_TENDRILS.defaultBlockState(), 5)
                        .add(CinderscapesBlocks.PYRACINTH.defaultBlockState(), 1)
                        .build()),
                List.of(
                        Blocks.NETHERRACK.defaultBlockState(),
                        Blocks.GRAVEL.defaultBlockState(),
                        Blocks.BLACKSTONE.defaultBlockState(),
                        Blocks.SOUL_SOIL.defaultBlockState(),
                        Blocks.BASALT.defaultBlockState()
                ),
                List.of(
                        CinderscapesBlocks.ASH.defaultBlockState()
                )
        ));
        CinderscapesRegistry.register(context, BRAMBLE_BERRY_BUSHES, new SimpleBlockFeature(BlockStateProvider.of(((BrambleBerryBushBlock) CinderscapesBlocks.BRAMBLE_BERRY_BUSH).getGenerationState())));

        IntProvider BLOB_SPREAD = UniformInt.of(3, 7);
        CinderscapesRegistry.register(context, ASHY_SOUL_SAND, new ReplaceBlobsFeature(Blocks.NETHERRACK.defaultBlockState(), Blocks.SOUL_SAND.defaultBlockState(), BLOB_SPREAD));
        CinderscapesRegistry.register(context, ASHY_SOUL_SOIL, new ReplaceBlobsFeature(Blocks.NETHERRACK.defaultBlockState(), Blocks.SOUL_SOIL.defaultBlockState(), BLOB_SPREAD));
        CinderscapesRegistry.register(context, ASHY_GRAVEL, new ReplaceBlobsFeature(Blocks.NETHERRACK.defaultBlockState(), Blocks.GRAVEL.defaultBlockState(), BLOB_SPREAD));
        CinderscapesRegistry.register(context, ASH_TOP_LAYER, new AshTopLayerFeature());

        CinderscapesRegistry.register(context, DEAD_TREE, new DeadTreeFeature());

        /* BLACKSTONE SHALES */
        CinderscapesRegistry.register(context, BLACKSTONE_WEEPING_VINES, new BlackstoneWeepingVinesFeature());

        CinderscapesRegistry.register(context, SHALES_SOUL_SAND, new ReplaceBlobsFeature(Blocks.NETHERRACK.defaultBlockState(), Blocks.SOUL_SAND.defaultBlockState(), BLOB_SPREAD));
        CinderscapesRegistry.register(context, SHALES_SOUL_SOIL, new ReplaceBlobsFeature(Blocks.NETHERRACK.defaultBlockState(), Blocks.SOUL_SOIL.defaultBlockState(), BLOB_SPREAD));

        CinderscapesRegistry.register(context, SHALE, new ShaleFeature(Blocks.BLACKSTONE.defaultBlockState(), 7, 12));

        /* LUMINOUS GROVE */
        CinderscapesRegistry.register(context, SHROOMLIGHT_BUSH, new ShroomlightBushFeature());
        CinderscapesRegistry.register(context, UMBRAL_VINE, new UmbralVineFeature());

        CinderscapesRegistry.register(context, LUMINOUS_VEGETATION, VegetationFeature.of(
                new WeightedStateProvider(WeightedList.<BlockState>builder()
                        .add(Blocks.WARPED_ROOTS.defaultBlockState(), 1)
                        .add(Blocks.NETHER_SPROUTS.defaultBlockState(), 1)
                        .add(Blocks.WARPED_FUNGUS.defaultBlockState(), 1)
                        .add(CinderscapesBlocks.PHOTOFERN.defaultBlockState(), 2)
                        .add(CinderscapesBlocks.TWILIGHT_FESCUES.defaultBlockState(), 5)
                        .add(CinderscapesBlocks.TWILIGHT_TENDRILS.defaultBlockState(), 5)
                        .add(CinderscapesBlocks.UMBRAL_FUNGUS.defaultBlockState(), 2)
                        .build()),
                List.of(
                        CinderscapesBlocks.UMBRAL_NYLIUM.defaultBlockState()
                )
        ));
        CinderscapesRegistry.register(context, UMBRAL_NYLIUM_BONEMEAL, new VegetationFeature(
                new WeightedStateProvider(WeightedList.<BlockState>builder()
                        .add(Blocks.WARPED_ROOTS.defaultBlockState(), 1)
                        .add(Blocks.NETHER_SPROUTS.defaultBlockState(), 1)
                        .add(Blocks.WARPED_FUNGUS.defaultBlockState(), 1)
                        .add(CinderscapesBlocks.PHOTOFERN.defaultBlockState(), 2)
                        .add(CinderscapesBlocks.TWILIGHT_FESCUES.defaultBlockState(), 5)
                        .add(CinderscapesBlocks.TWILIGHT_TENDRILS.defaultBlockState(), 5)
                        .add(CinderscapesBlocks.UMBRAL_FUNGUS.defaultBlockState(), 2)
                        .build()),
                List.of(
                        CinderscapesBlocks.UMBRAL_NYLIUM.defaultBlockState()
                ),
                List.of(),
                3,
                1
        ));
        CinderscapesRegistry.register(context, LUMINOUS_POD, new SimpleBlockFeature(BlockStateProvider.of(CinderscapesBlocks.LUMINOUS_POD)));
        CinderscapesRegistry.register(context, TALL_PHOTOFERN, new SimpleBlockFeature(BlockStateProvider.of(CinderscapesBlocks.TALL_PHOTOFERN)));

        CinderscapesRegistry.register(context, CANOPIED_HUGE_FUNGUS, new CanopiedHugeFungusFeature(CinderscapesBlocks.UMBRAL_NYLIUM.defaultBlockState(), CinderscapesBlocks.UMBRAL_HYPHAE.defaultBlockState(), CinderscapesBlocks.UMBRAL_STEM.defaultBlockState(), CinderscapesBlocks.UMBRAL_WART_BLOCK.defaultBlockState(), CinderscapesBlocks.UMBRAL_FLESH_BLOCK.defaultBlockState(), Blocks.SHROOMLIGHT.defaultBlockState(), false));
        CinderscapesRegistry.register(context, CANOPIED_HUGE_FUNGUS_PLANTED, new CanopiedHugeFungusFeature(CinderscapesBlocks.UMBRAL_NYLIUM.defaultBlockState(), CinderscapesBlocks.UMBRAL_HYPHAE.defaultBlockState(), CinderscapesBlocks.UMBRAL_STEM.defaultBlockState(), CinderscapesBlocks.UMBRAL_WART_BLOCK.defaultBlockState(), CinderscapesBlocks.UMBRAL_FLESH_BLOCK.defaultBlockState(), Blocks.SHROOMLIGHT.defaultBlockState(), true));

        /* QUARTZ CAVERN */
        CinderscapesRegistry.register(context, QUARTZ_VEGETATION, VegetationFeature.of(
                new WeightedStateProvider(WeightedList.<BlockState>builder()
                        .add(CinderscapesBlocks.CRYSTINIUM.defaultBlockState(), 1)
                        .build()),
                List.of(
                        Blocks.NETHERRACK.defaultBlockState()
                )
        ));

        CinderscapesRegistry.register(context, QUARTZ_ORE, new OreFeature(RULE_TEST_NETHERRACK, Blocks.NETHER_QUARTZ_ORE.defaultBlockState(), 14));
        CinderscapesRegistry.register(context, SULFUR_QUARTZ_ORE, new OreFeature(RULE_TEST_NETHERRACK, CinderscapesBlocks.SULFUR_QUARTZ_ORE.defaultBlockState(), 14));
        CinderscapesRegistry.register(context, ROSE_QUARTZ_ORE, new OreFeature(RULE_TEST_NETHERRACK, CinderscapesBlocks.ROSE_QUARTZ_ORE.defaultBlockState(), 14));
        CinderscapesRegistry.register(context, SMOKY_QUARTZ_ORE, new OreFeature(RULE_TEST_NETHERRACK, CinderscapesBlocks.SMOKY_QUARTZ_ORE.defaultBlockState(), 14));
        CinderscapesRegistry.register(context, GOLD_ORE, new OreFeature(RULE_TEST_NETHERRACK, Blocks.NETHER_GOLD_ORE.defaultBlockState(), 10));
        CinderscapesRegistry.register(context, SULFUR_ORE, new OreFeature(RULE_TEST_NETHERRACK, CinderscapesBlocks.SULFUR_ORE.defaultBlockState(), 14));

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

        CinderscapesRegistry.register(context, CEILING_SHARD_QUARTZ, new CrystalShardFeature(CinderscapesBlocks.CRYSTALLINE_QUARTZ.defaultBlockState(), Direction.DOWN, SHARD_WHITELIST));
        CinderscapesRegistry.register(context, CEILING_SHARD_SULFUR_QUARTZ, new CrystalShardFeature(CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ.defaultBlockState(), Direction.DOWN, SHARD_WHITELIST));
        CinderscapesRegistry.register(context, CEILING_SHARD_ROSE_QUARTZ, new CrystalShardFeature(CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ.defaultBlockState(), Direction.DOWN, SHARD_WHITELIST));
        CinderscapesRegistry.register(context, CEILING_SHARD_SMOKY_QUARTZ, new CrystalShardFeature(CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ.defaultBlockState(), Direction.DOWN, SHARD_WHITELIST));
        CinderscapesRegistry.register(context, CEILING_SHARDS,
                new SimpleRandomSelectorFeature(
                        HolderSet.direct(
                                placedFeatures.getOrThrow(CinderscapesPlacedFeatures.CEILING_SHARD_QUARTZ),
                                placedFeatures.getOrThrow(CinderscapesPlacedFeatures.CEILING_SHARD_ROSE_QUARTZ),
                                placedFeatures.getOrThrow(CinderscapesPlacedFeatures.CEILING_SHARD_SMOKY_QUARTZ),
                                placedFeatures.getOrThrow(CinderscapesPlacedFeatures.CEILING_SHARD_SULFUR_QUARTZ)
                        )
                )
        );

        CinderscapesRegistry.register(context, FLOOR_SHARD_QUARTZ, new CrystalShardFeature(CinderscapesBlocks.CRYSTALLINE_QUARTZ.defaultBlockState(), Direction.UP, SHARD_WHITELIST));
        CinderscapesRegistry.register(context, FLOOR_SHARD_SULFUR_QUARTZ, new CrystalShardFeature(CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ.defaultBlockState(), Direction.UP, SHARD_WHITELIST));
        CinderscapesRegistry.register(context, FLOOR_SHARD_ROSE_QUARTZ, new CrystalShardFeature(CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ.defaultBlockState(), Direction.UP, SHARD_WHITELIST));
        CinderscapesRegistry.register(context, FLOOR_SHARD_SMOKY_QUARTZ, new CrystalShardFeature(CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ.defaultBlockState(), Direction.UP, SHARD_WHITELIST));
        CinderscapesRegistry.register(context, FLOOR_SHARDS,
                new SimpleRandomSelectorFeature(
                        HolderSet.direct(
                                placedFeatures.getOrThrow(CinderscapesPlacedFeatures.FLOOR_SHARD_QUARTZ),
                                placedFeatures.getOrThrow(CinderscapesPlacedFeatures.FLOOR_SHARD_ROSE_QUARTZ),
                                placedFeatures.getOrThrow(CinderscapesPlacedFeatures.FLOOR_SHARD_SMOKY_QUARTZ),
                                placedFeatures.getOrThrow(CinderscapesPlacedFeatures.FLOOR_SHARD_SULFUR_QUARTZ)
                        )
                )
        );

        CinderscapesRegistry.register(context, POLYPITE_QUARTZ, new PolypiteQuartzFeature(CinderscapesBlocks.POLYPITE_QUARTZ.defaultBlockState()));
        CinderscapesRegistry.register(context, POLYPITE_SULFUR_QUARTZ, new PolypiteQuartzFeature(CinderscapesBlocks.POLYPITE_SULFUR_QUARTZ.defaultBlockState()));
        CinderscapesRegistry.register(context, POLYPITE_ROSE_QUARTZ, new PolypiteQuartzFeature(CinderscapesBlocks.POLYPITE_ROSE_QUARTZ.defaultBlockState()));
        CinderscapesRegistry.register(context, POLYPITE_SMOKY_QUARTZ, new PolypiteQuartzFeature(CinderscapesBlocks.POLYPITE_SMOKY_QUARTZ.defaultBlockState()));
    }

    private static ResourceKey<Feature> resourceKey(String path) {
        return ResourceKey.create(Registries.FEATURE, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, path));
    }
}
