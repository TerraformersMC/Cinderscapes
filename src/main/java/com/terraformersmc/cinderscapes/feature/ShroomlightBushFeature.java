package com.terraformersmc.cinderscapes.feature;

import com.mojang.datafixers.Dynamic;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;
import java.util.function.Function;

public class ShroomlightBushFeature extends Feature<DefaultFeatureConfig> {
    public ShroomlightBushFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> configDeserializer) {
        super(configDeserializer);
    }

    @Override
    public boolean generate(IWorld world, StructureAccessor accessor, ChunkGenerator<? extends ChunkGeneratorConfig> generator, Random random, BlockPos pos, DefaultFeatureConfig config) {
        while(true) {
            search: {
                // If you've gone through all layers and haven't found a suitable spot then return false
                // so that we don't get stuck in an endless loop
                if (pos.getY() <= 3) {
                    return false;
                }

                // If the blob would be generating above the nether ceiling then move down
                if (pos.getY() > (128 - 4) ) {
                    break search;
                }

                // If there's air under the blob then move down
                if (world.isAir(pos.down())) {
                    break search;
                }

                // If the four blocks below are not one of netherrack, luminous nylium, or luminous wart block then move down
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 2; y++) {
                        for (int z = -1; z <= 1; z++) {
                            Block block = world.getBlockState(pos.up(y).north(z).east(x)).getBlock();
                            if (y >= 0) {
                                if (block != Blocks.AIR) break search;
                            } else {
                                if (block != Blocks.NETHERRACK && block != CinderscapesBlocks.LUMINOUS_NYLIUM && block != CinderscapesBlocks.LUMINOUS_WART_BLOCK) break search;
                            }
                        }
                    }
                }


                // At this point, if we haven't broken, there are suitable conditions for a shale to generate

                // Iterate through all of the x, y, and z values that might be potentially included in the ellipse
                for (int xi = -1; xi <= 1 ; xi++) {
                    for (int yi = -1; yi <= 1 ; yi++) {
                        for (int zi = -1; zi <= 1 ; zi++) {
                            BlockPos question = pos.east(xi).up(yi).south(zi);
                            // This is literally just the formula for a a sphere, so yeah
                            // If the block in question is within the sphere then fill it
                            if (Math.sqrt((xi*xi)+(yi*yi)+(zi*zi)) <= 1.5) {
                                world.setBlockState(question, Blocks.SHROOMLIGHT.getDefaultState(), 0);
                            }
                        }
                    }
                }

                // Return because we are done generating and return true to indicate a successful generation
                return true;
            }

            pos = pos.down();
        }
    }
}
