package com.terraformersmc.cinderscapes.feature;

import com.mojang.datafixers.Dynamic;
import com.terraformersmc.cinderscapes.util.shapelib.Quaternion;
import com.terraformersmc.cinderscapes.util.shapelib.Shape;
import com.terraformersmc.cinderscapes.util.shapelib.Shapes;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

/**
 * @author <Wtoll> Will Toll on 2020-05-23
 * @project Cinderscapes
 */
public class DeadTreeFeature extends Feature<DefaultFeatureConfig> {
    public DeadTreeFeature() {
        super(DefaultFeatureConfig::deserialize);
    }

    @Override
    public boolean generate(IWorld world, StructureAccessor accessor, ChunkGenerator<? extends ChunkGeneratorConfig> generator, Random random, BlockPos pos, DefaultFeatureConfig config) {
        Shape shape = new Shape();
        boolean good = recursiveTree(world, pos, new ArrayList<>(), 5, random, shape);
        if (good) {
            shape.fill(Blocks.OAK_LOG.getDefaultState(), world);
            System.out.println("Yes");
            return true;
        }
        return false;
    }

    private boolean recursiveTree(IWorld world, BlockPos pos, List<Quaternion> previousRotations, int recursionLevel, Random random, Shape toBuild) {
        boolean allGood = true;
        float zAngle = random.nextFloat() * 45;
        float yAngle = random.nextFloat() * 360;
        int height = random.nextInt(5) + 5;

        List<Quaternion> rotations = new ArrayList<Quaternion>(previousRotations);
        rotations.add(new Quaternion(0, yAngle, zAngle, true));

        BlockPos endPoint = Quaternion.of(0, 0, height, 0).rotateBy(previousRotations).toBlockPos().add(pos);
        Shape line = Shapes.line(pos, endPoint);
        if (line.isSafeWhitelist(world, Arrays.asList(Blocks.AIR.getDefaultState()))) {
            toBuild.join(line);
            int amount = random.nextInt(3) + 1;
            for (int i = 0; i < amount; i++) {
                allGood = allGood && recursiveTree(world, pos, rotations, recursionLevel - 1, random, toBuild);
            }
        } else {
            allGood = false;
        }
        return allGood;
    }
}
