package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.block.*;
import com.terraformersmc.cinderscapes.init.helpers.CinderscapesRegistry;
import com.terraformersmc.cinderscapes.tag.CinderscapesBlockTags;
import com.terraformersmc.terraform.wood.api.block.PillarLogHelper;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;

public class CinderscapesBlocks {

    /*///////////////
    // Ashy Shoals //
    ///////////////*/

    public static Block SCORCHED_STEM;
    public static Block STRIPPED_SCORCHED_STEM;

    public static Block SCORCHED_HYPHAE;
    public static Block STRIPPED_SCORCHED_HYPHAE;

    public static Block SCORCHED_PLANKS;
    public static Block SCORCHED_SLAB;
    public static Block SCORCHED_STAIRS;

    public static Block SCORCHED_BUTTON;
    public static Block SCORCHED_DOOR;
    public static Block SCORCHED_FENCE;
    public static Block SCORCHED_FENCE_GATE;
    public static Block SCORCHED_PRESSURE_PLATE;
    public static Block SCORCHED_SHELF;
    public static Block SCORCHED_TRAPDOOR;

    public static StandingSignBlock SCORCHED_SIGN;
    public static WallSignBlock SCORCHED_WALL_SIGN;
    public static CeilingHangingSignBlock SCORCHED_HANGING_SIGN;
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

    /*//////////////////
    // Luminous Grove //
    //////////////////*/

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
    public static Block UMBRAL_STAIRS;

    public static Block UMBRAL_BUTTON;
    public static Block UMBRAL_DOOR;
    public static Block UMBRAL_FENCE;
    public static Block UMBRAL_FENCE_GATE;
    public static Block UMBRAL_PRESSURE_PLATE;
    public static Block UMBRAL_SHELF;
    public static Block UMBRAL_TRAPDOOR;

    public static StandingSignBlock UMBRAL_SIGN;
    public static WallSignBlock UMBRAL_WALL_SIGN;
    public static CeilingHangingSignBlock UMBRAL_HANGING_SIGN;
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

    /*/////////
    // Other //
    /////////*/

    public static Block BRAMBLE_BERRY_BUSH;

    public static Block NODZOL;

    public static Block SULFUR_BLOCK;
    public static Block SULFUR_ORE;

    /*/////////////////
    // Quartz Cavern //
    /////////////////*/

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

        /*///////////////
        // Ashy Shoals //
        ///////////////*/

        SCORCHED_STEM = CinderscapesRegistry.register("scorched_stem", RotatedPillarBlock::new, PillarLogHelper.createNetherProperties(MapColor.COLOR_GRAY, MapColor.TERRACOTTA_GRAY));
        STRIPPED_SCORCHED_STEM = CinderscapesRegistry.register("stripped_scorched_stem", RotatedPillarBlock::new, PillarLogHelper.createNetherProperties(MapColor.COLOR_GRAY));

        SCORCHED_HYPHAE = CinderscapesRegistry.register("scorched_hyphae", RotatedPillarBlock::new, PillarLogHelper.createNetherProperties(MapColor.TERRACOTTA_GRAY));
        STRIPPED_SCORCHED_HYPHAE = CinderscapesRegistry.register("stripped_scorched_hyphae", RotatedPillarBlock::new, PillarLogHelper.createNetherProperties(MapColor.COLOR_GRAY));

