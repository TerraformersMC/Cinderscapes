package com.terraformersmc.cinderscapes.mixin;

import net.minecraft.world.biome.DefaultBiomeCreator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(DefaultBiomeCreator.class)
public interface DefaultBiomeCreatorAccessor {

    @Invoker
    static int callGetSkyColor(float temperature) {
        throw new AssertionError("mixin");
    }
}
