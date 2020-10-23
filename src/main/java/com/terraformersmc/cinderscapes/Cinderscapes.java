package com.terraformersmc.cinderscapes;

import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.init.CinderscapesDecorators;
import com.terraformersmc.cinderscapes.init.CinderscapesFeatures;
import com.terraformersmc.cinderscapes.init.CinderscapesGroups;
import com.terraformersmc.cinderscapes.init.CinderscapesItems;
import com.terraformersmc.cinderscapes.init.CinderscapesSoundEvents;
import com.terraformersmc.cinderscapes.init.CinderscapesSurfaces;
import com.terraformersmc.cinderscapes.init.CinderscapesTags;
import com.terraformersmc.cinderscapes.util.NoiseCollisionChecker;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cinderscapes implements ModInitializer {

	public static final String NAMESPACE = "cinderscapes";
	public static final Logger LOGGER = LogManager.getLogger(StringUtils.capitalize(NAMESPACE));

	// TODO: Add back a better implementation of the fog density in the Ashy Shoals

	@Override
	public void onInitialize() {
		// TODO: Review this down
		CinderscapesItems.init();
		CinderscapesBlocks.init();
		CinderscapesTags.init();
		CinderscapesDecorators.init();
		CinderscapesFeatures.init();
		CinderscapesSurfaces.init();
		CinderscapesGroups.init();
		CinderscapesBiomes.init();
		CinderscapesSoundEvents.init();

		NoiseCollisionChecker.init();
	}

	public static Identifier id(String path) {
		return new Identifier(NAMESPACE, path);
	}
}