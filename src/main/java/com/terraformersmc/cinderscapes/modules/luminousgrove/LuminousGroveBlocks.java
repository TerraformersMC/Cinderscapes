package com.terraformersmc.cinderscapes.modules.luminousgrove;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.helper.RegistryHelper;
import com.terraformersmc.cinderscapes.legacy.block.*;
import com.terraformersmc.cinderscapes.legacy.init.CinderscapesFeatures;
import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import com.terraformersmc.terraform.wood.block.*;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;

public class LuminousGroveBlocks {

    public static final Block STRIPPED_UMBRAL_STEM = RegistryHelper.register("stripped_umbral_stem", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_WARPED_STEM).materialColor(MaterialColor.BLUE).breakByTool(FabricToolTags.AXES)), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_STEM = RegistryHelper.register("umbral_stem", new StrippableLogBlock(() -> STRIPPED_UMBRAL_STEM, MaterialColor.CLEAR, FabricBlockSettings.copyOf(Blocks.WARPED_STEM).materialColor(MaterialColor.BLUE).breakByTool(FabricToolTags.AXES)), ItemGroup.BUILDING_BLOCKS);

    public static final Block STRIPPED_UMBRAL_HYPHAE = RegistryHelper.register("stripped_umbral_hyphae", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_WARPED_HYPHAE).materialColor(MaterialColor.BLUE).breakByTool(FabricToolTags.AXES)), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_HYPHAE = RegistryHelper.register("umbral_hyphae", new StrippableLogBlock(() -> STRIPPED_UMBRAL_HYPHAE, MaterialColor.CLEAR, FabricBlockSettings.copyOf(Blocks.WARPED_HYPHAE).materialColor(MaterialColor.BLUE).breakByTool(FabricToolTags.AXES)), ItemGroup.BUILDING_BLOCKS);

    public static final Block UMBRAL_NYLIUM = RegistryHelper.register("umbral_nylium", new CinderscapesNyliumBlock(FabricBlockSettings.copyOf(Blocks.WARPED_NYLIUM).materialColor(MaterialColor.BLUE).breakByTool(FabricToolTags.PICKAXES)), ItemGroup.BUILDING_BLOCKS);

    public static final Block UMBRAL_FUNGUS = RegistryHelper.register("umbral_fungus", new CinderscapesCanopiedFungusBlock(FabricBlockSettings.copyOf(Blocks.WARPED_FUNGUS).materialColor(MaterialColor.BLUE).breakByTool(FabricToolTags.PICKAXES).lightLevel(15), () -> CinderscapesFeatures.CANOPIED_HUGE_FUNGUS.configure(CinderscapesFeatures.UMBRAL_FUNGUS_CONFIG)), ItemGroup.DECORATIONS);
    public static final Block POTTED_UMBRAL_FUNGUS = RegistryHelper.register("potted_umbral_fungus", new FlowerPotBlock(UMBRAL_FUNGUS, FabricBlockSettings.copyOf(Blocks.POTTED_WARPED_FUNGUS)));

    public static final Block UMBRAL_WART_BLOCK = RegistryHelper.register("umbral_wart_block", new CinderscapesTransparentBlock(FabricBlockSettings.copyOf(Blocks.WARPED_WART_BLOCK).materialColor(MaterialColor.BLUE).breakByTool(FabricToolTags.HOES).nonOpaque()), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_FLESH_BLOCK = RegistryHelper.register("umbral_flesh_block", new CinderscapesTransparentBlock(FabricBlockSettings.copyOf(UMBRAL_WART_BLOCK).breakByTool(FabricToolTags.HOES).lightLevel(15)), ItemGroup.BUILDING_BLOCKS);

    public static final Block UMBRAL_PLANKS = RegistryHelper.register("umbral_planks", new Block(FabricBlockSettings.copyOf(Blocks.WARPED_PLANKS).materialColor(MaterialColor.BLUE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_SLAB = RegistryHelper.register("umbral_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.WARPED_SLAB).materialColor(MaterialColor.BLUE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_PRESSURE_PLATE = RegistryHelper.register("umbral_pressure_plate", new TerraformPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.WARPED_PRESSURE_PLATE).materialColor(MaterialColor.BLUE)), ItemGroup.REDSTONE);
    public static final Block UMBRAL_FENCE = RegistryHelper.register("umbral_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.WARPED_FENCE).materialColor(MaterialColor.BLUE)), ItemGroup.DECORATIONS);
    public static final Block UMBRAL_TRAPDOOR = RegistryHelper.register("umbral_trapdoor", new TerraformTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.WARPED_TRAPDOOR).materialColor(MaterialColor.BLUE)), ItemGroup.REDSTONE);
    public static final Block UMBRAL_FENCE_GATE = RegistryHelper.register("umbral_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.WARPED_FENCE_GATE).materialColor(MaterialColor.BLUE)), ItemGroup.REDSTONE);
    public static final Block UMBRAL_STAIRS = RegistryHelper.register("umbral_stairs", new TerraformStairsBlock(UMBRAL_PLANKS, FabricBlockSettings.copyOf(Blocks.WARPED_STAIRS).materialColor(MaterialColor.BLUE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_BUTTON = RegistryHelper.register("umbral_button", new TerraformButtonBlock(FabricBlockSettings.copyOf(Blocks.WARPED_BUTTON).materialColor(MaterialColor.BLUE)), ItemGroup.REDSTONE);
    public static final Block UMBRAL_DOOR = RegistryHelper.register("umbral_door", new TerraformDoorBlock(FabricBlockSettings.copyOf(Blocks.WARPED_DOOR).materialColor(MaterialColor.BLUE)), ItemGroup.REDSTONE);
    public static final Block UMBRAL_SIGN = RegistryHelper.register("umbral_sign", new TerraformSignBlock(Cinderscapes.id("entity/signs/umbral"), FabricBlockSettings.copyOf(Blocks.WARPED_SIGN).materialColor(MaterialColor.BLUE)));
    public static final Block UMBRAL_WALL_SIGN = RegistryHelper.register("umbral_wall_sign", new TerraformWallSignBlock(Cinderscapes.id("entity/signs/umbral"), FabricBlockSettings.copyOf(Blocks.WARPED_WALL_SIGN).materialColor(MaterialColor.BLUE)));

    public static final Block TWILIGHT_VINE_BLOCK = RegistryHelper.register("twilight_vine_block", new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC).strength(1.0F).sounds(BlockSoundGroup.NETHER_STEM).breakByTool(FabricToolTags.AXES)), ItemGroup.DECORATIONS);
    public static final Block TWILIGHT_TENDRILS = RegistryHelper.register("twilight_tendrils", new CinderscapesNetherPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS).luminance((state) -> 15), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0)), ItemGroup.DECORATIONS);
    public static final Block POTTED_TWILIGHT_TENDRILS = RegistryHelper.register("potted_twilight_tendrils", new FlowerPotBlock(TWILIGHT_TENDRILS, FabricBlockSettings.copyOf(Blocks.POTTED_WARPED_ROOTS).luminance((state) -> 15)));
    public static final Block TWILIGHT_FESCUES = RegistryHelper.register("twilight_fescues", new CinderscapesNetherPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 5.0, 14.0)), ItemGroup.DECORATIONS);

    public static final Block PHOTOFERN = RegistryHelper.register("photofern", new PhotofernBlock(), ItemGroup.DECORATIONS);
    public static final Block POTTED_PHOTOFERN = RegistryHelper.register("potted_photofern", new FlowerPotBlock(PHOTOFERN, FabricBlockSettings.copyOf(Blocks.POTTED_FERN)));

    public static final Block TALL_PHOTOFERN = RegistryHelper.register("tall_photofern", new CinderscapesNetherTallPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS), (state) -> Block.createCuboidShape(2.0, 0, 2.0, 14.0, 16.0, 14.0)), ItemGroup.DECORATIONS);

    public static final Block LUMINOUS_POD = RegistryHelper.register("luminous_pod", new CinderscapesNetherTallPlantBlock(FabricBlockSettings.copy(Blocks.WARPED_ROOTS).luminance((state) -> 15), (state) -> Block.createCuboidShape(2.0, 0, 2.0, 14.0, 16.0, 14.0)), ItemGroup.DECORATIONS);
    public static final Block POTTED_LUMINOUS_POD = RegistryHelper.register("potted_luminous_pod", new FlowerPotBlock(LUMINOUS_POD, FabricBlockSettings.copyOf(Blocks.POTTED_WARPED_ROOTS).luminance((state) -> 15)));
    public static final Block GHASTLY_ECTOPLASM = RegistryHelper.register("ghastly_ectoplasm", new GhastlyEctoplasmBlock(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).noCollision().breakInstantly().sounds(BlockSoundGroup.ROOTS)), ItemGroup.DECORATIONS);

    public static void onInitialize() {
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(TWILIGHT_FESCUES.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(TWILIGHT_TENDRILS.asItem(), 0.3f);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(PHOTOFERN.asItem(), 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(TALL_PHOTOFERN.asItem(), 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(LUMINOUS_POD.asItem(), 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(UMBRAL_FUNGUS.asItem(), 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(GHASTLY_ECTOPLASM.asItem(), 0.65f);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(UMBRAL_WART_BLOCK.asItem(), 0.85f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(UMBRAL_FLESH_BLOCK.asItem(), 0.85f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(TWILIGHT_VINE_BLOCK.asItem(), 0.85f);
    }

    public static void onInitializeClient() {
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ((TerraformSignBlock) UMBRAL_SIGN).getTexture()));

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                PHOTOFERN,
                POTTED_PHOTOFERN,
                TALL_PHOTOFERN,
                LUMINOUS_POD,
                POTTED_LUMINOUS_POD,
                TWILIGHT_FESCUES,
                TWILIGHT_TENDRILS,
                POTTED_TWILIGHT_TENDRILS,
                UMBRAL_FUNGUS,
                POTTED_UMBRAL_FUNGUS,
                UMBRAL_DOOR);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(),
                UMBRAL_WART_BLOCK,
                GHASTLY_ECTOPLASM);
    }
}
