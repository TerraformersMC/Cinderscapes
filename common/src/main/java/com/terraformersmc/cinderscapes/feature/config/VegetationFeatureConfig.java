package com.terraformersmc.cinderscapes.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public record VegetationFeatureConfig(BlockStateProvider vegetationStates, List<BlockState> placeableStates, List<BlockState> replaceableStates) implements FeatureConfig {
    public static final Codec<VegetationFeatureConfig> CODEC = RecordCodecBuilder.create(
            (instance) -> instance.group(
                    BlockStateProvider.TYPE_CODEC.fieldOf("vegetation_state").forGetter((config) -> config.vegetationStates),
                    BlockState.CODEC.listOf().fieldOf("placeable_states").forGetter((config) -> config.placeableStates),
                    BlockState.CODEC.listOf().fieldOf("replaceable_states").forGetter((config) -> config.replaceableStates)
            ).apply(instance, VegetationFeatureConfig::new));

    public VegetationFeatureConfig(BlockStateProvider vegetationStates, List<BlockState> placeableStates) {
        this(vegetationStates, placeableStates, List.of());
    }
}
