package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.feature.config.CanopiedHugeFungusFeatureConfig;
import net.minecraft.block.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CanopiedHugeFungusFeature extends Feature<CanopiedHugeFungusFeatureConfig> {

    public CanopiedHugeFungusFeature() {
        super(CanopiedHugeFungusFeatureConfig.CODEC);
    }

    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator chunkGenerator, Random random, BlockPos pos, CanopiedHugeFungusFeatureConfig config) {

        if (config.planted && !(world.getBlockState(pos.down()) == config.soilBlock && world.getBlockState(pos.down().north()) == config.soilBlock && world.getBlockState(pos.down().north().west()) == config.soilBlock && world.getBlockState(pos.down().north().east()) == config.soilBlock && world.getBlockState(pos.down().south()) == config.soilBlock && world.getBlockState(pos.down().south().west()) == config.soilBlock && world.getBlockState(pos.down().south().east()) == config.soilBlock && world.getBlockState(pos.down().west()) == config.soilBlock && world.getBlockState(pos.down().east()) == config.soilBlock)) {
            return false;
        }

        List<BlockPos> stemBlocks = new ArrayList<>();

        int stemHeight = random.nextInt(20) + 6;

        for (int y = 0; y < stemHeight; y++) {
            stemBlocks.add(pos.add(0, y, 0));
            stemBlocks.add(pos.add(1, y, 0));
            stemBlocks.add(pos.add(-1, y, 0));
            stemBlocks.add(pos.add(0, y, 1));
            stemBlocks.add(pos.add(0, y, -1));
            if (y < stemHeight * 0.2) {
                stemBlocks.add(pos.add(1, y, 1));
                stemBlocks.add(pos.add(1, y, -1));
                stemBlocks.add(pos.add(-1, y, 1));
                stemBlocks.add(pos.add(-1, y, -1));
            }
        }

        List<BlockPos> canopyBlocks = new ArrayList<>();
        List<BlockPos> fleshBlocks = new ArrayList<>();
        List<BlockPos> detailBlocks = new ArrayList<>();

        int canopyRadius = random.nextInt(3) + 5;
        int canopyHeight = random.nextInt(5) + 4;

        for (int x = -canopyRadius; x < canopyRadius; x++) {
            for (int y = 0; y < canopyHeight; y++) {
                for (int z = -canopyRadius; z < canopyRadius; z++) {
                    if ( ((float)(x * x)/(float)(canopyRadius * canopyRadius)) + ((float)(y * y)/(float)(canopyHeight * canopyHeight)) + ((float)(z * z)/(float)(canopyRadius * canopyRadius)) <= 1 ) {
                        if ( ((float)(x * x)/(float)((canopyRadius - 1) * (canopyRadius - 1))) + ((float)(y * y)/(float)((canopyHeight - 1) * (canopyHeight - 1))) + ((float)(z * z)/(float)((canopyRadius - 1) * (canopyRadius - 1))) >= 1) {
                            canopyBlocks.add(pos.up(stemHeight - canopyHeight).add(x, y, z));
                            if (y == 0 && random.nextFloat() > 0.6) {
                                canopyBlocks.add(pos.up(stemHeight - canopyHeight).add(x, y - 1, z));
                            }
                        }
                    }

                    if ( ((float)(x * x)/(float)((canopyRadius - 1) * (canopyRadius - 1))) + ((float)(y * y)/(float)((canopyHeight - 1) * (canopyHeight - 1))) + ((float)(z * z)/(float)((canopyRadius - 1) * (canopyRadius - 1))) <= 1) {
                        if ( ((float)(x * x)/(float)((canopyRadius - 2) * (canopyRadius - 2))) + ((float)(y * y)/(float)((canopyHeight - 2) * (canopyHeight - 2))) + ((float)(z * z)/(float)((canopyRadius - 2) * (canopyRadius - 2))) >= 1) {
                            fleshBlocks.add(pos.up(stemHeight - canopyHeight).add(x, y, z));
                        }
                    }

                    if ( ((float)(x * x)/(float)((canopyRadius - 2) * (canopyRadius - 2))) + ((float)(y * y)/(float)((canopyHeight - 2) * (canopyHeight - 2))) + ((float)(z * z)/(float)((canopyRadius - 2) * (canopyRadius - 2))) <= 1) {
                        if ( ((float)(x * x)/(float)((canopyRadius - 3) * (canopyRadius - 3))) + ((float)(y * y)/(float)((canopyHeight - 3) * (canopyHeight - 3))) + ((float)(z * z)/(float)((canopyRadius - 3) * (canopyRadius - 3))) >= 1) {
                            if (random.nextFloat() > 0.9) {
                                detailBlocks.add(pos.up(stemHeight - canopyHeight).add(x, y, z));
                            }
                        }
                    }
                }
            }
        }

        boolean clear = true;

        for (BlockPos testPos : stemBlocks) {
            if (!(world.isAir(testPos) || world.getBlockState(testPos).getMaterial().equals(Material.PLANT) || world.getBlockState(testPos).getMaterial().equals(Material.REPLACEABLE_PLANT))) clear = false;
        }

        for (BlockPos testPos : canopyBlocks) {
            if (!world.isAir(testPos)) clear = false;
        }

        for (BlockPos testPos : fleshBlocks) {
            if (!world.isAir(testPos)) clear = false;
        }

        for (BlockPos testPos : detailBlocks) {
            if (!world.isAir(testPos)) clear = false;
        }

        if (clear) {
            stemBlocks.forEach((fillPos) -> world.setBlockState(fillPos, config.stemBlock, 3));
            fleshBlocks.forEach((fillPos) -> world.setBlockState(fillPos, config.fleshBlock, 3));
            canopyBlocks.forEach((fillPos) -> world.setBlockState(fillPos, config.canopyBlock, 3));
            detailBlocks.forEach((fillPos) -> world.setBlockState(fillPos, config.decorationBlock, 3));
        }

        return clear;
    }
}
