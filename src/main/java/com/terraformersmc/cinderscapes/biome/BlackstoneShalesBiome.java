package com.terraformersmc.cinderscapes.biome;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.terraformersmc.cinderscapes.decorator.config.CountSafelistRangeDecoratorConfig;
import com.terraformersmc.cinderscapes.feature.config.SimpleStateFeatureConfig;
import com.terraformersmc.cinderscapes.init.CinderscapesDecorators;
import com.terraformersmc.cinderscapes.init.CinderscapesFeatures;
import com.terraformersmc.cinderscapes.init.CinderscapesSurfaces;
import com.terraformersmc.cinderscapes.surfacebuilder.config.EmptySurfaceConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BiomeAdditionsSound;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.BiomeParticleConfig;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.carver.Carver;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;

import java.util.Arrays;
import java.util.List;

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
                        .fogColor(6235392)
                        .loopSound(SoundEvents.AMBIENT_NETHER_WASTES_LOOP)
                        .moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 6000, 8, 2.0D))
                        .additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, 0.0111D))
                        .particleConfig(new BiomeParticleConfig(ParticleTypes.WHITE_ASH, 0.118093334F))
                        .build())
                .parent(null)
                .noises(ImmutableList.of(new MixedNoisePoint(0.15F, 0.05F, 0.25F, 0.05F, 0.2F))));

        // VEGETATION
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.BLACKSTONE_WEEPING_VINES.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(100, 0, 0, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.SOUL_SAND_CRIMSON_ROOTS_CONFIG).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(100, 0, 0, 128))));

        // SHALES
        List<BlockState> safelist = Arrays.asList(Blocks.CRIMSON_ROOTS.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), Blocks.BLACKSTONE.getDefaultState(), Blocks.SOUL_SOIL.getDefaultState(), Blocks.SOUL_SAND.getDefaultState());
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapesFeatures.SHALE_FEATURE.configure(new SimpleStateFeatureConfig(Blocks.BLACKSTONE.getDefaultState(), safelist)).createDecoratedFeature(CinderscapesDecorators.COUNT_FLOOR.configure(new CountSafelistRangeDecoratorConfig(2, 20, 20, 128, safelist))));

        // DEFAULT MINECRAFT FEATURES
        this.addStructureFeature(DefaultBiomeFeatures.NETHER_RUINED_PORTAL);
        this.addCarver(GenerationStep.Carver.AIR, configureCarver(net.minecraft.world.gen.carver.Carver.NETHER_CAVE, new ProbabilityConfig(0.2F)));
        this.addStructureFeature(DefaultBiomeFeatures.FORTRESS);
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, net.minecraft.world.gen.feature.Feature.SPRING_FEATURE.configure(DefaultBiomeFeatures.LAVA_SPRING_CONFIG).createDecoratedFeature(Decorator.COUNT_VERY_BIASED_RANGE.configure(new RangeDecoratorConfig(40, 8, 16, 256))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, net.minecraft.world.gen.feature.Feature.SPRING_FEATURE.configure(DefaultBiomeFeatures.MIXED_NETHER_SPRING_CONFIG).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(16, 4, 8, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, net.minecraft.world.gen.feature.Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.NETHER_FIRE_CONFIG).createDecoratedFeature(Decorator.FIRE.configure(new CountDecoratorConfig(10))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, net.minecraft.world.gen.feature.Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.SOUL_FIRE_CONFIG).createDecoratedFeature(Decorator.FIRE.configure(new CountDecoratorConfig(10))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, net.minecraft.world.gen.feature.Feature.GLOWSTONE_BLOB.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.LIGHT_GEM_CHANCE.configure(new CountDecoratorConfig(10))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, net.minecraft.world.gen.feature.Feature.GLOWSTONE_BLOB.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, net.minecraft.world.gen.feature.Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG).createDecoratedFeature(Decorator.CHANCE_RANGE.configure(new ChanceRangeDecoratorConfig(0.5F, 0, 0, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, net.minecraft.world.gen.feature.Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.RED_MUSHROOM_CONFIG).createDecoratedFeature(Decorator.CHANCE_RANGE.configure(new ChanceRangeDecoratorConfig(0.5F, 0, 0, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, net.minecraft.world.gen.feature.Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NETHERRACK, Blocks.MAGMA_BLOCK.getDefaultState(), 33)).createDecoratedFeature(Decorator.MAGMA.configure(new CountDecoratorConfig(4))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, net.minecraft.world.gen.feature.Feature.SPRING_FEATURE.configure(DefaultBiomeFeatures.ENCLOSED_NETHER_SPRING_CONFIG).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(32, 10, 20, 128))));
        DefaultBiomeFeatures.addNetherOres(this, 20, 32);
        DefaultBiomeFeatures.addAncientDebris(this);

        // SPAWNS
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.GHAST, 40, 1, 1));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.PIGLIN, 15, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ZOMBIFIED_PIGLIN, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.MAGMA_CUBE, 100, 2, 5));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.STRIDER, 60, 1, 2));
    }
}
