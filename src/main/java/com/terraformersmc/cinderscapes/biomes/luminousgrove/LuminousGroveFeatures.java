package com.terraformersmc.cinderscapes.biomes.luminousgrove;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.biomes.luminousgrove.feature.CanopiedHugeFungusFeature;
import com.terraformersmc.cinderscapes.biomes.luminousgrove.feature.config.CanopiedHugeFungusFeatureConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.collection.DataPool;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

public class LuminousGroveFeatures {

    public static final CanopiedHugeFungusFeatureConfig UMBRAL_FUNGUS_CONFIG = new CanopiedHugeFungusFeatureConfig(LuminousGroveBlocks.UMBRAL_NYLIUM.getDefaultState(), LuminousGroveBlocks.UMBRAL_STEM.getDefaultState(), LuminousGroveBlocks.UMBRAL_WART_BLOCK.getDefaultState(), LuminousGroveBlocks.UMBRAL_FLESH_BLOCK.getDefaultState(), Blocks.SHROOMLIGHT.getDefaultState(), true);
    public static final CanopiedHugeFungusFeatureConfig UMBRAL_FUNGUS_NOT_PLANTED_CONFIG = UMBRAL_FUNGUS_CONFIG.withPlanted(false);

    public static final CanopiedHugeFungusFeature CANOPIED_HUGE_FUNGUS = Cinderscapes.REGISTRATION_HELPER.register(new CanopiedHugeFungusFeature(), "canopied_huge_fungus");

    public static final BlockPileFeatureConfig VEGETATION_CONFIG = new BlockPileFeatureConfig(new WeightedBlockStateProvider(new DataPool.Builder<BlockState>()
            .add(Blocks.WARPED_ROOTS.getDefaultState(), 1)
            .add(Blocks.CRIMSON_ROOTS.getDefaultState(), 1)
            .add(LuminousGroveBlocks.TWILIGHT_FESCUES.getDefaultState(), 85)
            .add(LuminousGroveBlocks.TWILIGHT_TENDRILS.getDefaultState(), 40)
            .add(LuminousGroveBlocks.UMBRAL_FUNGUS.getDefaultState(), 15)
            .add(Blocks.WARPED_FUNGUS.getDefaultState(), 1)
            .add(Blocks.CRIMSON_FUNGUS.getDefaultState(), 1)
            .add(Blocks.NETHER_SPROUTS.getDefaultState(), 3)
    ));

    public static final BlockPileFeatureConfig PHOTOFERNS = new BlockPileFeatureConfig(new WeightedBlockStateProvider(new DataPool.Builder<BlockState>()
            .add(LuminousGroveBlocks.TWILIGHT_FESCUES.getDefaultState(), 10)
            .add(LuminousGroveBlocks.TWILIGHT_TENDRILS.getDefaultState(), 5)
            .add(LuminousGroveBlocks.PHOTOFERN.getDefaultState(), 85)
            .add(LuminousGroveBlocks.TALL_PHOTOFERN.getDefaultState(), 40)
            .add(LuminousGroveBlocks.UMBRAL_FUNGUS.getDefaultState(), 15)
            .add(Blocks.NETHER_SPROUTS.getDefaultState(), 3)
    ));

    public static final BlockPileFeatureConfig LUMINOUS_POD = new BlockPileFeatureConfig(new WeightedBlockStateProvider(new DataPool.Builder<BlockState>()
            .add(LuminousGroveBlocks.TWILIGHT_FESCUES.getDefaultState(), 10)
            .add(LuminousGroveBlocks.TWILIGHT_TENDRILS.getDefaultState(), 5)
            .add(LuminousGroveBlocks.LUMINOUS_POD.getDefaultState(), 125)
            .add(LuminousGroveBlocks.UMBRAL_FUNGUS.getDefaultState(), 15)
            .add(Blocks.NETHER_SPROUTS.getDefaultState(), 3)
    ));

    public static void onInitializeCommon() { }
}
