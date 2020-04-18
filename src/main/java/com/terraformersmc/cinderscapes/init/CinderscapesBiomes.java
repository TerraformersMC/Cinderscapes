package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.biome.BlackstoneShalesBiome;
import com.terraformersmc.cinderscapes.biome.QuartzCanyonBiome;
import com.terraformersmc.cinderscapes.biome.WitheredWastesBiome;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class CinderscapesBiomes {
    public static Biome BLACKSTONE_SHALES;
    public static Biome QUARTZ_CANYON;
    public static Biome WITHERED_WASTES;

    public static void init() {
        BLACKSTONE_SHALES = Registry.register(Registry.BIOME, Cinderscapes.id("blackstone_shales"), new BlackstoneShalesBiome());
        QUARTZ_CANYON = Registry.register(Registry.BIOME, Cinderscapes.id("quartz_canyon"), new QuartzCanyonBiome());
        WITHERED_WASTES = Registry.register(Registry.BIOME, Cinderscapes.id("withered_wastes"), new WitheredWastesBiome());
    }
}
