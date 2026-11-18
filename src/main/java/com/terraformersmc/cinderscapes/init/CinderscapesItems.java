package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.init.helpers.CinderscapesRegistry;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Compostable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

import java.util.Collection;
import java.util.List;

public class CinderscapesItems {

    /*///////////////
    // Ashy Shoals //
    ///////////////*/

    public static BlockItem SCORCHED_STEM;
    public static BlockItem STRIPPED_SCORCHED_STEM;

    public static BlockItem SCORCHED_HYPHAE;
    public static BlockItem STRIPPED_SCORCHED_HYPHAE;

    public static BlockItem SCORCHED_PLANKS;
    public static BlockItem SCORCHED_SLAB;
    public static BlockItem SCORCHED_STAIRS;

    public static BlockItem SCORCHED_BUTTON;
    public static BlockItem SCORCHED_DOOR;
    public static BlockItem SCORCHED_FENCE;
    public static BlockItem SCORCHED_FENCE_GATE;
    public static BlockItem SCORCHED_PRESSURE_PLATE;
    public static BlockItem SCORCHED_SHELF;
    public static BlockItem SCORCHED_TRAPDOOR;

    public static BlockItem SCORCHED_SIGN;
    public static HangingSignItem SCORCHED_HANGING_SIGN;

    public static BlockItem SCORCHED_SHRUB;
    public static BlockItem SCORCHED_SPROUTS;
    public static BlockItem SCORCHED_TENDRILS;

    public static BlockItem ASH;
    public static BlockItem ASH_BLOCK;

    public static BlockItem PYRACINTH;

    /*//////////////////
    // Luminous Grove //
    //////////////////*/

    // Umbral Nylia

    public static BlockItem UMBRAL_STEM;
    public static BlockItem STRIPPED_UMBRAL_STEM;

    public static BlockItem UMBRAL_HYPHAE;
    public static BlockItem STRIPPED_UMBRAL_HYPHAE;

    public static BlockItem UMBRAL_NYLIUM;

    public static BlockItem UMBRAL_FUNGUS;

    public static BlockItem UMBRAL_WART_BLOCK;
    public static BlockItem UMBRAL_FLESH_BLOCK;

    public static BlockItem UMBRAL_PLANKS;
    public static BlockItem UMBRAL_SLAB;
    public static BlockItem UMBRAL_STAIRS;

    public static BlockItem UMBRAL_BUTTON;
    public static BlockItem UMBRAL_DOOR;
    public static BlockItem UMBRAL_FENCE;
    public static BlockItem UMBRAL_FENCE_GATE;
    public static BlockItem UMBRAL_PRESSURE_PLATE;
    public static BlockItem UMBRAL_SHELF;
    public static BlockItem UMBRAL_TRAPDOOR;

    public static BlockItem UMBRAL_SIGN;
    public static HangingSignItem UMBRAL_HANGING_SIGN;

    // Other

    public static BlockItem TWILIGHT_VINE_BLOCK;
    public static BlockItem TWILIGHT_TENDRILS;
    public static BlockItem TWILIGHT_FESCUES;
    public static BlockItem PHOTOFERN;
    public static BlockItem TALL_PHOTOFERN;

    public static BlockItem LUMINOUS_POD;
    public static BlockItem GHASTLY_ECTOPLASM;

    /*/////////
    // Other //
    /////////*/

    public static Item ASH_PILE;

    public static BlockItem BRAMBLE_BERRIES;

    public static BlockItem NODZOL;

    public static Item SULFUR;

    public static BlockItem SULFUR_BLOCK;
    public static BlockItem SULFUR_ORE;

    public static Item ROSE_QUARTZ;
    public static Item SMOKY_QUARTZ;
    public static Item SULFUR_QUARTZ;

    /*/////////////////
    // Quartz Cavern //
    /////////////////*/

    public static BlockItem CRYSTINIUM;

    public static BlockItem CRYSTALLINE_QUARTZ;
    public static BlockItem POLYPITE_QUARTZ;

    // Sulfur Quartz

