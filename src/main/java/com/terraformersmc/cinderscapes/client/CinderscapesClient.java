package com.terraformersmc.cinderscapes.client;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class CinderscapesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), CinderscapesBlocks.UMBRAL_WART_BLOCK);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), CinderscapesBlocks.FLAY, CinderscapesBlocks.WITHERED_FUNGUS, CinderscapesBlocks.RADIANT_ROOTS, CinderscapesBlocks.PHOTOFERN, CinderscapesBlocks.TALL_PHOTOFERN, CinderscapesBlocks.LUMINOUS_POD, CinderscapesBlocks.TWILIGHT_FESCUES, CinderscapesBlocks.TWILIGHT_TENDRILS, CinderscapesBlocks.UMBRAL_FUNGUS);
    }
}
