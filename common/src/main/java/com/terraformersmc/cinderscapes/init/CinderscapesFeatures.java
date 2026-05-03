package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.block.BrambleBerryBushBlock;
import com.terraformersmc.cinderscapes.feature.AshPileFeature;
import com.terraformersmc.cinderscapes.feature.AshTopLayerFeature;
import com.terraformersmc.cinderscapes.feature.BlackstoneWeepingVinesFeature;
import com.terraformersmc.cinderscapes.feature.CanopiedHugeFungusFeature;
import com.terraformersmc.cinderscapes.feature.CrystalShardFeature;
import com.terraformersmc.cinderscapes.feature.DeadTreeFeature;
import com.terraformersmc.cinderscapes.feature.PolypiteQuartzFeature;
import com.terraformersmc.cinderscapes.feature.ShaleFeature;
import com.terraformersmc.cinderscapes.feature.ShroomlightBushFeature;
import com.terraformersmc.cinderscapes.feature.UmbralVineFeature;
import com.terraformersmc.cinderscapes.feature.VegetationFeature;
import com.terraformersmc.cinderscapes.feature.config.CanopiedHugeFungusFeatureConfig;
import com.terraformersmc.cinderscapes.feature.config.CrystalShardFeatureConfig;
import com.terraformersmc.cinderscapes.feature.config.PolypiteQuartzFeatureConfig;
import com.terraformersmc.cinderscapes.feature.config.ShaleFeatureConfig;
import com.terraformersmc.cinderscapes.feature.config.VegetationFeatureConfig;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.ReplaceSphereConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// TODO: Check
public class CinderscapesFeatures {

    public static Feature<NoneFeatureConfiguration> ASH_TOP_LAYER;
    public static Feature<ShaleFeatureConfig> SHALE_FEATURE;

    public static Feature<NoneFeatureConfiguration> BLACKSTONE_WEEPING_VINES;
    public static Feature<CrystalShardFeatureConfig> CRYSTAL_SHARD_FEATURE;
    public static Feature<NoneFeatureConfiguration> ASH_PILE;

    public static Feature<CanopiedHugeFungusFeatureConfig> CANOPIED_HUGE_FUNGUS;

    public static CanopiedHugeFungusFeatureConfig UMBRAL_FUNGUS_CONFIG;
    public static CanopiedHugeFungusFeatureConfig UMBRAL_FUNGUS_NOT_PLANTED_CONFIG;
    public static Feature<NoneFeatureConfiguration> SHROOMLIGHT_BUSH;
    public static Feature<NoneFeatureConfiguration> UMBRAL_VINE;

    public static Feature<NoneFeatureConfiguration> DEAD_TREE;

    public static Feature<PolypiteQuartzFeatureConfig> POLYPITE_QUARTZ;

    public static Feature<VegetationFeatureConfig> VEGETATION;
    public static VegetationFeatureConfig LUMINOUS_GROVE_VEGETATION_CONFIG;
    public static VegetationFeatureConfig ASHY_SHOALS_VEGETATION_CONFIG;
    public static VegetationFeatureConfig QUARTZ_CAVERN_VEGETATION_CONFIG;

    public static SimpleBlockConfiguration TALL_PHOTOFERN_CONFIG;
    public static SimpleBlockConfiguration LUMINOUS_POD_CONFIG;

    public static SimpleBlockConfiguration BRAMBLE_BERRY_BUSH_CONFIG;

    public static ReplaceSphereConfiguration SOUL_SAND_REPLACE_CONFIG;
    public static ReplaceSphereConfiguration SOUL_SOIL_REPLACE_CONFIG;
    public static ReplaceSphereConfiguration GRAVEL_REPLACE_CONFIG;
    public static ReplaceSphereConfiguration CRIMSON_NYLIUM_REPLACE_CONFIG;
    public static ReplaceSphereConfiguration BLACKSTONE_REPLACE_CONFIG;

    public static void init() {

        ASH_TOP_LAYER = Registry.register(BuiltInRegistries.FEATURE, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, "ash_top_layer"), new AshTopLayerFeature());

        UMBRAL_FUNGUS_CONFIG = new CanopiedHugeFungusFeatureConfig(CinderscapesBlocks.UMBRAL_NYLIUM.defaultBlockState(), CinderscapesBlocks.UMBRAL_HYPHAE.defaultBlockState(), CinderscapesBlocks.UMBRAL_STEM.defaultBlockState(), CinderscapesBlocks.UMBRAL_WART_BLOCK.defaultBlockState(), CinderscapesBlocks.UMBRAL_FLESH_BLOCK.defaultBlockState(), Blocks.SHROOMLIGHT.defaultBlockState(), true);
        UMBRAL_FUNGUS_NOT_PLANTED_CONFIG = UMBRAL_FUNGUS_CONFIG.withPlanted(false);

