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
import com.terraformersmc.terraform.sign.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import com.terraformersmc.terraform.wood.block.PillarLogHelper;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import java.util.LinkedHashMap;
import java.util.Map;

public class CinderscapesBlocks {
    // Acts as a kind of local registry for blocks added by Cinderscapes
    private static final Map<Identifier, Block> BLOCKS = new LinkedHashMap<>();

    /////////////////
    // Ashy Shoals //
    /////////////////

    public static final Block SCORCHED_STEM = withItem("scorched_stem", PillarLogHelper.ofNether(MapColor.GRAY, MapColor.TERRACOTTA_GRAY));
    public static final Block STRIPPED_SCORCHED_STEM = withItem("stripped_scorched_stem", PillarLogHelper.ofNether(MapColor.GRAY));

    public static final Block SCORCHED_HYPHAE = withItem("scorched_hyphae", PillarLogHelper.ofNether(MapColor.TERRACOTTA_GRAY));
    public static final Block STRIPPED_SCORCHED_HYPHAE = withItem("stripped_scorched_hyphae", PillarLogHelper.ofNether(MapColor.GRAY));

    public static final Block SCORCHED_PLANKS = withItem("scorched_planks", new Block(FabricBlockSettings.copyOf(Blocks.CRIMSON_PLANKS).mapColor(MapColor.LIGHT_GRAY)));
    public static final Block SCORCHED_SLAB = withItem("scorched_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_SLAB).mapColor(MapColor.LIGHT_GRAY)));

    public static final Block SCORCHED_PRESSURE_PLATE = withItem("scorched_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.CRIMSON_PRESSURE_PLATE).mapColor(MapColor.LIGHT_GRAY), BlockSetType.CRIMSON));
    public static final Block SCORCHED_FENCE = withItem("scorched_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_FENCE).mapColor(MapColor.LIGHT_GRAY)));
    public static final Block SCORCHED_TRAPDOOR = withItem("scorched_trapdoor", new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_TRAPDOOR).mapColor(MapColor.LIGHT_GRAY), BlockSetType.CRIMSON));
    public static final Block SCORCHED_FENCE_GATE = withItem("scorched_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_FENCE_GATE).mapColor(MapColor.LIGHT_GRAY), WoodType.CRIMSON));
    public static final Block SCORCHED_STAIRS = withItem("scorched_stairs", new StairsBlock(SCORCHED_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.CRIMSON_STAIRS).mapColor(MapColor.LIGHT_GRAY)));
    public static final Block SCORCHED_BUTTON = withItem("scorched_button", new ButtonBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_BUTTON).mapColor(MapColor.LIGHT_GRAY), BlockSetType.CRIMSON, 30, true));
    public static final Block SCORCHED_DOOR = withItem("scorched_door", new DoorBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_DOOR).mapColor(MapColor.LIGHT_GRAY), BlockSetType.CRIMSON));

    private static final Identifier SCORCHED_SIGN_TEXTURE = Identifier.of(Cinderscapes.NAMESPACE, "entity/signs/scorched");
    public static final TerraformSignBlock SCORCHED_SIGN = add("scorched_sign", new TerraformSignBlock(SCORCHED_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.CRIMSON_SIGN).mapColor(MapColor.LIGHT_GRAY)));
    public static final TerraformWallSignBlock SCORCHED_WALL_SIGN = add("scorched_wall_sign", new TerraformWallSignBlock(SCORCHED_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.CRIMSON_WALL_SIGN).mapColor(MapColor.LIGHT_GRAY)));
    public static final SignItem SCORCHED_SIGN_ITEM = CinderscapesItems.add("scorched_sign", new SignItem(new Item.Settings().maxCount(16), SCORCHED_SIGN, SCORCHED_WALL_SIGN));
    private static final Identifier SCORCHED_HANGING_SIGN_TEXTURE = Identifier.of(Cinderscapes.NAMESPACE, "entity/signs/hanging/scorched");
    private static final Identifier SCORCHED_HANGING_SIGN_GUI_TEXTURE = new Identifier(Cinderscapes.NAMESPACE, "textures/gui/hanging_signs/scorched");
    public static final TerraformHangingSignBlock SCORCHED_HANGING_SIGN = add("scorched_hanging_sign", new TerraformHangingSignBlock(SCORCHED_HANGING_SIGN_TEXTURE, SCORCHED_HANGING_SIGN_GUI_TEXTURE, FabricBlockSettings.copyOf(Blocks.CRIMSON_HANGING_SIGN).mapColor(MapColor.LIGHT_GRAY).requires(FeatureFlags.UPDATE_1_20)));
    public static final TerraformWallHangingSignBlock SCORCHED_WALL_HANGING_SIGN = add("scorched_wall_hanging_sign", new TerraformWallHangingSignBlock(SCORCHED_HANGING_SIGN_TEXTURE, SCORCHED_HANGING_SIGN_GUI_TEXTURE, FabricBlockSettings.copyOf(Blocks.CRIMSON_WALL_HANGING_SIGN).mapColor(MapColor.LIGHT_GRAY).requires(FeatureFlags.UPDATE_1_20)));
    public static final HangingSignItem SCORCHED_HANGING_SIGN_ITEM = CinderscapesItems.add("scorched_hanging_sign", new HangingSignItem(SCORCHED_HANGING_SIGN, SCORCHED_WALL_HANGING_SIGN, new Item.Settings().maxCount(16)));

    public static final Block SCORCHED_SHRUB = withItem("scorched_shrub", new CinderscapesNetherPlantBlock(FabricBlockSettings.copyOf(Blocks.DEAD_BUSH), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 14.0, 14.0)));
    public static final Block POTTED_SCORCHED_SHRUB = add("potted_scorched_shrub", new FlowerPotBlock(SCORCHED_SHRUB, FabricBlockSettings.copyOf(Blocks.POTTED_DEAD_BUSH)));

    public static final Block SCORCHED_SPROUTS = withItem("scorched_sprouts", new CinderscapesNetherPlantBlock(FabricBlockSettings.copyOf(Blocks.NETHER_SPROUTS), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)));
    public static final Block SCORCHED_TENDRILS = withItem("scorched_tendrils", new CinderscapesNetherPlantBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_ROOTS), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0)));
    public static final Block POTTED_SCORCHED_TENDRILS = add("potted_scorched_tendrils", new FlowerPotBlock(SCORCHED_TENDRILS, FabricBlockSettings.copyOf(Blocks.POTTED_CRIMSON_ROOTS)));

    public static final Block ASH = withItem("ash", new AshLayerBlock(FabricBlockSettings.copyOf(Blocks.SNOW)));
    public static final Block ASH_BLOCK = withItem("ash_block", new Block(FabricBlockSettings.copyOf(Blocks.SNOW_BLOCK)));

    public static final Block PYRACINTH = withItem("pyracinth", new PyracinthBlock());
    public static final Block POTTED_PYRACINTH = add("potted_pyracinth", new PottedPyracinthBlock());

    ////////////////////
    // Luminous Grove //
    ////////////////////

    // Umbral Nylia

    public static final Block UMBRAL_STEM = withItem("umbral_stem", PillarLogHelper.ofNether(MapColor.LIGHT_BLUE_GRAY, MapColor.BLUE));
    public static final Block STRIPPED_UMBRAL_STEM = withItem("stripped_umbral_stem", PillarLogHelper.ofNether(MapColor.LIGHT_BLUE_GRAY));

    public static final Block UMBRAL_HYPHAE = withItem("umbral_hyphae", PillarLogHelper.ofNether(MapColor.BLUE));
    public static final Block STRIPPED_UMBRAL_HYPHAE = withItem("stripped_umbral_hyphae", PillarLogHelper.ofNether(MapColor.LIGHT_BLUE_GRAY));

    public static final Block UMBRAL_NYLIUM = withItem("umbral_nylium", new CinderscapesNyliumBlock(FabricBlockSettings.copyOf(Blocks.WARPED_NYLIUM).mapColor(MapColor.LIGHT_BLUE_GRAY)));

    public static final Block UMBRAL_FUNGUS = withItem("umbral_fungus", new FungusBlock(FabricBlockSettings.copyOf(Blocks.WARPED_FUNGUS).mapColor(MapColor.BLUE).luminance(15), CinderscapesConfiguredFeatures.CANOPIED_HUGE_FUNGUS_PLANTED, UMBRAL_NYLIUM));
    public static final Block POTTED_UMBRAL_FUNGUS = add("potted_umbral_fungus", new FlowerPotBlock(UMBRAL_FUNGUS, FabricBlockSettings.copyOf(Blocks.POTTED_WARPED_FUNGUS)));

    public static final Block UMBRAL_WART_BLOCK = withItem("umbral_wart_block", new CinderscapesTransparentBlock(FabricBlockSettings.copyOf(Blocks.WARPED_WART_BLOCK).mapColor(MapColor.BLUE).nonOpaque()));
    public static final Block UMBRAL_FLESH_BLOCK = withItem("umbral_flesh_block", new CinderscapesTransparentBlock(FabricBlockSettings.copyOf(UMBRAL_WART_BLOCK).luminance(15)));

    public static final Block UMBRAL_PLANKS = withItem("umbral_planks", new Block(FabricBlockSettings.copyOf(Blocks.WARPED_PLANKS).mapColor(MapColor.BLUE)));
    public static final Block UMBRAL_SLAB = withItem("umbral_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.WARPED_SLAB).mapColor(MapColor.BLUE)));
    public static final Block UMBRAL_PRESSURE_PLATE = withItem("umbral_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.WARPED_PRESSURE_PLATE).mapColor(MapColor.BLUE), BlockSetType.WARPED));
    public static final Block UMBRAL_FENCE = withItem("umbral_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.WARPED_FENCE).mapColor(MapColor.BLUE)));
    public static final Block UMBRAL_TRAPDOOR = withItem("umbral_trapdoor", new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.WARPED_TRAPDOOR).mapColor(MapColor.BLUE), BlockSetType.WARPED));
    public static final Block UMBRAL_FENCE_GATE = withItem("umbral_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.WARPED_FENCE_GATE).mapColor(MapColor.BLUE), WoodType.WARPED));
    public static final Block UMBRAL_STAIRS = withItem("umbral_stairs", new StairsBlock(UMBRAL_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.WARPED_STAIRS).mapColor(MapColor.BLUE)));
    public static final Block UMBRAL_BUTTON = withItem("umbral_button", new ButtonBlock(FabricBlockSettings.copyOf(Blocks.WARPED_BUTTON).mapColor(MapColor.BLUE), BlockSetType.WARPED, 30, true));
    public static final Block UMBRAL_DOOR = withItem("umbral_door", new DoorBlock(FabricBlockSettings.copyOf(Blocks.WARPED_DOOR).mapColor(MapColor.BLUE), BlockSetType.WARPED));

    private static final Identifier UMBRAL_SIGN_TEXTURE = Identifier.of(Cinderscapes.NAMESPACE, "entity/signs/umbral");
    public static final TerraformSignBlock UMBRAL_SIGN = add("umbral_sign", new TerraformSignBlock(UMBRAL_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.WARPED_SIGN).mapColor(MapColor.BLUE)));
    public static final TerraformWallSignBlock UMBRAL_WALL_SIGN = add("umbral_wall_sign", new TerraformWallSignBlock(UMBRAL_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.WARPED_WALL_SIGN).mapColor(MapColor.BLUE)));
    public static final SignItem UMBRAL_SIGN_ITEM = CinderscapesItems.add("umbral_sign", new SignItem(new Item.Settings().maxCount(16), UMBRAL_SIGN, UMBRAL_WALL_SIGN));
    private static final Identifier UMBRAL_HANGING_SIGN_TEXTURE = Identifier.of(Cinderscapes.NAMESPACE, "entity/signs/hanging/umbral");
    private static final Identifier UMBRAL_HANGING_SIGN_GUI_TEXTURE = new Identifier(Cinderscapes.NAMESPACE, "textures/gui/hanging_signs/umbral");
    public static final TerraformHangingSignBlock UMBRAL_HANGING_SIGN = add("umbral_hanging_sign", new TerraformHangingSignBlock(UMBRAL_HANGING_SIGN_TEXTURE, UMBRAL_HANGING_SIGN_GUI_TEXTURE, FabricBlockSettings.copyOf(Blocks.WARPED_HANGING_SIGN).mapColor(MapColor.BLUE).requires(FeatureFlags.UPDATE_1_20)));
    public static final TerraformWallHangingSignBlock UMBRAL_WALL_HANGING_SIGN = add("umbral_wall_hanging_sign", new TerraformWallHangingSignBlock(UMBRAL_HANGING_SIGN_TEXTURE, UMBRAL_HANGING_SIGN_GUI_TEXTURE, FabricBlockSettings.copyOf(Blocks.WARPED_WALL_HANGING_SIGN).mapColor(MapColor.BLUE).requires(FeatureFlags.UPDATE_1_20)));
    public static final HangingSignItem UMBRAL_HANGING_SIGN_ITEM = CinderscapesItems.add("umbral_hanging_sign", new HangingSignItem(UMBRAL_HANGING_SIGN, UMBRAL_WALL_HANGING_SIGN, new Item.Settings().maxCount(16)));

    // Other

    public static final Block TWILIGHT_VINE_BLOCK = withItem("twilight_vine_block", new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC).strength(1.0F).sounds(BlockSoundGroup.NETHER_STEM)));
    public static final Block TWILIGHT_TENDRILS = withItem("twilight_tendrils", new CinderscapesNetherPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS).luminance((state) -> 15), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0)));
    public static final Block POTTED_TWILIGHT_TENDRILS = add("potted_twilight_tendrils", new FlowerPotBlock(TWILIGHT_TENDRILS, FabricBlockSettings.copyOf(Blocks.POTTED_WARPED_ROOTS).luminance((state) -> 15)));
    public static final Block TWILIGHT_FESCUES = withItem("twilight_fescues", new CinderscapesNetherPlantBlock(FabricBlockSettings.copy(Blocks.NETHER_SPROUTS), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 5.0, 14.0)));

    public static Block PHOTOFERN = withItem("photofern", new PhotofernBlock());
    public static final Block POTTED_PHOTOFERN = add("potted_photofern", new FlowerPotBlock(PHOTOFERN, FabricBlockSettings.copyOf(Blocks.POTTED_FERN)));

    public static final Block TALL_PHOTOFERN = withItem("tall_photofern", new CinderscapesNetherTallPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS), (state) -> Block.createCuboidShape(2.0, 0, 2.0, 14.0, 16.0, 14.0)));

    public static final Block LUMINOUS_POD = withItem("luminous_pod", new CinderscapesNetherTallPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS).luminance((state) -> 15), (state) -> Block.createCuboidShape(2.0, 0, 2.0, 14.0, 16.0, 14.0)));
    public static final Block POTTED_LUMINOUS_POD = add("potted_luminous_pod", new FlowerPotBlock(LUMINOUS_POD, FabricBlockSettings.copyOf(Blocks.POTTED_WARPED_ROOTS).luminance((state) -> 15)));
    public static final Block GHASTLY_ECTOPLASM = withItem("ghastly_ectoplasm", new GhastlyEctoplasmBlock(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).noCollision().breakInstantly().sounds(BlockSoundGroup.ROOTS)));

    ///////////
    // Other //
    ///////////

    public static final Block SULFUR_BLOCK = withItem("sulfur_block", new Block(FabricBlockSettings.of(Material.AGGREGATE).strength(0.5F, 0.5f)));
    public static final Block SULFUR_ORE = addOre("sulfur_ore", 2, MapColor.YELLOW);

    public static final Block BRAMBLE_BERRY_BUSH = add("bramble_berry_bush", new BrambleBerryBushBlock(FabricBlockSettings.copyOf(Blocks.SWEET_BERRY_BUSH)));
    public static final BlockItem BRAMBLE_BERRIES = CinderscapesItems.add("bramble_berries", new AliasedBlockItem(CinderscapesBlocks.BRAMBLE_BERRY_BUSH, new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.1F).alwaysEdible().snack().statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 600, 0), 0.8F).build())));

    ///////////////////
    // Quartz Cavern //
    ///////////////////

    public static final Block CRYSTINIUM = withItem("crystinium", new CrystiniumBlock());
    public static final Block POTTED_CRYSTINIUM = add("potted_crystinium", new PottedCrystiniumBlock());

    public static final Block CRYSTALLINE_QUARTZ = withItem("crystalline_quartz", new CinderscapesTransparentBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).sounds(BlockSoundGroup.GLASS).nonOpaque().allowsSpawning(CinderscapesBlocks::never).solidBlock(CinderscapesBlocks::never).suffocates(CinderscapesBlocks::never).blockVision(CinderscapesBlocks::never)));
    public static final Block POLYPITE_QUARTZ = withItem("polypite_quartz", new PolypiteQuartzBlock(FabricBlockSettings.copyOf(CRYSTALLINE_QUARTZ)));
    public static final Block POTTED_POLYPITE_QUARTZ = add("potted_polypite_quartz", new FlowerPotBlock(POLYPITE_QUARTZ, FabricBlockSettings.copyOf(Blocks.FLOWER_POT)));

    // Sulfur Quartz

    public static final Block POLYPITE_SULFUR_QUARTZ = withItem("polypite_sulfur_quartz", new PolypiteQuartzBlock(FabricBlockSettings.copyOf(POLYPITE_QUARTZ).mapColor(MapColor.YELLOW)));
    public static final Block POTTED_POLYPITE_SULFUR_QUARTZ = add("potted_polypite_sulfur_quartz", new FlowerPotBlock(POLYPITE_SULFUR_QUARTZ, FabricBlockSettings.copyOf(Blocks.FLOWER_POT)));

    public static final Block SULFUR_QUARTZ_ORE = addOre("sulfur_quartz_ore", 1, MapColor.YELLOW);
    public static final Block SULFUR_QUARTZ_BLOCK = withItem("sulfur_quartz_block", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).mapColor(MapColor.YELLOW)));
    public static final Block CHISELED_SULFUR_QUARTZ_BLOCK = withItem("chiseled_sulfur_quartz_block", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).mapColor(MapColor.YELLOW)));
    public static final Block SULFUR_QUARTZ_PILLAR = withItem("sulfur_quartz_pillar", new PillarBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_PILLAR).mapColor(MapColor.YELLOW)));
    public static final Block SULFUR_QUARTZ_STAIRS = withItem("sulfur_quartz_stairs", new StairsBlock(SULFUR_QUARTZ_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.QUARTZ_STAIRS).mapColor(MapColor.YELLOW)));
    public static final Block SULFUR_QUARTZ_SLAB = withItem("sulfur_quartz_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_SLAB).mapColor(MapColor.YELLOW)));
    public static final Block SMOOTH_SULFUR_QUARTZ = withItem("smooth_sulfur_quartz", new Block(FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ).mapColor(MapColor.YELLOW)));
    public static final Block SMOOTH_SULFUR_QUARTZ_STAIRS = withItem("smooth_sulfur_quartz_stairs", new StairsBlock(SMOOTH_SULFUR_QUARTZ.getDefaultState(), FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_STAIRS).mapColor(MapColor.YELLOW)));
    public static final Block SMOOTH_SULFUR_QUARTZ_SLAB = withItem("smooth_sulfur_quartz_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_SLAB).mapColor(MapColor.YELLOW)));
    public static final Block SULFUR_QUARTZ_BRICKS = withItem("sulfur_quartz_bricks", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BRICKS).mapColor(MapColor.YELLOW)));
    public static final Block CRYSTALLINE_SULFUR_QUARTZ = withItem("crystalline_sulfur_quartz", new CinderscapesTransparentBlock(FabricBlockSettings.copyOf(CRYSTALLINE_QUARTZ).mapColor(MapColor.YELLOW)));

    // Rose Quartz

    public static final Block POLYPITE_ROSE_QUARTZ = withItem("polypite_rose_quartz", new PolypiteQuartzBlock(FabricBlockSettings.copyOf(POLYPITE_QUARTZ).mapColor(MapColor.PINK)));
    public static final Block POTTED_POLYPITE_ROSE_QUARTZ = add("potted_polypite_rose_quartz", new FlowerPotBlock(POLYPITE_ROSE_QUARTZ, FabricBlockSettings.copyOf(Blocks.FLOWER_POT)));

    public static final Block ROSE_QUARTZ_ORE = addOre("rose_quartz_ore", 1, MapColor.PINK);
    public static final Block ROSE_QUARTZ_BLOCK = withItem("rose_quartz_block", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).mapColor(MapColor.PINK)));
    public static final Block CHISELED_ROSE_QUARTZ_BLOCK = withItem("chiseled_rose_quartz_block", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).mapColor(MapColor.PINK)));
    public static final Block ROSE_QUARTZ_PILLAR = withItem("rose_quartz_pillar", new PillarBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_PILLAR).mapColor(MapColor.PINK)));
    public static final Block ROSE_QUARTZ_STAIRS = withItem("rose_quartz_stairs", new StairsBlock(ROSE_QUARTZ_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.QUARTZ_STAIRS).mapColor(MapColor.PINK)));
    public static final Block ROSE_QUARTZ_SLAB = withItem("rose_quartz_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_SLAB).mapColor(MapColor.PINK)));
    public static final Block SMOOTH_ROSE_QUARTZ = withItem("smooth_rose_quartz", new Block(FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ).mapColor(MapColor.PINK)));
    public static final Block SMOOTH_ROSE_QUARTZ_STAIRS = withItem("smooth_rose_quartz_stairs", new StairsBlock(SMOOTH_ROSE_QUARTZ.getDefaultState(), FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_STAIRS).mapColor(MapColor.PINK)));
    public static final Block SMOOTH_ROSE_QUARTZ_SLAB = withItem("smooth_rose_quartz_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_SLAB).mapColor(MapColor.PINK)));
    public static final Block ROSE_QUARTZ_BRICKS = withItem("rose_quartz_bricks", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BRICKS).mapColor(MapColor.PINK)));
    public static final Block CRYSTALLINE_ROSE_QUARTZ = withItem("crystalline_rose_quartz", new CinderscapesTransparentBlock(FabricBlockSettings.copyOf(CRYSTALLINE_QUARTZ).mapColor(MapColor.PINK)));

    // Smoky Quartz

    public static final Block POLYPITE_SMOKY_QUARTZ = withItem("polypite_smoky_quartz", new PolypiteQuartzBlock(FabricBlockSettings.copyOf(POLYPITE_QUARTZ).mapColor(MapColor.GRAY)));
    public static final Block POTTED_POLYPITE_SMOKY_QUARTZ = add("potted_polypite_smoky_quartz", new FlowerPotBlock(POLYPITE_SMOKY_QUARTZ, FabricBlockSettings.copyOf(Blocks.FLOWER_POT)));

    public static final Block SMOKY_QUARTZ_ORE = addOre("smoky_quartz_ore", 1, MapColor.GRAY);
    public static final Block SMOKY_QUARTZ_BLOCK = withItem("smoky_quartz_block", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).mapColor(MapColor.GRAY)));
    public static final Block CHISELED_SMOKY_QUARTZ_BLOCK = withItem("chiseled_smoky_quartz_block", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).mapColor(MapColor.GRAY)));
    public static final Block SMOKY_QUARTZ_PILLAR = withItem("smoky_quartz_pillar", new PillarBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_PILLAR).mapColor(MapColor.GRAY)));
    public static final Block SMOKY_QUARTZ_STAIRS = withItem("smoky_quartz_stairs", new StairsBlock(SMOKY_QUARTZ_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.QUARTZ_STAIRS).mapColor(MapColor.GRAY)));
    public static final Block SMOKY_QUARTZ_SLAB = withItem("smoky_quartz_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_SLAB).mapColor(MapColor.GRAY)));
    public static final Block SMOOTH_SMOKY_QUARTZ = withItem("smooth_smoky_quartz", new Block(FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ).mapColor(MapColor.GRAY)));
    public static final Block SMOOTH_SMOKY_QUARTZ_STAIRS = withItem("smooth_smoky_quartz_stairs", new StairsBlock(SMOOTH_SMOKY_QUARTZ.getDefaultState(), FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_STAIRS).mapColor(MapColor.GRAY)));
    public static final Block SMOOTH_SMOKY_QUARTZ_SLAB = withItem("smooth_smoky_quartz_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_SLAB).mapColor(MapColor.GRAY)));
    public static final Block SMOKY_QUARTZ_BRICKS = withItem("smoky_quartz_bricks", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BRICKS).mapColor(MapColor.GRAY)));
    public static final Block CRYSTALLINE_SMOKY_QUARTZ = withItem("crystalline_smoky_quartz", new CinderscapesTransparentBlock(FabricBlockSettings.copyOf(CRYSTALLINE_QUARTZ).mapColor(MapColor.GRAY)));

    public static final Block NODZOL = withItem("nodzol", new Block(FabricBlockSettings.copyOf(Blocks.NETHERRACK).mapColor(MapColor.BROWN)));

    private static Block addOre(String name, int miningLevel, MapColor color) {
        CinderscapesOreBlock block = new CinderscapesOreBlock(FabricBlockSettings.copyOf(Blocks.NETHER_QUARTZ_ORE).mapColor(color).sounds(BlockSoundGroup.NETHER_ORE).requiresTool());
        return withItem(name, block);
    }

    private static <B extends Block> B withItem(String name, B block) {
        return add(name, block, new BlockItem(block, new Item.Settings()));
    }

    private static <B extends Block> B add(String name, B block, BlockItem item) {
        add(name, block);
        if (item != null) {
            CinderscapesItems.add(name, item);
        }
        return block;
    }

    private static <B extends Block> B add(String name, B block) {
        BLOCKS.put(Identifier.of(Cinderscapes.NAMESPACE, name), block);
        return block;
    }

    public static void init() {
        for (Identifier id : BLOCKS.keySet()) {
            Registry.register(Registries.BLOCK, id, BLOCKS.get(id));
        }

        addCompostables();
        addStrippables();
    }

    private static void addCompostables() {
        CompostingChanceRegistry compostingRegistry = CompostingChanceRegistry.INSTANCE;
        float BERRY_CHANCE = compostingRegistry.get(Items.SWEET_BERRIES);
        float FLOWER_CHANCE = compostingRegistry.get(Items.POPPY);
        float FUNGUS_CHANCE = compostingRegistry.get(Items.CRIMSON_FUNGUS);
        float GRASS_CHANCE = compostingRegistry.get(Items.GRASS);
        float WART_BLOCK_CHANCE = compostingRegistry.get(Items.NETHER_WART_BLOCK);

        compostingRegistry.add(BRAMBLE_BERRIES, BERRY_CHANCE);

        compostingRegistry.add(SCORCHED_SHRUB, GRASS_CHANCE);
        compostingRegistry.add(SCORCHED_SPROUTS, GRASS_CHANCE);
        compostingRegistry.add(SCORCHED_TENDRILS, GRASS_CHANCE);
        compostingRegistry.add(TWILIGHT_FESCUES, GRASS_CHANCE);
        compostingRegistry.add(TWILIGHT_TENDRILS, GRASS_CHANCE);

        compostingRegistry.add(CRYSTINIUM, FLOWER_CHANCE);
        compostingRegistry.add(GHASTLY_ECTOPLASM, FLOWER_CHANCE);
        compostingRegistry.add(LUMINOUS_POD, FLOWER_CHANCE);
        compostingRegistry.add(PHOTOFERN, FLOWER_CHANCE);
        compostingRegistry.add(PYRACINTH, FLOWER_CHANCE);
        compostingRegistry.add(TALL_PHOTOFERN, FLOWER_CHANCE);
        compostingRegistry.add(UMBRAL_FUNGUS, FUNGUS_CHANCE);

        compostingRegistry.add(TWILIGHT_VINE_BLOCK, WART_BLOCK_CHANCE);
        compostingRegistry.add(UMBRAL_FLESH_BLOCK, WART_BLOCK_CHANCE);
        compostingRegistry.add(UMBRAL_WART_BLOCK, WART_BLOCK_CHANCE);
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
