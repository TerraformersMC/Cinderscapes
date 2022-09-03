package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.block.GhastlyEctoplasmBlock;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.util.MathHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.EightWayDirection;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class UmbralVineFeature extends Feature<DefaultFeatureConfig> {
    public UmbralVineFeature() {
        super(DefaultFeatureConfig.CODEC);
    }

    // TODO: Implement a FeatureConfig to change the material
    // TODO: Add the dip height to the potential delta values
    // TODO: Allow it to go at angles and stuff (intermediate approach via EightWayDirection)
    // TODO: Figure out the chunk boundary issue (worked-around by shortening vines)

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        Random random = context.getRandom();
        BlockPos pos = context.getOrigin();
        StructureWorldAccess world = context.getWorld();
        while (pos.getY() > context.getGenerator().getSeaLevel()) {
            search: {
                if ( world.getBlockState(pos).getBlock() != Blocks.NETHERRACK ) break search;
                if ( world.isAir(pos.up()) ) break search;
                boolean airBelow = false;
                for (int y = 0; y < 6; y++) {
                    if (world.isAir(pos.down(y))) airBelow = true;
                }
                if (!airBelow) break search;
                if ( world.isAir(pos.north()) && !world.isAir(pos.south()) && !world.isAir(pos.east()) && !world.isAir(pos.west()) ) return angleVine(world, pos, EightWayDirection.NORTH, random);
                if ( world.isAir(pos.south()) && !world.isAir(pos.north()) && !world.isAir(pos.east()) && !world.isAir(pos.west()) ) return angleVine(world, pos, EightWayDirection.SOUTH, random);
                if ( world.isAir(pos.east()) && !world.isAir(pos.south()) && !world.isAir(pos.north()) && !world.isAir(pos.west()) ) return angleVine(world, pos, EightWayDirection.EAST, random);
                if ( world.isAir(pos.west()) && !world.isAir(pos.south()) && !world.isAir(pos.east()) && !world.isAir(pos.north()) ) return angleVine(world, pos, EightWayDirection.WEST, random);
            }
            pos = pos.down();
        }
        return false;
    }

    public boolean angleVine(StructureWorldAccess world, BlockPos origin, EightWayDirection dir, Random random) {
        int eightWayOffset = random.nextBoolean() ? 1 : -1;

        // Bias towards cardinal vines because ordinal vines are inherently twice as likely.
        return (buildVine(world, origin, dir, random) ||
                buildVine(world, origin, getEightWayClockwiseRotation(dir,  eightWayOffset), random) ||
                buildVine(world, origin, getEightWayClockwiseRotation(dir, -eightWayOffset), random));
    }

    public boolean buildVine(StructureWorldAccess world, BlockPos origin, EightWayDirection dir, Random random) {
        final ChunkPos chunkOrigin = new ChunkPos(origin);
        final BlockPos.Mutable terminus = origin.mutableCopy();

        // Generation is restricted to the current and adjacent chunks, to match limits imposed by Minecraft.
        terminus.move(5 * dir.getOffsetX(), 0, 5 * dir.getOffsetZ());
        while (chunkOrigin.getChebyshevDistance(new ChunkPos(terminus)) < 2) {
            if (world.getBlockState(terminus).getBlock() == Blocks.NETHERRACK) {
                return modifiedLine(world, CinderscapesBlocks.TWILIGHT_VINE_BLOCK.getDefaultState(), terminus, origin, random);
            }
            terminus.move(dir.getOffsetX(), 0, dir.getOffsetZ());
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
                            world.setBlockState(pos.down(i), ectoState, 0);
                        }
                    }
                }
            }
        }

        return true;
    }

    private EightWayDirection getEightWayClockwiseRotation(EightWayDirection direction, int increment) {
        assert (increment >= -8);
        return EightWayDirection.values()[(direction.ordinal() + increment + 8) % 8];
    }
}
