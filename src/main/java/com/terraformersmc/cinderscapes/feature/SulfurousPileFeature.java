package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

//TODO: Rewrite using the upcoming shapes library
//TODO: Make a feature config allowing the material and size range to change
public class SulfurousPileFeature extends Feature<DefaultFeatureConfig> {
    public SulfurousPileFeature() {
        super(DefaultFeatureConfig.CODEC);
    }

    @Override
    public boolean generate(ServerWorldAccess world, StructureAccessor accessor, ChunkGenerator generator, Random random, BlockPos pos, DefaultFeatureConfig config) {
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
