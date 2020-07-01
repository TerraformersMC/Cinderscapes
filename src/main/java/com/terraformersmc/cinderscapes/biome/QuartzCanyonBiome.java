package com.terraformersmc.cinderscapes.biome;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.cinderscapes.block.PolypiteQuartzBlock;
import com.terraformersmc.cinderscapes.decorator.config.CountSafelistRangeDecoratorConfig;
import com.terraformersmc.cinderscapes.feature.config.PolypiteQuartzFeatureConfig;
import com.terraformersmc.cinderscapes.feature.config.SimpleStateFeatureConfig;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.init.CinderscapesDecorators;
import com.terraformersmc.cinderscapes.init.CinderscapesFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
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
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.ProbabilityConfig;
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
                        .fogColor(3344392)
                        .particleConfig(new BiomeParticleConfig(ParticleTypes.FIREWORK, 0.0025F))
                        .loopSound(SoundEvents.AMBIENT_NETHER_WASTES_LOOP)
                        .moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_NETHER_WASTES_MOOD, 6000, 8, 2.0D))
                        .additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_NETHER_WASTES_ADDITIONS, 0.0111D))
                        .music(MusicType.method_27283(SoundEvents.MUSIC_NETHER_NETHER_WASTES))
                        .build())
                .parent(null)
                .noises(ImmutableList.of(new Biome.MixedNoisePoint(0.0F, 0.0F, 0.35F, 0.35F, 0.2F))));


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
        DefaultBiomeFeatures.addAncientDebris(this);

        // SPAWNS
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ZOMBIFIED_PIGLIN, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.MAGMA_CUBE, 15, 2, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ENDERMAN, 1, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.PIGLIN, 20, 4, 4));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.STRIDER, 60, 1, 2));

        // QUARTZ ORES
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NETHERRACK, Blocks.NETHER_QUARTZ_ORE.getDefaultState(), 14)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(32, 10, 20, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NETHERRACK, CinderscapesBlocks.SULFUR_ORE.getDefaultState(), 14)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(16, 0, 0, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, net.minecraft.world.gen.feature.Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NETHERRACK, Blocks.NETHER_GOLD_ORE.getDefaultState(), 10)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(20, 10, 20, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NETHERRACK, CinderscapesBlocks.SMOKY_QUARTZ_ORE.getDefaultState(), 14)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(32, 0, 0, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NETHERRACK, CinderscapesBlocks.ROSE_QUARTZ_ORE.getDefaultState(), 14)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(32, 0, 0, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NETHERRACK, CinderscapesBlocks.SULFUR_QUARTZ_ORE.getDefaultState(), 14)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(32, 0, 0, 128))));

        // VEGETATION
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.VEGETATION.configure(CinderscapesFeatures.QUARTZ_CANYON_VEGETATION_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP.configure(new CountDecoratorConfig(1))));

        // QUARTZ SHARDS

        List<BlockState> safelist = Arrays.asList(Blocks.NETHERRACK.getDefaultState(), Blocks.NETHER_QUARTZ_ORE.getDefaultState());

        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.CEILING_SHARD.configure(new SimpleStateFeatureConfig(CinderscapesBlocks.CRYSTALLINE_QUARTZ.getDefaultState(), SHARD_WHITELIST)).createDecoratedFeature(CinderscapesDecorators.COUNT_CEILING.configure(new CountSafelistRangeDecoratorConfig(1, 20, 20, 128, safelist))));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.FLOOR_SHARD.configure(new SimpleStateFeatureConfig(CinderscapesBlocks.CRYSTALLINE_QUARTZ.getDefaultState(), SHARD_WHITELIST)).createDecoratedFeature(CinderscapesDecorators.COUNT_FLOOR.configure(new CountSafelistRangeDecoratorConfig(1, 20, 20, 128, safelist))));

        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.CEILING_SHARD.configure(new SimpleStateFeatureConfig(CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ.getDefaultState(), SHARD_WHITELIST)).createDecoratedFeature(CinderscapesDecorators.COUNT_CEILING.configure(new CountSafelistRangeDecoratorConfig(1, 20, 20, 128, safelist))));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.FLOOR_SHARD.configure(new SimpleStateFeatureConfig(CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ.getDefaultState(), SHARD_WHITELIST)).createDecoratedFeature(CinderscapesDecorators.COUNT_FLOOR.configure(new CountSafelistRangeDecoratorConfig(1, 20, 20, 128, safelist))));

        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.CEILING_SHARD.configure(new SimpleStateFeatureConfig(CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ.getDefaultState(), SHARD_WHITELIST)).createDecoratedFeature(CinderscapesDecorators.COUNT_CEILING.configure(new CountSafelistRangeDecoratorConfig(1, 20, 20, 128, safelist))));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.FLOOR_SHARD.configure(new SimpleStateFeatureConfig(CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ.getDefaultState(), SHARD_WHITELIST)).createDecoratedFeature(CinderscapesDecorators.COUNT_FLOOR.configure(new CountSafelistRangeDecoratorConfig(1, 20, 20, 128, safelist))));

        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.CEILING_SHARD.configure(new SimpleStateFeatureConfig(CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ.getDefaultState(), SHARD_WHITELIST)).createDecoratedFeature(CinderscapesDecorators.COUNT_CEILING.configure(new CountSafelistRangeDecoratorConfig(1, 20, 20, 128, safelist))));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.FLOOR_SHARD.configure(new SimpleStateFeatureConfig(CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ.getDefaultState(), SHARD_WHITELIST)).createDecoratedFeature(CinderscapesDecorators.COUNT_FLOOR.configure(new CountSafelistRangeDecoratorConfig(1, 20, 20, 128, safelist))));

        // POLYPITE QUARTZ
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.POLYPITE_QUARTZ.configure(new PolypiteQuartzFeatureConfig((PolypiteQuartzBlock) CinderscapesBlocks.POLYPITE_QUARTZ)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(128, 10, 20, 128))));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.POLYPITE_QUARTZ.configure(new PolypiteQuartzFeatureConfig((PolypiteQuartzBlock) CinderscapesBlocks.POLYPITE_SULFUR_QUARTZ)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(128, 10, 20, 128))));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.POLYPITE_QUARTZ.configure(new PolypiteQuartzFeatureConfig((PolypiteQuartzBlock) CinderscapesBlocks.POLYPITE_ROSE_QUARTZ)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(128, 10, 20, 128))));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.POLYPITE_QUARTZ.configure(new PolypiteQuartzFeatureConfig((PolypiteQuartzBlock) CinderscapesBlocks.POLYPITE_SMOKY_QUARTZ)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(128, 10, 20, 128))));
    }
}
