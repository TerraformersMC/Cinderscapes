package com.terraformersmc.cinderscapes;

import com.terraformersmc.cinderscapes.config.CinderscapesConfig;
import com.terraformersmc.cinderscapes.init.*;
import com.terraformersmc.cinderscapes.util.NoiseCollisionChecker;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.mixin.object.builder.SpawnRestrictionAccessor;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.ZoglinEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cinderscapes implements ModInitializer {

	public static final String NAMESPACE = "cinderscapes";
	public static final Logger LOGGER = LogManager.getLogger(StringUtils.capitalize(NAMESPACE));

	@Override
	public void onInitialize() {
		try { SpawnRestrictionAccessor.callRegister(EntityType.ZOGLIN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ZoglinEntity::canMobSpawn); } catch (IllegalStateException e) { }

		CinderscapesConfig.init();

		CinderscapesItems.init();
		CinderscapesBlocks.init();
		CinderscapesTags.init();
		CinderscapesDecorators.init();
		CinderscapesFeatures.init();
		CinderscapesSurfaceRules.init();
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