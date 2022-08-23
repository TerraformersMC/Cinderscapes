package com.terraformersmc.cinderscapes;

import com.terraformersmc.cinderscapes.surfacerules.CinderscapesSurfaceRules;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class CinderscapesWorldgen implements ModInitializer {

	@Override
	public void onInitialize() {
// TODO: TerraBlender worldgen
//
//		if (FabricLoader.getInstance().isModLoaded("terrablender")) {
//			Cinderscapes.LOGGER.info("Enabling Traverse's TerraBlender worldgen module.");
//		} else {
//			Cinderscapes.LOGGER.warn("Traverse world generation disabled; TerraBlender is not present.");
//		}

		CinderscapesSurfaceRules.init();
	}
}
