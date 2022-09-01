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

public class LuminousGroveBiome {
    public static final MultiNoiseUtil.NoiseHypercube NOISE_POINT = MultiNoiseUtil.createNoiseHypercube(0.35F, 0.35F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2F);

    public static Biome create() {
        return new Biome.Builder()
                .generationSettings(createGenerationSettings())
                .spawnSettings(createSpawnSettings())
                .precipitation(Biome.Precipitation.NONE)
                .category(Biome.Category.NETHER)
                .temperature(2.0F)
                .downfall(0.0F)
                .effects((new BiomeEffects.Builder())
                        .skyColor(OverworldBiomeCreatorAccessor.cinderscapes$callGetSkyColor(2.0f))
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

        // DEFAULT MINECRAFT FEATURES
        builder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.NETHER_CAVE);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.GLOWSTONE_EXTRA);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.GLOWSTONE);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, OrePlacedFeatures.ORE_MAGMA);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.SPRING_CLOSED);
        DefaultBiomeFeatures.addNetherMineables(builder);

        // UMBRAL FUNGUS
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesPlacedFeatures.CANOPIED_HUGE_FUNGUS);

        // SHROOMLIGHT BUSHES
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesPlacedFeatures.SHROOMLIGHT_BUSH);

        // VEGETATION
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesPlacedFeatures.VEGETATION_LUMINOUS_GROWTH);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesPlacedFeatures.LUMINOUS_POD);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesPlacedFeatures.TALL_PHOTOFERN);

        // VINES
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesPlacedFeatures.UMBRAL_VINE);

        return builder.build();
    }

    private static SpawnSettings createSpawnSettings() {

        SpawnSettings.Builder builder = new SpawnSettings.Builder();

        // SPAWNS
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.STRIDER, 60, 1, 2));

        return builder.build();
    }
}
