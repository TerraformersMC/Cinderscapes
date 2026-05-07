package com.terraformersmc.cinderscapes.block;

import com.terraformersmc.cinderscapes.feature.VegetationFeature;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.init.CinderscapesFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.NyliumBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NullMarked;

// TODO: Look into maybe removing the method and defining that behavior at declaration
@NullMarked
public class CinderscapesNyliumBlock extends NyliumBlock {
    public CinderscapesNyliumBlock(Properties settings) {
        super(settings);
    }

    @Override
    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState state) {
        Block block = world.getBlockState(pos).getBlock();
        BlockPos blockPos = pos.above();

        if (block == CinderscapesBlocks.UMBRAL_NYLIUM) {
            VegetationFeature.generateVegetation(world, random, blockPos, CinderscapesFeatures.LUMINOUS_GROVE_VEGETATION_CONFIG, 3, 1);
        }
    }
}
