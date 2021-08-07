package com.terraformersmc.cinderscapes.biomes.luminousgrove;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.block.NetherPlantBlock;
import com.terraformersmc.cinderscapes.block.NetherTallPlantBlock;
import com.terraformersmc.cinderscapes.biomes.luminousgrove.block.CinderscapesCanopiedFungusBlock;
import com.terraformersmc.cinderscapes.biomes.luminousgrove.block.GhastlyEctoplasmBlock;
import com.terraformersmc.cinderscapes.biomes.luminousgrove.block.PhotofernBlock;
import com.terraformersmc.cinderscapes.biomes.luminousgrove.feature.CanopiedHugeFungusFeature;
import com.terraformersmc.cinderscapes.biomes.luminousgrove.feature.config.CanopiedHugeFungusFeatureConfig;
import com.terraformersmc.terraform.dirt.block.TerraformNyliumBlock;
import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import com.terraformersmc.terraform.wood.block.*;
import com.terraformersmc.terraform.TransparentBlock;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class LuminousGroveBlocks {

    ///////////////////
    // Umbral Nylium //
    ///////////////////

    public static final Block STRIPPED_UMBRAL_STEM = Cinderscapes.REGISTRATION_HELPER.register(new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_WARPED_STEM).mapColor(MapColor.LIGHT_BLUE_GRAY).breakByTool(FabricToolTags.AXES)), "stripped_umbral_stem", new FabricItemSettings());
    public static final Block UMBRAL_STEM = Cinderscapes.REGISTRATION_HELPER.register(new StrippableLogBlock(() -> STRIPPED_UMBRAL_STEM, MapColor.CLEAR, FabricBlockSettings.copyOf(Blocks.WARPED_STEM).mapColor(MapColor.LIGHT_BLUE_GRAY).breakByTool(FabricToolTags.AXES)), "umbral_stem", new FabricItemSettings());

    public static final Block STRIPPED_UMBRAL_HYPHAE = Cinderscapes.REGISTRATION_HELPER.register(new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_WARPED_HYPHAE).mapColor(MapColor.LIGHT_BLUE_GRAY).breakByTool(FabricToolTags.AXES)), "stripped_umbral_hyphae", new FabricItemSettings());
    public static final Block UMBRAL_HYPHAE = Cinderscapes.REGISTRATION_HELPER.register(new StrippableLogBlock(() -> STRIPPED_UMBRAL_HYPHAE, MapColor.CLEAR, FabricBlockSettings.copyOf(Blocks.WARPED_HYPHAE).mapColor(MapColor.LIGHT_BLUE_GRAY).breakByTool(FabricToolTags.AXES)), "umbral_hyphae", new FabricItemSettings());

    public static final Block UMBRAL_NYLIUM = Cinderscapes.REGISTRATION_HELPER.register(new TerraformNyliumBlock(FabricBlockSettings.copyOf(Blocks.WARPED_NYLIUM).mapColor(MapColor.LIGHT_BLUE_GRAY).breakByTool(FabricToolTags.PICKAXES), null), "umbral_nylium", new FabricItemSettings());

    @SuppressWarnings("unchecked")
    public static final Block UMBRAL_FUNGUS = Cinderscapes.REGISTRATION_HELPER.register(new CinderscapesCanopiedFungusBlock(FabricBlockSettings.copyOf(Blocks.WARPED_FUNGUS).mapColor(DyeColor.BLACK), () -> (ConfiguredFeature<CanopiedHugeFungusFeatureConfig, CanopiedHugeFungusFeature>) LuminousGroveFeatures.CANOPIED_HUGE_FUNGUS.configure(LuminousGroveFeatures.UMBRAL_FUNGUS_CONFIG)), "umbral_fungus", new FabricItemSettings());
    public static final Block POTTED_UMBRAL_FUNGUS = Cinderscapes.REGISTRATION_HELPER.register(new FlowerPotBlock(UMBRAL_FUNGUS, FabricBlockSettings.copyOf(Blocks.POTTED_WARPED_FUNGUS)), "potted_umbral_fungus");

    public static final Block UMBRAL_WART_BLOCK = Cinderscapes.REGISTRATION_HELPER.register(new TransparentBlock(FabricBlockSettings.copyOf(Blocks.WARPED_WART_BLOCK).mapColor(MapColor.LIGHT_BLUE_GRAY).breakByTool(FabricToolTags.HOES).nonOpaque()), "umbral_wart_block", new FabricItemSettings());
    public static final Block UMBRAL_FLESH_BLOCK = Cinderscapes.REGISTRATION_HELPER.register(new TransparentBlock(FabricBlockSettings.copyOf(Blocks.WARPED_WART_BLOCK).mapColor(MapColor.LIGHT_BLUE_GRAY).breakByTool(FabricToolTags.HOES).nonOpaque().strength(0.6f)), "umbral_flesh_block", new FabricItemSettings());

    public static final Block UMBRAL_PLANKS = Cinderscapes.REGISTRATION_HELPER.register(new Block(FabricBlockSettings.copyOf(Blocks.WARPED_PLANKS).mapColor(MapColor.LIGHT_BLUE_GRAY)), "umbral_planks", new FabricItemSettings());
    public static final Block UMBRAL_SLAB = Cinderscapes.REGISTRATION_HELPER.register(new SlabBlock(FabricBlockSettings.copyOf(Blocks.WARPED_SLAB).mapColor(MapColor.LIGHT_BLUE_GRAY)), "umbral_slab", new FabricItemSettings());
    public static final Block UMBRAL_PRESSURE_PLATE = Cinderscapes.REGISTRATION_HELPER.register(new TerraformPressurePlateBlock(FabricBlockSettings.copyOf(Blocks.WARPED_PRESSURE_PLATE).mapColor(MapColor.LIGHT_BLUE_GRAY)), "umbral_pressure_plate", new FabricItemSettings());
    public static final Block UMBRAL_FENCE = Cinderscapes.REGISTRATION_HELPER.register(new FenceBlock(FabricBlockSettings.copyOf(Blocks.WARPED_FENCE).mapColor(MapColor.LIGHT_BLUE_GRAY)), "umbral_fence", new FabricItemSettings());
    public static final Block UMBRAL_TRAPDOOR = Cinderscapes.REGISTRATION_HELPER.register(new TerraformTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.WARPED_TRAPDOOR).mapColor(MapColor.LIGHT_BLUE_GRAY)), "umbral_trapdoor", new FabricItemSettings());
    public static final Block UMBRAL_FENCE_GATE = Cinderscapes.REGISTRATION_HELPER.register(new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.WARPED_FENCE_GATE).mapColor(MapColor.LIGHT_BLUE_GRAY)), "umbral_fence_gate", new FabricItemSettings());
    public static final Block UMBRAL_STAIRS = Cinderscapes.REGISTRATION_HELPER.register(new TerraformStairsBlock(UMBRAL_PLANKS, FabricBlockSettings.copyOf(Blocks.WARPED_STAIRS).mapColor(MapColor.LIGHT_BLUE_GRAY)), "umbral_stairs", new FabricItemSettings());
    public static final Block UMBRAL_BUTTON = Cinderscapes.REGISTRATION_HELPER.register(new TerraformButtonBlock(FabricBlockSettings.copyOf(Blocks.WARPED_BUTTON).mapColor(MapColor.LIGHT_BLUE_GRAY)), "umbral_button", new FabricItemSettings());
    public static final Block UMBRAL_DOOR = Cinderscapes.REGISTRATION_HELPER.register(new TerraformDoorBlock(FabricBlockSettings.copyOf(Blocks.WARPED_DOOR).mapColor(MapColor.LIGHT_BLUE_GRAY)), "umbral_door", new FabricItemSettings());
    public static final Block UMBRAL_SIGN = Cinderscapes.REGISTRATION_HELPER.register(new TerraformSignBlock(Cinderscapes.id("entity/signs/umbral"), FabricBlockSettings.copyOf(Blocks.WARPED_SIGN).mapColor(MapColor.LIGHT_BLUE_GRAY)), "umbral_sign");
    public static final Block UMBRAL_WALL_SIGN = Cinderscapes.REGISTRATION_HELPER.register(new TerraformWallSignBlock(Cinderscapes.id("entity/signs/umbral"), FabricBlockSettings.copyOf(Blocks.WARPED_WALL_SIGN).mapColor(MapColor.LIGHT_BLUE_GRAY)), "umbral_wall_sign");

    // Lucid Nylium (Light green)
    // Vivant Nylium (magenta)

    ////////////////
    // Vegetation //
    ////////////////

    public static final Block TWILIGHT_VINES_BLOCK = Cinderscapes.REGISTRATION_HELPER.register(new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC).strength(1.0f).sounds(BlockSoundGroup.NETHER_STEM).breakByTool(FabricToolTags.AXES)), "twilight_vine_block", new FabricItemSettings());
    public static final Block TWILIGHT_TENDRILS = Cinderscapes.REGISTRATION_HELPER.register(new NetherPlantBlock(FabricBlockSettings.copyOf(Blocks.WARPED_ROOTS).luminance(15), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0)), "twilight_tendrils", new FabricItemSettings());
    public static final Block POTTED_TWILIGHT_TENDRILS = Cinderscapes.REGISTRATION_HELPER.register(new FlowerPotBlock(TWILIGHT_TENDRILS, FabricBlockSettings.copyOf(Blocks.POTTED_WARPED_ROOTS).luminance(15)), "potted_twilight_tendrils");
    public static final Block TWILIGHT_FESCUES = Cinderscapes.REGISTRATION_HELPER.register(new NetherPlantBlock(FabricBlockSettings.copyOf(Blocks.WARPED_ROOTS), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 5.0, 14.0)), "twilight_fescues", new FabricItemSettings());
    public static final Block PHOTOFERN = Cinderscapes.REGISTRATION_HELPER.register(new PhotofernBlock(), "photofern", new FabricItemSettings());
    public static final Block POTTED_PHOTOFERN = Cinderscapes.REGISTRATION_HELPER.register(new FlowerPotBlock(PHOTOFERN, FabricBlockSettings.copyOf(Blocks.POTTED_FERN)), "potted_photofern");
    public static final Block TALL_PHOTOFERN = Cinderscapes.REGISTRATION_HELPER.register(new NetherTallPlantBlock(FabricBlockSettings.copyOf(Blocks.WARPED_ROOTS), (state) -> Block.createCuboidShape(2.0, 0, 2.0, 14.0, 16.0, 14.0)), "tall_photofern", new FabricItemSettings());
    public static final Block LUMINOUS_POD = Cinderscapes.REGISTRATION_HELPER.register(new NetherTallPlantBlock(FabricBlockSettings.copyOf(Blocks.WARPED_ROOTS).luminance(15), (state) -> Block.createCuboidShape(2.0, 0, 2.0, 14.0, 16.0, 14.0)), "luminous_pod", new FabricItemSettings());
    public static final Block POTTED_LUMINOUS_POD = Cinderscapes.REGISTRATION_HELPER.register(new FlowerPotBlock(LUMINOUS_POD, FabricBlockSettings.copyOf(Blocks.POTTED_WARPED_ROOTS).luminance(15)), "potted_luminous_pod");
    public static final Block GHASTLY_ECTOPLASM = Cinderscapes.REGISTRATION_HELPER.register(new GhastlyEctoplasmBlock(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).noCollision().breakInstantly().sounds(BlockSoundGroup.ROOTS)), "ghastly_ectoplasm", new FabricItemSettings());

    public static void onInitializeCommon() { }

    public static void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(),
                UMBRAL_WART_BLOCK,
                UMBRAL_FLESH_BLOCK
        );
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                UMBRAL_FUNGUS,
                POTTED_UMBRAL_FUNGUS,
                UMBRAL_TRAPDOOR,
                UMBRAL_DOOR,
                TWILIGHT_TENDRILS,
                POTTED_TWILIGHT_TENDRILS,
                TWILIGHT_FESCUES,
                PHOTOFERN,
                POTTED_PHOTOFERN,
                TALL_PHOTOFERN,
                LUMINOUS_POD,
                POTTED_LUMINOUS_POD,
                GHASTLY_ECTOPLASM
        );

        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ((TerraformSignBlock) LuminousGroveBlocks.UMBRAL_SIGN).getTexture()));
    }
}
