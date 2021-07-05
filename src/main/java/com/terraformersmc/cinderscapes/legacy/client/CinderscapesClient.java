package com.terraformersmc.cinderscapes.legacy.client;

import com.terraformersmc.cinderscapes.legacy.init.CinderscapesBlocks;
import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;

@SuppressWarnings("unused")
@Environment(EnvType.CLIENT)
public class CinderscapesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // TODO: Find a more elegant way to add blocks to their render layers

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(),
                CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ,
                CinderscapesBlocks.CRYSTALLINE_QUARTZ,
                CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ,
                CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ
        );
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                CinderscapesBlocks.SCORCHED_SHRUB,
                CinderscapesBlocks.POTTED_SCORCHED_SHRUB,
                CinderscapesBlocks.SCORCHED_SPROUTS,
                CinderscapesBlocks.BRAMBLE_BERRY_BUSH,
                CinderscapesBlocks.PYRACINTH,
                CinderscapesBlocks.POTTED_PYRACINTH,
                CinderscapesBlocks.CRYSTINIUM,
                CinderscapesBlocks.POTTED_CRYSTINIUM,
                CinderscapesBlocks.SCORCHED_TENDRILS,
                CinderscapesBlocks.POTTED_SCORCHED_TENDRILS,
                CinderscapesBlocks.POLYPITE_ROSE_QUARTZ,
                CinderscapesBlocks.POTTED_POLYPITE_ROSE_QUARTZ,
                CinderscapesBlocks.POLYPITE_QUARTZ,
                CinderscapesBlocks.POTTED_POLYPITE_QUARTZ,
                CinderscapesBlocks.POLYPITE_SMOKY_QUARTZ,
                CinderscapesBlocks.POTTED_POLYPITE_SMOKY_QUARTZ,
                CinderscapesBlocks.POLYPITE_SULFUR_QUARTZ,
                CinderscapesBlocks.POTTED_POLYPITE_SULFUR_QUARTZ
        );


        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ((TerraformSignBlock) CinderscapesBlocks.SCORCHED_SIGN).getTexture()));
    }
}