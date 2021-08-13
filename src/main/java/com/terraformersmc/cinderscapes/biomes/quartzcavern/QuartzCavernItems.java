package com.terraformersmc.cinderscapes.biomes.quartzcavern;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.text.Style;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

public class QuartzCavernItems {

    public static final Item ROSE_QUARTZ = Cinderscapes.REGISTRATION_HELPER.register(new Item(new FabricItemSettings()), "rose_quartz");
    public static final Item SMOKY_QUARTZ = Cinderscapes.REGISTRATION_HELPER.register(new Item(new FabricItemSettings()), "smoky_quartz");
    public static final Item SULFUR_QUARTZ = Cinderscapes.REGISTRATION_HELPER.register(new Item(new FabricItemSettings()), "sulfur_quartz");

    public static void onInitializeCommon() { }

    public static void onInitializeClient() { }
}
