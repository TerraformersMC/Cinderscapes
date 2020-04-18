package com.terraformersmc.cinderscapes;

import com.terraformersmc.cinderscapes.init.*;
import net.fabricmc.api.ModInitializer;

public class Cinderscapes implements ModInitializer {
	@Override
	public void onInitialize() {
		CinderscapesBlocks.init();
		CinderscapesDecorators.init();
		CinderscapesFeatures.init();
		CinderscapesBiomes.init();
		CinderscapesGeneration.init();
	}
}
