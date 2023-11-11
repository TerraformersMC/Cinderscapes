package com.terraformersmc.cinderscapes.block;

import com.mojang.serialization.MapCodec;
import com.terraformersmc.cinderscapes.util.StateShapeRegistry;
import com.terraformersmc.cinderscapes.util.StateShapeSupplier;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class CinderscapesNetherPlantBlock extends PlantBlock {
    public static final MapCodec<CinderscapesNetherPlantBlock> CODEC = CinderscapesNetherPlantBlock.createCodec(CinderscapesNetherPlantBlock::new);

    public CinderscapesNetherPlantBlock(Settings settings, StateShapeSupplier supplier) {
        super(settings.offset(AbstractBlock.OffsetType.XZ));

        StateShapeRegistry.put(this, supplier);
    }

    public CinderscapesNetherPlantBlock(Settings settings) {
        super(settings.offset(AbstractBlock.OffsetType.XZ));
    }

    @Override
    protected MapCodec<? extends PlantBlock> getCodec() {
        return null;
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
