package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.feature.config.CanopiedHugeFungusFeatureConfig;
import com.terraformersmc.terraform.shapes.api.Position;
import com.terraformersmc.terraform.shapes.api.Shape;
import com.terraformersmc.terraform.shapes.api.Shapes;
import com.terraformersmc.terraform.shapes.api.filler.Filler;
import com.terraformersmc.terraform.shapes.api.layer.Layer;
import com.terraformersmc.terraform.shapes.api.validator.Validator;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.NetherFungusBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import org.jspecify.annotations.NullMarked;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@NullMarked
public class CanopiedHugeFungusFeature extends Feature<CanopiedHugeFungusFeatureConfig> {
    public CanopiedHugeFungusFeature() {
        super(CanopiedHugeFungusFeatureConfig.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<CanopiedHugeFungusFeatureConfig> context) {
        CanopiedHugeFungusFeatureConfig config = context.config();
        WorldGenLevel level = context.level();
        BlockPos pos = context.origin();
        RandomSource random = context.random();

        final List<BlockState> baseSafeList = new ArrayList<>(List.of(config.soilBlock(), Blocks.AIR.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState()));

        // If the feature is being generated from a fungus block
        if (config.planted()) {
            // If the block the fungus is placed on isn't a soil block
            if (level.getBlockState(pos.below()) != config.soilBlock()) {
                return false;
            }

            // Check the 3x3 area under the stem
            boolean solidGround = Shape.of((ipos) -> true, Position.of(2, 0, 2), Position.of(-1, -1, -1))
                    .applyLayer(Layer.translate(Position.of(pos)))
                    .stream().map(Position::toBlockPos).allMatch((ipos) -> !level.isEmptyBlock(ipos) && Block.isFaceFull(level.getBlockState(ipos).getCollisionShape(level, pos.below()), Direction.UP));

            // If they are not all solid blocks
            if (!solidGround) {
                return false;
            }

            // We have to tolerate a fungus block (sapling) at ground zero if we were planted.
            BlockState groundZero = level.getBlockState(pos);
            if (groundZero.getBlock() instanceof NetherFungusBlock) {
                baseSafeList.add(groundZero);
            }
        }

        // Generate the actual fungus

        // Generate a random stem height
        int stemHeight = random.nextInt(20) + 6;

        Shape stem = Shapes.ellipticalPrism(1.4D, 1.4D, 0.8D * stemHeight)
                .applyLayer(Layer.translate(Position.of(0, 0.6D * (stemHeight - 1), 0)))
                .applyLayer(Layer.translate(Position.of(pos)));

        Shape base = Shapes.rectangularPrism(3, 0.2D * stemHeight, 3)
                .applyLayer(Layer.translate(Position.of(0, 0.1D * (stemHeight - 1), 0)))
                .applyLayer(Layer.translate(Position.of(pos)));

        // Generate a random canopy radius and height
        int canopyRadius = random.nextInt(3) + 6;
        int canopyHeight = random.nextInt(5) + 5;

        // Create a value for where the center of the canopy should be
        Position canopyPos = Position.of(pos.above(stemHeight - canopyHeight + 2));

        Shape canopy = Shapes.hemiEllipsoid(canopyRadius, canopyRadius, canopyHeight)
                .applyLayer(Layer.subtract(Shapes.hemiEllipsoid(canopyRadius - 1, canopyRadius - 1, canopyHeight - 1)))
                .applyLayer(Layer.add(Shapes.ellipticalPrism(canopyRadius, canopyRadius, 1)
                .applyLayer(Layer.subtract(Shapes.ellipticalPrism(canopyRadius - 1, canopyRadius - 1, 1)))))
                .applyLayer(Layer.translate(canopyPos));
        Shape flesh = Shapes.hemiEllipsoid(canopyRadius - 1, canopyRadius - 1, canopyHeight - 1)
                .applyLayer(Layer.subtract(Shapes.hemiEllipsoid(canopyRadius - 2, canopyRadius - 2, canopyHeight - 2)))
                .applyLayer(Layer.translate(canopyPos));
        Shape detailBlocks = Shapes.hemiEllipsoid(canopyRadius - 2, canopyRadius - 2, canopyHeight - 2)
                .applyLayer(Layer.subtract(Shapes.hemiEllipsoid(canopyRadius - 3, canopyRadius - 3, canopyHeight - 3)))
                .applyLayer(Layer.translate(canopyPos));
        Shape fleshDripping = Shapes.ellipticalPrism(canopyRadius - 1, canopyRadius - 1, 1)
                .applyLayer(Layer.subtract(Shapes.ellipticalPrism(canopyRadius - 2, canopyRadius - 2, 1)))
                .applyLayer(Layer.translate(canopyPos));
        Shape canopyDripping = Shapes.ellipticalPrism(canopyRadius, canopyRadius, 1)
                .applyLayer(Layer.subtract(Shapes.ellipticalPrism(canopyRadius - 1, canopyRadius - 1, 1)))
                .applyLayer(Layer.translate(Position.of(canopyPos.toBlockPos().below())));

        // The stem and canopy must be placed in open air, but the base can replace some ground blocks
        boolean baseClear = Validator.safelist(level, baseSafeList).validate(base);
        boolean stemClear = Validator.air((LevelSimulatedReader) level).validate(stem);
        boolean canopyClear = Stream.of(canopy, flesh, detailBlocks, fleshDripping, canopyDripping).allMatch((shape) -> Validator.air((LevelSimulatedReader) level).validate(shape));

        if (baseClear && stemClear && canopyClear) {
            // canopy
            canopy.fill(Filler.simple(level, config.canopyBlock()));
            canopyDripping.fill(Filler.randomSimple(level, config.canopyBlock(), random, 0.5f));
            flesh.fill(Filler.simple(level, config.fleshBlock()));
            fleshDripping.fill(Filler.randomSimple(level, config.fleshBlock(), random, 0.5f));
            detailBlocks.fill(Filler.randomSimple(level, config.decorationBlock(), random, 0.2f));

            // stem
            stem.fill(Filler.simple(level, config.stemBlock()));
            base.fill(Filler.simple(level, config.hyphaeBlock()));

            // level platform for generated fungus
            if (!config.planted()) {
                makePlatform(level, config, pos);
            }

            return true;
        }

        return false;
    }

    private void makePlatform(WorldGenLevel level, CanopiedHugeFungusFeatureConfig config, BlockPos origin) {
        // Iterate through the region beneath the base of the fungus; for some reason, rectangle() does not work
        for (BlockPos pos : Shapes.rectangularPrism(3, 1, 3).applyLayer(Layer.translate(Position.of(origin))).stream().map(Position::toBlockPos).toList()) {
            // Look down several blocks for solid ground and build it up with Netherrack to our level if we find it
            for (int i = 1; i < 5; ++i) {
                if (level.getBlockState(pos.below(i)).isRedstoneConductor(level, pos.below(i))) {
                    for (; i > 1; --i) {
                        level.setBlock(pos.below(i), Blocks.NETHERRACK.defaultBlockState(), 3);
                    }
                    break;
                }
            }
            // Shrooms grow on Nylium ... under Shrooms shall ye find Nylium
            level.setBlock(pos.below(), config.soilBlock(), 3);
        }
    }
}
