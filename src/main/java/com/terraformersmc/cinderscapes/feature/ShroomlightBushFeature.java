package com.terraformersmc.cinderscapes.feature;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class ShroomlightBushFeature extends Feature<NoneFeatureConfiguration> {

    public ShroomlightBushFeature() {
        super(NoneFeatureConfiguration.CODEC);
    }

    // TODO: Rewrite using the upcoming shapes library
    // TODO: Rewrite using the CountSafelistRangeFloorDecorator
    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        BlockPos pos = context.origin();
        WorldGenLevel level = context.level();

        while (true) {
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
                if (level.isEmptyBlock(pos.below())) {
                    break search;
                }

                // If the four blocks below are not one of netherrack, nylium, or a wart block then move down
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 2; y++) {
                        for (int z = -1; z <= 1; z++) {
                            Block block = level.getBlockState(pos.above(y).north(z).east(x)).getBlock();
                            if (y >= 0) {
                                if (block != Blocks.AIR) break search;
                            } else {
                                if (block != Blocks.NETHERRACK && !block.defaultBlockState().is(BlockTags.WART_BLOCKS) && !block.defaultBlockState().is(BlockTags.NYLIUM)) break search;
                            }
                        }
                    }
                }


                // At this point, if we haven't broken, there are suitable conditions for a bush to generate

                // Iterate through all of the x, y, and z values that might be potentially included in the ellipse
                for (int xi = -1; xi <= 1 ; xi++) {
                    for (int yi = -1; yi <= 1 ; yi++) {
                        for (int zi = -1; zi <= 1 ; zi++) {
                            BlockPos question = pos.east(xi).above(yi).south(zi);
                            // This is literally just the formula for a sphere, so yeah
                            // If the block in question is within the sphere then fill it
                            if (Math.sqrt((xi*xi)+(yi*yi)+(zi*zi)) <= 1.5) {
                                level.setBlock(question, Blocks.SHROOMLIGHT.defaultBlockState(), 0);
                            }
                        }
                    }
                }

                // Return because we are done generating and return true to indicate a successful generation
                return true;
            }

            pos = pos.below();
        }
    }
}
