package com.terraformersmc.cinderscapes.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.FeatureConfig;

public class CanopiedHugeFungusFeatureConfig implements FeatureConfig {

    public final BlockState soilBlock;
    public final BlockState stemBlock;
    public final BlockState canopyBlock;
    public final BlockState fleshBlock;
    public final BlockState decorationBlock;
    public final boolean planted;

    public CanopiedHugeFungusFeatureConfig(BlockState soilBlock, BlockState stemBlock, BlockState canopyBlock, BlockState fleshBlock, BlockState decorationBlock, boolean planted) {
        this.soilBlock = soilBlock;
        this.stemBlock = stemBlock;
        this.canopyBlock = canopyBlock;
        this.fleshBlock = fleshBlock;
        this.decorationBlock = decorationBlock;
        this.planted = planted;
    }

    public static final Codec<CanopiedHugeFungusFeatureConfig> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(BlockState.CODEC.fieldOf("soil").forGetter((config) -> {
            return config.soilBlock;
        }), BlockState.CODEC.fieldOf("stem").forGetter((config) -> {
            return config.stemBlock;
        }), BlockState.CODEC.fieldOf("canopy").forGetter((config) -> {
            return config.canopyBlock;
        }), BlockState.CODEC.fieldOf("flesh").forGetter((config) -> {
            return config.fleshBlock;
        }), BlockState.CODEC.fieldOf("decoration").forGetter((config) -> {
            return config.decorationBlock;
        }), Codec.BOOL.fieldOf("planted").forGetter((config) -> {
            return config.planted;
        })).apply(instance, CanopiedHugeFungusFeatureConfig::new);
    });
}
