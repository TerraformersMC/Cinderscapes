package com.terraformersmc.cinderscapes.biomes.blackstoneshales.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.FeatureConfig;

public class ShaleFeatureConfig implements FeatureConfig {

    public final BlockState state;
    public final int max;
    public final int min;

    public ShaleFeatureConfig(BlockState state, int min, int max) {
        this.state = state;
        this.max = max;
        this.min = min;
    }

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
