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
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.NetherPlacedFeatures;
import net.minecraft.world.gen.feature.OrePlacedFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;

public class LuminousGroveBiome {
    public static final MultiNoiseUtil.NoiseHypercube NOISE_POINT = MultiNoiseUtil.createNoiseHypercube(0.35F, 0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.225F);

    public static Biome create(Registerable<Biome> registerable) {
        return new Biome.Builder()
                .generationSettings(createGenerationSettings(registerable))
                .spawnSettings(createSpawnSettings())
                .precipitation(false)
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
                        .music(MusicType.createIngameMusic(Registries.SOUND_EVENT.getEntry(CinderscapesSoundEvents.LUMINOUS_GROVE_MUSIC)))
                        .build())
                .build();
    }

    private static GenerationSettings createGenerationSettings(Registerable<Biome> registerable) {
        RegistryEntryLookup<ConfiguredCarver<?>> configuredCarvers = registerable.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);
        RegistryEntryLookup<PlacedFeature> placedFeatures = registerable.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        GenerationSettings.LookupBackedBuilder builder = new GenerationSettings.LookupBackedBuilder(placedFeatures, configuredCarvers);

        // DEFAULT MINECRAFT FEATURES
        builder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.NETHER_CAVE);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.GLOWSTONE_EXTRA);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.GLOWSTONE);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, OrePlacedFeatures.ORE_MAGMA);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.SPRING_CLOSED);
        DefaultBiomeFeatures.addNetherMineables(builder);

        // UMBRAL FUNGUS
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.CANOPIED_HUGE_FUNGUS));

        // SHROOMLIGHT BUSHES
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.SHROOMLIGHT_BUSHES));

        // VEGETATION
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.LUMINOUS_VEGETATION));
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.LUMINOUS_PODS));
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.TALL_PHOTOFERNS));

        // VINES
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, placedFeatures.getOrThrow(CinderscapesPlacedFeatures.UMBRAL_VINES));

        return builder.build();
    }

    private static SpawnSettings createSpawnSettings() {
        SpawnSettings.Builder builder = new SpawnSettings.Builder();

        // SPAWNS
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.STRIDER, 60, 1, 2));

        return builder.build();
    }
}
