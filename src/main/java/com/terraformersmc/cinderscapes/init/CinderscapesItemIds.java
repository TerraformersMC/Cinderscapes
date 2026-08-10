package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import org.jspecify.annotations.NullMarked;

@NullMarked
@SuppressWarnings("unused")
public class CinderscapesItemIds {
    public static final ResourceKey<Item> ASH_PILE = create(id("ash_pile"));
    public static final ResourceKey<Item> BRAMBLE_BERRIES = create(id("bramble_berries"));
    public static final ResourceKey<Item> SULFUR = create(id("sulfur"));

    public static final ResourceKey<Item> ROSE_QUARTZ = create(id("rose_quartz"));
    public static final ResourceKey<Item> SMOKY_QUARTZ = create(id("smoky_quartz"));
    public static final ResourceKey<Item> SULFUR_QUARTZ = create(id("sulfur_quartz"));


    private static ResourceKey<Item> create(Identifier id) {
        return ResourceKey.create(Registries.ITEM, id);
    }

    private static ResourceKey<Item> create(String name) {
        return create(id(name));
    }

    private static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, path);
    }
}
