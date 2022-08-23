package com.terraformersmc.cinderscapes.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.FeatureConfig;

public record ShaleFeatureConfig(BlockState state, int min, int max) implements FeatureConfig {

    public static final Codec<ShaleFeatureConfig> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(BlockState.CODEC.fieldOf("state").forGetter((config) -> {
            return config.state;
        }), Codec.INT.fieldOf("min").forGetter((config) -> {
            return config.min;
        }), Codec.INT.fieldOf("max").forGetter((config) -> {
            return config.max;
        })).apply(instance, ShaleFeatureConfig::new);
    });
}
