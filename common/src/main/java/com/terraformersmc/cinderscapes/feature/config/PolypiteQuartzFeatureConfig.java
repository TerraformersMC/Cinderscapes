package com.terraformersmc.cinderscapes.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.terraformersmc.cinderscapes.block.PolypiteQuartzBlock;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.FeatureConfig;

public record PolypiteQuartzFeatureConfig(PolypiteQuartzBlock quartzMaterial) implements FeatureConfig {
    public static final Codec<PolypiteQuartzFeatureConfig> CODEC = RecordCodecBuilder.create(
            (instance) -> instance.group(
                    Codec.STRING.fieldOf("quartz_material").forGetter((config) -> Registries.BLOCK.getId(config.quartzMaterial).toString())
            ).apply(instance, PolypiteQuartzFeatureConfig::from));

    private static PolypiteQuartzFeatureConfig from(String id) {
        return new PolypiteQuartzFeatureConfig((PolypiteQuartzBlock) Registries.BLOCK.get(Identifier.tryParse(id)));
    }
}
