package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.block.AshLayerBlock;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.terraform.shapes.api.Position;
import com.terraformersmc.terraform.shapes.api.Shape;
import com.terraformersmc.terraform.shapes.api.Shapes;
import com.terraformersmc.terraform.shapes.api.layer.Layer;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import org.jspecify.annotations.NullMarked;

import java.util.List;

@NullMarked
public class AshPileFeature extends Feature<NoneFeatureConfiguration> {
    private static final BlockState MATERIAL = CinderscapesBlocks.ASH_BLOCK.defaultBlockState();
    private static final List<BlockState> SUPPORTS = List.of(Blocks.NETHERRACK.defaultBlockState(), Blocks.SOUL_SOIL.defaultBlockState(), Blocks.SOUL_SAND.defaultBlockState(), Blocks.GRAVEL.defaultBlockState());
    private static final List<BlockState> REPLACEABLE = List.of(CinderscapesBlocks.ASH.defaultBlockState().setValue(AshLayerBlock.LAYERS, 1));

    public AshPileFeature() {
        super(NoneFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        RandomSource random = context.random();
        BlockPos origin = context.origin();
        WorldGenLevel level = context.level();

        int xRadius = random.nextInt(3) + 3;
        int zRadius = random.nextInt(3) + 3;
        int yRadius = random.nextInt(2) + 2;
        BlockPos.MutableBlockPos pos = origin.mutable();

        while (true) {
            if (pos.getY() - 5 < level.getMinY()) {
                // Cannot generate below build height
                return false;
            }

            if (validateSupport(level, pos)) {
                if (pos.getY() + yRadius > level.getMaxY()) {
                    // Cannot generate above build height
                    return false;
                }

                Position anchor = Position.of(pos);

                // final shape (array to enable reassignment)
                Shape[] pile = { Shapes.empty() };

                // idealized (initial) shape
                Shape ellipsoid = Shapes.ellipsoid(xRadius, zRadius, yRadius);
                ellipsoid
                        .stream().filter(position -> position.getY() == 0)
                        .forEach(column -> {
                            pos.set(anchor.getX() + column.getX(), anchor.getY(), anchor.getZ() + column.getZ());
                            addColumn(level, random, pile, pos, ellipsoid, column);
                        });

                pile[0]
                        .applyLayer(Layer.translate(anchor))
                        .fill(position -> {
                            pos.set(position.getX(), position.getY(), position.getZ());

                            if (validateReplacement(level, pos)) {
                                level.setBlock(pos, MATERIAL, Block.UPDATE_INVISIBLE);
                            }
                        });

                // Successful generation
                return true;
            }

            pos.setY(pos.getY() - 1);
        }
    }

    private void addColumn(WorldGenLevel level, RandomSource random, Shape[] pile, BlockPos.MutableBlockPos pos, Shape ellipsoid, Position column) {
        int height = 0;
        int bottom = 4;

        // find column height
        //noinspection StatementWithEmptyBody
        while (ellipsoid.equation().test(column.move(0, ++height, 0)));

        // find column bottom displacement
        pos.setY(pos.getY() + bottom);
        while (bottom >= -4 && !validateSupport(level, pos)) {
            pos.setY(pos.getY() - 1);
            if (!validateReplacement(level, pos)) {
                // This is an attempt to place the column on something that shouldn't be directly under it
                return;
            }
            --bottom;
        }

        // displacement of -5 or lower disqualifies column placement
        if (bottom >= -4) {
            // fuzz the top a bit
            if (height > 0 && random.nextBoolean()) {
                --height;
            }

            pile[0] = pile[0]
                    .applyLayer(Layer.add(Shapes.rectangularPrism(1, height, 1)
                            .applyLayer(Layer.translate(column.move(0, bottom, 0)))));

        }
    }

    private boolean validateReplacement(WorldGenLevel level, BlockPos pos) {
        return level.isEmptyBlock(pos) || REPLACEABLE.contains(level.getBlockState(pos));
    }

    private boolean validateSupport(WorldGenLevel level, BlockPos.MutableBlockPos pos) {
        pos.setY(pos.getY() - 1);
        BlockState blockState = level.getBlockState(pos);
        pos.setY(pos.getY() + 1);

        return SUPPORTS.contains(blockState);
    }
}