        CANOPIED_HUGE_FUNGUS = Registry.register(BuiltInRegistries.FEATURE, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, "canopied_huge_fungus"), new CanopiedHugeFungusFeature());

        SHROOMLIGHT_BUSH = Registry.register(BuiltInRegistries.FEATURE, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, "shroomlight_bush"), new ShroomlightBushFeature());
        UMBRAL_VINE = Registry.register(BuiltInRegistries.FEATURE, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, "umbral_vine"), new UmbralVineFeature());

        VEGETATION = Registry.register(BuiltInRegistries.FEATURE, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, "vegetation"), new VegetationFeature());

        LUMINOUS_GROVE_VEGETATION_CONFIG = new VegetationFeatureConfig(
                new WeightedStateProvider(WeightedList.<BlockState>builder()
                        .add(Blocks.WARPED_ROOTS.defaultBlockState(), 1)
                        .add(Blocks.NETHER_SPROUTS.defaultBlockState(), 1)
                        .add(Blocks.WARPED_FUNGUS.defaultBlockState(), 1)
                        .add(CinderscapesBlocks.PHOTOFERN.defaultBlockState(), 2)
                        .add(CinderscapesBlocks.TWILIGHT_FESCUES.defaultBlockState(), 5)
                        .add(CinderscapesBlocks.TWILIGHT_TENDRILS.defaultBlockState(), 5)
                        .add(CinderscapesBlocks.UMBRAL_FUNGUS.defaultBlockState(), 2).build()),
                Collections.singletonList(
                        CinderscapesBlocks.UMBRAL_NYLIUM.defaultBlockState()
                )
        );

        QUARTZ_CAVERN_VEGETATION_CONFIG = new VegetationFeatureConfig(
                new WeightedStateProvider(WeightedList.<BlockState>builder()
                        .add(CinderscapesBlocks.CRYSTINIUM.defaultBlockState(), 1).build()),
                Arrays.asList(
                        Blocks.NETHERRACK.defaultBlockState()
                )
        );

        ASHY_SHOALS_VEGETATION_CONFIG = new VegetationFeatureConfig(
                new WeightedStateProvider(WeightedList.<BlockState>builder()
                        .add(CinderscapesBlocks.SCORCHED_SHRUB.defaultBlockState(), 2)
                        .add(CinderscapesBlocks.SCORCHED_SPROUTS.defaultBlockState(), 5)
                        .add(CinderscapesBlocks.SCORCHED_TENDRILS.defaultBlockState(), 5)
                        .add(CinderscapesBlocks.PYRACINTH.defaultBlockState(), 1).build()),
                Arrays.asList(
                        Blocks.NETHERRACK.defaultBlockState(),
                        Blocks.GRAVEL.defaultBlockState(),
                        Blocks.BLACKSTONE.defaultBlockState(),
                        Blocks.SOUL_SOIL.defaultBlockState(),
                        Blocks.BASALT.defaultBlockState()
                ),
                Arrays.asList(
                        CinderscapesBlocks.ASH.defaultBlockState()
                )
        );

        TALL_PHOTOFERN_CONFIG = new SimpleBlockConfiguration(BlockStateProvider.simple(CinderscapesBlocks.TALL_PHOTOFERN.defaultBlockState()));
        LUMINOUS_POD_CONFIG = new SimpleBlockConfiguration(BlockStateProvider.simple(CinderscapesBlocks.LUMINOUS_POD.defaultBlockState()));
        BRAMBLE_BERRY_BUSH_CONFIG = new SimpleBlockConfiguration(BlockStateProvider.simple(((BrambleBerryBushBlock) CinderscapesBlocks.BRAMBLE_BERRY_BUSH).getGenerationState()));

        SHALE_FEATURE = Registry.register(BuiltInRegistries.FEATURE, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, "shale"), new ShaleFeature());

        BLACKSTONE_WEEPING_VINES = Registry.register(BuiltInRegistries.FEATURE, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, "blackstone_weeping_vines"), new BlackstoneWeepingVinesFeature());

        CRYSTAL_SHARD_FEATURE = Registry.register(BuiltInRegistries.FEATURE, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, "crystal_shard"), new CrystalShardFeature());

        POLYPITE_QUARTZ = Registry.register(BuiltInRegistries.FEATURE, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, "polypite_quartz"), new PolypiteQuartzFeature());

        ASH_PILE = Registry.register(BuiltInRegistries.FEATURE, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, "ash_pile"), new AshPileFeature());

        DEAD_TREE = Registry.register(BuiltInRegistries.FEATURE, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, "dead_tree"), new DeadTreeFeature());

        IntProvider spread = UniformInt.of(3, 7);
        SOUL_SAND_REPLACE_CONFIG = new ReplaceSphereConfiguration(Blocks.NETHERRACK.defaultBlockState(), Blocks.SOUL_SAND.defaultBlockState(), spread);
        SOUL_SOIL_REPLACE_CONFIG = new ReplaceSphereConfiguration(Blocks.NETHERRACK.defaultBlockState(), Blocks.SOUL_SOIL.defaultBlockState(), spread);
        GRAVEL_REPLACE_CONFIG = new ReplaceSphereConfiguration(Blocks.NETHERRACK.defaultBlockState(), Blocks.GRAVEL.defaultBlockState(), spread);
        CRIMSON_NYLIUM_REPLACE_CONFIG = new ReplaceSphereConfiguration(Blocks.NETHERRACK.defaultBlockState(), Blocks.CRIMSON_NYLIUM.defaultBlockState(), spread);
        BLACKSTONE_REPLACE_CONFIG = new ReplaceSphereConfiguration(Blocks.NETHERRACK.defaultBlockState(), Blocks.BLACKSTONE.defaultBlockState(), spread);
    }
}
