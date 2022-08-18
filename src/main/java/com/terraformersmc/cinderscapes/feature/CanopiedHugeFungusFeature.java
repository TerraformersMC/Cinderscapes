package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.feature.config.CanopiedHugeFungusFeatureConfig;
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
import java.util.stream.Stream;

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

        final List<BlockState> baseSafeList = new ArrayList<>(List.of(config.soilBlock(), Blocks.AIR.getDefaultState(), Blocks.NETHERRACK.getDefaultState()));

        // If the feature is being generated from a fungus block
        if (config.planted()) {
            // If the block the fungus is placed on isn't a soil block
            if (world.getBlockState(pos.down()) != config.soilBlock()) {
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

            // We have to tolerate a fungus block (sapling) at ground zero if we were planted.
            BlockState groundZero = world.getBlockState(pos);
            if (groundZero.getBlock() instanceof FungusBlock) {
                baseSafeList.add(groundZero);
            }
        }

        // Generate the actual fungus

        // Generate a random stem height
        int stemHeight = random.nextInt(20) + 6;

        Shape stem = Shapes.ellipticalPrism(1.4D, 1.4D, 0.8D * stemHeight)
                .applyLayer(new TranslateLayer(Position.of(0, 0.6D * (stemHeight - 1), 0)))
                .applyLayer(new TranslateLayer(Position.of(pos)));

        Shape base = Shapes.rectanglarPrism(3, 0.2D * stemHeight, 3)
                .applyLayer(new TranslateLayer(Position.of(0, 0.1D * (stemHeight - 1), 0)))
                .applyLayer(new TranslateLayer(Position.of(pos)));

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
                .applyLayer(new TranslateLayer(Position.of(canopyPos.toBlockPos().down())));

        // The stem and canopy must be placed in open air, but the base can replace some ground blocks
        boolean baseClear = SafelistValidator.of(world, baseSafeList).validate(base);
        boolean stemClear = AirValidator.of((TestableWorld) world).validate(stem);
        boolean canopyClear = Stream.of(canopy, flesh, detailBlocks, fleshDripping, canopyDripping).allMatch((shape) -> AirValidator.of((TestableWorld) world).validate(shape));

        if (baseClear && stemClear && canopyClear) {
            // canopy
            canopy.fill(new SimpleFiller(world, config.canopyBlock()));
            canopyDripping.fill(new RandomSimpleFiller(world, config.canopyBlock(), random, 0.5f));
            flesh.fill(new SimpleFiller(world, config.fleshBlock()));
            fleshDripping.fill(new RandomSimpleFiller(world, config.fleshBlock(), random, 0.5f));
            detailBlocks.fill(new RandomSimpleFiller(world, config.decorationBlock(), random, 0.2f));

            // stem
            stem.fill(new SimpleFiller(world, config.stemBlock()));
            base.fill(new SimpleFiller(world, config.hyphaeBlock()));

            // level platform for generated fungus
            if (!config.planted()) {
                makePlatform(world, config, pos);
            }

            return true;
        }

        return false;
    }

    private void makePlatform(StructureWorldAccess world, CanopiedHugeFungusFeatureConfig config, BlockPos origin) {
        // Iterate through the region beneath the base of the fungus; for some reason, rectangle() does not work
        for (BlockPos pos : Shapes.rectanglarPrism(3, 1, 3).applyLayer(new TranslateLayer(Position.of(origin))).stream().map(Position::toBlockPos).toList()) {
            // Look down several blocks for solid ground and build it up with Netherrack to our level if we find it
            for (int i = 1; i < 5; ++i) {
                if (world.getBlockState(pos.down(i)).isSolidBlock(world, pos.down(i))) {
                    for (; i > 1; --i) {
                        world.setBlockState(pos.down(i), Blocks.NETHERRACK.getDefaultState(), 3);
                    }
                    break;
                }
            }
            // Shrooms grow on Nylium ... under Shrooms shall ye find Nylium
            world.setBlockState(pos.down(), config.soilBlock(), 3);
        }
    }
}
