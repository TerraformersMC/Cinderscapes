package com.terraformersmc.cinderscapes.biomes.quartzcavern;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.mixin.DefaultBiomeCreatorAccessor;
import net.fabricmc.fabric.api.biome.v1.NetherBiomes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.CountConfig;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

public class QuartzCavern {
    public static void onInitializeCommon() {
        QuartzCavernBlocks.onInitializeCommon();
        QuartzCavernItems.onInitializeCommon();
        QuartzCavernFeatures.onInitializeCommon();

        Cinderscapes.REGISTRATION_HELPER.register(constructBiome(), "quartz_cavern");
        NetherBiomes.addNetherBiome(RegistryKey.of(Registry.BIOME_KEY, Cinderscapes.id("quartz_cavern")),
                new Biome.MixedNoisePoint(0.0F, 0.0F, 0.35F, 0.35F, 0.2F));
    }

    public static void onInitializeClient() {
        QuartzCavernBlocks.onInitializeClient();
    }

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
                        .fogColor(3344392)
                        .skyColor(DefaultBiomeCreatorAccessor.callGetSkyColor(2.0f))
                        .particleConfig(new BiomeParticleConfig(ParticleTypes.FIREWORK, 0.0025F))
                        /*.loopSound()
                        .moodSound()
                        .additionsSound()
                        .music()*/
                        .build())
                .spawnSettings(new SpawnSettings.Builder()
                        .spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIFIED_PIGLIN, 50, 4, 4))
                        .spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.MAGMA_CUBE, 15, 2, 4))
                        .spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 1, 4, 4))
                        .spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.PIGLIN, 20, 4, 4))
                        .spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.STRIDER, 60, 1, 2))
                        .build())
                .generationSettings(new GenerationSettings.Builder()
                        .surfaceBuilder(Cinderscapes.REGISTRATION_HELPER.register(SurfaceBuilder.NETHER
                                .withConfig(SurfaceBuilder.NETHER_CONFIG),"quartz_cavern"))
                        .structureFeature(ConfiguredStructureFeatures.FORTRESS)
                        .structureFeature(ConfiguredStructureFeatures.BASTION_REMNANT)
                        .structureFeature(ConfiguredStructureFeatures.RUINED_PORTAL_NETHER)
                        .carver(GenerationStep.Carver.AIR, ConfiguredCarvers.NETHER_CAVE)
                        .feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SPRING_LAVA)
                        .feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.BROWN_MUSHROOM_NORMAL)
                        .feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.RED_MUSHROOM_NORMAL)
                        .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.SPRING_OPEN)
                        .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.PATCH_FIRE)
                        .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.PATCH_SOUL_FIRE)
                        .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.GLOWSTONE_EXTRA)
                        .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.GLOWSTONE)
                        .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.ORE_MAGMA)
                        .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.SPRING_CLOSED)
                        .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.ORE_GRAVEL_NETHER)
                        .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.ORE_BLACKSTONE)
                        .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.ORE_GOLD_NETHER)
                        .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.ORE_QUARTZ_NETHER)
                        .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.ORE_DEBRIS_LARGE)
                        .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.ORE_DEBRIS_SMALL)
                        .feature(GenerationStep.Feature.VEGETAL_DECORATION, Cinderscapes.REGISTRATION_HELPER
                                .register(QuartzCavernFeatures.CRYSTAL_SHARD_FEATURE
                                        .configure(QuartzCavernFeatures.QUARTZ_CIELING)
                                        .decorate(Decorator.COUNT_MULTILAYER
                                                .configure(new CountConfig(1))), "quartz_cavern/white/cieling_crystal"))
                        .feature(GenerationStep.Feature.VEGETAL_DECORATION, Cinderscapes.REGISTRATION_HELPER
                                .register(QuartzCavernFeatures.CRYSTAL_SHARD_FEATURE
                                        .configure(QuartzCavernFeatures.QUARTZ_FLOOR)
                                        .decorate(Decorator.COUNT_MULTILAYER
                                                .configure(new CountConfig(1))), "quartz_cavern/white/floor_crystal"))
                        .feature(GenerationStep.Feature.VEGETAL_DECORATION, Cinderscapes.REGISTRATION_HELPER
                                .register(QuartzCavernFeatures.CRYSTAL_SHARD_FEATURE
                                        .configure(QuartzCavernFeatures.ROSE_QUARTZ_CIELING)
                                        .decorate(Decorator.COUNT_MULTILAYER
                                                .configure(new CountConfig(1))), "quartz_cavern/rose/cieling_crystal"))
                        .feature(GenerationStep.Feature.VEGETAL_DECORATION, Cinderscapes.REGISTRATION_HELPER
                                .register(QuartzCavernFeatures.CRYSTAL_SHARD_FEATURE
                                        .configure(QuartzCavernFeatures.ROSE_QUARTZ_FLOOR)
                                        .decorate(Decorator.COUNT_MULTILAYER
                                                .configure(new CountConfig(1))), "quartz_cavern/rose/floor_crystal"))
                        .feature(GenerationStep.Feature.VEGETAL_DECORATION, Cinderscapes.REGISTRATION_HELPER
                                .register(QuartzCavernFeatures.CRYSTAL_SHARD_FEATURE
                                        .configure(QuartzCavernFeatures.SMOKY_QUARTZ_CIELING)
                                        .decorate(Decorator.COUNT_MULTILAYER
                                                .configure(new CountConfig(1))), "quartz_cavern/smoky/cieling_crystal"))
                        .feature(GenerationStep.Feature.VEGETAL_DECORATION, Cinderscapes.REGISTRATION_HELPER
                                .register(QuartzCavernFeatures.CRYSTAL_SHARD_FEATURE
                                        .configure(QuartzCavernFeatures.SMOKY_QUARTZ_FLOOR)
                                        .decorate(Decorator.COUNT_MULTILAYER
                                                .configure(new CountConfig(1))), "quartz_cavern/smoky/floor_crystal"))
                        .feature(GenerationStep.Feature.VEGETAL_DECORATION, Cinderscapes.REGISTRATION_HELPER
                                .register(QuartzCavernFeatures.CRYSTAL_SHARD_FEATURE
                                        .configure(QuartzCavernFeatures.SULFUR_QUARTZ_CIELING)
                                        .decorate(Decorator.COUNT_MULTILAYER
                                                .configure(new CountConfig(1))), "quartz_cavern/sulfur/cieling_crystal"))
                        .feature(GenerationStep.Feature.VEGETAL_DECORATION, Cinderscapes.REGISTRATION_HELPER
                                .register(QuartzCavernFeatures.CRYSTAL_SHARD_FEATURE
                                        .configure(QuartzCavernFeatures.SULFUR_QUARTZ_FLOOR)
                                        .decorate(Decorator.COUNT_MULTILAYER
                                                .configure(new CountConfig(1))), "quartz_cavern/sulfur/floor_crystal"))
                        .build())
                .build();
    }
}
