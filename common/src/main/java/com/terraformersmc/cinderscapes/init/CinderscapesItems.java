package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.item.CinderscapesMusicDiscItem;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import java.util.LinkedHashMap;
import java.util.Map;

public class CinderscapesItems {
    // Acts as a kind of local registry for items added by Cinderscapes
    private static final Map<Identifier, Item> ITEMS = new LinkedHashMap<>();

    public static final Item ASH_PILE = add("ash_pile", new Item(new Item.Settings()));

    public static final Item SULFUR = add("sulfur", new Item(new Item.Settings()));

    public static final Item ROSE_QUARTZ = add("rose_quartz", new Item(new Item.Settings()));
    public static final Item SMOKY_QUARTZ = add("smoky_quartz", new Item(new Item.Settings()));
    public static final Item SULFUR_QUARTZ = add("sulfur_quartz", new Item(new Item.Settings()));

    public static final Item MUSIC_DISC_LUMINOUS_PLANTATION = add("music_disc_luminous_plantation", new CinderscapesMusicDiscItem(14, CinderscapesSoundEvents.MUSIC_DISC_LUMINOUS_PLANTATION, 231));
    public static final Item MUSIC_DISC_CHILLING_IN_HELL = add("music_disc_chilling_in_hell", new CinderscapesMusicDiscItem(14, CinderscapesSoundEvents.MUSIC_DISC_CHILLING_IN_HELL, 136));

    public static Item add(String name, Item item) {
        ITEMS.put(Identifier.of(Cinderscapes.NAMESPACE, name), item);
        return item;
    }

    public static <I extends BlockItem> I add(String name, I item) {
        item.appendBlocks(Item.BLOCK_ITEMS, item);
        ITEMS.put(Identifier.of(Cinderscapes.NAMESPACE, name), item);
        return item;
    }

    public static void init() {
        for (Identifier id : ITEMS.keySet()) {
            Registry.register(Registries.ITEM, id, ITEMS.get(id));
        }
    }
}
