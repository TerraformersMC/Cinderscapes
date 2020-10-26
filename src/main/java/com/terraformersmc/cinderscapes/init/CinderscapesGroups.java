package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;

// Contains the item groups added by Cinderscapes
public class CinderscapesGroups {
    // Registers the item group added by Cinderscapes
    public static void init() {
        FabricItemGroupBuilder.create(Cinderscapes.id("items"))
            .icon(() -> CinderscapesBlocks.UMBRAL_FUNGUS.asItem().getDefaultStack())
            .appendItems((stacks) -> {
                Registry.ITEM.stream().filter((item) -> {
                    return Registry.ITEM.getId(item).getNamespace().equals(Cinderscapes.NAMESPACE);
                }).forEach((item) -> stacks.add(new ItemStack(item)));
            })
            .build();
    }
}
