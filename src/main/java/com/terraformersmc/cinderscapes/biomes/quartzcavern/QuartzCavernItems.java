package com.terraformersmc.cinderscapes.biomes.quartzcavern;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class QuartzCavernItems {

    public static final Item ROSE_QUARTZ = Cinderscapes.REGISTRATION_HELPER.register(new Item(new FabricItemSettings()), "rose_quartz");
    public static final Item SMOKY_QUARTZ = Cinderscapes.REGISTRATION_HELPER.register(new Item(new FabricItemSettings()), "smoky_quartz");
    public static final Item SULFUR_QUARTZ = Cinderscapes.REGISTRATION_HELPER.register(new Item(new FabricItemSettings()), "sulfur_quartz");

    public static void onInitializeCommon() { }

    public static void onInitializeClient() { }
}
