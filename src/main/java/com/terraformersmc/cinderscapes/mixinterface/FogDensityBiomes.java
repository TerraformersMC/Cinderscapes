package com.terraformersmc.cinderscapes.mixinterface;

import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

/**
 * @author <Wtoll> Will Toll on 2020-05-24
 * @project Cinderscapes
 */
public final class FogDensityBiomes {
    private FogDensityBiomes() {
    }

    public static boolean isFogDensityBiome(RegistryKey<Biome> biome) {
        return biome == CinderscapesBiomes.ASHY_SHOALS;
    }

    public static float getFogMultiplier(RegistryKey<Biome> biome) {
        return 0.5f;
    }

}
