package com.terraformersmc.cinderscapes.block;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.terraform.util.RecipeUtil;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

public class CinderscapesBlocks {

    private static final Map<Identifier, BlockItem> ITEMS = new HashMap<>();
    private static final Map<Identifier, Block> BLOCKS = new HashMap<>();

    public static final Block WITHERED_NYLIUM = add("withered_nylium", new CinderscapesNyliumBlock(FabricBlockSettings.copy(Blocks.WARPED_NYLIUM).materialColor(MaterialColor.GRAY).breakByTool(FabricToolTags.PICKAXES).build()), ItemGroup.BUILDING_BLOCKS);
    public static final Block WITHERED_FUNGUS = add("withered_fungus", new CinderscapesFungusBlock(FabricBlockSettings.copy(Blocks.WARPED_FUNGUS).materialColor(MaterialColor.GRAY).breakByTool(FabricToolTags.PICKAXES).build(), () -> null), ItemGroup.DECORATIONS);
    public static final Block WITHERED_STEM = add("withered_stem", new PillarBlock(FabricBlockSettings.copy(Blocks.WARPED_STEM).materialColor(MaterialColor.GRAY).breakByTool(FabricToolTags.AXES).build()), ItemGroup.BUILDING_BLOCKS);
    public static final Block WITHERED_WART_BLOCK = add("withered_wart_block", new Block(FabricBlockSettings.copy(Blocks.WARPED_WART_BLOCK).materialColor(MaterialColor.GRAY).breakByTool(FabricToolTags.HOES).build()), ItemGroup.BUILDING_BLOCKS);
    public static final Block CHARRED_BONE_BLOCK = add("charred_bone_block", new PillarBlock(FabricBlockSettings.copy(Blocks.BONE_BLOCK).materialColor(MaterialColor.GRAY).breakByTool(FabricToolTags.PICKAXES).build()), ItemGroup.BUILDING_BLOCKS);
    public static final Block SLATE = add("slate", new Block(FabricBlockSettings.copy(Blocks.BLACKSTONE).build()), ItemGroup.BUILDING_BLOCKS);
    public static final Block SULFUR_BLOCK = add("sulfur_block", new Block(FabricBlockSettings.of(Material.SAND).strength(0.5F, 0.5f).build()), ItemGroup.BUILDING_BLOCKS);
    public static final Block RADIANT_SLATE = add("radiant_slate", new Block(FabricBlockSettings.copy(Blocks.BLACKSTONE).lightLevel(12).build()), ItemGroup.BUILDING_BLOCKS);
    public static final Block FLAY = add("flay", new CinderscapesRootsBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS).lightLevel(12).build()), ItemGroup.DECORATIONS);
    public static final Block RADIANT_ROOTS = add("radiant_roots", new CinderscapesRootsBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS).lightLevel(8).build()), ItemGroup.DECORATIONS);

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

    public static void register() {
        for (Identifier id : ITEMS.keySet()) {
            Registry.register(Registry.ITEM, id, ITEMS.get(id));
        }
        for (Identifier id : BLOCKS.keySet()) {
            Registry.register(Registry.BLOCK, id, BLOCKS.get(id));
        }
    }
}