    public static BlockItem SULFUR_QUARTZ_ORE;
    public static BlockItem SULFUR_QUARTZ_BLOCK;
    public static BlockItem CHISELED_SULFUR_QUARTZ_BLOCK;
    public static BlockItem SULFUR_QUARTZ_PILLAR;
    public static BlockItem SULFUR_QUARTZ_STAIRS;
    public static BlockItem SULFUR_QUARTZ_SLAB;
    public static BlockItem SMOOTH_SULFUR_QUARTZ;
    public static BlockItem SMOOTH_SULFUR_QUARTZ_STAIRS;
    public static BlockItem SMOOTH_SULFUR_QUARTZ_SLAB;
    public static BlockItem SULFUR_QUARTZ_BRICKS;

    public static BlockItem CRYSTALLINE_SULFUR_QUARTZ;
    public static BlockItem POLYPITE_SULFUR_QUARTZ;

    // Rose Quartz

    public static BlockItem ROSE_QUARTZ_ORE;
    public static BlockItem ROSE_QUARTZ_BLOCK;
    public static BlockItem CHISELED_ROSE_QUARTZ_BLOCK;
    public static BlockItem ROSE_QUARTZ_PILLAR;
    public static BlockItem ROSE_QUARTZ_STAIRS;
    public static BlockItem ROSE_QUARTZ_SLAB;
    public static BlockItem SMOOTH_ROSE_QUARTZ;
    public static BlockItem SMOOTH_ROSE_QUARTZ_STAIRS;
    public static BlockItem SMOOTH_ROSE_QUARTZ_SLAB;
    public static BlockItem ROSE_QUARTZ_BRICKS;

    public static BlockItem CRYSTALLINE_ROSE_QUARTZ;
    public static BlockItem POLYPITE_ROSE_QUARTZ;

    // Smoky Quartz

    public static BlockItem SMOKY_QUARTZ_ORE;
    public static BlockItem SMOKY_QUARTZ_BLOCK;
    public static BlockItem CHISELED_SMOKY_QUARTZ_BLOCK;
    public static BlockItem SMOKY_QUARTZ_PILLAR;
    public static BlockItem SMOKY_QUARTZ_STAIRS;
    public static BlockItem SMOKY_QUARTZ_SLAB;
    public static BlockItem SMOOTH_SMOKY_QUARTZ;
    public static BlockItem SMOOTH_SMOKY_QUARTZ_STAIRS;
    public static BlockItem SMOOTH_SMOKY_QUARTZ_SLAB;
    public static BlockItem SMOKY_QUARTZ_BRICKS;

    public static BlockItem CRYSTALLINE_SMOKY_QUARTZ;
    public static BlockItem POLYPITE_SMOKY_QUARTZ;