        SCORCHED_PLANKS = CinderscapesRegistry.register("scorched_planks", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).mapColor(MapColor.COLOR_LIGHT_GRAY));
        SCORCHED_SLAB = CinderscapesRegistry.register("scorched_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_SLAB).mapColor(MapColor.COLOR_LIGHT_GRAY));
        SCORCHED_STAIRS = CinderscapesRegistry.register("scorched_stairs", settings -> new StairBlock(SCORCHED_PLANKS.defaultBlockState(), settings), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_STAIRS).mapColor(MapColor.COLOR_LIGHT_GRAY));

        SCORCHED_BUTTON = CinderscapesRegistry.register("scorched_button", settings -> new ButtonBlock(BlockSetType.CRIMSON, 30, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_BUTTON).mapColor(MapColor.COLOR_LIGHT_GRAY));
        SCORCHED_DOOR = CinderscapesRegistry.register("scorched_door", settings -> new DoorBlock(BlockSetType.CRIMSON, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_DOOR).mapColor(MapColor.COLOR_LIGHT_GRAY));
        SCORCHED_FENCE = CinderscapesRegistry.register("scorched_fence", FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_FENCE).mapColor(MapColor.COLOR_LIGHT_GRAY));
        SCORCHED_FENCE_GATE = CinderscapesRegistry.register("scorched_fence_gate", settings -> new FenceGateBlock(WoodType.CRIMSON, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_FENCE_GATE).mapColor(MapColor.COLOR_LIGHT_GRAY));
        SCORCHED_PRESSURE_PLATE = CinderscapesRegistry.register("scorched_pressure_plate", settings -> new PressurePlateBlock(BlockSetType.CRIMSON, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PRESSURE_PLATE).mapColor(MapColor.COLOR_LIGHT_GRAY));
        SCORCHED_SHELF = CinderscapesRegistry.register("scorched_shelf", ShelfBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_SHELF).mapColor(MapColor.COLOR_LIGHT_GRAY));
        SCORCHED_TRAPDOOR = CinderscapesRegistry.register("scorched_trapdoor", settings -> new TrapDoorBlock(BlockSetType.CRIMSON, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_TRAPDOOR).mapColor(MapColor.COLOR_LIGHT_GRAY));

        SCORCHED_SIGN = CinderscapesRegistry.registerSignBlock("scorched_sign", settings -> new StandingSignBlock(CinderscapesWoodTypes.SCORCHED, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.NETHER_WOOD));
        SCORCHED_WALL_SIGN = CinderscapesRegistry.registerSignBlock("scorched_wall_sign", settings -> new WallSignBlock(CinderscapesWoodTypes.SCORCHED, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_WALL_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.NETHER_WOOD).overrideLootTable(SCORCHED_SIGN.getLootTable()));
        SCORCHED_HANGING_SIGN = CinderscapesRegistry.registerSignBlock("scorched_hanging_sign", settings -> new CeilingHangingSignBlock(CinderscapesWoodTypes.SCORCHED, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_HANGING_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.NETHER_WOOD_HANGING_SIGN));
        SCORCHED_WALL_HANGING_SIGN = CinderscapesRegistry.registerSignBlock("scorched_wall_hanging_sign", settings -> new WallHangingSignBlock(CinderscapesWoodTypes.SCORCHED, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_WALL_HANGING_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.NETHER_WOOD_HANGING_SIGN).overrideLootTable(SCORCHED_HANGING_SIGN.getLootTable()));

        SCORCHED_SHRUB = CinderscapesRegistry.register("scorched_shrub", settings -> new CinderscapesNetherPlantBlock(state -> Block.box(2.0, 0.0, 2.0, 14.0, 14.0, 14.0), settings), BlockBehaviour.Properties.ofFullCopy(Blocks.DEAD_BUSH).mapColor(MapColor.TERRACOTTA_GRAY));
        POTTED_SCORCHED_SHRUB = CinderscapesRegistry.register("potted_scorched_shrub", settings -> new FlowerPotBlock(SCORCHED_SHRUB, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_DEAD_BUSH));

        SCORCHED_SPROUTS = CinderscapesRegistry.register("scorched_sprouts", settings -> new CinderscapesNetherPlantBlock(state -> Block.box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0), settings), BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_SPROUTS).mapColor(MapColor.COLOR_GRAY));
        SCORCHED_TENDRILS = CinderscapesRegistry.register("scorched_tendrils", settings -> new CinderscapesNetherPlantBlock(state -> Block.box(2.0, 0.0, 2.0, 14.0, 12.0, 14.0), settings), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_ROOTS).mapColor(MapColor.COLOR_GRAY));
        POTTED_SCORCHED_TENDRILS = CinderscapesRegistry.register("potted_scorched_tendrils", settings -> new FlowerPotBlock(SCORCHED_TENDRILS, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_CRIMSON_ROOTS));

        ASH = CinderscapesRegistry.register("ash", AshLayerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW).mapColor(MapColor.COLOR_GRAY));
        ASH_BLOCK = CinderscapesRegistry.register("ash_block", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK).mapColor(MapColor.COLOR_GRAY));

        PYRACINTH = CinderscapesRegistry.register("pyracinth", PyracinthBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_ROOTS).mapColor(MapColor.COLOR_ORANGE));
        POTTED_PYRACINTH = CinderscapesRegistry.register("potted_pyracinth", PottedPyracinthBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM));

        /*//////////////////
        // Luminous Grove //
        //////////////////*/

        // Umbral Nylia

        UMBRAL_STEM = CinderscapesRegistry.register("umbral_stem", RotatedPillarBlock::new, PillarLogHelper.createNetherProperties(MapColor.CLAY, MapColor.COLOR_BLUE));
        STRIPPED_UMBRAL_STEM = CinderscapesRegistry.register("stripped_umbral_stem", RotatedPillarBlock::new, PillarLogHelper.createNetherProperties(MapColor.CLAY));

        UMBRAL_HYPHAE = CinderscapesRegistry.register("umbral_hyphae", RotatedPillarBlock::new, PillarLogHelper.createNetherProperties(MapColor.COLOR_BLUE));
        STRIPPED_UMBRAL_HYPHAE = CinderscapesRegistry.register("stripped_umbral_hyphae", RotatedPillarBlock::new, PillarLogHelper.createNetherProperties(MapColor.CLAY));

        UMBRAL_NYLIUM = CinderscapesRegistry.register("umbral_nylium", CinderscapesNyliumBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_NYLIUM).mapColor(MapColor.CLAY));

        UMBRAL_FUNGUS = CinderscapesRegistry.register("umbral_fungus", settings -> new NetherFungusBlock(CinderscapesConfiguredFeatures.CANOPIED_HUGE_FUNGUS_PLANTED, UMBRAL_NYLIUM, CinderscapesBlockTags.SUPPORTS_UMBRAL_FUNGUS, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_FUNGUS).mapColor(MapColor.COLOR_BLUE).lightLevel(state -> 15));
        POTTED_UMBRAL_FUNGUS = CinderscapesRegistry.register("potted_umbral_fungus", settings -> new FlowerPotBlock(UMBRAL_FUNGUS, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_WARPED_FUNGUS).lightLevel(state -> 12));

        UMBRAL_WART_BLOCK = CinderscapesRegistry.register("umbral_wart_block", CinderscapesTransparentBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_WART_BLOCK).mapColor(MapColor.COLOR_BLUE).noOcclusion());
        UMBRAL_FLESH_BLOCK = CinderscapesRegistry.register("umbral_flesh_block", CinderscapesTransparentBlock::new, BlockBehaviour.Properties.ofFullCopy(UMBRAL_WART_BLOCK).lightLevel(state -> 15));

        UMBRAL_PLANKS = CinderscapesRegistry.register("umbral_planks", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).mapColor(MapColor.COLOR_BLUE));
        UMBRAL_SLAB = CinderscapesRegistry.register("umbral_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_SLAB).mapColor(MapColor.COLOR_BLUE));
        UMBRAL_STAIRS = CinderscapesRegistry.register("umbral_stairs", settings -> new StairBlock(UMBRAL_PLANKS.defaultBlockState(), settings), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_STAIRS).mapColor(MapColor.COLOR_BLUE));

        UMBRAL_BUTTON = CinderscapesRegistry.register("umbral_button", settings -> new ButtonBlock(BlockSetType.WARPED, 30, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_BUTTON).mapColor(MapColor.COLOR_BLUE));
        UMBRAL_DOOR = CinderscapesRegistry.register("umbral_door", settings -> new DoorBlock(BlockSetType.WARPED, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_DOOR).mapColor(MapColor.COLOR_BLUE));
        UMBRAL_FENCE = CinderscapesRegistry.register("umbral_fence", FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_FENCE).mapColor(MapColor.COLOR_BLUE));
        UMBRAL_FENCE_GATE = CinderscapesRegistry.register("umbral_fence_gate", settings -> new FenceGateBlock(WoodType.WARPED, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_FENCE_GATE).mapColor(MapColor.COLOR_BLUE));
        UMBRAL_PRESSURE_PLATE = CinderscapesRegistry.register("umbral_pressure_plate", settings -> new PressurePlateBlock(BlockSetType.WARPED, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PRESSURE_PLATE).mapColor(MapColor.COLOR_BLUE));
        UMBRAL_SHELF = CinderscapesRegistry.register("umbral_shelf", ShelfBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_SHELF).mapColor(MapColor.COLOR_BLUE));
        UMBRAL_TRAPDOOR = CinderscapesRegistry.register("umbral_trapdoor", settings -> new TrapDoorBlock(BlockSetType.WARPED, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_TRAPDOOR).mapColor(MapColor.COLOR_BLUE));

        UMBRAL_SIGN = CinderscapesRegistry.registerSignBlock("umbral_sign", settings -> new StandingSignBlock(CinderscapesWoodTypes.UMBRAL, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_SIGN).mapColor(MapColor.COLOR_BLUE).sound(SoundType.NETHER_WOOD));
        UMBRAL_WALL_SIGN = CinderscapesRegistry.registerSignBlock("umbral_wall_sign", settings -> new WallSignBlock(CinderscapesWoodTypes.UMBRAL, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_WALL_SIGN).mapColor(MapColor.COLOR_BLUE).sound(SoundType.NETHER_WOOD).overrideLootTable(UMBRAL_SIGN.getLootTable()));
        UMBRAL_HANGING_SIGN = CinderscapesRegistry.registerSignBlock("umbral_hanging_sign", settings -> new CeilingHangingSignBlock(CinderscapesWoodTypes.UMBRAL, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_HANGING_SIGN).mapColor(MapColor.COLOR_BLUE).sound(SoundType.NETHER_WOOD_HANGING_SIGN));
        UMBRAL_WALL_HANGING_SIGN = CinderscapesRegistry.registerSignBlock("umbral_wall_hanging_sign", settings -> new WallHangingSignBlock(CinderscapesWoodTypes.UMBRAL, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_WALL_HANGING_SIGN).mapColor(MapColor.COLOR_BLUE).sound(SoundType.NETHER_WOOD_HANGING_SIGN).overrideLootTable(UMBRAL_HANGING_SIGN.getLootTable()));

        // Other

        TWILIGHT_VINE_BLOCK = CinderscapesRegistry.register("twilight_vine_block", Block::new, BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_STEM).instrument(NoteBlockInstrument.BASS).strength(1.0F).sound(SoundType.STEM));
        TWILIGHT_TENDRILS = CinderscapesRegistry.register("twilight_tendrils", settings -> new CinderscapesNetherPlantBlock(state -> Block.box(2.0, 0.0, 2.0, 14.0, 12.0, 14.0), settings), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_ROOTS).mapColor(MapColor.ICE).lightLevel(state -> 15));
        POTTED_TWILIGHT_TENDRILS = CinderscapesRegistry.register("potted_twilight_tendrils", settings -> new FlowerPotBlock(TWILIGHT_TENDRILS, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_WARPED_ROOTS).lightLevel(state -> 12));
        TWILIGHT_FESCUES = CinderscapesRegistry.register("twilight_fescues", settings -> new CinderscapesNetherPlantBlock(state -> Block.box(2.0, 0.0, 2.0, 14.0, 5.0, 14.0), settings), BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_SPROUTS).mapColor(MapColor.COLOR_PURPLE));

        PHOTOFERN = CinderscapesRegistry.register("photofern", PhotofernBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_ROOTS).mapColor(MapColor.COLOR_PURPLE));
        POTTED_PHOTOFERN = CinderscapesRegistry.register("potted_photofern", settings -> new FlowerPotBlock(PHOTOFERN, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_FERN));

        TALL_PHOTOFERN = CinderscapesRegistry.register("tall_photofern", settings -> new CinderscapesNetherTallPlantBlock(state -> Block.box(2.0, 0, 2.0, 14.0, 16.0, 14.0), settings), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_ROOTS).mapColor(MapColor.COLOR_PURPLE));

        LUMINOUS_POD = CinderscapesRegistry.register("luminous_pod", settings -> new CinderscapesNetherTallPlantBlock(state -> Block.box(2.0, 0, 2.0, 14.0, 16.0, 14.0), settings), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_ROOTS).mapColor(MapColor.GRASS).lightLevel(state -> 15));
        POTTED_LUMINOUS_POD = CinderscapesRegistry.register("potted_luminous_pod", settings -> new FlowerPotBlock(LUMINOUS_POD, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_WARPED_ROOTS).lightLevel(state -> 12));
        GHASTLY_ECTOPLASM = CinderscapesRegistry.register("ghastly_ectoplasm", GhastlyEctoplasmBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WEEPING_VINES_PLANT).mapColor(MapColor.QUARTZ).sound(SoundType.ROOTS));

        /*/////////
        // Other //
        /////////*/

        BRAMBLE_BERRY_BUSH = CinderscapesRegistry.register("bramble_berry_bush", BrambleBerryBushBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH).mapColor(MapColor.TERRACOTTA_BLACK));

        NODZOL = CinderscapesRegistry.register("nodzol", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK).mapColor(MapColor.COLOR_BROWN));

        SULFUR_BLOCK = CinderscapesRegistry.register("sulfur_block", Block::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.SNARE).strength(0.5F, 0.5f).sound(SoundType.GRAVEL));
        SULFUR_ORE = CinderscapesRegistry.register("sulfur_ore", CinderscapesOreBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_QUARTZ_ORE).mapColor(MapColor.COLOR_YELLOW).sound(SoundType.NETHER_ORE).requiresCorrectToolForDrops());

        /*/////////////////
        // Quartz Cavern //
        /////////////////*/

        CRYSTINIUM = CinderscapesRegistry.register("crystinium", CrystiniumBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_ROOTS).mapColor(MapColor.COLOR_YELLOW));
        POTTED_CRYSTINIUM = CinderscapesRegistry.register("potted_crystinium", PottedCrystiniumBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM));

        CRYSTALLINE_QUARTZ = CinderscapesRegistry.register("crystalline_quartz", CinderscapesTransparentBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).sound(SoundType.GLASS).noOcclusion().isValidSpawn(CinderscapesBlocks::never).isRedstoneConductor(CinderscapesBlocks::never).isSuffocating(CinderscapesBlocks::never).isViewBlocking(CinderscapesBlocks::never));
        POLYPITE_QUARTZ = CinderscapesRegistry.register("polypite_quartz", PolypiteQuartzBlock::new, BlockBehaviour.Properties.ofFullCopy(CRYSTALLINE_QUARTZ));
        POTTED_POLYPITE_QUARTZ = CinderscapesRegistry.register("potted_polypite_quartz", settings -> new FlowerPotBlock(POLYPITE_QUARTZ, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT));

        // Sulfur Quartz

        SULFUR_QUARTZ_ORE = CinderscapesRegistry.register("sulfur_quartz_ore", CinderscapesOreBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_QUARTZ_ORE).mapColor(MapColor.COLOR_YELLOW).sound(SoundType.NETHER_ORE).requiresCorrectToolForDrops());
        SULFUR_QUARTZ_BLOCK = CinderscapesRegistry.register("sulfur_quartz_block", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.COLOR_YELLOW));
        CHISELED_SULFUR_QUARTZ_BLOCK = CinderscapesRegistry.register("chiseled_sulfur_quartz_block", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.COLOR_YELLOW));
        SULFUR_QUARTZ_PILLAR = CinderscapesRegistry.register("sulfur_quartz_pillar", RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_PILLAR).mapColor(MapColor.COLOR_YELLOW));
        SULFUR_QUARTZ_STAIRS = CinderscapesRegistry.register("sulfur_quartz_stairs", settings -> new StairBlock(SULFUR_QUARTZ_BLOCK.defaultBlockState(), settings), BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_STAIRS).mapColor(MapColor.COLOR_YELLOW));
        SULFUR_QUARTZ_SLAB = CinderscapesRegistry.register("sulfur_quartz_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_SLAB).mapColor(MapColor.COLOR_YELLOW));
        SMOOTH_SULFUR_QUARTZ = CinderscapesRegistry.register("smooth_sulfur_quartz", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_QUARTZ).mapColor(MapColor.COLOR_YELLOW));
        SMOOTH_SULFUR_QUARTZ_STAIRS = CinderscapesRegistry.register("smooth_sulfur_quartz_stairs", settings -> new StairBlock(SMOOTH_SULFUR_QUARTZ.defaultBlockState(), settings), BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_QUARTZ_STAIRS).mapColor(MapColor.COLOR_YELLOW));
        SMOOTH_SULFUR_QUARTZ_SLAB = CinderscapesRegistry.register("smooth_sulfur_quartz_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_QUARTZ_SLAB).mapColor(MapColor.COLOR_YELLOW));
        SULFUR_QUARTZ_BRICKS = CinderscapesRegistry.register("sulfur_quartz_bricks", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).mapColor(MapColor.COLOR_YELLOW));

        CRYSTALLINE_SULFUR_QUARTZ = CinderscapesRegistry.register("crystalline_sulfur_quartz", CinderscapesTransparentBlock::new, BlockBehaviour.Properties.ofFullCopy(CRYSTALLINE_QUARTZ).mapColor(MapColor.COLOR_YELLOW));
        POLYPITE_SULFUR_QUARTZ = CinderscapesRegistry.register("polypite_sulfur_quartz", PolypiteQuartzBlock::new, BlockBehaviour.Properties.ofFullCopy(CRYSTALLINE_SULFUR_QUARTZ));
        POTTED_POLYPITE_SULFUR_QUARTZ = CinderscapesRegistry.register("potted_polypite_sulfur_quartz", settings -> new FlowerPotBlock(POLYPITE_SULFUR_QUARTZ, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT));

        // Rose Quartz

        ROSE_QUARTZ_ORE = CinderscapesRegistry.register("rose_quartz_ore", CinderscapesOreBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_QUARTZ_ORE).mapColor(MapColor.COLOR_PINK).sound(SoundType.NETHER_ORE).requiresCorrectToolForDrops());
        ROSE_QUARTZ_BLOCK = CinderscapesRegistry.register("rose_quartz_block", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.COLOR_PINK));
        CHISELED_ROSE_QUARTZ_BLOCK = CinderscapesRegistry.register("chiseled_rose_quartz_block", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.COLOR_PINK));
        ROSE_QUARTZ_PILLAR = CinderscapesRegistry.register("rose_quartz_pillar", RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_PILLAR).mapColor(MapColor.COLOR_PINK));
        ROSE_QUARTZ_STAIRS = CinderscapesRegistry.register("rose_quartz_stairs", settings -> new StairBlock(ROSE_QUARTZ_BLOCK.defaultBlockState(), settings), BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_STAIRS).mapColor(MapColor.COLOR_PINK));
        ROSE_QUARTZ_SLAB = CinderscapesRegistry.register("rose_quartz_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_SLAB).mapColor(MapColor.COLOR_PINK));
        SMOOTH_ROSE_QUARTZ = CinderscapesRegistry.register("smooth_rose_quartz", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_QUARTZ).mapColor(MapColor.COLOR_PINK));
        SMOOTH_ROSE_QUARTZ_STAIRS = CinderscapesRegistry.register("smooth_rose_quartz_stairs", settings -> new StairBlock(SMOOTH_ROSE_QUARTZ.defaultBlockState(), settings), BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_QUARTZ_STAIRS).mapColor(MapColor.COLOR_PINK));
        SMOOTH_ROSE_QUARTZ_SLAB = CinderscapesRegistry.register("smooth_rose_quartz_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_QUARTZ_SLAB).mapColor(MapColor.COLOR_PINK));
        ROSE_QUARTZ_BRICKS = CinderscapesRegistry.register("rose_quartz_bricks", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).mapColor(MapColor.COLOR_PINK));

        CRYSTALLINE_ROSE_QUARTZ = CinderscapesRegistry.register("crystalline_rose_quartz", CinderscapesTransparentBlock::new, BlockBehaviour.Properties.ofFullCopy(CRYSTALLINE_QUARTZ).mapColor(MapColor.COLOR_PINK));
        POLYPITE_ROSE_QUARTZ = CinderscapesRegistry.register("polypite_rose_quartz", PolypiteQuartzBlock::new, BlockBehaviour.Properties.ofFullCopy(CRYSTALLINE_ROSE_QUARTZ));
        POTTED_POLYPITE_ROSE_QUARTZ = CinderscapesRegistry.register("potted_polypite_rose_quartz", settings -> new FlowerPotBlock(POLYPITE_ROSE_QUARTZ, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT));

        // Smoky Quartz

        SMOKY_QUARTZ_ORE = CinderscapesRegistry.register("smoky_quartz_ore", CinderscapesOreBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_QUARTZ_ORE).mapColor(MapColor.COLOR_GRAY).sound(SoundType.NETHER_ORE).requiresCorrectToolForDrops());
        SMOKY_QUARTZ_BLOCK = CinderscapesRegistry.register("smoky_quartz_block", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.COLOR_GRAY));
        CHISELED_SMOKY_QUARTZ_BLOCK = CinderscapesRegistry.register("chiseled_smoky_quartz_block", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.COLOR_GRAY));
        SMOKY_QUARTZ_PILLAR = CinderscapesRegistry.register("smoky_quartz_pillar", RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_PILLAR).mapColor(MapColor.COLOR_GRAY));
        SMOKY_QUARTZ_STAIRS = CinderscapesRegistry.register("smoky_quartz_stairs", settings -> new StairBlock(SMOKY_QUARTZ_BLOCK.defaultBlockState(), settings), BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_STAIRS).mapColor(MapColor.COLOR_GRAY));
        SMOKY_QUARTZ_SLAB = CinderscapesRegistry.register("smoky_quartz_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_SLAB).mapColor(MapColor.COLOR_GRAY));
        SMOOTH_SMOKY_QUARTZ = CinderscapesRegistry.register("smooth_smoky_quartz", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_QUARTZ).mapColor(MapColor.COLOR_GRAY));
        SMOOTH_SMOKY_QUARTZ_STAIRS = CinderscapesRegistry.register("smooth_smoky_quartz_stairs", settings -> new StairBlock(SMOOTH_SMOKY_QUARTZ.defaultBlockState(), settings), BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_QUARTZ_STAIRS).mapColor(MapColor.COLOR_GRAY));
        SMOOTH_SMOKY_QUARTZ_SLAB = CinderscapesRegistry.register("smooth_smoky_quartz_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_QUARTZ_SLAB).mapColor(MapColor.COLOR_GRAY));
        SMOKY_QUARTZ_BRICKS = CinderscapesRegistry.register("smoky_quartz_bricks", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).mapColor(MapColor.COLOR_GRAY));

        CRYSTALLINE_SMOKY_QUARTZ = CinderscapesRegistry.register("crystalline_smoky_quartz", CinderscapesTransparentBlock::new, BlockBehaviour.Properties.ofFullCopy(CRYSTALLINE_QUARTZ).mapColor(MapColor.COLOR_GRAY));
        POLYPITE_SMOKY_QUARTZ = CinderscapesRegistry.register("polypite_smoky_quartz", PolypiteQuartzBlock::new, BlockBehaviour.Properties.ofFullCopy(CRYSTALLINE_SMOKY_QUARTZ));
        POTTED_POLYPITE_SMOKY_QUARTZ = CinderscapesRegistry.register("potted_polypite_smoky_quartz", settings -> new FlowerPotBlock(POLYPITE_SMOKY_QUARTZ, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT));

        addStrippables();
    }

    private static void addStrippables() {
        StrippableBlockRegistry.register(SCORCHED_STEM, STRIPPED_SCORCHED_STEM);
        StrippableBlockRegistry.register(SCORCHED_HYPHAE, STRIPPED_SCORCHED_HYPHAE);
        StrippableBlockRegistry.register(UMBRAL_STEM, STRIPPED_UMBRAL_STEM);
        StrippableBlockRegistry.register(UMBRAL_HYPHAE, STRIPPED_UMBRAL_HYPHAE);
    }

    private static boolean never(BlockState blockState, BlockGetter blockView, BlockPos pos) {
        return false;
    }

    private static boolean never(BlockState blockState, BlockGetter blockView, BlockPos pos, EntityType<?> entityType) {
        return false;
    }
}
