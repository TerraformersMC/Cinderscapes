package com.terraformersmc.cinderscapes;

import com.terraformersmc.cinderscapes.surfacebuilders.CinderscapesSurfaceBuilders;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class CinderscapesWorldgen implements ModInitializer {

	@Override
	public void onInitialize() {

		if (FabricLoader.getInstance().isModLoaded("terrablender")) {
			Cinderscapes.LOGGER.info("Enabling Cinderscapes' TerraBlender worldgen module.");
		} else {
			Cinderscapes.LOGGER.warn("Cinderscapes world generation disabled; TerraBlender is not present.");
		}

		Cinderscapes.callbackWhenInitialized(CinderscapesSurfaceBuilders::init);
	}
}
