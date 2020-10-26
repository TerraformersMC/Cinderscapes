package com.terraformersmc.cinderscapes.biome;

import com.terraformersmc.cinderscapes.client.CinderscapesSoundEvents;
import com.terraformersmc.cinderscapes.init.CinderscapeConfiguredFeatures;
import com.terraformersmc.cinderscapes.init.CinderscapesCarvers;
import com.terraformersmc.cinderscapes.init.CinderscapesSurfaces;
import com.terraformersmc.cinderscapes.mixin.DefaultBiomeCreatorAccessor;

import net.minecraft.client.sound.MusicType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BiomeAdditionsSound;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.BiomeParticleConfig;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

// TODO: Check
public class IvoryShallowsBiome {

	public static final Biome.MixedNoisePoint NOISE_POINT = new Biome.MixedNoisePoint(-0.45F, 0.45F, 0.15F, 0.45F,
			0.2F);

	public static Biome create() {
		return new Biome.Builder().generationSettings(createGenerationSettings()).spawnSettings(createSpawnSettings())
				.precipitation(Biome.Precipitation.NONE).category(Biome.Category.NETHER).depth(0.15F).scale(0.5F)
				.temperature(1.5F).downfall(0.0F)
				.effects(new BiomeEffects.Builder().skyColor(DefaultBiomeCreatorAccessor.callGetSkyColor(2.0f))
						.waterColor(4159204).waterFogColor(4341314).fogColor(0xF9F1DE)
						.particleConfig(new BiomeParticleConfig(ParticleTypes.CLOUD, 0.0025F))
						.loopSound(SoundEvents.AMBIENT_NETHER_WASTES_LOOP)
						.moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_NETHER_WASTES_MOOD, 6000, 8, 2.0D))
						.additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_NETHER_WASTES_ADDITIONS, 0.0111D))
						.music(MusicType.createIngameMusic(CinderscapesSoundEvents.IVORY_SHALLOWS_MUSIC)).build())
				.build();
	}

	private static GenerationSettings createGenerationSettings() {
		GenerationSettings.Builder builder = new GenerationSettings.Builder();
		builder.surfaceBuilder(CinderscapesSurfaces.CONFIGURED_IVORY_SHALLOWS);

		// DEFAULT MINECRAFT FEATURES
		builder.structureFeature(ConfiguredStructureFeatures.RUINED_PORTAL_NETHER);
		builder.carver(GenerationStep.Carver.AIR, CinderscapesCarvers.IVORY_SHALLOWS_CONFIGURED_CARVER);
		builder.structureFeature(ConfiguredStructureFeatures.FORTRESS);
		builder.structureFeature(ConfiguredStructureFeatures.NETHER_FOSSIL);
		builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.BROWN_MUSHROOM_NETHER);
		builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.RED_MUSHROOM_NETHER);
		builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.SPRING_CLOSED_DOUBLE);
		DefaultBiomeFeatures.addAncientDebris(builder);

		// PILLARS
		builder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, CinderscapeConfiguredFeatures.IVORY_PILLAR);

		// TUSKS
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapeConfiguredFeatures.CEILING_IVORY_TUSK);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapeConfiguredFeatures.FLOOR_IVORY_TUSK);
		
		// IVORY FOLIAGE
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapeConfiguredFeatures.IVORY_TOOTH);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapeConfiguredFeatures.IVORY_SPIKE_SHORT);

		return builder.build();

	}

	private static SpawnSettings createSpawnSettings() {

		SpawnSettings.Builder builder = new SpawnSettings.Builder();

		// SPAWNS
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIFIED_PIGLIN, 50, 4, 4));
		builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.STRIDER, 60, 1, 2));

		return builder.build();

	}

}
