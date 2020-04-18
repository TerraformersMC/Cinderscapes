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

    public static Block LUMINOUS_STEM;
    public static Block STRIPPED_LUMINOUS_STEM;
    public static Block LUMINOUS_HYPHAE;
    public static Block STRIPPED_LUMINOUS_HYPHAE;

    public static Block LUMINOUS_NYLIUM;
    public static Block LUMINOUS_FUNGUS;
    public static Block LUMINOUS_TENDRILS;
    public static Block LUMINOUS_WART_BLOCK;
    public static Block LUMINOUS_FLESH_BLOCK;



    public static Block PHOTOFERN;
    public static Block TALL_PHOTOFERN;
    public static Block LUMINOUS_POD;
    public static Block LUMINOUS_FESCUES;

    public static void init() {
        LUMINOUS_TENDRILS = register("luminous_tendrils", new NetherPlantBlock(FabricBlockSettings.of(Material.REPLACEABLE_PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.NYLIUM).build()));
        LUMINOUS_FESCUES = register("luminous_fescues", new NetherPlantBlock(FabricBlockSettings.of(Material.REPLACEABLE_PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.NYLIUM).build()));


        PHOTOFERN = register("photofern", new NetherPlantBlock(FabricBlockSettings.of(Material.REPLACEABLE_PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.NYLIUM).build()));
        TALL_PHOTOFERN = register("tall_photofern", new NetherTallPlantBlock(FabricBlockSettings.of(Material.REPLACEABLE_PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.NYLIUM).build()));


        LUMINOUS_POD = register("luminous_pod", new NetherTallPlantBlock(FabricBlockSettings.of(Material.REPLACEABLE_PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.NYLIUM).lightLevel(15).build()));


        BlockRenderLayerMapImpl.INSTANCE.putBlock(PHOTOFERN, RenderLayer.getCutout());
        BlockRenderLayerMapImpl.INSTANCE.putBlock(TALL_PHOTOFERN, RenderLayer.getCutout());
        BlockRenderLayerMapImpl.INSTANCE.putBlock(LUMINOUS_POD, RenderLayer.getCutout());
        BlockRenderLayerMapImpl.INSTANCE.putBlock(LUMINOUS_TENDRILS, RenderLayer.getCutout());
        BlockRenderLayerMapImpl.INSTANCE.putBlock(LUMINOUS_FESCUES, RenderLayer.getCutout());




        LUMINOUS_STEM = register("umbrus_stem", new PillarBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MaterialColor.BLUE).strength(1.0F, 1.0F).sounds(BlockSoundGroup.NETHER_STEM).build()));
        STRIPPED_LUMINOUS_STEM = register("stripped_luminous_stem", new PillarBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MaterialColor.BLUE).strength(1.0F, 1.0F).sounds(BlockSoundGroup.NETHER_STEM).build()));
        LUMINOUS_HYPHAE = register("luminous_hyphae", new PillarBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MaterialColor.BLUE).strength(2.0F, 2.0F).sounds(BlockSoundGroup.NETHER_STEM).build()));
        STRIPPED_LUMINOUS_HYPHAE = register("stripped_luminous_hyphae", new PillarBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MaterialColor.BLUE).strength(2.0F, 2.0F).sounds(BlockSoundGroup.NETHER_STEM).build()));
        LUMINOUS_NYLIUM = register("luminous_nylium", new NyliumBlock(FabricBlockSettings.of(Material.STONE, MaterialColor.BLUE).strength(1.0F, 1.0F).sounds(BlockSoundGroup.NYLIUM).ticksRandomly().build()));

        LUMINOUS_FUNGUS = register("umbrus_fungus", new FungusBlock(FabricBlockSettings.of(Material.PLANT).breakInstantly().noCollision().sounds(BlockSoundGroup.FUNGUS).lightLevel(15).build(), () -> Feature.HUGE_FUNGUS.configure(CinderscapesFeatures.LUMINOUS_FUNGUS_CONFIG)));

        BlockRenderLayerMapImpl.INSTANCE.putBlock(LUMINOUS_FUNGUS, RenderLayer.getCutout());

        LUMINOUS_WART_BLOCK = register("umbrus_wart_block", new Block(FabricBlockSettings.of(Material.ORGANIC, MaterialColor.BLUE).strength(1.0F, 1.0F).sounds(BlockSoundGroup.WART_BLOCK).build()));
        LUMINOUS_FLESH_BLOCK = register("umbrus_flesh_block", new Block(FabricBlockSettings.of(Material.ORGANIC).strength(1.0F, 1.0F).sounds(BlockSoundGroup.WART_BLOCK).lightLevel(7).build()));
    }

    private static Block register(String id, Block block) {
        Registry.register(Registry.ITEM, new Identifier("cinderscapes", id), new BlockItem(block, new Item.Settings().group(ItemGroup.MISC)));
        return Registry.register(Registry.BLOCK, new Identifier("cinderscapes", id), block);
    }
}
