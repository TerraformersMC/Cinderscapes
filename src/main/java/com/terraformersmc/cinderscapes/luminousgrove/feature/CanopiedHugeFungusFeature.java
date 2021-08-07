package com.terraformersmc.cinderscapes.luminousgrove.feature;

import com.terraformersmc.cinderscapes.luminousgrove.feature.config.CanopiedHugeFungusFeatureConfig;
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
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

        // If the feature is being generated from a fungus block
        if (config.planted) {
            // If the block the fungus is placed on isn't a soil block
            if (world.getBlockState(pos.down()) != config.soilBlock) {
                return false;
            }

            // Check the 3x3 area under the stem
            boolean solidGround = Shape.of((ipos) -> true, Position.of(-1, -1, -1), Position.of(1, -1, 1))
                    .applyLayer(TranslateLayer.of(Position.of(pos)))
                    .stream().map(Position::toBlockPos).allMatch((ipos) -> world.getBlockState(ipos).isSolidBlock(world, ipos));

            // If they are not all solid blocks
            if (!solidGround) {
                return false;
            }
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

        // Construct a shape from the list of positions
        Shape stem = Shape.of(stemBlocks::contains, Position.of(-1, 0, -1), Position.of(1, stemHeight, 1))
                // Translate it to the area
                .applyLayer(new TranslateLayer(Position.of(pos)));

        // Generate a random canopy radius and height
        int canopyRadius = random.nextInt(3) + 5;
        int canopyHeight = random.nextInt(5) + 4;

        // Create a value for where the center of the canopy should be
        Position canopyPos = Position.of(pos.up(stemHeight - canopyHeight + 2));

        Shape canopy = Shapes.hemiEllipsoid(canopyRadius, canopyHeight, canopyRadius)
                .applyLayer(new SubtractLayer(Shapes.hemiEllipsoid(canopyRadius - 1, canopyHeight - 1, canopyRadius - 1)))
                .applyLayer(new AddLayer(Shapes.ellipse(canopyRadius, canopyRadius)
                        .applyLayer(new SubtractLayer(Shapes.ellipse(canopyRadius - 1, canopyRadius - 1)))
                        .applyLayer(new TranslateLayer(Position.of(0, -1, 0)))))
                .applyLayer(new TranslateLayer(canopyPos));
        Shape flesh = Shapes.hemiEllipsoid(canopyRadius - 1, canopyHeight - 1, canopyRadius - 1)
                .applyLayer(new SubtractLayer(Shapes.hemiEllipsoid(canopyRadius - 2, canopyHeight - 2, canopyRadius - 2)))
                .applyLayer(new TranslateLayer(canopyPos));
        Shape detailBlocks = Shapes.hemiEllipsoid(canopyRadius - 2, canopyHeight - 2, canopyRadius - 2)
                .applyLayer(new SubtractLayer(Shapes.hemiEllipsoid(canopyRadius - 3, canopyHeight - 3, canopyRadius - 3)))
                .applyLayer(new TranslateLayer(canopyPos));
        Shape fleshDripping = Shapes.ellipse(canopyRadius - 1, canopyRadius - 1)
                .applyLayer(new SubtractLayer(Shapes.ellipse(canopyRadius - 2, canopyRadius - 2)))
                .applyLayer(new TranslateLayer(canopyPos.down()));
        Shape canopyDripping = Shapes.ellipse(canopyRadius, canopyRadius)
                .applyLayer(new SubtractLayer(Shapes.ellipse(canopyRadius - 1, canopyRadius - 1)))
                .applyLayer(new TranslateLayer(canopyPos.down(2)));

        boolean canopyClear = List.of(canopy, flesh, detailBlocks, fleshDripping, canopyDripping).stream().allMatch((shape) -> AirValidator.of((TestableWorld) world).validate(shape));
        boolean stemClear = SafelistValidator.of(world, config.soilBlock, Blocks.AIR.getDefaultState(), Blocks.NETHERRACK.getDefaultState()).validate(stem);

        if (canopyClear && stemClear) {
            canopy.fill(new SimpleFiller(world, config.canopyBlock));
            canopyDripping.fill(new RandomSimpleFiller(world, config.canopyBlock, random, 0.5f));
            flesh.fill(new SimpleFiller(world, config.fleshBlock));
            fleshDripping.fill(new RandomSimpleFiller(world, config.fleshBlock, random, 0.5f));
            detailBlocks.fill(new RandomSimpleFiller(world, config.decorationBlock, random, 0.2f));
            stem.fill(new SimpleFiller(world, config.stemBlock));
            return true;
        }

        return false;
    }
}
