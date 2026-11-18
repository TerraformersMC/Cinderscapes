package com.terraformersmc.cinderscapes.feature;

import com.mojang.serialization.MapCodec;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import org.jspecify.annotations.NullMarked;

// TODO: Rewrite using the upcoming shapes library
// TODO: Make a feature config allowing the material and size range to change
@NullMarked
public class AshPileFeature implements Feature {
    public static final MapCodec<AshPileFeature> CODEC = MapCodec.unit(AshPileFeature::new);

    @Override
    public MapCodec<AshPileFeature> codec() {
        return CODEC;
    }

    @Override
    public boolean place(WorldGenLevel level, ChunkGenerator chunkGenerator, RandomSource random, BlockPos origin) {
        int yradius = random.nextInt(5) + 7;

        while (true) {
            search:
            {
                if (origin.getY() <= 3) {
                    return false;
                }

                if (origin.getY() > (128 - 2 * yradius)) {
                    break search;
                }

                if (level.isEmptyBlock(origin.below())) {
                    break search;
                }

                for (int y = 1; y <= 4; y++) {
                    Block block = level.getBlockState(origin.below(y)).getBlock();
                    if (!(block == Blocks.NETHERRACK || block == Blocks.SOUL_SOIL || block == Blocks.GRAVEL)) {
                        break search;
                    }
                }

                for (int i = 0; i < 50; i++) {
                    BlockPos setPos = origin.offset(random.nextInt(5) - random.nextInt(5), 0, random.nextInt(5) - random.nextInt(5));

                    BlockState setState = level.getBlockState(setPos);

                    while (level.isEmptyBlock(setPos.below()) || level.getBlockState(setPos.below()).is(CinderscapesBlocks.ASH)) {
                        setPos = setPos.below();
                    }

                    while (setState.is(CinderscapesBlocks.ASH_BLOCK) && setPos.getY() < 256) {
                        if (level.isEmptyBlock(setPos.above()) || level.getBlockState(setPos.above()).is(CinderscapesBlocks.ASH)) {
                            setPos = setPos.above();
                            setState = level.getBlockState(setPos);
                        } else {
                            break;
                        }
                    }

                    if (level.isEmptyBlock(setPos) || level.getBlockState(setPos).is(CinderscapesBlocks.ASH)) {
                        level.setBlock(setPos, CinderscapesBlocks.ASH_BLOCK.defaultBlockState(), 4);
                    }
                }

                // Return because we are done generating and return true to indicate a successful generation
                return true;
            }

            origin = origin.below();
        }
    }
}
