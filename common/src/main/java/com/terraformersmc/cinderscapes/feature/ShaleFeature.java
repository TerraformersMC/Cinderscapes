package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.feature.config.ShaleFeatureConfig;
import com.terraformersmc.terraform.shapes.api.Position;
import com.terraformersmc.terraform.shapes.api.Quaternion;
import com.terraformersmc.terraform.shapes.api.Shapes;
import com.terraformersmc.terraform.shapes.api.filler.Filler;
import com.terraformersmc.terraform.shapes.api.layer.Layer;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class ShaleFeature extends Feature<ShaleFeatureConfig> {
    public ShaleFeature() {
        super(ShaleFeatureConfig.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<ShaleFeatureConfig> context) {
        RandomSource random = context.random();
        ShaleFeatureConfig config = context.config();
        WorldGenLevel world = context.level();
        BlockPos pos = context.origin();

        if (world.isEmptyBlock(pos) || !world.getBlockState(pos.above()).isAir() || world.getBlockState(pos).is(Blocks.BLACKSTONE)) {
            return false;
        }

        float radius = random.nextInt(config.max() - config.min()) + config.min();
        if (world.getBlockState(pos).is(Blocks.LAVA)) {
            radius = radius * 1.5f;
        }
        float ztheta = (random.nextFloat() * 30) - 15;
        float ytheta = random.nextFloat() * 360;

        Shapes.ellipsoid(2, radius / 1.5, radius)
                .applyLayer(Layer.rotate(Quaternion.of(0, ytheta, ztheta, true)))
                .applyLayer(Layer.translate(Position.of(pos)))
                .fill(Filler.simple(world, config.state()));

        return true;
    }
}
