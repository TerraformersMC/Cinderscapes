package com.terraformersmc.cinderscapes.biome;

import com.terraformersmc.cinderscapes.init.CinderscapesPlacedFeatures;
import com.terraformersmc.cinderscapes.init.CinderscapesSoundEvents;
import com.terraformersmc.cinderscapes.mixin.OverworldBiomeCreatorAccessor;
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
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.MiscPlacedFeatures;
import net.minecraft.world.gen.feature.NetherPlacedFeatures;
import net.minecraft.world.gen.feature.OrePlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class QuartzCavernBiome {
    public static final MultiNoiseUtil.NoiseHypercube NOISE_POINT = MultiNoiseUtil.createNoiseHypercube(0.0F, 0.0F, 0.0F, 0.0F, 0.35F, 0.35F, 0.2F);

    public static Biome create() {
        return new Biome.Builder()
                .generationSettings(createGenerationSettings())
                .spawnSettings(createSpawnSettings())
                .precipitation(Biome.Precipitation.NONE)
                .category(Biome.Category.NETHER)
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
                        .music(MusicType.createIngameMusic(CinderscapesSoundEvents.QUARTZ_CAVERN_MUSIC))
                        .build())
                .build();
    }

    private static GenerationSettings createGenerationSettings() {
        GenerationSettings.Builder builder = new GenerationSettings.Builder();

        // DEFAULT MINECRAFT FEATURES
        builder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.NETHER_CAVE);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MiscPlacedFeatures.SPRING_LAVA);
        vanillaNetherFeatures(builder);
        DefaultBiomeFeatures.addAncientDebris(builder);

        // QUARTZ ORES
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapesPlacedFeatures.ORE_GOLD_QUARTZ_CAVERN);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapesPlacedFeatures.ORE_SULFUR_QUARTZ_CAVERN);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapesPlacedFeatures.ORE_QUARTZ_QUARTZ_CAVERN);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapesPlacedFeatures.ORE_ROSE_QUARTZ_QUARTZ_CAVERN);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapesPlacedFeatures.ORE_SMOKY_QUARTZ_QUARTZ_CAVERN);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapesPlacedFeatures.ORE_SULFUR_QUARTZ_QUARTZ_CAVERN);

        // QUARTZ SHARDS
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesPlacedFeatures.CEILING_SHARDS);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesPlacedFeatures.FLOOR_SHARDS);

        // POLYPITE QUARTZ
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesPlacedFeatures.POLYPITE_QUARTZ);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesPlacedFeatures.POLYPITE_ROSE_QUARTZ);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesPlacedFeatures.POLYPITE_SMOKY_QUARTZ);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesPlacedFeatures.POLYPITE_SULFUR_QUARTZ);

        // VEGETATION
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesPlacedFeatures.VEGETATION_QUARTZ_CAVERN);

        return builder.build();
    }

    private static void vanillaNetherFeatures(GenerationSettings.Builder generationSettings) {
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.SPRING_DELTA);
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.PATCH_FIRE);
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.PATCH_SOUL_FIRE);
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.GLOWSTONE_EXTRA);
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.GLOWSTONE);
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, VegetationPlacedFeatures.BROWN_MUSHROOM_NETHER);
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, VegetationPlacedFeatures.RED_MUSHROOM_NETHER);
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, OrePlacedFeatures.ORE_MAGMA);
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.SPRING_CLOSED_DOUBLE);
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
