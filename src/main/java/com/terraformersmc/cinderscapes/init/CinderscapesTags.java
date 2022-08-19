package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

public class CinderscapesTags {
    public static final TagKey<Block> ASH_PERMEABLE = TagKey.of(Registry.BLOCK_KEY, Cinderscapes.id("ash_permeable"));

    public static void init() { }
}
