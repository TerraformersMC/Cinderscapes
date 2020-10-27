package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;

public class CinderscapesTags {
    public static final Tag<Block> ASH_PERMEABLE = TagRegistry.block(Cinderscapes.id("ash_permeable"));

    public static void init() { }
}
