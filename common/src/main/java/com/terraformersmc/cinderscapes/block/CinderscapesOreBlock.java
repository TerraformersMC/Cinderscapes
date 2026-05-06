package com.terraformersmc.cinderscapes.block;

import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class CinderscapesOreBlock extends DropExperienceBlock {
    public CinderscapesOreBlock(Properties settings) {
        super(UniformInt.of(2, 5), settings);
    }
}
