package com.terraformersmc.cinderscapes.biome;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.cinderscapes.init.CinderscapesFeatures;
import com.terraformersmc.cinderscapes.surfacebuilder.CinderscapesSurfaceBuilders;
import net.minecraft.block.Blocks;
import net.minecraft.class_5179;
import net.minecraft.class_5183;
import net.minecraft.class_5186;
import net.minecraft.class_5187;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BiomeAdditionsSound;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.BiomeParticleConfig;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

public class LuminousGroveBiome extends Biome {
    public LuminousGroveBiome() {
        super((new Settings())
                .configureSurfaceBuilder(SurfaceBuilder.NETHER_FOREST, CinderscapesSurfaceBuilders.LUMINOUS_NYLIUM_CONFIG)
                .precipitation(Precipitation.NONE)
                .category(Category.NETHER)
                .depth(0.1F)
                .scale(0.2F)
                .temperature(2.0F)
                .downfall(0.0F)
                .effects((new BiomeEffects.Builder())
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .fogColor(15790202)
                        .particleConfig(
                                new BiomeParticleConfig(ParticleTypes.WARPED_SPORE, 0.01428F,
                                        (random) -> 0.0D,
                                        (random) -> (double)random.nextFloat() * -1.9D * (double)random.nextFloat() * 0.1D,
                                        (random) -> 0.0D))
                        .loopSound(SoundEvents.AMBIENT_WARPED_FOREST_LOOP)
                        .moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_WARPED_FOREST_MOOD, 6000, 8, 2.0D))
                        .additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_WARPED_FOREST_ADDITIONS, 0.0111D))
                        .build())
                .parent(null)
                .noises(ImmutableList.of(new MixedNoisePoint(0.0F, 0.0F, 0.0F, 0.0F, 1.0F))));

        DefaultBiomeFeatures.addNetherOres(this);

        this.addStructureFeature(Feature.NETHER_BRIDGE.configure(FeatureConfig.DEFAULT));
        this.addStructureFeature(Feature.field_23997.configure(new class_5186(class_5179.field_23994)));
        DefaultBiomeFeatures.addDefaultStructures(this);
        this.addStructureFeature(Feature.field_23996.configure(new class_5187(class_5183.class_5185.field_24006)));

        this.addCarver(GenerationStep.Carver.AIR, configureCarver(net.minecraft.world.gen.carver.Carver.NETHER_CAVE, new ProbabilityConfig(0.2F)));
        // Glowstone
        this.addFeature(net.minecraft.world.gen.GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.GLOWSTONE_BLOB.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.LIGHT_GEM_CHANCE.configure(new CountDecoratorConfig(40))));
        this.addFeature(net.minecraft.world.gen.GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.GLOWSTONE_BLOB.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(40, 0, 0, 128))));
        // Shroomlight Bushes
        this.addFeature(net.minecraft.world.gen.GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapesFeatures.SHROOMLIGHT_BUSH.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(5, 0, 0, 128))));

        this.addFeature(net.minecraft.world.gen.GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NETHERRACK, Blocks.MAGMA_BLOCK.getDefaultState(), 33)).createDecoratedFeature(Decorator.MAGMA.configure(new CountDecoratorConfig(4))));

        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, net.minecraft.world.gen.feature.Feature.HUGE_FUNGUS.configure(CinderscapesFeatures.LUMINOUS_FUNGUS_NOT_PLANTED_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP.configure(new CountDecoratorConfig(8))));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, net.minecraft.world.gen.feature.Feature.NETHER_FOREST_VEGETATION.configure(DefaultBiomeFeatures.NETHER_SPROUTS_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP.configure(new CountDecoratorConfig(4))));
    }
}
