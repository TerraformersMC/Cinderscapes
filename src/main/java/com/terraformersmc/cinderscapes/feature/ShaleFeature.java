package com.terraformersmc.cinderscapes.feature;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.terraformersmc.terraform.shapes.api.Position;
import com.terraformersmc.terraform.shapes.api.Quaternion;
import com.terraformersmc.terraform.shapes.api.Shapes;
import com.terraformersmc.terraform.shapes.api.filler.Filler;
import com.terraformersmc.terraform.shapes.api.layer.Layer;
import net.minecraft.core.BlockPos;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import org.jspecify.annotations.NullMarked;

@NullMarked
public record ShaleFeature(BlockState state, int min, int max) implements Feature {
    public static final MapCodec<ShaleFeature> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    BlockState.CODEC.fieldOf("state").forGetter(ShaleFeature::state),
                    ExtraCodecs.POSITIVE_INT.fieldOf("min").forGetter(ShaleFeature::min),
                    ExtraCodecs.POSITIVE_INT.fieldOf("max").forGetter(ShaleFeature::max)
            ).apply(instance, ShaleFeature::new)
    );

    public ShaleFeature {
        if (min < 1) {
            throw new IllegalArgumentException("min must be greater than zero");
        }
        if (max < min) {
            throw new IllegalArgumentException("max must be greater than or equal to min");
        }
    }

    @Override
    public MapCodec<ShaleFeature> codec() {
        return CODEC;
    }

    @Override
    public boolean place(WorldGenLevel level, ChunkGenerator chunkGenerator, RandomSource random, BlockPos origin) {
        if (level.isEmptyBlock(origin) || !level.getBlockState(origin.above()).isAir() || level.getBlockState(origin).is(Blocks.BLACKSTONE)) {
            return false;
        }

        float radius = random.nextInt(max - min) + min;
        if (level.getBlockState(origin).is(Blocks.LAVA)) {
            radius = radius * 1.5f;
        }
        float ztheta = (random.nextFloat() * 30) - 15;
        float ytheta = random.nextFloat() * 360;

        Shapes.ellipsoid(2, radius / 1.5, radius)
                .applyLayer(Layer.rotate(Quaternion.of(0, ytheta, ztheta, true)))
                .applyLayer(Layer.translate(Position.of(origin)))
                .fill(Filler.simple(level, state));

        return true;
    }
}
