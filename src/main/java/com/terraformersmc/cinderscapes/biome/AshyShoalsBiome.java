package com.terraformersmc.cinderscapes.biome;

import com.terraformersmc.cinderscapes.client.CinderscapesSoundEvents;
import com.terraformersmc.cinderscapes.init.CinderscapeConfiguredFeatures;
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
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

public class AshyShoalsBiome {

    public static final Biome.MixedNoisePoint NOISE_POINT = new Biome.MixedNoisePoint(-0.35F, 0.0F, 0.35F, 0.0F, 0.2F);

    public static Biome create() {
        return new Biome.Builder()
                .generationSettings(createGenerationSettings())
                .spawnSettings(createSpawnSettings())
                .precipitation(Biome.Precipitation.NONE)
                .category(Biome.Category.NETHER)
                .depth(0.1F)
                .scale(0.2F)
                .temperature(2.0F)
                .downfall(0.0F)
                .effects(new BiomeEffects.Builder()
                        .skyColor(DefaultBiomeCreatorAccessor.callGetSkyColor(2.0f))
                        .waterColor(4159204)
                        .waterFogColor(4341314)
                        .fogColor(0x363636)
                        .particleConfig(new BiomeParticleConfig(ParticleTypes.ASH, 0.625F))
                        .loopSound(SoundEvents.AMBIENT_NETHER_WASTES_LOOP)
                        .moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D))
                        .additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, 0.0111D))
                        .music(MusicType.createIngameMusic(CinderscapesSoundEvents.ASHY_SHOALS_MUSIC))
                        .build())
                .build();
    }

    private static GenerationSettings createGenerationSettings() {

        GenerationSettings.Builder builder = new GenerationSettings.Builder();
        builder.surfaceBuilder(CinderscapesSurfaces.CONFIGURED_ASHY_SHOALS);

        // DEFAULT MINECRAFT FEATURES

        builder.structureFeature(ConfiguredStructureFeatures.RUINED_PORTAL_NETHER);
        builder.structureFeature(ConfiguredStructureFeatures.FORTRESS);
        builder.structureFeature(ConfiguredStructureFeatures.BASTION_REMNANT);
        builder.structureFeature(ConfiguredStructureFeatures.NETHER_FOSSIL);
        builder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.NETHER_CAVE);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.GLOWSTONE_EXTRA);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.GLOWSTONE);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.ORE_MAGMA);
        DefaultBiomeFeatures.addNetherMineables(builder);

        // ASH PILES
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapeConfiguredFeatures.ASH_PILES);

        // VEGETATION
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapeConfiguredFeatures.VEGETATION_ASHY_SHOALS);

        // BRAMBLE BERRY BUSHES
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapeConfiguredFeatures.BRAMBLE_BERRY_BUSHES);

        // REPLACE NETHERRACK
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapeConfiguredFeatures.SOUL_SAND_ASHY_SHOALS);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapeConfiguredFeatures.SOUL_SOIL_ASHY_SHOALS);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapeConfiguredFeatures.GRAVEL_ASHY_SHOALS);

        // TOP LAYER MODIFICATION
        builder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, CinderscapeConfiguredFeatures.ASH_TOP_LAYER);

        // FEATURES
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapeConfiguredFeatures.DEAD_TREE);

        // ANCIENT DEBRIS
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapeConfiguredFeatures.ORE_DEBRIS_LARGE_ASHY_SHOALS);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapeConfiguredFeatures.ORE_DEBRIS_SMALL_ASHY_SHOALS);

        return builder.build();
    }

    private static SpawnSettings createSpawnSettings() {

        SpawnSettings.Builder builder = new SpawnSettings.Builder();

        // SPAWNS
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIFIED_PIGLIN, 1, 1, 4));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOGLIN, 1, 1, 1));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 1, 4, 4));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.STRIDER, 60, 1, 2));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SKELETON, 20, 5, 5));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.GHAST, 50, 4, 4));

        return builder.build();

    }

}
