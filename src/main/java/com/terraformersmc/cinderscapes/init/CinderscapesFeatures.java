package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.block.BrambleBerryBushBlock;
import com.terraformersmc.cinderscapes.feature.*;
import com.terraformersmc.cinderscapes.feature.config.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ReplaceSphereConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import org.jspecify.annotations.NullMarked;

import java.util.Arrays;
import java.util.Collections;

@NullMarked
public class CinderscapesFeatures {
    /* ASHY SHOALS */
    public static final Feature<NoneFeatureConfiguration> ASH_PILE = Registry.register(BuiltInRegistries.FEATURE, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, "ash_pile"), new AshPileFeature());
    public static final VegetationFeatureConfig ASHY_SHOALS_VEGETATION_CONFIG = new VegetationFeatureConfig(
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
    public static final Feature<VegetationFeatureConfig> CINDERSCAPES_VEGETATION = Registry.register(BuiltInRegistries.FEATURE, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, "vegetation"), new VegetationFeature());
    public static final SimpleBlockConfiguration BRAMBLE_BERRY_BUSH_CONFIG = new SimpleBlockConfiguration(BlockStateProvider.simple(((BrambleBerryBushBlock) CinderscapesBlocks.BRAMBLE_BERRY_BUSH).getGenerationState()));

    private static final IntProvider BLOB_SPREAD = UniformInt.of(3, 7);
    public static final ReplaceSphereConfiguration SOUL_SAND_REPLACE_CONFIG = new ReplaceSphereConfiguration(Blocks.NETHERRACK.defaultBlockState(), Blocks.SOUL_SAND.defaultBlockState(), BLOB_SPREAD);
    public static final ReplaceSphereConfiguration SOUL_SOIL_REPLACE_CONFIG = new ReplaceSphereConfiguration(Blocks.NETHERRACK.defaultBlockState(), Blocks.SOUL_SOIL.defaultBlockState(), BLOB_SPREAD);
    public static final ReplaceSphereConfiguration GRAVEL_REPLACE_CONFIG = new ReplaceSphereConfiguration(Blocks.NETHERRACK.defaultBlockState(), Blocks.GRAVEL.defaultBlockState(), BLOB_SPREAD);
    public static final ReplaceSphereConfiguration CRIMSON_NYLIUM_REPLACE_CONFIG = new ReplaceSphereConfiguration(Blocks.NETHERRACK.defaultBlockState(), Blocks.CRIMSON_NYLIUM.defaultBlockState(), BLOB_SPREAD);
    public static final ReplaceSphereConfiguration BLACKSTONE_REPLACE_CONFIG = new ReplaceSphereConfiguration(Blocks.NETHERRACK.defaultBlockState(), Blocks.BLACKSTONE.defaultBlockState(), BLOB_SPREAD);
    public static final Feature<NoneFeatureConfiguration> ASH_TOP_LAYER = Registry.register(BuiltInRegistries.FEATURE, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, "ash_top_layer"), new AshTopLayerFeature());

    public static final Feature<NoneFeatureConfiguration> DEAD_TREE = Registry.register(BuiltInRegistries.FEATURE, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, "dead_tree"), new DeadTreeFeature());

    /* BLACKSTONE SHALES */
    public static final Feature<NoneFeatureConfiguration> BLACKSTONE_WEEPING_VINES = Registry.register(BuiltInRegistries.FEATURE, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, "blackstone_weeping_vines"), new BlackstoneWeepingVinesFeature());

    public static final Feature<ShaleFeatureConfig> SHALE_FEATURE = Registry.register(BuiltInRegistries.FEATURE, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, "shale"), new ShaleFeature());

    /* LUMINOUS GROVE */
    public static final Feature<NoneFeatureConfiguration> SHROOMLIGHT_BUSH = Registry.register(BuiltInRegistries.FEATURE, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, "shroomlight_bush"), new ShroomlightBushFeature());
    public static final Feature<NoneFeatureConfiguration> UMBRAL_VINE = Registry.register(BuiltInRegistries.FEATURE, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, "umbral_vine"), new UmbralVineFeature());

    public static final VegetationFeatureConfig LUMINOUS_GROVE_VEGETATION_CONFIG = new VegetationFeatureConfig(
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
    public static final SimpleBlockConfiguration LUMINOUS_POD_CONFIG = new SimpleBlockConfiguration(BlockStateProvider.simple(CinderscapesBlocks.LUMINOUS_POD));
    public static final SimpleBlockConfiguration TALL_PHOTOFERN_CONFIG = new SimpleBlockConfiguration(BlockStateProvider.simple(CinderscapesBlocks.TALL_PHOTOFERN));

    public static final Feature<CanopiedHugeFungusFeatureConfig> CANOPIED_HUGE_FUNGUS = Registry.register(BuiltInRegistries.FEATURE, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, "canopied_huge_fungus"), new CanopiedHugeFungusFeature());

    public static final CanopiedHugeFungusFeatureConfig UMBRAL_FUNGUS_CONFIG = new CanopiedHugeFungusFeatureConfig(CinderscapesBlocks.UMBRAL_NYLIUM.defaultBlockState(), CinderscapesBlocks.UMBRAL_HYPHAE.defaultBlockState(), CinderscapesBlocks.UMBRAL_STEM.defaultBlockState(), CinderscapesBlocks.UMBRAL_WART_BLOCK.defaultBlockState(), CinderscapesBlocks.UMBRAL_FLESH_BLOCK.defaultBlockState(), Blocks.SHROOMLIGHT.defaultBlockState(), true);
    public static final CanopiedHugeFungusFeatureConfig UMBRAL_FUNGUS_NOT_PLANTED_CONFIG = UMBRAL_FUNGUS_CONFIG.withPlanted(false);

    /* QUARTZ CAVERN */
    public static final VegetationFeatureConfig QUARTZ_CAVERN_VEGETATION_CONFIG = new VegetationFeatureConfig(
            new WeightedStateProvider(WeightedList.<BlockState>builder()
                    .add(CinderscapesBlocks.CRYSTINIUM.defaultBlockState(), 1).build()),
            Arrays.asList(
                    Blocks.NETHERRACK.defaultBlockState()
            )
    );

    public static final Feature<CrystalShardFeatureConfig> CRYSTAL_SHARD_FEATURE = Registry.register(BuiltInRegistries.FEATURE, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, "crystal_shard"), new CrystalShardFeature());

    public static final Feature<PolypiteQuartzFeatureConfig> POLYPITE_QUARTZ = Registry.register(BuiltInRegistries.FEATURE, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, "polypite_quartz"), new PolypiteQuartzFeature());

    public static void init() {}
}
