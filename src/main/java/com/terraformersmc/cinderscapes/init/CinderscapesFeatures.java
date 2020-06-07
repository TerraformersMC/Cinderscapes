package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.block.BrambleBerryBushBlock;
import com.terraformersmc.cinderscapes.feature.*;
import com.terraformersmc.cinderscapes.feature.config.CanopiedHugeFungusFeatureConfig;
import com.terraformersmc.cinderscapes.feature.config.PolypiteQuartzFeatureConfig;
import com.terraformersmc.cinderscapes.feature.config.ShardFeatureConfig;
import com.terraformersmc.cinderscapes.feature.config.VegetationFeatureConfig;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placer.DoublePlantPlacer;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

import java.util.Arrays;

// TODO: Check
public class CinderscapesFeatures {

    public static Feature<DefaultFeatureConfig> BLACKSTONE_SHALE;
    public static Feature<DefaultFeatureConfig> BLACKSTONE_LAVA_SHALE;
    public static Feature<DefaultFeatureConfig> BLACKSTONE_WEEPING_VINES;
    public static Feature<ShardFeatureConfig> CEILING_SHARD;
    public static Feature<ShardFeatureConfig> FLOOR_SHARD;
    public static Feature<DefaultFeatureConfig> ASH_PILE;

    public static Feature<CanopiedHugeFungusFeatureConfig> CANOPIED_HUGE_FUNGUS;

    public static HugeFungusFeatureConfig UMBRAL_FUNGUS_CONFIG;
    public static HugeFungusFeatureConfig UMBRAL_FUNGUS_NOT_PLANTED_CONFIG;
    public static Feature<DefaultFeatureConfig> SHROOMLIGHT_BUSH;
    public static Feature<DefaultFeatureConfig> UMBRAL_VINE;

    public static Feature<DefaultFeatureConfig> DEAD_TREE;

    public static Feature<PolypiteQuartzFeatureConfig> POLYPITE_QUARTZ;

    public static Feature<VegetationFeatureConfig> VEGETATION;
    public static VegetationFeatureConfig LUMINOUS_GROVE_VEGETATION_CONFIG;
    public static VegetationFeatureConfig ASHY_SHOALS_VEGETATION_CONFIG;
    public static VegetationFeatureConfig QUARTZ_CANYON_VEGETATION_CONFIG;

    public static RandomPatchFeatureConfig TALL_PHOTOFERN_CONFIG;
    public static RandomPatchFeatureConfig LUMINOUS_POD_CONFIG;

    public static RandomPatchFeatureConfig BRAMBLE_BERRY_BUSH_CONFIG;

    public static NetherrackReplaceBlobsFeatureConfig SOUL_SAND_REPLACE_CONFIG;
    public static NetherrackReplaceBlobsFeatureConfig SOUL_SOIL_REPLACE_CONFIG;
    public static NetherrackReplaceBlobsFeatureConfig GRAVEL_REPLACE_CONFIG;

