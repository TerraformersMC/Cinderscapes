package com.terraformersmc.cinderscapes.biome;

import com.terraformersmc.cinderscapes.init.CinderscapesPlacedFeatures;
import com.terraformersmc.cinderscapes.init.CinderscapesSoundEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeAdditionsSound;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.attribute.*;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.*;

import java.util.List;
import java.util.Optional;

public class QuartzCavernBiome {
    public static final MultiNoiseUtil.NoiseHypercube NOISE_POINT = MultiNoiseUtil.createNoiseHypercube(-0.225F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1F);

    public static Biome create(Registerable<Biome> registerable) {
        return new Biome.Builder()
                .generationSettings(createGenerationSettings(registerable))
                .spawnSettings(createSpawnSettings())
                .precipitation(false)
                .temperature(2.0F)
                .downfall(0.0F)
                .effects(new BiomeEffects.Builder()
                        .waterColor(4159204)
                        .build()
                )
                .addEnvironmentAttributes(EnvironmentAttributeMap.builder()
                        .with(EnvironmentAttributes.AMBIENT_PARTICLES_VISUAL, List.of(new AmbientParticle(ParticleTypes.FIREWORK, 0.0025F)))
                        .with(EnvironmentAttributes.AMBIENT_SOUNDS_AUDIO, new AmbientSounds(Optional.of(SoundEvents.AMBIENT_NETHER_WASTES_LOOP), Optional.of(new BiomeMoodSound(SoundEvents.AMBIENT_NETHER_WASTES_MOOD, 6000, 8, 2.0D)), List.of(new BiomeAdditionsSound(SoundEvents.AMBIENT_NETHER_WASTES_ADDITIONS, 0.0111D))))
                        .with(EnvironmentAttributes.BACKGROUND_MUSIC_AUDIO, new BackgroundMusic(CinderscapesSoundEvents.QUARTZ_CAVERN_MUSIC))
                        .with(EnvironmentAttributes.FOG_COLOR_VISUAL, 3344392)
                        .with(EnvironmentAttributes.SNOW_GOLEM_MELTS_GAMEPLAY, true)
                        .with(EnvironmentAttributes.WATER_FOG_COLOR_VISUAL, 4341314)
                        .build()
                )
                .build();
    }

    private static GenerationSettings createGenerationSettings(Registerable<Biome> registerable) {
        RegistryEntryLookup<ConfiguredCarver<?>> configuredCarvers = registerable.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);
        RegistryEntryLookup<PlacedFeature> placedFeatures = registerable.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        GenerationSettings.LookupBackedBuilder builder = new GenerationSettings.LookupBackedBuilder(placedFeatures, configuredCarvers);

        // DEFAULT MINECRAFT FEATURES
        builder.carver(ConfiguredCarvers.NETHER_CAVE);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MiscPlacedFeatures.SPRING_LAVA);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.SPRING_DELTA);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.PATCH_FIRE);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.PATCH_SOUL_FIRE);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.GLOWSTONE_EXTRA);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.GLOWSTONE);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, VegetationPlacedFeatures.BROWN_MUSHROOM_NETHER);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, VegetationPlacedFeatures.RED_MUSHROOM_NETHER);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, OrePlacedFeatures.ORE_MAGMA);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.SPRING_CLOSED_DOUBLE);
        DefaultBiomeFeatures.addAncientDebris(builder);

        // QUARTZ ORES
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.GOLD_ORE));
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.SULFUR_ORE));
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.QUARTZ_ORE));
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.ROSE_QUARTZ_ORE));
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.SMOKY_QUARTZ_ORE));
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.SULFUR_QUARTZ_ORE));

        // QUARTZ SHARDS
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.CEILING_SHARDS));
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.FLOOR_SHARDS));

        // POLYPITE QUARTZ
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.POLYPITE_QUARTZ));
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.POLYPITE_ROSE_QUARTZ));
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.POLYPITE_SMOKY_QUARTZ));
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.POLYPITE_SULFUR_QUARTZ));

        // VEGETATION
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.QUARTZ_VEGETATION));

        return builder.build();
    }

    private static SpawnSettings createSpawnSettings() {
        SpawnSettings.Builder builder = new SpawnSettings.Builder();

        // SPAWNS
        builder.spawn(SpawnGroup.MONSTER, 50, new SpawnSettings.SpawnEntry(EntityType.ZOMBIFIED_PIGLIN, 4, 4));
        builder.spawn(SpawnGroup.MONSTER, 15, new SpawnSettings.SpawnEntry(EntityType.MAGMA_CUBE, 2, 4));
        builder.spawn(SpawnGroup.MONSTER,  1, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 4, 4));
        builder.spawn(SpawnGroup.MONSTER, 20, new SpawnSettings.SpawnEntry(EntityType.PIGLIN, 4, 4));
        builder.spawn(SpawnGroup.CREATURE, 60, new SpawnSettings.SpawnEntry(EntityType.STRIDER, 1, 2));

        return builder.build();
    }
}
