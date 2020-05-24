package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.terraform.util.RecipeUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <Wtoll> Will Toll on 2020-05-24
 * @project Cinderscapes
 */
public class CinderscapesItems {
    // Acts as a kind of local registry for items added by Cinderscapes
    private static final Map<Identifier, Item> ITEMS = new HashMap<>();

    public static final Item ASH_PILE = add("ash_pile", new Item(new Item.Settings().group(ItemGroup.MATERIALS)));
    public static final Item ROSE_QUARTZ = add("rose_quartz", new Item(new Item.Settings().group(ItemGroup.MATERIALS)));
    public static final Item SMOKY_QUARTZ = add("smoky_quartz", new Item(new Item.Settings().group(ItemGroup.MATERIALS)));
    public static final Item SULFUR_QUARTZ = add("sulfur_quartz", new Item(new Item.Settings().group(ItemGroup.MATERIALS)));

    private static <I extends Item> I add(String name, I item) {
        ITEMS.put(Cinderscapes.id(name), item);
        return item;
    }

    public static void init() {
        for (Identifier id : ITEMS.keySet()) {
            Registry.register(Registry.ITEM, id, ITEMS.get(id));
        }
    }
}
