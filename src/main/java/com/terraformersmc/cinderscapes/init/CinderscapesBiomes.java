package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.biome.BlackstoneShalesBiome;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class CinderscapesBiomes {
    public static Biome BLACKSTONE_SHALES;

    public static void init() {
        BLACKSTONE_SHALES = Registry.register(Registry.BIOME, Cinderscapes.id("blackstone_shales"), new BlackstoneShalesBiome());
    }
}

