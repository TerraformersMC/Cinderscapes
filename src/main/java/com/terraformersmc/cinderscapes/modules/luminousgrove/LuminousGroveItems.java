package com.terraformersmc.cinderscapes.modules.luminousgrove;

import com.terraformersmc.cinderscapes.helper.RegistryHelper;
import com.terraformersmc.cinderscapes.legacy.item.CinderscapesMusicDiscItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SignItem;

public class LuminousGroveItems {

    public static final Item UMBRAL_SIGN = RegistryHelper.register("umbral_sign", new SignItem(new Item.Settings().maxCount(16).group(ItemGroup.DECORATIONS), LuminousGroveBlocks.UMBRAL_SIGN, LuminousGroveBlocks.UMBRAL_WALL_SIGN));
    public static final Item MUSIC_DISC_LUMINOUS_PLANTATION = RegistryHelper.register("music_disc_luminous_plantation", new CinderscapesMusicDiscItem(14, LuminousGroveSoundEvents.MUSIC_DISC_LUMINOUS_PLANTATION));

    public static void onInitialize() {  }
}
