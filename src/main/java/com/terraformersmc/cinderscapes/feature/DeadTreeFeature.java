package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.util.shapelib.MathHelper;
import com.terraformersmc.cinderscapes.util.shapelib.Quaternion;
import com.terraformersmc.cinderscapes.util.shapelib.Shape;
import com.terraformersmc.cinderscapes.util.shapelib.Shapes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author <Wtoll> Will Toll on 2020-05-23
 * @project Cinderscapes
 */
public class DeadTreeFeature extends Feature<DefaultFeatureConfig> {
    public DeadTreeFeature() {
        super(DefaultFeatureConfig.CODEC);
    }

    @Override
    public boolean generate(ServerWorldAccess world, StructureAccessor accessor, ChunkGenerator generator, Random random, BlockPos pos, DefaultFeatureConfig config) {
        if (world.getBlockState(pos.down()).getBlock() == CinderscapesBlocks.ASH) {
            pos = pos.down();
        }
        if (!Block.isFaceFullSquare(world.getBlockState(pos.down()).getCollisionShape(world, pos.down()), Direction.UP)) {
            return false;
        }
        if (world.getBlockState(pos.down()).getBlock() == Blocks.MAGMA_BLOCK || world.getBlockState(pos.down()).getBlock() == CinderscapesBlocks.SCORCHED_STEM) {
            return false;
        }
        Shape shape = new Shape();
        boolean good = recursiveTree(world, pos, new ArrayList<>(), 3, 3, random, shape);
        if (good) {
            shape.fill(CinderscapesBlocks.SCORCHED_HYPHAE.getDefaultState(), world);
            return true;
        }
        return false;
    }

    private boolean recursiveTree(ServerWorldAccess world, BlockPos pos, List<Quaternion> previousRotations, int startingPoint, int recursionLevel, Random random, Shape toBuild) {
        if (recursionLevel == 0) {
            return true;
        }
        boolean allGood = true;
        float zAngle = random.nextFloat() * 45;
        float yAngle = random.nextFloat() * 360;
        if (recursionLevel == startingPoint) {
            zAngle = 0;
            yAngle = 0;
        }
        int height = random.nextInt(2) + Math.round(MathHelper.map(recursionLevel, startingPoint, 0, 6, 2));

        List<Quaternion> rotations = new ArrayList<Quaternion>(previousRotations);
        rotations.add(new Quaternion(0, yAngle, zAngle, true));

        BlockPos endPoint = Quaternion.of(0, 0, height, 0).rotateBy(rotations).toBlockPos().add(pos);
        Shape line = Shapes.line(pos, endPoint);
        if (line.isSafeWhitelist(world, Arrays.asList(Blocks.AIR.getDefaultState(), CinderscapesBlocks.ASH.getDefaultState()))) {
            toBuild.join(line);
            int amount = random.nextInt(3) + 2;
            for (int i = 0; i < amount; i++) {
                allGood = allGood && recursiveTree(world, endPoint, rotations, startingPoint, recursionLevel - 1, random, toBuild);
            }
        } else {
            allGood = false;
        }
        return allGood;
    }
}
