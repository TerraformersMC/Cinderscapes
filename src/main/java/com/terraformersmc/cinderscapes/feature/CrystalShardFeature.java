package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.feature.config.CrystalShardFeatureConfig;
import com.terraformersmc.cinderscapes.util.RegionalSafelistValidator;
import com.terraformersmc.terraform.shapes.api.Position;
import com.terraformersmc.terraform.shapes.api.Quaternion;
import com.terraformersmc.terraform.shapes.api.Shape;
import com.terraformersmc.terraform.shapes.api.Shapes;
import com.terraformersmc.terraform.shapes.api.filler.Filler;
import com.terraformersmc.terraform.shapes.api.layer.Layer;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class CrystalShardFeature extends Feature<CrystalShardFeatureConfig> {
    public CrystalShardFeature() {
        super(CrystalShardFeatureConfig.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<CrystalShardFeatureConfig> context) {
        RandomSource random = context.random();
        WorldGenLevel level = context.level();
        BlockPos pos = context.origin();
        CrystalShardFeatureConfig config = context.config();

        int amount = random.nextInt(3) + 2;

        Shape shape = Shapes.empty();
        for (int i = 0; i < amount; i++) {
            int height = random.nextInt(8) + 14;
            float radius = random.nextFloat() * 2 + 2;
            float ztheta = (random.nextFloat() * 30) + 15;
            float ytheta = random.nextFloat() * 360;

            shape = shape.applyLayer(Layer.add(Shapes
                    .ellipticalPyramid(radius, radius, height)
                    .applyLayer(Layer.rotate(Quaternion.of(0, ytheta, ztheta, true)))
            ));
        }

        shape
                .applyLayer(Layer.rotate(Quaternion.of(config.dir().getRotation())))
                .applyLayer(Layer.translate(Position.of(pos)))
                .validate(new RegionalSafelistValidator(level, config.dir(), config.whitelist()),
                        validShape -> validShape.fill(Filler.simple(level, config.state()))
                );

        return true;
    }
}
