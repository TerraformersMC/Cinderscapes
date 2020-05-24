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
    public static final Block WITHERED_STEM = add("withered_stem", new PillarBlock(FabricBlockSettings.copyOf(Blocks.WARPED_STEM).materialColor(MaterialColor.GRAY).breakByTool(FabricToolTags.AXES)), ItemGroup.BUILDING_BLOCKS);

    ///////////////////
    // Umbral Nylium //
    ///////////////////
    public static final Block UMBRAL_STEM = add("umbral_stem", new PillarBlock(FabricBlockSettings.copyOf(Blocks.WARPED_STEM).materialColor(MaterialColor.BLUE).breakByTool(FabricToolTags.AXES)), ItemGroup.BUILDING_BLOCKS);
    public static final Block STRIPPED_UMBRAL_STEM = add("stripped_umbral_stem", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_WARPED_STEM).materialColor(MaterialColor.BLUE).breakByTool(FabricToolTags.AXES)), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_NYLIUM = add("umbral_nylium", new CinderscapesNyliumBlock(FabricBlockSettings.copyOf(Blocks.WARPED_NYLIUM).materialColor(MaterialColor.BLUE).breakByTool(FabricToolTags.PICKAXES)), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_FUNGUS = add("umbral_fungus", new CinderscapesFungusBlock(FabricBlockSettings.copyOf(Blocks.WARPED_FUNGUS).materialColor(MaterialColor.BLUE).breakByTool(FabricToolTags.PICKAXES).lightLevel(15), () -> Feature.HUGE_FUNGUS.configure(CinderscapesFeatures.UMBRAL_FUNGUS_CONFIG)), ItemGroup.DECORATIONS);
    public static Block UMBRAL_WART_BLOCK = add("umbral_wart_block", new Block(FabricBlockSettings.copyOf(Blocks.WARPED_WART_BLOCK).materialColor(MaterialColor.BLUE).breakByTool(FabricToolTags.HOES).nonOpaque()), ItemGroup.BUILDING_BLOCKS);
    public static Block UMBRAL_FLESH_BLOCK = add("umbral_flesh_block", new Block(FabricBlockSettings.copyOf(UMBRAL_WART_BLOCK).breakByTool(FabricToolTags.HOES).lightLevel(15)), ItemGroup.BUILDING_BLOCKS);

    ///////////
    // Other //
    ///////////
    public static final Block SULFUR_BLOCK = add("sulfur_block", new Block(FabricBlockSettings.of(Material.SAND).strength(0.5F, 0.5f)), ItemGroup.BUILDING_BLOCKS);

    public static Block TWILIGHT_TENDRILS = add("twilight_tendrils", new CinderscapesNetherPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS).lightLevel((state) -> 15), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0)), ItemGroup.DECORATIONS);
    public static Block TWILIGHT_FESCUES = add("twilight_fescues", new CinderscapesNetherPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0)), ItemGroup.DECORATIONS);
    public static Block PHOTOFERN = add("photofern", new CinderscapesNetherPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0)), ItemGroup.DECORATIONS);
    public static Block TALL_PHOTOFERN = add("tall_photofern", new CinderscapesNetherTallPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS), (state) -> Block.createCuboidShape(2.0, 0, 2.0, 14.0, 16.0, 14.0)), ItemGroup.DECORATIONS);
    public static Block LUMINOUS_POD = add("luminous_pod", new CinderscapesNetherTallPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS).lightLevel((state) -> 15), (state) -> Block.createCuboidShape(2.0, 0, 2.0, 14.0, 16.0, 14.0)), ItemGroup.DECORATIONS);

    ///////////////////
    // Sulfur Quartz //
    ///////////////////

    public static final Block SULFUR_QUARTZ_ORE = add("sulfur_quartz_ore", new Block(FabricBlockSettings.copyOf(Blocks.NETHER_QUARTZ_ORE).materialColor(MaterialColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SULFUR_QUARTZ_BLOCK = add("sulfur_quartz_block", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).materialColor(MaterialColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block CHISELED_SULFUR_QUARTZ_BLOCK = add("chiseled_sulfur_quartz_block", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).materialColor(MaterialColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SULFUR_QUARTZ_PILLAR = add("sulfur_quartz_pillar", new PillarBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_PILLAR).materialColor(MaterialColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SULFUR_QUARTZ_STAIRS = add("sulfur_quartz_stairs", new CinderscapesStairsBlock(SULFUR_QUARTZ_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.QUARTZ_STAIRS).materialColor(MaterialColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SULFUR_QUARTZ_SLAB = add("sulfur_quartz_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_SLAB).materialColor(MaterialColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_SULFUR_QUARTZ = add("smooth_sulfur_quartz", new Block(FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ).materialColor(MaterialColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_SULFUR_QUARTZ_STAIRS = add("smooth_sulfur_quartz_stairs", new CinderscapesStairsBlock(SMOOTH_SULFUR_QUARTZ.getDefaultState(), FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_STAIRS).materialColor(MaterialColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_SULFUR_QUARTZ_SLAB = add("smooth_sulfur_quartz_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_SLAB).materialColor(MaterialColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SULFUR_QUARTZ_BRICKS = add("sulfur_quartz_bricks", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BRICKS).materialColor(MaterialColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);

    /////////////////
    // Rose Quartz //
    /////////////////

    public static final Block ROSE_QUARTZ_ORE = add("rose_quartz_ore", new Block(FabricBlockSettings.copyOf(Blocks.NETHER_QUARTZ_ORE).materialColor(MaterialColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block ROSE_QUARTZ_BLOCK = add("rose_quartz_block", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).materialColor(MaterialColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block CHISELED_ROSE_QUARTZ_BLOCK = add("chiseled_rose_quartz_block", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).materialColor(MaterialColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block ROSE_QUARTZ_PILLAR = add("rose_quartz_pillar", new PillarBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_PILLAR).materialColor(MaterialColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block ROSE_QUARTZ_STAIRS = add("rose_quartz_stairs", new CinderscapesStairsBlock(ROSE_QUARTZ_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.QUARTZ_STAIRS).materialColor(MaterialColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block ROSE_QUARTZ_SLAB = add("rose_quartz_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_SLAB).materialColor(MaterialColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_ROSE_QUARTZ = add("smooth_rose_quartz", new Block(FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ).materialColor(MaterialColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_ROSE_QUARTZ_STAIRS = add("smooth_rose_quartz_stairs", new CinderscapesStairsBlock(SMOOTH_ROSE_QUARTZ.getDefaultState(), FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_STAIRS).materialColor(MaterialColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_ROSE_QUARTZ_SLAB = add("smooth_rose_quartz_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_SLAB).materialColor(MaterialColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block ROSE_QUARTZ_BRICKS = add("rose_quartz_bricks", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BRICKS).materialColor(MaterialColor.PINK)), ItemGroup.BUILDING_BLOCKS);

    ///////////////////
    // Smoky Quartz //
    ///////////////////

    public static final Block SMOKY_QUARTZ_ORE = add("smoky_quartz_ore", new Block(FabricBlockSettings.copyOf(Blocks.NETHER_QUARTZ_ORE).materialColor(MaterialColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOKY_QUARTZ_BLOCK = add("smoky_quartz_block", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).materialColor(MaterialColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block CHISELED_SMOKY_QUARTZ_BLOCK = add("chiseled_smoky_quartz_block", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).materialColor(MaterialColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOKY_QUARTZ_PILLAR = add("smoky_quartz_pillar", new PillarBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_PILLAR).materialColor(MaterialColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOKY_QUARTZ_STAIRS = add("smoky_quartz_stairs", new CinderscapesStairsBlock(SMOKY_QUARTZ_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.QUARTZ_STAIRS).materialColor(MaterialColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOKY_QUARTZ_SLAB = add("smoky_quartz_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_SLAB).materialColor(MaterialColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_SMOKY_QUARTZ = add("smooth_smoky_quartz", new Block(FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ).materialColor(MaterialColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_SMOKY_QUARTZ_STAIRS = add("smooth_smoky_quartz_stairs", new CinderscapesStairsBlock(SMOOTH_SMOKY_QUARTZ.getDefaultState(), FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_STAIRS).materialColor(MaterialColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_SMOKY_QUARTZ_SLAB = add("smooth_smoky_quartz_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_SLAB).materialColor(MaterialColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOKY_QUARTZ_BRICKS = add("smoky_quartz_bricks", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BRICKS).materialColor(MaterialColor.GRAY)), ItemGroup.BUILDING_BLOCKS);

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
