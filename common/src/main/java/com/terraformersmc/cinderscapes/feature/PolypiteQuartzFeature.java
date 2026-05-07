package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.feature.config.PolypiteQuartzFeatureConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import org.jspecify.annotations.NullMarked;

import java.util.ArrayList;
import java.util.List;

@NullMarked
public class PolypiteQuartzFeature extends Feature<PolypiteQuartzFeatureConfig> {
    public PolypiteQuartzFeature() {
        super(PolypiteQuartzFeatureConfig.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<PolypiteQuartzFeatureConfig> context) {
        RandomSource random = context.random();
        BlockPos pos = context.origin();
        WorldGenLevel world = context.level();
        if (world.isEmptyBlock(pos)) {
            List<Direction> valid_faces = new ArrayList<>();
            for (Direction dir : Direction.values()) {
                BlockPos placeOnPos = pos.relative(dir);
                BlockState placeOnState = world.getBlockState(placeOnPos);
                if (placeOnState.is(Blocks.NETHERRACK)) {
                    valid_faces.add(dir);
                }
            }
            if (!valid_faces.isEmpty()) {
                Direction setDir = valid_faces.get(random.nextInt(valid_faces.size()));
                world.setBlock(pos, context.config().quartzMaterial().stateOf(setDir), 0);
                return true;
            }
        }

        return false;
    }
}
