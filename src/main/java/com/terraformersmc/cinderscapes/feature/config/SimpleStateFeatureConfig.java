package com.terraformersmc.cinderscapes.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.FeatureConfig;

import java.util.List;

public class SimpleStateFeatureConfig implements FeatureConfig {

    public final BlockState state;
    public final List<BlockState> replaceableBlocks;

    public SimpleStateFeatureConfig(BlockState state, List<BlockState> replaceableBlocks) {
        this.state = state;
        this.replaceableBlocks = replaceableBlocks;
    }

    public static final Codec<SimpleStateFeatureConfig> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(BlockState.CODEC.fieldOf("state").forGetter((config) -> {
            return config.state;
        }), BlockState.CODEC.listOf().fieldOf("replaceable").forGetter((config) -> {
            return config.replaceableBlocks;
        })).apply(instance, SimpleStateFeatureConfig::new);
    });
}
