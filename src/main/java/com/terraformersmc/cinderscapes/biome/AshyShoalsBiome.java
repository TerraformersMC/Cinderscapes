package com.terraformersmc.cinderscapes.biome;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.cinderscapes.decorator.config.CountSafelistRangeDecoratorConfig;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.init.CinderscapesDecorators;
import com.terraformersmc.cinderscapes.init.CinderscapesFeatures;
import com.terraformersmc.cinderscapes.init.CinderscapesSurfaces;
import com.terraformersmc.cinderscapes.mixinterface.AshyBiome;
import com.terraformersmc.cinderscapes.mixinterface.FogDensityBiome;
import com.terraformersmc.cinderscapes.surfacebuilder.config.EmptySurfaceConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.sound.MusicType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BiomeAdditionsSound;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.BiomeParticleConfig;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import java.util.Arrays;
import java.util.List;

public class AshyShoalsBiome extends Biome implements AshyBiome, FogDensityBiome {
    public AshyShoalsBiome() {
        super(new Settings()
                .configureSurfaceBuilder(CinderscapesSurfaces.ASHY_SHOALS, new TernarySurfaceConfig(Blocks.NETHERRACK.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), Blocks.MAGMA_BLOCK.getDefaultState()))
                .precipitation(Precipitation.NONE)
                .category(Category.NETHER)
                .depth(0.1F)
                .scale(0.2F)
                .temperature(2.0F)
                .downfall(0.0F)
                .effects(new BiomeEffects.Builder()
                        .waterColor(4159204)
                        .waterFogColor(4341314)
                        .fogColor(0x363636)
                        .particleConfig(new BiomeParticleConfig(ParticleTypes.ASH, 0.625F))
                        .loopSound(SoundEvents.AMBIENT_NETHER_WASTES_LOOP)
                        .moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D))
                        .additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, 0.0111D))
                        .music(MusicType.method_27283(SoundEvents.MUSIC_NETHER_SOUL_SAND_VALLEY))
                        .build())
                .parent(null)
                .noises(ImmutableList.of(new MixedNoisePoint(-0.35F, 0.0F, 0.35F, 0.0F, 0.2F))));

        // DEFAULT MINECRAFT FEATURES

        this.addStructureFeature(DefaultBiomeFeatures.NETHER_RUINED_PORTAL);
        this.addStructureFeature(DefaultBiomeFeatures.FORTRESS);
        this.addStructureFeature(DefaultBiomeFeatures.BASTION_REMNANT);
        this.addStructureFeature(DefaultBiomeFeatures.NETHER_FOSSIL);
        this.addCarver(GenerationStep.Carver.AIR, configureCarver(net.minecraft.world.gen.carver.Carver.NETHER_CAVE, new ProbabilityConfig(0.2F)));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, net.minecraft.world.gen.feature.Feature.GLOWSTONE_BLOB.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.LIGHT_GEM_CHANCE.configure(new CountDecoratorConfig(10))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, net.minecraft.world.gen.feature.Feature.GLOWSTONE_BLOB.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, net.minecraft.world.gen.feature.Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NETHERRACK, Blocks.MAGMA_BLOCK.getDefaultState(), 33)).createDecoratedFeature(Decorator.MAGMA.configure(new CountDecoratorConfig(4))));
        DefaultBiomeFeatures.addNetherMineables(this);

        // ASH PILES
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.ASH_PILE.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(5, 10, 10, 128))));

        // VEGETATION
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.VEGETATION.configure(CinderscapesFeatures.ASHY_SHOALS_VEGETATION_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP.configure(new CountDecoratorConfig(8))));

        // BRAMBLE BERRY BUSHES
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(CinderscapesFeatures.BRAMBLE_BERRY_BUSH_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(8))));

        // REPLACE NETHERRACK
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.NETHERRACK_REPLACE_BLOBS.configure(CinderscapesFeatures.SOUL_SAND_REPLACE_CONFIG).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(5, 0, 0, 64))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.NETHERRACK_REPLACE_BLOBS.configure(CinderscapesFeatures.SOUL_SOIL_REPLACE_CONFIG).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.NETHERRACK_REPLACE_BLOBS.configure(CinderscapesFeatures.GRAVEL_REPLACE_CONFIG).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 128))));

        // TOP LAYER MODIFICATION
        this.addFeature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, CinderscapesFeatures.ASH_TOP_LAYER.configure(FeatureConfig.DEFAULT));

        // FEATURES
        List<BlockState> safelist = Arrays.asList(Blocks.NETHERRACK.getDefaultState(), Blocks.GRAVEL.getDefaultState(), CinderscapesBlocks.ASH.getDefaultState(), Blocks.SOUL_SAND.getDefaultState(), Blocks.SOUL_SOIL.getDefaultState());
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.DEAD_TREE.configure(FeatureConfig.DEFAULT).createDecoratedFeature(CinderscapesDecorators.COUNT_FLOOR.configure(new CountSafelistRangeDecoratorConfig(10, 20, 20, 128, safelist))));

        // ANCIENT DEBRIS
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, net.minecraft.world.gen.feature.Feature.NO_SURFACE_ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NETHER_ORE_REPLACEABLES, Blocks.ANCIENT_DEBRIS.getDefaultState(), 3)).createDecoratedFeature(Decorator.COUNT_DEPTH_AVERAGE.configure(new CountDepthDecoratorConfig(4, 16, 8))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, net.minecraft.world.gen.feature.Feature.NO_SURFACE_ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NETHER_ORE_REPLACEABLES, Blocks.ANCIENT_DEBRIS.getDefaultState(), 2)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(4, 8, 16, 128))));

        // SPAWNS
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ZOMBIFIED_PIGLIN, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ZOGLIN, 3, 3, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ENDERMAN, 1, 4, 4));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.STRIDER, 60, 1, 2));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.SKELETON, 20, 5, 5));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.GHAST, 50, 4, 4));

    }

    public float fogMultiplier() {
        return 0.5f;
    }
}
