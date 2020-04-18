package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.block.*;
import com.terraformersmc.terraform.util.RecipeUtil;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.SimpleVoxelShape;
import net.minecraft.world.gen.feature.Feature;

import java.util.HashMap;
import java.util.Map;

public class CinderscapesBlocks {

    private static final Map<Identifier, BlockItem> ITEMS = new HashMap<>();
    private static final Map<Identifier, Block> BLOCKS = new HashMap<>();

    /////////////////////
    // Withered Nylium //
    /////////////////////
    public static final Block WITHERED_NYLIUM = add("withered_nylium", new CinderscapesNyliumBlock(FabricBlockSettings.copy(Blocks.WARPED_NYLIUM).materialColor(MaterialColor.GRAY).breakByTool(FabricToolTags.PICKAXES).build()), ItemGroup.BUILDING_BLOCKS);
    public static final Block WITHERED_FUNGUS = add("withered_fungus", new CinderscapesFungusBlock(FabricBlockSettings.copy(Blocks.WARPED_FUNGUS).materialColor(MaterialColor.GRAY).breakByTool(FabricToolTags.PICKAXES).build(), () -> null), ItemGroup.DECORATIONS);
    public static final Block WITHERED_STEM = add("withered_stem", new PillarBlock(FabricBlockSettings.copy(Blocks.WARPED_STEM).materialColor(MaterialColor.GRAY).breakByTool(FabricToolTags.AXES).build()), ItemGroup.BUILDING_BLOCKS);
    public static final Block WITHERED_WART_BLOCK = add("withered_wart_block", new Block(FabricBlockSettings.copy(Blocks.WARPED_WART_BLOCK).materialColor(MaterialColor.GRAY).breakByTool(FabricToolTags.HOES).build()), ItemGroup.BUILDING_BLOCKS);

    ///////////////////
    // Umbral Nylium //
    ///////////////////
    public static final Block UMBRAL_STEM = add("umbral_stem", new PillarBlock(FabricBlockSettings.copy(Blocks.WARPED_STEM).materialColor(MaterialColor.BLUE).breakByTool(FabricToolTags.AXES).build()), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_NYLIUM = add("umbral_nylium", new CinderscapesNyliumBlock(FabricBlockSettings.copy(Blocks.WARPED_NYLIUM).materialColor(MaterialColor.BLUE).breakByTool(FabricToolTags.PICKAXES).build()), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_FUNGUS = add("umbral_fungus", new CinderscapesFungusBlock(FabricBlockSettings.copy(Blocks.WARPED_FUNGUS).materialColor(MaterialColor.BLUE).breakByTool(FabricToolTags.PICKAXES).build(), () -> Feature.HUGE_FUNGUS.configure(CinderscapesFeatures.UMBRAL_FUNGUS_CONFIG)), ItemGroup.DECORATIONS);
    public static Block UMBRAL_WART_BLOCK = add("umbral_wart_block", new Block(FabricBlockSettings.copy(Blocks.WARPED_WART_BLOCK).materialColor(MaterialColor.BLUE).breakByTool(FabricToolTags.HOES).build()), ItemGroup.BUILDING_BLOCKS);
    public static Block UMBRAL_FLESH_BLOCK = add("umbral_flesh_block", new Block(FabricBlockSettings.copy(UMBRAL_WART_BLOCK).breakByTool(FabricToolTags.HOES).build()));


    ///////////
    // Other //
    ///////////
    public static final Block CHARRED_BONE_BLOCK = add("charred_bone_block", new PillarBlock(FabricBlockSettings.copy(Blocks.BONE_BLOCK).materialColor(MaterialColor.GRAY).breakByTool(FabricToolTags.PICKAXES).build()), ItemGroup.BUILDING_BLOCKS);
    public static final Block SLATE = add("slate", new Block(FabricBlockSettings.copy(Blocks.BLACKSTONE).build()), ItemGroup.BUILDING_BLOCKS);
    public static final Block RADIANT_SLATE = add("radiant_slate", new Block(FabricBlockSettings.copy(Blocks.BLACKSTONE).lightLevel(12).build()), ItemGroup.BUILDING_BLOCKS);
    public static final Block FLAY = add("flay", new CinderscapesRootsBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS).lightLevel(12).build()), ItemGroup.DECORATIONS);
    public static final Block RADIANT_ROOTS = add("radiant_roots", new CinderscapesRootsBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS).lightLevel(8).build()), ItemGroup.DECORATIONS);

    public static Block TWILIGHT_TENDRILS = add("twilight_tendrils", new NetherPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS).build(), Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0)), ItemGroup.DECORATIONS);
    public static Block TWILIGHT_FESCUES = add("twilight_fescues", new NetherPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS).build(), Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0)), ItemGroup.DECORATIONS);
    public static Block PHOTOFERN = add("photofern", new NetherPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS).build(), Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0)), ItemGroup.DECORATIONS);
    public static Block TALL_PHOTOFERN = add("tall_photofern", new NetherTallPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS).build(), Block.createCuboidShape(2.0, 0, 2.0, 14.0, 16.0, 14.0)), ItemGroup.DECORATIONS);
    public static Block LUMINOUS_POD = add("luminous_pod", new NetherTallPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS).lightLevel(15).build(), Block.createCuboidShape(2.0, 0, 2.0, 14.0, 16.0, 14.0)), ItemGroup.DECORATIONS);

    private static <B extends Block> B add(String name, B block, ItemGroup tab) {
        return add(name, block, new BlockItem(block, new Item.Settings().group(tab)));
    }

    private static <B extends Block> B add(String name, B block, BlockItem item) {
        add(name, block);
        if (item != null) {
            item.appendBlocks(Item.BLOCK_ITEMS, item);
            ITEMS.put(Cinderscapes.id(name), item);
            RecipeUtil.registerCompostableBlock(block);
        }
        return block;
    }

    private static <B extends Block> B add(String name, B block) {
        BLOCKS.put(Cinderscapes.id(name), block);
        return block;
    }

    private static <I extends BlockItem> I add(String name, I item) {
        item.appendBlocks(Item.BLOCK_ITEMS, item);
        ITEMS.put(Cinderscapes.id(name), item);
        return item;
    }

    public static void init() {
        for (Identifier id : ITEMS.keySet()) {
            Registry.register(Registry.ITEM, id, ITEMS.get(id));
        }
        for (Identifier id : BLOCKS.keySet()) {
            Registry.register(Registry.BLOCK, id, BLOCKS.get(id));
        }
    }
}
