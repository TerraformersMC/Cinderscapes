package com.terraformersmc.cinderscapes.block;

import com.mojang.serialization.MapCodec;
import com.terraformersmc.cinderscapes.util.StateShapeRegistry;
import com.terraformersmc.cinderscapes.util.StateShapeSupplier;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class CinderscapesNetherTallPlantBlock extends DoublePlantBlock {
    public static final MapCodec<CinderscapesNetherTallPlantBlock> CODEC = CinderscapesNetherTallPlantBlock.simpleCodec(CinderscapesNetherTallPlantBlock::new);

    public CinderscapesNetherTallPlantBlock(StateShapeSupplier supplier, Properties settings) {
        super(settings);

        StateShapeRegistry.put(this, supplier);
    }

    public CinderscapesNetherTallPlantBlock(Properties settings) {
        super(settings);
    }

    @Override
    public MapCodec<DoublePlantBlock> codec() {
        // Don't look at me; this is how the Fabric folks say we're going to do it...
        //noinspection unchecked
        return (MapCodec<DoublePlantBlock>) (Object) CODEC;
    }

    @Override
    protected boolean mayPlaceOn(BlockState floor, BlockGetter world, BlockPos pos) {
        return floor.is(BlockTags.NYLIUM) || floor.is(Blocks.SOUL_SOIL) || floor.is(Blocks.NETHERRACK) || super.mayPlaceOn(floor, world, pos);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return StateShapeRegistry.getShape(state);
    }
}
