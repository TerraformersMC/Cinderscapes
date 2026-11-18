package com.terraformersmc.cinderscapes.feature;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import org.jspecify.annotations.NullMarked;

import java.util.List;

@NullMarked
public record VegetationFeature(BlockStateProvider vegetationState, List<BlockState> placeableStates, List<BlockState> replaceableStates, int horizontalSpread, int verticalSpread) implements Feature {
    public static final MapCodec<VegetationFeature> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    BlockStateProvider.DIRECT_CODEC.fieldOf("vegetation_state").forGetter(VegetationFeature::vegetationState),
                    BlockState.CODEC.listOf().fieldOf("placeable_states").forGetter(VegetationFeature::placeableStates),
                    BlockState.CODEC.listOf().fieldOf("replaceable_states").forGetter(VegetationFeature::replaceableStates),
                    ExtraCodecs.POSITIVE_INT.fieldOf("horizontal_spread").forGetter(VegetationFeature::horizontalSpread),
                    ExtraCodecs.POSITIVE_INT.fieldOf("vertical_spread").forGetter(VegetationFeature::verticalSpread)
            ).apply(instance, VegetationFeature::new)
    );

    public VegetationFeature {
        if (horizontalSpread < 1 || verticalSpread < 1) {
            throw new IllegalArgumentException("spread values must be positive integers");
        }
    }

    public static VegetationFeature of(BlockStateProvider vegetationStates, List<BlockState> placeableStates) {
        return of(vegetationStates, placeableStates, List.of());
    }

    public static VegetationFeature of(BlockStateProvider vegetationState, List<BlockState> placeableStates, List<BlockState> replaceableStates) {
        return new VegetationFeature(vegetationState, placeableStates, replaceableStates, 8, 4);
    }

    @Override
    public MapCodec<? extends VegetationFeature> codec() {
        return CODEC;
    }

    @Override
    public boolean place(WorldGenLevel level, ChunkGenerator chunkGenerator, RandomSource random, BlockPos origin) {
        BlockState belowState = level.getBlockState(origin.below());
        BlockState testState = level.getBlockState(origin);

        while(!(placeableStates.contains(belowState) && (level.isEmptyBlock(origin) || replaceableStates.contains(testState)) ) && origin.getY() > 0) {
            origin = origin.below();
            belowState = level.getBlockState(origin.below());
            testState = level.getBlockState(origin);
        }

        int y = origin.getY();
        if (y >= 1 && y + 1 < 256) {
            int setCount = 0;

            for(int n = 0; n < horizontalSpread * horizontalSpread; n++) {
                BlockPos setPos = origin.offset(random.nextInt(horizontalSpread) - random.nextInt(horizontalSpread), random.nextInt(verticalSpread) - random.nextInt(verticalSpread), random.nextInt(horizontalSpread) - random.nextInt(horizontalSpread));
                BlockState setState = vegetationState.getState(level, random, setPos);
                if ((level.isEmptyBlock(setPos) || replaceableStates.contains(level.getBlockState(setPos))) && setPos.getY() > 0 && setState.canSurvive(level, setPos)) {
                    level.setBlock(setPos, setState, 2);
                    setCount++;
                }
            }

            return setCount > 0;
        } else {
            return false;
        }
    }
}
