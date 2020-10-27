package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.feature.config.VegetationFeatureConfig;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class VegetationFeature extends Feature<VegetationFeatureConfig> {
    public VegetationFeature() {
        super(VegetationFeatureConfig.CODEC);
    }

    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator generator, Random random, BlockPos pos, VegetationFeatureConfig config) {
        return generateVegetation(world, random, pos, config, 8, 4);
    }

    public static boolean generateVegetation(WorldAccess world, Random random, BlockPos pos, VegetationFeatureConfig config, int horizontalSpread, int verticalSpread) {
        BlockState belowState = world.getBlockState(pos.down());
        BlockState testState = world.getBlockState(pos);
        while(!(config.placeableStates.contains(belowState) && (world.isAir(pos) || config.replaceableStates.contains(testState)) ) && pos.getY() > 0) {
            pos = pos.down();
            belowState = world.getBlockState(pos.down());
            testState = world.getBlockState(pos);
        }
        int y = pos.getY();
        if (y >= 1 && y + 1 < 256) {
            int setCount = 0;

            for(int n = 0; n < horizontalSpread * horizontalSpread; n++) {
                BlockPos setPos = pos.add(random.nextInt(horizontalSpread) - random.nextInt(horizontalSpread), random.nextInt(verticalSpread) - random.nextInt(verticalSpread), random.nextInt(horizontalSpread) - random.nextInt(horizontalSpread));
                BlockState setState = config.vegetationStates.getBlockState(random, setPos);
                if ((world.isAir(setPos) || config.replaceableStates.contains(world.getBlockState(setPos))) && setPos.getY() > 0 && setState.canPlaceAt(world, setPos)) {
                    world.setBlockState(setPos, setState, 2);
                    setCount++;
                }
            }

            return setCount > 0;
        } else {
            return false;
        }
    }
}
