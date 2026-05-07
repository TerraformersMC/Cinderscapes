package com.terraformersmc.cinderscapes.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.List;

public record VegetationFeatureConfig(BlockStateProvider vegetationStates, List<BlockState> placeableStates, List<BlockState> replaceableStates) implements FeatureConfiguration {
    public static final Codec<VegetationFeatureConfig> CODEC = RecordCodecBuilder.create(
            (instance) -> instance.group(
                    BlockStateProvider.CODEC.fieldOf("vegetation_state").forGetter((config) -> config.vegetationStates),
                    BlockState.CODEC.listOf().fieldOf("placeable_states").forGetter((config) -> config.placeableStates),
                    BlockState.CODEC.listOf().fieldOf("replaceable_states").forGetter((config) -> config.replaceableStates)
            ).apply(instance, VegetationFeatureConfig::new));

    public VegetationFeatureConfig(BlockStateProvider vegetationStates, List<BlockState> placeableStates) {
        this(vegetationStates, placeableStates, List.of());
    }
}
