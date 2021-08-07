package com.terraformersmc.cinderscapes.biomes.blackstoneshales;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.biomes.blackstoneshales.feature.config.ShaleFeatureConfig;
import com.terraformersmc.cinderscapes.init.CinderscapesFeatures;
import com.terraformersmc.cinderscapes.mixin.DefaultBiomeCreatorAccessor;
import net.fabricmc.fabric.api.biome.v1.NetherBiomes;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilders;

public class BlackstoneShales {
    public static void onInitializeCommon() {
        Cinderscapes.REGISTRATION_HELPER.register(constructBiome(), "blackstone_shales");
        NetherBiomes.addNetherBiome(RegistryKey.of(Registry.BIOME_KEY, Cinderscapes.id("blackstone_shales")),
                new Biome.MixedNoisePoint(0.15F, 0.05F, 0.25F, 0.05F, 0.2F));
    }

    public static void onInitializeClient() { }

    public static Biome constructBiome() {
        return new Biome.Builder()
                .precipitation(Biome.Precipitation.NONE)
                .category(Biome.Category.NETHER)
                .depth(0.1f)
                .scale(0.2f)
                .temperature(2.0f)
                .downfall(0.0f)
                .effects(new BiomeEffects.Builder()
                        .waterColor(4159204)
                        .waterFogColor(4341314)
                        .fogColor(6235392)
                        .skyColor(DefaultBiomeCreatorAccessor.callGetSkyColor(2.0f))
                        .particleConfig(new BiomeParticleConfig(ParticleTypes.WHITE_ASH, 0.118093334F))
                        /*.loopSound()
                        .moodSound()
                        .additionsSound()
                        .music()*/
                        .build())
                .spawnSettings(new SpawnSettings.Builder()
                        .spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.GHAST, 40, 1, 1))
                        .spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.MAGMA_CUBE, 100, 2, 5))
                        .spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.STRIDER, 60, 1, 2))
                        .spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIFIED_PIGLIN, 50, 4, 4))
                        .spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.PIGLIN, 20, 4, 4))
                        .build())
                .generationSettings(new GenerationSettings.Builder()
                        .surfaceBuilder(ConfiguredSurfaceBuilders.NETHER)
                        .structureFeature(ConfiguredStructureFeatures.FORTRESS)
                        .structureFeature(ConfiguredStructureFeatures.BASTION_REMNANT)
                        .structureFeature(ConfiguredStructureFeatures.RUINED_PORTAL_NETHER)
                        .carver(GenerationStep.Carver.AIR, ConfiguredCarvers.NETHER_CAVE)
                        .feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SPRING_LAVA_DOUBLE)
                        .feature(GenerationStep.Feature.VEGETAL_DECORATION, Cinderscapes.REGISTRATION_HELPER
                                .register(BlackstoneShalesFeatures.BLACKSTONE_WEEPING_VINES
                                        .configure(FeatureConfig.DEFAULT)
                                        .range(ConfiguredFeatures.Decorators.BOTTOM_TO_TOP)
                                        .spreadHorizontally()
                                        .repeat(256), "blackstone_shales/weeping_vines"))
                        .feature(GenerationStep.Feature.VEGETAL_DECORATION, Cinderscapes.REGISTRATION_HELPER
                                .register(BlackstoneShalesFeatures.SHALE
                                        .configure(new ShaleFeatureConfig(Blocks.BLACKSTONE.getDefaultState(), 7, 12))
                                        .range(ConfiguredFeatures.Decorators.BOTTOM_TO_TOP)
                                        .repeat(70), "blackstone_shales/shale"))
                        .feature(GenerationStep.Feature.VEGETAL_DECORATION, Cinderscapes.REGISTRATION_HELPER
                                .register(ConfiguredFeatures.PATCH_CRIMSON_ROOTS.repeat(128), "blackstone_shales/crimson_roots"))
                        .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, Cinderscapes.REGISTRATION_HELPER
                                .register(CinderscapesFeatures.SOUL_SOIL_BLOBS.repeat(20), "blackstone_shales/soul_soil_blobs"))
                        .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, Cinderscapes.REGISTRATION_HELPER
                                .register(CinderscapesFeatures.SOUL_SAND_BLOBS.repeat(15), "blackstone_shales/soul_sand_blobs"))
                        .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, Cinderscapes.REGISTRATION_HELPER
                                .register(CinderscapesFeatures.BLACKSTONE_BLOBS.repeat(15), "blackstone_shales/blackstone_blobs"))
                        .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, Cinderscapes.REGISTRATION_HELPER
                                .register(CinderscapesFeatures.BASALT_BLOBS.repeat(10), "blackstone_shales/basalt_blobs"))
                        .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.SPRING_OPEN)
                        .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.PATCH_FIRE)
                        .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.PATCH_SOUL_FIRE)
                        .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.GLOWSTONE_EXTRA)
                        .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.GLOWSTONE)
                        .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.BROWN_MUSHROOM_NETHER)
                        .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.RED_MUSHROOM_NETHER)
                        .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.ORE_MAGMA)
                        .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.SPRING_CLOSED_DOUBLE)
                        .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.ORE_GOLD_DELTAS)
                        .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.ORE_QUARTZ_DELTAS)
                        .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.ORE_DEBRIS_LARGE)
                        .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.ORE_DEBRIS_SMALL)
                        .build())
                .build();
    }

}
