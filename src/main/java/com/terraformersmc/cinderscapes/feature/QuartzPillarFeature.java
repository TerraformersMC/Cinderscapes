package com.terraformersmc.cinderscapes.feature;

import com.mojang.datafixers.Dynamic;
import com.terraformersmc.terraform.util.Shapes;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
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

        BlockPos.Mutable origin = pos.mutableCopy();
        double maxRadius = 1; //this can vary if you want it to
        for (int i = 0; i < height; i++) {
            Shapes.circle(origin.mutableCopy(), maxRadius * radius(i / (float) height), position -> setIfAir(world, position));
            origin.move(Direction.DOWN);
            //and other offset stuff for angles if you want
        }

        return true;
    }

    protected static void setIfAir(IWorld world, BlockPos pos) {
        if (world.getBlockState(pos).isAir()) {
            world.setBlockState(pos, Blocks.SMOOTH_QUARTZ.getDefaultState(), 0);
        }
    }

    // Provides the factor to the radius, where x is a double from 0.0 to 1.0 that represents the progress along the spike.
    protected static double radius(double x) {
        //Original function: y=-5x^2+4x+1
        double radius = (-5 * (x * x)) + (2 * x) + 1;
        return radius > 1 ? 1.0 : radius;
    }
}
