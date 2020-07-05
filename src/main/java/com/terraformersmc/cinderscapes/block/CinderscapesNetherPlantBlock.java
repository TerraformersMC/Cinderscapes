package com.terraformersmc.cinderscapes.block;

import com.terraformersmc.cinderscapes.util.StateShapeSupplier;
import net.minecraft.block.*;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

/**
 * [REVIEWED]
 *
 * The root class for nether plants of varying bounding box shapes
 *
 * @author <Wtoll> Will Toll on 2020-05-02
 * @project Cinderscapes
 */
public class CinderscapesNetherPlantBlock extends PlantBlock {
    protected final StateShapeSupplier SHAPE_SUPPLIER;

    public CinderscapesNetherPlantBlock(Settings settings, StateShapeSupplier supplier) {
        super(settings);
        SHAPE_SUPPLIER = supplier;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return BlockTags.NYLIUM.contains(floor.getBlock()) || floor.isOf(Blocks.SOUL_SOIL) || floor.isOf(Blocks.NETHERRACK) || super.canPlantOnTop(floor, world, pos);
    }

    public AbstractBlock.OffsetType getOffsetType() {
        return AbstractBlock.OffsetType.XZ;
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE_SUPPLIER.apply(state);
    }
}
