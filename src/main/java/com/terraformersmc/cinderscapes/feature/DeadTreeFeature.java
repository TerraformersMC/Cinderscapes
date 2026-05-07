package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.terraform.shapes.api.Position;
import com.terraformersmc.terraform.shapes.api.Quaternion;
import com.terraformersmc.terraform.shapes.api.Shape;
import com.terraformersmc.terraform.shapes.api.Shapes;
import com.terraformersmc.terraform.shapes.api.filler.Filler;
import com.terraformersmc.terraform.shapes.api.layer.Layer;
import com.terraformersmc.terraform.shapes.api.validator.Validator;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import org.jspecify.annotations.NullMarked;

import java.util.Arrays;

@NullMarked
public class DeadTreeFeature extends Feature<NoneFeatureConfiguration> {
    public DeadTreeFeature() {
        super(NoneFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        RandomSource random = context.random();
        BlockPos pos = context.origin();
        WorldGenLevel level = context.level();
        if (level.getBlockState(pos.below()).getBlock() == CinderscapesBlocks.ASH) {
            pos = pos.below();
        }
        if (!Block.isFaceFull(level.getBlockState(pos.below()).getCollisionShape(level, pos.below()), Direction.UP)) {
            return false;
        }
        if (level.getBlockState(pos.below()).getBlock() == Blocks.MAGMA_BLOCK || level.getBlockState(pos.below()).getBlock() == CinderscapesBlocks.SCORCHED_STEM) {
            return false;
        }

        int trunkHeight = random.nextInt(4) + 4;

        Shape trunkShape = verticalLine(trunkHeight, Quaternion.of(1, 0, 0, 0))
            .applyLayer(Layer.translate(Position.of(pos)));

        Shape topperShape = recursiveTreeTopper(random, 2, 4, 15, 45, 2, 5, 3, 3)
                .applyLayer(Layer.translate(Position.of(0, trunkHeight, 0)))
                .applyLayer(Layer.translate(Position.of(pos)));

        Validator safelistValidator = Validator.safelist(level,  Arrays.asList(
                Blocks.AIR.defaultBlockState(),
                CinderscapesBlocks.ASH.defaultBlockState()
        ));

        boolean trunkSafe = safelistValidator.validate(trunkShape);
        boolean topperSafe = safelistValidator.validate(topperShape);

        if (trunkSafe && topperSafe) {
            trunkShape.fill(Filler.simple(level, CinderscapesBlocks.SCORCHED_STEM.defaultBlockState()));
            topperShape.fill(Filler.simple(level, CinderscapesBlocks.SCORCHED_HYPHAE.defaultBlockState()));
            return true;
        }

        return false;
    }

    private static Shape recursiveTreeTopper(RandomSource random, int minLength, int maxLength, int minSpread, int maxSpread, int minChildren, int maxChildren, int totalRecursionLevel, int recursionCounter) {
        Shape shape = Shapes.rectangularPrism(1, 1, 1);

        if (recursionCounter == 0) {
            return shape;
        }

        int children = random.nextInt(maxChildren - minChildren) + minChildren;
        for (int i = 0; i < children; i++) {
            float recursionRatio = (float) recursionCounter / (float) totalRecursionLevel;
            int length = random.nextInt(maxLength - minLength) + minLength;
            shape = shape.applyLayer(Layer.add(Shapes.rectangularPrism(1, length, 1)
                    .applyLayer(Layer.translate(Position.of(0, length / 2.0f, 0)))
                    .applyLayer(Layer.add(recursiveTreeTopper(random, minLength, (int)((maxLength - minLength) * recursionRatio) + minLength, (int)(minSpread * recursionRatio), (int)(maxSpread * recursionRatio), (int)(minChildren * recursionRatio), (int)(maxChildren * recursionRatio), totalRecursionLevel, recursionCounter - 1)
                            .applyLayer(Layer.translate(Position.of(0, length, 0)))))
                    .applyLayer(Layer.rotate(Quaternion.of(0, random.nextFloat() * 360, random.nextFloat() * (maxSpread - minSpread) + minSpread, true)))));
        }

        return shape;
    }

    private static Shape verticalLine(int height, Quaternion rotation) {
        return Shape.of((pos) -> true, Position.of(1, height, 1), Position.of(0, 0, 0)).applyLayer(Layer.rotate(rotation));
    }
}
