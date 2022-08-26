package com.terraformersmc.cinderscapes;

import com.terraformersmc.cinderscapes.surfacerules.CinderscapesSurfaceRules;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class CinderscapesWorldgen implements ModInitializer {

	@Override
	public void onInitialize() {

		CinderscapesSurfaceRules.init();
	}
}
