package com.terraformersmc.cinderscapes.tag;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class CinderscapesItemTags {
    public static final TagKey<Item> ROSE_QUARTZ_CONVERTIBLES = TagKey.of(RegistryKeys.ITEM, Cinderscapes.id("rose_quartz_convertibles"));
    public static final TagKey<Item> SCORCHED_STEMS = TagKey.of(RegistryKeys.ITEM, Cinderscapes.id("scorched_stems"));
    public static final TagKey<Item> SMOKY_QUARTZ_CONVERTIBLES = TagKey.of(RegistryKeys.ITEM, Cinderscapes.id("smoky_quartz_convertibles"));
    public static final TagKey<Item> SULFUR_QUARTZ_CONVERTIBLES = TagKey.of(RegistryKeys.ITEM, Cinderscapes.id("sulfur_quartz_convertibles"));
    public static final TagKey<Item> UMBRAL_STEMS = TagKey.of(RegistryKeys.ITEM, Cinderscapes.id("umbral_stems"));

    public static final TagKey<Item> DARK_ASHES_DUSTS = TagKey.of(RegistryKeys.ITEM, new Identifier("c", "dark_ashes_dusts"));
    public static final TagKey<Item> QUARTZ = TagKey.of(RegistryKeys.ITEM, new Identifier("c", "quartz"));
    public static final TagKey<Item> QUARTZ_BLOCKS = TagKey.of(RegistryKeys.ITEM, new Identifier("c", "quartz_blocks"));
    public static final TagKey<Item> QUARTZ_ORES = TagKey.of(RegistryKeys.ITEM, new Identifier("c", "quartz_ores"));
    public static final TagKey<Item> SULFUR_ORES = TagKey.of(RegistryKeys.ITEM, new Identifier("c", "sulfur_ores"));
    public static final TagKey<Item> SULFURS = TagKey.of(RegistryKeys.ITEM, new Identifier("c", "sulfurs"));

    public static void init() { }
}
