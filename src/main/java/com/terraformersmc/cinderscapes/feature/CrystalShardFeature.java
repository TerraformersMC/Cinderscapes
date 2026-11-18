package com.terraformersmc.cinderscapes.feature;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.terraformersmc.cinderscapes.util.RegionalSafelistValidator;
import com.terraformersmc.terraform.shapes.api.Position;
import com.terraformersmc.terraform.shapes.api.Quaternion;
import com.terraformersmc.terraform.shapes.api.Shape;
import com.terraformersmc.terraform.shapes.api.Shapes;
import com.terraformersmc.terraform.shapes.api.filler.Filler;
import com.terraformersmc.terraform.shapes.api.layer.Layer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import org.jspecify.annotations.NullMarked;

import java.util.List;

@NullMarked
public record CrystalShardFeature(BlockState state, Direction direction, List<BlockState> whitelist) implements Feature {
    public static final MapCodec<CrystalShardFeature> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    BlockState.CODEC.fieldOf("state").forGetter(CrystalShardFeature::state),
                    Direction.CODEC.fieldOf("direction").forGetter(CrystalShardFeature::direction),
                    BlockState.CODEC.listOf().fieldOf("whitelist").forGetter(CrystalShardFeature::whitelist)
            ).apply(instance, CrystalShardFeature::new)
    );

    @Override
    public MapCodec<CrystalShardFeature> codec() {
        return CODEC;
    }

    @Override
    public boolean place(WorldGenLevel level, ChunkGenerator chunkGenerator, RandomSource random, BlockPos origin) {
        int amount = random.nextInt(3) + 2;

        Shape shape = Shapes.empty();
        for (int i = 0; i < amount; i++) {
            int height = random.nextInt(8) + 14;
            float radius = random.nextFloat() * 2 + 2;
            float ztheta = (random.nextFloat() * 30) + 15;
            float ytheta = random.nextFloat() * 360;

            shape = shape.applyLayer(Layer.add(Shapes
                    .ellipticalPyramid(radius, radius, height)
                    .applyLayer(Layer.rotate(Quaternion.of(0, ytheta, ztheta, true)))
            ));
        }

        shape
                .applyLayer(Layer.rotate(Quaternion.of(direction.getRotation())))
                .applyLayer(Layer.translate(Position.of(origin)))
                .validate(
                        new RegionalSafelistValidator(level, direction, whitelist),
                        validShape -> validShape.fill(Filler.simple(level, state))
                );

        return true;
    }
}
