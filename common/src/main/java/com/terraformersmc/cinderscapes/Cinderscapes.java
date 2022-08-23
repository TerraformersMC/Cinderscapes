package com.terraformersmc.cinderscapes;

import com.terraformersmc.cinderscapes.config.CinderscapesConfig;
import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.init.CinderscapesFeatures;
import com.terraformersmc.cinderscapes.init.CinderscapesGroups;
import com.terraformersmc.cinderscapes.init.CinderscapesPlacementModifierTypes;
import com.terraformersmc.cinderscapes.init.CinderscapesItems;
import com.terraformersmc.cinderscapes.init.CinderscapesSoundEvents;
import com.terraformersmc.cinderscapes.init.CinderscapesTags;
import com.terraformersmc.cinderscapes.init.CinderscapesTrades;
import com.terraformersmc.cinderscapes.util.NoiseCollisionChecker;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.mixin.object.builder.SpawnRestrictionAccessor;
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
import java.util.List;

public class Cinderscapes implements ModInitializer {

	public static final String NAMESPACE = "cinderscapes";
	public static final Logger LOGGER = LogManager.getLogger(StringUtils.capitalize(NAMESPACE));

	public static List<Item> HIDDEN_ITEMS = new ArrayList<>();

	@Override
	public void onInitialize() {
		try {
			SpawnRestrictionAccessor.callRegister(EntityType.ZOGLIN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ZoglinEntity::canMobSpawn);
			SpawnRestrictionAccessor.callRegister(EntityType.ZOMBIFIED_PIGLIN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ZombifiedPiglinEntity::canMobSpawn);
		} catch (IllegalStateException ignored) { }

		CinderscapesConfig.init();

		CinderscapesItems.init();
		CinderscapesBlocks.init();
		CinderscapesTags.init();
		CinderscapesPlacementModifierTypes.init();
		CinderscapesFeatures.init();
		CinderscapesGroups.init();
		CinderscapesBiomes.init();
		CinderscapesSoundEvents.init();
		CinderscapesTrades.init();

		NoiseCollisionChecker.init();
	}

	public static Identifier id(String path) {
		return new Identifier(NAMESPACE, path);
	}
}
