package com.terraformersmc.cinderscapes.feature;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.terraformersmc.terraform.shapes.api.Position;
import com.terraformersmc.terraform.shapes.api.Shape;
import com.terraformersmc.terraform.shapes.api.Shapes;
import com.terraformersmc.terraform.shapes.api.layer.Layer;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import org.jspecify.annotations.NullMarked;

import java.util.List;

@NullMarked
public record AshPileFeature(BlockState material, List<BlockState> supports, List<BlockState> replaceable) implements Feature {
    public static final MapCodec<AshPileFeature> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    BlockState.CODEC.fieldOf("material").forGetter(AshPileFeature::material),
                    BlockState.CODEC.listOf().fieldOf("supports").forGetter(AshPileFeature::supports),
                    BlockState.CODEC.listOf().fieldOf("replaceable").forGetter(AshPileFeature::replaceable)
            ).apply(instance, AshPileFeature::new)
    );

    @Override
    public MapCodec<AshPileFeature> codec() {
        return CODEC;
    }

    @Override
    public boolean place(WorldGenLevel level, ChunkGenerator chunkGenerator, RandomSource random, BlockPos origin) {
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
                                level.setBlock(pos, material, Block.UPDATE_INVISIBLE);
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
        return level.isEmptyBlock(pos) || replaceable.contains(level.getBlockState(pos));
    }

    private boolean validateSupport(WorldGenLevel level, BlockPos.MutableBlockPos pos) {
        pos.setY(pos.getY() - 1);
        BlockState blockState = level.getBlockState(pos);
        pos.setY(pos.getY() + 1);

        return supports.contains(blockState);
    }
}
