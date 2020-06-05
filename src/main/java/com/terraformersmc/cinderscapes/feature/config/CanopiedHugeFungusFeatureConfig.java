package com.terraformersmc.cinderscapes.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.FeatureConfig;


/**
 * [REVIEWED]
 *
 * The feature configurator for canopied fungus
 *
 * @author <Wtoll> Will Toll
 * @project Cinderscapes
 */
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
        return instance.group(BlockState.field_24734.fieldOf("soil").forGetter((config) -> {
            return config.soilBlock;
        }), BlockState.field_24734.fieldOf("stem").forGetter((config) -> {
            return config.stemBlock;
        }), BlockState.field_24734.fieldOf("canopy").forGetter((config) -> {
            return config.canopyBlock;
        }), BlockState.field_24734.fieldOf("flesh").forGetter((config) -> {
            return config.fleshBlock;
        }), BlockState.field_24734.fieldOf("decoration").forGetter((config) -> {
            return config.decorationBlock;
        }), Codec.BOOL.fieldOf("planted").forGetter((config) -> {
            return config.planted;
        })).apply(instance, CanopiedHugeFungusFeatureConfig::new);
    });
}
