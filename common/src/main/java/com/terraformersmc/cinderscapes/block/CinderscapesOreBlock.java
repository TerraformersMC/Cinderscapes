package com.terraformersmc.cinderscapes.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.DropExperienceBlock;

public class CinderscapesOreBlock extends DropExperienceBlock {
    public CinderscapesOreBlock(Properties settings) {
        super(UniformInt.of(2, 5), settings);
    }
}
