package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.block.AshLayerBlock;
import com.terraformersmc.cinderscapes.block.BrambleBerryBushBlock;
import com.terraformersmc.cinderscapes.block.CinderscapesNetherPlantBlock;
import com.terraformersmc.cinderscapes.block.CinderscapesNetherTallPlantBlock;
import com.terraformersmc.cinderscapes.block.CinderscapesNyliumBlock;
import com.terraformersmc.cinderscapes.block.CinderscapesOreBlock;
import com.terraformersmc.cinderscapes.block.CinderscapesTransparentBlock;
import com.terraformersmc.cinderscapes.block.CrystiniumBlock;
import com.terraformersmc.cinderscapes.block.GhastlyEctoplasmBlock;
import com.terraformersmc.cinderscapes.block.PhotofernBlock;
import com.terraformersmc.cinderscapes.block.PolypiteQuartzBlock;
import com.terraformersmc.cinderscapes.block.PottedCrystiniumBlock;
import com.terraformersmc.cinderscapes.block.PottedPyracinthBlock;
import com.terraformersmc.cinderscapes.block.PyracinthBlock;
import com.terraformersmc.cinderscapes.init.helpers.CinderscapesRegistry;
import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import com.terraformersmc.terraform.wood.api.block.PillarLogHelper;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.entity.EntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
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

    public static TerraformSignBlock SCORCHED_SIGN;
    public static TerraformWallSignBlock SCORCHED_WALL_SIGN;
    public static TerraformHangingSignBlock SCORCHED_HANGING_SIGN;
    public static TerraformWallHangingSignBlock SCORCHED_WALL_HANGING_SIGN;

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

    public static TerraformSignBlock UMBRAL_SIGN;
    public static TerraformWallSignBlock UMBRAL_WALL_SIGN;
    public static TerraformHangingSignBlock UMBRAL_HANGING_SIGN;
    public static TerraformWallHangingSignBlock UMBRAL_WALL_HANGING_SIGN;

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

        SCORCHED_STEM = CinderscapesRegistry.register("scorched_stem", PillarLogHelper.ofNether(MapColor.GRAY, MapColor.TERRACOTTA_GRAY));
        STRIPPED_SCORCHED_STEM = CinderscapesRegistry.register("stripped_scorched_stem", PillarLogHelper.ofNether(MapColor.GRAY));

        SCORCHED_HYPHAE = CinderscapesRegistry.register("scorched_hyphae", PillarLogHelper.ofNether(MapColor.TERRACOTTA_GRAY));
        STRIPPED_SCORCHED_HYPHAE = CinderscapesRegistry.register("stripped_scorched_hyphae", PillarLogHelper.ofNether(MapColor.GRAY));

        SCORCHED_PLANKS = CinderscapesRegistry.register("scorched_planks", new Block(AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).mapColor(MapColor.LIGHT_GRAY)));
        SCORCHED_SLAB = CinderscapesRegistry.register("scorched_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.CRIMSON_SLAB).mapColor(MapColor.LIGHT_GRAY)));

        SCORCHED_PRESSURE_PLATE = CinderscapesRegistry.register("scorched_pressure_plate", new PressurePlateBlock(BlockSetType.CRIMSON, AbstractBlock.Settings.copy(Blocks.CRIMSON_PRESSURE_PLATE).mapColor(MapColor.LIGHT_GRAY)));
        SCORCHED_FENCE = CinderscapesRegistry.register("scorched_fence", new FenceBlock(AbstractBlock.Settings.copy(Blocks.CRIMSON_FENCE).mapColor(MapColor.LIGHT_GRAY)));
        SCORCHED_TRAPDOOR = CinderscapesRegistry.register("scorched_trapdoor", new TrapdoorBlock(BlockSetType.CRIMSON, AbstractBlock.Settings.copy(Blocks.CRIMSON_TRAPDOOR).mapColor(MapColor.LIGHT_GRAY)));
        SCORCHED_FENCE_GATE = CinderscapesRegistry.register("scorched_fence_gate", new FenceGateBlock(WoodType.CRIMSON, AbstractBlock.Settings.copy(Blocks.CRIMSON_FENCE_GATE).mapColor(MapColor.LIGHT_GRAY)));
        SCORCHED_STAIRS = CinderscapesRegistry.register("scorched_stairs", new StairsBlock(SCORCHED_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.CRIMSON_STAIRS).mapColor(MapColor.LIGHT_GRAY)));
        SCORCHED_BUTTON = CinderscapesRegistry.register("scorched_button", new ButtonBlock(BlockSetType.CRIMSON, 30, AbstractBlock.Settings.copy(Blocks.CRIMSON_BUTTON).mapColor(MapColor.LIGHT_GRAY)));
        SCORCHED_DOOR = CinderscapesRegistry.register("scorched_door", new DoorBlock(BlockSetType.CRIMSON, AbstractBlock.Settings.copy(Blocks.CRIMSON_DOOR).mapColor(MapColor.LIGHT_GRAY)));

        final Identifier SCORCHED_SIGN_TEXTURE = Identifier.of(Cinderscapes.MOD_ID, "entity/signs/scorched");
        SCORCHED_SIGN = CinderscapesRegistry.register("scorched_sign", new TerraformSignBlock(SCORCHED_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.CRIMSON_SIGN).mapColor(MapColor.LIGHT_GRAY).sounds(BlockSoundGroup.NETHER_WOOD)));
        SCORCHED_WALL_SIGN = CinderscapesRegistry.register("scorched_wall_sign", new TerraformWallSignBlock(SCORCHED_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.CRIMSON_WALL_SIGN).mapColor(MapColor.LIGHT_GRAY).sounds(BlockSoundGroup.NETHER_WOOD).dropsLike(SCORCHED_SIGN)));
        final Identifier SCORCHED_HANGING_SIGN_TEXTURE = Identifier.of(Cinderscapes.MOD_ID, "entity/signs/hanging/scorched");
        final Identifier SCORCHED_HANGING_SIGN_GUI_TEXTURE = Identifier.of(Cinderscapes.MOD_ID, "textures/gui/hanging_signs/scorched");
        SCORCHED_HANGING_SIGN = CinderscapesRegistry.register("scorched_hanging_sign", new TerraformHangingSignBlock(SCORCHED_HANGING_SIGN_TEXTURE, SCORCHED_HANGING_SIGN_GUI_TEXTURE, AbstractBlock.Settings.copy(Blocks.CRIMSON_HANGING_SIGN).mapColor(MapColor.LIGHT_GRAY).sounds(BlockSoundGroup.NETHER_WOOD_HANGING_SIGN)));
        SCORCHED_WALL_HANGING_SIGN = CinderscapesRegistry.register("scorched_wall_hanging_sign", new TerraformWallHangingSignBlock(SCORCHED_HANGING_SIGN_TEXTURE, SCORCHED_HANGING_SIGN_GUI_TEXTURE, AbstractBlock.Settings.copy(Blocks.CRIMSON_WALL_HANGING_SIGN).mapColor(MapColor.LIGHT_GRAY).sounds(BlockSoundGroup.NETHER_WOOD_HANGING_SIGN).dropsLike(SCORCHED_HANGING_SIGN)));

        SCORCHED_SHRUB = CinderscapesRegistry.register("scorched_shrub", new CinderscapesNetherPlantBlock(AbstractBlock.Settings.copy(Blocks.DEAD_BUSH).mapColor(MapColor.TERRACOTTA_GRAY), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 14.0, 14.0)));
        POTTED_SCORCHED_SHRUB = CinderscapesRegistry.register("potted_scorched_shrub", new FlowerPotBlock(SCORCHED_SHRUB, AbstractBlock.Settings.copy(Blocks.POTTED_DEAD_BUSH)));

        SCORCHED_SPROUTS = CinderscapesRegistry.register("scorched_sprouts", new CinderscapesNetherPlantBlock(AbstractBlock.Settings.copy(Blocks.NETHER_SPROUTS).mapColor(MapColor.GRAY), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)));
        SCORCHED_TENDRILS = CinderscapesRegistry.register("scorched_tendrils", new CinderscapesNetherPlantBlock(AbstractBlock.Settings.copy(Blocks.CRIMSON_ROOTS).mapColor(MapColor.GRAY), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0)));
        POTTED_SCORCHED_TENDRILS = CinderscapesRegistry.register("potted_scorched_tendrils", new FlowerPotBlock(SCORCHED_TENDRILS, AbstractBlock.Settings.copy(Blocks.POTTED_CRIMSON_ROOTS)));

        ASH = CinderscapesRegistry.register("ash", new AshLayerBlock(AbstractBlock.Settings.copy(Blocks.SNOW).mapColor(MapColor.GRAY)));
        ASH_BLOCK = CinderscapesRegistry.register("ash_block", new Block(AbstractBlock.Settings.copy(Blocks.SNOW_BLOCK).mapColor(MapColor.GRAY)));

        PYRACINTH = CinderscapesRegistry.register("pyracinth", new PyracinthBlock());
        POTTED_PYRACINTH = CinderscapesRegistry.register("potted_pyracinth", new PottedPyracinthBlock());

        ////////////////////
        // Luminous Grove //
        ////////////////////

        // Umbral Nylia

        UMBRAL_STEM = CinderscapesRegistry.register("umbral_stem", PillarLogHelper.ofNether(MapColor.LIGHT_BLUE_GRAY, MapColor.BLUE));
        STRIPPED_UMBRAL_STEM = CinderscapesRegistry.register("stripped_umbral_stem", PillarLogHelper.ofNether(MapColor.LIGHT_BLUE_GRAY));

        UMBRAL_HYPHAE = CinderscapesRegistry.register("umbral_hyphae", PillarLogHelper.ofNether(MapColor.BLUE));
        STRIPPED_UMBRAL_HYPHAE = CinderscapesRegistry.register("stripped_umbral_hyphae", PillarLogHelper.ofNether(MapColor.LIGHT_BLUE_GRAY));

        UMBRAL_NYLIUM = CinderscapesRegistry.register("umbral_nylium", new CinderscapesNyliumBlock(AbstractBlock.Settings.copy(Blocks.WARPED_NYLIUM).mapColor(MapColor.LIGHT_BLUE_GRAY)));

        UMBRAL_FUNGUS = CinderscapesRegistry.register("umbral_fungus", new FungusBlock(CinderscapesConfiguredFeatures.CANOPIED_HUGE_FUNGUS_PLANTED, UMBRAL_NYLIUM, AbstractBlock.Settings.copy(Blocks.WARPED_FUNGUS).mapColor(MapColor.BLUE).luminance(state -> 15)));
        POTTED_UMBRAL_FUNGUS = CinderscapesRegistry.register("potted_umbral_fungus", new FlowerPotBlock(UMBRAL_FUNGUS, AbstractBlock.Settings.copy(Blocks.POTTED_WARPED_FUNGUS)));

        UMBRAL_WART_BLOCK = CinderscapesRegistry.register("umbral_wart_block", new CinderscapesTransparentBlock(AbstractBlock.Settings.copy(Blocks.WARPED_WART_BLOCK).mapColor(MapColor.BLUE).nonOpaque()));
        UMBRAL_FLESH_BLOCK = CinderscapesRegistry.register("umbral_flesh_block", new CinderscapesTransparentBlock(AbstractBlock.Settings.copy(UMBRAL_WART_BLOCK).luminance(state -> 15)));

        UMBRAL_PLANKS = CinderscapesRegistry.register("umbral_planks", new Block(AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).mapColor(MapColor.BLUE)));
        UMBRAL_SLAB = CinderscapesRegistry.register("umbral_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.WARPED_SLAB).mapColor(MapColor.BLUE)));
        UMBRAL_PRESSURE_PLATE = CinderscapesRegistry.register("umbral_pressure_plate", new PressurePlateBlock(BlockSetType.WARPED, AbstractBlock.Settings.copy(Blocks.WARPED_PRESSURE_PLATE).mapColor(MapColor.BLUE)));
        UMBRAL_FENCE = CinderscapesRegistry.register("umbral_fence", new FenceBlock(AbstractBlock.Settings.copy(Blocks.WARPED_FENCE).mapColor(MapColor.BLUE)));
        UMBRAL_TRAPDOOR = CinderscapesRegistry.register("umbral_trapdoor", new TrapdoorBlock(BlockSetType.WARPED, AbstractBlock.Settings.copy(Blocks.WARPED_TRAPDOOR).mapColor(MapColor.BLUE)));
        UMBRAL_FENCE_GATE = CinderscapesRegistry.register("umbral_fence_gate", new FenceGateBlock(WoodType.WARPED, AbstractBlock.Settings.copy(Blocks.WARPED_FENCE_GATE).mapColor(MapColor.BLUE)));
        UMBRAL_STAIRS = CinderscapesRegistry.register("umbral_stairs", new StairsBlock(UMBRAL_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.WARPED_STAIRS).mapColor(MapColor.BLUE)));
        UMBRAL_BUTTON = CinderscapesRegistry.register("umbral_button", new ButtonBlock(BlockSetType.WARPED, 30, AbstractBlock.Settings.copy(Blocks.WARPED_BUTTON).mapColor(MapColor.BLUE)));
        UMBRAL_DOOR = CinderscapesRegistry.register("umbral_door", new DoorBlock(BlockSetType.WARPED, AbstractBlock.Settings.copy(Blocks.WARPED_DOOR).mapColor(MapColor.BLUE)));

        final Identifier UMBRAL_SIGN_TEXTURE = Identifier.of(Cinderscapes.MOD_ID, "entity/signs/umbral");
        UMBRAL_SIGN = CinderscapesRegistry.register("umbral_sign", new TerraformSignBlock(UMBRAL_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.WARPED_SIGN).mapColor(MapColor.BLUE).sounds(BlockSoundGroup.NETHER_WOOD)));
        UMBRAL_WALL_SIGN = CinderscapesRegistry.register("umbral_wall_sign", new TerraformWallSignBlock(UMBRAL_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.WARPED_WALL_SIGN).mapColor(MapColor.BLUE).sounds(BlockSoundGroup.NETHER_WOOD).dropsLike(UMBRAL_SIGN)));
        final Identifier UMBRAL_HANGING_SIGN_TEXTURE = Identifier.of(Cinderscapes.MOD_ID, "entity/signs/hanging/umbral");
        final Identifier UMBRAL_HANGING_SIGN_GUI_TEXTURE = Identifier.of(Cinderscapes.MOD_ID, "textures/gui/hanging_signs/umbral");
        UMBRAL_HANGING_SIGN = CinderscapesRegistry.register("umbral_hanging_sign", new TerraformHangingSignBlock(UMBRAL_HANGING_SIGN_TEXTURE, UMBRAL_HANGING_SIGN_GUI_TEXTURE, AbstractBlock.Settings.copy(Blocks.WARPED_HANGING_SIGN).mapColor(MapColor.BLUE).sounds(BlockSoundGroup.NETHER_WOOD_HANGING_SIGN)));
        UMBRAL_WALL_HANGING_SIGN = CinderscapesRegistry.register("umbral_wall_hanging_sign", new TerraformWallHangingSignBlock(UMBRAL_HANGING_SIGN_TEXTURE, UMBRAL_HANGING_SIGN_GUI_TEXTURE, AbstractBlock.Settings.copy(Blocks.WARPED_WALL_HANGING_SIGN).mapColor(MapColor.BLUE).sounds(BlockSoundGroup.NETHER_WOOD_HANGING_SIGN).dropsLike(UMBRAL_HANGING_SIGN)));

        // Other

        TWILIGHT_VINE_BLOCK = CinderscapesRegistry.register("twilight_vine_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.DARK_AQUA).instrument(NoteBlockInstrument.BASS).strength(1.0F).sounds(BlockSoundGroup.NETHER_STEM)));
        TWILIGHT_TENDRILS = CinderscapesRegistry.register("twilight_tendrils", new CinderscapesNetherPlantBlock(AbstractBlock.Settings.copy(Blocks.WARPED_ROOTS).mapColor(MapColor.PALE_PURPLE).luminance((state) -> 15), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0)));
        POTTED_TWILIGHT_TENDRILS = CinderscapesRegistry.register("potted_twilight_tendrils", new FlowerPotBlock(TWILIGHT_TENDRILS, AbstractBlock.Settings.copy(Blocks.POTTED_WARPED_ROOTS).luminance((state) -> 15)));
        TWILIGHT_FESCUES = CinderscapesRegistry.register("twilight_fescues", new CinderscapesNetherPlantBlock(AbstractBlock.Settings.copy(Blocks.NETHER_SPROUTS).mapColor(MapColor.PURPLE), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 5.0, 14.0)));

        PHOTOFERN = CinderscapesRegistry.register("photofern", new PhotofernBlock());
        POTTED_PHOTOFERN = CinderscapesRegistry.register("potted_photofern", new FlowerPotBlock(PHOTOFERN, AbstractBlock.Settings.copy(Blocks.POTTED_FERN)));

        TALL_PHOTOFERN = CinderscapesRegistry.register("tall_photofern", new CinderscapesNetherTallPlantBlock(AbstractBlock.Settings.copy(Blocks.WARPED_ROOTS).mapColor(MapColor.PURPLE), (state) -> Block.createCuboidShape(2.0, 0, 2.0, 14.0, 16.0, 14.0)));

        LUMINOUS_POD = CinderscapesRegistry.register("luminous_pod", new CinderscapesNetherTallPlantBlock(AbstractBlock.Settings.copy(Blocks.WARPED_ROOTS).mapColor(MapColor.PALE_GREEN).luminance((state) -> 15), (state) -> Block.createCuboidShape(2.0, 0, 2.0, 14.0, 16.0, 14.0)));
        POTTED_LUMINOUS_POD = CinderscapesRegistry.register("potted_luminous_pod", new FlowerPotBlock(LUMINOUS_POD, AbstractBlock.Settings.copy(Blocks.POTTED_WARPED_ROOTS).luminance((state) -> 15)));
        GHASTLY_ECTOPLASM = CinderscapesRegistry.register("ghastly_ectoplasm", new GhastlyEctoplasmBlock(AbstractBlock.Settings.copy(Blocks.WEEPING_VINES_PLANT).mapColor(MapColor.OFF_WHITE).sounds(BlockSoundGroup.ROOTS)));

        ///////////
        // Other //
        ///////////

        BRAMBLE_BERRY_BUSH = CinderscapesRegistry.register("bramble_berry_bush", new BrambleBerryBushBlock(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH).mapColor(MapColor.TERRACOTTA_BLACK)));

        NODZOL = CinderscapesRegistry.register("nodzol", new Block(AbstractBlock.Settings.copy(Blocks.NETHERRACK).mapColor(MapColor.BROWN)));

        SULFUR_BLOCK = CinderscapesRegistry.register("sulfur_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.YELLOW).instrument(NoteBlockInstrument.SNARE).strength(0.5F, 0.5f).sounds(BlockSoundGroup.GRAVEL)));
        SULFUR_ORE = CinderscapesRegistry.register("sulfur_ore", new CinderscapesOreBlock(AbstractBlock.Settings.copy(Blocks.NETHER_QUARTZ_ORE).mapColor(MapColor.YELLOW).sounds(BlockSoundGroup.NETHER_ORE).requiresTool()));

        ///////////////////
        // Quartz Cavern //
        ///////////////////

        CRYSTINIUM = CinderscapesRegistry.register("crystinium", new CrystiniumBlock());
        POTTED_CRYSTINIUM = CinderscapesRegistry.register("potted_crystinium", new PottedCrystiniumBlock());

        CRYSTALLINE_QUARTZ = CinderscapesRegistry.register("crystalline_quartz", new CinderscapesTransparentBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).sounds(BlockSoundGroup.GLASS).nonOpaque().allowsSpawning(CinderscapesBlocks::never).solidBlock(CinderscapesBlocks::never).suffocates(CinderscapesBlocks::never).blockVision(CinderscapesBlocks::never)));
        POLYPITE_QUARTZ = CinderscapesRegistry.register("polypite_quartz", new PolypiteQuartzBlock(AbstractBlock.Settings.copy(CRYSTALLINE_QUARTZ)));
        POTTED_POLYPITE_QUARTZ = CinderscapesRegistry.register("potted_polypite_quartz", new FlowerPotBlock(POLYPITE_QUARTZ, AbstractBlock.Settings.copy(Blocks.FLOWER_POT)));

        // Sulfur Quartz

        SULFUR_QUARTZ_ORE = CinderscapesRegistry.register("sulfur_quartz_ore", new CinderscapesOreBlock(AbstractBlock.Settings.copy(Blocks.NETHER_QUARTZ_ORE).mapColor(MapColor.YELLOW).sounds(BlockSoundGroup.NETHER_ORE).requiresTool()));
        SULFUR_QUARTZ_BLOCK = CinderscapesRegistry.register("sulfur_quartz_block", new Block(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.YELLOW)));
        CHISELED_SULFUR_QUARTZ_BLOCK = CinderscapesRegistry.register("chiseled_sulfur_quartz_block", new Block(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.YELLOW)));
        SULFUR_QUARTZ_PILLAR = CinderscapesRegistry.register("sulfur_quartz_pillar", new PillarBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_PILLAR).mapColor(MapColor.YELLOW)));
        SULFUR_QUARTZ_STAIRS = CinderscapesRegistry.register("sulfur_quartz_stairs", new StairsBlock(SULFUR_QUARTZ_BLOCK.getDefaultState(), AbstractBlock.Settings.copy(Blocks.QUARTZ_STAIRS).mapColor(MapColor.YELLOW)));
        SULFUR_QUARTZ_SLAB = CinderscapesRegistry.register("sulfur_quartz_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_SLAB).mapColor(MapColor.YELLOW)));
        SMOOTH_SULFUR_QUARTZ = CinderscapesRegistry.register("smooth_sulfur_quartz", new Block(AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ).mapColor(MapColor.YELLOW)));
        SMOOTH_SULFUR_QUARTZ_STAIRS = CinderscapesRegistry.register("smooth_sulfur_quartz_stairs", new StairsBlock(SMOOTH_SULFUR_QUARTZ.getDefaultState(), AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ_STAIRS).mapColor(MapColor.YELLOW)));
        SMOOTH_SULFUR_QUARTZ_SLAB = CinderscapesRegistry.register("smooth_sulfur_quartz_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ_SLAB).mapColor(MapColor.YELLOW)));
        SULFUR_QUARTZ_BRICKS = CinderscapesRegistry.register("sulfur_quartz_bricks", new Block(AbstractBlock.Settings.copy(Blocks.QUARTZ_BRICKS).mapColor(MapColor.YELLOW)));

        CRYSTALLINE_SULFUR_QUARTZ = CinderscapesRegistry.register("crystalline_sulfur_quartz", new CinderscapesTransparentBlock(AbstractBlock.Settings.copy(CRYSTALLINE_QUARTZ).mapColor(MapColor.YELLOW)));
        POLYPITE_SULFUR_QUARTZ = CinderscapesRegistry.register("polypite_sulfur_quartz", new PolypiteQuartzBlock(AbstractBlock.Settings.copy(CRYSTALLINE_SULFUR_QUARTZ)));
        POTTED_POLYPITE_SULFUR_QUARTZ = CinderscapesRegistry.register("potted_polypite_sulfur_quartz", new FlowerPotBlock(POLYPITE_SULFUR_QUARTZ, AbstractBlock.Settings.copy(Blocks.FLOWER_POT)));

        // Rose Quartz

        ROSE_QUARTZ_ORE = CinderscapesRegistry.register("rose_quartz_ore", new CinderscapesOreBlock(AbstractBlock.Settings.copy(Blocks.NETHER_QUARTZ_ORE).mapColor(MapColor.PINK).sounds(BlockSoundGroup.NETHER_ORE).requiresTool()));
        ROSE_QUARTZ_BLOCK = CinderscapesRegistry.register("rose_quartz_block", new Block(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.PINK)));
        CHISELED_ROSE_QUARTZ_BLOCK = CinderscapesRegistry.register("chiseled_rose_quartz_block", new Block(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.PINK)));
        ROSE_QUARTZ_PILLAR = CinderscapesRegistry.register("rose_quartz_pillar", new PillarBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_PILLAR).mapColor(MapColor.PINK)));
        ROSE_QUARTZ_STAIRS = CinderscapesRegistry.register("rose_quartz_stairs", new StairsBlock(ROSE_QUARTZ_BLOCK.getDefaultState(), AbstractBlock.Settings.copy(Blocks.QUARTZ_STAIRS).mapColor(MapColor.PINK)));
        ROSE_QUARTZ_SLAB = CinderscapesRegistry.register("rose_quartz_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_SLAB).mapColor(MapColor.PINK)));
        SMOOTH_ROSE_QUARTZ = CinderscapesRegistry.register("smooth_rose_quartz", new Block(AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ).mapColor(MapColor.PINK)));
        SMOOTH_ROSE_QUARTZ_STAIRS = CinderscapesRegistry.register("smooth_rose_quartz_stairs", new StairsBlock(SMOOTH_ROSE_QUARTZ.getDefaultState(), AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ_STAIRS).mapColor(MapColor.PINK)));
        SMOOTH_ROSE_QUARTZ_SLAB = CinderscapesRegistry.register("smooth_rose_quartz_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ_SLAB).mapColor(MapColor.PINK)));
        ROSE_QUARTZ_BRICKS = CinderscapesRegistry.register("rose_quartz_bricks", new Block(AbstractBlock.Settings.copy(Blocks.QUARTZ_BRICKS).mapColor(MapColor.PINK)));

        CRYSTALLINE_ROSE_QUARTZ = CinderscapesRegistry.register("crystalline_rose_quartz", new CinderscapesTransparentBlock(AbstractBlock.Settings.copy(CRYSTALLINE_QUARTZ).mapColor(MapColor.PINK)));
        POLYPITE_ROSE_QUARTZ = CinderscapesRegistry.register("polypite_rose_quartz", new PolypiteQuartzBlock(AbstractBlock.Settings.copy(CRYSTALLINE_ROSE_QUARTZ)));
        POTTED_POLYPITE_ROSE_QUARTZ = CinderscapesRegistry.register("potted_polypite_rose_quartz", new FlowerPotBlock(POLYPITE_ROSE_QUARTZ, AbstractBlock.Settings.copy(Blocks.FLOWER_POT)));

        // Smoky Quartz

        SMOKY_QUARTZ_ORE = CinderscapesRegistry.register("smoky_quartz_ore", new CinderscapesOreBlock(AbstractBlock.Settings.copy(Blocks.NETHER_QUARTZ_ORE).mapColor(MapColor.GRAY).sounds(BlockSoundGroup.NETHER_ORE).requiresTool()));
        SMOKY_QUARTZ_BLOCK = CinderscapesRegistry.register("smoky_quartz_block", new Block(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.GRAY)));
        CHISELED_SMOKY_QUARTZ_BLOCK = CinderscapesRegistry.register("chiseled_smoky_quartz_block", new Block(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.GRAY)));
        SMOKY_QUARTZ_PILLAR = CinderscapesRegistry.register("smoky_quartz_pillar", new PillarBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_PILLAR).mapColor(MapColor.GRAY)));
        SMOKY_QUARTZ_STAIRS = CinderscapesRegistry.register("smoky_quartz_stairs", new StairsBlock(SMOKY_QUARTZ_BLOCK.getDefaultState(), AbstractBlock.Settings.copy(Blocks.QUARTZ_STAIRS).mapColor(MapColor.GRAY)));
        SMOKY_QUARTZ_SLAB = CinderscapesRegistry.register("smoky_quartz_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_SLAB).mapColor(MapColor.GRAY)));
        SMOOTH_SMOKY_QUARTZ = CinderscapesRegistry.register("smooth_smoky_quartz", new Block(AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ).mapColor(MapColor.GRAY)));
        SMOOTH_SMOKY_QUARTZ_STAIRS = CinderscapesRegistry.register("smooth_smoky_quartz_stairs", new StairsBlock(SMOOTH_SMOKY_QUARTZ.getDefaultState(), AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ_STAIRS).mapColor(MapColor.GRAY)));
        SMOOTH_SMOKY_QUARTZ_SLAB = CinderscapesRegistry.register("smooth_smoky_quartz_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ_SLAB).mapColor(MapColor.GRAY)));
        SMOKY_QUARTZ_BRICKS = CinderscapesRegistry.register("smoky_quartz_bricks", new Block(AbstractBlock.Settings.copy(Blocks.QUARTZ_BRICKS).mapColor(MapColor.GRAY)));

        CRYSTALLINE_SMOKY_QUARTZ = CinderscapesRegistry.register("crystalline_smoky_quartz", new CinderscapesTransparentBlock(AbstractBlock.Settings.copy(CRYSTALLINE_QUARTZ).mapColor(MapColor.GRAY)));
        POLYPITE_SMOKY_QUARTZ = CinderscapesRegistry.register("polypite_smoky_quartz", new PolypiteQuartzBlock(AbstractBlock.Settings.copy(CRYSTALLINE_SMOKY_QUARTZ)));
        POTTED_POLYPITE_SMOKY_QUARTZ = CinderscapesRegistry.register("potted_polypite_smoky_quartz", new FlowerPotBlock(POLYPITE_SMOKY_QUARTZ, AbstractBlock.Settings.copy(Blocks.FLOWER_POT)));

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
