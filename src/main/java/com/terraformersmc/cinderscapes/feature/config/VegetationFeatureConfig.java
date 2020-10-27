package com.terraformersmc.cinderscapes.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.Arrays;
import java.util.List;

public class VegetationFeatureConfig implements FeatureConfig {

    public final BlockStateProvider vegetationStates;
    public final List<BlockState> placeableStates;
    public final List<BlockState> replaceableStates;

    public VegetationFeatureConfig(BlockStateProvider vegetationStates, List<BlockState> placeableStates) {
        this(vegetationStates, placeableStates, Arrays.asList());
    }

    public VegetationFeatureConfig(BlockStateProvider vegetationStates, List<BlockState> placeableStates, List<BlockState> replaceableStates) {
        this.vegetationStates = vegetationStates;
        this.placeableStates = placeableStates;
        this.replaceableStates = replaceableStates;
    }

    public static final Codec<VegetationFeatureConfig> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(BlockStateProvider.TYPE_CODEC.fieldOf("vegetation_state").forGetter((config) -> {
            return config.vegetationStates;
        }), BlockState.CODEC.listOf().fieldOf("placeable_states").forGetter((config) -> {
            return config.placeableStates;
        }), BlockState.CODEC.listOf().fieldOf("replaceable_states").forGetter((config) -> {
            return config.replaceableStates;
        })).apply(instance, VegetationFeatureConfig::new);
    });
}
