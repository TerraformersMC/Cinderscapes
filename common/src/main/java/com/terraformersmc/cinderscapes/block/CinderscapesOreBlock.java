package com.terraformersmc.cinderscapes.block;

import net.minecraft.block.OreBlock;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class CinderscapesOreBlock extends OreBlock {
    public CinderscapesOreBlock(Settings settings) {
        super(settings, UniformIntProvider.create(2, 5));
    }
}
