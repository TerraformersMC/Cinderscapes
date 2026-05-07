package com.terraformersmc.cinderscapes.biome;

import com.terraformersmc.cinderscapes.init.CinderscapesPlacedFeatures;
import com.terraformersmc.cinderscapes.init.CinderscapesSoundEvents;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.NetherPlacements;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.attribute.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;
import java.util.Optional;

public class QuartzCavernBiome {
    public static final Climate.ParameterPoint NOISE_POINT = Climate.parameters(-0.225F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1F);

    public static Biome create(BootstrapContext<Biome> registerable) {
        return new Biome.BiomeBuilder()
                .generationSettings(createGenerationSettings(registerable))
                .mobSpawnSettings(createSpawnSettings())
                .hasPrecipitation(false)
                .temperature(2.0F)
                .downfall(0.0F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(4159204)
                        .build()
                )
                .putAttributes(EnvironmentAttributeMap.builder()
                        .set(EnvironmentAttributes.AMBIENT_PARTICLES, List.of(new AmbientParticle(ParticleTypes.FIREWORK, 0.0025F)))
                        .set(EnvironmentAttributes.AMBIENT_SOUNDS, new AmbientSounds(Optional.of(SoundEvents.AMBIENT_NETHER_WASTES_LOOP), Optional.of(new AmbientMoodSettings(SoundEvents.AMBIENT_NETHER_WASTES_MOOD, 6000, 8, 2.0D)), List.of(new AmbientAdditionsSettings(SoundEvents.AMBIENT_NETHER_WASTES_ADDITIONS, 0.0111D))))
                        .set(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(CinderscapesSoundEvents.QUARTZ_CAVERN_MUSIC))
                        .set(EnvironmentAttributes.FOG_COLOR, 3344392)
                        .set(EnvironmentAttributes.SNOW_GOLEM_MELTS, true)
                        .set(EnvironmentAttributes.WATER_FOG_COLOR, 4341314)
                        .build()
                )
                .build();
    }

    private static BiomeGenerationSettings createGenerationSettings(BootstrapContext<Biome> registerable) {
        HolderGetter<ConfiguredWorldCarver<?>> configuredCarvers = registerable.lookup(Registries.CONFIGURED_CARVER);
        HolderGetter<PlacedFeature> placedFeatures = registerable.lookup(Registries.PLACED_FEATURE);

        net.minecraft.world.level.biome.BiomeGenerationSettings.Builder builder = new net.minecraft.world.level.biome.BiomeGenerationSettings.Builder(placedFeatures, configuredCarvers);

        // DEFAULT MINECRAFT FEATURES
        builder.addCarver(Carvers.NETHER_CAVE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MiscOverworldPlacements.SPRING_LAVA);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.SPRING_DELTA);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.PATCH_FIRE);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.PATCH_SOUL_FIRE);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.GLOWSTONE_EXTRA);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.GLOWSTONE);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, VegetationPlacements.BROWN_MUSHROOM_NETHER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, VegetationPlacements.RED_MUSHROOM_NETHER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, OrePlacements.ORE_MAGMA);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.SPRING_CLOSED_DOUBLE);
        BiomeDefaultFeatures.addAncientDebris(builder);

        // QUARTZ ORES
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.GOLD_ORE));
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.SULFUR_ORE));
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.QUARTZ_ORE));
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.ROSE_QUARTZ_ORE));
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.SMOKY_QUARTZ_ORE));
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.SULFUR_QUARTZ_ORE));

        // QUARTZ SHARDS
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.CEILING_SHARDS));
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.FLOOR_SHARDS));

        // POLYPITE QUARTZ
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.POLYPITE_QUARTZ));
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.POLYPITE_ROSE_QUARTZ));
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.POLYPITE_SMOKY_QUARTZ));
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.POLYPITE_SULFUR_QUARTZ));

        // VEGETATION
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.QUARTZ_VEGETATION));

        return builder.build();
    }

    private static MobSpawnSettings createSpawnSettings() {
        net.minecraft.world.level.biome.MobSpawnSettings.Builder builder = new net.minecraft.world.level.biome.MobSpawnSettings.Builder();

        // SPAWNS
        builder.addSpawn(MobCategory.MONSTER, 50, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIFIED_PIGLIN, 4, 4));
        builder.addSpawn(MobCategory.MONSTER, 15, new MobSpawnSettings.SpawnerData(EntityType.MAGMA_CUBE, 2, 4));
        builder.addSpawn(MobCategory.MONSTER,  1, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 4, 4));
        builder.addSpawn(MobCategory.MONSTER, 20, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 4, 4));
        builder.addSpawn(MobCategory.CREATURE, 60, new MobSpawnSettings.SpawnerData(EntityType.STRIDER, 1, 2));

        return builder.build();
    }
}
