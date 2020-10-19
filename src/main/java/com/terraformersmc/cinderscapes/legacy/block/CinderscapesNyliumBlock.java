package com.terraformersmc.cinderscapes.legacy.block;

import com.terraformersmc.cinderscapes.legacy.feature.VegetationFeature;
import com.terraformersmc.cinderscapes.legacy.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.legacy.init.CinderscapesFeatures;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.NyliumBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

// TODO: Look into maybe removing the method and defining that behavior at declaration
public class CinderscapesNyliumBlock extends NyliumBlock {
    public CinderscapesNyliumBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        Block block = world.getBlockState(pos).getBlock();
        BlockPos blockPos = pos.up();

        if (block == CinderscapesBlocks.UMBRAL_NYLIUM) {
            VegetationFeature.generateVegetation(world, random, blockPos, CinderscapesFeatures.LUMINOUS_GROVE_VEGETATION_CONFIG, 3, 1);
        }

    }
}
