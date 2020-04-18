package com.terraformersmc.cinderscapes.block;

import net.minecraft.block.*;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class NetherTallPlantBlock extends TallPlantBlock {
    private static VoxelShape SHAPE;

    public NetherTallPlantBlock(Settings settings, VoxelShape shape) {
        super(settings);
        SHAPE = shape;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        Block block = floor.getBlock();
        return BlockTags.NYLIUM.contains(block)|| block == Blocks.NETHERRACK || block == Blocks.SOUL_SOIL;
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
