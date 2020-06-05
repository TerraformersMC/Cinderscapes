package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.feature.config.ShardFeatureConfig;
import com.terraformersmc.cinderscapes.util.shapelib.Quaternion;
import com.terraformersmc.cinderscapes.util.shapelib.Shape;
import com.terraformersmc.cinderscapes.util.shapelib.Shapes;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;

public class CeilingShardFeature extends Feature<ShardFeatureConfig> {
    public CeilingShardFeature() {
        super(ShardFeatureConfig.CODEC);
    }

    @Override
    public boolean generate(ServerWorldAccess world, StructureAccessor accessor, ChunkGenerator generator, Random random, BlockPos pos, ShardFeatureConfig config) {
        int amount = random.nextInt(3) + 2;
        Shape shape = new Shape();
        for (int i = 0; i < amount; i++) {
            int height = random.nextInt(8) + 14;
            float radius = random.nextFloat() * 2 + 2;
            float ztheta = (random.nextFloat() * 30) + 15;
            float ytheta = random.nextFloat() * 360;
            shape.join(Shapes.coneSolidRotated(radius, height, new Quaternion(0, ytheta, ztheta, true)));
        }
        shape.rotateBy(Quaternion.of(0, 0, 0, 1)).translateBy(pos).translateUp(2).fillIfSafeWhitelist(config.shardMaterial, world, config.groundMaterials);
        return true;
    }
}
