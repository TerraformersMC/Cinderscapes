package com.terraformersmc.cinderscapes.block;

import net.minecraft.block.*;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

import java.util.function.Function;

public class NetherPlantBlock extends PlantBlock {

    private final Function<BlockState, VoxelShape> shapeSupplier;

    public NetherPlantBlock(Settings settings, Function<BlockState, VoxelShape> shapeSupplier) {
        super(settings);
        this.shapeSupplier = shapeSupplier;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return BlockTags.NYLIUM.contains(floor.getBlock()) || floor.isOf(Blocks.SOUL_SOIL) || floor.isOf(Blocks.NETHERRACK) || super.canPlantOnTop(floor, world, pos);
    }

    @Override
    public AbstractBlock.OffsetType getOffsetType() {
        return AbstractBlock.OffsetType.XZ;
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return shapeSupplier.apply(state);
    }
}
