package com.terraformersmc.cinderscapes;

import com.terraformersmc.cinderscapes.init.CinderscapesArmorTrimItemModels;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;

@SuppressWarnings("unused")
public class CinderscapesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        CinderscapesArmorTrimItemModels.init();

        ItemTooltipCallback.EVENT.register((stack, context, type, lines) -> {
            if (stack.is(CinderscapesBlocks.NODZOL.asItem())) {
                lines.add(Component.translatable("block.cinderscapes.nodzol.description").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            }
        });
    }
}
