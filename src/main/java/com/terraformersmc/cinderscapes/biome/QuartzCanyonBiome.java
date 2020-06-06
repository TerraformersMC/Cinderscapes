package com.terraformersmc.cinderscapes.biome;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.cinderscapes.feature.config.ShardFeatureConfig;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.init.CinderscapesDecorators;
import com.terraformersmc.cinderscapes.init.CinderscapesFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BiomeAdditionsSound;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.BiomeParticleConfig;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

import java.util.Arrays;
import java.util.List;

// TODO: Check
public class QuartzCanyonBiome extends Biome {

    private static List<BlockState> SHARD_WHITELIST = Arrays.asList(Blocks.NETHERRACK.getDefaultState(), Blocks.AIR.getDefaultState(), Blocks.GRAVEL.getDefaultState(), Blocks.NETHER_QUARTZ_ORE.getDefaultState(), Blocks.SOUL_SAND.getDefaultState());

    public QuartzCanyonBiome() {
        super(new Biome.Settings()
                .configureSurfaceBuilder(SurfaceBuilder.NETHER, SurfaceBuilder.NETHER_CONFIG)
                .precipitation(Biome.Precipitation.NONE)
                .category(Biome.Category.NETHER)
                .depth(0.1F)
                .scale(0.2F)
                .temperature(2.0F)
                .downfall(0.0F)
                .effects(new BiomeEffects.Builder()
                        .waterColor(4159204)
                        .waterFogColor(4341314)
                        .fogColor(6840176)
                        .particleConfig(new BiomeParticleConfig(ParticleTypes.FIREWORK, 0.00625F))
                        .loopSound(SoundEvents.AMBIENT_NETHER_WASTES_LOOP)
                        .moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 6000, 8, 2.0D))
                        .additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, 0.0111D))
                        .build())
                .parent(null)
                .noises(ImmutableList.of(new Biome.MixedNoisePoint(0.0F, 0.0F, 0.35F, 0.35F, 0.2F))));




        // Default Nether Biome Additions







        // QUARTZ ORES
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NETHERRACK, Blocks.NETHER_QUARTZ_ORE.getDefaultState(), 14)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(32, 10, 20, 256))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NETHERRACK, CinderscapesBlocks.SMOKY_QUARTZ_ORE.getDefaultState(), 14)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(32, 10, 20, 256))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NETHERRACK, CinderscapesBlocks.ROSE_QUARTZ_ORE.getDefaultState(), 14)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(32, 10, 20, 256))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NETHERRACK, CinderscapesBlocks.SULFUR_QUARTZ_ORE.getDefaultState(), 14)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(32, 10, 20, 256))));

        // VEGETATION
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.VEGETATION.configure(CinderscapesFeatures.QUARTZ_CANYON_VEGETATION_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP.configure(new CountDecoratorConfig(1))));

        // QUARTZ SHARDS
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.CEILING_SHARD.configure(new ShardFeatureConfig(CinderscapesBlocks.CRYSTALLINE_QUARTZ.getDefaultState(), SHARD_WHITELIST)).createDecoratedFeature(CinderscapesDecorators.COUNT_CEILING.configure(new CountDecoratorConfig(1))));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.FLOOR_SHARD.configure(new ShardFeatureConfig(CinderscapesBlocks.CRYSTALLINE_QUARTZ.getDefaultState(), SHARD_WHITELIST)).createDecoratedFeature(CinderscapesDecorators.COUNT_FLOOR.configure(new CountDecoratorConfig(1))));

        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.CEILING_SHARD.configure(new ShardFeatureConfig(CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ.getDefaultState(), SHARD_WHITELIST)).createDecoratedFeature(CinderscapesDecorators.COUNT_CEILING.configure(new CountDecoratorConfig(1))));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.FLOOR_SHARD.configure(new ShardFeatureConfig(CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ.getDefaultState(), SHARD_WHITELIST)).createDecoratedFeature(CinderscapesDecorators.COUNT_FLOOR.configure(new CountDecoratorConfig(1))));

        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.CEILING_SHARD.configure(new ShardFeatureConfig(CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ.getDefaultState(), SHARD_WHITELIST)).createDecoratedFeature(CinderscapesDecorators.COUNT_CEILING.configure(new CountDecoratorConfig(1))));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.FLOOR_SHARD.configure(new ShardFeatureConfig(CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ.getDefaultState(), SHARD_WHITELIST)).createDecoratedFeature(CinderscapesDecorators.COUNT_FLOOR.configure(new CountDecoratorConfig(1))));

        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.CEILING_SHARD.configure(new ShardFeatureConfig(CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ.getDefaultState(), SHARD_WHITELIST)).createDecoratedFeature(CinderscapesDecorators.COUNT_CEILING.configure(new CountDecoratorConfig(1))));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.FLOOR_SHARD.configure(new ShardFeatureConfig(CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ.getDefaultState(), SHARD_WHITELIST)).createDecoratedFeature(CinderscapesDecorators.COUNT_FLOOR.configure(new CountDecoratorConfig(1))));
    }
}
