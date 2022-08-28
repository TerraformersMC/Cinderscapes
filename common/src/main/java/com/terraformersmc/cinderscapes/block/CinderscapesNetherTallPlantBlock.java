package com.terraformersmc.cinderscapes.block;

import com.terraformersmc.cinderscapes.util.StateShapeSupplier;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class CinderscapesNetherTallPlantBlock extends TallPlantBlock {
    protected final StateShapeSupplier SHAPE_SUPPLIER;

    public CinderscapesNetherTallPlantBlock(Settings settings, StateShapeSupplier supplier) {
        super(settings);
        SHAPE_SUPPLIER = supplier;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BlockTags.NYLIUM) || floor.isOf(Blocks.SOUL_SOIL) || floor.isOf(Blocks.NETHERRACK) || super.canPlantOnTop(floor, world, pos);
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE_SUPPLIER.apply(state);
    }
}
