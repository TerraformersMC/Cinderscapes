package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.block.*;
import com.terraformersmc.cinderscapes.init.helpers.CinderscapesRegistry;
import com.terraformersmc.cinderscapes.tag.CinderscapesBlockTags;
import com.terraformersmc.terraform.wood.api.block.PillarLogHelper;
import net.fabricmc.fabric.api.item.v1.BlockTransformerHelper;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
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

        SCORCHED_STEM = CinderscapesRegistry.register(CinderscapesBlockItemIds.SCORCHED_STEM, RotatedPillarBlock::new, PillarLogHelper.createNetherProperties(MapColor.COLOR_GRAY, MapColor.TERRACOTTA_GRAY));
        STRIPPED_SCORCHED_STEM = CinderscapesRegistry.register(CinderscapesBlockItemIds.STRIPPED_SCORCHED_STEM, RotatedPillarBlock::new, PillarLogHelper.createNetherProperties(MapColor.COLOR_GRAY));

        SCORCHED_HYPHAE = CinderscapesRegistry.register(CinderscapesBlockItemIds.SCORCHED_HYPHAE, RotatedPillarBlock::new, PillarLogHelper.createNetherProperties(MapColor.TERRACOTTA_GRAY));
        STRIPPED_SCORCHED_HYPHAE = CinderscapesRegistry.register(CinderscapesBlockItemIds.STRIPPED_SCORCHED_HYPHAE, RotatedPillarBlock::new, PillarLogHelper.createNetherProperties(MapColor.COLOR_GRAY));

        SCORCHED_PLANKS = CinderscapesRegistry.register(CinderscapesBlockItemIds.SCORCHED_PLANKS, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).mapColor(MapColor.COLOR_LIGHT_GRAY));
        SCORCHED_SLAB = CinderscapesRegistry.register(CinderscapesBlockItemIds.SCORCHED_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_SLAB).mapColor(MapColor.COLOR_LIGHT_GRAY));
        SCORCHED_STAIRS = CinderscapesRegistry.register(CinderscapesBlockItemIds.SCORCHED_STAIRS, settings -> new StairBlock(SCORCHED_PLANKS.defaultBlockState(), settings), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_STAIRS).mapColor(MapColor.COLOR_LIGHT_GRAY));

        SCORCHED_BUTTON = CinderscapesRegistry.register(CinderscapesBlockItemIds.SCORCHED_BUTTON, settings -> new ButtonBlock(BlockSetType.CRIMSON, 30, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_BUTTON).mapColor(MapColor.COLOR_LIGHT_GRAY));
        SCORCHED_DOOR = CinderscapesRegistry.register(CinderscapesBlockItemIds.SCORCHED_DOOR, settings -> new DoorBlock(BlockSetType.CRIMSON, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_DOOR).mapColor(MapColor.COLOR_LIGHT_GRAY));
        SCORCHED_FENCE = CinderscapesRegistry.register(CinderscapesBlockItemIds.SCORCHED_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_FENCE).mapColor(MapColor.COLOR_LIGHT_GRAY));
        SCORCHED_FENCE_GATE = CinderscapesRegistry.register(CinderscapesBlockItemIds.SCORCHED_FENCE_GATE, settings -> new FenceGateBlock(WoodType.CRIMSON, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_FENCE_GATE).mapColor(MapColor.COLOR_LIGHT_GRAY));
        SCORCHED_PRESSURE_PLATE = CinderscapesRegistry.register(CinderscapesBlockItemIds.SCORCHED_PRESSURE_PLATE, settings -> new PressurePlateBlock(BlockSetType.CRIMSON, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PRESSURE_PLATE).mapColor(MapColor.COLOR_LIGHT_GRAY));
        SCORCHED_SHELF = CinderscapesRegistry.register(CinderscapesBlockItemIds.SCORCHED_SHELF, ShelfBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_SHELF).mapColor(MapColor.COLOR_LIGHT_GRAY));
        SCORCHED_TRAPDOOR = CinderscapesRegistry.register(CinderscapesBlockItemIds.SCORCHED_TRAPDOOR, settings -> new TrapDoorBlock(BlockSetType.CRIMSON, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_TRAPDOOR).mapColor(MapColor.COLOR_LIGHT_GRAY));

        SCORCHED_SIGN = CinderscapesRegistry.registerSignBlock(CinderscapesBlockItemIds.SCORCHED_SIGN.block(), settings -> new StandingSignBlock(CinderscapesWoodTypes.SCORCHED, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.NETHER_WOOD));
        SCORCHED_WALL_SIGN = CinderscapesRegistry.registerSignBlock(CinderscapesBlockIds.SCORCHED_WALL_SIGN, settings -> new WallSignBlock(CinderscapesWoodTypes.SCORCHED, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_WALL_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.NETHER_WOOD).overrideLootTable(SCORCHED_SIGN.getLootTable()));
        SCORCHED_HANGING_SIGN = CinderscapesRegistry.registerSignBlock(CinderscapesBlockItemIds.SCORCHED_HANGING_SIGN.block(), settings -> new CeilingHangingSignBlock(CinderscapesWoodTypes.SCORCHED, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_HANGING_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.NETHER_WOOD_HANGING_SIGN));
        SCORCHED_WALL_HANGING_SIGN = CinderscapesRegistry.registerSignBlock(CinderscapesBlockIds.SCORCHED_WALL_HANGING_SIGN, settings -> new WallHangingSignBlock(CinderscapesWoodTypes.SCORCHED, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_WALL_HANGING_SIGN).mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.NETHER_WOOD_HANGING_SIGN).overrideLootTable(SCORCHED_HANGING_SIGN.getLootTable()));

        SCORCHED_SHRUB = CinderscapesRegistry.register(CinderscapesBlockItemIds.SCORCHED_SHRUB, settings -> new CinderscapesNetherPlantBlock(_ -> Block.box(2.0, 0.0, 2.0, 14.0, 14.0, 14.0), settings), BlockBehaviour.Properties.ofFullCopy(Blocks.DEAD_BUSH).mapColor(MapColor.TERRACOTTA_GRAY));
        POTTED_SCORCHED_SHRUB = CinderscapesRegistry.register(CinderscapesBlockIds.POTTED_SCORCHED_SHRUB, settings -> new FlowerPotBlock(SCORCHED_SHRUB, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_DEAD_BUSH));

        SCORCHED_SPROUTS = CinderscapesRegistry.register(CinderscapesBlockItemIds.SCORCHED_SPROUTS, settings -> new CinderscapesNetherPlantBlock(_ -> Block.box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0), settings), BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_SPROUTS).mapColor(MapColor.COLOR_GRAY));
        SCORCHED_TENDRILS = CinderscapesRegistry.register(CinderscapesBlockItemIds.SCORCHED_TENDRILS, settings -> new CinderscapesNetherPlantBlock(_ -> Block.box(2.0, 0.0, 2.0, 14.0, 12.0, 14.0), settings), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_ROOTS).mapColor(MapColor.COLOR_GRAY));
        POTTED_SCORCHED_TENDRILS = CinderscapesRegistry.register(CinderscapesBlockIds.POTTED_SCORCHED_TENDRILS, settings -> new FlowerPotBlock(SCORCHED_TENDRILS, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_CRIMSON_ROOTS));

        ASH = CinderscapesRegistry.register(CinderscapesBlockItemIds.ASH, AshLayerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW).mapColor(MapColor.COLOR_GRAY));
        ASH_BLOCK = CinderscapesRegistry.register(CinderscapesBlockItemIds.ASH_BLOCK, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK).mapColor(MapColor.COLOR_GRAY));

        PYRACINTH = CinderscapesRegistry.register(CinderscapesBlockItemIds.PYRACINTH, PyracinthBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_ROOTS).mapColor(MapColor.COLOR_ORANGE));
        POTTED_PYRACINTH = CinderscapesRegistry.register(CinderscapesBlockIds.POTTED_PYRACINTH, PottedPyracinthBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM));

        /*//////////////////
        // Luminous Grove //
        //////////////////*/

        // Umbral Nylia

        UMBRAL_STEM = CinderscapesRegistry.register(CinderscapesBlockItemIds.UMBRAL_STEM, RotatedPillarBlock::new, PillarLogHelper.createNetherProperties(MapColor.CLAY, MapColor.COLOR_BLUE));
        STRIPPED_UMBRAL_STEM = CinderscapesRegistry.register(CinderscapesBlockItemIds.STRIPPED_UMBRAL_STEM, RotatedPillarBlock::new, PillarLogHelper.createNetherProperties(MapColor.CLAY));

        UMBRAL_HYPHAE = CinderscapesRegistry.register(CinderscapesBlockItemIds.UMBRAL_HYPHAE, RotatedPillarBlock::new, PillarLogHelper.createNetherProperties(MapColor.COLOR_BLUE));
        STRIPPED_UMBRAL_HYPHAE = CinderscapesRegistry.register(CinderscapesBlockItemIds.STRIPPED_UMBRAL_HYPHAE, RotatedPillarBlock::new, PillarLogHelper.createNetherProperties(MapColor.CLAY));

        UMBRAL_NYLIUM = CinderscapesRegistry.register(CinderscapesBlockItemIds.UMBRAL_NYLIUM, CinderscapesNyliumBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_NYLIUM).mapColor(MapColor.CLAY));

        UMBRAL_FUNGUS = CinderscapesRegistry.register(CinderscapesBlockItemIds.UMBRAL_FUNGUS, settings -> new NetherFungusBlock(CinderscapesFeatures.CANOPIED_HUGE_FUNGUS_PLANTED, UMBRAL_NYLIUM, CinderscapesBlockTags.SUPPORTS_UMBRAL_FUNGUS, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_FUNGUS).mapColor(MapColor.COLOR_BLUE).lightLevel(_ -> 15));
        POTTED_UMBRAL_FUNGUS = CinderscapesRegistry.register(CinderscapesBlockIds.POTTED_UMBRAL_FUNGUS, settings -> new FlowerPotBlock(UMBRAL_FUNGUS, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_WARPED_FUNGUS).lightLevel(_ -> 12));

        UMBRAL_WART_BLOCK = CinderscapesRegistry.register(CinderscapesBlockItemIds.UMBRAL_WART_BLOCK, CinderscapesTransparentBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_WART_BLOCK).mapColor(MapColor.COLOR_BLUE).noOcclusion());
        UMBRAL_FLESH_BLOCK = CinderscapesRegistry.register(CinderscapesBlockItemIds.UMBRAL_FLESH_BLOCK, CinderscapesTransparentBlock::new, BlockBehaviour.Properties.ofFullCopy(UMBRAL_WART_BLOCK).lightLevel(_ -> 15));

        UMBRAL_PLANKS = CinderscapesRegistry.register(CinderscapesBlockItemIds.UMBRAL_PLANKS, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).mapColor(MapColor.COLOR_BLUE));
        UMBRAL_SLAB = CinderscapesRegistry.register(CinderscapesBlockItemIds.UMBRAL_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_SLAB).mapColor(MapColor.COLOR_BLUE));
        UMBRAL_STAIRS = CinderscapesRegistry.register(CinderscapesBlockItemIds.UMBRAL_STAIRS, settings -> new StairBlock(UMBRAL_PLANKS.defaultBlockState(), settings), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_STAIRS).mapColor(MapColor.COLOR_BLUE));

        UMBRAL_BUTTON = CinderscapesRegistry.register(CinderscapesBlockItemIds.UMBRAL_BUTTON, settings -> new ButtonBlock(BlockSetType.WARPED, 30, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_BUTTON).mapColor(MapColor.COLOR_BLUE));
        UMBRAL_DOOR = CinderscapesRegistry.register(CinderscapesBlockItemIds.UMBRAL_DOOR, settings -> new DoorBlock(BlockSetType.WARPED, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_DOOR).mapColor(MapColor.COLOR_BLUE));
        UMBRAL_FENCE = CinderscapesRegistry.register(CinderscapesBlockItemIds.UMBRAL_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_FENCE).mapColor(MapColor.COLOR_BLUE));
        UMBRAL_FENCE_GATE = CinderscapesRegistry.register(CinderscapesBlockItemIds.UMBRAL_FENCE_GATE, settings -> new FenceGateBlock(WoodType.WARPED, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_FENCE_GATE).mapColor(MapColor.COLOR_BLUE));
        UMBRAL_PRESSURE_PLATE = CinderscapesRegistry.register(CinderscapesBlockItemIds.UMBRAL_PRESSURE_PLATE, settings -> new PressurePlateBlock(BlockSetType.WARPED, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PRESSURE_PLATE).mapColor(MapColor.COLOR_BLUE));
        UMBRAL_SHELF = CinderscapesRegistry.register(CinderscapesBlockItemIds.UMBRAL_SHELF, ShelfBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_SHELF).mapColor(MapColor.COLOR_BLUE));
        UMBRAL_TRAPDOOR = CinderscapesRegistry.register(CinderscapesBlockItemIds.UMBRAL_TRAPDOOR, settings -> new TrapDoorBlock(BlockSetType.WARPED, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_TRAPDOOR).mapColor(MapColor.COLOR_BLUE));

        UMBRAL_SIGN = CinderscapesRegistry.registerSignBlock(CinderscapesBlockItemIds.UMBRAL_SIGN.block(), settings -> new StandingSignBlock(CinderscapesWoodTypes.UMBRAL, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_SIGN).mapColor(MapColor.COLOR_BLUE).sound(SoundType.NETHER_WOOD));
        UMBRAL_WALL_SIGN = CinderscapesRegistry.registerSignBlock(CinderscapesBlockIds.UMBRAL_WALL_SIGN, settings -> new WallSignBlock(CinderscapesWoodTypes.UMBRAL, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_WALL_SIGN).mapColor(MapColor.COLOR_BLUE).sound(SoundType.NETHER_WOOD).overrideLootTable(UMBRAL_SIGN.getLootTable()));
        UMBRAL_HANGING_SIGN = CinderscapesRegistry.registerSignBlock(CinderscapesBlockItemIds.UMBRAL_HANGING_SIGN.block(), settings -> new CeilingHangingSignBlock(CinderscapesWoodTypes.UMBRAL, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_HANGING_SIGN).mapColor(MapColor.COLOR_BLUE).sound(SoundType.NETHER_WOOD_HANGING_SIGN));
        UMBRAL_WALL_HANGING_SIGN = CinderscapesRegistry.registerSignBlock(CinderscapesBlockIds.UMBRAL_WALL_HANGING_SIGN, settings -> new WallHangingSignBlock(CinderscapesWoodTypes.UMBRAL, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_WALL_HANGING_SIGN).mapColor(MapColor.COLOR_BLUE).sound(SoundType.NETHER_WOOD_HANGING_SIGN).overrideLootTable(UMBRAL_HANGING_SIGN.getLootTable()));

        // Other

        TWILIGHT_VINE_BLOCK = CinderscapesRegistry.register(CinderscapesBlockItemIds.TWILIGHT_VINE_BLOCK, Block::new, BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_STEM).instrument(NoteBlockInstrument.BASS).strength(1.0F).sound(SoundType.STEM));
        TWILIGHT_TENDRILS = CinderscapesRegistry.register(CinderscapesBlockItemIds.TWILIGHT_TENDRILS, settings -> new CinderscapesNetherPlantBlock(_ -> Block.box(2.0, 0.0, 2.0, 14.0, 12.0, 14.0), settings), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_ROOTS).mapColor(MapColor.ICE).lightLevel(_ -> 15));
        POTTED_TWILIGHT_TENDRILS = CinderscapesRegistry.register(CinderscapesBlockIds.POTTED_TWILIGHT_TENDRILS, settings -> new FlowerPotBlock(TWILIGHT_TENDRILS, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_WARPED_ROOTS).lightLevel(_ -> 12));
        TWILIGHT_FESCUES = CinderscapesRegistry.register(CinderscapesBlockItemIds.TWILIGHT_FESCUES, settings -> new CinderscapesNetherPlantBlock(_ -> Block.box(2.0, 0.0, 2.0, 14.0, 5.0, 14.0), settings), BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_SPROUTS).mapColor(MapColor.COLOR_PURPLE));

        PHOTOFERN = CinderscapesRegistry.register(CinderscapesBlockItemIds.PHOTOFERN, PhotofernBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_ROOTS).mapColor(MapColor.COLOR_PURPLE));
        POTTED_PHOTOFERN = CinderscapesRegistry.register(CinderscapesBlockIds.POTTED_PHOTOFERN, settings -> new FlowerPotBlock(PHOTOFERN, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_FERN));

        TALL_PHOTOFERN = CinderscapesRegistry.register(CinderscapesBlockItemIds.TALL_PHOTOFERN, settings -> new CinderscapesNetherTallPlantBlock(_ -> Block.box(2.0, 0, 2.0, 14.0, 16.0, 14.0), settings), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_ROOTS).mapColor(MapColor.COLOR_PURPLE));

        LUMINOUS_POD = CinderscapesRegistry.register(CinderscapesBlockItemIds.LUMINOUS_POD, settings -> new CinderscapesNetherTallPlantBlock(_ -> Block.box(2.0, 0, 2.0, 14.0, 16.0, 14.0), settings), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_ROOTS).mapColor(MapColor.GRASS).lightLevel(_ -> 15));
        POTTED_LUMINOUS_POD = CinderscapesRegistry.register(CinderscapesBlockIds.POTTED_LUMINOUS_POD, settings -> new FlowerPotBlock(LUMINOUS_POD, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_WARPED_ROOTS).lightLevel(_ -> 12));
        GHASTLY_ECTOPLASM = CinderscapesRegistry.register(CinderscapesBlockItemIds.GHASTLY_ECTOPLASM, GhastlyEctoplasmBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WEEPING_VINES_PLANT).mapColor(MapColor.QUARTZ).sound(SoundType.ROOTS));

        /*/////////
        // Other //
        /////////*/

        BRAMBLE_BERRY_BUSH = CinderscapesRegistry.register(CinderscapesBlockIds.BRAMBLE_BERRY_BUSH, BrambleBerryBushBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH).mapColor(MapColor.TERRACOTTA_BLACK));

        NODZOL = CinderscapesRegistry.register(CinderscapesBlockItemIds.NODZOL, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK).mapColor(MapColor.COLOR_BROWN));

        SULFUR_BLOCK = CinderscapesRegistry.register(CinderscapesBlockItemIds.SULFUR_BLOCK, Block::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.SNARE).strength(0.5F, 0.5f).sound(SoundType.GRAVEL));
        SULFUR_ORE = CinderscapesRegistry.register(CinderscapesBlockItemIds.SULFUR_ORE, CinderscapesOreBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_QUARTZ_ORE).mapColor(MapColor.COLOR_YELLOW).sound(SoundType.NETHER_ORE).requiresCorrectToolForDrops());

        /*/////////////////
        // Quartz Cavern //
        /////////////////*/

        CRYSTINIUM = CinderscapesRegistry.register(CinderscapesBlockItemIds.CRYSTINIUM, CrystiniumBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_ROOTS).mapColor(MapColor.COLOR_YELLOW));
        POTTED_CRYSTINIUM = CinderscapesRegistry.register(CinderscapesBlockIds.POTTED_CRYSTINIUM, PottedCrystiniumBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM));

        CRYSTALLINE_QUARTZ = CinderscapesRegistry.register(CinderscapesBlockItemIds.CRYSTALLINE_QUARTZ, CinderscapesTransparentBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).sound(SoundType.GLASS).noOcclusion().isValidSpawn(CinderscapesBlocks::never).isRedstoneConductor(CinderscapesBlocks::never).isSuffocating(CinderscapesBlocks::never).isViewBlocking(CinderscapesBlocks::never));
        POLYPITE_QUARTZ = CinderscapesRegistry.register(CinderscapesBlockItemIds.POLYPITE_QUARTZ, PolypiteQuartzBlock::new, BlockBehaviour.Properties.ofFullCopy(CRYSTALLINE_QUARTZ));
        POTTED_POLYPITE_QUARTZ = CinderscapesRegistry.register(CinderscapesBlockIds.POTTED_POLYPITE_QUARTZ, settings -> new FlowerPotBlock(POLYPITE_QUARTZ, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT));

        // Sulfur Quartz

        SULFUR_QUARTZ_ORE = CinderscapesRegistry.register(CinderscapesBlockItemIds.SULFUR_QUARTZ_ORE, CinderscapesOreBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_QUARTZ_ORE).mapColor(MapColor.COLOR_YELLOW).sound(SoundType.NETHER_ORE).requiresCorrectToolForDrops());
        SULFUR_QUARTZ_BLOCK = CinderscapesRegistry.register(CinderscapesBlockItemIds.SULFUR_QUARTZ_BLOCK, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.COLOR_YELLOW));
        CHISELED_SULFUR_QUARTZ_BLOCK = CinderscapesRegistry.register(CinderscapesBlockItemIds.CHISELED_SULFUR_QUARTZ_BLOCK, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.COLOR_YELLOW));
        SULFUR_QUARTZ_PILLAR = CinderscapesRegistry.register(CinderscapesBlockItemIds.SULFUR_QUARTZ_PILLAR, RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_PILLAR).mapColor(MapColor.COLOR_YELLOW));
        SULFUR_QUARTZ_STAIRS = CinderscapesRegistry.register(CinderscapesBlockItemIds.SULFUR_QUARTZ_STAIRS, settings -> new StairBlock(SULFUR_QUARTZ_BLOCK.defaultBlockState(), settings), BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_STAIRS).mapColor(MapColor.COLOR_YELLOW));
        SULFUR_QUARTZ_SLAB = CinderscapesRegistry.register(CinderscapesBlockItemIds.SULFUR_QUARTZ_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_SLAB).mapColor(MapColor.COLOR_YELLOW));
        SMOOTH_SULFUR_QUARTZ = CinderscapesRegistry.register(CinderscapesBlockItemIds.SMOOTH_SULFUR_QUARTZ, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_QUARTZ).mapColor(MapColor.COLOR_YELLOW));
        SMOOTH_SULFUR_QUARTZ_STAIRS = CinderscapesRegistry.register(CinderscapesBlockItemIds.SMOOTH_SULFUR_QUARTZ_STAIRS, settings -> new StairBlock(SMOOTH_SULFUR_QUARTZ.defaultBlockState(), settings), BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_QUARTZ_STAIRS).mapColor(MapColor.COLOR_YELLOW));
        SMOOTH_SULFUR_QUARTZ_SLAB = CinderscapesRegistry.register(CinderscapesBlockItemIds.SMOOTH_SULFUR_QUARTZ_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_QUARTZ_SLAB).mapColor(MapColor.COLOR_YELLOW));
        SULFUR_QUARTZ_BRICKS = CinderscapesRegistry.register(CinderscapesBlockItemIds.SULFUR_QUARTZ_BRICKS, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).mapColor(MapColor.COLOR_YELLOW));

        CRYSTALLINE_SULFUR_QUARTZ = CinderscapesRegistry.register(CinderscapesBlockItemIds.CRYSTALLINE_SULFUR_QUARTZ, CinderscapesTransparentBlock::new, BlockBehaviour.Properties.ofFullCopy(CRYSTALLINE_QUARTZ).mapColor(MapColor.COLOR_YELLOW));
        POLYPITE_SULFUR_QUARTZ = CinderscapesRegistry.register(CinderscapesBlockItemIds.POLYPITE_SULFUR_QUARTZ, PolypiteQuartzBlock::new, BlockBehaviour.Properties.ofFullCopy(CRYSTALLINE_SULFUR_QUARTZ));
        POTTED_POLYPITE_SULFUR_QUARTZ = CinderscapesRegistry.register(CinderscapesBlockIds.POTTED_POLYPITE_SULFUR_QUARTZ, settings -> new FlowerPotBlock(POLYPITE_SULFUR_QUARTZ, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT));

        // Rose Quartz

        ROSE_QUARTZ_ORE = CinderscapesRegistry.register(CinderscapesBlockItemIds.ROSE_QUARTZ_ORE, CinderscapesOreBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_QUARTZ_ORE).mapColor(MapColor.COLOR_PINK).sound(SoundType.NETHER_ORE).requiresCorrectToolForDrops());
        ROSE_QUARTZ_BLOCK = CinderscapesRegistry.register(CinderscapesBlockItemIds.ROSE_QUARTZ_BLOCK, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.COLOR_PINK));
        CHISELED_ROSE_QUARTZ_BLOCK = CinderscapesRegistry.register(CinderscapesBlockItemIds.CHISELED_ROSE_QUARTZ_BLOCK, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.COLOR_PINK));
        ROSE_QUARTZ_PILLAR = CinderscapesRegistry.register(CinderscapesBlockItemIds.ROSE_QUARTZ_PILLAR, RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_PILLAR).mapColor(MapColor.COLOR_PINK));
        ROSE_QUARTZ_STAIRS = CinderscapesRegistry.register(CinderscapesBlockItemIds.ROSE_QUARTZ_STAIRS, settings -> new StairBlock(ROSE_QUARTZ_BLOCK.defaultBlockState(), settings), BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_STAIRS).mapColor(MapColor.COLOR_PINK));
        ROSE_QUARTZ_SLAB = CinderscapesRegistry.register(CinderscapesBlockItemIds.ROSE_QUARTZ_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_SLAB).mapColor(MapColor.COLOR_PINK));
        SMOOTH_ROSE_QUARTZ = CinderscapesRegistry.register(CinderscapesBlockItemIds.SMOOTH_ROSE_QUARTZ, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_QUARTZ).mapColor(MapColor.COLOR_PINK));
        SMOOTH_ROSE_QUARTZ_STAIRS = CinderscapesRegistry.register(CinderscapesBlockItemIds.SMOOTH_ROSE_QUARTZ_STAIRS, settings -> new StairBlock(SMOOTH_ROSE_QUARTZ.defaultBlockState(), settings), BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_QUARTZ_STAIRS).mapColor(MapColor.COLOR_PINK));
        SMOOTH_ROSE_QUARTZ_SLAB = CinderscapesRegistry.register(CinderscapesBlockItemIds.SMOOTH_ROSE_QUARTZ_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_QUARTZ_SLAB).mapColor(MapColor.COLOR_PINK));
        ROSE_QUARTZ_BRICKS = CinderscapesRegistry.register(CinderscapesBlockItemIds.ROSE_QUARTZ_BRICKS, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).mapColor(MapColor.COLOR_PINK));

        CRYSTALLINE_ROSE_QUARTZ = CinderscapesRegistry.register(CinderscapesBlockItemIds.CRYSTALLINE_ROSE_QUARTZ, CinderscapesTransparentBlock::new, BlockBehaviour.Properties.ofFullCopy(CRYSTALLINE_QUARTZ).mapColor(MapColor.COLOR_PINK));
        POLYPITE_ROSE_QUARTZ = CinderscapesRegistry.register(CinderscapesBlockItemIds.POLYPITE_ROSE_QUARTZ, PolypiteQuartzBlock::new, BlockBehaviour.Properties.ofFullCopy(CRYSTALLINE_ROSE_QUARTZ));
        POTTED_POLYPITE_ROSE_QUARTZ = CinderscapesRegistry.register(CinderscapesBlockIds.POTTED_POLYPITE_ROSE_QUARTZ, settings -> new FlowerPotBlock(POLYPITE_ROSE_QUARTZ, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT));

        // Smoky Quartz

        SMOKY_QUARTZ_ORE = CinderscapesRegistry.register(CinderscapesBlockItemIds.SMOKY_QUARTZ_ORE, CinderscapesOreBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_QUARTZ_ORE).mapColor(MapColor.COLOR_GRAY).sound(SoundType.NETHER_ORE).requiresCorrectToolForDrops());
        SMOKY_QUARTZ_BLOCK = CinderscapesRegistry.register(CinderscapesBlockItemIds.SMOKY_QUARTZ_BLOCK, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.COLOR_GRAY));
        CHISELED_SMOKY_QUARTZ_BLOCK = CinderscapesRegistry.register(CinderscapesBlockItemIds.CHISELED_SMOKY_QUARTZ_BLOCK, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.COLOR_GRAY));
        SMOKY_QUARTZ_PILLAR = CinderscapesRegistry.register(CinderscapesBlockItemIds.SMOKY_QUARTZ_PILLAR, RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_PILLAR).mapColor(MapColor.COLOR_GRAY));
        SMOKY_QUARTZ_STAIRS = CinderscapesRegistry.register(CinderscapesBlockItemIds.SMOKY_QUARTZ_STAIRS, settings -> new StairBlock(SMOKY_QUARTZ_BLOCK.defaultBlockState(), settings), BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_STAIRS).mapColor(MapColor.COLOR_GRAY));
        SMOKY_QUARTZ_SLAB = CinderscapesRegistry.register(CinderscapesBlockItemIds.SMOKY_QUARTZ_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_SLAB).mapColor(MapColor.COLOR_GRAY));
        SMOOTH_SMOKY_QUARTZ = CinderscapesRegistry.register(CinderscapesBlockItemIds.SMOOTH_SMOKY_QUARTZ, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_QUARTZ).mapColor(MapColor.COLOR_GRAY));
        SMOOTH_SMOKY_QUARTZ_STAIRS = CinderscapesRegistry.register(CinderscapesBlockItemIds.SMOOTH_SMOKY_QUARTZ_STAIRS, settings -> new StairBlock(SMOOTH_SMOKY_QUARTZ.defaultBlockState(), settings), BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_QUARTZ_STAIRS).mapColor(MapColor.COLOR_GRAY));
        SMOOTH_SMOKY_QUARTZ_SLAB = CinderscapesRegistry.register(CinderscapesBlockItemIds.SMOOTH_SMOKY_QUARTZ_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_QUARTZ_SLAB).mapColor(MapColor.COLOR_GRAY));
        SMOKY_QUARTZ_BRICKS = CinderscapesRegistry.register(CinderscapesBlockItemIds.SMOKY_QUARTZ_BRICKS, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).mapColor(MapColor.COLOR_GRAY));

        CRYSTALLINE_SMOKY_QUARTZ = CinderscapesRegistry.register(CinderscapesBlockItemIds.CRYSTALLINE_SMOKY_QUARTZ, CinderscapesTransparentBlock::new, BlockBehaviour.Properties.ofFullCopy(CRYSTALLINE_QUARTZ).mapColor(MapColor.COLOR_GRAY));
        POLYPITE_SMOKY_QUARTZ = CinderscapesRegistry.register(CinderscapesBlockItemIds.POLYPITE_SMOKY_QUARTZ, PolypiteQuartzBlock::new, BlockBehaviour.Properties.ofFullCopy(CRYSTALLINE_SMOKY_QUARTZ));
        POTTED_POLYPITE_SMOKY_QUARTZ = CinderscapesRegistry.register(CinderscapesBlockIds.POTTED_POLYPITE_SMOKY_QUARTZ, settings -> new FlowerPotBlock(POLYPITE_SMOKY_QUARTZ, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT));

        addStrippables();
    }

    private static void addStrippables() {
        BlockTransformerHelper.registerStripping(SCORCHED_STEM, STRIPPED_SCORCHED_STEM);
        BlockTransformerHelper.registerStripping(SCORCHED_HYPHAE, STRIPPED_SCORCHED_HYPHAE);
        BlockTransformerHelper.registerStripping(UMBRAL_STEM, STRIPPED_UMBRAL_STEM);
        BlockTransformerHelper.registerStripping(UMBRAL_HYPHAE, STRIPPED_UMBRAL_HYPHAE);
    }

    // Predicate that just don't care
    private static boolean never(Object... ignored) {
        return false;
    }
}
