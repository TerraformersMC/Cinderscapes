package com.terraformersmc.cinderscapes.init;

import java.util.LinkedHashMap;
import java.util.Map;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.block.AshLayerBlock;
import com.terraformersmc.cinderscapes.block.BrambleBerryBushBlock;
import com.terraformersmc.cinderscapes.block.CinderscapesCanopiedFungusBlock;
import com.terraformersmc.cinderscapes.block.CinderscapesNetherPlantBlock;
import com.terraformersmc.cinderscapes.block.CinderscapesNetherTallPlantBlock;
import com.terraformersmc.cinderscapes.block.CinderscapesNyliumBlock;
import com.terraformersmc.cinderscapes.block.CinderscapesOreBlock;
import com.terraformersmc.cinderscapes.block.CinderscapesTransparentBlock;
import com.terraformersmc.cinderscapes.block.CrystiniumBlock;
import com.terraformersmc.cinderscapes.block.GhastlyEctoplasmBlock;
import com.terraformersmc.cinderscapes.block.IvorySpikeBlock;
import com.terraformersmc.cinderscapes.block.IvoryTeethBlock;
import com.terraformersmc.cinderscapes.block.PhotofernBlock;
import com.terraformersmc.cinderscapes.block.PolypiteQuartzBlock;
import com.terraformersmc.cinderscapes.block.PottedCrystiniumBlock;
import com.terraformersmc.cinderscapes.block.PottedPyracinthBlock;
import com.terraformersmc.cinderscapes.block.PyracinthBlock;
import com.terraformersmc.terraform.block.StrippableLogBlock;
import com.terraformersmc.terraform.block.TerraformButtonBlock;
import com.terraformersmc.terraform.block.TerraformDoorBlock;
import com.terraformersmc.terraform.block.TerraformPressurePlateBlock;
import com.terraformersmc.terraform.block.TerraformSignBlock;
import com.terraformersmc.terraform.block.TerraformStairsBlock;
import com.terraformersmc.terraform.block.TerraformTrapdoorBlock;
import com.terraformersmc.terraform.block.TerraformWallSignBlock;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

// TODO: Check
public class CinderscapesBlocks {

    // Acts as a kind of local registry for block items added by Cinderscapes
    private static final Map<Identifier, BlockItem> ITEMS = new LinkedHashMap<>();
    // Acts as a kind of local registry for blocks added by Cinderscapes
    private static final Map<Identifier, Block> BLOCKS = new LinkedHashMap<>();

    /////////////////
    // Ashy Shoals //
    /////////////////

