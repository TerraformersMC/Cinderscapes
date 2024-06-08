package com.terraformersmc.cinderscapes.biome;

import com.terraformersmc.cinderscapes.init.CinderscapesPlacedFeatures;
import com.terraformersmc.cinderscapes.init.CinderscapesSoundEvents;
import com.terraformersmc.cinderscapes.mixin.OverworldBiomeCreatorAccessor;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeAdditionsSound;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.BiomeParticleConfig;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.*;

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
                        .skyColor(OverworldBiomeCreatorAccessor.cinderscapes$callGetSkyColor(2.0f))
                        .waterColor(4159204)
                        .waterFogColor(4341314)
                        .fogColor(3344392)
                        .particleConfig(new BiomeParticleConfig(ParticleTypes.FIREWORK, 0.0025F))
                        .loopSound(SoundEvents.AMBIENT_NETHER_WASTES_LOOP)
                        .moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_NETHER_WASTES_MOOD, 6000, 8, 2.0D))
                        .additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_NETHER_WASTES_ADDITIONS, 0.0111D))
                        .music(MusicType.createIngameMusic(Registries.SOUND_EVENT.getEntry(CinderscapesSoundEvents.QUARTZ_CAVERN_MUSIC)))
                        .build())
                .build();
    }

    private static GenerationSettings createGenerationSettings(Registerable<Biome> registerable) {
        RegistryEntryLookup<ConfiguredCarver<?>> configuredCarvers = registerable.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);
        RegistryEntryLookup<PlacedFeature> placedFeatures = registerable.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        GenerationSettings.LookupBackedBuilder builder = new GenerationSettings.LookupBackedBuilder(placedFeatures, configuredCarvers);

        // DEFAULT MINECRAFT FEATURES
        builder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.NETHER_CAVE);
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
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIFIED_PIGLIN, 50, 4, 4));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.MAGMA_CUBE, 15, 2, 4));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 1, 4, 4));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.PIGLIN, 20, 4, 4));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.STRIDER, 60, 1, 2));

        return builder.build();
    }
}