    public static void init() {

        /*///////////////
        // Ashy Shoals //
        ///////////////*/

        SCORCHED_STEM = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SCORCHED_STEM, CinderscapesBlocks.SCORCHED_STEM);
        STRIPPED_SCORCHED_STEM = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.STRIPPED_SCORCHED_STEM, CinderscapesBlocks.STRIPPED_SCORCHED_STEM);

        SCORCHED_HYPHAE = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SCORCHED_HYPHAE, CinderscapesBlocks.SCORCHED_HYPHAE);
        STRIPPED_SCORCHED_HYPHAE = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.STRIPPED_SCORCHED_HYPHAE, CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE);

        SCORCHED_PLANKS = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SCORCHED_PLANKS, CinderscapesBlocks.SCORCHED_PLANKS);
        SCORCHED_SLAB = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SCORCHED_SLAB, CinderscapesBlocks.SCORCHED_SLAB);
        SCORCHED_STAIRS = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SCORCHED_STAIRS, CinderscapesBlocks.SCORCHED_STAIRS);

        SCORCHED_BUTTON = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SCORCHED_BUTTON, CinderscapesBlocks.SCORCHED_BUTTON);
        SCORCHED_DOOR = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SCORCHED_DOOR, CinderscapesBlocks.SCORCHED_DOOR);
        SCORCHED_FENCE = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SCORCHED_FENCE, CinderscapesBlocks.SCORCHED_FENCE);
        SCORCHED_FENCE_GATE = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SCORCHED_FENCE_GATE, CinderscapesBlocks.SCORCHED_FENCE_GATE);
        SCORCHED_PRESSURE_PLATE = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SCORCHED_PRESSURE_PLATE, CinderscapesBlocks.SCORCHED_PRESSURE_PLATE);
        SCORCHED_SHELF = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SCORCHED_SHELF, CinderscapesBlocks.SCORCHED_SHELF);
        SCORCHED_TRAPDOOR = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SCORCHED_TRAPDOOR, CinderscapesBlocks.SCORCHED_TRAPDOOR);

        SCORCHED_SIGN = CinderscapesRegistry.register(CinderscapesBlockItemIds.SCORCHED_SIGN, settings -> new StandingAndWallBlockItem(CinderscapesBlocks.SCORCHED_SIGN, CinderscapesBlocks.SCORCHED_WALL_SIGN, Direction.DOWN, settings), new Item.Properties().stacksTo(16).useBlockDescriptionPrefix());
        SCORCHED_HANGING_SIGN = CinderscapesRegistry.register(CinderscapesBlockItemIds.SCORCHED_HANGING_SIGN, settings -> new HangingSignItem(CinderscapesBlocks.SCORCHED_HANGING_SIGN, CinderscapesBlocks.SCORCHED_WALL_HANGING_SIGN, settings), new Item.Properties().stacksTo(16).useBlockDescriptionPrefix());

        SCORCHED_SHRUB = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SCORCHED_SHRUB, CinderscapesBlocks.SCORCHED_SHRUB);
        SCORCHED_SPROUTS = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SCORCHED_SPROUTS, CinderscapesBlocks.SCORCHED_SPROUTS);
        SCORCHED_TENDRILS = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SCORCHED_TENDRILS, CinderscapesBlocks.SCORCHED_TENDRILS);

        ASH = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.ASH, CinderscapesBlocks.ASH);
        ASH_BLOCK = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.ASH_BLOCK, CinderscapesBlocks.ASH_BLOCK);

        PYRACINTH = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.PYRACINTH, CinderscapesBlocks.PYRACINTH);

        /*//////////////////
        // Luminous Grove //
        //////////////////*/

        // Umbral Nylia

        UMBRAL_STEM = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.UMBRAL_STEM, CinderscapesBlocks.UMBRAL_STEM);
        STRIPPED_UMBRAL_STEM = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.STRIPPED_UMBRAL_STEM, CinderscapesBlocks.STRIPPED_UMBRAL_STEM);

        UMBRAL_HYPHAE = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.UMBRAL_HYPHAE, CinderscapesBlocks.UMBRAL_HYPHAE);
        STRIPPED_UMBRAL_HYPHAE = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.STRIPPED_UMBRAL_HYPHAE, CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE);

        UMBRAL_NYLIUM = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.UMBRAL_NYLIUM, CinderscapesBlocks.UMBRAL_NYLIUM);

        UMBRAL_FUNGUS = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.UMBRAL_FUNGUS, CinderscapesBlocks.UMBRAL_FUNGUS);

        UMBRAL_WART_BLOCK = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.UMBRAL_WART_BLOCK, CinderscapesBlocks.UMBRAL_WART_BLOCK);
        UMBRAL_FLESH_BLOCK = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.UMBRAL_FLESH_BLOCK, CinderscapesBlocks.UMBRAL_FLESH_BLOCK);

        UMBRAL_PLANKS = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.UMBRAL_PLANKS, CinderscapesBlocks.UMBRAL_PLANKS);
        UMBRAL_SLAB = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.UMBRAL_SLAB, CinderscapesBlocks.UMBRAL_SLAB);
        UMBRAL_STAIRS = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.UMBRAL_STAIRS, CinderscapesBlocks.UMBRAL_STAIRS);

        UMBRAL_BUTTON = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.UMBRAL_BUTTON, CinderscapesBlocks.UMBRAL_BUTTON);
        UMBRAL_DOOR = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.UMBRAL_DOOR, CinderscapesBlocks.UMBRAL_DOOR);
        UMBRAL_FENCE = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.UMBRAL_FENCE, CinderscapesBlocks.UMBRAL_FENCE);
        UMBRAL_FENCE_GATE = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.UMBRAL_FENCE_GATE, CinderscapesBlocks.UMBRAL_FENCE_GATE);
        UMBRAL_PRESSURE_PLATE = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.UMBRAL_PRESSURE_PLATE, CinderscapesBlocks.UMBRAL_PRESSURE_PLATE);
        UMBRAL_SHELF = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.UMBRAL_SHELF, CinderscapesBlocks.UMBRAL_SHELF);
        UMBRAL_TRAPDOOR = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.UMBRAL_TRAPDOOR, CinderscapesBlocks.UMBRAL_TRAPDOOR);

        UMBRAL_SIGN = CinderscapesRegistry.register(CinderscapesBlockItemIds.UMBRAL_SIGN, settings -> new StandingAndWallBlockItem(CinderscapesBlocks.UMBRAL_SIGN, CinderscapesBlocks.UMBRAL_WALL_SIGN, Direction.DOWN, settings), new Item.Properties().stacksTo(16).useBlockDescriptionPrefix());
        UMBRAL_HANGING_SIGN = CinderscapesRegistry.register(CinderscapesBlockItemIds.UMBRAL_HANGING_SIGN, settings -> new HangingSignItem(CinderscapesBlocks.UMBRAL_HANGING_SIGN, CinderscapesBlocks.UMBRAL_WALL_HANGING_SIGN, settings), new Item.Properties().stacksTo(16).useBlockDescriptionPrefix());

        // Other

        TWILIGHT_VINE_BLOCK = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.TWILIGHT_VINE_BLOCK, CinderscapesBlocks.TWILIGHT_VINE_BLOCK);
        TWILIGHT_TENDRILS = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.TWILIGHT_TENDRILS, CinderscapesBlocks.TWILIGHT_TENDRILS);
        TWILIGHT_FESCUES = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.TWILIGHT_FESCUES, CinderscapesBlocks.TWILIGHT_FESCUES);
        PHOTOFERN = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.PHOTOFERN, CinderscapesBlocks.PHOTOFERN);
        TALL_PHOTOFERN = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.TALL_PHOTOFERN, CinderscapesBlocks.TALL_PHOTOFERN);

        LUMINOUS_POD = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.LUMINOUS_POD, CinderscapesBlocks.LUMINOUS_POD);
        GHASTLY_ECTOPLASM = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.GHASTLY_ECTOPLASM, CinderscapesBlocks.GHASTLY_ECTOPLASM);

        /*/////////
        // Other //
        /////////*/

        ASH_PILE = CinderscapesRegistry.register(CinderscapesItemIds.ASH_PILE, Item::new, new Item.Properties());

        BRAMBLE_BERRIES = CinderscapesRegistry.register(CinderscapesItemIds.BRAMBLE_BERRIES, settings -> new BlockItem(CinderscapesBlocks.BRAMBLE_BERRY_BUSH, settings.useItemDescriptionPrefix()), new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).alwaysEdible().build(), Consumables.defaultFood().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 0), 0.8F)).build()));

        NODZOL = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.NODZOL, CinderscapesBlocks.NODZOL);

        SULFUR = CinderscapesRegistry.register(CinderscapesItemIds.SULFUR, Item::new, new Item.Properties());

        SULFUR_BLOCK = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SULFUR_BLOCK, CinderscapesBlocks.SULFUR_BLOCK);
        SULFUR_ORE = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SULFUR_ORE, CinderscapesBlocks.SULFUR_ORE);

        ROSE_QUARTZ = CinderscapesRegistry.register(CinderscapesItemIds.ROSE_QUARTZ, Item::new, new Item.Properties().trimMaterial(CinderscapesTrimMaterials.ROSE_QUARTZ));
        SMOKY_QUARTZ = CinderscapesRegistry.register(CinderscapesItemIds.SMOKY_QUARTZ, Item::new, new Item.Properties().trimMaterial(CinderscapesTrimMaterials.SMOKY_QUARTZ));
        SULFUR_QUARTZ = CinderscapesRegistry.register(CinderscapesItemIds.SULFUR_QUARTZ, Item::new, new Item.Properties().trimMaterial(CinderscapesTrimMaterials.SULFUR_QUARTZ));

        /*/////////////////
        // Quartz Cavern //
        /////////////////*/

        CRYSTINIUM = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.CRYSTINIUM, CinderscapesBlocks.CRYSTINIUM);

        CRYSTALLINE_QUARTZ = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.CRYSTALLINE_QUARTZ, CinderscapesBlocks.CRYSTALLINE_QUARTZ);
        POLYPITE_QUARTZ = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.POLYPITE_QUARTZ, CinderscapesBlocks.POLYPITE_QUARTZ);

        // Sulfur Quartz

        SULFUR_QUARTZ_ORE = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SULFUR_QUARTZ_ORE, CinderscapesBlocks.SULFUR_QUARTZ_ORE);
        SULFUR_QUARTZ_BLOCK = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SULFUR_QUARTZ_BLOCK, CinderscapesBlocks.SULFUR_QUARTZ_BLOCK);
        CHISELED_SULFUR_QUARTZ_BLOCK = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.CHISELED_SULFUR_QUARTZ_BLOCK, CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK);
        SULFUR_QUARTZ_PILLAR = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SULFUR_QUARTZ_PILLAR, CinderscapesBlocks.SULFUR_QUARTZ_PILLAR);
        SULFUR_QUARTZ_STAIRS = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SULFUR_QUARTZ_STAIRS, CinderscapesBlocks.SULFUR_QUARTZ_STAIRS);
        SULFUR_QUARTZ_SLAB = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SULFUR_QUARTZ_SLAB, CinderscapesBlocks.SULFUR_QUARTZ_SLAB);
        SMOOTH_SULFUR_QUARTZ = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SMOOTH_SULFUR_QUARTZ, CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ);
        SMOOTH_SULFUR_QUARTZ_STAIRS = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SMOOTH_SULFUR_QUARTZ_STAIRS, CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_STAIRS);
        SMOOTH_SULFUR_QUARTZ_SLAB = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SMOOTH_SULFUR_QUARTZ_SLAB, CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_SLAB);
        SULFUR_QUARTZ_BRICKS = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SULFUR_QUARTZ_BRICKS, CinderscapesBlocks.SULFUR_QUARTZ_BRICKS);

        CRYSTALLINE_SULFUR_QUARTZ = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.CRYSTALLINE_SULFUR_QUARTZ, CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ);
        POLYPITE_SULFUR_QUARTZ = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.POLYPITE_SULFUR_QUARTZ, CinderscapesBlocks.POLYPITE_SULFUR_QUARTZ);

        // Rose Quartz

        ROSE_QUARTZ_ORE = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.ROSE_QUARTZ_ORE, CinderscapesBlocks.ROSE_QUARTZ_ORE);
        ROSE_QUARTZ_BLOCK = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.ROSE_QUARTZ_BLOCK, CinderscapesBlocks.ROSE_QUARTZ_BLOCK);
        CHISELED_ROSE_QUARTZ_BLOCK = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.CHISELED_ROSE_QUARTZ_BLOCK, CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK);
        ROSE_QUARTZ_PILLAR = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.ROSE_QUARTZ_PILLAR, CinderscapesBlocks.ROSE_QUARTZ_PILLAR);
        ROSE_QUARTZ_STAIRS = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.ROSE_QUARTZ_STAIRS, CinderscapesBlocks.ROSE_QUARTZ_STAIRS);
        ROSE_QUARTZ_SLAB = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.ROSE_QUARTZ_SLAB, CinderscapesBlocks.ROSE_QUARTZ_SLAB);
        SMOOTH_ROSE_QUARTZ = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SMOOTH_ROSE_QUARTZ, CinderscapesBlocks.SMOOTH_ROSE_QUARTZ);
        SMOOTH_ROSE_QUARTZ_STAIRS = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SMOOTH_ROSE_QUARTZ_STAIRS, CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_STAIRS);
        SMOOTH_ROSE_QUARTZ_SLAB = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SMOOTH_ROSE_QUARTZ_SLAB, CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_SLAB);
        ROSE_QUARTZ_BRICKS = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.ROSE_QUARTZ_BRICKS, CinderscapesBlocks.ROSE_QUARTZ_BRICKS);

        CRYSTALLINE_ROSE_QUARTZ = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.CRYSTALLINE_ROSE_QUARTZ, CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ);
        POLYPITE_ROSE_QUARTZ = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.POLYPITE_ROSE_QUARTZ, CinderscapesBlocks.POLYPITE_ROSE_QUARTZ);

        // Smoky Quartz

        SMOKY_QUARTZ_ORE = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SMOKY_QUARTZ_ORE, CinderscapesBlocks.SMOKY_QUARTZ_ORE);
        SMOKY_QUARTZ_BLOCK = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SMOKY_QUARTZ_BLOCK, CinderscapesBlocks.SMOKY_QUARTZ_BLOCK);
        CHISELED_SMOKY_QUARTZ_BLOCK = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.CHISELED_SMOKY_QUARTZ_BLOCK, CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK);
        SMOKY_QUARTZ_PILLAR = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SMOKY_QUARTZ_PILLAR, CinderscapesBlocks.SMOKY_QUARTZ_PILLAR);
        SMOKY_QUARTZ_STAIRS = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SMOKY_QUARTZ_STAIRS, CinderscapesBlocks.SMOKY_QUARTZ_STAIRS);
        SMOKY_QUARTZ_SLAB = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SMOKY_QUARTZ_SLAB, CinderscapesBlocks.SMOKY_QUARTZ_SLAB);
        SMOOTH_SMOKY_QUARTZ = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SMOOTH_SMOKY_QUARTZ, CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ);
        SMOOTH_SMOKY_QUARTZ_STAIRS = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SMOOTH_SMOKY_QUARTZ_STAIRS, CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_STAIRS);
        SMOOTH_SMOKY_QUARTZ_SLAB = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SMOOTH_SMOKY_QUARTZ_SLAB, CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_SLAB);
        SMOKY_QUARTZ_BRICKS = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.SMOKY_QUARTZ_BRICKS, CinderscapesBlocks.SMOKY_QUARTZ_BRICKS);

        CRYSTALLINE_SMOKY_QUARTZ = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.CRYSTALLINE_SMOKY_QUARTZ, CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ);
        POLYPITE_SMOKY_QUARTZ = CinderscapesRegistry.registerBlockItem(CinderscapesBlockItemIds.POLYPITE_SMOKY_QUARTZ, CinderscapesBlocks.POLYPITE_SMOKY_QUARTZ);

        addCompostables();
    }

    private static void addCompostables() {
        Collection<Item> berries = List.of(
                BRAMBLE_BERRIES
        );

        Collection<Item> grass = List.of(
                SCORCHED_SHRUB,
                SCORCHED_SPROUTS,
                SCORCHED_TENDRILS,
                TWILIGHT_FESCUES,
                TWILIGHT_TENDRILS
        );

        Collection<Item> flowers = List.of(
                CRYSTINIUM,
                GHASTLY_ECTOPLASM,
                LUMINOUS_POD,
                PHOTOFERN,
                PYRACINTH,
                TALL_PHOTOFERN,
                UMBRAL_FUNGUS
        );

        Collection<Item> wartBlocks = List.of(
                TWILIGHT_VINE_BLOCK,
                UMBRAL_FLESH_BLOCK,
                UMBRAL_WART_BLOCK
        );

        DefaultItemComponentEvents.MODIFY.register(modifyContext -> {
            modifyContext.modify(berries, (builder, _, _) ->
                    builder.set(DataComponents.COMPOSTABLE,
                            new Compostable(ContextIntProviders.COMPOSTABLE_LOW))
            );

            modifyContext.modify(grass, (builder, _, _) ->
                    builder.set(DataComponents.COMPOSTABLE,
                            new Compostable(ContextIntProviders.COMPOSTABLE_LOW))
            );

            modifyContext.modify(flowers, (builder, _, _) ->
                    builder.set(DataComponents.COMPOSTABLE,
                            new Compostable(ContextIntProviders.COMPOSTABLE_MEDIUM))
            );

            modifyContext.modify(wartBlocks, (builder, _, _) ->
                    builder.set(DataComponents.COMPOSTABLE,
                            new Compostable(ContextIntProviders.COMPOSTABLE_MEDIUM_HIGH))
            );
        });
    }
}
