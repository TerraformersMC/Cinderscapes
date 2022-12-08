package com.terraformersmc.cinderscapes.tag;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class CinderscapesBlockTags {
    public static final TagKey<Block> ASH_PERMEABLE = TagKey.of(RegistryKeys.BLOCK, Cinderscapes.id("ash_permeable"));
    public static final TagKey<Block> SCORCHED_STEMS = TagKey.of(RegistryKeys.BLOCK, Cinderscapes.id("scorched_stems"));
    public static final TagKey<Block> UMBRAL_STEMS = TagKey.of(RegistryKeys.BLOCK, Cinderscapes.id("umbral_stems"));

    public static void init() { }
}
