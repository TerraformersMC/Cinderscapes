package com.terraformersmc.cinderscapes;

import com.terraformersmc.cinderscapes.surfacebuilders.CinderscapesSurfaceBuilders;
import com.terraformersmc.cinderscapes.biomegen.CinderscapesBiomeAPIGeneration;
import net.fabricmc.api.ModInitializer;

public class CinderscapesWorldgen implements ModInitializer {

	@Override
	public void onInitialize() {
		Cinderscapes.LOGGER.info("Enabling Cinderscapes' Fabric Biome API worldgen module.");

		Cinderscapes.callbackWhenInitialized(CinderscapesSurfaceBuilders::init);
		CinderscapesBiomeAPIGeneration.init();
	}
}
