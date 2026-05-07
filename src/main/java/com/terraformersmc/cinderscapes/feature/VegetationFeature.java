package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.feature.config.VegetationFeatureConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class VegetationFeature extends Feature<VegetationFeatureConfig> {
    public VegetationFeature() {
        super(VegetationFeatureConfig.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<VegetationFeatureConfig> context) {
        return generateVegetation(context.level(), context.random(), context.origin(), context.config(), 8, 4);
    }

    public static boolean generateVegetation(WorldGenLevel level, RandomSource random, BlockPos pos, VegetationFeatureConfig config, int horizontalSpread, int verticalSpread) {
        BlockState belowState = level.getBlockState(pos.below());
        BlockState testState = level.getBlockState(pos);
        while(!(config.placeableStates().contains(belowState) && (level.isEmptyBlock(pos) || config.replaceableStates().contains(testState)) ) && pos.getY() > 0) {
            pos = pos.below();
            belowState = level.getBlockState(pos.below());
            testState = level.getBlockState(pos);
        }
        int y = pos.getY();
        if (y >= 1 && y + 1 < 256) {
            int setCount = 0;

            for(int n = 0; n < horizontalSpread * horizontalSpread; n++) {
                BlockPos setPos = pos.offset(random.nextInt(horizontalSpread) - random.nextInt(horizontalSpread), random.nextInt(verticalSpread) - random.nextInt(verticalSpread), random.nextInt(horizontalSpread) - random.nextInt(horizontalSpread));
                BlockState setState = config.vegetationStates().getState(level, random, setPos);
                if ((level.isEmptyBlock(setPos) || config.replaceableStates().contains(level.getBlockState(setPos))) && setPos.getY() > 0 && setState.canSurvive(level, setPos)) {
                    level.setBlock(setPos, setState, 2);
                    setCount++;
                }
            }

            return setCount > 0;
        } else {
            return false;
        }
    }
}
