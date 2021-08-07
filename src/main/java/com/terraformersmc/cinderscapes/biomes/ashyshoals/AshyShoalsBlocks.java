package com.terraformersmc.cinderscapes.biomes.ashyshoals;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.biomes.ashyshoals.block.AshLayerBlock;
import com.terraformersmc.cinderscapes.biomes.ashyshoals.block.PyracinthBlock;
import com.terraformersmc.cinderscapes.block.NetherPlantBlock;
import com.terraformersmc.cinderscapes.block.PottedFlowerBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import com.terraformersmc.terraform.wood.block.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AshyShoalsBlocks {
    public static final Block STRIPPED_SCORCHED_STEM = register(new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_WARPED_STEM).mapColor(MapColor.LIGHT_BLUE_GRAY).breakByTool(FabricToolTags.AXES)), "stripped_scorched_stem", new FabricItemSettings());
    public static final Block SCORCHED_STEM = register(new StrippableLogBlock(() -> STRIPPED_SCORCHED_STEM, MapColor.CLEAR, FabricBlockSettings.copyOf(Blocks.WARPED_STEM).mapColor(MapColor.LIGHT_BLUE_GRAY).breakByTool(FabricToolTags.AXES)), "scorched_stem", new FabricItemSettings());

    public static final Block STRIPPED_SCORCHED_HYPHAE = register(new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_WARPED_HYPHAE).mapColor(MapColor.LIGHT_BLUE_GRAY).breakByTool(FabricToolTags.AXES)), "stripped_scorched_hyphae", new FabricItemSettings());
    public static final Block SCORCHED_HYPHAE = register(new StrippableLogBlock(() -> STRIPPED_SCORCHED_HYPHAE, MapColor.CLEAR, FabricBlockSettings.copyOf(Blocks.WARPED_HYPHAE).mapColor(MapColor.LIGHT_BLUE_GRAY).breakByTool(FabricToolTags.AXES)), "scorched_hyphae", new FabricItemSettings());

    public static final Block SCORCHED_PLANKS = register(new Block(FabricBlockSettings.copyOf(Blocks.WARPED_PLANKS).mapColor(MapColor.LIGHT_BLUE_GRAY)), "scorched_planks", new FabricItemSettings());
    public static final Block SCORCHED_SLAB = register(new SlabBlock(FabricBlockSettings.copyOf(Blocks.WARPED_SLAB).mapColor(MapColor.LIGHT_BLUE_GRAY)), "scorched_slab", new FabricItemSettings());
    public static final Block SCORCHED_PRESSURE_PLATE = register(new TerraformPressurePlateBlock(FabricBlockSettings.copyOf(Blocks.WARPED_PRESSURE_PLATE).mapColor(MapColor.LIGHT_BLUE_GRAY)), "scorched_pressure_plate", new FabricItemSettings());
    public static final Block SCORCHED_FENCE = register(new FenceBlock(FabricBlockSettings.copyOf(Blocks.WARPED_FENCE).mapColor(MapColor.LIGHT_BLUE_GRAY)), "scorched_fence", new FabricItemSettings());
    public static final Block SCORCHED_TRAPDOOR = register(new TerraformTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.WARPED_TRAPDOOR).mapColor(MapColor.LIGHT_BLUE_GRAY)), "scorched_trapdoor", new FabricItemSettings());
    public static final Block SCORCHED_FENCE_GATE = register(new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.WARPED_FENCE_GATE).mapColor(MapColor.LIGHT_BLUE_GRAY)), "scorched_fence_gate", new FabricItemSettings());
    public static final Block SCORCHED_STAIRS = register(new TerraformStairsBlock(SCORCHED_PLANKS, FabricBlockSettings.copyOf(Blocks.WARPED_STAIRS).mapColor(MapColor.LIGHT_BLUE_GRAY)), "scorched_stairs", new FabricItemSettings());
    public static final Block SCORCHED_BUTTON = register(new TerraformButtonBlock(FabricBlockSettings.copyOf(Blocks.WARPED_BUTTON).mapColor(MapColor.LIGHT_BLUE_GRAY)), "scorched_button", new FabricItemSettings());
    public static final Block SCORCHED_DOOR = register(new TerraformDoorBlock(FabricBlockSettings.copyOf(Blocks.WARPED_DOOR).mapColor(MapColor.LIGHT_BLUE_GRAY)), "scorched_door", new FabricItemSettings());
    public static final Block SCORCHED_SIGN = register(new TerraformSignBlock(Cinderscapes.id("entity/signs/scorched"), FabricBlockSettings.copyOf(Blocks.WARPED_SIGN).mapColor(MapColor.LIGHT_BLUE_GRAY)), "scorched_sign");
    public static final Block SCORCHED_WALL_SIGN = register(new TerraformWallSignBlock(Cinderscapes.id("entity/signs/scorched"), FabricBlockSettings.copyOf(Blocks.WARPED_WALL_SIGN).mapColor(MapColor.LIGHT_BLUE_GRAY)), "scorched_wall_sign");

    public static final Block SCORCHED_SHRUB = register(new NetherPlantBlock(FabricBlockSettings.copyOf(Blocks.DEAD_BUSH), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 14.0, 14.0)), "scorched_shrub", new FabricItemSettings());
    public static final Block POTTED_SCORCHED_SHRUB = register(new FlowerPotBlock(SCORCHED_SHRUB, FabricBlockSettings.copyOf(Blocks.POTTED_DEAD_BUSH)), "potted_scorched_shrub");
    public static final Block SCORCHED_SPROUTS = register(new NetherPlantBlock(FabricBlockSettings.copyOf(Blocks.DEAD_BUSH), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)), "scorched_sprouts", new FabricItemSettings());
    public static final Block SCORCHED_TENDRILS = register(new NetherPlantBlock(FabricBlockSettings.copyOf(Blocks.DEAD_BUSH), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0)), "scorched_tendrils", new FabricItemSettings());
    public static final Block POTTED_SCORCHED_TENDRILS = register(new FlowerPotBlock(SCORCHED_TENDRILS, FabricBlockSettings.copyOf(Blocks.POTTED_WARPED_ROOTS)), "potted_scorched_tendrils");

    public static final Block ASH = register(new Block(FabricBlockSettings.copyOf(Blocks.SNOW_BLOCK).breakByTool(FabricToolTags.SHOVELS)), "ash_block", new FabricItemSettings());
    public static final Block ASH_LAYER = register(new AshLayerBlock(FabricBlockSettings.copyOf(Blocks.SNOW).breakByTool(FabricToolTags.SHOVELS)), "ash", new FabricItemSettings());

    public static final Block PYRACINTH = register(new PyracinthBlock(), "pyracinth", new FabricItemSettings());
    public static final Block POTTED_PYRACINTH = register(new PottedFlowerBlock(PYRACINTH, FabricBlockSettings.copyOf(Blocks.WARPED_ROOTS)), "potted_pyracinth");

    private static <B extends Block> B register(B b, String name) {
        return Registry.register(Registry.BLOCK, new Identifier(Cinderscapes.NAMESPACE, name), b);
    }

    private static <B extends Block> B register(B b, String name, Item.Settings settings) {
        register(new BlockItem(b, settings), name);
        return register(b, name);
    }

    private static <I extends Item> I register(I i, String name) {
        return Registry.register(Registry.ITEM, new Identifier(Cinderscapes.NAMESPACE, name), i);
    }

    public static void onInitializeCommon() { }

}
