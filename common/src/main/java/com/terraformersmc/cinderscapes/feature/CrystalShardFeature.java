package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.feature.config.CrystalShardFeatureConfig;
import com.terraformersmc.cinderscapes.util.RegionalSafelistValidator;
import com.terraformersmc.terraform.shapes.api.Position;
import com.terraformersmc.terraform.shapes.api.Quaternion;
import com.terraformersmc.terraform.shapes.api.Shape;
import com.terraformersmc.terraform.shapes.impl.Shapes;
import com.terraformersmc.terraform.shapes.impl.filler.SimpleFiller;
import com.terraformersmc.terraform.shapes.impl.layer.pathfinder.AddLayer;
import com.terraformersmc.terraform.shapes.impl.layer.transform.RotateLayer;
import com.terraformersmc.terraform.shapes.impl.layer.transform.TranslateLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class CrystalShardFeature extends Feature<CrystalShardFeatureConfig> {
    public CrystalShardFeature() {
        super(CrystalShardFeatureConfig.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<CrystalShardFeatureConfig> context) {
        RandomSource random = context.random();
        WorldGenLevel world = context.level();
        BlockPos pos = context.origin();
        CrystalShardFeatureConfig config = context.config();

        int amount = random.nextInt(3) + 2;

        Shape shape = Shape.of((point) -> false, Position.of(0, 0, 0), Position.of(0, 0, 0));
        for (int i = 0; i < amount; i++) {
            int height = random.nextInt(8) + 14;
            float radius = random.nextFloat() * 2 + 2;
            float ztheta = (random.nextFloat() * 30) + 15;
            float ytheta = random.nextFloat() * 360;

            shape = shape.applyLayer(new AddLayer(Shapes
                    .ellipticalPyramid(radius, radius, height)
                    .applyLayer(RotateLayer.of(Quaternion.of(0, ytheta, ztheta, true)))
            ));
        }

        shape
                .applyLayer(RotateLayer.of(Quaternion.of(config.dir().getRotation())))
                .applyLayer(TranslateLayer.of(Position.of(pos)))
                .validate(new RegionalSafelistValidator(world, config.dir(), config.whitelist()), (validShape) -> {
                    validShape.fill(SimpleFiller.of(world, config.state()));
                });

        return true;
    }
}
