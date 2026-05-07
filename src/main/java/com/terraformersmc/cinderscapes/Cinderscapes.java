package com.terraformersmc.cinderscapes;

import com.terraformersmc.cinderscapes.biomegen.CinderscapesBiolithGeneration;
import com.terraformersmc.cinderscapes.config.CinderscapesConfig;
import com.terraformersmc.cinderscapes.init.*;
import com.terraformersmc.cinderscapes.item.CinderscapesItemGroups;
import com.terraformersmc.cinderscapes.surface.builders.CinderscapesSurfaceBuilders;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cinderscapes implements ModInitializer {
	public static final String MOD_ID = "cinderscapes";
	public static final Logger LOGGER = LogManager.getLogger(StringUtils.capitalize(MOD_ID));

	@Override
	public void onInitialize() {
		CinderscapesConfig.init();

		CinderscapesArmorTrimAssets.init();
		CinderscapesSpawnRestrictions.init();
		CinderscapesBlocks.init();
		CinderscapesItems.init();
		CinderscapesBlockEntityTypes.init();
		CinderscapesPlacementModifierTypes.init();
		CinderscapesFeatures.init();
		CinderscapesSoundEvents.init();
		CinderscapesTrades.init();
		CinderscapesItemGroups.init();
		CinderscapesRegistryAliases.init();

		if (FabricLoader.getInstance().isModLoaded("biolith")) {
			Cinderscapes.LOGGER.info("Enabling Cinderscapes's Biolith worldgen module.");
			CinderscapesSurfaceBuilders.init();
			CinderscapesBiolithGeneration.init();
		} else {
			Cinderscapes.LOGGER.warn("Cinderscapes world generation disabled; Biolith is not present.");
		}
	}
}
