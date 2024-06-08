package com.terraformersmc.cinderscapes.biomegen;

import com.terraformersmc.biolith.api.surface.SurfaceGeneration;
import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.biome.AshyShoalsBiome;
import com.terraformersmc.cinderscapes.biome.BlackstoneShalesBiome;
import com.terraformersmc.cinderscapes.biome.LuminousGroveBiome;
import com.terraformersmc.cinderscapes.biome.QuartzCavernBiome;
import com.terraformersmc.cinderscapes.config.CinderscapesConfig;
import com.terraformersmc.cinderscapes.surfacebuilders.CinderscapesSurfaceBuilders;
import com.terraformersmc.cinderscapes.surfacerules.CinderscapesSurfaceRules;
import net.fabricmc.fabric.api.biome.v1.NetherBiomes;
import net.minecraft.util.Identifier;

import static com.terraformersmc.cinderscapes.init.CinderscapesBiomes.*;

public class CinderscapesBiomeAPIGeneration implements Runnable {
    CinderscapesConfig.BiomeOptions BIOME_CONFIG;

    public void addBiomes() {
        if (BIOME_CONFIG.enableAshyShoals)        { NetherBiomes.addNetherBiome(ASHY_SHOALS, AshyShoalsBiome.NOISE_POINT); }
        if (BIOME_CONFIG.enableBlackstoneShales)  { NetherBiomes.addNetherBiome(BLACKSTONE_SHALES, BlackstoneShalesBiome.NOISE_POINT); }
        if (BIOME_CONFIG.enableLuminousGrove)     { NetherBiomes.addNetherBiome(LUMINOUS_GROVE, LuminousGroveBiome.NOISE_POINT); }
        if (BIOME_CONFIG.enableQuartzCavern)      { NetherBiomes.addNetherBiome(QUARTZ_CAVERN, QuartzCavernBiome.NOISE_POINT); }
    }

    // Use Fabric's Biome API to register our Biome placements.
    // We can't do registration stuff until Cinderscapes' common module is ready.
    // This method will be called when Cinderscapes is done initializing.
    @Override
    public void run() {
        // Register the Cinderscapes surface rules.
        SurfaceGeneration.addNetherSurfaceRules(
                Identifier.of(Cinderscapes.MOD_ID, "surface_rules"),
                CinderscapesSurfaceRules.createRules());

        // Register the Cinderscapes surface builders.
        CinderscapesSurfaceBuilders.getBuilders().forEach(SurfaceGeneration::addSurfaceBuilder);

        // Add the biomes to Nether generation via Fabric's Biome API.
        BIOME_CONFIG = CinderscapesConfig.INSTANCE.biomes;
        this.addBiomes();
    }
}
