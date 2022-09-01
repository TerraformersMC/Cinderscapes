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
import net.minecraft.world.gen.feature.NetherPlacedFeatures;
import net.minecraft.world.gen.feature.OrePlacedFeatures;

public class AshyShoalsBiome {
    public static final MultiNoiseUtil.NoiseHypercube NOISE_POINT = MultiNoiseUtil.createNoiseHypercube(-0.35F, 0.0F, 0.2F, 0.0F, 0.35F, 0.0F, 0.0F);

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

        // DEFAULT MINECRAFT FEATURES
        builder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.NETHER_CAVE);
        vanillaNetherFeatures(builder);
        DefaultBiomeFeatures.addNetherMineables(builder);

        // ANCIENT DEBRIS
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapesPlacedFeatures.ORE_DEBRIS_LARGE_ASHY_SHOALS);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapesPlacedFeatures.ORE_DEBRIS_SMALL_ASHY_SHOALS);

        // REPLACE NETHERRACK
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapesPlacedFeatures.SOUL_SAND_ASHY_SHOALS);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapesPlacedFeatures.SOUL_SOIL_ASHY_SHOALS);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapesPlacedFeatures.GRAVEL_ASHY_SHOALS);

        // ASH PILES
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesPlacedFeatures.ASH_PILES);

        // FEATURES
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesPlacedFeatures.DEAD_TREES);

        // VEGETATION
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesPlacedFeatures.VEGETATION_ASHY_SHOALS);

        // BRAMBLE BERRY BUSHES
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesPlacedFeatures.BRAMBLE_BERRY_BUSHES);

        // TOP LAYER MODIFICATION
        builder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, CinderscapesPlacedFeatures.ASH_TOP_LAYER);

        return builder.build();
    }

    private static void vanillaNetherFeatures(GenerationSettings.Builder generationSettings) {
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.GLOWSTONE_EXTRA);
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.GLOWSTONE);
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, OrePlacedFeatures.ORE_MAGMA);
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
