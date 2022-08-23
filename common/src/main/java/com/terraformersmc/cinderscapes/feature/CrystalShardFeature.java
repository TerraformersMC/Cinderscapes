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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Random;

public class CrystalShardFeature extends Feature<CrystalShardFeatureConfig> {
    public CrystalShardFeature() {
        super(CrystalShardFeatureConfig.CODEC);
    }

    @Override
    public boolean generate(FeatureContext<CrystalShardFeatureConfig> context) {

        Random random = context.getRandom();
        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();
        CrystalShardFeatureConfig config = context.getConfig();

        int amount = random.nextInt(3) + 2;

        Shape shape = Shape.of((point) -> false, Position.of(0, 0, 0), Position.of(0, 0, 0));
        for (int i = 0; i < amount; i++) {
            int height = random.nextInt(8) + 14;
            float radius = random.nextFloat() * 2 + 2;
            float ztheta = (random.nextFloat() * 30) + 15;
            float ytheta = random.nextFloat() * 360;

            shape = shape.applyLayer(new AddLayer(Shapes
                    .ellipticalPyramid(radius, radius, height)
                    .applyLayer(new RotateLayer(Quaternion.of(0, ytheta, ztheta, true)))
            ));
        }

        shape
                .applyLayer(new RotateLayer(Quaternion.of(config.dir().getRotationQuaternion())))
                .applyLayer(new TranslateLayer(Position.of(pos)))
                .validate(new RegionalSafelistValidator(world, config.dir(), config.whitelist()), (validShape) -> {
                    validShape.fill(new SimpleFiller(world, config.state()));
                });

        return true;
    }
}
