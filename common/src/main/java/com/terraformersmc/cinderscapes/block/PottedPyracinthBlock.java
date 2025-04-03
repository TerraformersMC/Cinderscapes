package com.terraformersmc.cinderscapes.block;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class PottedPyracinthBlock extends FlowerPotBlock {
    public PottedPyracinthBlock(Settings settings) {
        super(CinderscapesBlocks.PYRACINTH, settings);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        double x = pos.getX() + 0.5;
        double z = pos.getZ() + 0.5;

        world.addParticleClient(ParticleTypes.SMOKE, x + random.nextFloat() - 0.5f, pos.getY() + random.nextFloat(), z + random.nextFloat() - 0.5f, random.nextFloat() * 0.1 - 0.05, random.nextFloat() * 0.1 - 0.05, random.nextFloat() * 0.1 - 0.05);
        if (random.nextFloat() > 0.6) {
            world.addParticleClient(ParticleTypes.FLAME, x - 0.1f + random.nextFloat() * 0.2f, pos.getY() + 0.5f, z - 0.1f + random.nextFloat() * 0.2f, 0.0f, 0.05f, 0.0f);
        }
    }
}
