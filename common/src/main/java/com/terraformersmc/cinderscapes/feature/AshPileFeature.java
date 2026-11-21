package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.block.AshLayerBlock;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.terraform.shapes.api.Position;
import com.terraformersmc.terraform.shapes.api.Shape;
import com.terraformersmc.terraform.shapes.impl.Shapes;
import com.terraformersmc.terraform.shapes.impl.layer.pathfinder.AddLayer;
import com.terraformersmc.terraform.shapes.impl.layer.transform.TranslateLayer;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.List;

public class AshPileFeature extends Feature<DefaultFeatureConfig> {
    private static final BlockState MATERIAL = CinderscapesBlocks.ASH_BLOCK.getDefaultState();
    private static final List<BlockState> SUPPORTS = List.of(Blocks.NETHERRACK.getDefaultState(), Blocks.SOUL_SOIL.getDefaultState(), Blocks.SOUL_SAND.getDefaultState(), Blocks.GRAVEL.getDefaultState());
    private static final List<BlockState> REPLACEABLE = List.of(CinderscapesBlocks.ASH.getDefaultState().with(AshLayerBlock.LAYERS, 1));

    public AshPileFeature() {
        super(DefaultFeatureConfig.CODEC);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        Random random = context.getRandom();
        BlockPos origin = context.getOrigin();
        StructureWorldAccess level = context.getWorld();

        int xRadius = random.nextInt(3) + 3;
        int zRadius = random.nextInt(3) + 3;
        int yRadius = random.nextInt(2) + 2;
        BlockPos.Mutable pos = origin.mutableCopy();

        while (true) {
            if (pos.getY() - 5 < level.getBottomY()) {
                // Cannot generate below build height
                return false;
            }

            if (validateSupport(level, pos)) {
                if (pos.getY() + yRadius > level.getTopYInclusive()) {
                    // Cannot generate above build height
                    return false;
                }

                Position anchor = Position.of(pos);

                // final shape (array to enable reassignment)
                // In the Shapes API for Minecraft 26.x and above, this is available as Shapes.empty()
                Shape[] pile = { Shape.of((point) -> false, Position.of(0, 0, 0), Position.of(0, 0, 0)) };

                // idealized (initial) shape
                Shape ellipsoid = Shapes.ellipsoid(xRadius, zRadius, yRadius);
                ellipsoid
                        .stream().filter(position -> position.getY() == 0)
                        .forEach(column -> {
                            pos.set(anchor.getX() + column.getX(), anchor.getY(), anchor.getZ() + column.getZ());
                            addColumn(level, random, pile, pos, ellipsoid, column);
                        });

                pile[0]
                        .applyLayer(new TranslateLayer(anchor))
                        .fill(position -> {
                                    pos.set(position.getX(), position.getY(), position.getZ());

                            if (validateReplacement(level, pos)) {
                                level.setBlockState(pos, MATERIAL, 4);
                            }
                        });

                // Successful generation
                return true;
            }

            pos.setY(pos.getY() - 1);
        }
    }

    private void addColumn(StructureWorldAccess level, Random random, Shape[] pile, BlockPos.Mutable pos, Shape ellipsoid, Position column) {
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
                    .applyLayer(new AddLayer(Shapes.rectanglarPrism(1, height, 1)
                            .applyLayer(new TranslateLayer(column.move(0, bottom, 0)))));

        }
    }

    private boolean validateReplacement(StructureWorldAccess level, BlockPos pos) {
        return level.isAir(pos) || REPLACEABLE.contains(level.getBlockState(pos));
    }

    private boolean validateSupport(StructureWorldAccess level, BlockPos.Mutable pos) {
        pos.setY(pos.getY() - 1);
        BlockState blockState = level.getBlockState(pos);
        pos.setY(pos.getY() + 1);

        return SUPPORTS.contains(blockState);
    }
}
