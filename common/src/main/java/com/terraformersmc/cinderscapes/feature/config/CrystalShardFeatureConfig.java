package com.terraformersmc.cinderscapes.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

import java.util.List;

public record CrystalShardFeatureConfig(BlockState state, Direction dir, List<BlockState> whitelist) implements FeatureConfiguration {
    public static final Codec<CrystalShardFeatureConfig> CODEC = RecordCodecBuilder.create(
            (instance) -> instance.group(
                    BlockState.CODEC.fieldOf("state").forGetter((config) -> config.state),
                    Direction.CODEC.fieldOf("direction").forGetter((config) -> config.dir),
                    BlockState.CODEC.listOf().fieldOf("whitelist").forGetter((config) -> config.whitelist)
            ).apply(instance, CrystalShardFeatureConfig::new));
}
