package com.terraformersmc.cinderscapes.biomes.blackstoneshales;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.biomes.blackstoneshales.feature.BlackstoneWeepingVineFeature;
import com.terraformersmc.cinderscapes.biomes.blackstoneshales.feature.ShaleFeature;
import com.terraformersmc.cinderscapes.biomes.blackstoneshales.feature.config.ShaleFeatureConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class BlackstoneShalesFeatures {
    public static final Feature<DefaultFeatureConfig> BLACKSTONE_WEEPING_VINES = Cinderscapes.REGISTRATION_HELPER.register(new BlackstoneWeepingVineFeature(DefaultFeatureConfig.CODEC), "blackstone_weeping_vines");
    public static final Feature<ShaleFeatureConfig> SHALE = Cinderscapes.REGISTRATION_HELPER.register(new ShaleFeature(), "shale");
}
