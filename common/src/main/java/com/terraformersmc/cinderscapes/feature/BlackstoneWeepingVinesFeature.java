package com.terraformersmc.cinderscapes.feature;

import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

// TODO: Make a feature config allowing the blockstates to change
public class BlackstoneWeepingVinesFeature extends Feature<DefaultFeatureConfig> {
    public BlackstoneWeepingVinesFeature() {
        super(DefaultFeatureConfig.CODEC);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        Random random = context.getRandom();
        BlockPos pos = context.getOrigin();
        StructureWorldAccess world = context.getWorld();
        if (!world.isAir(pos)) {
            return false;
        } else {
            Block block = world.getBlockState(pos.up()).getBlock();
            if (block != Blocks.BLACKSTONE && block != Blocks.NETHER_WART_BLOCK) {
                return false;
            } else {
                this.generateNetherWartBlocksInArea(world, random, pos);
                this.generateVinesInArea(world, random, pos);
                return true;
            }
        }
    }

    private void generateNetherWartBlocksInArea(StructureWorldAccess world, Random random, BlockPos pos) {
        world.setBlockState(pos, Blocks.NETHER_WART_BLOCK.getDefaultState(), 2);
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        BlockPos.Mutable mutable2 = new BlockPos.Mutable();

        for (int i = 0; i < 200; ++i) {
            mutable.set(pos, random.nextInt(6) - random.nextInt(6), random.nextInt(2) - random.nextInt(5), random.nextInt(6) - random.nextInt(6));
            if (world.isAir(mutable)) {
                int j = 0;

                for (Direction direction : Direction.values()) {
                    Block block = world.getBlockState(mutable2.set(mutable, direction)).getBlock();
                    if (block == Blocks.BLACKSTONE || block == Blocks.NETHER_WART_BLOCK) {
                        ++j;
                    }

                    if (j > 1) {
                        break;
                    }
                }

                if (j == 1) {
                    world.setBlockState(mutable, Blocks.NETHER_WART_BLOCK.getDefaultState(), 2);
                }
            }
        }

    }

    private void generateVinesInArea(StructureWorldAccess world, Random random, BlockPos pos) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (int i = 0; i < 100; ++i) {
            mutable.set(pos, random.nextInt(8) - random.nextInt(8), random.nextInt(2) - random.nextInt(7), random.nextInt(8) - random.nextInt(8));
            if (world.isAir(mutable)) {
                Block block = world.getBlockState(mutable.up()).getBlock();
                if (block == Blocks.BLACKSTONE || block == Blocks.NETHER_WART_BLOCK) {
                    int j = MathHelper.nextInt(random, 1, 8);
                    if (random.nextInt(6) == 0) {
                        j *= 2;
                    }

                    if (random.nextInt(5) == 0) {
                        j = 1;
                    }

                    generateVineColumn(world, random, mutable, j, 17, 25);
                }
            }
        }
    }

    public static void generateVineColumn(StructureWorldAccess world, Random random, BlockPos.Mutable pos, int length, int minAge, int maxAge) {
        for (int i = 0; i <= length; ++i) {
            if (world.isAir(pos)) {
                if (i == length || !world.isAir(pos.down())) {
                    world.setBlockState(pos, Blocks.WEEPING_VINES.getDefaultState().with(AbstractPlantStemBlock.AGE, MathHelper.nextInt(random, minAge, maxAge)), 2);
                    break;
                }
                world.setBlockState(pos, Blocks.WEEPING_VINES_PLANT.getDefaultState(), 2);
            }
            pos.move(Direction.DOWN);
        }
    }
}
