package com.terraformersmc.cinderscapes.block;

import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class CinderscapesOreBlock extends ExperienceDroppingBlock {
    public CinderscapesOreBlock(Settings settings) {
        super(UniformIntProvider.create(2, 5), settings);
    }
}
