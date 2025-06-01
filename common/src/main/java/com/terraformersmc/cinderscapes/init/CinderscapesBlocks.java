package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.block.*;
import com.terraformersmc.cinderscapes.init.helpers.CinderscapesRegistry;
import com.terraformersmc.terraform.wood.api.block.PillarLogHelper;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.entity.EntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class CinderscapesBlocks {

    /////////////////
    // Ashy Shoals //
    /////////////////

    public static Block SCORCHED_STEM;
    public static Block STRIPPED_SCORCHED_STEM;

    public static Block SCORCHED_HYPHAE;
    public static Block STRIPPED_SCORCHED_HYPHAE;

    public static Block SCORCHED_PLANKS;
    public static Block SCORCHED_SLAB;

    public static Block SCORCHED_PRESSURE_PLATE;
    public static Block SCORCHED_FENCE;
    public static Block SCORCHED_TRAPDOOR;
    public static Block SCORCHED_FENCE_GATE;
    public static Block SCORCHED_STAIRS;
    public static Block SCORCHED_BUTTON;
    public static Block SCORCHED_DOOR;

    public static SignBlock SCORCHED_SIGN;
    public static WallSignBlock SCORCHED_WALL_SIGN;
    public static HangingSignBlock SCORCHED_HANGING_SIGN;
    public static WallHangingSignBlock SCORCHED_WALL_HANGING_SIGN;

    public static Block SCORCHED_SHRUB;
    public static Block POTTED_SCORCHED_SHRUB;

    public static Block SCORCHED_SPROUTS;
    public static Block SCORCHED_TENDRILS;
    public static Block POTTED_SCORCHED_TENDRILS;

    public static Block ASH;
    public static Block ASH_BLOCK;

    public static Block PYRACINTH;
    public static Block POTTED_PYRACINTH;

    ////////////////////
    // Luminous Grove //
    ////////////////////

    // Umbral Nylia

    public static Block UMBRAL_STEM;
    public static Block STRIPPED_UMBRAL_STEM;

    public static Block UMBRAL_HYPHAE;
    public static Block STRIPPED_UMBRAL_HYPHAE;

    public static Block UMBRAL_NYLIUM;

    public static Block UMBRAL_FUNGUS;
    public static Block POTTED_UMBRAL_FUNGUS;

    public static Block UMBRAL_WART_BLOCK;
    public static Block UMBRAL_FLESH_BLOCK;

    public static Block UMBRAL_PLANKS;
    public static Block UMBRAL_SLAB;
    public static Block UMBRAL_PRESSURE_PLATE;
    public static Block UMBRAL_FENCE;
    public static Block UMBRAL_TRAPDOOR;
    public static Block UMBRAL_FENCE_GATE;
    public static Block UMBRAL_STAIRS;
    public static Block UMBRAL_BUTTON;
    public static Block UMBRAL_DOOR;

    public static SignBlock UMBRAL_SIGN;
    public static WallSignBlock UMBRAL_WALL_SIGN;
    public static HangingSignBlock UMBRAL_HANGING_SIGN;
    public static WallHangingSignBlock UMBRAL_WALL_HANGING_SIGN;

    // Other

    public static Block TWILIGHT_VINE_BLOCK;
    public static Block TWILIGHT_TENDRILS;
    public static Block POTTED_TWILIGHT_TENDRILS;
    public static Block TWILIGHT_FESCUES;

    public static Block PHOTOFERN;
    public static Block POTTED_PHOTOFERN;

    public static Block TALL_PHOTOFERN;

    public static Block LUMINOUS_POD;
    public static Block POTTED_LUMINOUS_POD;
    public static Block GHASTLY_ECTOPLASM;

    ///////////
    // Other //
    ///////////

    public static Block BRAMBLE_BERRY_BUSH;

    public static Block NODZOL;

    public static Block SULFUR_BLOCK;
    public static Block SULFUR_ORE;

    ///////////////////
    // Quartz Cavern //
    ///////////////////

    public static Block CRYSTINIUM;
    public static Block POTTED_CRYSTINIUM;

    public static Block CRYSTALLINE_QUARTZ;
    public static Block POLYPITE_QUARTZ;
    public static Block POTTED_POLYPITE_QUARTZ;

    // Sulfur Quartz

    public static Block SULFUR_QUARTZ_ORE;
    public static Block SULFUR_QUARTZ_BLOCK;
    public static Block CHISELED_SULFUR_QUARTZ_BLOCK;
    public static Block SULFUR_QUARTZ_PILLAR;
    public static Block SULFUR_QUARTZ_STAIRS;
    public static Block SULFUR_QUARTZ_SLAB;
    public static Block SMOOTH_SULFUR_QUARTZ;
    public static Block SMOOTH_SULFUR_QUARTZ_STAIRS;
    public static Block SMOOTH_SULFUR_QUARTZ_SLAB;
    public static Block SULFUR_QUARTZ_BRICKS;

    public static Block CRYSTALLINE_SULFUR_QUARTZ;
    public static Block POLYPITE_SULFUR_QUARTZ;
    public static Block POTTED_POLYPITE_SULFUR_QUARTZ;

    // Rose Quartz

    public static Block ROSE_QUARTZ_ORE;
    public static Block ROSE_QUARTZ_BLOCK;
    public static Block CHISELED_ROSE_QUARTZ_BLOCK;
    public static Block ROSE_QUARTZ_PILLAR;
    public static Block ROSE_QUARTZ_STAIRS;
    public static Block ROSE_QUARTZ_SLAB;
    public static Block SMOOTH_ROSE_QUARTZ;
    public static Block SMOOTH_ROSE_QUARTZ_STAIRS;
    public static Block SMOOTH_ROSE_QUARTZ_SLAB;
    public static Block ROSE_QUARTZ_BRICKS;

    public static Block CRYSTALLINE_ROSE_QUARTZ;
    public static Block POLYPITE_ROSE_QUARTZ;
    public static Block POTTED_POLYPITE_ROSE_QUARTZ;

    // Smoky Quartz

    public static Block SMOKY_QUARTZ_ORE;
    public static Block SMOKY_QUARTZ_BLOCK;
    public static Block CHISELED_SMOKY_QUARTZ_BLOCK;
    public static Block SMOKY_QUARTZ_PILLAR;
    public static Block SMOKY_QUARTZ_STAIRS;
    public static Block SMOKY_QUARTZ_SLAB;
    public static Block SMOOTH_SMOKY_QUARTZ;
    public static Block SMOOTH_SMOKY_QUARTZ_STAIRS;
    public static Block SMOOTH_SMOKY_QUARTZ_SLAB;
    public static Block SMOKY_QUARTZ_BRICKS;

    public static Block CRYSTALLINE_SMOKY_QUARTZ;
    public static Block POLYPITE_SMOKY_QUARTZ;
    public static Block POTTED_POLYPITE_SMOKY_QUARTZ;

    public static void init() {

        /////////////////
        // Ashy Shoals //
        /////////////////

        SCORCHED_STEM = CinderscapesRegistry.register("scorched_stem", PillarBlock::new, PillarLogHelper.createNetherSettings(MapColor.GRAY, MapColor.TERRACOTTA_GRAY));
        STRIPPED_SCORCHED_STEM = CinderscapesRegistry.register("stripped_scorched_stem", PillarBlock::new, PillarLogHelper.createNetherSettings(MapColor.GRAY));

        SCORCHED_HYPHAE = CinderscapesRegistry.register("scorched_hyphae", PillarBlock::new, PillarLogHelper.createNetherSettings(MapColor.TERRACOTTA_GRAY));
        STRIPPED_SCORCHED_HYPHAE = CinderscapesRegistry.register("stripped_scorched_hyphae", PillarBlock::new, PillarLogHelper.createNetherSettings(MapColor.GRAY));

        SCORCHED_PLANKS = CinderscapesRegistry.register("scorched_planks", Block::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).mapColor(MapColor.LIGHT_GRAY));
        SCORCHED_SLAB = CinderscapesRegistry.register("scorched_slab", SlabBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_SLAB).mapColor(MapColor.LIGHT_GRAY));

        SCORCHED_PRESSURE_PLATE = CinderscapesRegistry.register("scorched_pressure_plate", settings -> new PressurePlateBlock(BlockSetType.CRIMSON, settings), AbstractBlock.Settings.copy(Blocks.CRIMSON_PRESSURE_PLATE).mapColor(MapColor.LIGHT_GRAY));
        SCORCHED_FENCE = CinderscapesRegistry.register("scorched_fence", FenceBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_FENCE).mapColor(MapColor.LIGHT_GRAY));
        SCORCHED_TRAPDOOR = CinderscapesRegistry.register("scorched_trapdoor", settings -> new TrapdoorBlock(BlockSetType.CRIMSON, settings), AbstractBlock.Settings.copy(Blocks.CRIMSON_TRAPDOOR).mapColor(MapColor.LIGHT_GRAY));
        SCORCHED_FENCE_GATE = CinderscapesRegistry.register("scorched_fence_gate", settings -> new FenceGateBlock(WoodType.CRIMSON, settings), AbstractBlock.Settings.copy(Blocks.CRIMSON_FENCE_GATE).mapColor(MapColor.LIGHT_GRAY));
        SCORCHED_STAIRS = CinderscapesRegistry.register("scorched_stairs", settings -> new StairsBlock(SCORCHED_PLANKS.getDefaultState(), settings), AbstractBlock.Settings.copy(Blocks.CRIMSON_STAIRS).mapColor(MapColor.LIGHT_GRAY));
        SCORCHED_BUTTON = CinderscapesRegistry.register("scorched_button", settings -> new ButtonBlock(BlockSetType.CRIMSON, 30, settings), AbstractBlock.Settings.copy(Blocks.CRIMSON_BUTTON).mapColor(MapColor.LIGHT_GRAY));
        SCORCHED_DOOR = CinderscapesRegistry.register("scorched_door", settings -> new DoorBlock(BlockSetType.CRIMSON, settings), AbstractBlock.Settings.copy(Blocks.CRIMSON_DOOR).mapColor(MapColor.LIGHT_GRAY));

        SCORCHED_SIGN = CinderscapesRegistry.registerSignBlock("scorched_sign", settings -> new SignBlock(CinderscapesWoodTypes.SCORCHED, settings), AbstractBlock.Settings.copy(Blocks.CRIMSON_SIGN).mapColor(MapColor.LIGHT_GRAY).sounds(BlockSoundGroup.NETHER_WOOD));
        SCORCHED_WALL_SIGN = CinderscapesRegistry.registerSignBlock("scorched_wall_sign", settings -> new WallSignBlock(CinderscapesWoodTypes.SCORCHED, settings), AbstractBlock.Settings.copy(Blocks.CRIMSON_WALL_SIGN).mapColor(MapColor.LIGHT_GRAY).sounds(BlockSoundGroup.NETHER_WOOD).lootTable(SCORCHED_SIGN.getLootTableKey()));
        SCORCHED_HANGING_SIGN = CinderscapesRegistry.registerSignBlock("scorched_hanging_sign", settings -> new HangingSignBlock(CinderscapesWoodTypes.SCORCHED, settings), AbstractBlock.Settings.copy(Blocks.CRIMSON_HANGING_SIGN).mapColor(MapColor.LIGHT_GRAY).sounds(BlockSoundGroup.NETHER_WOOD_HANGING_SIGN));
        SCORCHED_WALL_HANGING_SIGN = CinderscapesRegistry.registerSignBlock("scorched_wall_hanging_sign", settings -> new WallHangingSignBlock(CinderscapesWoodTypes.SCORCHED, settings), AbstractBlock.Settings.copy(Blocks.CRIMSON_WALL_HANGING_SIGN).mapColor(MapColor.LIGHT_GRAY).sounds(BlockSoundGroup.NETHER_WOOD_HANGING_SIGN).lootTable(SCORCHED_HANGING_SIGN.getLootTableKey()));

        SCORCHED_SHRUB = CinderscapesRegistry.register("scorched_shrub", settings -> new CinderscapesNetherPlantBlock(state -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 14.0, 14.0), settings), AbstractBlock.Settings.copy(Blocks.DEAD_BUSH).mapColor(MapColor.TERRACOTTA_GRAY));
        POTTED_SCORCHED_SHRUB = CinderscapesRegistry.register("potted_scorched_shrub", settings -> new FlowerPotBlock(SCORCHED_SHRUB, settings), AbstractBlock.Settings.copy(Blocks.POTTED_DEAD_BUSH));

        SCORCHED_SPROUTS = CinderscapesRegistry.register("scorched_sprouts", settings -> new CinderscapesNetherPlantBlock(state -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 3.0, 14.0), settings), AbstractBlock.Settings.copy(Blocks.NETHER_SPROUTS).mapColor(MapColor.GRAY));
        SCORCHED_TENDRILS = CinderscapesRegistry.register("scorched_tendrils", settings -> new CinderscapesNetherPlantBlock(state -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0), settings), AbstractBlock.Settings.copy(Blocks.CRIMSON_ROOTS).mapColor(MapColor.GRAY));
        POTTED_SCORCHED_TENDRILS = CinderscapesRegistry.register("potted_scorched_tendrils", settings -> new FlowerPotBlock(SCORCHED_TENDRILS, settings), AbstractBlock.Settings.copy(Blocks.POTTED_CRIMSON_ROOTS));

        ASH = CinderscapesRegistry.register("ash", AshLayerBlock::new, AbstractBlock.Settings.copy(Blocks.SNOW).mapColor(MapColor.GRAY));
        ASH_BLOCK = CinderscapesRegistry.register("ash_block", Block::new, AbstractBlock.Settings.copy(Blocks.SNOW_BLOCK).mapColor(MapColor.GRAY));

        PYRACINTH = CinderscapesRegistry.register("pyracinth", PyracinthBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_ROOTS).mapColor(MapColor.ORANGE));
        POTTED_PYRACINTH = CinderscapesRegistry.register("potted_pyracinth", PottedPyracinthBlock::new, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM));

        ////////////////////
        // Luminous Grove //
        ////////////////////

        // Umbral Nylia

        UMBRAL_STEM = CinderscapesRegistry.register("umbral_stem", PillarBlock::new, PillarLogHelper.createNetherSettings(MapColor.LIGHT_BLUE_GRAY, MapColor.BLUE));
        STRIPPED_UMBRAL_STEM = CinderscapesRegistry.register("stripped_umbral_stem", PillarBlock::new, PillarLogHelper.createNetherSettings(MapColor.LIGHT_BLUE_GRAY));

        UMBRAL_HYPHAE = CinderscapesRegistry.register("umbral_hyphae", PillarBlock::new, PillarLogHelper.createNetherSettings(MapColor.BLUE));
        STRIPPED_UMBRAL_HYPHAE = CinderscapesRegistry.register("stripped_umbral_hyphae", PillarBlock::new, PillarLogHelper.createNetherSettings(MapColor.LIGHT_BLUE_GRAY));

        UMBRAL_NYLIUM = CinderscapesRegistry.register("umbral_nylium", CinderscapesNyliumBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_NYLIUM).mapColor(MapColor.LIGHT_BLUE_GRAY));

        UMBRAL_FUNGUS = CinderscapesRegistry.register("umbral_fungus", settings -> new FungusBlock(CinderscapesConfiguredFeatures.CANOPIED_HUGE_FUNGUS_PLANTED, UMBRAL_NYLIUM, settings), AbstractBlock.Settings.copy(Blocks.WARPED_FUNGUS).mapColor(MapColor.BLUE).luminance(state -> 15));
        POTTED_UMBRAL_FUNGUS = CinderscapesRegistry.register("potted_umbral_fungus", settings -> new FlowerPotBlock(UMBRAL_FUNGUS, settings), AbstractBlock.Settings.copy(Blocks.POTTED_WARPED_FUNGUS).luminance(state -> 12));

        UMBRAL_WART_BLOCK = CinderscapesRegistry.register("umbral_wart_block", CinderscapesTransparentBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_WART_BLOCK).mapColor(MapColor.BLUE).nonOpaque());
        UMBRAL_FLESH_BLOCK = CinderscapesRegistry.register("umbral_flesh_block", CinderscapesTransparentBlock::new, AbstractBlock.Settings.copy(UMBRAL_WART_BLOCK).luminance(state -> 15));

        UMBRAL_PLANKS = CinderscapesRegistry.register("umbral_planks", Block::new, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).mapColor(MapColor.BLUE));
        UMBRAL_SLAB = CinderscapesRegistry.register("umbral_slab", SlabBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_SLAB).mapColor(MapColor.BLUE));
        UMBRAL_PRESSURE_PLATE = CinderscapesRegistry.register("umbral_pressure_plate", settings -> new PressurePlateBlock(BlockSetType.WARPED, settings), AbstractBlock.Settings.copy(Blocks.WARPED_PRESSURE_PLATE).mapColor(MapColor.BLUE));
        UMBRAL_FENCE = CinderscapesRegistry.register("umbral_fence", FenceBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_FENCE).mapColor(MapColor.BLUE));
        UMBRAL_TRAPDOOR = CinderscapesRegistry.register("umbral_trapdoor", settings -> new TrapdoorBlock(BlockSetType.WARPED, settings), AbstractBlock.Settings.copy(Blocks.WARPED_TRAPDOOR).mapColor(MapColor.BLUE));
        UMBRAL_FENCE_GATE = CinderscapesRegistry.register("umbral_fence_gate", settings -> new FenceGateBlock(WoodType.WARPED, settings), AbstractBlock.Settings.copy(Blocks.WARPED_FENCE_GATE).mapColor(MapColor.BLUE));
        UMBRAL_STAIRS = CinderscapesRegistry.register("umbral_stairs", settings -> new StairsBlock(UMBRAL_PLANKS.getDefaultState(), settings), AbstractBlock.Settings.copy(Blocks.WARPED_STAIRS).mapColor(MapColor.BLUE));
        UMBRAL_BUTTON = CinderscapesRegistry.register("umbral_button", settings -> new ButtonBlock(BlockSetType.WARPED, 30, settings), AbstractBlock.Settings.copy(Blocks.WARPED_BUTTON).mapColor(MapColor.BLUE));
        UMBRAL_DOOR = CinderscapesRegistry.register("umbral_door", settings -> new DoorBlock(BlockSetType.WARPED, settings), AbstractBlock.Settings.copy(Blocks.WARPED_DOOR).mapColor(MapColor.BLUE));

        UMBRAL_SIGN = CinderscapesRegistry.registerSignBlock("umbral_sign", settings -> new SignBlock(CinderscapesWoodTypes.UMBRAL, settings), AbstractBlock.Settings.copy(Blocks.WARPED_SIGN).mapColor(MapColor.BLUE).sounds(BlockSoundGroup.NETHER_WOOD));
        UMBRAL_WALL_SIGN = CinderscapesRegistry.registerSignBlock("umbral_wall_sign", settings -> new WallSignBlock(CinderscapesWoodTypes.UMBRAL, settings), AbstractBlock.Settings.copy(Blocks.WARPED_WALL_SIGN).mapColor(MapColor.BLUE).sounds(BlockSoundGroup.NETHER_WOOD).lootTable(UMBRAL_SIGN.getLootTableKey()));
        UMBRAL_HANGING_SIGN = CinderscapesRegistry.registerSignBlock("umbral_hanging_sign", settings -> new HangingSignBlock(CinderscapesWoodTypes.UMBRAL, settings), AbstractBlock.Settings.copy(Blocks.WARPED_HANGING_SIGN).mapColor(MapColor.BLUE).sounds(BlockSoundGroup.NETHER_WOOD_HANGING_SIGN));
        UMBRAL_WALL_HANGING_SIGN = CinderscapesRegistry.registerSignBlock("umbral_wall_hanging_sign", settings -> new WallHangingSignBlock(CinderscapesWoodTypes.UMBRAL, settings), AbstractBlock.Settings.copy(Blocks.WARPED_WALL_HANGING_SIGN).mapColor(MapColor.BLUE).sounds(BlockSoundGroup.NETHER_WOOD_HANGING_SIGN).lootTable(UMBRAL_HANGING_SIGN.getLootTableKey()));

        // Other

        TWILIGHT_VINE_BLOCK = CinderscapesRegistry.register("twilight_vine_block", Block::new, AbstractBlock.Settings.create().mapColor(MapColor.DARK_AQUA).instrument(NoteBlockInstrument.BASS).strength(1.0F).sounds(BlockSoundGroup.NETHER_STEM));
        TWILIGHT_TENDRILS = CinderscapesRegistry.register("twilight_tendrils", settings -> new CinderscapesNetherPlantBlock(state -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0), settings), AbstractBlock.Settings.copy(Blocks.WARPED_ROOTS).mapColor(MapColor.PALE_PURPLE).luminance(state -> 15));
        POTTED_TWILIGHT_TENDRILS = CinderscapesRegistry.register("potted_twilight_tendrils", settings -> new FlowerPotBlock(TWILIGHT_TENDRILS, settings), AbstractBlock.Settings.copy(Blocks.POTTED_WARPED_ROOTS).luminance(state -> 12));
        TWILIGHT_FESCUES = CinderscapesRegistry.register("twilight_fescues", settings -> new CinderscapesNetherPlantBlock(state -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 5.0, 14.0), settings), AbstractBlock.Settings.copy(Blocks.NETHER_SPROUTS).mapColor(MapColor.PURPLE));

        PHOTOFERN = CinderscapesRegistry.register("photofern", PhotofernBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_ROOTS).mapColor(MapColor.PURPLE));
        POTTED_PHOTOFERN = CinderscapesRegistry.register("potted_photofern", settings -> new FlowerPotBlock(PHOTOFERN, settings), AbstractBlock.Settings.copy(Blocks.POTTED_FERN));

        TALL_PHOTOFERN = CinderscapesRegistry.register("tall_photofern", settings -> new CinderscapesNetherTallPlantBlock(state -> Block.createCuboidShape(2.0, 0, 2.0, 14.0, 16.0, 14.0), settings), AbstractBlock.Settings.copy(Blocks.WARPED_ROOTS).mapColor(MapColor.PURPLE));

        LUMINOUS_POD = CinderscapesRegistry.register("luminous_pod", settings -> new CinderscapesNetherTallPlantBlock(state -> Block.createCuboidShape(2.0, 0, 2.0, 14.0, 16.0, 14.0), settings), AbstractBlock.Settings.copy(Blocks.WARPED_ROOTS).mapColor(MapColor.PALE_GREEN).luminance(state -> 15));
        POTTED_LUMINOUS_POD = CinderscapesRegistry.register("potted_luminous_pod", settings -> new FlowerPotBlock(LUMINOUS_POD, settings), AbstractBlock.Settings.copy(Blocks.POTTED_WARPED_ROOTS).luminance(state -> 12));
        GHASTLY_ECTOPLASM = CinderscapesRegistry.register("ghastly_ectoplasm", GhastlyEctoplasmBlock::new, AbstractBlock.Settings.copy(Blocks.WEEPING_VINES_PLANT).mapColor(MapColor.OFF_WHITE).sounds(BlockSoundGroup.ROOTS));

        ///////////
        // Other //
        ///////////

        BRAMBLE_BERRY_BUSH = CinderscapesRegistry.register("bramble_berry_bush", BrambleBerryBushBlock::new, AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH).mapColor(MapColor.TERRACOTTA_BLACK));

        NODZOL = CinderscapesRegistry.register("nodzol", Block::new, AbstractBlock.Settings.copy(Blocks.NETHERRACK).mapColor(MapColor.BROWN));

        SULFUR_BLOCK = CinderscapesRegistry.register("sulfur_block", Block::new, AbstractBlock.Settings.create().mapColor(MapColor.YELLOW).instrument(NoteBlockInstrument.SNARE).strength(0.5F, 0.5f).sounds(BlockSoundGroup.GRAVEL));
        SULFUR_ORE = CinderscapesRegistry.register("sulfur_ore", CinderscapesOreBlock::new, AbstractBlock.Settings.copy(Blocks.NETHER_QUARTZ_ORE).mapColor(MapColor.YELLOW).sounds(BlockSoundGroup.NETHER_ORE).requiresTool());

        ///////////////////
        // Quartz Cavern //
        ///////////////////

        CRYSTINIUM = CinderscapesRegistry.register("crystinium", CrystiniumBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_ROOTS).mapColor(MapColor.YELLOW));
        POTTED_CRYSTINIUM = CinderscapesRegistry.register("potted_crystinium", PottedCrystiniumBlock::new, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM));

        CRYSTALLINE_QUARTZ = CinderscapesRegistry.register("crystalline_quartz", CinderscapesTransparentBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).sounds(BlockSoundGroup.GLASS).nonOpaque().allowsSpawning(CinderscapesBlocks::never).solidBlock(CinderscapesBlocks::never).suffocates(CinderscapesBlocks::never).blockVision(CinderscapesBlocks::never));
        POLYPITE_QUARTZ = CinderscapesRegistry.register("polypite_quartz", PolypiteQuartzBlock::new, AbstractBlock.Settings.copy(CRYSTALLINE_QUARTZ));
        POTTED_POLYPITE_QUARTZ = CinderscapesRegistry.register("potted_polypite_quartz", settings -> new FlowerPotBlock(POLYPITE_QUARTZ, settings), AbstractBlock.Settings.copy(Blocks.FLOWER_POT));

        // Sulfur Quartz

        SULFUR_QUARTZ_ORE = CinderscapesRegistry.register("sulfur_quartz_ore", CinderscapesOreBlock::new, AbstractBlock.Settings.copy(Blocks.NETHER_QUARTZ_ORE).mapColor(MapColor.YELLOW).sounds(BlockSoundGroup.NETHER_ORE).requiresTool());
        SULFUR_QUARTZ_BLOCK = CinderscapesRegistry.register("sulfur_quartz_block", Block::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.YELLOW));
        CHISELED_SULFUR_QUARTZ_BLOCK = CinderscapesRegistry.register("chiseled_sulfur_quartz_block", Block::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.YELLOW));
        SULFUR_QUARTZ_PILLAR = CinderscapesRegistry.register("sulfur_quartz_pillar", PillarBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_PILLAR).mapColor(MapColor.YELLOW));
        SULFUR_QUARTZ_STAIRS = CinderscapesRegistry.register("sulfur_quartz_stairs", settings -> new StairsBlock(SULFUR_QUARTZ_BLOCK.getDefaultState(), settings), AbstractBlock.Settings.copy(Blocks.QUARTZ_STAIRS).mapColor(MapColor.YELLOW));
        SULFUR_QUARTZ_SLAB = CinderscapesRegistry.register("sulfur_quartz_slab", SlabBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_SLAB).mapColor(MapColor.YELLOW));
        SMOOTH_SULFUR_QUARTZ = CinderscapesRegistry.register("smooth_sulfur_quartz", Block::new, AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ).mapColor(MapColor.YELLOW));
        SMOOTH_SULFUR_QUARTZ_STAIRS = CinderscapesRegistry.register("smooth_sulfur_quartz_stairs", settings -> new StairsBlock(SMOOTH_SULFUR_QUARTZ.getDefaultState(), settings), AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ_STAIRS).mapColor(MapColor.YELLOW));
        SMOOTH_SULFUR_QUARTZ_SLAB = CinderscapesRegistry.register("smooth_sulfur_quartz_slab", SlabBlock::new, AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ_SLAB).mapColor(MapColor.YELLOW));
        SULFUR_QUARTZ_BRICKS = CinderscapesRegistry.register("sulfur_quartz_bricks", Block::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BRICKS).mapColor(MapColor.YELLOW));

        CRYSTALLINE_SULFUR_QUARTZ = CinderscapesRegistry.register("crystalline_sulfur_quartz", CinderscapesTransparentBlock::new, AbstractBlock.Settings.copy(CRYSTALLINE_QUARTZ).mapColor(MapColor.YELLOW));
        POLYPITE_SULFUR_QUARTZ = CinderscapesRegistry.register("polypite_sulfur_quartz", PolypiteQuartzBlock::new, AbstractBlock.Settings.copy(CRYSTALLINE_SULFUR_QUARTZ));
        POTTED_POLYPITE_SULFUR_QUARTZ = CinderscapesRegistry.register("potted_polypite_sulfur_quartz", settings -> new FlowerPotBlock(POLYPITE_SULFUR_QUARTZ, settings), AbstractBlock.Settings.copy(Blocks.FLOWER_POT));

        // Rose Quartz

        ROSE_QUARTZ_ORE = CinderscapesRegistry.register("rose_quartz_ore", CinderscapesOreBlock::new, AbstractBlock.Settings.copy(Blocks.NETHER_QUARTZ_ORE).mapColor(MapColor.PINK).sounds(BlockSoundGroup.NETHER_ORE).requiresTool());
        ROSE_QUARTZ_BLOCK = CinderscapesRegistry.register("rose_quartz_block", Block::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.PINK));
        CHISELED_ROSE_QUARTZ_BLOCK = CinderscapesRegistry.register("chiseled_rose_quartz_block", Block::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.PINK));
        ROSE_QUARTZ_PILLAR = CinderscapesRegistry.register("rose_quartz_pillar", PillarBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_PILLAR).mapColor(MapColor.PINK));
        ROSE_QUARTZ_STAIRS = CinderscapesRegistry.register("rose_quartz_stairs", settings -> new StairsBlock(ROSE_QUARTZ_BLOCK.getDefaultState(), settings), AbstractBlock.Settings.copy(Blocks.QUARTZ_STAIRS).mapColor(MapColor.PINK));
        ROSE_QUARTZ_SLAB = CinderscapesRegistry.register("rose_quartz_slab", SlabBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_SLAB).mapColor(MapColor.PINK));
        SMOOTH_ROSE_QUARTZ = CinderscapesRegistry.register("smooth_rose_quartz", Block::new, AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ).mapColor(MapColor.PINK));
        SMOOTH_ROSE_QUARTZ_STAIRS = CinderscapesRegistry.register("smooth_rose_quartz_stairs", settings -> new StairsBlock(SMOOTH_ROSE_QUARTZ.getDefaultState(), settings), AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ_STAIRS).mapColor(MapColor.PINK));
        SMOOTH_ROSE_QUARTZ_SLAB = CinderscapesRegistry.register("smooth_rose_quartz_slab", SlabBlock::new, AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ_SLAB).mapColor(MapColor.PINK));
        ROSE_QUARTZ_BRICKS = CinderscapesRegistry.register("rose_quartz_bricks", Block::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BRICKS).mapColor(MapColor.PINK));

        CRYSTALLINE_ROSE_QUARTZ = CinderscapesRegistry.register("crystalline_rose_quartz", CinderscapesTransparentBlock::new, AbstractBlock.Settings.copy(CRYSTALLINE_QUARTZ).mapColor(MapColor.PINK));
        POLYPITE_ROSE_QUARTZ = CinderscapesRegistry.register("polypite_rose_quartz", PolypiteQuartzBlock::new, AbstractBlock.Settings.copy(CRYSTALLINE_ROSE_QUARTZ));
        POTTED_POLYPITE_ROSE_QUARTZ = CinderscapesRegistry.register("potted_polypite_rose_quartz", settings -> new FlowerPotBlock(POLYPITE_ROSE_QUARTZ, settings), AbstractBlock.Settings.copy(Blocks.FLOWER_POT));

        // Smoky Quartz

        SMOKY_QUARTZ_ORE = CinderscapesRegistry.register("smoky_quartz_ore", CinderscapesOreBlock::new, AbstractBlock.Settings.copy(Blocks.NETHER_QUARTZ_ORE).mapColor(MapColor.GRAY).sounds(BlockSoundGroup.NETHER_ORE).requiresTool());
        SMOKY_QUARTZ_BLOCK = CinderscapesRegistry.register("smoky_quartz_block", Block::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.GRAY));
        CHISELED_SMOKY_QUARTZ_BLOCK = CinderscapesRegistry.register("chiseled_smoky_quartz_block", Block::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.GRAY));
        SMOKY_QUARTZ_PILLAR = CinderscapesRegistry.register("smoky_quartz_pillar", PillarBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_PILLAR).mapColor(MapColor.GRAY));
        SMOKY_QUARTZ_STAIRS = CinderscapesRegistry.register("smoky_quartz_stairs", settings -> new StairsBlock(SMOKY_QUARTZ_BLOCK.getDefaultState(), settings), AbstractBlock.Settings.copy(Blocks.QUARTZ_STAIRS).mapColor(MapColor.GRAY));
        SMOKY_QUARTZ_SLAB = CinderscapesRegistry.register("smoky_quartz_slab", SlabBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_SLAB).mapColor(MapColor.GRAY));
        SMOOTH_SMOKY_QUARTZ = CinderscapesRegistry.register("smooth_smoky_quartz", Block::new, AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ).mapColor(MapColor.GRAY));
        SMOOTH_SMOKY_QUARTZ_STAIRS = CinderscapesRegistry.register("smooth_smoky_quartz_stairs", settings -> new StairsBlock(SMOOTH_SMOKY_QUARTZ.getDefaultState(), settings), AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ_STAIRS).mapColor(MapColor.GRAY));
        SMOOTH_SMOKY_QUARTZ_SLAB = CinderscapesRegistry.register("smooth_smoky_quartz_slab", SlabBlock::new, AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ_SLAB).mapColor(MapColor.GRAY));
        SMOKY_QUARTZ_BRICKS = CinderscapesRegistry.register("smoky_quartz_bricks", Block::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BRICKS).mapColor(MapColor.GRAY));

        CRYSTALLINE_SMOKY_QUARTZ = CinderscapesRegistry.register("crystalline_smoky_quartz", CinderscapesTransparentBlock::new, AbstractBlock.Settings.copy(CRYSTALLINE_QUARTZ).mapColor(MapColor.GRAY));
        POLYPITE_SMOKY_QUARTZ = CinderscapesRegistry.register("polypite_smoky_quartz", PolypiteQuartzBlock::new, AbstractBlock.Settings.copy(CRYSTALLINE_SMOKY_QUARTZ));
        POTTED_POLYPITE_SMOKY_QUARTZ = CinderscapesRegistry.register("potted_polypite_smoky_quartz", settings -> new FlowerPotBlock(POLYPITE_SMOKY_QUARTZ, settings), AbstractBlock.Settings.copy(Blocks.FLOWER_POT));

        addStrippables();
    }

    private static void addStrippables() {
        StrippableBlockRegistry.register(SCORCHED_STEM, STRIPPED_SCORCHED_STEM);
        StrippableBlockRegistry.register(SCORCHED_HYPHAE, STRIPPED_SCORCHED_HYPHAE);
        StrippableBlockRegistry.register(UMBRAL_STEM, STRIPPED_UMBRAL_STEM);
        StrippableBlockRegistry.register(UMBRAL_HYPHAE, STRIPPED_UMBRAL_HYPHAE);
    }

    private static boolean never(BlockState blockState, BlockView blockView, BlockPos pos) {
        return false;
    }

    private static boolean never(BlockState blockState, BlockView blockView, BlockPos pos, EntityType<?> entityType) {
        return false;
    }
}
