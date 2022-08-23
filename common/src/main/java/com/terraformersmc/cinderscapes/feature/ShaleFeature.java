package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.feature.config.ShaleFeatureConfig;
import com.terraformersmc.terraform.shapes.api.Position;
import com.terraformersmc.terraform.shapes.api.Quaternion;
import com.terraformersmc.terraform.shapes.impl.Shapes;
import com.terraformersmc.terraform.shapes.impl.filler.SimpleFiller;
import com.terraformersmc.terraform.shapes.impl.layer.transform.RotateLayer;
import com.terraformersmc.terraform.shapes.impl.layer.transform.TranslateLayer;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class ShaleFeature extends Feature<ShaleFeatureConfig> {
    public ShaleFeature() {
        super(ShaleFeatureConfig.CODEC);
    }

    @Override
    public boolean generate(FeatureContext<ShaleFeatureConfig> context) {
        ShaleFeatureConfig config = context.getConfig();
        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();

        if (world.isAir(pos) || !world.getBlockState(pos.up()).isAir() || world.getBlockState(pos).isOf(Blocks.BLACKSTONE)) {
            return false;
        }

        float radius = context.getRandom().nextInt(config.max() - config.min()) + config.min();
        if (world.getBlockState(pos).isOf(Blocks.LAVA)) {
            radius = radius * 1.5f;
        }
        int tilt = context.getRandom().nextInt(30) - 15;
        int turn = context.getRandom().nextInt(360);

        Shapes.ellipsoid(2, radius / 1.5, radius)
                .applyLayer(RotateLayer.of(Quaternion.of(tilt, turn, 0, true)))
                .applyLayer(TranslateLayer.of(Position.of(pos)))
                .fill(new SimpleFiller(world, config.state()));

        return true;
    }
}
