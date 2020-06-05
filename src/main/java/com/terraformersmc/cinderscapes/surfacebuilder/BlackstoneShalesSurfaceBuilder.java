package com.terraformersmc.cinderscapes.surfacebuilder;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.cinderscapes.surfacebuilder.config.EmptySurfaceConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.noise.OctavePerlinNoiseSampler;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

import java.util.Random;

/**
 * [REVIEWED]
 *
 * Surface builder that creates the marbled effect of the blackstone shales biome
 *
 * @author <Wtoll> Will Toll on 2020-05-02
 * @project Cinderscapes
 */
public class BlackstoneShalesSurfaceBuilder extends SurfaceBuilder<EmptySurfaceConfig> {
    private static final BlockState BLACKSTONE;
    private static final BlockState SOUL_SAND;
    private static final BlockState SOUL_SOIL;
    private static final BlockState MAGMA_BLOCK;

    private OctavePerlinNoiseSampler soulsoilSampler;
    private OctavePerlinNoiseSampler blackstoneSampler;
    private OctavePerlinNoiseSampler soulsandSampler;

    protected long seed;

    public BlackstoneShalesSurfaceBuilder() {
        super(EmptySurfaceConfig.CODEC);
    }

    @Override
    public void generate(Random random, Chunk chunk, Biome biome, int x, int z, int height, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, EmptySurfaceConfig config) {
        // For each x, z value go through every y value
        for (int y = 0; y < 256; y++) {
            // Set a position variable equal to the current block in question
            BlockPos pos = new BlockPos(x & 15, y, z & 15);
            // Get the block state of the current block in question
            BlockState state = chunk.getBlockState(pos);

            // If the block in question is a ground block
            if (state.getBlock() == defaultBlock.getBlock()) {

                // If the block is in a two block radius of air
                if (blockInProximity(pos, chunk, Blocks.AIR.getDefaultState(), 2)) {
                    // Get the noise concentrations for the three blocks we're interested in
                    double blackstoneConcentration = blackstoneSampler.sample(x, y, z);
                    double soulsoilConcentration = soulsoilSampler.sample(x, y, z);
                    double soulsandConcentration = soulsandSampler.sample(x, y, z);

                    BlockState toBe;
                    if (soulsoilConcentration > blackstoneConcentration) {
                        if (soulsandConcentration > soulsoilConcentration) {
                            toBe = SOUL_SAND;
                        } else {
                            toBe = SOUL_SOIL;
                        }
                    } else {
                        toBe = BLACKSTONE;
                        if (blockInProximity(pos, chunk, defaultFluid, 4) && random.nextFloat() > 0.5) {
                            toBe = MAGMA_BLOCK;
                        }
                    }
                    chunk.setBlockState(pos, toBe, false);
                }
            }
        }
    }

    public boolean blockInProximity(BlockPos pos, Chunk chunk, BlockState state, int radius) {
        for (int checkx = -radius; checkx <= radius; checkx++) {
            for (int checky = -radius; checky <= radius; checky++) {
                for (int checkz = -radius; checkz <= radius; checkz++) {
                    if (chunk.getBlockState(pos.east(checkx).up(checky).south(checkz)).getBlock() == state.getBlock()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void initSeed(long seed) {
        if (this.seed != seed || this.soulsoilSampler == null || this.soulsandSampler == null || this.blackstoneSampler == null) {
            this.soulsoilSampler = new OctavePerlinNoiseSampler(new ChunkRandom(seed), ImmutableList.of(-4));
            seed++;
            this.soulsandSampler = new OctavePerlinNoiseSampler(new ChunkRandom(seed), ImmutableList.of(-4));
            seed++;
            this.blackstoneSampler = new OctavePerlinNoiseSampler(new ChunkRandom(seed), ImmutableList.of(-4));
            seed++;
        }
        this.seed = seed;
    }

    static {
        BLACKSTONE = Blocks.BLACKSTONE.getDefaultState();
        SOUL_SAND = Blocks.SOUL_SAND.getDefaultState();
        SOUL_SOIL = Blocks.SOUL_SOIL.getDefaultState();
        MAGMA_BLOCK = Blocks.MAGMA_BLOCK.getDefaultState();
    }
}
