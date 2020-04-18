package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.block.FungusBlock;
import com.terraformersmc.cinderscapes.block.NetherPlantBlock;
import com.terraformersmc.cinderscapes.block.NetherTallPlantBlock;
import com.terraformersmc.cinderscapes.block.NyliumBlock;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;

public class CinderscapesBlocks {

    public static Block UMBRAL_STEM;
    public static Block STRIPPED_UMBRAL_STEM;
    public static Block UMBRAL_HYPHAE;
    public static Block STRIPPED_UMBRAL_HYPHAE;
    public static Block UMBRAL_NYLIUM;
    public static Block UMBRAL_FUNGUS;
    public static Block UMBRAL_WART_BLOCK;
    public static Block UMBRAL_FLESH_BLOCK;

    public static Block TWILIGHT_TENDRILS;
    public static Block TWILIGHT_FESCUES;

    public static Block PHOTOFERN;
    public static Block TALL_PHOTOFERN;

    public static Block LUMINOUS_POD;

    public static void init() {
        UMBRAL_STEM = register("umbral_stem", new PillarBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MaterialColor.BLUE).strength(1.0F, 1.0F).sounds(BlockSoundGroup.NETHER_STEM).lightLevel(15).build()));
        STRIPPED_UMBRAL_STEM = register("stripped_umbral_stem", new PillarBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MaterialColor.BLUE).strength(1.0F, 1.0F).sounds(BlockSoundGroup.NETHER_STEM).build()));
        UMBRAL_HYPHAE = register("umbral_hyphae", new PillarBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MaterialColor.BLUE).strength(2.0F, 2.0F).sounds(BlockSoundGroup.NETHER_STEM).build()));
        STRIPPED_UMBRAL_HYPHAE = register("stripped_umbral_hyphae", new PillarBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MaterialColor.BLUE).strength(2.0F, 2.0F).sounds(BlockSoundGroup.NETHER_STEM).build()));
        UMBRAL_NYLIUM = register("umbral_nylium", new NyliumBlock(FabricBlockSettings.of(Material.STONE, MaterialColor.BLUE).strength(1.0F, 1.0F).sounds(BlockSoundGroup.NYLIUM).ticksRandomly().build()));
        UMBRAL_FUNGUS = register("umbral_fungus", new FungusBlock(FabricBlockSettings.of(Material.PLANT).breakInstantly().noCollision().sounds(BlockSoundGroup.FUNGUS).lightLevel(15).build(), () -> Feature.HUGE_FUNGUS.configure(CinderscapesFeatures.UMBRAL_FUNGUS_CONFIG)));
        UMBRAL_WART_BLOCK = register("umbral_wart_block", new Block(FabricBlockSettings.of(Material.ORGANIC, MaterialColor.BLUE).strength(1.0F, 1.0F).sounds(BlockSoundGroup.WART_BLOCK).build()));
        UMBRAL_FLESH_BLOCK = register("umbral_flesh_block", new Block(FabricBlockSettings.of(Material.ORGANIC).strength(1.0F, 1.0F).sounds(BlockSoundGroup.WART_BLOCK).lightLevel(15).build()));

        TWILIGHT_TENDRILS = register("twilight_tendrils", new NetherPlantBlock(FabricBlockSettings.of(Material.REPLACEABLE_PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.NYLIUM).build()));
        TWILIGHT_FESCUES = register("twilight_fescues", new NetherPlantBlock(FabricBlockSettings.of(Material.REPLACEABLE_PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.NYLIUM).build()));

        PHOTOFERN = register("photofern", new NetherPlantBlock(FabricBlockSettings.of(Material.REPLACEABLE_PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.NYLIUM).build()));
        TALL_PHOTOFERN = register("tall_photofern", new NetherTallPlantBlock(FabricBlockSettings.of(Material.REPLACEABLE_PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.NYLIUM).build()));

        LUMINOUS_POD = register("luminous_pod", new NetherTallPlantBlock(FabricBlockSettings.of(Material.REPLACEABLE_PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.NYLIUM).lightLevel(15).build()));

        BlockRenderLayerMapImpl.INSTANCE.putBlock(PHOTOFERN, RenderLayer.getCutout());
        BlockRenderLayerMapImpl.INSTANCE.putBlock(TALL_PHOTOFERN, RenderLayer.getCutout());
        BlockRenderLayerMapImpl.INSTANCE.putBlock(LUMINOUS_POD, RenderLayer.getCutout());
        BlockRenderLayerMapImpl.INSTANCE.putBlock(TWILIGHT_TENDRILS, RenderLayer.getCutout());
        BlockRenderLayerMapImpl.INSTANCE.putBlock(TWILIGHT_FESCUES, RenderLayer.getCutout());
        BlockRenderLayerMapImpl.INSTANCE.putBlock(UMBRAL_FUNGUS, RenderLayer.getCutout());
    }

    private static Block register(String id, Block block) {
        Registry.register(Registry.ITEM, new Identifier("cinderscapes", id), new BlockItem(block, new Item.Settings().group(ItemGroup.MISC)));
        return Registry.register(Registry.BLOCK, new Identifier("cinderscapes", id), block);
    }
}
