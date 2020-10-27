package com.terraformersmc.cinderscapes.init;

import java.util.LinkedHashMap;
import java.util.Map;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.client.CinderscapesSoundEvents;
import com.terraformersmc.cinderscapes.item.CinderscapesMusicDiscItem;

import net.minecraft.block.ComposterBlock;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SignItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CinderscapesItems {
    // Acts as a kind of local registry for items added by Cinderscapes
    private static final Map<Identifier, Item> ITEMS = new LinkedHashMap<>();

    public static final Item BRAMBLE_BERRIES = add("bramble_berries", new AliasedBlockItem(CinderscapesBlocks.BRAMBLE_BERRY_BUSH, new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.1F).alwaysEdible().snack().statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 600, 0), 0.8F).build())));

    public static final Item UMBRAL_SIGN = add("umbral_sign", new SignItem(new Item.Settings().maxCount(16).group(ItemGroup.DECORATIONS), CinderscapesBlocks.UMBRAL_SIGN, CinderscapesBlocks.UMBRAL_WALL_SIGN));

    public static final Item SCORCHED_SIGN = add("scorched_sign", new SignItem(new Item.Settings().maxCount(16).group(ItemGroup.DECORATIONS), CinderscapesBlocks.SCORCHED_SIGN, CinderscapesBlocks.SCORCHED_WALL_SIGN));
    public static final Item ASH_PILE = add("ash_pile", new Item(new Item.Settings().group(ItemGroup.MATERIALS)));

    public static final Item SULFUR = add("sulfur", new Item(new Item.Settings().group(ItemGroup.MATERIALS)));

    public static final Item ROSE_QUARTZ = add("rose_quartz", new Item(new Item.Settings().group(ItemGroup.MATERIALS)));
    public static final Item SMOKY_QUARTZ = add("smoky_quartz", new Item(new Item.Settings().group(ItemGroup.MATERIALS)));
    public static final Item SULFUR_QUARTZ = add("sulfur_quartz", new Item(new Item.Settings().group(ItemGroup.MATERIALS)));
    
    public static final Item IVORY = add("ivory", new Item(new Item.Settings().group(ItemGroup.MATERIALS)));
    public static final Item IVORY_MARROW = add("ivory_marrow", new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(3).saturationModifier(3.0F).alwaysEdible().snack().build())));

    public static final Item MUSIC_DISC_LUMINOUS_PLANTATION = add("music_disc_luminous_plantation", new CinderscapesMusicDiscItem(14, CinderscapesSoundEvents.MUSIC_DISC_LUMINOUS_PLANTATION));
    public static final Item MUSIC_DISC_CHILLING_IN_HELL = add("music_disc_chilling_in_hell", new CinderscapesMusicDiscItem(14, CinderscapesSoundEvents.MUSIC_DISC_CHILLING_IN_HELL));

    private static <I extends Item> I add(String name, I item) {
        ITEMS.put(Cinderscapes.id(name), item);
        return item;
    }

    public static void init() {

        for (Identifier id : ITEMS.keySet()) {
            Registry.register(Registry.ITEM, id, ITEMS.get(id));
        }

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BRAMBLE_BERRIES, 0.3f);
    }
}
