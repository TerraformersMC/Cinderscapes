package com.terraformersmc.cinderscapes.feature;

import com.mojang.datafixers.Dynamic;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.util.Math;
import com.terraformersmc.cinderscapes.util.Shapes;
import net.minecraft.block.BlockState;
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


public class UmbralVineFeature extends Feature<DefaultFeatureConfig> {
    public UmbralVineFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> configDeserializer) {
        super(configDeserializer);
    }

    // TODO: Implement a FeatureConfig to change the material
    // TODO: Add the dip height to the potential delta values
    // TODO: Allow it to go at angles and stuff
    // TODO: Figure out the chunk boundary issue

    @Override
    public boolean generate(IWorld world, StructureAccessor accessor, ChunkGenerator<? extends ChunkGeneratorConfig> generator, Random random, BlockPos pos, DefaultFeatureConfig config) {
        while (pos.getY() >= 3) {
            search: {
                if ( world.getBlockState(pos).getBlock() != Blocks.NETHERRACK ) break search;
                if ( world.isAir(pos.up()) ) break search;
                boolean airBelow = false;
                for (int y = 0; y < 6; y++) {
                    if (world.isAir(pos.down(y))) airBelow = true;
                }
                if (!airBelow) break search;
                if ( world.isAir(pos.north()) && !world.isAir(pos.south()) && !world.isAir(pos.east()) && !world.isAir(pos.west()) ) return buildVine(world, pos, Direction.NORTH, random);
                if ( world.isAir(pos.south()) && !world.isAir(pos.north()) && !world.isAir(pos.east()) && !world.isAir(pos.west()) ) return buildVine(world, pos, Direction.SOUTH, random);
                if ( world.isAir(pos.east()) && !world.isAir(pos.south()) && !world.isAir(pos.north()) && !world.isAir(pos.west()) ) return buildVine(world, pos, Direction.EAST, random);
                if ( world.isAir(pos.west()) && !world.isAir(pos.south()) && !world.isAir(pos.east()) && !world.isAir(pos.north()) ) return buildVine(world, pos, Direction.WEST, random);
            }
            pos = pos.down();
        }
        return false;
    }

    public boolean buildVine(IWorld world, BlockPos pos, Direction dir, Random random) {
        for (int offset = 5; offset < 50; offset++) {
            if (world.getBlockState(pos.offset(dir, offset)).getBlock() == Blocks.NETHERRACK) {
                return modifiedLine(world, CinderscapesBlocks.UMBRAL_WART_BLOCK.getDefaultState(), pos.offset(dir, offset), pos, random);
            }
        }
        return false;
    }

    public static boolean modifiedLine(IWorld world, BlockState state, BlockPos to, BlockPos from, Random random) {
        int dx = to.getX() - from.getX();
        int dy = to.getY() - from.getY();
        int dz = to.getZ() - from.getZ();
        int dt = java.lang.Math.max(java.lang.Math.max(java.lang.Math.abs(dx), java.lang.Math.abs(dy)), java.lang.Math.abs(dz));

        int randomDroop = -(random.nextInt(dt/2) + 1);

        // Check if all of the blocks are air or netherrack
        for (float t = 0; t < dt; t+=0.25) {
            BlockPos pos = new BlockPos( from.getX() + ((float)dx/dt)*t, from.getY() + ((float)dy/dt)*t + Math.map(t*t - dt*t, -dt*dt/4.0f, 0, 0, randomDroop), from.getZ() + ((float)dz/dt)*t );
            if (!world.isAir(pos) && world.getBlockState(pos).getBlock() != Blocks.NETHERRACK) return false;
        }

        // If they are then generate the thing
        for (float t = 0; t < dt; t+=0.25) {
            BlockPos pos = new BlockPos( from.getX() + ((float)dx/dt)*t, from.getY() + ((float)dy/dt)*t + Math.map(t*t - dt*t, -dt*dt/4.0f, 0, 0, randomDroop), from.getZ() + ((float)dz/dt)*t );
            world.setBlockState(pos, state, 4);
        }
        return true;
    }
}
