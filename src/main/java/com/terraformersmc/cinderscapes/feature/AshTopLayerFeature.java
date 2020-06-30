package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
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
    public boolean generate(ServerWorldAccess world, StructureAccessor structureAccessor, ChunkGenerator generator, Random random, BlockPos pos, DefaultFeatureConfig config) {
        for(int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = 0; y < 128; y++) {
                    BlockPos testPosition = pos.add(x, y, z);
                    if (!world.getBlockState(testPosition).isOf(Blocks.MAGMA_BLOCK) && Block.isSideSolidFullSquare(world.getBlockState(testPosition), world, testPosition, Direction.UP) && world.isAir(testPosition.up())) {
                        world.setBlockState(testPosition.up(), CinderscapesBlocks.ASH.getDefaultState(), 2);
                    }
                }
            }
        }
        return true;
    }
}
