package com.terraformersmc.cinderscapes.init;

import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.BlockPileFeatureConfig;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

public class CinderscapesBiomeFeatures {
    public static final BlockPileFeatureConfig RADIANT_ROOTS_CONFIG = new BlockPileFeatureConfig((new WeightedBlockStateProvider()).addState(CinderscapesBlocks.RADIANT_ROOTS.getDefaultState(), 85).addState(Blocks.WARPED_ROOTS.getDefaultState(), 1).addState(CinderscapesBlocks.WITHERED_FUNGUS.getDefaultState(), 13).addState(Blocks.WARPED_FUNGUS.getDefaultState(), 2).addState(Blocks.CRIMSON_FUNGUS.getDefaultState(), 1));
    public static final BlockPileFeatureConfig FLAY_CONFIG = new BlockPileFeatureConfig(new SimpleBlockStateProvider(CinderscapesBlocks.FLAY.getDefaultState()));

}
