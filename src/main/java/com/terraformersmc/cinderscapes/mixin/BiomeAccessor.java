package com.terraformersmc.cinderscapes.mixin;

import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(Biome.class)
public interface BiomeAccessor {
    @Accessor
    List<Biome.MixedNoisePoint> getNoisePoints();
}
