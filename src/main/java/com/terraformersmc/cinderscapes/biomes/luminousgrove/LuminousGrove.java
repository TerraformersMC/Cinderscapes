package com.terraformersmc.cinderscapes.biomes.luminousgrove;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.mixin.DefaultBiomeCreatorAccessor;
import net.fabricmc.fabric.api.biome.v1.NetherBiomes;
import net.minecraft.block.Blocks;
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
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class LuminousGrove {
    public static void onInitializeCommon() {
        LuminousGroveBlocks.onInitializeCommon();
        LuminousGroveItems.onInitializeCommon();
        LuminousGroveFeatures.onInitializeCommon();

        Cinderscapes.REGISTRATION_HELPER.register(constructBiome(), "luminous_grove");
        NetherBiomes.addNetherBiome(RegistryKey.of(Registry.BIOME_KEY, Cinderscapes.id("luminous_grove")),
                new Biome.MixedNoisePoint(0.35F, 0.35F, 0.0F, 0.0F, 0.2F));
    }

    public static void onInitializeClient() {
        LuminousGroveBlocks.onInitializeClient();
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
                        .waterFogColor(329011)
                        .fogColor(1705242)
                        .skyColor(DefaultBiomeCreatorAccessor.callGetSkyColor(2.0f))
                        .particleConfig(new BiomeParticleConfig(ParticleTypes.WARPED_SPORE, 0.01428f))
                        /*.loopSound()
                        .moodSound()
                        .additionsSound()
                        .music()*/
                        .build())
                .spawnSettings(new SpawnSettings.Builder()
                        .spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 1, 4, 4))
                        .spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.STRIDER, 60, 1, 2))
                        .spawnCost(EntityType.ENDERMAN, 1.0D, 0.12D)
                        .build())
                .generationSettings(new GenerationSettings.Builder()
                        .surfaceBuilder(Cinderscapes.REGISTRATION_HELPER.register(SurfaceBuilder.NETHER_FOREST
                                .withConfig(new TernarySurfaceConfig(
                                        LuminousGroveBlocks.UMBRAL_NYLIUM.getDefaultState(),
                                        Blocks.NETHERRACK.getDefaultState(),
                                        LuminousGroveBlocks.UMBRAL_WART_BLOCK.getDefaultState())),"luminous_grove"))
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
                            .register(LuminousGroveFeatures.CANOPIED_HUGE_FUNGUS
                                    .configure(LuminousGroveFeatures.UMBRAL_FUNGUS_NOT_PLANTED_CONFIG)
                                    .decorate(Decorator.COUNT_MULTILAYER
                                            .configure(new CountConfig(4))), "luminous_grove/umbral_fungi"))
                        .feature(GenerationStep.Feature.VEGETAL_DECORATION, Cinderscapes.REGISTRATION_HELPER
                            .register(Feature.NETHER_FOREST_VEGETATION
                                    .configure(LuminousGroveFeatures.VEGETATION_CONFIG)
                                    .decorate(Decorator.COUNT_MULTILAYER
                                            .configure(new CountConfig(10))), "luminous_grove/vegetation"))
                        .feature(GenerationStep.Feature.VEGETAL_DECORATION, Cinderscapes.REGISTRATION_HELPER
                                .register(Feature.NETHER_FOREST_VEGETATION
                                        .configure(LuminousGroveFeatures.PHOTOFERNS)
                                        .decorate(Decorator.COUNT_MULTILAYER
                                                .configure(new CountConfig(3))), "luminous_grove/photoferns"))
                        .feature(GenerationStep.Feature.VEGETAL_DECORATION, Cinderscapes.REGISTRATION_HELPER
                                .register(Feature.NETHER_FOREST_VEGETATION
                                        .configure(LuminousGroveFeatures.LUMINOUS_POD)
                                        .decorate(Decorator.COUNT_MULTILAYER
                                                .configure(new CountConfig(1))), "luminous_grove/pods"))
                        .feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.NETHER_SPROUTS)
                        .build())
                .build();
    }
}
