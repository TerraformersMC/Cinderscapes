package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

/**
 * @author <Wtoll> Will Toll on 2020-06-29
 * @project cinderscapes
 */
public class AshTopLayerFeature extends Feature<DefaultFeatureConfig> {
    public AshTopLayerFeature() {
        super(DefaultFeatureConfig.CODEC);
    }

    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator chunkGenerator, Random random, BlockPos pos, DefaultFeatureConfig featureConfig) {
        for(int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = 0; y < 128; y++) {
                    BlockPos testPosition = pos.add(x, y, z);
                    BlockState testState = world.getBlockState(testPosition);
                    if (!testState.isOf(Blocks.MAGMA_BLOCK) && testState.isSideSolidFullSquare(world, testPosition, Direction.UP) && world.isAir(testPosition.up())) {
                        world.setBlockState(testPosition.up(), CinderscapesBlocks.ASH.getDefaultState(), 2);
                    }
                }
            }
        }
        return true;
    }
}