    public static void init() {
        UMBRAL_FUNGUS_CONFIG = new HugeFungusFeatureConfig(CinderscapesBlocks.UMBRAL_NYLIUM.getDefaultState(), CinderscapesBlocks.UMBRAL_STEM.getDefaultState(), CinderscapesBlocks.UMBRAL_WART_BLOCK.getDefaultState(), Blocks.SHROOMLIGHT.getDefaultState(), true);
        UMBRAL_FUNGUS_NOT_PLANTED_CONFIG = new HugeFungusFeatureConfig(UMBRAL_FUNGUS_CONFIG.validBaseBlock, UMBRAL_FUNGUS_CONFIG.stemState, UMBRAL_FUNGUS_CONFIG.hatState, UMBRAL_FUNGUS_CONFIG.decorationState, false);

        CANOPIED_HUGE_FUNGUS = Registry.register(Registry.FEATURE, Cinderscapes.id("canopied_huge_fungus"), new CanopiedHugeFungusFeature());

        SHROOMLIGHT_BUSH = Registry.register(Registry.FEATURE, Cinderscapes.id("shroomlight_bush"), new ShroomlightBushFeature());
        UMBRAL_VINE = Registry.register(Registry.FEATURE, Cinderscapes.id("umbral_vine"), new UmbralVineFeature());

        VEGETATION = Registry.register(Registry.FEATURE, Cinderscapes.id("vegetation"), new VegetationFeature());

        LUMINOUS_GROVE_VEGETATION_CONFIG = new VegetationFeatureConfig(
            new WeightedBlockStateProvider()
                .addState(Blocks.WARPED_ROOTS.getDefaultState(), 1)
                .addState(Blocks.NETHER_SPROUTS.getDefaultState(), 1)
                .addState(Blocks.WARPED_FUNGUS.getDefaultState(), 1)
                .addState(CinderscapesBlocks.PHOTOFERN.getDefaultState(), 2)
                .addState(CinderscapesBlocks.TWILIGHT_FESCUES.getDefaultState(), 5)
                .addState(CinderscapesBlocks.TWILIGHT_TENDRILS.getDefaultState(), 5)
                .addState(CinderscapesBlocks.UMBRAL_FUNGUS.getDefaultState(), 2),
            Arrays.asList(
                CinderscapesBlocks.UMBRAL_NYLIUM.getDefaultState()
            )
        );

        QUARTZ_CANYON_VEGETATION_CONFIG = new VegetationFeatureConfig(
            new WeightedBlockStateProvider()
                .addState(CinderscapesBlocks.CRYSTINIUM.getDefaultState(), 1),
            Arrays.asList(
                Blocks.NETHERRACK.getDefaultState()
            )
        );

        ASHY_SHOALS_VEGETATION_CONFIG = new VegetationFeatureConfig(
            new WeightedBlockStateProvider()
                .addState(CinderscapesBlocks.SCORCHED_SHRUB.getDefaultState(), 2)
                .addState(CinderscapesBlocks.SCORCHED_SPROUTS.getDefaultState(), 5)
                .addState(CinderscapesBlocks.SCORCHED_TENDRILS.getDefaultState(), 5)
                .addState(CinderscapesBlocks.PYRACINTH.getDefaultState(), 1),
            Arrays.asList(
                Blocks.NETHERRACK.getDefaultState(),
                Blocks.GRAVEL.getDefaultState(),
                Blocks.BLACKSTONE.getDefaultState(),
                Blocks.SOUL_SOIL.getDefaultState(),
                Blocks.BASALT.getDefaultState()
            ),
            Arrays.asList(
                CinderscapesBlocks.ASH.getDefaultState()
            )
        );

        TALL_PHOTOFERN_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(CinderscapesBlocks.TALL_PHOTOFERN.getDefaultState()), new DoublePlantPlacer())).tries(64).cannotProject().build();
        LUMINOUS_POD_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(CinderscapesBlocks.LUMINOUS_POD.getDefaultState()), new DoublePlantPlacer())).tries(64).cannotProject().build();
        BRAMBLE_BERRY_BUSH_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(((BrambleBerryBushBlock) CinderscapesBlocks.BRAMBLE_BERRY_BUSH).getGenerationState()), SimpleBlockPlacer.field_24871)).tries(64).cannotProject().canReplace().build();

        BLACKSTONE_SHALE = Registry.register(Registry.FEATURE, Cinderscapes.id("blackstone_shale"), new BlackstoneShaleFeature());
        BLACKSTONE_LAVA_SHALE = Registry.register(Registry.FEATURE, Cinderscapes.id("blackstone_lava_shale"), new BlackstoneLavaShaleFeature());
        BLACKSTONE_WEEPING_VINES = Registry.register(Registry.FEATURE, Cinderscapes.id("blackstone_weeping_vines"), new BlackstoneWeepingVinesFeature());

        CEILING_SHARD = Registry.register(Registry.FEATURE, Cinderscapes.id("ceiling_shard"), new CeilingShardFeature());
        FLOOR_SHARD = Registry.register(Registry.FEATURE, Cinderscapes.id("floor_shard"), new FloorShardFeature());

        POLYPITE_QUARTZ = Registry.register(Registry.FEATURE, Cinderscapes.id("polypite_quartz"), new PolypiteQuartzFeature());

        ASH_PILE = Registry.register(Registry.FEATURE, Cinderscapes.id("ash_pile"), new AshPileFeature());

        DEAD_TREE = Registry.register(Registry.FEATURE, Cinderscapes.id("dead_tree"), new DeadTreeFeature());

        SOUL_SAND_REPLACE_CONFIG = (new NetherrackReplaceBlobsFeatureConfig.Builder()).minReachPos(new Vec3i(3, 3, 3)).maxReachPos(new Vec3i(7, 7, 7)).target(Blocks.NETHERRACK.getDefaultState()).state(Blocks.SOUL_SAND.getDefaultState()).build();
        SOUL_SOIL_REPLACE_CONFIG = (new NetherrackReplaceBlobsFeatureConfig.Builder()).minReachPos(new Vec3i(3, 3, 3)).maxReachPos(new Vec3i(7, 7, 7)).target(Blocks.NETHERRACK.getDefaultState()).state(Blocks.SOUL_SOIL.getDefaultState()).build();
        GRAVEL_REPLACE_CONFIG = (new NetherrackReplaceBlobsFeatureConfig.Builder()).minReachPos(new Vec3i(3, 3, 3)).maxReachPos(new Vec3i(7, 7, 7)).target(Blocks.NETHERRACK.getDefaultState()).state(Blocks.GRAVEL.getDefaultState()).build();
    }
}
