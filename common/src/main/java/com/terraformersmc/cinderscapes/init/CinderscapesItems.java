package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CinderscapesItems {
    public static final Item ASH_PILE = add("ash_pile", new Item(new Item.Settings()));

    public static final Item SULFUR = add("sulfur", new Item(new Item.Settings()));

    public static final Item ROSE_QUARTZ = add("rose_quartz", new Item(new Item.Settings()));
    public static final Item SMOKY_QUARTZ = add("smoky_quartz", new Item(new Item.Settings()));
    public static final Item SULFUR_QUARTZ = add("sulfur_quartz", new Item(new Item.Settings()));

    public static <I extends Item> I add(String name, I item) {
        if (item instanceof BlockItem blockItem) {
            blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return Registry.register(Registries.ITEM, Identifier.of(Cinderscapes.NAMESPACE, name), item);
    }

    public static void init() { }
}
