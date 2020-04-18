package com.terraformersmc.cinderscapes;

import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import com.terraformersmc.cinderscapes.init.CinderscapesDecorators;
import com.terraformersmc.cinderscapes.init.CinderscapesFeatures;
import com.terraformersmc.cinderscapes.init.CinderscapesGeneration;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class Cinderscapes implements ModInitializer {

	private static final String MOD_ID = "cinderscapes";

	@Override
	public void onInitialize() {
		CinderscapesDecorators.init();
		CinderscapesFeatures.init();
		CinderscapesBiomes.init();
		CinderscapesGeneration.init();
	}

	public static Identifier id(String s) {
		return new Identifier(MOD_ID, s);
	}
}
