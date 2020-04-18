package com.terraformersmc.cinderscapes.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class NetherTallPlantBlock extends TallPlantBlock {
    public NetherTallPlantBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        Block block = floor.getBlock();
        if (BlockTags.NYLIUM.contains(block)) {
            return true;
        } else {
            return block == Blocks.NETHERRACK || block == Blocks.SOUL_SOIL;
        }
    }
}
