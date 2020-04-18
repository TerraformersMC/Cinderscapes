package com.terraformersmc.cinderscapes;

import com.terraformersmc.cinderscapes.command.MapBiomesCommand;
import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import com.terraformersmc.cinderscapes.init.CinderscapesDecorators;
import com.terraformersmc.cinderscapes.init.CinderscapesFeatures;
import com.terraformersmc.cinderscapes.init.CinderscapesGeneration;
import com.terraformersmc.cinderscapes.util.NoiseCollisionChecker;
import net.fabricmc.api.ModInitializer;

public class Cinderscapes implements ModInitializer {
	@Override
	public void onInitialize() {
		CinderscapesDecorators.init();
		CinderscapesFeatures.init();
		CinderscapesBiomes.init();
		CinderscapesGeneration.init();
		MapBiomesCommand.register();

		NoiseCollisionChecker.init();
	}
}
