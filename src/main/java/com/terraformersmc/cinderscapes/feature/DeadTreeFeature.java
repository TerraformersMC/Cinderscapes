package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.terraform.shapes.api.Position;
import com.terraformersmc.terraform.shapes.api.Quaternion;
import com.terraformersmc.terraform.shapes.api.Shape;
import com.terraformersmc.terraform.shapes.impl.Shapes;
import com.terraformersmc.terraform.shapes.impl.filler.SimpleFiller;
import com.terraformersmc.terraform.shapes.impl.layer.pathfinder.AddLayer;
import com.terraformersmc.terraform.shapes.impl.layer.transform.RotateLayer;
import com.terraformersmc.terraform.shapes.impl.layer.transform.TranslateLayer;
import com.terraformersmc.terraform.shapes.impl.validator.SafelistValidator;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DeadTreeFeature extends Feature<DefaultFeatureConfig> {
    public DeadTreeFeature() {
        super(DefaultFeatureConfig.CODEC);
    }

    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator generator, Random random, BlockPos pos, DefaultFeatureConfig config) {
        if (world.getBlockState(pos.down()).getBlock() == CinderscapesBlocks.ASH) {
            pos = pos.down();
        }
        if (!Block.isFaceFullSquare(world.getBlockState(pos.down()).getCollisionShape(world, pos.down()), Direction.UP)) {
            return false;
        }
        if (world.getBlockState(pos.down()).getBlock() == Blocks.MAGMA_BLOCK || world.getBlockState(pos.down()).getBlock() == CinderscapesBlocks.SCORCHED_STEM) {
            return false;
        }

        int trunkHeight = random.nextInt(4) + 4;

        Shape shape = recursiveTree(3, random);
        shape
            .applyLayer(new TranslateLayer(Position.of(0, trunkHeight, 0)))
            .applyLayer(new AddLayer(Shapes.rectanglarPrism(1, trunkHeight, 1)))
            .applyLayer(new TranslateLayer(Position.of(pos)))
            .validate(new SafelistValidator(world, Arrays.asList(Blocks.AIR.getDefaultState(), CinderscapesBlocks.ASH.getDefaultState())), (safeShape) -> {
                safeShape.fill(new SimpleFiller(world, CinderscapesBlocks.SCORCHED_HYPHAE.getDefaultState()));
            });
        return true;
    }

    private Shape recursiveTree(int recursionLevel, Random random) {
        if (recursionLevel == 0) {
            return Shape.of((point) -> false, Position.of(0, 0, 0), Position.of(0, 0, 0));
        }

        int amount = random.nextInt(4) + 1;

        Shape shape = Shape.of((point) -> false, Position.of(0, 0, 0), Position.of(0, 0, 0));

        for (int i = 0; i < amount; i++) {

            float zAngle = random.nextFloat() * 30 + 15;
            float yAngle = random.nextFloat() * 360;

            int height = random.nextInt(2) + 4;

            shape
                .applyLayer(new AddLayer(
                    recursiveTree(recursionLevel - 1, random)
                        .applyLayer(new TranslateLayer(Position.of(0, height, 0)))
                        .applyLayer(new AddLayer(Shapes.rectanglarPrism(1, height, 1)))
                        .applyLayer(new RotateLayer(Quaternion.of(0, yAngle, zAngle, true)))
                ));
        }

        return shape;
    }
}
