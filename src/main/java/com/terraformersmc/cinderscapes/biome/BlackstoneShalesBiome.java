package com.terraformersmc.cinderscapes.biome;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.terraformersmc.cinderscapes.init.CinderscapesFeatures;
import com.terraformersmc.cinderscapes.init.CinderscapesSurfaces;
import com.terraformersmc.cinderscapes.surfacebuilder.config.EmptySurfaceConfig;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.BiomeParticleConfig;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.carver.Carver;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;

// TODO: Check
// TODO: Finalize mob spawns
public class BlackstoneShalesBiome extends Biome {
    public BlackstoneShalesBiome() {
        super(new Biome.Settings()
                .configureSurfaceBuilder(CinderscapesSurfaces.BLACKSTONE_SHALES, new EmptySurfaceConfig())
                .precipitation(Precipitation.NONE)
                .category(Category.NETHER)
                .depth(0.1F)
                .scale(0.2F)
                .temperature(2.0F)
                .downfall(0.0F)
                .effects(new BiomeEffects.Builder()
                        .waterColor(4159204)
                        .waterFogColor(4341314)
                        .fogColor(8470016)
                        .particleConfig(
                                new BiomeParticleConfig(ParticleTypes.ASH, 0.00625F,
                                        (random) -> 0.0D,
                                        (random) -> 0.0D,
                                        (random) -> 0.0D))
                        .build())
                .parent(null)
                .noises(ImmutableList.of(new MixedNoisePoint(0.0F, 0.0F, -0.5F, 0.0F, 1.0F))));

        this.addCarver(GenerationStep.Carver.AIR, configureCarver(Carver.NETHER_CAVE, new ProbabilityConfig(0.2F)));
        this.addFeature(GenerationStep.Feature.LOCAL_MODIFICATIONS, Feature.DELTA_FEATURE.configure(DefaultBiomeFeatures.field_23858).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP.configure(new CountDecoratorConfig(10))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.NETHERRACK_REPLACE_BLOBS.configure(DefaultBiomeFeatures.field_23857).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(75, 0, 0, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.NETHER_BRIDGE.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.NOPE.configure(DecoratorConfig.DEFAULT)));
        // Fire on Blackstone
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.configure(new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.FIRE.getDefaultState()), new SimpleBlockPlacer()).tries(64).whitelist(ImmutableSet.of(Blocks.BLACKSTONE)).cannotProject().build()).createDecoratedFeature(Decorator.FIRE.configure(new CountDecoratorConfig(10))));
        // Glowstone
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.GLOWSTONE_BLOB.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.LIGHT_GEM_CHANCE.configure(new CountDecoratorConfig(10))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.GLOWSTONE_BLOB.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 128))));
        // Vegetation
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG).createDecoratedFeature(Decorator.CHANCE_RANGE.configure(new ChanceRangeDecoratorConfig(0.5F, 0, 0, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.RED_MUSHROOM_CONFIG).createDecoratedFeature(Decorator.CHANCE_RANGE.configure(new ChanceRangeDecoratorConfig(0.5F, 0, 0, 128))));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.BLACKSTONE_WEEPING_VINES.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(100, 0, 0, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.SOUL_SAND_CRIMSON_ROOTS_CONFIG).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(100, 0, 0, 128))));
        // Ores
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NETHERRACK, Blocks.NETHER_QUARTZ_ORE.getDefaultState(), 14)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(16, 10, 20, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NETHERRACK, Blocks.MAGMA_BLOCK.getDefaultState(), 33)).createDecoratedFeature(Decorator.MAGMA.configure(new CountDecoratorConfig(4))));
        // Springs
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.SPRING_FEATURE.configure(DefaultBiomeFeatures.ENCLOSED_NETHER_SPRING_CONFIG).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(32, 10, 20, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.SPRING_FEATURE.configure(DefaultBiomeFeatures.field_23851).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(16, 4, 8, 128))));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.SPRING_FEATURE.configure(DefaultBiomeFeatures.LAVA_SPRING_CONFIG).createDecoratedFeature(Decorator.COUNT_VERY_BIASED_RANGE.configure(new RangeDecoratorConfig(40, 8, 16, 256))));
        // Fossils
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.NETHER_FOSSIL.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.NOPE.configure(DecoratorConfig.DEFAULT)));
        this.addStructureFeature(Feature.NETHER_FOSSIL.configure(FeatureConfig.DEFAULT));
        // Shales
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapesFeatures.BLACKSTONE_SHALE.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(15, 0, 0, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapesFeatures.BLACKSTONE_LAVA_SHALE.configure(FeatureConfig.DEFAULT).createDecoratedFeature(   Decorator.CHANCE_RANGE.configure(new ChanceRangeDecoratorConfig(0.25f, 0, 0, 128))));
        // Entity Spawns
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.GHAST, 40, 1, 1));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.SKELETON, 2, 5, 5));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.ENDERMAN, 1, 4, 4));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.MAGMA_CUBE, 40, 2, 5));
        this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(EntityType.STRIDER, 60, 2, 4));
    }
}
