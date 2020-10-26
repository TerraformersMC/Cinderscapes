package com.terraformersmc.cinderscapes.biome;

import java.util.Arrays;
import java.util.List;

import com.terraformersmc.cinderscapes.client.CinderscapesSoundEvents;
import com.terraformersmc.cinderscapes.init.CinderscapeConfiguredFeatures;
import com.terraformersmc.cinderscapes.mixin.DefaultBiomeCreatorAccessor;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
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
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilders;

// TODO: Check
public class QuartzCanyonBiome {

    public static final Biome.MixedNoisePoint NOISE_POINT = new Biome.MixedNoisePoint(0.0F, 0.0F, 0.35F, 0.35F, 0.2F);

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
                        .fogColor(3344392)
                        .particleConfig(new BiomeParticleConfig(ParticleTypes.FIREWORK, 0.0025F))
                        .loopSound(SoundEvents.AMBIENT_NETHER_WASTES_LOOP)
                        .moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_NETHER_WASTES_MOOD, 6000, 8, 2.0D))
                        .additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_NETHER_WASTES_ADDITIONS, 0.0111D))
                        .music(MusicType.createIngameMusic(CinderscapesSoundEvents.QUARTZ_CANYON_MUSIC))
                        .build())
                .build();
    }

    private static GenerationSettings createGenerationSettings() {
        GenerationSettings.Builder builder = new GenerationSettings.Builder();
        builder.surfaceBuilder(ConfiguredSurfaceBuilders.NETHER);

        // DEFAULT MINECRAFT FEATURES
        builder.structureFeature(ConfiguredStructureFeatures.RUINED_PORTAL_NETHER);
        builder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.NETHER_CAVE);
        builder.structureFeature(ConfiguredStructureFeatures.FORTRESS);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SPRING_LAVA_DOUBLE);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.SPRING_DELTA);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.PATCH_FIRE);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.PATCH_SOUL_FIRE);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.GLOWSTONE_EXTRA);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.GLOWSTONE);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.BROWN_MUSHROOM_NETHER);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.RED_MUSHROOM_NETHER);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.ORE_MAGMA);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.SPRING_CLOSED_DOUBLE);
        DefaultBiomeFeatures.addAncientDebris(builder);

        // QUARTZ ORES
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapeConfiguredFeatures.ORE_QUARTZ_QUARTZ_CANYON);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapeConfiguredFeatures.ORE_SULFUR_QUARTZ_CANYON);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapeConfiguredFeatures.ORE_GOLD_QUARTZ_CANYON);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapeConfiguredFeatures.ORE_SMOKY_QUARTZ_QUARTZ_CANYON);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapeConfiguredFeatures.ORE_ROSE_QUARTZ_QUARTZ_CANYON);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapeConfiguredFeatures.ORE_SULFUR_QUARTZ_QUARTZ_CANYON);

        // VEGETATION
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapeConfiguredFeatures.VEGETATION_QUARTZ_CANYON);

        // QUARTZ SHARDS

        List<BlockState> safelist = Arrays.asList(Blocks.NETHERRACK.getDefaultState(), Blocks.NETHER_QUARTZ_ORE.getDefaultState());

        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapeConfiguredFeatures.CEILING_SHARD_QUARTZ);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapeConfiguredFeatures.FLOOR_SHARD_QUARTZ);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapeConfiguredFeatures.CEILING_SHARD_ROSE_QUARTZ);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapeConfiguredFeatures.FLOOR_SHARD_ROSE_QUARTZ);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapeConfiguredFeatures.CEILING_SHARD_SMOKY_QUARTZ);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapeConfiguredFeatures.FLOOR_SHARD_SMOKY_QUARTZ);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapeConfiguredFeatures.CEILING_SHARD_SULFUR_QUARTZ);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapeConfiguredFeatures.FLOOR_SHARD_SULFUR_QUARTZ);

        // POLYPITE QUARTZ
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapeConfiguredFeatures.POLYPITE_QUARTZ);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapeConfiguredFeatures.POLYPITE_SULFUR_QUARTZ);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapeConfiguredFeatures.POLYPITE_ROSE_QUARTZ);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapeConfiguredFeatures.POLYPITE_SMOKY_QUARTZ);

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
