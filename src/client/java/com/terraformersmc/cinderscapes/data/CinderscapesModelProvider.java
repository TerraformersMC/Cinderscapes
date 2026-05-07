package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.block.GhastlyEctoplasmBlock;
import com.terraformersmc.cinderscapes.block.PolypiteQuartzBlock;
import com.terraformersmc.cinderscapes.init.*;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jspecify.annotations.NullMarked;

import java.util.List;
import java.util.Optional;

@NullMarked
public class CinderscapesModelProvider extends FabricModelProvider {
    private static final List<ItemModelGenerators.TrimMaterialData> TRIM_MATERIALS = List.of(
            new ItemModelGenerators.TrimMaterialData(CinderscapesArmorTrimAssets.ROSE_QUARTZ, CinderscapesArmorTrimMaterials.ROSE_QUARTZ),
            new ItemModelGenerators.TrimMaterialData(CinderscapesArmorTrimAssets.SMOKY_QUARTZ, CinderscapesArmorTrimMaterials.SMOKY_QUARTZ),
            new ItemModelGenerators.TrimMaterialData(CinderscapesArmorTrimAssets.SULFUR_QUARTZ, CinderscapesArmorTrimMaterials.SULFUR_QUARTZ)
    );

    public CinderscapesModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators generator) {

        /*///////////////
        // Ashy Shoals //
        ///////////////*/

        // Scorched wood set
        generator.family(CinderscapesBlockFamilies.SCORCHED.getBaseBlock()).generateFor(CinderscapesBlockFamilies.SCORCHED);
        generator.createShelf(CinderscapesBlocks.SCORCHED_SHELF, CinderscapesBlocks.STRIPPED_SCORCHED_STEM);
        generator.woodProvider(CinderscapesBlocks.SCORCHED_STEM).logWithHorizontal(CinderscapesBlocks.SCORCHED_STEM).wood(CinderscapesBlocks.SCORCHED_HYPHAE);
        generator.woodProvider(CinderscapesBlocks.STRIPPED_SCORCHED_STEM).logWithHorizontal(CinderscapesBlocks.STRIPPED_SCORCHED_STEM).wood(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE);
        generator.createHangingSign(CinderscapesBlockFamilies.SCORCHED.getBaseBlock(), CinderscapesBlocks.SCORCHED_HANGING_SIGN, CinderscapesBlocks.SCORCHED_WALL_HANGING_SIGN);
        // Item models missed by vanilla code
        this.registerBlockItemModel(generator, CinderscapesBlocks.SCORCHED_FENCE_GATE);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SCORCHED_PLANKS);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SCORCHED_PRESSURE_PLATE);

        // Misc. vegetation
        generator.createPlantWithDefaultItem(CinderscapesBlocks.SCORCHED_SHRUB, CinderscapesBlocks.POTTED_SCORCHED_SHRUB, BlockModelGenerators.PlantType.NOT_TINTED);
        generator.createCrossBlock(CinderscapesBlocks.SCORCHED_SPROUTS, BlockModelGenerators.PlantType.NOT_TINTED);
        generator.createCrossBlockWithDefaultItem(CinderscapesBlocks.SCORCHED_TENDRILS, BlockModelGenerators.PlantType.NOT_TINTED);
        this.registerPottedPlantOnly(generator, CinderscapesBlocks.SCORCHED_TENDRILS, CinderscapesBlocks.POTTED_SCORCHED_TENDRILS, true);
        generator.createPlant(CinderscapesBlocks.PYRACINTH, CinderscapesBlocks.POTTED_PYRACINTH, BlockModelGenerators.PlantType.NOT_TINTED);

        // BlockStateModelGenerator.registerSnows() equivalent  (Ash is a snow-like layered powder block)
        // We have to make models inheriting from vanilla's hand-rolled snow models...
        TextureMapping ashTexture = TextureMapping.cube(CinderscapesBlocks.ASH);
        Identifier ashModelId = ModelTemplates.CUBE_ALL.create(CinderscapesBlocks.ASH_BLOCK, ashTexture, generator.modelOutput);
        MultiVariant ashModel = BlockModelGenerators.plainVariant(ashModelId);
        generator.blockStateOutput.accept(MultiVariantGenerator.dispatch(CinderscapesBlocks.ASH).with(
                PropertyDispatch.initial(BlockStateProperties.LAYERS).generate(height ->
                        BlockModelGenerators.plainVariant(height < 8 ?
                                new ModelTemplate(Optional.of(ModelLocationUtils.getModelLocation(Blocks.SNOW, "_height" + height * 2)),
                                        Optional.empty(), TextureSlot.PARTICLE, TextureSlot.TEXTURE)
                                        .create(ModelLocationUtils.getModelLocation(CinderscapesBlocks.ASH, "_height" + height * 2),
                                                ashTexture, generator.modelOutput) :
                                ashModelId))));
        generator.registerSimpleItemModel(CinderscapesBlocks.ASH, ModelLocationUtils.getModelLocation(CinderscapesBlocks.ASH, "_height2"));
        generator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(CinderscapesBlocks.ASH_BLOCK, ashModel));
        this.registerBlockItemModel(generator, CinderscapesBlocks.ASH_BLOCK);


        /*//////////////////
        // Luminous Grove //
        //////////////////*/

        // Umbral wood set
        generator.family(CinderscapesBlockFamilies.UMBRAL.getBaseBlock()).generateFor(CinderscapesBlockFamilies.UMBRAL);
        generator.createShelf(CinderscapesBlocks.UMBRAL_SHELF, CinderscapesBlocks.STRIPPED_UMBRAL_STEM);
        generator.woodProvider(CinderscapesBlocks.UMBRAL_STEM).logWithHorizontal(CinderscapesBlocks.UMBRAL_STEM).wood(CinderscapesBlocks.UMBRAL_HYPHAE);
        generator.woodProvider(CinderscapesBlocks.STRIPPED_UMBRAL_STEM).logWithHorizontal(CinderscapesBlocks.STRIPPED_UMBRAL_STEM).wood(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE);
        generator.createHangingSign(CinderscapesBlockFamilies.UMBRAL.getBaseBlock(), CinderscapesBlocks.UMBRAL_HANGING_SIGN, CinderscapesBlocks.UMBRAL_WALL_HANGING_SIGN);
        generator.createPlantWithDefaultItem(CinderscapesBlocks.UMBRAL_FUNGUS, CinderscapesBlocks.POTTED_UMBRAL_FUNGUS, BlockModelGenerators.PlantType.NOT_TINTED);
        // Item models missed by vanilla code
        this.registerBlockItemModel(generator, CinderscapesBlocks.UMBRAL_FENCE_GATE);
        this.registerBlockItemModel(generator, CinderscapesBlocks.UMBRAL_PLANKS);
        this.registerBlockItemModel(generator, CinderscapesBlocks.UMBRAL_PRESSURE_PLATE);

        // Luminous Grove misc.
        generator.createNyliumBlock(CinderscapesBlocks.UMBRAL_NYLIUM);
        this.registerBlockItemModel(generator, CinderscapesBlocks.UMBRAL_NYLIUM);
        generator.createTrivialCube(CinderscapesBlocks.UMBRAL_FLESH_BLOCK);
        this.registerBlockItemModel(generator, CinderscapesBlocks.UMBRAL_FLESH_BLOCK);
        generator.createTrivialCube(CinderscapesBlocks.UMBRAL_WART_BLOCK);
        this.registerBlockItemModel(generator, CinderscapesBlocks.UMBRAL_WART_BLOCK);
        generator.createTrivialCube(CinderscapesBlocks.TWILIGHT_VINE_BLOCK);
        this.registerBlockItemModel(generator, CinderscapesBlocks.TWILIGHT_VINE_BLOCK);
        generator.createCrossBlockWithDefaultItem(CinderscapesBlocks.TWILIGHT_TENDRILS, BlockModelGenerators.PlantType.NOT_TINTED);
        this.registerPottedPlantOnly(generator, CinderscapesBlocks.TWILIGHT_TENDRILS, CinderscapesBlocks.POTTED_TWILIGHT_TENDRILS, true);
        generator.createCrossBlock(CinderscapesBlocks.TWILIGHT_FESCUES, BlockModelGenerators.PlantType.NOT_TINTED);
        generator.createPlant(CinderscapesBlocks.PHOTOFERN, CinderscapesBlocks.POTTED_PHOTOFERN, BlockModelGenerators.PlantType.NOT_TINTED);
        generator.createDoublePlant(CinderscapesBlocks.TALL_PHOTOFERN, BlockModelGenerators.PlantType.NOT_TINTED);
        // Luminous Pod is two tall but potted
        generator.createDoublePlant(CinderscapesBlocks.LUMINOUS_POD, BlockModelGenerators.PlantType.NOT_TINTED);
        this.registerPottedPlantOnly(generator, CinderscapesBlocks.LUMINOUS_POD, CinderscapesBlocks.POTTED_LUMINOUS_POD, true);

        // Ghastly Ectoplasm is a multi-part variable length hanging cross block
        generator.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(CinderscapesBlocks.GHASTLY_ECTOPLASM)
                        .with(
                                PropertyDispatch.initial(GhastlyEctoplasmBlock.TYPE)
                                        .select(GhastlyEctoplasmBlock.Type.TOP, BlockModelGenerators.plainVariant(
                                                ModelTemplates.TINTED_CROSS.createWithSuffix(CinderscapesBlocks.GHASTLY_ECTOPLASM, "_top",
                                                        TextureMapping.cross(TextureMapping.getBlockTexture(CinderscapesBlocks.GHASTLY_ECTOPLASM, "_top")),
                                                        generator.modelOutput)))
                                        .select(GhastlyEctoplasmBlock.Type.MIDDLE, BlockModelGenerators.plainVariant(
                                                ModelTemplates.TINTED_CROSS.createWithSuffix(CinderscapesBlocks.GHASTLY_ECTOPLASM, "_middle",
                                                        TextureMapping.cross(TextureMapping.getBlockTexture(CinderscapesBlocks.GHASTLY_ECTOPLASM, "_middle")),
                                                        generator.modelOutput)))
                                        .select(GhastlyEctoplasmBlock.Type.BOTTOM, BlockModelGenerators.plainVariant(
                                                ModelTemplates.TINTED_CROSS.createWithSuffix(CinderscapesBlocks.GHASTLY_ECTOPLASM, "_bottom",
                                                        TextureMapping.cross(TextureMapping.getBlockTexture(CinderscapesBlocks.GHASTLY_ECTOPLASM, "_bottom")),
                                                        generator.modelOutput)))
                        )
        );



        /*/////////////////
        // Quartz Cavern //
        /////////////////*/

        // Rose Quartz set
        generator.family(CinderscapesBlockFamilies.ROSE_QUARTZ_BLOCK.getBaseBlock()).generateFor(CinderscapesBlockFamilies.ROSE_QUARTZ_BLOCK);
        this.registerBlockItemModel(generator, CinderscapesBlocks.ROSE_QUARTZ_BLOCK);
        generator.family(CinderscapesBlockFamilies.SMOOTH_ROSE_QUARTZ.getBaseBlock()).generateFor(CinderscapesBlockFamilies.SMOOTH_ROSE_QUARTZ);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SMOOTH_ROSE_QUARTZ);
        this.registerCubeColumn(generator, CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK);
        this.registerBlockItemModel(generator, CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK);
        generator.createTrivialCube(CinderscapesBlocks.ROSE_QUARTZ_ORE);
        this.registerBlockItemModel(generator, CinderscapesBlocks.ROSE_QUARTZ_ORE);
        generator.createTrivialCube(CinderscapesBlocks.ROSE_QUARTZ_BRICKS);
        this.registerBlockItemModel(generator, CinderscapesBlocks.ROSE_QUARTZ_BRICKS);
        generator.createRotatedPillarWithHorizontalVariant(CinderscapesBlocks.ROSE_QUARTZ_PILLAR, TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
        this.registerBlockItemModel(generator, CinderscapesBlocks.ROSE_QUARTZ_PILLAR);
        generator.createTrivialCube(CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ);
        this.registerBlockItemModel(generator, CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ);
        this.registerPolyp(generator, CinderscapesBlocks.POLYPITE_ROSE_QUARTZ);
        this.registerPottedPlantOnly(generator, CinderscapesBlocks.POLYPITE_ROSE_QUARTZ, CinderscapesBlocks.POTTED_POLYPITE_ROSE_QUARTZ);

        // Smoky Quartz set
        generator.family(CinderscapesBlockFamilies.SMOKY_QUARTZ_BLOCK.getBaseBlock()).generateFor(CinderscapesBlockFamilies.SMOKY_QUARTZ_BLOCK);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SMOKY_QUARTZ_BLOCK);
        generator.family(CinderscapesBlockFamilies.SMOOTH_SMOKY_QUARTZ.getBaseBlock()).generateFor(CinderscapesBlockFamilies.SMOOTH_SMOKY_QUARTZ);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ);
        this.registerCubeColumn(generator, CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK);
        this.registerBlockItemModel(generator, CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK);
        generator.createTrivialCube(CinderscapesBlocks.SMOKY_QUARTZ_ORE);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SMOKY_QUARTZ_ORE);
        generator.createTrivialCube(CinderscapesBlocks.SMOKY_QUARTZ_BRICKS);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SMOKY_QUARTZ_BRICKS);
        generator.createRotatedPillarWithHorizontalVariant(CinderscapesBlocks.SMOKY_QUARTZ_PILLAR, TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SMOKY_QUARTZ_PILLAR);
        generator.createTrivialCube(CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ);
        this.registerBlockItemModel(generator, CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ);
        this.registerPolyp(generator, CinderscapesBlocks.POLYPITE_SMOKY_QUARTZ);
        this.registerPottedPlantOnly(generator, CinderscapesBlocks.POLYPITE_SMOKY_QUARTZ, CinderscapesBlocks.POTTED_POLYPITE_SMOKY_QUARTZ);

        // Sulfur Quartz set
        generator.family(CinderscapesBlockFamilies.SULFUR_QUARTZ_BLOCK.getBaseBlock()).generateFor(CinderscapesBlockFamilies.SULFUR_QUARTZ_BLOCK);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SULFUR_QUARTZ_BLOCK);
        generator.family(CinderscapesBlockFamilies.SMOOTH_SULFUR_QUARTZ.getBaseBlock()).generateFor(CinderscapesBlockFamilies.SMOOTH_SULFUR_QUARTZ);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ);
        this.registerCubeColumn(generator, CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK);
        this.registerBlockItemModel(generator, CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK);
        generator.createTrivialCube(CinderscapesBlocks.SULFUR_QUARTZ_ORE);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SULFUR_QUARTZ_ORE);
        generator.createTrivialCube(CinderscapesBlocks.SULFUR_QUARTZ_BRICKS);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SULFUR_QUARTZ_BRICKS);
        generator.createRotatedPillarWithHorizontalVariant(CinderscapesBlocks.SULFUR_QUARTZ_PILLAR, TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SULFUR_QUARTZ_PILLAR);
        generator.createTrivialCube(CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ);
        this.registerBlockItemModel(generator, CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ);
        this.registerPolyp(generator, CinderscapesBlocks.POLYPITE_SULFUR_QUARTZ);
        this.registerPottedPlantOnly(generator, CinderscapesBlocks.POLYPITE_SULFUR_QUARTZ, CinderscapesBlocks.POTTED_POLYPITE_SULFUR_QUARTZ);

        // Nether Quartz additions
        generator.createTrivialCube(CinderscapesBlocks.CRYSTALLINE_QUARTZ);
        this.registerBlockItemModel(generator, CinderscapesBlocks.CRYSTALLINE_QUARTZ);
        this.registerPolyp(generator, CinderscapesBlocks.POLYPITE_QUARTZ);
        this.registerPottedPlantOnly(generator, CinderscapesBlocks.POLYPITE_QUARTZ, CinderscapesBlocks.POTTED_POLYPITE_QUARTZ);

        // Quartz Cavern misc.
        generator.createPlant(CinderscapesBlocks.CRYSTINIUM, CinderscapesBlocks.POTTED_CRYSTINIUM, BlockModelGenerators.PlantType.NOT_TINTED);


        /*/////////
        // Other //
        /////////*/

        generator.createNyliumBlock(CinderscapesBlocks.NODZOL);
        this.registerBlockItemModel(generator, CinderscapesBlocks.NODZOL);
        generator.createTrivialCube(CinderscapesBlocks.SULFUR_BLOCK);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SULFUR_BLOCK);
        generator.createTrivialCube(CinderscapesBlocks.SULFUR_ORE);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SULFUR_ORE);

        // Adapted copy of BlockStateModelGenerator.registerSweetBerryBush for Bramble Berry Bush
        generator.registerSimpleFlatItemModel(CinderscapesItems.BRAMBLE_BERRIES);
        generator.blockStateOutput.accept(MultiVariantGenerator.dispatch(CinderscapesBlocks.BRAMBLE_BERRY_BUSH)
                .with(PropertyDispatch.initial(BlockStateProperties.AGE_3).generate(stage -> BlockModelGenerators
                        .plainVariant(generator.createSuffixedVariant(CinderscapesBlocks.BRAMBLE_BERRY_BUSH,
                                "_stage" + stage, ModelTemplates.CROSS, TextureMapping::cross)))));
    }

    @Override
    public void generateItemModels(ItemModelGenerators generator) {
        generator.generateFlatItem(CinderscapesItems.ASH_PILE, ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(CinderscapesItems.SULFUR, ModelTemplates.FLAT_ITEM);

        generator.generateFlatItem(CinderscapesItems.ROSE_QUARTZ, ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(CinderscapesItems.SMOKY_QUARTZ, ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(CinderscapesItems.SULFUR_QUARTZ, ModelTemplates.FLAT_ITEM);

        // Block items with provided item textures
        generator.generateFlatItem(CinderscapesItems.CRYSTINIUM, ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(CinderscapesItems.GHASTLY_ECTOPLASM, ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(CinderscapesItems.LUMINOUS_POD, ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(CinderscapesItems.PYRACINTH, ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(CinderscapesItems.PHOTOFERN, ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(CinderscapesItems.SCORCHED_SPROUTS, ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(CinderscapesItems.TALL_PHOTOFERN, ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(CinderscapesItems.TWILIGHT_FESCUES, ModelTemplates.FLAT_ITEM);

        // Armor items with Cinderscapes trim materials
        this.registerArmorTrims(generator, Items.TURTLE_HELMET, EquipmentAssets.TURTLE_SCUTE, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        this.registerArmorTrims(generator, Items.LEATHER_HELMET, EquipmentAssets.LEATHER, ItemModelGenerators.TRIM_PREFIX_HELMET, true);
        this.registerArmorTrims(generator, Items.LEATHER_CHESTPLATE, EquipmentAssets.LEATHER, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, true);
        this.registerArmorTrims(generator, Items.LEATHER_LEGGINGS, EquipmentAssets.LEATHER, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, true);
        this.registerArmorTrims(generator, Items.LEATHER_BOOTS, EquipmentAssets.LEATHER, ItemModelGenerators.TRIM_PREFIX_BOOTS, true);
        this.registerArmorTrims(generator, Items.COPPER_HELMET, EquipmentAssets.COPPER, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        this.registerArmorTrims(generator, Items.COPPER_CHESTPLATE, EquipmentAssets.COPPER, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        this.registerArmorTrims(generator, Items.COPPER_LEGGINGS, EquipmentAssets.COPPER, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        this.registerArmorTrims(generator, Items.COPPER_BOOTS, EquipmentAssets.COPPER, ItemModelGenerators.TRIM_PREFIX_BOOTS, false);
        this.registerArmorTrims(generator, Items.CHAINMAIL_HELMET, EquipmentAssets.CHAINMAIL, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        this.registerArmorTrims(generator, Items.CHAINMAIL_CHESTPLATE, EquipmentAssets.CHAINMAIL, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        this.registerArmorTrims(generator, Items.CHAINMAIL_LEGGINGS, EquipmentAssets.CHAINMAIL, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        this.registerArmorTrims(generator, Items.CHAINMAIL_BOOTS, EquipmentAssets.CHAINMAIL, ItemModelGenerators.TRIM_PREFIX_BOOTS, false);
        this.registerArmorTrims(generator, Items.IRON_HELMET, EquipmentAssets.IRON, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        this.registerArmorTrims(generator, Items.IRON_CHESTPLATE, EquipmentAssets.IRON, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        this.registerArmorTrims(generator, Items.IRON_LEGGINGS, EquipmentAssets.IRON, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        this.registerArmorTrims(generator, Items.IRON_BOOTS, EquipmentAssets.IRON, ItemModelGenerators.TRIM_PREFIX_BOOTS, false);
        this.registerArmorTrims(generator, Items.DIAMOND_HELMET, EquipmentAssets.DIAMOND, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        this.registerArmorTrims(generator, Items.DIAMOND_CHESTPLATE, EquipmentAssets.DIAMOND, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        this.registerArmorTrims(generator, Items.DIAMOND_LEGGINGS, EquipmentAssets.DIAMOND, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        this.registerArmorTrims(generator, Items.DIAMOND_BOOTS, EquipmentAssets.DIAMOND, ItemModelGenerators.TRIM_PREFIX_BOOTS, false);
        this.registerArmorTrims(generator, Items.GOLDEN_HELMET, EquipmentAssets.GOLD, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        this.registerArmorTrims(generator, Items.GOLDEN_CHESTPLATE, EquipmentAssets.GOLD, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        this.registerArmorTrims(generator, Items.GOLDEN_LEGGINGS, EquipmentAssets.GOLD, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        this.registerArmorTrims(generator, Items.GOLDEN_BOOTS, EquipmentAssets.GOLD, ItemModelGenerators.TRIM_PREFIX_BOOTS, false);
        this.registerArmorTrims(generator, Items.NETHERITE_HELMET, EquipmentAssets.NETHERITE, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        this.registerArmorTrims(generator, Items.NETHERITE_CHESTPLATE, EquipmentAssets.NETHERITE, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        this.registerArmorTrims(generator, Items.NETHERITE_LEGGINGS, EquipmentAssets.NETHERITE, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        this.registerArmorTrims(generator, Items.NETHERITE_BOOTS, EquipmentAssets.NETHERITE, ItemModelGenerators.TRIM_PREFIX_BOOTS, false);
    }


    private void registerPottedPlantOnly(BlockModelGenerators generator, Block plant, Block pottedPlant) {
        registerPottedPlantOnly(generator, plant, pottedPlant, false);
    }

    private void registerPottedPlantOnly(BlockModelGenerators generator, Block plant, Block pottedPlant, boolean usePottedTexture) {
        TextureMapping pottedTextures = usePottedTexture ?
                BlockModelGenerators.PlantType.NOT_TINTED.getPlantTextureMapping(pottedPlant) :
                BlockModelGenerators.PlantType.NOT_TINTED.getPlantTextureMapping(plant);
        Identifier pottedModelId = BlockModelGenerators.PlantType.NOT_TINTED.getCrossPot()
                .create(pottedPlant, pottedTextures, generator.modelOutput);
        MultiVariant pottedModel = BlockModelGenerators.plainVariant(pottedModelId);
        generator.blockStateOutput.accept(BlockModelGenerators
                .createSimpleBlock(pottedPlant, pottedModel));
    }

    private void registerPolyp(BlockModelGenerators generator, Block polyp) {
        // Cribbed somewhat from BlockStateModelGenerator.registerCoralFan(), but with only one Block
        // involved and downward orientation added, the variants are more like a dispenser...
        TexturedModel floorPolypModel = TexturedModel.CORAL_FAN.get(polyp);
        Identifier floorPolypId = floorPolypModel.createWithSuffix(polyp, "_floor", generator.modelOutput);
        Identifier wallPolypId = ModelTemplates.CORAL_WALL_FAN
                .createWithSuffix(polyp, "_wall", floorPolypModel.getMapping(), generator.modelOutput);

        generator.blockStateOutput
                .accept(
                        MultiVariantGenerator.dispatch(polyp)
                                .with(
                                        PropertyDispatch.initial(PolypiteQuartzBlock.DIRECTION)
                                                .select(Direction.DOWN, BlockModelGenerators.plainVariant(floorPolypId))
                                                .select(Direction.UP, BlockModelGenerators.plainVariant(floorPolypId).with(BlockModelGenerators.X_ROT_180))
                                                .select(Direction.NORTH, BlockModelGenerators.plainVariant(wallPolypId).with(BlockModelGenerators.Y_ROT_180))
                                                .select(Direction.EAST, BlockModelGenerators.plainVariant(wallPolypId).with(BlockModelGenerators.X_ROT_270))
                                                .select(Direction.SOUTH, BlockModelGenerators.plainVariant(wallPolypId))
                                                .select(Direction.WEST, BlockModelGenerators.plainVariant(wallPolypId).with(BlockModelGenerators.Y_ROT_90))
                                )
                );

        generator.registerSimpleFlatItemModel(polyp);
    }

    private void registerCubeColumn(BlockModelGenerators generator, Block cubeColumn) {
        // Put together from the hard-coded mess in BlockTexturePool that can only handle vanilla blocks
        TexturedModel columnModel = TexturedModel.COLUMN.get(cubeColumn)
                .updateTextures(textures -> textures.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(cubeColumn)));
        Identifier modelId = columnModel.create(cubeColumn, generator.modelOutput);
        MultiVariant model = BlockModelGenerators.plainVariant(modelId);
        generator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(cubeColumn, model));
    }


    /*
     * Shorthand for registering just the item model of a block item which uses its block's model.
     */
    private void registerBlockItemModel(BlockModelGenerators generator, Block block) {
        generator.registerSimpleItemModel(block, ModelLocationUtils.getModelLocation(block));
    }

    private void generateLayeredItem(ItemModelGenerators generator, Identifier id, Material layer0, Material layer1) {
        ModelTemplates.TWO_LAYERED_ITEM.create(id, TextureMapping.layered(layer0, layer1), generator.modelOutput);
    }

    private void generateLayeredItem(ItemModelGenerators generator, Identifier id, Material layer0, Material layer1, Material layer2) {
        ModelTemplates.THREE_LAYERED_ITEM.create(id, TextureMapping.layered(layer0, layer1, layer2), generator.modelOutput);
    }

    private void registerArmorTrims(ItemModelGenerators generator, Item armor, ResourceKey<EquipmentAsset> equipmentKey, Identifier slotTrimPrefix, boolean hasDyedLayer) {
        Identifier armorModelId = ModelLocationUtils.getModelLocation(armor);
        Material armorTextures = TextureMapping.getItemTexture(armor);
        Material armorOverlayTextures = TextureMapping.getItemTexture(armor, "_overlay");
        for (ItemModelGenerators.TrimMaterialData trimMaterial : TRIM_MATERIALS) {
            Identifier trimmedModelId = Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, armorModelId.getPath())
                    .withSuffix("_" + trimMaterial.assets().base().suffix() + "_trim");
            Material trimTextureId = new Material(slotTrimPrefix
                    .withSuffix("_" + trimMaterial.assets().assetId(equipmentKey).suffix()));
            if (hasDyedLayer) {
                this.generateLayeredItem(generator, trimmedModelId, armorTextures, armorOverlayTextures, trimTextureId);
            } else {
                this.generateLayeredItem(generator, trimmedModelId, armorTextures, trimTextureId);
            }
        }
    }
}
