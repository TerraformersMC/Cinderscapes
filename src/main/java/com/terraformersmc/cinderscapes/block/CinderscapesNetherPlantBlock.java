package com.terraformersmc.cinderscapes.block;

import com.mojang.serialization.MapCodec;
import com.terraformersmc.cinderscapes.util.StateShapeRegistry;
import com.terraformersmc.cinderscapes.util.StateShapeSupplier;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.VegetationBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class CinderscapesNetherPlantBlock extends VegetationBlock {
    public static final MapCodec<CinderscapesNetherPlantBlock> CODEC = CinderscapesNetherPlantBlock.simpleCodec(CinderscapesNetherPlantBlock::new);

    public CinderscapesNetherPlantBlock(StateShapeSupplier supplier, Properties settings) {
        super(settings.offsetType(BlockBehaviour.OffsetType.XZ));

        StateShapeRegistry.put(this, supplier);
    }

    public CinderscapesNetherPlantBlock(Properties settings) {
        super(settings.offsetType(BlockBehaviour.OffsetType.XZ));
    }

    @Override
    protected MapCodec<? extends VegetationBlock> codec() {
        //noinspection ConstantConditions
        return null;
    }

    @Override
    protected boolean mayPlaceOn(BlockState floor, BlockGetter level, BlockPos pos) {
        return floor.is(BlockTags.NYLIUM) || floor.is(Blocks.SOUL_SOIL) || floor.is(Blocks.NETHERRACK) || super.mayPlaceOn(floor, level, pos);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return StateShapeRegistry.getShape(state);
    }
}