    public static final Block STRIPPED_SCORCHED_STEM = add("stripped_scorched_stem", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_WARPED_STEM).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.AXES)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SCORCHED_STEM = add("scorched_stem", new StrippableLogBlock(() -> STRIPPED_SCORCHED_STEM, MaterialColor.CLEAR, FabricBlockSettings.copyOf(Blocks.WARPED_STEM).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.AXES)), ItemGroup.BUILDING_BLOCKS);

    public static final Block STRIPPED_SCORCHED_HYPHAE = add("stripped_scorched_hyphae", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_WARPED_HYPHAE).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.AXES)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SCORCHED_HYPHAE = add("scorched_hyphae", new StrippableLogBlock(() -> STRIPPED_SCORCHED_HYPHAE, MaterialColor.CLEAR, FabricBlockSettings.copyOf(Blocks.WARPED_HYPHAE).materialColor(MaterialColor.LIGHT_GRAY).breakByTool(FabricToolTags.AXES)), ItemGroup.BUILDING_BLOCKS);

    public static final Block SCORCHED_PLANKS = add("scorched_planks", new Block(FabricBlockSettings.copyOf(Blocks.WARPED_PLANKS).materialColor(MaterialColor.LIGHT_GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SCORCHED_SLAB = add("scorched_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.WARPED_SLAB).materialColor(MaterialColor.LIGHT_GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SCORCHED_PRESSURE_PLATE = add("scorched_pressure_plate", new TerraformPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.WARPED_PRESSURE_PLATE).materialColor(MaterialColor.LIGHT_GRAY)), ItemGroup.REDSTONE);
    public static final Block SCORCHED_FENCE = add("scorched_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.WARPED_FENCE).materialColor(MaterialColor.LIGHT_GRAY)), ItemGroup.DECORATIONS);
    public static final Block SCORCHED_TRAPDOOR = add("scorched_trapdoor", new TerraformTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.WARPED_TRAPDOOR).materialColor(MaterialColor.LIGHT_GRAY)), ItemGroup.REDSTONE);
    public static final Block SCORCHED_FENCE_GATE = add("scorched_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.WARPED_FENCE_GATE).materialColor(MaterialColor.LIGHT_GRAY)), ItemGroup.REDSTONE);
    public static final Block SCORCHED_STAIRS = add("scorched_stairs", new TerraformStairsBlock(SCORCHED_PLANKS, FabricBlockSettings.copyOf(Blocks.WARPED_STAIRS).materialColor(MaterialColor.LIGHT_GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SCORCHED_BUTTON = add("scorched_button", new TerraformButtonBlock(FabricBlockSettings.copyOf(Blocks.WARPED_BUTTON).materialColor(MaterialColor.LIGHT_GRAY)), ItemGroup.REDSTONE);
    public static final Block SCORCHED_DOOR = add("scorched_door", new TerraformDoorBlock(FabricBlockSettings.copyOf(Blocks.WARPED_DOOR).materialColor(MaterialColor.LIGHT_GRAY)), ItemGroup.REDSTONE);
    public static final Block SCORCHED_SIGN = add("scorched_sign", new TerraformSignBlock(Cinderscapes.id("entity/signs/scorched"), FabricBlockSettings.copyOf(Blocks.WARPED_SIGN).materialColor(MaterialColor.LIGHT_GRAY)));
    public static final Block SCORCHED_WALL_SIGN = add("scorched_wall_sign", new TerraformWallSignBlock(Cinderscapes.id("entity/signs/scorched"), FabricBlockSettings.copyOf(Blocks.WARPED_WALL_SIGN).materialColor(MaterialColor.LIGHT_GRAY)));

    public static final Block SCORCHED_SHRUB = add("scorched_shrub", new CinderscapesNetherPlantBlock(FabricBlockSettings.copyOf(Blocks.DEAD_BUSH), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 14.0, 14.0)), ItemGroup.DECORATIONS);
    public static final Block POTTED_SCORCHED_SHRUB = add("potted_scorched_shrub", new FlowerPotBlock(SCORCHED_SHRUB, FabricBlockSettings.copyOf(Blocks.POTTED_DEAD_BUSH)));

    public static final Block SCORCHED_SPROUTS = add("scorched_sprouts", new CinderscapesNetherPlantBlock(FabricBlockSettings.copyOf(Blocks.DEAD_BUSH), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)), ItemGroup.DECORATIONS);
    public static final Block SCORCHED_TENDRILS = add("scorched_tendrils", new CinderscapesNetherPlantBlock(FabricBlockSettings.copyOf(Blocks.DEAD_BUSH), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0)), ItemGroup.DECORATIONS);
    public static final Block POTTED_SCORCHED_TENDRILS = add("potted_scorched_tendrils", new FlowerPotBlock(SCORCHED_TENDRILS, FabricBlockSettings.copyOf(Blocks.POTTED_WARPED_ROOTS)));

    public static final Block ASH = add("ash", new AshLayerBlock(FabricBlockSettings.copyOf(Blocks.SNOW).breakByTool(FabricToolTags.SHOVELS)), ItemGroup.DECORATIONS);
    public static final Block ASH_BLOCK = add("ash_block", new Block(FabricBlockSettings.copyOf(Blocks.SNOW_BLOCK).breakByTool(FabricToolTags.SHOVELS)), ItemGroup.DECORATIONS);

    public static final Block PYRACINTH = add("pyracinth", new PyracinthBlock(), ItemGroup.DECORATIONS);
    public static final Block POTTED_PYRACINTH = add("potted_pyracinth", new PottedPyracinthBlock());

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
    public static final Block POTTED_UMBRAL_FUNGUS = add("potted_umbral_fungus", new FlowerPotBlock(UMBRAL_FUNGUS, FabricBlockSettings.copyOf(Blocks.POTTED_WARPED_FUNGUS)));

    public static final Block UMBRAL_WART_BLOCK = add("umbral_wart_block", new CinderscapesTransparentBlock(FabricBlockSettings.copyOf(Blocks.WARPED_WART_BLOCK).materialColor(MaterialColor.BLUE).breakByTool(FabricToolTags.HOES).nonOpaque()), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_FLESH_BLOCK = add("umbral_flesh_block", new CinderscapesTransparentBlock(FabricBlockSettings.copyOf(UMBRAL_WART_BLOCK).breakByTool(FabricToolTags.HOES).lightLevel(15)), ItemGroup.BUILDING_BLOCKS);

    public static final Block UMBRAL_PLANKS = add("umbral_planks", new Block(FabricBlockSettings.copyOf(Blocks.WARPED_PLANKS).materialColor(MaterialColor.BLUE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_SLAB = add("umbral_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.WARPED_SLAB).materialColor(MaterialColor.BLUE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_PRESSURE_PLATE = add("umbral_pressure_plate", new TerraformPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.WARPED_PRESSURE_PLATE).materialColor(MaterialColor.BLUE)), ItemGroup.REDSTONE);
    public static final Block UMBRAL_FENCE = add("umbral_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.WARPED_FENCE).materialColor(MaterialColor.BLUE)), ItemGroup.DECORATIONS);
    public static final Block UMBRAL_TRAPDOOR = add("umbral_trapdoor", new TerraformTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.WARPED_TRAPDOOR).materialColor(MaterialColor.BLUE)), ItemGroup.REDSTONE);
    public static final Block UMBRAL_FENCE_GATE = add("umbral_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.WARPED_FENCE_GATE).materialColor(MaterialColor.BLUE)), ItemGroup.REDSTONE);
    public static final Block UMBRAL_STAIRS = add("umbral_stairs", new TerraformStairsBlock(UMBRAL_PLANKS, FabricBlockSettings.copyOf(Blocks.WARPED_STAIRS).materialColor(MaterialColor.BLUE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_BUTTON = add("umbral_button", new TerraformButtonBlock(FabricBlockSettings.copyOf(Blocks.WARPED_BUTTON).materialColor(MaterialColor.BLUE)), ItemGroup.REDSTONE);
    public static final Block UMBRAL_DOOR = add("umbral_door", new TerraformDoorBlock(FabricBlockSettings.copyOf(Blocks.WARPED_DOOR).materialColor(MaterialColor.BLUE)), ItemGroup.REDSTONE);
    public static final Block UMBRAL_SIGN = add("umbral_sign", new TerraformSignBlock(Cinderscapes.id("entity/signs/umbral"), FabricBlockSettings.copyOf(Blocks.WARPED_SIGN).materialColor(MaterialColor.BLUE)));
    public static final Block UMBRAL_WALL_SIGN = add("umbral_wall_sign", new TerraformWallSignBlock(Cinderscapes.id("entity/signs/umbral"), FabricBlockSettings.copyOf(Blocks.WARPED_WALL_SIGN).materialColor(MaterialColor.BLUE)));

    // Other

    public static final Block TWILIGHT_VINE_BLOCK = add("twilight_vine_block", new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC).strength(1.0F).sounds(BlockSoundGroup.NETHER_STEM).breakByTool(FabricToolTags.AXES)), ItemGroup.DECORATIONS);
    public static final Block TWILIGHT_TENDRILS = add("twilight_tendrils", new CinderscapesNetherPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS).luminance((state) -> 15), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0)), ItemGroup.DECORATIONS);
    public static final Block POTTED_TWILIGHT_TENDRILS = add("potted_twilight_tendrils", new FlowerPotBlock(TWILIGHT_TENDRILS, FabricBlockSettings.copyOf(Blocks.POTTED_WARPED_ROOTS).luminance((state) -> 15)));
    public static final Block TWILIGHT_FESCUES = add("twilight_fescues", new CinderscapesNetherPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 5.0, 14.0)), ItemGroup.DECORATIONS);

    public static Block PHOTOFERN = add("photofern", new PhotofernBlock(), ItemGroup.DECORATIONS);
    public static final Block POTTED_PHOTOFERN = add("potted_photofern", new FlowerPotBlock(PHOTOFERN, FabricBlockSettings.copyOf(Blocks.POTTED_FERN)));

    public static final Block TALL_PHOTOFERN = add("tall_photofern", new CinderscapesNetherTallPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS), (state) -> Block.createCuboidShape(2.0, 0, 2.0, 14.0, 16.0, 14.0)), ItemGroup.DECORATIONS);

    public static final Block LUMINOUS_POD = add("luminous_pod", new CinderscapesNetherTallPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS).luminance((state) -> 15), (state) -> Block.createCuboidShape(2.0, 0, 2.0, 14.0, 16.0, 14.0)), ItemGroup.DECORATIONS);
    public static final Block POTTED_LUMINOUS_POD = add("potted_luminous_pod", new FlowerPotBlock(LUMINOUS_POD, FabricBlockSettings.copyOf(Blocks.POTTED_WARPED_ROOTS).luminance((state) -> 15)));
    public static final Block GHASTLY_ECTOPLASM = add("ghastly_ectoplasm", new GhastlyEctoplasmBlock(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).noCollision().breakInstantly().sounds(BlockSoundGroup.ROOTS)), ItemGroup.DECORATIONS);

    ///////////
    // Other //
    ///////////

    public static final Block SULFUR_BLOCK = add("sulfur_block", new Block(FabricBlockSettings.of(Material.AGGREGATE).strength(0.5F, 0.5f)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SULFUR_ORE = addOre("sulfur_ore", ItemGroup.BUILDING_BLOCKS, 2, MaterialColor.YELLOW);

    public static final Block BRAMBLE_BERRY_BUSH = add("bramble_berry_bush", new BrambleBerryBushBlock(FabricBlockSettings.copyOf(Blocks.SWEET_BERRY_BUSH)));

    ///////////////////
    // Quartz Canyon //
    ///////////////////

    public static final Block CRYSTINIUM = add("crystinium", new CrystiniumBlock(), ItemGroup.DECORATIONS);
    public static final Block POTTED_CRYSTINIUM = add("potted_crystinium", new PottedCrystiniumBlock());

    public static final Block CRYSTALLINE_QUARTZ = add("crystalline_quartz", new CinderscapesTransparentBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).sounds(BlockSoundGroup.GLASS).nonOpaque().allowsSpawning(CinderscapesBlocks::never).solidBlock(CinderscapesBlocks::never).suffocates(CinderscapesBlocks::never).blockVision(CinderscapesBlocks::never)), ItemGroup.BUILDING_BLOCKS);
    public static final Block POLYPITE_QUARTZ = add("polypite_quartz", new PolypiteQuartzBlock(FabricBlockSettings.copyOf(CRYSTALLINE_QUARTZ)), ItemGroup.DECORATIONS);
    public static final Block POTTED_POLYPITE_QUARTZ = add("potted_polypite_quartz", new FlowerPotBlock(POLYPITE_QUARTZ, FabricBlockSettings.copyOf(Blocks.FLOWER_POT)));

    // Sulfur Quartz

    public static final Block POLYPITE_SULFUR_QUARTZ = add("polypite_sulfur_quartz", new PolypiteQuartzBlock(FabricBlockSettings.copyOf(POLYPITE_QUARTZ).materialColor(MaterialColor.YELLOW)), ItemGroup.DECORATIONS);
    public static final Block POTTED_POLYPITE_SULFUR_QUARTZ = add("potted_polypite_sulfur_quartz", new FlowerPotBlock(POLYPITE_SULFUR_QUARTZ, FabricBlockSettings.copyOf(Blocks.FLOWER_POT)));

    public static final Block SULFUR_QUARTZ_ORE = addOre("sulfur_quartz_ore", ItemGroup.BUILDING_BLOCKS, 1, MaterialColor.YELLOW);
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
    public static final Block POTTED_POLYPITE_ROSE_QUARTZ = add("potted_polypite_rose_quartz", new FlowerPotBlock(POLYPITE_ROSE_QUARTZ, FabricBlockSettings.copyOf(Blocks.FLOWER_POT)));

    public static final Block ROSE_QUARTZ_ORE = addOre("rose_quartz_ore", ItemGroup.BUILDING_BLOCKS, 1, MaterialColor.PINK);
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
    public static final Block POTTED_POLYPITE_SMOKY_QUARTZ = add("potted_polypite_smoky_quartz", new FlowerPotBlock(POLYPITE_SMOKY_QUARTZ, FabricBlockSettings.copyOf(Blocks.FLOWER_POT)));

    public static final Block SMOKY_QUARTZ_ORE = addOre("smoky_quartz_ore", ItemGroup.BUILDING_BLOCKS, 1, MaterialColor.GRAY);
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

    ////////////////////
    // Ivory Shallows //
    ////////////////////
    
    // IVORY
    
    public static final Block IVORY_BLOCK = add("ivory_block", new Block(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK).strength(3.0f).materialColor(MaterialColor.LIGHT_GRAY).requiresTool()), ItemGroup.BUILDING_BLOCKS);
    public static final Block POLISHED_IVORY_BLOCK = add("polished_ivory", new Block(FabricBlockSettings.copyOf(IVORY_BLOCK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block CHISELED_IVORY_BLOCK = add("chiseled_ivory", new Block(FabricBlockSettings.copyOf(IVORY_BLOCK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block IVORY_PILLAR_BLOCK = add("ivory_pillar", new PillarBlock(FabricBlockSettings.copyOf(IVORY_BLOCK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block IVORY_BRICKS = add("ivory_bricks", new Block(FabricBlockSettings.copyOf(IVORY_BLOCK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block IVORY_MARROW_BLOCK = add("ivory_marrow_block", new PillarBlock(FabricBlockSettings.copyOf(IVORY_BLOCK).sounds(BlockSoundGroup.STONE).hardness(10.0f)), ItemGroup.BUILDING_BLOCKS);
    public static final Block IVORY_TEETH = add("ivory_teeth", new IvoryTeethBlock(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK).noCollision().sounds(BlockSoundGroup.BONE).requiresTool().strength(2.5f)), ItemGroup.DECORATIONS);
    public static final Block IVORY_SPIKE = add("ivory_spike", new IvorySpikeBlock(FabricBlockSettings.copyOf(IVORY_TEETH)), ItemGroup.DECORATIONS);
    
    // SLABS STAIRS AND WALL
    
    public static final Block IVORY_SLAB = add("ivory_slab", new SlabBlock(FabricBlockSettings.copyOf(IVORY_BLOCK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block POLISHED_IVORY_SLAB = add("polished_ivory_slab", new SlabBlock(FabricBlockSettings.copyOf(IVORY_BLOCK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block IVORY_STAIRS = add("ivory_stairs", new TerraformStairsBlock(IVORY_BLOCK, FabricBlockSettings.copyOf(IVORY_BLOCK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block POLISHED_IVORY_STAIRS = add("polished_ivory_stairs", new TerraformStairsBlock(IVORY_BLOCK, FabricBlockSettings.copyOf(IVORY_BLOCK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block IVORY_WALL = add("ivory_wall", new WallBlock(FabricBlockSettings.copyOf(IVORY_BLOCK)), ItemGroup.DECORATIONS);
    public static final Block POLISHED_IVORY_WALL = add("polished_ivory_wall", new WallBlock(FabricBlockSettings.copyOf(IVORY_BLOCK)), ItemGroup.DECORATIONS);
    
    private static Block addOre(String name, ItemGroup tab, int miningLevel, MaterialColor color) {
        CinderscapesOreBlock block = new CinderscapesOreBlock(FabricBlockSettings.copyOf(Blocks.NETHER_QUARTZ_ORE).materialColor(color).breakByTool(FabricToolTags.PICKAXES, miningLevel).sounds(BlockSoundGroup.NETHER_ORE).requiresTool());
        return add(name, block, tab);
    }

    private static <B extends Block> B add(String name, B block, ItemGroup tab) {
        return add(name, block, new BlockItem(block, new Item.Settings().group(tab)));
    }

    private static <B extends Block> B add(String name, B block, BlockItem item) {
        add(name, block);
        if (item != null) {
            item.appendBlocks(Item.BLOCK_ITEMS, item);
            ITEMS.put(Cinderscapes.id(name), item);
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

        registerCompostableBlocks();
    }

    private static void registerCompostableBlocks() {
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(TWILIGHT_FESCUES.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(TWILIGHT_TENDRILS.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(SCORCHED_TENDRILS.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(SCORCHED_SPROUTS.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(SCORCHED_SHRUB.asItem(), 0.3f);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(CRYSTINIUM.asItem(), 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(PYRACINTH.asItem(), 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(PHOTOFERN.asItem(), 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(TALL_PHOTOFERN.asItem(), 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(LUMINOUS_POD.asItem(), 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(UMBRAL_FUNGUS.asItem(), 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(GHASTLY_ECTOPLASM.asItem(), 0.65f);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(UMBRAL_WART_BLOCK.asItem(), 0.85f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(UMBRAL_FLESH_BLOCK.asItem(), 0.85f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(TWILIGHT_VINE_BLOCK.asItem(), 0.85f);
    }

    private static boolean never(BlockState blockState, BlockView blockView, BlockPos pos) {
        return false;
    }

    private static boolean never(BlockState blockState, BlockView blockView, BlockPos pos, EntityType<?> entityType) {
        return false;
    }
}
