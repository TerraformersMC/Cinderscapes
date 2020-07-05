package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.terraform.util.RecipeUtil;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <Wtoll> Will Toll on 2020-05-24
 * @project Cinderscapes
 */
public class CinderscapesItems {

    public static final Item BRAMBLE_BERRIES = add("bramble_berries", new AliasedBlockItem(CinderscapesBlocks.BRAMBLE_BERRY_BUSH, new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.1F).alwaysEdible().snack().statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 2400, 0), 1.0F).build())));


    public static final Item UMBRAL_SIGN = add("umbral_sign", new SignItem(new Item.Settings().maxCount(16).group(ItemGroup.DECORATIONS), CinderscapesBlocks.UMBRAL_SIGN, CinderscapesBlocks.UMBRAL_WALL_SIGN));

    public static final Item SCORCHED_SIGN = add("scorched_sign", new SignItem(new Item.Settings().maxCount(16).group(ItemGroup.DECORATIONS), CinderscapesBlocks.SCORCHED_SIGN, CinderscapesBlocks.SCORCHED_WALL_SIGN));
    public static final Item ASH_PILE = add("ash_pile", new Item(new Item.Settings().group(ItemGroup.MATERIALS)));

    public static final Item SULFUR = add("sulfur", new Item(new Item.Settings().group(ItemGroup.MATERIALS)));

    public static final Item ROSE_QUARTZ = add("rose_quartz", new Item(new Item.Settings().group(ItemGroup.MATERIALS)));
    public static final Item SMOKY_QUARTZ = add("smoky_quartz", new Item(new Item.Settings().group(ItemGroup.MATERIALS)));
    public static final Item SULFUR_QUARTZ = add("sulfur_quartz", new Item(new Item.Settings().group(ItemGroup.MATERIALS)));

    private static <I extends Item> I add(String name, I item) {
        return Registry.register(Registry.ITEM, Cinderscapes.id(name), item);
    }

    public static void init() {}
}
