package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

//TODO: Rewrite using the upcoming shapes library
//TODO: Make a feature config allowing the material and size range to change
public class AshPileFeature extends Feature<DefaultFeatureConfig> {
    public AshPileFeature() {
        super(DefaultFeatureConfig.CODEC);
    }

    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator chunkGenerator, Random random, BlockPos pos, DefaultFeatureConfig featureConfig) {
        int yradius = random.nextInt(5) + 7;

        while(true) {
            search:
            {
                if (pos.getY() <= 3) {
                    return false;
                }

                if (pos.getY() > (128 - 2 * yradius)) {
                    break search;
                }

                if (world.isAir(pos.down())) {
                    break search;
                }

                for (int y = 1; y <= 4; y++) {
                    Block block = world.getBlockState(pos.down(y)).getBlock();
                    if (!(block == Blocks.NETHERRACK || block == Blocks.SOUL_SOIL || block == Blocks.GRAVEL)) {
                        break search;
                    }
                }

                for (int i = 0; i < 50; i++) {
                    BlockPos setPos = pos.add(random.nextInt(5) - random.nextInt(5), 0, random.nextInt(5) - random.nextInt(5));

                    BlockState setState = world.getBlockState(setPos);

                    while (world.isAir(setPos.down()) || world.getBlockState(setPos.down()).isOf(CinderscapesBlocks.ASH)) {
                        setPos = setPos.down();
                    }

                    while (setState.isOf(CinderscapesBlocks.ASH_BLOCK) && setPos.getY() < 256) {
                        if (world.isAir(setPos.up()) || world.getBlockState(setPos.up()).isOf(CinderscapesBlocks.ASH)) {
                            setPos = setPos.up();
                            setState = world.getBlockState(setPos);
                        } else {
                            break;
                        }
                    }

                    if (world.isAir(setPos) || world.getBlockState(setPos).isOf(CinderscapesBlocks.ASH)) {
                        world.setBlockState(setPos, CinderscapesBlocks.ASH_BLOCK.getDefaultState(), 4);
                    }
                }

                // Return because we are done generating and return true to indicate a successful generation
                return true;
            }

            pos = pos.down();
        }
    }
}
