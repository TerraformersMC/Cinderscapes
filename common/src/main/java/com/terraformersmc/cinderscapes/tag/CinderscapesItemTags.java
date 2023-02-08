package com.terraformersmc.cinderscapes.tag;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CinderscapesItemTags {
    public static final TagKey<Item> ROSE_QUARTZ_CONVERTIBLES = TagKey.of(Registry.ITEM_KEY, Cinderscapes.asIdentifier("rose_quartz_convertibles"));
    public static final TagKey<Item> SCORCHED_STEMS = TagKey.of(Registry.ITEM_KEY, Cinderscapes.asIdentifier("scorched_stems"));
    public static final TagKey<Item> SMOKY_QUARTZ_CONVERTIBLES = TagKey.of(Registry.ITEM_KEY, Cinderscapes.asIdentifier("smoky_quartz_convertibles"));
    public static final TagKey<Item> SULFUR_QUARTZ_CONVERTIBLES = TagKey.of(Registry.ITEM_KEY, Cinderscapes.asIdentifier("sulfur_quartz_convertibles"));
    public static final TagKey<Item> UMBRAL_STEMS = TagKey.of(Registry.ITEM_KEY, Cinderscapes.asIdentifier("umbral_stems"));

    public static final TagKey<Item> DARK_ASHES_DUSTS = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "dark_ashes_dusts"));
    public static final TagKey<Item> QUARTZ = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "quartz"));
    public static final TagKey<Item> QUARTZ_BLOCKS = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "quartz_blocks"));
    public static final TagKey<Item> QUARTZ_ORES = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "quartz_ores"));
    public static final TagKey<Item> SULFUR_ORES = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "sulfur_ores"));
    public static final TagKey<Item> SULFURS = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "sulfurs"));

    public static void init() { }
}
