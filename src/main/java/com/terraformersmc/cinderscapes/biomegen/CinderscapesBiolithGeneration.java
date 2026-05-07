package com.terraformersmc.cinderscapes.biomegen;

import com.terraformersmc.biolith.api.biome.BiomePlacement;
import com.terraformersmc.biolith.api.surface.SurfaceGeneration;
import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.biome.AshyShoalsBiome;
import com.terraformersmc.cinderscapes.biome.BlackstoneShalesBiome;
import com.terraformersmc.cinderscapes.biome.LuminousGroveBiome;
import com.terraformersmc.cinderscapes.biome.QuartzCavernBiome;
import com.terraformersmc.cinderscapes.config.CinderscapesConfig;
import com.terraformersmc.cinderscapes.surface.builders.CinderscapesSurfaceBuilders;
import com.terraformersmc.cinderscapes.surface.rules.CinderscapesSurfaceRules;
import net.minecraft.resources.Identifier;

import static com.terraformersmc.cinderscapes.init.CinderscapesBiomes.*;

public class CinderscapesBiolithGeneration {
	private static final CinderscapesConfig.BiomeOptions BIOME_CONFIG = CinderscapesConfig.INSTANCE.biomes;

	public static void init() {
		// Register the Cinderscapes surface rules.
		SurfaceGeneration.addNetherSurfaceRules(
				Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, "surface_rules"),
				CinderscapesSurfaceRules.createRules());

		// Register the Cinderscapes surface builders.
		CinderscapesSurfaceBuilders.getBuilders().forEach(SurfaceGeneration::addSurfaceBuilder);

		if (BIOME_CONFIG.enableAshyShoals)        { BiomePlacement.addNether(ASHY_SHOALS, AshyShoalsBiome.NOISE_POINT); }
		if (BIOME_CONFIG.enableBlackstoneShales)  { BiomePlacement.addNether(BLACKSTONE_SHALES, BlackstoneShalesBiome.NOISE_POINT); }
		if (BIOME_CONFIG.enableLuminousGrove)     { BiomePlacement.addNether(LUMINOUS_GROVE, LuminousGroveBiome.NOISE_POINT); }
		if (BIOME_CONFIG.enableQuartzCavern)      { BiomePlacement.addNether(QUARTZ_CAVERN, QuartzCavernBiome.NOISE_POINT); }
	}
}
