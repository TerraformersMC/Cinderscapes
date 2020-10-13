package com.terraformersmc.cinderscapes.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.SnowBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;

import java.util.Random;

public class AshLayerBlock extends SnowBlock {
    public AshLayerBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
    }

    public boolean canMobSpawnInside() {
        return true;
    }
}
