package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.block.*;
import com.terraformersmc.terraform.util.RecipeUtil;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.gen.feature.Feature;

import java.util.HashMap;
import java.util.Map;

// TODO: Check
public class CinderscapesBlocks {

    // Acts as a kind of local registry for block items added by Cinderscapes
    private static final Map<Identifier, BlockItem> ITEMS = new HashMap<>();
    // Acts as a kind of local registry for blocks added by Cinderscapes
    private static final Map<Identifier, Block> BLOCKS = new HashMap<>();

    /////////////////////
    // Withered Nylium //
    /////////////////////
    public static final Block WITHERED_NYLIUM = add("withered_nylium", new CinderscapesNyliumBlock(FabricBlockSettings.copyOf(Blocks.WARPED_NYLIUM).materialColor(MaterialColor.GRAY).breakByTool(FabricToolTags.PICKAXES)), ItemGroup.BUILDING_BLOCKS);
    public static final Block WITHERED_FUNGUS = add("withered_fungus", new CinderscapesFungusBlock(FabricBlockSettings.copyOf(Blocks.WARPED_FUNGUS).materialColor(MaterialColor.GRAY).breakByTool(FabricToolTags.PICKAXES), () -> null), ItemGroup.DECORATIONS);
    public static final Block WITHERED_STEM = add("withered_stem", new PillarBlock(FabricBlockSettings.copyOf(Blocks.WARPED_STEM).materialColor(MaterialColor.GRAY).breakByTool(FabricToolTags.AXES)), ItemGroup.BUILDING_BLOCKS);
    public static final Block WITHERED_WART_BLOCK = add("withered_wart_block", new Block(FabricBlockSettings.copyOf(Blocks.WARPED_WART_BLOCK).materialColor(MaterialColor.GRAY).breakByTool(FabricToolTags.HOES)), ItemGroup.BUILDING_BLOCKS);

    ///////////////////
    // Umbral Nylium //
    ///////////////////
    public static final Block UMBRAL_STEM = add("umbral_stem", new PillarBlock(FabricBlockSettings.copyOf(Blocks.WARPED_STEM).materialColor(MaterialColor.BLUE).breakByTool(FabricToolTags.AXES)), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_NYLIUM = add("umbral_nylium", new CinderscapesNyliumBlock(FabricBlockSettings.copyOf(Blocks.WARPED_NYLIUM).materialColor(MaterialColor.BLUE).breakByTool(FabricToolTags.PICKAXES)), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_FUNGUS = add("umbral_fungus", new CinderscapesFungusBlock(FabricBlockSettings.copyOf(Blocks.WARPED_FUNGUS).materialColor(MaterialColor.BLUE).breakByTool(FabricToolTags.PICKAXES).lightLevel(15), () -> Feature.HUGE_FUNGUS.configure(CinderscapesFeatures.UMBRAL_FUNGUS_CONFIG)), ItemGroup.DECORATIONS);
    public static Block UMBRAL_WART_BLOCK = add("umbral_wart_block", new Block(FabricBlockSettings.copyOf(Blocks.WARPED_WART_BLOCK).materialColor(MaterialColor.BLUE).breakByTool(FabricToolTags.HOES).nonOpaque()), ItemGroup.BUILDING_BLOCKS);
    public static Block UMBRAL_FLESH_BLOCK = add("umbral_flesh_block", new Block(FabricBlockSettings.copyOf(UMBRAL_WART_BLOCK).breakByTool(FabricToolTags.HOES).lightLevel(15)), ItemGroup.BUILDING_BLOCKS);


    ///////////
    // Other //
    ///////////
    public static final Block CHARRED_BONE_BLOCK = add("charred_bone_block", new PillarBlock(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK).materialColor(MaterialColor.GRAY).breakByTool(FabricToolTags.PICKAXES)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SLATE = add("slate", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SULFUR_BLOCK = add("sulfur_block", new Block(FabricBlockSettings.of(Material.SAND).strength(0.5F, 0.5f)), ItemGroup.BUILDING_BLOCKS);
    public static final Block RADIANT_SLATE = add("radiant_slate", new Block(FabricBlockSettings.copy(Blocks.BLACKSTONE).lightLevel((state) -> 12)), ItemGroup.BUILDING_BLOCKS);
    public static final Block FLAY = add("flay", new CinderscapesNetherPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS).lightLevel((state) -> 8), (state) -> VoxelShapes.fullCube()), ItemGroup.DECORATIONS);
    public static final Block RADIANT_ROOTS = add("radiant_roots", new CinderscapesNetherPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS).lightLevel((state) -> 8), (state) -> VoxelShapes.fullCube()), ItemGroup.DECORATIONS);

    public static Block TWILIGHT_TENDRILS = add("twilight_tendrils", new CinderscapesNetherPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS).lightLevel((state) -> 15), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0)), ItemGroup.DECORATIONS);
    public static Block TWILIGHT_FESCUES = add("twilight_fescues", new CinderscapesNetherPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0)), ItemGroup.DECORATIONS);
    public static Block PHOTOFERN = add("photofern", new CinderscapesNetherPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0)), ItemGroup.DECORATIONS);
    public static Block TALL_PHOTOFERN = add("tall_photofern", new CinderscapesNetherTallPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS), (state) -> Block.createCuboidShape(2.0, 0, 2.0, 14.0, 16.0, 14.0)), ItemGroup.DECORATIONS);
    public static Block LUMINOUS_POD = add("luminous_pod", new CinderscapesNetherTallPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS).lightLevel((state) -> 15), (state) -> Block.createCuboidShape(2.0, 0, 2.0, 14.0, 16.0, 14.0)), ItemGroup.DECORATIONS);

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
