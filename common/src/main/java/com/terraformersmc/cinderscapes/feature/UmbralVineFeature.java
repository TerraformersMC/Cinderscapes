package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.block.GhastlyEctoplasmBlock;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.util.MathHelper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.core.Direction8;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class UmbralVineFeature extends Feature<NoneFeatureConfiguration> {
    public UmbralVineFeature() {
        super(NoneFeatureConfiguration.CODEC);
    }

    // TODO: Implement a FeatureConfig to change the material
    // TODO: Add the dip height to the potential delta values
    // TODO: Allow it to go at angles and stuff (intermediate approach via EightWayDirection)
    // TODO: Figure out the chunk boundary issue (worked-around by shortening vines)

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        RandomSource random = context.random();
        BlockPos pos = context.origin();
        WorldGenLevel world = context.level();
        while (pos.getY() > context.chunkGenerator().getSeaLevel()) {
            search: {
                if ( world.getBlockState(pos).getBlock() != Blocks.NETHERRACK ) break search;
                if ( world.isEmptyBlock(pos.above()) ) break search;
                boolean airBelow = false;
                for (int y = 0; y < 6; y++) {
                    if (world.isEmptyBlock(pos.below(y))) airBelow = true;
                }
                if (!airBelow) break search;
                if ( world.isEmptyBlock(pos.north()) && !world.isEmptyBlock(pos.south()) && !world.isEmptyBlock(pos.east()) && !world.isEmptyBlock(pos.west()) ) return angleVine(world, pos, Direction8.NORTH, random);
                if ( world.isEmptyBlock(pos.south()) && !world.isEmptyBlock(pos.north()) && !world.isEmptyBlock(pos.east()) && !world.isEmptyBlock(pos.west()) ) return angleVine(world, pos, Direction8.SOUTH, random);
                if ( world.isEmptyBlock(pos.east()) && !world.isEmptyBlock(pos.south()) && !world.isEmptyBlock(pos.north()) && !world.isEmptyBlock(pos.west()) ) return angleVine(world, pos, Direction8.EAST, random);
                if ( world.isEmptyBlock(pos.west()) && !world.isEmptyBlock(pos.south()) && !world.isEmptyBlock(pos.east()) && !world.isEmptyBlock(pos.north()) ) return angleVine(world, pos, Direction8.WEST, random);
            }
            pos = pos.below();
        }
        return false;
    }

    public boolean angleVine(WorldGenLevel world, BlockPos origin, Direction8 dir, RandomSource random) {
        int eightWayOffset = random.nextBoolean() ? 1 : -1;

        // Bias towards cardinal vines because ordinal vines are inherently twice as likely.
        return (buildVine(world, origin, dir, random) ||
                buildVine(world, origin, getEightWayClockwiseRotation(dir,  eightWayOffset), random) ||
                buildVine(world, origin, getEightWayClockwiseRotation(dir, -eightWayOffset), random));
    }

    public boolean buildVine(WorldGenLevel world, BlockPos origin, Direction8 dir, RandomSource random) {
        final ChunkPos chunkOrigin = new ChunkPos(origin);
        final BlockPos.MutableBlockPos terminus = origin.mutable();

        // Generation is restricted to the current and adjacent chunks, to match limits imposed by Minecraft.
        terminus.move(5 * dir.getStepX(), 0, 5 * dir.getStepZ());
        while (chunkOrigin.getChessboardDistance(new ChunkPos(terminus)) < 2) {
            if (world.getBlockState(terminus).getBlock() == Blocks.NETHERRACK) {
                return modifiedLine(world, CinderscapesBlocks.TWILIGHT_VINE_BLOCK.defaultBlockState(), terminus, origin, random);
            }
            terminus.move(dir.getStepX(), 0, dir.getStepZ());
        }

        return false;
    }

    public static boolean modifiedLine(WorldGenLevel world, BlockState state, BlockPos to, BlockPos from, RandomSource random) {
        int dx = to.getX() - from.getX();
        int dy = to.getY() - from.getY();
        int dz = to.getZ() - from.getZ();
        int dt = java.lang.Math.max(java.lang.Math.max(java.lang.Math.abs(dx), java.lang.Math.abs(dy)), java.lang.Math.abs(dz));

        int randomDroop = -(random.nextInt(dt/2) + 1);

        dt = Math.round(MathHelper.max(Math.abs(dx), Math.abs(dy), Math.abs(dz), Math.abs(randomDroop)));

        // Check if all of the blocks are air or netherrack
        for (float t = 0; t < dt; t += 0.25) {
            BlockPos pos = BlockPos.containing(from.getX() + ((float)dx/dt)*t, from.getY() + ((float)dy/dt)*t + MathHelper.map(t*t - dt*t, -dt*dt/4.0f, 0, randomDroop, 0), from.getZ() + ((float)dz/dt)*t);
            if (!world.isEmptyBlock(pos) && world.getBlockState(pos).getBlock() != Blocks.NETHERRACK) return false;
        }

        // If they are then generate the thing
        for (float t = 0; t < dt; t += 0.25) {
            BlockPos pos = BlockPos.containing(from.getX() + ((float)dx/dt)*t, from.getY() + ((float)dy/dt)*t + MathHelper.map(t*t - dt*t, -dt*dt/4.0f, 0, randomDroop, 0), from.getZ() + ((float)dz/dt)*t);
            world.setBlock(pos, state, 0);

            if (random.nextFloat() > 0.8f) {
                int ectoHeight = random.nextInt(3) + 1;
                boolean clear = true;
                for (int i = 1; i <= ectoHeight; i++) {
                    if (!world.isEmptyBlock(pos.below(i))) clear = false;
                }

                if (clear) {
                    for (int i = 1; i <= ectoHeight; i++) {
                        if (world.isEmptyBlock(pos.below(i))) {
                            BlockState ectoState = ((GhastlyEctoplasmBlock) CinderscapesBlocks.GHASTLY_ECTOPLASM).typeOf(GhastlyEctoplasmBlock.Type.MIDDLE);
                            if (i == ectoHeight) {
                                ectoState = ((GhastlyEctoplasmBlock) CinderscapesBlocks.GHASTLY_ECTOPLASM).typeOf(GhastlyEctoplasmBlock.Type.BOTTOM);
                            }
                            if (i == 1 && ectoHeight >= 3) {
                                ectoState = ((GhastlyEctoplasmBlock) CinderscapesBlocks.GHASTLY_ECTOPLASM).typeOf(GhastlyEctoplasmBlock.Type.TOP);
                            }
                            world.setBlock(pos.below(i), ectoState, 0);
                        }
                    }
                }
            }
        }

        return true;
    }

    private Direction8 getEightWayClockwiseRotation(Direction8 direction, int increment) {
        assert (increment >= -8);
        return Direction8.values()[(direction.ordinal() + increment + 8) % 8];
    }
}
