package com.terraformersmc.cinderscapes.block;

import com.terraformersmc.cinderscapes.util.StateShapeSupplier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

public class PyracinthBlock extends CinderscapesNetherPlantBlock {
    public PyracinthBlock() {
        super(FabricBlockSettings.copy(Blocks.WARPED_ROOTS), (state) -> Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 16.0, 11.0));
    }

    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        Vec3d center = this.getOutlineShape(state, world, pos, ShapeContext.absent()).getBoundingBox().getCenter();
        double x = (double)pos.getX() + center.x;
        double z = (double)pos.getZ() + center.z;

        world.addParticle(ParticleTypes.SMOKE, x + random.nextFloat() - 0.5f, pos.getY() + random.nextFloat(), z + random.nextFloat() - 0.5f, random.nextFloat() * 0.1 - 0.05, random.nextFloat() * 0.1 - 0.05, random.nextFloat() * 0.1 - 0.05);
        if (random.nextFloat() > 0.6) {
            world.addParticle(ParticleTypes.FLAME, x - 0.1f + random.nextFloat() * 0.2f, pos.getY() + 0.5f, z - 0.1f + random.nextFloat() * 0.2f, 0.0f, 0.05f, 0.0f);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Vec3d modelOffset = state.getModelOffset(world, pos);
        return super.getOutlineShape(state, world, pos, context).offset(modelOffset.x, modelOffset.y, modelOffset.z);
    }
}
