package com.terraformersmc.cinderscapes.block;

import com.terraformersmc.cinderscapes.util.StateShapeRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class PyracinthBlock extends CinderscapesNetherPlantBlock {
    public PyracinthBlock(Properties settings) {
        super(settings);

        StateShapeRegistry.put(this, (state) -> Block.box(5.0, 0.0, 5.0, 11.0, 16.0, 11.0));
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        Vec3 center = this.getShape(state, level, pos, CollisionContext.empty()).bounds().getCenter();
        double x = (double)pos.getX() + center.x;
        double z = (double)pos.getZ() + center.z;

        level.addParticle(ParticleTypes.SMOKE, x + random.nextFloat() - 0.5f, pos.getY() + random.nextFloat(), z + random.nextFloat() - 0.5f, random.nextFloat() * 0.1 - 0.05, random.nextFloat() * 0.1 - 0.05, random.nextFloat() * 0.1 - 0.05);
        if (random.nextFloat() > 0.6) {
            level.addParticle(ParticleTypes.FLAME, x - 0.1f + random.nextFloat() * 0.2f, pos.getY() + 0.5f, z - 0.1f + random.nextFloat() * 0.2f, 0.0f, 0.05f, 0.0f);
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Vec3 modelOffset = state.getOffset(pos);
        return super.getShape(state, level, pos, context).move(modelOffset.x, modelOffset.y, modelOffset.z);
    }
}
