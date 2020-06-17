package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.feature.config.SimpleStateFeatureConfig;
import com.terraformersmc.shapes.api.Position;
import com.terraformersmc.shapes.api.Quaternion;
import com.terraformersmc.shapes.api.validator.AllMeetValidator;
import com.terraformersmc.shapes.impl.Shapes;
import com.terraformersmc.shapes.impl.filler.SimpleFiller;
import com.terraformersmc.shapes.impl.layer.transform.RotateLayer;
import com.terraformersmc.shapes.impl.layer.transform.TranslateLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author <Wtoll> Will Toll on 2020-06-17
 * @project Cinderscapes
 */
public class ShaleFeature extends Feature<SimpleStateFeatureConfig> {
    public ShaleFeature() {
        super(SimpleStateFeatureConfig.CODEC);
    }

    @Override
    public boolean generate(ServerWorldAccess world, StructureAccessor accessor, ChunkGenerator generator, Random random, BlockPos pos, SimpleStateFeatureConfig config) {
        float pitch = random.nextFloat() * 30;
        float yaw = random.nextFloat() * 360;
        float height = random.nextFloat() * 5 + 5;
        List<Boolean> ok = new ArrayList<>();
        Shapes.ellipsoid(height * 0.75, 2, height)
                .applyLayer(RotateLayer.of(Quaternion.of(new net.minecraft.util.math.Quaternion(pitch, yaw, 0, true))))
                .applyLayer(TranslateLayer.of(Position.of(pos)))
                .validate(AllMeetValidator.of((valpos) -> {
                    return world.isAir(valpos.toBlockPos()) || config.replaceableBlocks.contains(world.getBlockState(valpos.toBlockPos()));
                }), (validshape) -> {
                    ok.add(true);
                    validshape.fill(SimpleFiller.of(world, config.state));
                });
        return ok.contains(true);
    }
}
