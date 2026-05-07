package com.terraformersmc.cinderscapes.feature;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import org.jspecify.annotations.NullMarked;

// TODO: Make a feature config allowing the blockstates to change
@NullMarked
public class BlackstoneWeepingVinesFeature extends Feature<NoneFeatureConfiguration> {
    public BlackstoneWeepingVinesFeature() {
        super(NoneFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        RandomSource random = context.random();
        BlockPos pos = context.origin();
        WorldGenLevel level = context.level();
        if (!level.isEmptyBlock(pos)) {
            return false;
        } else {
            Block block = level.getBlockState(pos.above()).getBlock();
            if (block != Blocks.BLACKSTONE && block != Blocks.NETHER_WART_BLOCK) {
                return false;
            } else {
                this.generateNetherWartBlocksInArea(level, random, pos);
                this.generateVinesInArea(level, random, pos);
                return true;
            }
        }
    }

    private void generateNetherWartBlocksInArea(WorldGenLevel level, RandomSource random, BlockPos pos) {
        level.setBlock(pos, Blocks.NETHER_WART_BLOCK.defaultBlockState(), 2);
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        BlockPos.MutableBlockPos mutable2 = new BlockPos.MutableBlockPos();

        for (int i = 0; i < 200; ++i) {
            mutable.setWithOffset(pos, random.nextInt(6) - random.nextInt(6), random.nextInt(2) - random.nextInt(5), random.nextInt(6) - random.nextInt(6));
            if (level.isEmptyBlock(mutable)) {
                int j = 0;

                for (Direction direction : Direction.values()) {
                    Block block = level.getBlockState(mutable2.setWithOffset(mutable, direction)).getBlock();
                    if (block == Blocks.BLACKSTONE || block == Blocks.NETHER_WART_BLOCK) {
                        ++j;
                    }

                    if (j > 1) {
                        break;
                    }
                }

                if (j == 1) {
                    level.setBlock(mutable, Blocks.NETHER_WART_BLOCK.defaultBlockState(), 2);
                }
            }
        }

    }

    private void generateVinesInArea(WorldGenLevel level, RandomSource random, BlockPos pos) {
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        for (int i = 0; i < 100; ++i) {
            mutable.setWithOffset(pos, random.nextInt(8) - random.nextInt(8), random.nextInt(2) - random.nextInt(7), random.nextInt(8) - random.nextInt(8));
            if (level.isEmptyBlock(mutable)) {
                Block block = level.getBlockState(mutable.above()).getBlock();
                if (block == Blocks.BLACKSTONE || block == Blocks.NETHER_WART_BLOCK) {
                    int j = Mth.nextInt(random, 1, 8);
                    if (random.nextInt(6) == 0) {
                        j *= 2;
                    }

                    if (random.nextInt(5) == 0) {
                        j = 1;
                    }

                    generateVineColumn(level, random, mutable, j, 17, 25);
                }
            }
        }
    }

    public static void generateVineColumn(WorldGenLevel level, RandomSource random, BlockPos.MutableBlockPos pos, int length, int minAge, int maxAge) {
        for (int i = 0; i <= length; ++i) {
            if (level.isEmptyBlock(pos)) {
                if (i == length || !level.isEmptyBlock(pos.below())) {
                    level.setBlock(pos, Blocks.WEEPING_VINES.defaultBlockState().setValue(StemBlock.AGE, Mth.nextInt(random, minAge, maxAge)), 2);
                    break;
                }
                level.setBlock(pos, Blocks.WEEPING_VINES_PLANT.defaultBlockState(), 2);
            }
            pos.move(Direction.DOWN);
        }
    }
}
