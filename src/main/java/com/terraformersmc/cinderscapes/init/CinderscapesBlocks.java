package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.block.*;
import com.terraformersmc.terraform.block.*;
import com.terraformersmc.terraform.util.RecipeUtil;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

import java.util.HashMap;
import java.util.Map;

// TODO: Check
public class CinderscapesBlocks {

    // Acts as a kind of local registry for block items added by Cinderscapes
    private static final Map<Identifier, BlockItem> ITEMS = new HashMap<>();
    // Acts as a kind of local registry for blocks added by Cinderscapes
    private static final Map<Identifier, Block> BLOCKS = new HashMap<>();

    /////////////////
    // Ashy Shoals //
    /////////////////

    public static final Block STRIPPED_SCORCHED_STEM = add("stripped_scorched_stem", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_WARPED_STEM).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.AXES)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SCORCHED_STEM = add("scorched_stem", new StrippableLogBlock(() -> STRIPPED_SCORCHED_STEM, MaterialColor.CLEAR, FabricBlockSettings.copyOf(Blocks.WARPED_STEM).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.AXES)), ItemGroup.BUILDING_BLOCKS);

    public static final Block STRIPPED_SCORCHED_HYPHAE = add("stripped_scorched_hyphae", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_WARPED_HYPHAE).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.AXES)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SCORCHED_HYPHAE = add("scorched_hyphae", new StrippableLogBlock(() -> STRIPPED_SCORCHED_HYPHAE, MaterialColor.CLEAR, FabricBlockSettings.copyOf(Blocks.WARPED_HYPHAE).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.AXES)), ItemGroup.BUILDING_BLOCKS);

    public static final Block SCORCHED_PLANKS = add("scorched_planks", new Block(FabricBlockSettings.copyOf(Blocks.WARPED_PLANKS).materialColor(MaterialColor.LIGHT_GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SCORCHED_SLAB = add("scorched_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.WARPED_SLAB).materialColor(MaterialColor.LIGHT_GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SCORCHED_PRESSURE_PLATE = add("scorched_pressure_plate", new TerraformPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.WARPED_PRESSURE_PLATE).materialColor(MaterialColor.LIGHT_GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SCORCHED_FENCE = add("scorched_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.WARPED_FENCE).materialColor(MaterialColor.LIGHT_GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SCORCHED_TRAPDOOR = add("scorched_trapdoor", new TerraformTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.WARPED_TRAPDOOR).materialColor(MaterialColor.LIGHT_GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SCORCHED_FENCE_GATE = add("scorched_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.WARPED_FENCE_GATE).materialColor(MaterialColor.LIGHT_GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SCORCHED_STAIRS = add("scorched_stairs", new TerraformStairsBlock(SCORCHED_PLANKS, FabricBlockSettings.copyOf(Blocks.WARPED_STAIRS).materialColor(MaterialColor.LIGHT_GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SCORCHED_BUTTON = add("scorched_button", new TerraformButtonBlock(FabricBlockSettings.copyOf(Blocks.WARPED_BUTTON).materialColor(MaterialColor.LIGHT_GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SCORCHED_DOOR = add("scorched_door", new TerraformDoorBlock(FabricBlockSettings.copyOf(Blocks.WARPED_DOOR).materialColor(MaterialColor.LIGHT_GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SCORCHED_SIGN = add("scorched_sign", new TerraformSignBlock(Cinderscapes.id("entity/signs/scorched"), FabricBlockSettings.copyOf(Blocks.WARPED_SIGN).materialColor(MaterialColor.LIGHT_GRAY)));
    public static final Block SCORCHED_WALL_SIGN = add("scorched_wall_sign", new TerraformWallSignBlock(Cinderscapes.id("entity/signs/scorched"), FabricBlockSettings.copyOf(Blocks.WARPED_WALL_SIGN).materialColor(MaterialColor.LIGHT_GRAY)));

    public static final Block SCORCHED_SHRUB = add("scorched_shrub", new CinderscapesNetherPlantBlock(FabricBlockSettings.copyOf(Blocks.DEAD_BUSH), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SCORCHED_SPROUTS = add("scorched_sprouts", new CinderscapesNetherPlantBlock(FabricBlockSettings.copyOf(Blocks.DEAD_BUSH), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SCORCHED_TENDRILS = add("scorched_tendrils", new CinderscapesNetherPlantBlock(FabricBlockSettings.copyOf(Blocks.DEAD_BUSH), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0)), ItemGroup.BUILDING_BLOCKS);

    public static final Block ASH = add("ash", new AshLayerBlock(FabricBlockSettings.copyOf(Blocks.SNOW).breakByTool(FabricToolTags.SHOVELS)), ItemGroup.DECORATIONS);
    public static final Block ASH_BLOCK = add("ash_block", new Block(FabricBlockSettings.copyOf(Blocks.SNOW_BLOCK).breakByTool(FabricToolTags.SHOVELS)), ItemGroup.DECORATIONS);

    public static Block PYRACINTH = add("pyracinth", new PyracinthBlock(), ItemGroup.DECORATIONS);

    ////////////////////
    // Luminous Grove //
    ////////////////////

    // Umbral Nylia

    public static final Block STRIPPED_UMBRAL_STEM = add("stripped_umbral_stem", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_WARPED_STEM).materialColor(MaterialColor.BLUE).breakByTool(FabricToolTags.AXES)), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_STEM = add("umbral_stem", new StrippableLogBlock(() -> STRIPPED_UMBRAL_STEM, MaterialColor.CLEAR, FabricBlockSettings.copyOf(Blocks.WARPED_STEM).materialColor(MaterialColor.BLUE).breakByTool(FabricToolTags.AXES)), ItemGroup.BUILDING_BLOCKS);

    public static final Block STRIPPED_UMBRAL_HYPHAE = add("stripped_umbral_hyphae", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_WARPED_HYPHAE).materialColor(MaterialColor.BLUE).breakByTool(FabricToolTags.AXES)), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_HYPHAE = add("umbral_hyphae", new StrippableLogBlock(() -> STRIPPED_UMBRAL_HYPHAE, MaterialColor.CLEAR, FabricBlockSettings.copyOf(Blocks.WARPED_HYPHAE).materialColor(MaterialColor.BLUE).breakByTool(FabricToolTags.AXES)), ItemGroup.BUILDING_BLOCKS);

    public static final Block UMBRAL_NYLIUM = add("umbral_nylium", new CinderscapesNyliumBlock(FabricBlockSettings.copyOf(Blocks.WARPED_NYLIUM).materialColor(MaterialColor.BLUE).breakByTool(FabricToolTags.PICKAXES)), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_FUNGUS = add("umbral_fungus", new CinderscapesCanopiedFungusBlock(FabricBlockSettings.copyOf(Blocks.WARPED_FUNGUS).materialColor(MaterialColor.BLUE).breakByTool(FabricToolTags.PICKAXES).lightLevel(15), () -> CinderscapesFeatures.CANOPIED_HUGE_FUNGUS.configure(CinderscapesFeatures.UMBRAL_FUNGUS_CONFIG)), ItemGroup.DECORATIONS);
    public static Block UMBRAL_WART_BLOCK = add("umbral_wart_block", new CinderscapesTransparentBlock(FabricBlockSettings.copyOf(Blocks.WARPED_WART_BLOCK).materialColor(MaterialColor.BLUE).breakByTool(FabricToolTags.HOES).nonOpaque()), ItemGroup.BUILDING_BLOCKS);
    public static Block UMBRAL_FLESH_BLOCK = add("umbral_flesh_block", new Block(FabricBlockSettings.copyOf(UMBRAL_WART_BLOCK).breakByTool(FabricToolTags.HOES).lightLevel(15)), ItemGroup.BUILDING_BLOCKS);

    public static final Block UMBRAL_PLANKS = add("umbral_planks", new Block(FabricBlockSettings.copyOf(Blocks.WARPED_PLANKS).materialColor(MaterialColor.BLUE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_SLAB = add("umbral_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.WARPED_SLAB).materialColor(MaterialColor.BLUE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_PRESSURE_PLATE = add("umbral_pressure_plate", new TerraformPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.WARPED_PRESSURE_PLATE).materialColor(MaterialColor.BLUE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_FENCE = add("umbral_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.WARPED_FENCE).materialColor(MaterialColor.BLUE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_TRAPDOOR = add("umbral_trapdoor", new TerraformTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.WARPED_TRAPDOOR).materialColor(MaterialColor.BLUE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_FENCE_GATE = add("umbral_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.WARPED_FENCE_GATE).materialColor(MaterialColor.BLUE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_STAIRS = add("umbral_stairs", new TerraformStairsBlock(UMBRAL_PLANKS, FabricBlockSettings.copyOf(Blocks.WARPED_STAIRS).materialColor(MaterialColor.BLUE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_BUTTON = add("umbral_button", new TerraformButtonBlock(FabricBlockSettings.copyOf(Blocks.WARPED_BUTTON).materialColor(MaterialColor.BLUE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_DOOR = add("umbral_door", new TerraformDoorBlock(FabricBlockSettings.copyOf(Blocks.WARPED_DOOR).materialColor(MaterialColor.BLUE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_SIGN = add("umbral_sign", new TerraformSignBlock(Cinderscapes.id("entity/signs/umbral"), FabricBlockSettings.copyOf(Blocks.WARPED_SIGN).materialColor(MaterialColor.BLUE)));
    public static final Block UMBRAL_WALL_SIGN = add("umbral_wall_sign", new TerraformWallSignBlock(Cinderscapes.id("entity/signs/umbral"), FabricBlockSettings.copyOf(Blocks.WARPED_WALL_SIGN).materialColor(MaterialColor.BLUE)));

    // Other

    public static Block TWILIGHT_VINE_BLOCK = add("twilight_vine_block", new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC).strength(1.0F).sounds(BlockSoundGroup.NETHER_STEM)), ItemGroup.DECORATIONS);

    public static Block TWILIGHT_TENDRILS = add("twilight_tendrils", new CinderscapesNetherPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS).lightLevel((state) -> 15), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0)), ItemGroup.DECORATIONS);
    public static Block TWILIGHT_FESCUES = add("twilight_fescues", new CinderscapesNetherPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0)), ItemGroup.DECORATIONS);
    public static Block PHOTOFERN = add("photofern", new CinderscapesNetherPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0)), ItemGroup.DECORATIONS);
    public static Block TALL_PHOTOFERN = add("tall_photofern", new CinderscapesNetherTallPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS), (state) -> Block.createCuboidShape(2.0, 0, 2.0, 14.0, 16.0, 14.0)), ItemGroup.DECORATIONS);
    public static Block LUMINOUS_POD = add("luminous_pod", new CinderscapesNetherTallPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS).lightLevel((state) -> 15), (state) -> Block.createCuboidShape(2.0, 0, 2.0, 14.0, 16.0, 14.0)), ItemGroup.DECORATIONS);
    public static Block GHASTLY_ECTOPLASM = add("ghastly_ectoplasm", new GhastlyEctoplasmBlock(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).noCollision().breakInstantly().sounds(BlockSoundGroup.ROOTS)), ItemGroup.DECORATIONS);

    ///////////
    // Other //
    ///////////

    public static final Block SULFUR_BLOCK = add("sulfur_block", new Block(FabricBlockSettings.of(Material.AGGREGATE).strength(0.5F, 0.5f)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SULFUR_ORE = add("sulfur_ore", new OreBlock(FabricBlockSettings.copyOf(Blocks.NETHER_QUARTZ_ORE)), ItemGroup.BUILDING_BLOCKS);

    public static final Block BRAMBLE_BERRY_BUSH = add("bramble_berry_bush", new BrambleBerryBushBlock(FabricBlockSettings.copyOf(Blocks.SWEET_BERRY_BUSH)));

    ///////////////////
    // Quartz Canyon //
    ///////////////////

    public static Block CRYSTINIUM = add("crystinium", new CrystiniumBlock(), ItemGroup.DECORATIONS);

    public static final Block CRYSTALLINE_QUARTZ = add("crystalline_quartz", new CinderscapesTransparentBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).sounds(BlockSoundGroup.GLASS).nonOpaque().allowsSpawning(CinderscapesBlocks::never).solidBlock(CinderscapesBlocks::never).suffocates(CinderscapesBlocks::never).blockVision(CinderscapesBlocks::never)), ItemGroup.BUILDING_BLOCKS);
    public static final Block POLYPITE_QUARTZ = add("polypite_quartz", new PolypiteQuartzBlock(FabricBlockSettings.copyOf(CRYSTALLINE_QUARTZ)), ItemGroup.DECORATIONS);

    // Sulfur Quartz

    public static final Block POLYPITE_SULFUR_QUARTZ = add("polypite_sulfur_quartz", new PolypiteQuartzBlock(FabricBlockSettings.copyOf(POLYPITE_QUARTZ).materialColor(MaterialColor.YELLOW)), ItemGroup.DECORATIONS);

    public static final Block SULFUR_QUARTZ_ORE = add("sulfur_quartz_ore", new CinderscapesOreBlock(FabricBlockSettings.copyOf(Blocks.NETHER_QUARTZ_ORE).materialColor(MaterialColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SULFUR_QUARTZ_BLOCK = add("sulfur_quartz_block", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).materialColor(MaterialColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block CHISELED_SULFUR_QUARTZ_BLOCK = add("chiseled_sulfur_quartz_block", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).materialColor(MaterialColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SULFUR_QUARTZ_PILLAR = add("sulfur_quartz_pillar", new PillarBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_PILLAR).materialColor(MaterialColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SULFUR_QUARTZ_STAIRS = add("sulfur_quartz_stairs", new TerraformStairsBlock(SULFUR_QUARTZ_BLOCK, FabricBlockSettings.copyOf(Blocks.QUARTZ_STAIRS).materialColor(MaterialColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SULFUR_QUARTZ_SLAB = add("sulfur_quartz_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_SLAB).materialColor(MaterialColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_SULFUR_QUARTZ = add("smooth_sulfur_quartz", new Block(FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ).materialColor(MaterialColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_SULFUR_QUARTZ_STAIRS = add("smooth_sulfur_quartz_stairs", new TerraformStairsBlock(SMOOTH_SULFUR_QUARTZ, FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_STAIRS).materialColor(MaterialColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_SULFUR_QUARTZ_SLAB = add("smooth_sulfur_quartz_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_SLAB).materialColor(MaterialColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SULFUR_QUARTZ_BRICKS = add("sulfur_quartz_bricks", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BRICKS).materialColor(MaterialColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block CRYSTALLINE_SULFUR_QUARTZ = add("crystalline_sulfur_quartz", new CinderscapesTransparentBlock(FabricBlockSettings.copyOf(CRYSTALLINE_QUARTZ).materialColor(MaterialColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);

    // Rose Quartz

    public static final Block POLYPITE_ROSE_QUARTZ = add("polypite_rose_quartz", new PolypiteQuartzBlock(FabricBlockSettings.copyOf(POLYPITE_QUARTZ).materialColor(MaterialColor.PINK)), ItemGroup.DECORATIONS);

    public static final Block ROSE_QUARTZ_ORE = add("rose_quartz_ore", new CinderscapesOreBlock(FabricBlockSettings.copyOf(Blocks.NETHER_QUARTZ_ORE).materialColor(MaterialColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block ROSE_QUARTZ_BLOCK = add("rose_quartz_block", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).materialColor(MaterialColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block CHISELED_ROSE_QUARTZ_BLOCK = add("chiseled_rose_quartz_block", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).materialColor(MaterialColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block ROSE_QUARTZ_PILLAR = add("rose_quartz_pillar", new PillarBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_PILLAR).materialColor(MaterialColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block ROSE_QUARTZ_STAIRS = add("rose_quartz_stairs", new TerraformStairsBlock(ROSE_QUARTZ_BLOCK, FabricBlockSettings.copyOf(Blocks.QUARTZ_STAIRS).materialColor(MaterialColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block ROSE_QUARTZ_SLAB = add("rose_quartz_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_SLAB).materialColor(MaterialColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_ROSE_QUARTZ = add("smooth_rose_quartz", new Block(FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ).materialColor(MaterialColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_ROSE_QUARTZ_STAIRS = add("smooth_rose_quartz_stairs", new TerraformStairsBlock(SMOOTH_ROSE_QUARTZ, FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_STAIRS).materialColor(MaterialColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_ROSE_QUARTZ_SLAB = add("smooth_rose_quartz_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_SLAB).materialColor(MaterialColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block ROSE_QUARTZ_BRICKS = add("rose_quartz_bricks", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BRICKS).materialColor(MaterialColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block CRYSTALLINE_ROSE_QUARTZ = add("crystalline_rose_quartz", new CinderscapesTransparentBlock(FabricBlockSettings.copyOf(CRYSTALLINE_QUARTZ).materialColor(MaterialColor.PINK)), ItemGroup.BUILDING_BLOCKS);

    // Smoky Quartz

    public static final Block POLYPITE_SMOKY_QUARTZ = add("polypite_smoky_quartz", new PolypiteQuartzBlock(FabricBlockSettings.copyOf(POLYPITE_QUARTZ).materialColor(MaterialColor.GRAY)), ItemGroup.DECORATIONS);

    public static final Block SMOKY_QUARTZ_ORE = add("smoky_quartz_ore", new CinderscapesOreBlock(FabricBlockSettings.copyOf(Blocks.NETHER_QUARTZ_ORE).materialColor(MaterialColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOKY_QUARTZ_BLOCK = add("smoky_quartz_block", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).materialColor(MaterialColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block CHISELED_SMOKY_QUARTZ_BLOCK = add("chiseled_smoky_quartz_block", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).materialColor(MaterialColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOKY_QUARTZ_PILLAR = add("smoky_quartz_pillar", new PillarBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_PILLAR).materialColor(MaterialColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOKY_QUARTZ_STAIRS = add("smoky_quartz_stairs", new TerraformStairsBlock(SMOKY_QUARTZ_BLOCK, FabricBlockSettings.copyOf(Blocks.QUARTZ_STAIRS).materialColor(MaterialColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOKY_QUARTZ_SLAB = add("smoky_quartz_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_SLAB).materialColor(MaterialColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_SMOKY_QUARTZ = add("smooth_smoky_quartz", new Block(FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ).materialColor(MaterialColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_SMOKY_QUARTZ_STAIRS = add("smooth_smoky_quartz_stairs", new TerraformStairsBlock(SMOOTH_SMOKY_QUARTZ, FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_STAIRS).materialColor(MaterialColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_SMOKY_QUARTZ_SLAB = add("smooth_smoky_quartz_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_SLAB).materialColor(MaterialColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOKY_QUARTZ_BRICKS = add("smoky_quartz_bricks", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BRICKS).materialColor(MaterialColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block CRYSTALLINE_SMOKY_QUARTZ = add("crystalline_smoky_quartz", new CinderscapesTransparentBlock(FabricBlockSettings.copyOf(CRYSTALLINE_QUARTZ).materialColor(MaterialColor.GRAY)), ItemGroup.BUILDING_BLOCKS);

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

        RecipeUtil.registerCompostableBlock(CRYSTINIUM);
        RecipeUtil.registerCompostableBlock(PHOTOFERN);
        RecipeUtil.registerCompostableBlock(TALL_PHOTOFERN);
        RecipeUtil.registerCompostableBlock(TWILIGHT_VINE_BLOCK);
        RecipeUtil.registerCompostableBlock(TWILIGHT_FESCUES);
        RecipeUtil.registerCompostableBlock(TWILIGHT_TENDRILS);
        RecipeUtil.registerCompostableBlock(PYRACINTH);
        RecipeUtil.registerCompostableBlock(SCORCHED_TENDRILS);
        RecipeUtil.registerCompostableBlock(UMBRAL_FUNGUS);
        RecipeUtil.registerCompostableBlock(LUMINOUS_POD);
        RecipeUtil.registerCompostableBlock(SCORCHED_SPROUTS);
        RecipeUtil.registerCompostableBlock(SCORCHED_SHRUB);
        RecipeUtil.registerCompostableBlock(GHASTLY_ECTOPLASM);
        RecipeUtil.registerCompostableBlock(UMBRAL_WART_BLOCK);
    }

    private static boolean never(BlockState blockState, BlockView blockView, BlockPos pos) {
        return false;
    }

    private static boolean never(BlockState blockState, BlockView blockView, BlockPos pos, EntityType<?> entityType) {
        return false;
    }
}
