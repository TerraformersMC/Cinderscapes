package com.terraformersmc.cinderscapes.biome;

import com.terraformersmc.cinderscapes.init.CinderscapesPlacedFeatures;
import com.terraformersmc.cinderscapes.init.CinderscapesSoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.attribute.AmbientAdditionsSettings;
import net.minecraft.world.attribute.AmbientMoodSettings;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.attribute.*;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.NetherPlacements;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;
import java.util.Optional;

public class AshyShoalsBiome {
    public static final Climate.ParameterPoint NOISE_POINT = Climate.parameters(-0.35F, -0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2F);

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
                        .set(EnvironmentAttributes.AMBIENT_PARTICLES, List.of(new AmbientParticle(ParticleTypes.ASH, 0.625F)))
                        .set(EnvironmentAttributes.AMBIENT_SOUNDS, new AmbientSounds(Optional.of(SoundEvents.AMBIENT_NETHER_WASTES_LOOP), Optional.of(new AmbientMoodSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D)), List.of(new AmbientAdditionsSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, 0.0111D))))
                        .set(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(CinderscapesSoundEvents.ASHY_SHOALS_MUSIC))
                        .set(EnvironmentAttributes.FOG_COLOR, 0x363636)
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
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.GLOWSTONE_EXTRA);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.GLOWSTONE);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, OrePlacements.ORE_MAGMA);
        BiomeDefaultFeatures.addNetherDefaultOres(builder);

        // ANCIENT DEBRIS
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.DEBRIS_ORE_LARGE));
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.DEBRIS_ORE_SMALL));

        // REPLACE NETHERRACK
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.ASHY_SOUL_SAND));
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.ASHY_SOUL_SOIL));
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.ASHY_GRAVEL));

        // ASH PILES
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.ASH_PILES));

        // FEATURES
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.DEAD_TREES));

        // VEGETATION
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.ASHY_VEGETATION));

        // BRAMBLE BERRY BUSHES
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.BRAMBLE_BERRY_BUSHES));

        // TOP LAYER MODIFICATION
        builder.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.ASH_TOP_LAYER));

        return builder.build();
    }

    private static MobSpawnSettings createSpawnSettings() {
        net.minecraft.world.level.biome.MobSpawnSettings.Builder builder = new net.minecraft.world.level.biome.MobSpawnSettings.Builder();

        // SPAWNS
        builder.addSpawn(MobCategory.MONSTER,  1, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIFIED_PIGLIN, 1, 4));
        builder.addSpawn(MobCategory.MONSTER,  1, new MobSpawnSettings.SpawnerData(EntityType.ZOGLIN, 1, 1));
        builder.addSpawn(MobCategory.MONSTER,  1, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 4, 4));
        builder.addSpawn(MobCategory.CREATURE, 60, new MobSpawnSettings.SpawnerData(EntityType.STRIDER, 1, 2));
        builder.addSpawn(MobCategory.MONSTER, 20, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 5, 5));
        builder.addSpawn(MobCategory.MONSTER, 50, new MobSpawnSettings.SpawnerData(EntityType.GHAST, 4, 4));

        return builder.build();
    }
}
