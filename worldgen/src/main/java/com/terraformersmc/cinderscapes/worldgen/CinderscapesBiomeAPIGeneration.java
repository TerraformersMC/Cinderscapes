package com.terraformersmc.cinderscapes.worldgen;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.biome.AshyShoalsBiome;
import com.terraformersmc.cinderscapes.biome.BlackstoneShalesBiome;
import com.terraformersmc.cinderscapes.biome.LuminousGroveBiome;
import com.terraformersmc.cinderscapes.biome.QuartzCavernBiome;
import com.terraformersmc.cinderscapes.config.CinderscapesConfig;
import com.terraformersmc.cinderscapes.surfacerules.CinderscapesSurfaceRules;
import net.fabricmc.fabric.api.biome.v1.NetherBiomes;

import static com.terraformersmc.cinderscapes.init.CinderscapesBiomes.*;

public class CinderscapesBiomeAPIGeneration implements Runnable {
    CinderscapesConfig.BiomeOptions BIOME_CONFIG;

    public void addBiomes() {
        if (BIOME_CONFIG.enableAshyShoals)        { NetherBiomes.addNetherBiome(ASHY_SHOALS, AshyShoalsBiome.NOISE_POINT); }
        if (BIOME_CONFIG.enableBlackstoneShales)  { NetherBiomes.addNetherBiome(BLACKSTONE_SHALES, BlackstoneShalesBiome.NOISE_POINT); }
        if (BIOME_CONFIG.enableLuminousGrove)     { NetherBiomes.addNetherBiome(LUMINOUS_GROVE, LuminousGroveBiome.NOISE_POINT); }
        if (BIOME_CONFIG.enableQuartzCavern)      { NetherBiomes.addNetherBiome(QUARTZ_CAVERN, QuartzCavernBiome.NOISE_POINT); }
    }

    public static void init() {
        // We can't do registration stuff until Cinderscapes' common module is ready.
        // The run() method below will be called when Cinderscapes is done initializing.
        Cinderscapes.callbackWhenInitialized(new CinderscapesBiomeAPIGeneration());
    }

    // Use Fabric's Biome API to register our Biome placements.
    @Override
    public void run() {
        // Register the Cinderscapes surface rules.
        CinderscapesSurfaceRules.init();

        // Add the biomes to Nether generation via Fabric's Biome API.
        BIOME_CONFIG = CinderscapesConfig.INSTANCE.biomes;
        this.addBiomes();
    }
}
