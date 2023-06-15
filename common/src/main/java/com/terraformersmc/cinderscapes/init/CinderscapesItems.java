package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.item.CinderscapesMusicDiscItem;
import net.minecraft.MinecraftVersion;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CinderscapesItems {
    public static final Item ASH_PILE = add("ash_pile", new Item(new Item.Settings().group(ItemGroup.MATERIALS)));

    public static final Item SULFUR = add("sulfur", new Item(new Item.Settings().group(ItemGroup.MATERIALS)));

    public static final Item ROSE_QUARTZ = add("rose_quartz", new Item(new Item.Settings().group(ItemGroup.MATERIALS)));
    public static final Item SMOKY_QUARTZ = add("smoky_quartz", new Item(new Item.Settings().group(ItemGroup.MATERIALS)));
    public static final Item SULFUR_QUARTZ = add("sulfur_quartz", new Item(new Item.Settings().group(ItemGroup.MATERIALS)));

    // TODO: Fails in 1.19.0 where Minecraft does not want to know the length.
    //       Rip out if{} block in init() and restore the two lines below in 1.20.
    //public static final Item MUSIC_DISC_LUMINOUS_PLANTATION = add("music_disc_luminous_plantation", new CinderscapesMusicDiscItem(14, CinderscapesSoundEvents.MUSIC_DISC_LUMINOUS_PLANTATION, 231));
    //public static final Item MUSIC_DISC_CHILLING_IN_HELL = add("music_disc_chilling_in_hell", new CinderscapesMusicDiscItem(14, CinderscapesSoundEvents.MUSIC_DISC_CHILLING_IN_HELL, 136));
    public static Item MUSIC_DISC_LUMINOUS_PLANTATION;
    public static Item MUSIC_DISC_CHILLING_IN_HELL;

    public static <I extends Item> I add(String name, I item) {
        if (item instanceof BlockItem blockItem) {
            blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return Registry.register(Registry.ITEM, Identifier.of(Cinderscapes.NAMESPACE, name), item);
    }

    public static void init() {
        // TODO: I've said it before but ... WTH does Mojang think dot releases are for?
        //       STOP MODIFYING THE API IN DOT RELEASES, MOJANG!  STOP IT!!!
        if (MinecraftVersion.CURRENT.toString().startsWith("1.19.")) {
            MUSIC_DISC_LUMINOUS_PLANTATION = add("music_disc_luminous_plantation", new CinderscapesMusicDiscItem(14, CinderscapesSoundEvents.MUSIC_DISC_LUMINOUS_PLANTATION, 231));
            MUSIC_DISC_CHILLING_IN_HELL = add("music_disc_chilling_in_hell", new CinderscapesMusicDiscItem(14, CinderscapesSoundEvents.MUSIC_DISC_CHILLING_IN_HELL, 136));
        }
    }
}
