package com.terraformersmc.cinderscapes.biome;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.cinderscapes.init.CinderscapesDecorators;
import com.terraformersmc.cinderscapes.init.CinderscapesFeatures;
import com.terraformersmc.cinderscapes.init.CinderscapesSurfaces;
import com.terraformersmc.cinderscapes.mixinterface.AshyBiome;
import com.terraformersmc.cinderscapes.mixinterface.FogDensityBiome;
import com.terraformersmc.cinderscapes.surfacebuilder.config.EmptySurfaceConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BiomeAdditionsSound;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.structure.BastionRemnantGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.WorldView;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.BiomeParticleConfig;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.carver.Carver;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

/**
 * @author <Wtoll> Will Toll on 2020-05-23
 * @project Cinderscapes
 */
public class AshyShoalsBiome extends Biome implements AshyBiome, FogDensityBiome {
    public AshyShoalsBiome() {
        super(new Settings()
                .configureSurfaceBuilder(CinderscapesSurfaces.ASHY_SHOALS, new EmptySurfaceConfig())
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
                        .particleConfig(
                                new BiomeParticleConfig(ParticleTypes.ASH, 0.3F,
                                        (random) -> (double)random.nextFloat() * -1.9D * (double)random.nextFloat() * 0.1D,
                                        (random) -> (double)random.nextFloat() * -0.5D * (double)random.nextFloat() * 0.1D * 5.0D,
                                        (random) -> (double)random.nextFloat() * -1.9D * (double)random.nextFloat() * 0.1D))
                        .loopSound(SoundEvents.AMBIENT_NETHER_WASTES_LOOP)
                        .build())
                .parent(null)
                .noises(ImmutableList.of(new MixedNoisePoint(-0.35F, 0.0F, 0.35F, 0.0F, 0.2F))));
        //ruined portal
        this.addStructureFeature(Feature.NETHER_BRIDGE.configure(FeatureConfig.DEFAULT));
        this.addStructureFeature(Feature.NETHER_FOSSIL.configure(FeatureConfig.DEFAULT));
        this.addStructureFeature(Feature.RUINED_PORTAL.configure(new RuinedPortalFeatureConfig(RuinedPortalFeature.Type.NETHER)));
        this.addStructureFeature(Feature.BASTION_REMNANT.configure(new BastionRemnantFeatureConfig(BastionRemnantGenerator.START_POOLS_TO_SIZES)));
        DefaultBiomeFeatures.addDefaultStructures(this);
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.NETHER_BRIDGE.configure(FeatureConfig.DEFAULT));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.NETHER_FOSSIL.configure(FeatureConfig.DEFAULT));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.RUINED_PORTAL.configure(new RuinedPortalFeatureConfig(RuinedPortalFeature.Type.NETHER)));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.NETHERRACK_REPLACE_BLOBS.configure(DefaultBiomeFeatures.field_23856).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.NETHERRACK_REPLACE_BLOBS.configure(DefaultBiomeFeatures.field_23857).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.NETHERRACK_REPLACE_BLOBS.configure(CinderscapesFeatures.SOUL_SAND_REPLACE_CONFIG).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.NETHERRACK_REPLACE_BLOBS.configure(CinderscapesFeatures.SOUL_SOIL_REPLACE_CONFIG).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.NETHERRACK_REPLACE_BLOBS.configure(CinderscapesFeatures.GRAVEL_REPLACE_CONFIG).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 128))));
        //glowstone
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.GLOWSTONE_BLOB.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.LIGHT_GEM_CHANCE.configure(new CountDecoratorConfig(20))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.GLOWSTONE_BLOB.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(20, 0, 0, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG).createDecoratedFeature(Decorator.CHANCE_RANGE.configure(new ChanceRangeDecoratorConfig(0.5F, 0, 0, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.RED_MUSHROOM_CONFIG).createDecoratedFeature(Decorator.CHANCE_RANGE.configure(new ChanceRangeDecoratorConfig(0.5F, 0, 0, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NETHERRACK, Blocks.NETHER_QUARTZ_ORE.getDefaultState(), 14)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(16, 10, 20, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NETHERRACK, Blocks.MAGMA_BLOCK.getDefaultState(), 33)).createDecoratedFeature(Decorator.MAGMA.configure(new CountDecoratorConfig(4))));

        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.DEAD_TREE.configure(FeatureConfig.DEFAULT).createDecoratedFeature(CinderscapesDecorators.COUNT_FLOOR.configure(new CountDecoratorConfig(10))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.BASALT_PILLAR.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(30, 0, 0, 128))));



        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.GHAST, 50, 4, 4));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ZOMBIFIED_PIGLIN, 100, 4, 4));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.MAGMA_CUBE, 2, 4, 4));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ENDERMAN, 1, 4, 4));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.PIGLIN, 15, 4, 4));
        this.addSpawn(EntityCategory.CREATURE, new Biome.SpawnEntry(EntityType.STRIDER, 60, 2, 4));
    }

    public float fogMultiplier() {
        return 0.5f;
    }
}
