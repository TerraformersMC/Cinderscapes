package com.terraformersmc.cinderscapes;

import com.terraformersmc.cinderscapes.init.CinderscapesArmorTrimItemModels;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;

@SuppressWarnings("unused")
@Environment(EnvType.CLIENT)
public class CinderscapesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        CinderscapesArmorTrimItemModels.init();

        BlockRenderLayerMap.putBlocks(ChunkSectionLayer.TRANSLUCENT,
                // Ashy Shoals

                // Blackstone Shales

                // Luminous Grove
                CinderscapesBlocks.GHASTLY_ECTOPLASM,
                CinderscapesBlocks.UMBRAL_WART_BLOCK,

                // Quartz Cavern
                CinderscapesBlocks.CRYSTALLINE_QUARTZ,
                CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ,
                CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ,
                CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ
        );

        BlockRenderLayerMap.putBlocks(ChunkSectionLayer.CUTOUT,
                // Ashy Shoals
                CinderscapesBlocks.BRAMBLE_BERRY_BUSH,
                CinderscapesBlocks.POTTED_PYRACINTH,
                CinderscapesBlocks.POTTED_SCORCHED_SHRUB,
                CinderscapesBlocks.POTTED_SCORCHED_TENDRILS,
                CinderscapesBlocks.PYRACINTH,
                CinderscapesBlocks.SCORCHED_SHRUB,
                CinderscapesBlocks.SCORCHED_SPROUTS,
                CinderscapesBlocks.SCORCHED_TENDRILS,

                // Blackstone Shales

                // Luminous Grove
                CinderscapesBlocks.LUMINOUS_POD,
                CinderscapesBlocks.PHOTOFERN,
                CinderscapesBlocks.POTTED_LUMINOUS_POD,
                CinderscapesBlocks.POTTED_PHOTOFERN,
                CinderscapesBlocks.POTTED_TWILIGHT_TENDRILS,
                CinderscapesBlocks.POTTED_UMBRAL_FUNGUS,
                CinderscapesBlocks.TALL_PHOTOFERN,
                CinderscapesBlocks.TWILIGHT_FESCUES,
                CinderscapesBlocks.TWILIGHT_TENDRILS,
                CinderscapesBlocks.UMBRAL_FUNGUS,
                CinderscapesBlocks.UMBRAL_DOOR,

                // Quartz Cavern
                CinderscapesBlocks.CRYSTINIUM,
                CinderscapesBlocks.POTTED_CRYSTINIUM,
                CinderscapesBlocks.POLYPITE_QUARTZ,
                CinderscapesBlocks.POLYPITE_ROSE_QUARTZ,
                CinderscapesBlocks.POLYPITE_SMOKY_QUARTZ,
                CinderscapesBlocks.POLYPITE_SULFUR_QUARTZ,
                CinderscapesBlocks.POTTED_POLYPITE_QUARTZ,
                CinderscapesBlocks.POTTED_POLYPITE_ROSE_QUARTZ,
                CinderscapesBlocks.POTTED_POLYPITE_SMOKY_QUARTZ,
                CinderscapesBlocks.POTTED_POLYPITE_SULFUR_QUARTZ
        );

        ItemTooltipCallback.EVENT.register((stack, context, type, lines) -> {
            if (stack.is(CinderscapesBlocks.NODZOL.asItem())) {
                lines.add(Component.translatable("block.cinderscapes.nodzol.description").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            }
        });
    }
}
