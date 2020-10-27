package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.block.GhastlyEctoplasmBlock;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.util.MathHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class UmbralVineFeature extends Feature<DefaultFeatureConfig> {
    public UmbralVineFeature() {
        super(DefaultFeatureConfig.CODEC);
    }

    // TODO: Implement a FeatureConfig to change the material
    // TODO: Add the dip height to the potential delta values
    // TODO: Allow it to go at angles and stuff
    // TODO: Figure out the chunk boundary issue

    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator generator, Random random, BlockPos pos, DefaultFeatureConfig config) {
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

    public boolean buildVine(StructureWorldAccess world, BlockPos pos, Direction dir, Random random) {
        for (int offset = 5; offset < 50; offset++) {
            if (world.getBlockState(pos.offset(dir, offset)).getBlock() == Blocks.NETHERRACK) {
                return modifiedLine(world, CinderscapesBlocks.TWILIGHT_VINE_BLOCK.getDefaultState(), pos.offset(dir, offset), pos, random);
            }
        }
        return false;
    }

    public static boolean modifiedLine(StructureWorldAccess world, BlockState state, BlockPos to, BlockPos from, Random random) {
        int dx = to.getX() - from.getX();
        int dy = to.getY() - from.getY();
        int dz = to.getZ() - from.getZ();
        int dt = java.lang.Math.max(java.lang.Math.max(java.lang.Math.abs(dx), java.lang.Math.abs(dy)), java.lang.Math.abs(dz));

        int randomDroop = -(random.nextInt(dt/2) + 1);

        dt = Math.round(MathHelper.max(Math.abs(dx), Math.abs(dy), Math.abs(dz), Math.abs(randomDroop)));

        // Check if all of the blocks are air or netherrack
        for (float t = 0; t < dt; t+=0.25) {
            BlockPos pos = new BlockPos( from.getX() + ((float)dx/dt)*t, from.getY() + ((float)dy/dt)*t + MathHelper.map(t*t - dt*t, -dt*dt/4.0f, 0, randomDroop, 0), from.getZ() + ((float)dz/dt)*t );
            if (!world.isAir(pos) && world.getBlockState(pos).getBlock() != Blocks.NETHERRACK) return false;
        }

        // If they are then generate the thing
        for (float t = 0; t < dt; t+=0.25) {
            BlockPos pos = new BlockPos( from.getX() + ((float)dx/dt)*t, from.getY() + ((float)dy/dt)*t + MathHelper.map(t*t - dt*t, -dt*dt/4.0f, 0, randomDroop, 0), from.getZ() + ((float)dz/dt)*t );
            world.setBlockState(pos, state, 0);
            if (random.nextFloat() > 0.8f) {
                int ectoHeight = random.nextInt(3) + 1;
                boolean clear = true;
                for (int i = 1; i <= ectoHeight; i++) {
                    if (!world.isAir(pos.down(i))) clear = false;
                }

                if (clear) {
                    for (int i = 1; i <= ectoHeight; i++) {
                        if (world.isAir(pos.down(i))) {
                            BlockState ectoState = ((GhastlyEctoplasmBlock) CinderscapesBlocks.GHASTLY_ECTOPLASM).typeOf(GhastlyEctoplasmBlock.Type.MIDDLE);
                            if (i == ectoHeight) {
                                ectoState = ((GhastlyEctoplasmBlock) CinderscapesBlocks.GHASTLY_ECTOPLASM).typeOf(GhastlyEctoplasmBlock.Type.BOTTOM);
                            }
                            if (i == 1 && ectoHeight >= 3) {
                                ectoState = ((GhastlyEctoplasmBlock) CinderscapesBlocks.GHASTLY_ECTOPLASM).typeOf(GhastlyEctoplasmBlock.Type.TOP);
                            }
                            if (i > ectoHeight) {
                                ectoState = Blocks.AIR.getDefaultState();
                            }
                            world.setBlockState(pos.down(i), ectoState, 0);
                        }
                    }
                }
            }
        }
        return true;
    }
}
