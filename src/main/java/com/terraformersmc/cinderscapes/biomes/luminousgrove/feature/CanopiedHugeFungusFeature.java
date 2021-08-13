package com.terraformersmc.cinderscapes.biomes.luminousgrove.feature;

import com.terraformersmc.cinderscapes.biomes.luminousgrove.feature.config.CanopiedHugeFungusFeatureConfig;
import com.terraformersmc.terraform.shapes.api.Position;
import com.terraformersmc.terraform.shapes.api.Shape;
import com.terraformersmc.terraform.shapes.impl.Shapes;
import com.terraformersmc.terraform.shapes.impl.filler.RandomSimpleFiller;
import com.terraformersmc.terraform.shapes.impl.filler.SimpleFiller;
import com.terraformersmc.terraform.shapes.impl.layer.pathfinder.AddLayer;
import com.terraformersmc.terraform.shapes.impl.layer.pathfinder.SubtractLayer;
import com.terraformersmc.terraform.shapes.impl.layer.transform.TranslateLayer;
import com.terraformersmc.terraform.shapes.impl.validator.AirValidator;
import com.terraformersmc.terraform.shapes.impl.validator.SafelistValidator;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CanopiedHugeFungusFeature extends Feature<CanopiedHugeFungusFeatureConfig> {
    public CanopiedHugeFungusFeature() {
        super(CanopiedHugeFungusFeatureConfig.CODEC);
    }

    @Override
    public boolean generate(FeatureContext<CanopiedHugeFungusFeatureConfig> context) {

        CanopiedHugeFungusFeatureConfig config = context.getConfig();
        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();
        Random random = context.getRandom();

        // If the block the fungus is placed on isn't a soil block
        if (world.getBlockState(pos.down()) != config.soilBlock) {
            return false;
        }

        // Check the 3x3 area under the stem
        boolean solidGround = Shape.of((ipos) -> true, Position.of(2, 0, 2), Position.of(-1, -1, -1))
                .applyLayer(TranslateLayer.of(Position.of(pos)))
                .stream().map(Position::toBlockPos).allMatch((ipos) -> !world.isAir(ipos) && Block.isFaceFullSquare(world.getBlockState(ipos).getCollisionShape(world, pos.down()), Direction.UP));

        // If they are not all solid blocks
        if (!solidGround) {
            return false;
        }

        // Generate the actual fungus

        // Generate a random stem height
        int stemHeight = random.nextInt(20) + 6;

        // Create an empty list to generate a non geometric shape
        List<Position> stemBlocks = new ArrayList<>();
        // For each y value in the stem
        for (int y = 0; y < stemHeight; y++) {
            // Add the plus shape
            stemBlocks.add(Position.of(0, y, 0));
            stemBlocks.add(Position.of(1, y, 0));
            stemBlocks.add(Position.of(-1, y, 0));
            stemBlocks.add(Position.of(0, y, 1));
            stemBlocks.add(Position.of(0, y, -1));
            // If the y value is low down add the corners as well
            if (y < stemHeight * 0.2) {
                stemBlocks.add(Position.of(1, y, 1));
                stemBlocks.add(Position.of(1, y, -1));
                stemBlocks.add(Position.of(-1, y, 1));
                stemBlocks.add(Position.of(-1, y, -1));
            }
        }

        // Translate the stem blocks over
        stemBlocks = stemBlocks.stream().map((ipos) -> Position.of(ipos.getX() + pos.getX(), ipos.getY() + pos.getY(), ipos.getZ() + pos.getZ())).collect(Collectors.toList());

        // Generate a random canopy radius and height
        int canopyRadius = random.nextInt(3) + 6;
        int canopyHeight = random.nextInt(5) + 5;

        // Create a value for where the center of the canopy should be
        Position canopyPos = Position.of(pos.up(stemHeight - canopyHeight + 2));

        Shape canopy = Shapes.hemiEllipsoid(canopyRadius, canopyRadius, canopyHeight)
                .applyLayer(new SubtractLayer(Shapes.hemiEllipsoid(canopyRadius - 1, canopyRadius - 1, canopyHeight - 1)))
                .applyLayer(new AddLayer(Shapes.ellipticalPrism(canopyRadius, canopyRadius, 1)
                        .applyLayer(new SubtractLayer(Shapes.ellipticalPrism(canopyRadius - 1, canopyRadius - 1, 1)))))
                .applyLayer(new TranslateLayer(canopyPos));

        Shape flesh = Shapes.hemiEllipsoid(canopyRadius - 1, canopyRadius - 1, canopyHeight - 1)
                .applyLayer(new SubtractLayer(Shapes.hemiEllipsoid(canopyRadius - 2, canopyRadius - 2, canopyHeight - 2)))
                .applyLayer(new TranslateLayer(canopyPos));

        Shape detailBlocks = Shapes.hemiEllipsoid(canopyRadius - 2, canopyRadius - 2, canopyHeight - 2)
                .applyLayer(new SubtractLayer(Shapes.hemiEllipsoid(canopyRadius - 3, canopyRadius - 3, canopyHeight - 3)))
                .applyLayer(new TranslateLayer(canopyPos));

        Shape fleshDripping = Shapes.ellipticalPrism(canopyRadius - 1, canopyRadius - 1, 1)
                .applyLayer(new SubtractLayer(Shapes.ellipticalPrism(canopyRadius - 2, canopyRadius - 2, 1)))
                .applyLayer(new TranslateLayer(canopyPos));

        Shape canopyDripping = Shapes.ellipticalPrism(canopyRadius, canopyRadius, 1)
                .applyLayer(new SubtractLayer(Shapes.ellipticalPrism(canopyRadius - 1, canopyRadius - 1, 1)))
                .applyLayer(new TranslateLayer(down(canopyPos, 1)));

        boolean canopyClear = List.of(canopy, flesh, detailBlocks, fleshDripping, canopyDripping).stream().allMatch((shape) -> AirValidator.of((TestableWorld) world).validate(shape));
        boolean stemClear = stemBlocks.stream().allMatch((ipos) -> {
            return SafelistValidator.of(world, config.soilBlock, Blocks.NETHERRACK.getDefaultState()).test(ipos) || world.getBlockState(ipos.toBlockPos()).getBlock() instanceof PlantBlock;
        });

        if (canopyClear && stemClear) {
            canopy.fill(new SimpleFiller(world, config.canopyBlock));
            canopyDripping.fill(new RandomSimpleFiller(world, config.canopyBlock, random, 0.5f));
            flesh.fill(new SimpleFiller(world, config.fleshBlock));
            fleshDripping.fill(new RandomSimpleFiller(world, config.fleshBlock, random, 0.5f));
            detailBlocks.fill(new RandomSimpleFiller(world, config.decorationBlock, random, 0.2f));
            stemBlocks.forEach(new SimpleFiller(world, config.stemBlock));
            return true;
        }

        return false;
    }

    private static Position down(Position pos, double d) {
        return Position.of(pos.getX(), pos.getY() - d, pos.getZ());
    }
}
