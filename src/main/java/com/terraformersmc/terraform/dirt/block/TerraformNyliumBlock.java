package com.terraformersmc.terraform.dirt.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.NyliumBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.BlockPileFeatureConfig;
import net.minecraft.world.gen.feature.NetherForestVegetationFeature;

import java.util.Random;

public class TerraformNyliumBlock extends NyliumBlock {

    private final BlockPileFeatureConfig growConfig;

    public TerraformNyliumBlock(Settings settings, BlockPileFeatureConfig growConfig) {
        super(settings);
        this.growConfig = growConfig;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        BlockPos blockPos = pos.up();
        NetherForestVegetationFeature.generate(world, random, blockPos, this.growConfig, 3, 1);
    }
}
