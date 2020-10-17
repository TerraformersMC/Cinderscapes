package com.terraformersmc.cinderscapes.block;

import com.terraformersmc.cinderscapes.feature.config.CanopiedHugeFungusFeatureConfig;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FungusBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.Random;
import java.util.function.Supplier;

public class CinderscapesCanopiedFungusBlock extends FungusBlock {
    private final Supplier<ConfiguredFeature<CanopiedHugeFungusFeatureConfig, ?>> config;

    public CinderscapesCanopiedFungusBlock(Settings settings, Supplier<ConfiguredFeature<CanopiedHugeFungusFeatureConfig, ?>> supplier) {
        super(settings, null);
        this.config = supplier;
    }

    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        Block block = ((this.config.get()).config).soilBlock.getBlock();
        Block block2 = world.getBlockState(pos.down()).getBlock();
        return block2 == block;
    }

    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        (this.config.get()).generate(world, world.getChunkManager().getChunkGenerator(), random, pos);
    }
}
