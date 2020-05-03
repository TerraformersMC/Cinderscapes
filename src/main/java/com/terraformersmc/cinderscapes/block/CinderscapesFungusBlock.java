package com.terraformersmc.cinderscapes.block;

import net.minecraft.block.FungusBlock;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.HugeFungusFeatureConfig;

import java.util.function.Supplier;

/**
 * [REVIEWED]
 *
 * A shell class to expand the scope of the default FungusBlock class
 *
 * @author <Wtoll> Will Toll on 2020-05-02
 * @project Cinderscapes
 */
public class CinderscapesFungusBlock extends FungusBlock {
    public CinderscapesFungusBlock(Settings settings, Supplier<ConfiguredFeature<HugeFungusFeatureConfig, ?>> supplier) {
        super(settings, supplier);
    }
}
