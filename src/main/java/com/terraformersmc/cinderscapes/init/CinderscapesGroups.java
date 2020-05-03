package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;

import java.util.Random;

/**
 * [REVIEWED]
 *
 * Contains the item groups added by Cinderscapes
 *
 * @author <Wtoll> Will Toll on 2020-05-02
 * @project Cinderscapes
 */
public class CinderscapesGroups {
    /**
     * Registers the item groups added by Cinderscapes
     */
    public static void init() {
        makeNamespaceGroup(Cinderscapes.MOD_ID);
    }

    /**
     * Builds an item group that automatically contains all of the items within the given namespace
     * @param namespace The namespace of the mod whose items the group will contain
     */
    public static void makeNamespaceGroup(String namespace) {
        FabricItemGroupBuilder.create(new Identifier(namespace, "items")).icon(() -> Registry.ITEM.stream().filter((item) -> Registry.ITEM.getId(item).getNamespace().equals(namespace)).skip(new Random().nextInt((int) Registry.ITEM.stream().filter((item) -> Registry.ITEM.getId(item).getNamespace().equals(namespace)).count() - 1)).findFirst().orElse(Items.DIRT).getStackForRender()).appendItems((stacks) -> Registry.ITEM.stream().filter((item) -> Registry.ITEM.getId(item).getNamespace().equals(namespace)).forEach((item) -> item.appendStacks(item.getGroup(), (DefaultedList<ItemStack>) stacks))).build();
    }

}
