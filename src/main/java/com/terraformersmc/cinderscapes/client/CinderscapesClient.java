package com.terraformersmc.cinderscapes.client;

import com.terraformersmc.cinderscapes.block.CinderscapesBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class CinderscapesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), CinderscapesBlocks.FLAY, CinderscapesBlocks.WITHERED_FUNGUS, CinderscapesBlocks.RADIANT_ROOTS);
    }
}
