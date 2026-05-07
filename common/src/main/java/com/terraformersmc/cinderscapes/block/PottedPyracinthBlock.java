package com.terraformersmc.cinderscapes.block;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class PottedPyracinthBlock extends FlowerPotBlock {
    public PottedPyracinthBlock(Properties settings) {
        super(CinderscapesBlocks.PYRACINTH, settings);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
        double x = pos.getX() + 0.5;
        double z = pos.getZ() + 0.5;

        world.addParticle(ParticleTypes.SMOKE, x + random.nextFloat() - 0.5f, pos.getY() + random.nextFloat(), z + random.nextFloat() - 0.5f, random.nextFloat() * 0.1 - 0.05, random.nextFloat() * 0.1 - 0.05, random.nextFloat() * 0.1 - 0.05);
        if (random.nextFloat() > 0.6) {
            world.addParticle(ParticleTypes.FLAME, x - 0.1f + random.nextFloat() * 0.2f, pos.getY() + 0.5f, z - 0.1f + random.nextFloat() * 0.2f, 0.0f, 0.05f, 0.0f);
        }
    }
}
