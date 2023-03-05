package com.terraformersmc.cinderscapes.biomegen;

import com.terraformersmc.biolith.api.biome.BiomePlacement;
import com.terraformersmc.biolith.api.surface.SurfaceGeneration;
import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.biome.AshyShoalsBiome;
import com.terraformersmc.cinderscapes.biome.BlackstoneShalesBiome;
import com.terraformersmc.cinderscapes.biome.LuminousGroveBiome;
import com.terraformersmc.cinderscapes.biome.QuartzCavernBiome;
import com.terraformersmc.cinderscapes.config.CinderscapesConfig;
import com.terraformersmc.cinderscapes.surfacebuilders.CinderscapesSurfaceBuilders;
import com.terraformersmc.cinderscapes.surfacerules.CinderscapesSurfaceRules;
import net.minecraft.util.Identifier;

import static com.terraformersmc.cinderscapes.init.CinderscapesBiomes.*;

public class CinderscapesBiolithGeneration implements Runnable {
	CinderscapesConfig.BiomeOptions BIOME_CONFIG;

	public void addBiomes() {
		/* TODO: BiomePlacement.addNetherBiome() is not implemented yet
		if (BIOME_CONFIG.enableAshyShoals)        { BiomePlacement.addNetherBiome(ASHY_SHOALS, AshyShoalsBiome.NOISE_POINT); }
		if (BIOME_CONFIG.enableBlackstoneShales)  { BiomePlacement.addNetherBiome(BLACKSTONE_SHALES, BlackstoneShalesBiome.NOISE_POINT); }
		if (BIOME_CONFIG.enableLuminousGrove)     { BiomePlacement.addNetherBiome(LUMINOUS_GROVE, LuminousGroveBiome.NOISE_POINT); }
		if (BIOME_CONFIG.enableQuartzCavern)      { BiomePlacement.addNetherBiome(QUARTZ_CAVERN, QuartzCavernBiome.NOISE_POINT); }
		*/
	}

	// Use Biolith to register our Biome placements.
	// We can't do registration stuff until Cinderscapes' common module is ready.
	// This method will be called when Cinderscapes is done initializing.
	@Override
	public void run() {
		// Register the Cinderscapes surface rules.
		SurfaceGeneration.addNetherSurfaceRules(
				Identifier.of(Cinderscapes.NAMESPACE, "surface_rules"),
				CinderscapesSurfaceRules.createRules());

		// Register the Cinderscapes surface builders.
		CinderscapesSurfaceBuilders.getBuilders().forEach(SurfaceGeneration::addSurfaceBuilder);

		// Add the biomes to Nether generation via Biolith.
		BIOME_CONFIG = CinderscapesConfig.INSTANCE.biomes;
		this.addBiomes();
	}
}
