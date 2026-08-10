package com.terraformersmc.cinderscapes.tag;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.jspecify.annotations.NullMarked;

@NullMarked
@SuppressWarnings("unused")
public class CinderscapesItemTags {
    public static final TagKey<Item> ROSE_QUARTZ_CONVERTIBLES = create("rose_quartz_convertibles");
    public static final TagKey<Item> SMOKY_QUARTZ_CONVERTIBLES = create("smoky_quartz_convertibles");
    public static final TagKey<Item> SULFUR_QUARTZ_CONVERTIBLES = create("sulfur_quartz_convertibles");

    public static final TagKey<Item> DARK_ASHES_DUSTS = create(Identifier.fromNamespaceAndPath("c", "dark_ashes_dusts"));
    public static final TagKey<Item> QUARTZ_BLOCKS = create(Identifier.fromNamespaceAndPath("c", "quartz_blocks"));
    public static final TagKey<Item> STORAGE_BLOCKS_SULFUR = create(Identifier.fromNamespaceAndPath("c", "storage_blocks/sulfur"));
    public static final TagKey<Item> SULFURS = create(Identifier.fromNamespaceAndPath("c", "sulfurs"));

    @SuppressWarnings("UnnecessaryReturnStatement")
    private CinderscapesItemTags() {
        return;
    }

    private static TagKey<Item> create(String path) {
        return create(Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, path));
    }

    private static TagKey<Item> create(Identifier id) {
        return TagKey.create(Registries.ITEM, id);
    }
}
