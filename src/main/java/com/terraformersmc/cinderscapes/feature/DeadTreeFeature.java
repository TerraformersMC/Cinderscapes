package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.util.MathHelper;
import com.terraformersmc.terraform.shapes.api.Filler;
import com.terraformersmc.terraform.shapes.api.Position;
import com.terraformersmc.terraform.shapes.api.Quaternion;
import com.terraformersmc.terraform.shapes.api.Shape;
import com.terraformersmc.terraform.shapes.api.validator.Validator;
import com.terraformersmc.terraform.shapes.impl.Shapes;
import com.terraformersmc.terraform.shapes.impl.filler.SimpleFiller;
import com.terraformersmc.terraform.shapes.impl.layer.pathfinder.AddLayer;
import com.terraformersmc.terraform.shapes.impl.layer.transform.RotateLayer;
import com.terraformersmc.terraform.shapes.impl.layer.transform.TranslateLayer;
import com.terraformersmc.terraform.shapes.impl.validator.SafelistValidator;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

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

        Shape trunkShape = verticalLine(trunkHeight, Quaternion.of(1, 0, 0, 0))
            .applyLayer(new TranslateLayer(Position.of(pos)));

        Shape topperShape = recursiveTreeTopper(random, 2, 4, 15, 45, 2, 5, 3, 3)
                .applyLayer(new TranslateLayer(Position.of(0, trunkHeight, 0)))
                .applyLayer(new TranslateLayer(Position.of(pos)));

        Validator safelistValidator = new SafelistValidator(world,  Arrays.asList(
                Blocks.AIR.getDefaultState(),
                CinderscapesBlocks.ASH.getDefaultState()
        ));

        boolean trunkSafe = safelistValidator.validate(trunkShape);
        boolean topperSafe = safelistValidator.validate(topperShape);

        if (trunkSafe && topperSafe) {
            trunkShape.fill(new SimpleFiller(world, CinderscapesBlocks.SCORCHED_STEM.getDefaultState()));
            topperShape.fill(new SimpleFiller(world, CinderscapesBlocks.SCORCHED_HYPHAE.getDefaultState()));
            return true;
        }

        return false;
    }

    private static Shape recursiveTreeTopper(Random random, int minLength, int maxLength, int minSpread, int maxSpread, int minChildren, int maxChildren, int totalRecursionLevel, int recursionCounter) {
        Shape shape = Shapes.rectanglarPrism(1, 1, 1);

        if (recursionCounter == 0) {
            return shape;
        }

        int children = random.nextInt(maxChildren - minChildren) + minChildren;
        for (int i = 0; i < children; i++) {
            float recursionRatio = (float) recursionCounter / (float) totalRecursionLevel;
            int length = random.nextInt(maxLength - minLength) + minLength;
            shape = shape.applyLayer(new AddLayer(Shapes.rectanglarPrism(1, length, 1)
                    .applyLayer(new TranslateLayer(Position.of(0, length / 2.0f, 0)))
                    .applyLayer(new AddLayer(recursiveTreeTopper(random, minLength, (int)((maxLength - minLength) * recursionRatio) + minLength, (int)(minSpread * recursionRatio), (int)(maxSpread * recursionRatio), (int)(minChildren * recursionRatio), (int)(maxChildren * recursionRatio), totalRecursionLevel, recursionCounter - 1)
                            .applyLayer(new TranslateLayer(Position.of(0, length, 0)))))
                    .applyLayer(new RotateLayer(Quaternion.of(0, random.nextFloat() * 360, random.nextFloat() * (maxSpread - minSpread) + minSpread, true)))));
        }

        return shape;
    }

    private static Shape verticalLine(int height, Quaternion rotation) {
        return Shape.of((pos) -> true, Position.of(1, height, 1), Position.of(0, 0, 0)).applyLayer(new RotateLayer(rotation));
    }
}
