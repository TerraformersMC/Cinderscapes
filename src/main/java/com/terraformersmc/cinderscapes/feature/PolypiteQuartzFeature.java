package com.terraformersmc.cinderscapes.feature;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.terraformersmc.cinderscapes.block.PolypiteQuartzBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import org.jspecify.annotations.NullMarked;

import java.util.ArrayList;
import java.util.List;

@NullMarked
public record PolypiteQuartzFeature(BlockState quartzMaterial) implements Feature {
    public static final MapCodec<PolypiteQuartzFeature> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    BlockState.CODEC.fieldOf("soil_block").forGetter(PolypiteQuartzFeature::quartzMaterial)
            ).apply(instance, PolypiteQuartzFeature::new)
    );

    public PolypiteQuartzFeature {
        if (!(quartzMaterial.hasProperty(PolypiteQuartzBlock.DIRECTION))) {
            throw new IllegalArgumentException("Provided quartzMaterial must have 'direction' property!");
        }
    }

    @Override
    public MapCodec<PolypiteQuartzFeature> codec() {
        return CODEC;
    }

    @Override
    public boolean place(WorldGenLevel level, ChunkGenerator chunkGenerator, RandomSource random, BlockPos origin) {
        if (level.isEmptyBlock(origin)) {
            List<Direction> valid_faces = new ArrayList<>();
            for (Direction dir : Direction.values()) {
                BlockPos placeOnPos = origin.relative(dir);
                BlockState placeOnState = level.getBlockState(placeOnPos);
                if (placeOnState.is(Blocks.NETHERRACK)) {
                    valid_faces.add(dir);
                }
            }
            if (!valid_faces.isEmpty()) {
                Direction setDir = valid_faces.get(random.nextInt(valid_faces.size()));
                level.setBlock(origin, quartzMaterial.setValue(PolypiteQuartzBlock.DIRECTION, setDir), 0);

                return true;
            }
        }

        return false;
    }
}
