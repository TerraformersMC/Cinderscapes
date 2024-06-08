package com.terraformersmc.cinderscapes.tag;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class CinderscapesItemTags {
    public static final TagKey<Item> ROSE_QUARTZ_CONVERTIBLES = CinderscapesItemTags.of("rose_quartz_convertibles");
    public static final TagKey<Item> SCORCHED_STEMS = CinderscapesItemTags.of("scorched_stems");
    public static final TagKey<Item> SMOKY_QUARTZ_CONVERTIBLES = CinderscapesItemTags.of("smoky_quartz_convertibles");
    public static final TagKey<Item> SULFUR_QUARTZ_CONVERTIBLES = CinderscapesItemTags.of("sulfur_quartz_convertibles");
    public static final TagKey<Item> UMBRAL_STEMS = CinderscapesItemTags.of("umbral_stems");

    public static final TagKey<Item> DARK_ASHES_DUSTS = CinderscapesItemTags.of(Identifier.of("c", "dark_ashes_dusts"));
    public static final TagKey<Item> QUARTZ = CinderscapesItemTags.of(Identifier.of("c", "quartz"));
    public static final TagKey<Item> QUARTZ_BLOCKS = CinderscapesItemTags.of(Identifier.of("c", "quartz_blocks"));
    public static final TagKey<Item> STORAGE_BLOCKS_SULFUR = CinderscapesItemTags.of(Identifier.of("c", "storage_blocks/sulfur"));
    public static final TagKey<Item> STRIPPED_LOGS = CinderscapesItemTags.of(Identifier.of("c", "stripped_logs"));
    public static final TagKey<Item> STRIPPED_WOOD = CinderscapesItemTags.of(Identifier.of("c", "stripped_wood"));
    public static final TagKey<Item> SULFUR_ORES = CinderscapesItemTags.of(Identifier.of("c", "sulfur_ores"));
    public static final TagKey<Item> SULFURS_ORES = CinderscapesItemTags.of(Identifier.of("c", "ores/sulfurs"));
    public static final TagKey<Item> SULFURS = CinderscapesItemTags.of(Identifier.of("c", "sulfurs"));

    @SuppressWarnings("UnnecessaryReturnStatement")
    private CinderscapesItemTags() {
        return;
    }

    private static TagKey<Item> of(String path) {
        return CinderscapesItemTags.of(Identifier.of(Cinderscapes.MOD_ID, path));
    }

    private static TagKey<Item> of(Identifier id) {
        return TagKey.of(RegistryKeys.ITEM, id);
    }
}
