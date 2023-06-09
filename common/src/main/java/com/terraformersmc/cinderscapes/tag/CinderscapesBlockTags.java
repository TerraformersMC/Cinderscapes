package com.terraformersmc.cinderscapes.tag;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CinderscapesBlockTags {
    public static final TagKey<Block> ASH_PERMEABLE = TagKey.of(Registry.BLOCK_KEY, Cinderscapes.id("ash_permeable"));
    public static final TagKey<Block> SCORCHED_STEMS = TagKey.of(Registry.BLOCK_KEY, Cinderscapes.id("scorched_stems"));
    public static final TagKey<Block> UMBRAL_STEMS = TagKey.of(Registry.BLOCK_KEY, Cinderscapes.id("umbral_stems"));

    public static final TagKey<Block> STRIPPED_LOGS = TagKey.of(Registry.BLOCK_KEY, new Identifier("c", "stripped_logs"));
    public static final TagKey<Block> STRIPPED_WOOD = TagKey.of(Registry.BLOCK_KEY, new Identifier("c", "stripped_wood"));

    public static void init() { }
}
