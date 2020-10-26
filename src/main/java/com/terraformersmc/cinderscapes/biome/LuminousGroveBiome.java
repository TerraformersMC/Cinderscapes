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

public class LuminousGroveBiome {

    public static final Biome.MixedNoisePoint NOISE_POINT = new Biome.MixedNoisePoint(0.35F, 0.35F, 0.0F, 0.0F, 0.2F);

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
                .effects((new BiomeEffects.Builder())
                        .skyColor(DefaultBiomeCreatorAccessor.callGetSkyColor(2.0f))
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .fogColor(2297392)
                        .particleConfig(new BiomeParticleConfig(ParticleTypes.WARPED_SPORE, 0.01428F))
                        .loopSound(SoundEvents.AMBIENT_WARPED_FOREST_LOOP)
                        .moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_WARPED_FOREST_MOOD, 6000, 8, 2.0D))
                        .additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_WARPED_FOREST_ADDITIONS, 0.0111D))
                        .music(MusicType.createIngameMusic(CinderscapesSoundEvents.LUMINOUS_GROVE_MUSIC))
                        .build())
                .build();
    }

    private static GenerationSettings createGenerationSettings() {
        GenerationSettings.Builder builder = new GenerationSettings.Builder();
        builder.surfaceBuilder(CinderscapesSurfaces.CONFIGURED_LUMINOUS_GROVE);

        // UMBRAL FUNGUS
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapeConfiguredFeatures.CANOPIED_HUGE_FUNGUS);

        // GLOWSTONE
        builder.feature(net.minecraft.world.gen.GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.GLOWSTONE_EXTRA);
        builder.feature(net.minecraft.world.gen.GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.GLOWSTONE);

        // SHROOMLIGHT BUSHES
        builder.feature(net.minecraft.world.gen.GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapeConfiguredFeatures.SHROOMLIGHT_BUSH);

        // VEGETATION
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapeConfiguredFeatures.VEGETATION_LUMINOUS_GROWTH);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapeConfiguredFeatures.LUMINOUS_POD);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapeConfiguredFeatures.TALL_PHOTOFERN);

        // VINES
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapeConfiguredFeatures.UMBRAL_VINE);

        // DEFAULT MINECRAFT FEATURES
        builder.structureFeature(ConfiguredStructureFeatures.FORTRESS);
        builder.structureFeature(ConfiguredStructureFeatures.BASTION_REMNANT);
        builder.structureFeature(ConfiguredStructureFeatures.RUINED_PORTAL_NETHER);
        builder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.NETHER_CAVE);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.ORE_MAGMA);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.SPRING_CLOSED);
        DefaultBiomeFeatures.addNetherMineables(builder);

        return builder.build();

    }

    private static SpawnSettings createSpawnSettings() {

        SpawnSettings.Builder builder = new SpawnSettings.Builder();

        // SPAWNS
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.STRIDER, 60, 1, 2));

        return builder.build();

    }

}
