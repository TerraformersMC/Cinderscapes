package com.terraformersmc.cinderscapes.block;

import com.terraformersmc.cinderscapes.luminousgrove.feature.CanopiedHugeFungusFeature;
import com.terraformersmc.cinderscapes.luminousgrove.feature.config.CanopiedHugeFungusFeatureConfig;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FungusBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.HugeFungusFeatureConfig;

import java.util.Random;
import java.util.function.Supplier;

public class CinderscapesCanopiedFungusBlock extends FungusBlock {

    private final Supplier<ConfiguredFeature<CanopiedHugeFungusFeatureConfig, CanopiedHugeFungusFeature>> feature;

    public CinderscapesCanopiedFungusBlock(Settings settings, Supplier<ConfiguredFeature<CanopiedHugeFungusFeatureConfig, CanopiedHugeFungusFeature>> feature) {
        super(settings, null);
        this.feature = feature;
    }

    @Override
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        Block block = this.feature.get().config.soilBlock.getBlock();
        BlockState blockState = world.getBlockState(pos.down());
        return blockState.isOf(block);
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        this.feature.get().generate(world, world.getChunkManager().getChunkGenerator(), random, pos);
    }
}
