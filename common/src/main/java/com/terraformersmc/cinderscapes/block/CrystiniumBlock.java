package com.terraformersmc.cinderscapes.block;

import com.terraformersmc.cinderscapes.util.StateShapeRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;

public class CrystiniumBlock extends CinderscapesNetherPlantBlock {
    public CrystiniumBlock(Properties settings) {
        super(settings);

        StateShapeRegistry.put(this, (state) -> Block.box(2.0, 0.0, 2.0, 14.0, 12.0, 14.0));
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
        Vec3 center = this.getShape(state, world, pos, CollisionContext.empty()).bounds().getCenter();
        double x = (double)pos.getX() + center.x;
        double z = (double)pos.getZ() + center.z;

        if (random.nextFloat() > 0.8) {
            world.addParticle(ParticleTypes.FIREWORK, x + random.nextFloat() - 0.5f, pos.getY() + random.nextFloat(), z + random.nextFloat() - 0.5f, random.nextFloat() * 0.1 - 0.05, random.nextFloat() * 0.1 - 0.05, random.nextFloat() * 0.1 - 0.05);
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Vec3 modelOffset = state.getOffset(pos);
        return super.getShape(state, world, pos, context).move(modelOffset.x, modelOffset.y, modelOffset.z);
    }
}
