package com.terraformersmc.cinderscapes.biomes.quartzcavern.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.feature.FeatureConfig;

public class CrystalShardFeatureConfig implements FeatureConfig {

    public final BlockState state;
    public final Direction dir;

    public CrystalShardFeatureConfig(BlockState state, Direction dir) {
        this.state = state;
        this.dir = dir;
    }

    public static final Codec<CrystalShardFeatureConfig> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(BlockState.CODEC.fieldOf("state").forGetter((config) -> {
            return config.state;
        }), Direction.CODEC.fieldOf("direction").forGetter((config) -> {
            return config.dir;
        })).apply(instance, CrystalShardFeatureConfig::new);
    });
}
