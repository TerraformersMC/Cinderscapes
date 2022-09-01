package com.terraformersmc.cinderscapes.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.FeatureConfig;

public record CanopiedHugeFungusFeatureConfig(BlockState soilBlock, BlockState hyphaeBlock, BlockState stemBlock, BlockState canopyBlock, BlockState fleshBlock, BlockState decorationBlock, boolean planted) implements FeatureConfig {
    public static final Codec<CanopiedHugeFungusFeatureConfig> CODEC = RecordCodecBuilder.create(
            (instance) -> instance.group(
                    BlockState.CODEC.fieldOf("soil").forGetter((config) -> config.soilBlock),
                    BlockState.CODEC.fieldOf("hyphae").forGetter((config) -> config.hyphaeBlock),
                    BlockState.CODEC.fieldOf("stem").forGetter((config) -> config.stemBlock),
                    BlockState.CODEC.fieldOf("canopy").forGetter((config) -> config.canopyBlock),
                    BlockState.CODEC.fieldOf("flesh").forGetter((config) -> config.fleshBlock),
                    BlockState.CODEC.fieldOf("decoration").forGetter((config) -> config.decorationBlock),
                    Codec.BOOL.fieldOf("planted").forGetter((config) -> config.planted)
            ).apply(instance, CanopiedHugeFungusFeatureConfig::new));

    public CanopiedHugeFungusFeatureConfig withPlanted(boolean planted) {
        return new CanopiedHugeFungusFeatureConfig(this.soilBlock, this.hyphaeBlock, this.stemBlock, this.canopyBlock, this.fleshBlock, this.decorationBlock, planted);
    }
}
