package com.terraformersmc.cinderscapes.biomes.luminousgrove.block;

import com.terraformersmc.cinderscapes.block.NetherPlantBlock;
import com.terraformersmc.cinderscapes.block.NetherTallPlantBlock;
import com.terraformersmc.cinderscapes.biomes.luminousgrove.LuminousGroveBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

public class PhotofernBlock extends NetherPlantBlock implements Fertilizable {
    public PhotofernBlock() {
        super(FabricBlockSettings.copyOf(Blocks.WARPED_ROOTS), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0));
    }

    @Override
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        NetherTallPlantBlock tallPhotofern = (NetherTallPlantBlock) LuminousGroveBlocks.TALL_PHOTOFERN;
        if (tallPhotofern.getDefaultState().canPlaceAt(world, pos) && world.isAir(pos.up())) {
            TallPlantBlock.placeAt(world, tallPhotofern.getDefaultState(), pos, 2);
        }
    }
}
