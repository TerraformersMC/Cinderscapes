package com.terraformersmc.cinderscapes.biomes.ashyshoals;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;

public class AshyShoalsItems {

    public static final Item SCORCHED_SIGN = Cinderscapes.REGISTRATION_HELPER.register(new SignItem(new FabricItemSettings().maxCount(16), AshyShoalsBlocks.SCORCHED_SIGN, AshyShoalsBlocks.SCORCHED_WALL_SIGN), "scorched_sign");

    public static void onInitializeCommon() { }
}
