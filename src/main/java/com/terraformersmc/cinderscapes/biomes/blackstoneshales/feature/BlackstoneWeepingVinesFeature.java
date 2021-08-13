package com.terraformersmc.cinderscapes.biomes.blackstoneshales.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.WeepingVinesFeature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Arrays;
import java.util.Random;

public class BlackstoneWeepingVinesFeature extends WeepingVinesFeature {

    private static final Block[] PLACEABLE = new Block[]{Blocks.SOUL_SOIL, Blocks.SOUL_SAND, Blocks.BLACKSTONE, Blocks.NETHERRACK, Blocks.NETHER_WART_BLOCK};

    public BlackstoneWeepingVinesFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        Random random = context.getRandom();
        if (!structureWorldAccess.isAir(blockPos)) {
            return false;
        } else {
            BlockState blockState = structureWorldAccess.getBlockState(blockPos.up());
            if (Arrays.stream(PLACEABLE).noneMatch(blockState::isOf)) {
                return false;
            } else {
                this.generateNetherWartBlocksInArea(structureWorldAccess, random, blockPos);
                this.generateVinesInArea(structureWorldAccess, random, blockPos);
                return true;
            }
        }
    }
}
