package com.terraformersmc.cinderscapes;

import com.terraformersmc.cinderscapes.config.CinderscapesConfig;
import com.terraformersmc.cinderscapes.init.*;
import com.terraformersmc.cinderscapes.item.CinderscapesItemGroups;
import com.terraformersmc.cinderscapes.tag.CinderscapesBlockTags;
import com.terraformersmc.cinderscapes.tag.CinderscapesItemTags;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.ZoglinEntity;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Cinderscapes implements ModInitializer {
	public static final String NAMESPACE = "cinderscapes";
	public static final Logger LOGGER = LogManager.getLogger(StringUtils.capitalize(NAMESPACE));

	private static Boolean initialized = false;
	private static final ArrayList<Runnable> runnables = new ArrayList<>(1);

	@Override
	public void onInitialize() {
		try {
			SpawnRestriction.register(EntityType.ZOGLIN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ZoglinEntity::canMobSpawn);
			SpawnRestriction.register(EntityType.ZOMBIFIED_PIGLIN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ZombifiedPiglinEntity::canMobSpawn);
		} catch (IllegalStateException ignored) { }

		CinderscapesConfig.init();

		CinderscapesBlocks.init();
		CinderscapesItems.init();
		CinderscapesBlockTags.init();
		CinderscapesItemTags.init();
		CinderscapesPlacementModifierTypes.init();
		CinderscapesFeatures.init();
		CinderscapesConfiguredFeatures.init();
		CinderscapesPlacedFeatures.init();
		CinderscapesSoundEvents.init();
		CinderscapesBiomes.init();
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

	public static Identifier id(String path) {
		return new Identifier(NAMESPACE, path);
	}
}
