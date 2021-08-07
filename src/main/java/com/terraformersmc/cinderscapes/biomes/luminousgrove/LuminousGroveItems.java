package com.terraformersmc.cinderscapes.biomes.luminousgrove;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.init.CinderscapesMusicEvents;
import com.terraformersmc.cinderscapes.item.CinderscapesMusicDiscItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;

public class LuminousGroveItems {

    public static final Item UMBRAL_SIGN = Cinderscapes.REGISTRATION_HELPER.register(new SignItem(new FabricItemSettings().maxCount(16), LuminousGroveBlocks.UMBRAL_SIGN, LuminousGroveBlocks.UMBRAL_WALL_SIGN), "umbral_sign");
    public static final Item MUSIC_DISC_LUMINOUS_PLANTATION = Cinderscapes.REGISTRATION_HELPER.register(new CinderscapesMusicDiscItem(CinderscapesMusicEvents.MUSIC_DISC_LUMINOUS_PLANTATION), "music_disc_luminous_plantation");

    public static void onInitializeCommon() { }
}
