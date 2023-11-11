package com.terraformersmc.cinderscapes.block;

import com.mojang.serialization.MapCodec;
import com.terraformersmc.cinderscapes.util.StateShapeRegistry;
import com.terraformersmc.cinderscapes.util.StateShapeSupplier;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class CinderscapesNetherTallPlantBlock extends TallPlantBlock {
    public static final MapCodec<CinderscapesNetherTallPlantBlock> CODEC = CinderscapesNetherTallPlantBlock.createCodec(CinderscapesNetherTallPlantBlock::new);

    public CinderscapesNetherTallPlantBlock(Settings settings, StateShapeSupplier supplier) {
        super(settings);

        StateShapeRegistry.put(this, supplier);
    }

    public CinderscapesNetherTallPlantBlock(Settings settings) {
        super(settings);
    }

    @Override
    public MapCodec<TallPlantBlock> getCodec() {
        // Don't look at me; this is how the Fabric folks say we're going to do it...
        //noinspection unchecked
        return (MapCodec<TallPlantBlock>) (Object) CODEC;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BlockTags.NYLIUM) || floor.isOf(Blocks.SOUL_SOIL) || floor.isOf(Blocks.NETHERRACK) || super.canPlantOnTop(floor, world, pos);
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return StateShapeRegistry.getShape(state);
    }
}
