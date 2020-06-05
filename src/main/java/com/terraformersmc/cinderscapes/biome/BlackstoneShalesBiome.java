package com.terraformersmc.cinderscapes.biome;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.terraformersmc.cinderscapes.init.CinderscapesDecorators;
import com.terraformersmc.cinderscapes.init.CinderscapesFeatures;
import com.terraformersmc.cinderscapes.init.CinderscapesSurfaces;
import com.terraformersmc.cinderscapes.surfacebuilder.config.EmptySurfaceConfig;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.particle.ParticleTypes;
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
                        .particleConfig(new BiomeParticleConfig(ParticleTypes.WHITE_ASH, 0.118093334F))
                        .build())
                .parent(null)
                .noises(ImmutableList.of(new MixedNoisePoint(0.05F, 0.05F, 0.05F, 0.05F, 0.2F))));




        // VEGETATION
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.BLACKSTONE_WEEPING_VINES.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(100, 0, 0, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.SOUL_SAND_CRIMSON_ROOTS_CONFIG).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(100, 0, 0, 128))));

        // SHALES
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapesFeatures.BLACKSTONE_SHALE.configure(FeatureConfig.DEFAULT).createDecoratedFeature(CinderscapesDecorators.COUNT_FLOOR.configure(new CountDecoratorConfig(1))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapesFeatures.BLACKSTONE_LAVA_SHALE.configure(FeatureConfig.DEFAULT).createDecoratedFeature(CinderscapesDecorators.COUNT_FLOOR.configure(new CountDecoratorConfig(1))));


    }
}
