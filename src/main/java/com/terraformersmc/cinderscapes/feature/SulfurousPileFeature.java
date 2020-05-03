package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class SulfurousPileFeature extends Feature<DefaultFeatureConfig> {
    public SulfurousPileFeature() {
        super(DefaultFeatureConfig::deserialize);
    }

    @Override
    public boolean generate(IWorld world, StructureAccessor accessor, ChunkGenerator<? extends ChunkGeneratorConfig> generator, Random random, BlockPos pos, DefaultFeatureConfig config) {
        int width = random.nextInt(3) + 2;
        int length = random.nextInt(3) + 2;
        int height = random.nextInt(3) + 3;

        for (int x = -width; x <= width; x++) {
            for (int z = -length; z <= length; z++) {
                for (int y = 0; y < height; y++) {
                    BlockPos localPos = pos.add(x, y, z);

                    //ensure the position is valid
                    if (world.getBlockState(localPos.down()).isOpaque() && world.getBlockState(localPos).isAir()) {
                        if (random.nextInt(4) == 0) {
                            world.setBlockState(localPos, CinderscapesBlocks.SULFUR_BLOCK.getDefaultState(), 0);
                        }
                    }
                }
            }
        }

        return true;
    }
}
