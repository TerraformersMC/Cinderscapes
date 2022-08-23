package com.terraformersmc.cinderscapes.mixin;

import net.minecraft.world.biome.OverworldBiomeCreator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(OverworldBiomeCreator.class)
public interface OverworldBiomeCreatorAccessor {

    @Invoker("getSkyColor")
    static int cinderscapes$callGetSkyColor(float temperature) {
        throw new AssertionError("mixin");
    }
}
