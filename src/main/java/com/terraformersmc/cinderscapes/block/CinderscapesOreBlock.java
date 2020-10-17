package com.terraformersmc.cinderscapes.block;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class CinderscapesOreBlock extends OreBlock {
    public CinderscapesOreBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected int getExperienceWhenMined(Random random) {
        if (this == CinderscapesBlocks.SULFUR_QUARTZ_ORE || this == CinderscapesBlocks.SMOKY_QUARTZ_ORE || this == CinderscapesBlocks.ROSE_QUARTZ_ORE) {
            return MathHelper.nextInt(random, 2, 5);
        } else {
            return super.getExperienceWhenMined(random);
        }
    }
}
