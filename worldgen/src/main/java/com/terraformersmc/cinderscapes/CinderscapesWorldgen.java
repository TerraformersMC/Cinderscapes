package com.terraformersmc.cinderscapes;

import com.terraformersmc.cinderscapes.worldgen.CinderscapesBiomeAPIGeneration;
import net.fabricmc.api.ModInitializer;

public class CinderscapesWorldgen implements ModInitializer {

	@Override
	public void onInitialize() {

		Cinderscapes.LOGGER.info("Enabling Cinderscapes' TerraBlender worldgen module.");

		CinderscapesBiomeAPIGeneration.init();
	}
}
