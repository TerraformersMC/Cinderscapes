package com.terraformersmc.cinderscapes.biomes.quartzcavern;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.biomes.quartzcavern.feature.CrystalShardFeature;
import com.terraformersmc.cinderscapes.biomes.quartzcavern.feature.config.CrystalShardFeatureConfig;
import net.minecraft.util.math.Direction;

public class QuartzCavernFeatures {
    public static final CrystalShardFeature CRYSTAL_SHARD_FEATURE = Cinderscapes.REGISTRATION_HELPER.register(new CrystalShardFeature(), "crystal_shard");

    public static final CrystalShardFeatureConfig QUARTZ_CIELING = new CrystalShardFeatureConfig(QuartzCavernBlocks.CRYSTALLINE_QUARTZ.getDefaultState(), Direction.DOWN);
    public static final CrystalShardFeatureConfig QUARTZ_FLOOR = new CrystalShardFeatureConfig(QuartzCavernBlocks.CRYSTALLINE_QUARTZ.getDefaultState(), Direction.UP);
    public static final CrystalShardFeatureConfig ROSE_QUARTZ_CIELING = new CrystalShardFeatureConfig(QuartzCavernBlocks.CRYSTALLINE_ROSE_QUARTZ.getDefaultState(), Direction.DOWN);
    public static final CrystalShardFeatureConfig ROSE_QUARTZ_FLOOR = new CrystalShardFeatureConfig(QuartzCavernBlocks.CRYSTALLINE_ROSE_QUARTZ.getDefaultState(), Direction.UP);
    public static final CrystalShardFeatureConfig SMOKY_QUARTZ_CIELING = new CrystalShardFeatureConfig(QuartzCavernBlocks.CRYSTALLINE_SMOKY_QUARTZ.getDefaultState(), Direction.DOWN);
    public static final CrystalShardFeatureConfig SMOKY_QUARTZ_FLOOR = new CrystalShardFeatureConfig(QuartzCavernBlocks.CRYSTALLINE_SMOKY_QUARTZ.getDefaultState(), Direction.UP);
    public static final CrystalShardFeatureConfig SULFUR_QUARTZ_CIELING = new CrystalShardFeatureConfig(QuartzCavernBlocks.CRYSTALLINE_SULFUR_QUARTZ.getDefaultState(), Direction.DOWN);
    public static final CrystalShardFeatureConfig SULFUR_QUARTZ_FLOOR = new CrystalShardFeatureConfig(QuartzCavernBlocks.CRYSTALLINE_SULFUR_QUARTZ.getDefaultState(), Direction.UP);

    public static void onInitializeCommon() { }
}
