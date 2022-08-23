package com.terraformersmc.cinderscapes.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.feature.FeatureConfig;

import java.util.List;

public record CrystalShardFeatureConfig(BlockState state, Direction dir, List<BlockState> whitelist) implements FeatureConfig {

    public static final Codec<CrystalShardFeatureConfig> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(BlockState.CODEC.fieldOf("state").forGetter((config) -> {
            return config.state;
        }), Direction.CODEC.fieldOf("direction").forGetter((config) -> {
            return config.dir;
        }), BlockState.CODEC.listOf().fieldOf("whitelist").forGetter((config) -> {
            return config.whitelist;
        })).apply(instance, CrystalShardFeatureConfig::new);
    });
}
