package com.terraformersmc.cinderscapes;

import com.terraformersmc.cinderscapes.biomegen.CinderscapesBiolithGeneration;
import com.terraformersmc.cinderscapes.surfacebuilders.CinderscapesSurfaceBuilders;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class CinderscapesWorldgen implements ModInitializer {

	@Override
	public void onInitialize() {
		// For the time being, our TerraBlender support is unused.
		if (FabricLoader.getInstance().isModLoaded("biolith")) {
			Cinderscapes.LOGGER.info("Enabling Cinderscapes' Biolith worldgen module.");

			Cinderscapes.callbackWhenInitialized(CinderscapesSurfaceBuilders::init);
			Cinderscapes.callbackWhenInitialized(new CinderscapesBiolithGeneration());
		} else {
			Cinderscapes.LOGGER.warn("Cinderscapes world generation disabled; Biolith is not present.");
		}
	}
}
