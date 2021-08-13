package com.terraformersmc.cinderscapes.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class PottedFlowerBlock extends FlowerPotBlock {
    public PottedFlowerBlock(Block content, Settings settings) {
        super(content, settings);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        this.getContent().randomDisplayTick(state, world, pos, random);
    }
}
