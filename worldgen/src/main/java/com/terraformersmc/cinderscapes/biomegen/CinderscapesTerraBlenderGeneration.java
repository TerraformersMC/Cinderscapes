package com.terraformersmc.cinderscapes.biomegen;

import com.mojang.datafixers.util.Pair;
import com.terraformersmc.biolith.api.surface.SurfaceGeneration;
import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.biome.AshyShoalsBiome;
import com.terraformersmc.cinderscapes.biome.BlackstoneShalesBiome;
import com.terraformersmc.cinderscapes.biome.LuminousGroveBiome;
import com.terraformersmc.cinderscapes.biome.QuartzCavernBiome;
import com.terraformersmc.cinderscapes.config.CinderscapesConfig;
import com.terraformersmc.cinderscapes.surfacebuilders.CinderscapesSurfaceBuilders;
import com.terraformersmc.cinderscapes.surfacerules.CinderscapesSurfaceRules;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.*;

import java.util.function.Consumer;

import static com.terraformersmc.cinderscapes.init.CinderscapesBiomes.*;

public class CinderscapesTerraBlenderGeneration extends Region implements Runnable, TerraBlenderApi {
    CinderscapesConfig.BiomeOptions BIOME_CONFIG;

    public CinderscapesTerraBlenderGeneration() {
        super(Identifier.of(Cinderscapes.MOD_ID, "nether"), RegionType.NETHER, 10);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
        if (BIOME_CONFIG.enableAshyShoals)        { addBiome(mapper, AshyShoalsBiome.NOISE_POINT, ASHY_SHOALS); }
        if (BIOME_CONFIG.enableBlackstoneShales)  { addBiome(mapper, BlackstoneShalesBiome.NOISE_POINT, BLACKSTONE_SHALES); }
        if (BIOME_CONFIG.enableLuminousGrove)     { addBiome(mapper, LuminousGroveBiome.NOISE_POINT, LUMINOUS_GROVE); }
        if (BIOME_CONFIG.enableQuartzCavern)      { addBiome(mapper, QuartzCavernBiome.NOISE_POINT, QUARTZ_CAVERN); }
    }

    @Override
    public void onTerraBlenderInitialized() {
        // We can't do registration stuff until both Cinderscapes and TerraBlender are ready.
        // The run() method below will be called when Cinderscapes is done initializing.
        Cinderscapes.callbackWhenInitialized(CinderscapesSurfaceBuilders::init);
        Cinderscapes.callbackWhenInitialized(this);
    }

    // Initialize TerraBlender as our biome placement provider.
    @Override
    public void run() {
        // Register the Cinderscapes surface rules; this must happen before we call addSurfaceRules().
        CinderscapesSurfaceRules.init();

        // Add the Cinderscapes Overworld surface rules via TerraBlender.
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.NETHER, Cinderscapes.MOD_ID, CinderscapesSurfaceRules.createRules());

        // Register the Cinderscapes surface builders.
        CinderscapesSurfaceBuilders.getBuilders().forEach(SurfaceGeneration::addSurfaceBuilder);

        // Add the biomes to Overworld generation via TerraBlender.
        BIOME_CONFIG = CinderscapesConfig.INSTANCE.biomes;
        Regions.register(this);
    }
}
