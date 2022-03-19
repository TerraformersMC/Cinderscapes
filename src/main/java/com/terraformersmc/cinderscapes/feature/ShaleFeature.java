package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.feature.config.SimpleStateFeatureConfig;
import com.terraformersmc.terraform.shapes.api.Position;
import com.terraformersmc.terraform.shapes.api.Quaternion;
import com.terraformersmc.terraform.shapes.api.validator.AllMeetValidator;
import com.terraformersmc.terraform.shapes.impl.Shapes;
import com.terraformersmc.terraform.shapes.impl.filler.SimpleFiller;
import com.terraformersmc.terraform.shapes.impl.layer.transform.RotateLayer;
import com.terraformersmc.terraform.shapes.impl.layer.transform.TranslateLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShaleFeature extends Feature<SimpleStateFeatureConfig> {
    public ShaleFeature() {
        super(SimpleStateFeatureConfig.CODEC);
    }

    @Override
    public boolean generate(FeatureContext<SimpleStateFeatureConfig> context) {
        Random random = context.getRandom();
        BlockPos pos = context.getOrigin();
        StructureWorldAccess world = context.getWorld();
        float pitch = random.nextFloat() * 30;
        float yaw = random.nextFloat() * 360;
        float height = random.nextFloat() * 5 + 5;
        List<Boolean> ok = new ArrayList<>();
        Shapes.ellipsoid(height * 0.75, 2, height)
                .applyLayer(RotateLayer.of(Quaternion.of(pitch, yaw, 0, true)))
                .applyLayer(TranslateLayer.of(Position.of(pos)))
                .validate(AllMeetValidator.of((valpos) -> {
                    return world.isAir(valpos.toBlockPos()) || context.getConfig().replaceableBlocks.contains(world.getBlockState(valpos.toBlockPos()));
                }), (validshape) -> {
                    ok.add(true);
                    validshape.fill(SimpleFiller.of(world, context.getConfig().state));
                });
        return ok.contains(true);
    }
}
