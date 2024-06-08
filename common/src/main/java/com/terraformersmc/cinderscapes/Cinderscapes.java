package com.terraformersmc.cinderscapes;

import com.terraformersmc.cinderscapes.config.CinderscapesConfig;
import com.terraformersmc.cinderscapes.init.*;
import com.terraformersmc.cinderscapes.item.CinderscapesItemGroups;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Cinderscapes implements ModInitializer {
	public static final String MOD_ID = "cinderscapes";
	public static final Logger LOGGER = LogManager.getLogger(StringUtils.capitalize(MOD_ID));

	private static Boolean initialized = false;
	private static final ArrayList<Runnable> runnables = new ArrayList<>(1);

	@Override
	public void onInitialize() {
		CinderscapesConfig.init();

		CinderscapesSpawnRestrictions.init();
		CinderscapesBlocks.init();
		CinderscapesItems.init();
		CinderscapesPlacementModifierTypes.init();
		CinderscapesFeatures.init();
		CinderscapesSoundEvents.init();
		CinderscapesTrades.init();
		CinderscapesItemGroups.init();

		if (!FabricLoader.getInstance().isModLoaded("cinderscapes-worldgen")) {
			Cinderscapes.LOGGER.info("No Cinderscapes worldgen module present; Cinderscapes biomes will not generate.");
		}

		// At this point Cinderscapes is completely initialized.
		initialized = true;
		for (Runnable callback : runnables) {
			callback.run();
		}
	}

	public static void callbackWhenInitialized(Runnable callback) {
		if (initialized) {
			callback.run();
		} else {
			runnables.add(callback);
		}
	}
}
