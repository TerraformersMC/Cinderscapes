package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import org.jspecify.annotations.NullMarked;

// TODO: Rewrite using the upcoming shapes library
// TODO: Make a feature config allowing the material and size range to change
@NullMarked
public class AshPileFeature extends Feature<NoneFeatureConfiguration> {
    public AshPileFeature() {
        super(NoneFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        RandomSource random = context.random();
        BlockPos pos = context.origin();
        WorldGenLevel world = context.level();
        int yradius = random.nextInt(5) + 7;

        while (true) {
            search:
            {
                if (pos.getY() <= 3) {
                    return false;
                }

                if (pos.getY() > (128 - 2 * yradius)) {
                    break search;
                }

                if (world.isEmptyBlock(pos.below())) {
                    break search;
                }

                for (int y = 1; y <= 4; y++) {
                    Block block = world.getBlockState(pos.below(y)).getBlock();
                    if (!(block == Blocks.NETHERRACK || block == Blocks.SOUL_SOIL || block == Blocks.GRAVEL)) {
                        break search;
                    }
                }

                for (int i = 0; i < 50; i++) {
                    BlockPos setPos = pos.offset(random.nextInt(5) - random.nextInt(5), 0, random.nextInt(5) - random.nextInt(5));

                    BlockState setState = world.getBlockState(setPos);

                    while (world.isEmptyBlock(setPos.below()) || world.getBlockState(setPos.below()).is(CinderscapesBlocks.ASH)) {
                        setPos = setPos.below();
                    }

                    while (setState.is(CinderscapesBlocks.ASH_BLOCK) && setPos.getY() < 256) {
                        if (world.isEmptyBlock(setPos.above()) || world.getBlockState(setPos.above()).is(CinderscapesBlocks.ASH)) {
                            setPos = setPos.above();
                            setState = world.getBlockState(setPos);
                        } else {
                            break;
                        }
                    }

                    if (world.isEmptyBlock(setPos) || world.getBlockState(setPos).is(CinderscapesBlocks.ASH)) {
                        world.setBlock(setPos, CinderscapesBlocks.ASH_BLOCK.defaultBlockState(), 4);
                    }
                }

                // Return because we are done generating and return true to indicate a successful generation
                return true;
            }

            pos = pos.below();
        }
    }
}
