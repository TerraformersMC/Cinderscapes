package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.block.GhastlyEctoplasmBlock;
import com.terraformersmc.cinderscapes.block.PolypiteQuartzBlock;
import com.terraformersmc.cinderscapes.init.*;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.data.*;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.registry.RegistryKey;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.List;
import java.util.Optional;

public class CinderscapesModelProvider extends FabricModelProvider {
    private static final List<ItemModelGenerator.TrimMaterial> TRIM_MATERIALS = List.of(
            new ItemModelGenerator.TrimMaterial(CinderscapesArmorTrimAssets.ROSE_QUARTZ, CinderscapesArmorTrimMaterials.ROSE_QUARTZ),
            new ItemModelGenerator.TrimMaterial(CinderscapesArmorTrimAssets.SMOKY_QUARTZ, CinderscapesArmorTrimMaterials.SMOKY_QUARTZ),
            new ItemModelGenerator.TrimMaterial(CinderscapesArmorTrimAssets.SULFUR_QUARTZ, CinderscapesArmorTrimMaterials.SULFUR_QUARTZ)
    );

    public CinderscapesModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {

        /////////////////
        // Ashy Shoals //
        /////////////////

        // Scorched wood set
        generator.registerCubeAllModelTexturePool(CinderscapesBlockFamilies.SCORCHED.getBaseBlock()).family(CinderscapesBlockFamilies.SCORCHED);
        generator.registerShelf(CinderscapesBlocks.SCORCHED_SHELF, CinderscapesBlocks.STRIPPED_SCORCHED_STEM);
        generator.createLogTexturePool(CinderscapesBlocks.SCORCHED_STEM).log(CinderscapesBlocks.SCORCHED_STEM).wood(CinderscapesBlocks.SCORCHED_HYPHAE);
        generator.createLogTexturePool(CinderscapesBlocks.STRIPPED_SCORCHED_STEM).log(CinderscapesBlocks.STRIPPED_SCORCHED_STEM).wood(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE);
        generator.registerHangingSign(CinderscapesBlockFamilies.SCORCHED.getBaseBlock(), CinderscapesBlocks.SCORCHED_HANGING_SIGN, CinderscapesBlocks.SCORCHED_WALL_HANGING_SIGN);
        // Item models missed by vanilla code
        this.registerBlockItemModel(generator, CinderscapesBlocks.SCORCHED_FENCE_GATE);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SCORCHED_PLANKS);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SCORCHED_PRESSURE_PLATE);

        // Misc. vegetation
        generator.registerFlowerPotPlantAndItem(CinderscapesBlocks.SCORCHED_SHRUB, CinderscapesBlocks.POTTED_SCORCHED_SHRUB, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerTintableCrossBlockState(CinderscapesBlocks.SCORCHED_SPROUTS, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerTintableCross(CinderscapesBlocks.SCORCHED_TENDRILS, BlockStateModelGenerator.CrossType.NOT_TINTED);
        this.registerPottedPlantOnly(generator, CinderscapesBlocks.SCORCHED_TENDRILS, CinderscapesBlocks.POTTED_SCORCHED_TENDRILS, true);
        generator.registerFlowerPotPlant(CinderscapesBlocks.PYRACINTH, CinderscapesBlocks.POTTED_PYRACINTH, BlockStateModelGenerator.CrossType.NOT_TINTED);

        // BlockStateModelGenerator.registerSnows() equivalent  (Ash is a snow-like layered powder block)
        // We have to make models inheriting from vanilla's hand-rolled snow models...
        TextureMap ashTexture = TextureMap.all(CinderscapesBlocks.ASH);
        Identifier ashModelId = Models.CUBE_ALL.upload(CinderscapesBlocks.ASH_BLOCK, ashTexture, generator.modelCollector);
        WeightedVariant ashModel = BlockStateModelGenerator.createWeightedVariant(ashModelId);
        generator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(CinderscapesBlocks.ASH).with(
                BlockStateVariantMap.models(Properties.LAYERS).generate(height ->
                        BlockStateModelGenerator.createWeightedVariant(height < 8 ?
                                new Model(Optional.of(ModelIds.getBlockSubModelId(Blocks.SNOW, "_height" + height * 2)),
                                        Optional.empty(), TextureKey.PARTICLE, TextureKey.TEXTURE)
                                        .upload(ModelIds.getBlockSubModelId(CinderscapesBlocks.ASH, "_height" + height * 2),
                                                ashTexture, generator.modelCollector) :
                                ashModelId))));
        generator.registerParentedItemModel(CinderscapesBlocks.ASH, ModelIds.getBlockSubModelId(CinderscapesBlocks.ASH, "_height2"));
        generator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(CinderscapesBlocks.ASH_BLOCK, ashModel));
        this.registerBlockItemModel(generator, CinderscapesBlocks.ASH_BLOCK);


        ////////////////////
        // Luminous Grove //
        ////////////////////

        // Umbral wood set
        generator.registerCubeAllModelTexturePool(CinderscapesBlockFamilies.UMBRAL.getBaseBlock()).family(CinderscapesBlockFamilies.UMBRAL);
        generator.registerShelf(CinderscapesBlocks.UMBRAL_SHELF, CinderscapesBlocks.STRIPPED_UMBRAL_STEM);
        generator.createLogTexturePool(CinderscapesBlocks.UMBRAL_STEM).log(CinderscapesBlocks.UMBRAL_STEM).wood(CinderscapesBlocks.UMBRAL_HYPHAE);
        generator.createLogTexturePool(CinderscapesBlocks.STRIPPED_UMBRAL_STEM).log(CinderscapesBlocks.STRIPPED_UMBRAL_STEM).wood(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE);
        generator.registerHangingSign(CinderscapesBlockFamilies.UMBRAL.getBaseBlock(), CinderscapesBlocks.UMBRAL_HANGING_SIGN, CinderscapesBlocks.UMBRAL_WALL_HANGING_SIGN);
        generator.registerFlowerPotPlantAndItem(CinderscapesBlocks.UMBRAL_FUNGUS, CinderscapesBlocks.POTTED_UMBRAL_FUNGUS, BlockStateModelGenerator.CrossType.NOT_TINTED);
        // Item models missed by vanilla code
        this.registerBlockItemModel(generator, CinderscapesBlocks.UMBRAL_FENCE_GATE);
        this.registerBlockItemModel(generator, CinderscapesBlocks.UMBRAL_PLANKS);
        this.registerBlockItemModel(generator, CinderscapesBlocks.UMBRAL_PRESSURE_PLATE);

        // Luminous Grove misc.
        generator.registerNetherrackBottomCustomTop(CinderscapesBlocks.UMBRAL_NYLIUM);
        this.registerBlockItemModel(generator, CinderscapesBlocks.UMBRAL_NYLIUM);
        generator.registerSimpleCubeAll(CinderscapesBlocks.UMBRAL_FLESH_BLOCK);
        this.registerBlockItemModel(generator, CinderscapesBlocks.UMBRAL_FLESH_BLOCK);
        generator.registerSimpleCubeAll(CinderscapesBlocks.UMBRAL_WART_BLOCK);
        this.registerBlockItemModel(generator, CinderscapesBlocks.UMBRAL_WART_BLOCK);
        generator.registerSimpleCubeAll(CinderscapesBlocks.TWILIGHT_VINE_BLOCK);
        this.registerBlockItemModel(generator, CinderscapesBlocks.TWILIGHT_VINE_BLOCK);
        generator.registerTintableCross(CinderscapesBlocks.TWILIGHT_TENDRILS, BlockStateModelGenerator.CrossType.NOT_TINTED);
        this.registerPottedPlantOnly(generator, CinderscapesBlocks.TWILIGHT_TENDRILS, CinderscapesBlocks.POTTED_TWILIGHT_TENDRILS, true);
        generator.registerTintableCrossBlockState(CinderscapesBlocks.TWILIGHT_FESCUES, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlant(CinderscapesBlocks.PHOTOFERN, CinderscapesBlocks.POTTED_PHOTOFERN, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerDoubleBlock(CinderscapesBlocks.TALL_PHOTOFERN, BlockStateModelGenerator.CrossType.NOT_TINTED);
        // Luminous Pod is two tall but potted
        generator.registerDoubleBlock(CinderscapesBlocks.LUMINOUS_POD, BlockStateModelGenerator.CrossType.NOT_TINTED);
        this.registerPottedPlantOnly(generator, CinderscapesBlocks.LUMINOUS_POD, CinderscapesBlocks.POTTED_LUMINOUS_POD, true);

        // Ghastly Ectoplasm is a multi-part variable length hanging cross block
        generator.blockStateCollector.accept(
                VariantsBlockModelDefinitionCreator.of(CinderscapesBlocks.GHASTLY_ECTOPLASM)
                        .with(
                                BlockStateVariantMap.models(GhastlyEctoplasmBlock.TYPE)
                                        .register(GhastlyEctoplasmBlock.Type.TOP, BlockStateModelGenerator.createWeightedVariant(
                                                Models.TINTED_CROSS.upload(CinderscapesBlocks.GHASTLY_ECTOPLASM, "_top",
                                                        TextureMap.cross(TextureMap.getSubId(CinderscapesBlocks.GHASTLY_ECTOPLASM, "_top")),
                                                        generator.modelCollector)))
                                        .register(GhastlyEctoplasmBlock.Type.MIDDLE, BlockStateModelGenerator.createWeightedVariant(
                                                Models.TINTED_CROSS.upload(CinderscapesBlocks.GHASTLY_ECTOPLASM, "_middle",
                                                        TextureMap.cross(TextureMap.getSubId(CinderscapesBlocks.GHASTLY_ECTOPLASM, "_middle")),
                                                        generator.modelCollector)))
                                        .register(GhastlyEctoplasmBlock.Type.BOTTOM, BlockStateModelGenerator.createWeightedVariant(
                                                Models.TINTED_CROSS.upload(CinderscapesBlocks.GHASTLY_ECTOPLASM, "_bottom",
                                                        TextureMap.cross(TextureMap.getSubId(CinderscapesBlocks.GHASTLY_ECTOPLASM, "_bottom")),
                                                        generator.modelCollector)))
                        )
        );



        ///////////////////
        // Quartz Cavern //
        ///////////////////

        // Rose Quartz set
        generator.registerCubeAllModelTexturePool(CinderscapesBlockFamilies.ROSE_QUARTZ_BLOCK.getBaseBlock()).family(CinderscapesBlockFamilies.ROSE_QUARTZ_BLOCK);
        this.registerBlockItemModel(generator, CinderscapesBlocks.ROSE_QUARTZ_BLOCK);
        generator.registerCubeAllModelTexturePool(CinderscapesBlockFamilies.SMOOTH_ROSE_QUARTZ.getBaseBlock()).family(CinderscapesBlockFamilies.SMOOTH_ROSE_QUARTZ);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SMOOTH_ROSE_QUARTZ);
        this.registerCubeColumn(generator, CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK);
        this.registerBlockItemModel(generator, CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK);
        generator.registerSimpleCubeAll(CinderscapesBlocks.ROSE_QUARTZ_ORE);
        this.registerBlockItemModel(generator, CinderscapesBlocks.ROSE_QUARTZ_ORE);
        generator.registerSimpleCubeAll(CinderscapesBlocks.ROSE_QUARTZ_BRICKS);
        this.registerBlockItemModel(generator, CinderscapesBlocks.ROSE_QUARTZ_BRICKS);
        generator.registerAxisRotated(CinderscapesBlocks.ROSE_QUARTZ_PILLAR, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
        this.registerBlockItemModel(generator, CinderscapesBlocks.ROSE_QUARTZ_PILLAR);
        generator.registerSimpleCubeAll(CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ);
        this.registerBlockItemModel(generator, CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ);
        this.registerPolyp(generator, CinderscapesBlocks.POLYPITE_ROSE_QUARTZ);
        this.registerPottedPlantOnly(generator, CinderscapesBlocks.POLYPITE_ROSE_QUARTZ, CinderscapesBlocks.POTTED_POLYPITE_ROSE_QUARTZ);

        // Smoky Quartz set
        generator.registerCubeAllModelTexturePool(CinderscapesBlockFamilies.SMOKY_QUARTZ_BLOCK.getBaseBlock()).family(CinderscapesBlockFamilies.SMOKY_QUARTZ_BLOCK);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SMOKY_QUARTZ_BLOCK);
        generator.registerCubeAllModelTexturePool(CinderscapesBlockFamilies.SMOOTH_SMOKY_QUARTZ.getBaseBlock()).family(CinderscapesBlockFamilies.SMOOTH_SMOKY_QUARTZ);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ);
        this.registerCubeColumn(generator, CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK);
        this.registerBlockItemModel(generator, CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK);
        generator.registerSimpleCubeAll(CinderscapesBlocks.SMOKY_QUARTZ_ORE);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SMOKY_QUARTZ_ORE);
        generator.registerSimpleCubeAll(CinderscapesBlocks.SMOKY_QUARTZ_BRICKS);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SMOKY_QUARTZ_BRICKS);
        generator.registerAxisRotated(CinderscapesBlocks.SMOKY_QUARTZ_PILLAR, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SMOKY_QUARTZ_PILLAR);
        generator.registerSimpleCubeAll(CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ);
        this.registerBlockItemModel(generator, CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ);
        this.registerPolyp(generator, CinderscapesBlocks.POLYPITE_SMOKY_QUARTZ);
        this.registerPottedPlantOnly(generator, CinderscapesBlocks.POLYPITE_SMOKY_QUARTZ, CinderscapesBlocks.POTTED_POLYPITE_SMOKY_QUARTZ);

        // Sulfur Quartz set
        generator.registerCubeAllModelTexturePool(CinderscapesBlockFamilies.SULFUR_QUARTZ_BLOCK.getBaseBlock()).family(CinderscapesBlockFamilies.SULFUR_QUARTZ_BLOCK);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SULFUR_QUARTZ_BLOCK);
        generator.registerCubeAllModelTexturePool(CinderscapesBlockFamilies.SMOOTH_SULFUR_QUARTZ.getBaseBlock()).family(CinderscapesBlockFamilies.SMOOTH_SULFUR_QUARTZ);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ);
        this.registerCubeColumn(generator, CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK);
        this.registerBlockItemModel(generator, CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK);
        generator.registerSimpleCubeAll(CinderscapesBlocks.SULFUR_QUARTZ_ORE);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SULFUR_QUARTZ_ORE);
        generator.registerSimpleCubeAll(CinderscapesBlocks.SULFUR_QUARTZ_BRICKS);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SULFUR_QUARTZ_BRICKS);
        generator.registerAxisRotated(CinderscapesBlocks.SULFUR_QUARTZ_PILLAR, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SULFUR_QUARTZ_PILLAR);
        generator.registerSimpleCubeAll(CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ);
        this.registerBlockItemModel(generator, CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ);
        this.registerPolyp(generator, CinderscapesBlocks.POLYPITE_SULFUR_QUARTZ);
        this.registerPottedPlantOnly(generator, CinderscapesBlocks.POLYPITE_SULFUR_QUARTZ, CinderscapesBlocks.POTTED_POLYPITE_SULFUR_QUARTZ);

        // Nether Quartz additions
        generator.registerSimpleCubeAll(CinderscapesBlocks.CRYSTALLINE_QUARTZ);
        this.registerBlockItemModel(generator, CinderscapesBlocks.CRYSTALLINE_QUARTZ);
        this.registerPolyp(generator, CinderscapesBlocks.POLYPITE_QUARTZ);
        this.registerPottedPlantOnly(generator, CinderscapesBlocks.POLYPITE_QUARTZ, CinderscapesBlocks.POTTED_POLYPITE_QUARTZ);

        // Quartz Cavern misc.
        generator.registerFlowerPotPlant(CinderscapesBlocks.CRYSTINIUM, CinderscapesBlocks.POTTED_CRYSTINIUM, BlockStateModelGenerator.CrossType.NOT_TINTED);


        ///////////
        // Other //
        ///////////

        generator.registerNetherrackBottomCustomTop(CinderscapesBlocks.NODZOL);
        this.registerBlockItemModel(generator, CinderscapesBlocks.NODZOL);
        generator.registerSimpleCubeAll(CinderscapesBlocks.SULFUR_BLOCK);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SULFUR_BLOCK);
        generator.registerSimpleCubeAll(CinderscapesBlocks.SULFUR_ORE);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SULFUR_ORE);

        // Adapted copy of BlockStateModelGenerator.registerSweetBerryBush for Bramble Berry Bush
        generator.registerItemModel(CinderscapesItems.BRAMBLE_BERRIES);
        generator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(CinderscapesBlocks.BRAMBLE_BERRY_BUSH)
                .with(BlockStateVariantMap.models(Properties.AGE_3).generate(stage -> BlockStateModelGenerator
                        .createWeightedVariant(generator.createSubModel(CinderscapesBlocks.BRAMBLE_BERRY_BUSH,
                                "_stage" + stage, Models.CROSS, TextureMap::cross)))));
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {
        generator.register(CinderscapesItems.ASH_PILE, Models.GENERATED);
        generator.register(CinderscapesItems.SULFUR, Models.GENERATED);

        generator.register(CinderscapesItems.ROSE_QUARTZ, Models.GENERATED);
        generator.register(CinderscapesItems.SMOKY_QUARTZ, Models.GENERATED);
        generator.register(CinderscapesItems.SULFUR_QUARTZ, Models.GENERATED);

        // Block items with provided item textures
        generator.register(CinderscapesItems.CRYSTINIUM, Models.GENERATED);
        generator.register(CinderscapesItems.GHASTLY_ECTOPLASM, Models.GENERATED);
        generator.register(CinderscapesItems.LUMINOUS_POD, Models.GENERATED);
        generator.register(CinderscapesItems.PYRACINTH, Models.GENERATED);
        generator.register(CinderscapesItems.PHOTOFERN, Models.GENERATED);
        generator.register(CinderscapesItems.SCORCHED_SPROUTS, Models.GENERATED);
        generator.register(CinderscapesItems.TALL_PHOTOFERN, Models.GENERATED);
        generator.register(CinderscapesItems.TWILIGHT_FESCUES, Models.GENERATED);

        // Armor items with Cinderscapes trim materials
        this.registerArmorTrims(generator, Items.TURTLE_HELMET, EquipmentAssetKeys.TURTLE_SCUTE, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        this.registerArmorTrims(generator, Items.LEATHER_HELMET, EquipmentAssetKeys.LEATHER, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, true);
        this.registerArmorTrims(generator, Items.LEATHER_CHESTPLATE, EquipmentAssetKeys.LEATHER, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, true);
        this.registerArmorTrims(generator, Items.LEATHER_LEGGINGS, EquipmentAssetKeys.LEATHER, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, true);
        this.registerArmorTrims(generator, Items.LEATHER_BOOTS, EquipmentAssetKeys.LEATHER, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, true);
        this.registerArmorTrims(generator, Items.CHAINMAIL_HELMET, EquipmentAssetKeys.CHAINMAIL, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        this.registerArmorTrims(generator, Items.CHAINMAIL_CHESTPLATE, EquipmentAssetKeys.CHAINMAIL, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        this.registerArmorTrims(generator, Items.CHAINMAIL_LEGGINGS, EquipmentAssetKeys.CHAINMAIL, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        this.registerArmorTrims(generator, Items.CHAINMAIL_BOOTS, EquipmentAssetKeys.CHAINMAIL, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);
        this.registerArmorTrims(generator, Items.IRON_HELMET, EquipmentAssetKeys.IRON, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        this.registerArmorTrims(generator, Items.IRON_CHESTPLATE, EquipmentAssetKeys.IRON, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        this.registerArmorTrims(generator, Items.IRON_LEGGINGS, EquipmentAssetKeys.IRON, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        this.registerArmorTrims(generator, Items.IRON_BOOTS, EquipmentAssetKeys.IRON, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);
        this.registerArmorTrims(generator, Items.DIAMOND_HELMET, EquipmentAssetKeys.DIAMOND, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        this.registerArmorTrims(generator, Items.DIAMOND_CHESTPLATE, EquipmentAssetKeys.DIAMOND, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        this.registerArmorTrims(generator, Items.DIAMOND_LEGGINGS, EquipmentAssetKeys.DIAMOND, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        this.registerArmorTrims(generator, Items.DIAMOND_BOOTS, EquipmentAssetKeys.DIAMOND, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);
        this.registerArmorTrims(generator, Items.GOLDEN_HELMET, EquipmentAssetKeys.GOLD, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        this.registerArmorTrims(generator, Items.GOLDEN_CHESTPLATE, EquipmentAssetKeys.GOLD, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        this.registerArmorTrims(generator, Items.GOLDEN_LEGGINGS, EquipmentAssetKeys.GOLD, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        this.registerArmorTrims(generator, Items.GOLDEN_BOOTS, EquipmentAssetKeys.GOLD, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);
        this.registerArmorTrims(generator, Items.NETHERITE_HELMET, EquipmentAssetKeys.NETHERITE, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        this.registerArmorTrims(generator, Items.NETHERITE_CHESTPLATE, EquipmentAssetKeys.NETHERITE, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        this.registerArmorTrims(generator, Items.NETHERITE_LEGGINGS, EquipmentAssetKeys.NETHERITE, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        this.registerArmorTrims(generator, Items.NETHERITE_BOOTS, EquipmentAssetKeys.NETHERITE, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);
    }


    private void registerPottedPlantOnly(BlockStateModelGenerator generator, Block plant, Block pottedPlant) {
        registerPottedPlantOnly(generator, plant, pottedPlant, false);
    }

    private void registerPottedPlantOnly(BlockStateModelGenerator generator, Block plant, Block pottedPlant, boolean usePottedTexture) {
        TextureMap pottedTextures = usePottedTexture ?
                BlockStateModelGenerator.CrossType.NOT_TINTED.getFlowerPotTextureMap(pottedPlant) :
                BlockStateModelGenerator.CrossType.NOT_TINTED.getFlowerPotTextureMap(plant);
        Identifier pottedModelId = BlockStateModelGenerator.CrossType.NOT_TINTED.getFlowerPotCrossModel()
                .upload(pottedPlant, pottedTextures, generator.modelCollector);
        WeightedVariant pottedModel = BlockStateModelGenerator.createWeightedVariant(pottedModelId);
        generator.blockStateCollector.accept(BlockStateModelGenerator
                .createSingletonBlockState(pottedPlant, pottedModel));
    }

    private void registerPolyp(BlockStateModelGenerator generator, Block polyp) {
        // Cribbed somewhat from BlockStateModelGenerator.registerCoralFan(), but with only one Block
        // involved and downward orientation added, the variants are more like a dispenser...
        TexturedModel floorPolypModel = TexturedModel.CORAL_FAN.get(polyp);
        Identifier floorPolypId = floorPolypModel.upload(polyp, "_floor", generator.modelCollector);
        Identifier wallPolypId = Models.CORAL_WALL_FAN
                .upload(polyp, "_wall", floorPolypModel.getTextures(), generator.modelCollector);

        generator.blockStateCollector
                .accept(
                        VariantsBlockModelDefinitionCreator.of(polyp)
                                .with(
                                        BlockStateVariantMap.models(PolypiteQuartzBlock.DIRECTION)
                                                .register(Direction.DOWN, BlockStateModelGenerator.createWeightedVariant(floorPolypId))
                                                .register(Direction.UP, BlockStateModelGenerator.createWeightedVariant(floorPolypId).apply(BlockStateModelGenerator.ROTATE_X_180))
                                                .register(Direction.NORTH, BlockStateModelGenerator.createWeightedVariant(wallPolypId).apply(BlockStateModelGenerator.ROTATE_Y_180))
                                                .register(Direction.EAST, BlockStateModelGenerator.createWeightedVariant(wallPolypId).apply(BlockStateModelGenerator.ROTATE_X_270))
                                                .register(Direction.SOUTH, BlockStateModelGenerator.createWeightedVariant(wallPolypId))
                                                .register(Direction.WEST, BlockStateModelGenerator.createWeightedVariant(wallPolypId).apply(BlockStateModelGenerator.ROTATE_Y_90))
                                )
                );

        generator.registerItemModel(polyp);
    }

    private void registerCubeColumn(BlockStateModelGenerator generator, Block cubeColumn) {
        // Put together from the hard-coded mess in BlockTexturePool that can only handle vanilla blocks
        TexturedModel columnModel = TexturedModel.CUBE_COLUMN.get(cubeColumn)
                .textures(textures -> textures.put(TextureKey.SIDE, TextureMap.getId(cubeColumn)));
        Identifier modelId = columnModel.upload(cubeColumn, generator.modelCollector);
        WeightedVariant model = BlockStateModelGenerator.createWeightedVariant(modelId);
        generator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(cubeColumn, model));
    }


    /*
     * Shorthand for registering just the item model of a block item which uses its block's model.
     */
    private void registerBlockItemModel(BlockStateModelGenerator generator, Block block) {
        generator.registerParentedItemModel(block, ModelIds.getBlockModelId(block));
    }

    private void uploadArmor(ItemModelGenerator generator, Identifier id, Identifier layer0, Identifier layer1) {
        Models.GENERATED_TWO_LAYERS.upload(id, TextureMap.layered(layer0, layer1), generator.modelCollector);
    }

    private void uploadArmor(ItemModelGenerator generator, Identifier id, Identifier layer0, Identifier layer1, Identifier layer2) {
        Models.GENERATED_THREE_LAYERS.upload(id, TextureMap.layered(layer0, layer1, layer2), generator.modelCollector);
    }

    private void registerArmorTrims(ItemModelGenerator generator, Item armor, RegistryKey<EquipmentAsset> equipmentKey, Identifier trimIdPrefix, boolean dyeable) {
        Identifier armorModelId = ModelIds.getItemModelId(armor);
        Identifier armorTextures = TextureMap.getId(armor);
        Identifier armorOverlayTextures = TextureMap.getSubId(armor, "_overlay");
        for (ItemModelGenerator.TrimMaterial trimMaterial : TRIM_MATERIALS) {
            Identifier trimmedModelId = Identifier.of(Cinderscapes.MOD_ID, armorModelId.getPath())
                    .withSuffixedPath("_" + trimMaterial.assets().base().suffix() + "_trim");
            Identifier trimTextureId = trimIdPrefix
                    .withSuffixedPath("_" + trimMaterial.assets().getAssetId(equipmentKey).suffix());
            if (dyeable) {
                this.uploadArmor(generator, trimmedModelId, armorTextures, armorOverlayTextures, trimTextureId);
            } else {
                this.uploadArmor(generator, trimmedModelId, armorTextures, trimTextureId);
            }
        }
    }
}
