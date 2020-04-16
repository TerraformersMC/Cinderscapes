package com.terraformersmc.cinderscapes.feature;

import com.mojang.datafixers.Dynamic;
import com.terraformersmc.terraform.util.Shapes;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;
import java.util.function.Function;

public class QuartzPillarFeature extends Feature<DefaultFeatureConfig> {
    public QuartzPillarFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> configDeserializer) {
        super(configDeserializer);
    }

    @Override
    public boolean generate(IWorld world, StructureAccessor accessor, ChunkGenerator<? extends ChunkGeneratorConfig> generator, Random random, BlockPos pos, DefaultFeatureConfig config) {
        int height = random.nextInt(8) + 14;

        int y = pos.getY();
        double radius;
        double maxRadius = 1;
        for (int i = 0; i < height; i++) {
            radius = maxRadius * radius(i / (float) height);
            BlockPos.Mutable mut = pos.mutableCopy();
            mut.setY(y);
            Shapes.circle(mut, radius, position -> setIfAir(world, position));
            y--;
        }

        return true;
    }

    private static void setIfAir(IWorld world, BlockPos pos) {
        if (world.getBlockState(pos).isAir()) {
            world.setBlockState(pos, Blocks.SMOOTH_QUARTZ.getDefaultState(), 0);
        }
    }

    // Provides the factor to the radius, where x is a double from 0.0 to 1.0 that represents the progress along the spike.
    private static double radius(double x) {
        //Original function: y=-5x^2+4x+1
        double radius = -5 * (x * x) + (2 * x) + 1;
        return radius > 1 ? 1.0 : radius;
    }
}
