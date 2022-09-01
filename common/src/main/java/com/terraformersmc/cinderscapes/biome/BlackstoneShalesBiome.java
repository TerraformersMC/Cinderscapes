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
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class BlackstoneShalesBiome {
    public static final MultiNoiseUtil.NoiseHypercube NOISE_POINT = MultiNoiseUtil.createNoiseHypercube(0.15F, 0.05F, 0.2F, 0.0F, 0.25F, 0.05F, 0.0F);

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
                        .fogColor(6235392)
                        .loopSound(SoundEvents.AMBIENT_NETHER_WASTES_LOOP)
                        .moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 6000, 8, 2.0D))
                        .additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, 0.0111D))
                        .music(MusicType.createIngameMusic(CinderscapesSoundEvents.BLACKSTONE_SHALES_MUSIC))
                        .particleConfig(new BiomeParticleConfig(ParticleTypes.WHITE_ASH, 0.118093334F))
                        .build())
                .build();
    }

    private static GenerationSettings createGenerationSettings() {
        GenerationSettings.Builder builder = new GenerationSettings.Builder();

        // DEFAULT MINECRAFT FEATURES
        builder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.NETHER_CAVE);
        vanillaNetherFeatures(builder);
        DefaultBiomeFeatures.addAncientDebris(builder);

        // VEGETATION
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapesPlacedFeatures.BLACKSTONE_SHALE_WEEPING_VINES);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapesPlacedFeatures.PATCH_CRIMSON_ROOTS);

        // NETHERRACK REPLACERS
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapesPlacedFeatures.SOUL_SAND_BLACKSTONE_SHALES);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapesPlacedFeatures.SOUL_SOIL_BLACKSTONE_SHALES);

        // SHALES
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesPlacedFeatures.SHALES);

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
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, OrePlacedFeatures.ORE_GOLD_DELTAS);
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, OrePlacedFeatures.ORE_QUARTZ_DELTAS);
    }

    private static SpawnSettings createSpawnSettings() {

        SpawnSettings.Builder builder = new SpawnSettings.Builder();

        // SPAWNS
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.GHAST, 40, 1, 1));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.PIGLIN, 15, 4, 4));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIFIED_PIGLIN, 100, 4, 4));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.MAGMA_CUBE, 100, 2, 5));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.STRIDER, 60, 1, 2));

        return builder.build();
    }
}
