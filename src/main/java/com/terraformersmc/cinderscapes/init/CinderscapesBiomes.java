package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.biome.QuartzCanyonBiome;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class CinderscapesBiomes {
    public static Biome QUARTZ_CANYON;

    public static void init() {
        QUARTZ_CANYON = Registry.register(Registry.BIOME, new Identifier("cinderscapes", "quartz_canyon"), new QuartzCanyonBiome());
    }
}
