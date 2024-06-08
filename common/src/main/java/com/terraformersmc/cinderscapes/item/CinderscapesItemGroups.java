package com.terraformersmc.cinderscapes.item;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.config.CinderscapesConfig;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.init.CinderscapesItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;

public class CinderscapesItemGroups {
	private static final RegistryKey<ItemGroup> ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(Cinderscapes.MOD_ID, "items"));
	private static final HashMap<RegistryKey<ItemGroup>, HashMap<ItemConvertible, ItemGroupEntries>> ITEM_GROUP_ENTRY_MAPS;

	static {
		ITEM_GROUP_ENTRY_MAPS = new HashMap<>(8);

		/*
		 * These items are the last Vanilla item of a "similar" type to items we add to Vanilla groups.
		 * Each is used to build a collection of items which will be inserted below the Vanilla item.
		 */
		final Item BUILDING_NETHER_WOOD = Items.WARPED_BUTTON;
		final Item BUILDING_NETHER_QUARTZ = Items.SMOOTH_QUARTZ_SLAB;
		final Item BUILDING_NETHER_STORAGE_BLOCK = Items.NETHERITE_BLOCK;
		final Item FUNCTIONAL_NETHER_SIGN = Items.WARPED_HANGING_SIGN;
		final Item NATURAL_NYLIUM = Items.WARPED_NYLIUM;
		final Item NATURAL_SNOWLIKE = Items.MOSS_CARPET;
		final Item NATURAL_QUARTZ_ORE = Items.NETHER_QUARTZ_ORE;
		final Item NATURAL_FUNGUS = Items.WARPED_FUNGUS;
		final Item NATURAL_STEM = Items.WARPED_STEM;
		final Item NATURAL_WART_BLOCK = Items.WARPED_WART_BLOCK;
		final Item NATURAL_NETHER_VEGETATION = Items.NETHER_SPROUTS;
		final Item NATURAL_TALL_VEGETATION = Items.LARGE_FERN;
		final Item NATURAL_BERRIES = Items.SWEET_BERRIES;
		final Item FOOD_BERRIES = Items.GLOW_BERRIES;
		final Item INGREDIENTS_QUARTZ = Items.QUARTZ;


		/*
		 * For each Vanilla item group, add the same kinds of items Vanilla adds.
		 * Since Minecraft 1.19.3, items are often in multiple item groups...
		 */

		// BUILDING BLOCKS

		// Wood items
		addGroupEntry(CinderscapesBlocks.SCORCHED_STEM, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addGroupEntry(CinderscapesBlocks.SCORCHED_HYPHAE, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addGroupEntry(CinderscapesBlocks.STRIPPED_SCORCHED_STEM, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addGroupEntry(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addGroupEntry(CinderscapesBlocks.SCORCHED_PLANKS, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addGroupEntry(CinderscapesBlocks.SCORCHED_STAIRS, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addGroupEntry(CinderscapesBlocks.SCORCHED_SLAB, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addGroupEntry(CinderscapesBlocks.SCORCHED_FENCE, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addGroupEntry(CinderscapesBlocks.SCORCHED_FENCE_GATE, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addGroupEntry(CinderscapesBlocks.SCORCHED_DOOR, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addGroupEntry(CinderscapesBlocks.SCORCHED_TRAPDOOR, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addGroupEntry(CinderscapesBlocks.SCORCHED_PRESSURE_PLATE, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addGroupEntry(CinderscapesBlocks.SCORCHED_BUTTON, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);

		addGroupEntry(CinderscapesBlocks.UMBRAL_STEM, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addGroupEntry(CinderscapesBlocks.UMBRAL_HYPHAE, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addGroupEntry(CinderscapesBlocks.STRIPPED_UMBRAL_STEM, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addGroupEntry(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addGroupEntry(CinderscapesBlocks.UMBRAL_PLANKS, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addGroupEntry(CinderscapesBlocks.UMBRAL_STAIRS, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addGroupEntry(CinderscapesBlocks.UMBRAL_SLAB, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addGroupEntry(CinderscapesBlocks.UMBRAL_FENCE, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addGroupEntry(CinderscapesBlocks.UMBRAL_FENCE_GATE, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addGroupEntry(CinderscapesBlocks.UMBRAL_DOOR, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addGroupEntry(CinderscapesBlocks.UMBRAL_TRAPDOOR, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addGroupEntry(CinderscapesBlocks.UMBRAL_PRESSURE_PLATE, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addGroupEntry(CinderscapesBlocks.UMBRAL_BUTTON, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);

		// Quartz Items
		addGroupEntry(CinderscapesBlocks.CRYSTALLINE_QUARTZ, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);

		addGroupEntry(CinderscapesBlocks.SULFUR_QUARTZ_BLOCK, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addGroupEntry(CinderscapesBlocks.SULFUR_QUARTZ_STAIRS, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addGroupEntry(CinderscapesBlocks.SULFUR_QUARTZ_SLAB, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addGroupEntry(CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addGroupEntry(CinderscapesBlocks.SULFUR_QUARTZ_BRICKS, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addGroupEntry(CinderscapesBlocks.SULFUR_QUARTZ_PILLAR, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addGroupEntry(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addGroupEntry(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_STAIRS, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addGroupEntry(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_SLAB, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addGroupEntry(CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);

		addGroupEntry(CinderscapesBlocks.ROSE_QUARTZ_BLOCK, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addGroupEntry(CinderscapesBlocks.ROSE_QUARTZ_STAIRS, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addGroupEntry(CinderscapesBlocks.ROSE_QUARTZ_SLAB, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addGroupEntry(CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addGroupEntry(CinderscapesBlocks.ROSE_QUARTZ_BRICKS, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addGroupEntry(CinderscapesBlocks.ROSE_QUARTZ_PILLAR, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addGroupEntry(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addGroupEntry(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_STAIRS, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addGroupEntry(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_SLAB, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addGroupEntry(CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);

		addGroupEntry(CinderscapesBlocks.SMOKY_QUARTZ_BLOCK, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addGroupEntry(CinderscapesBlocks.SMOKY_QUARTZ_STAIRS, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addGroupEntry(CinderscapesBlocks.SMOKY_QUARTZ_SLAB, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addGroupEntry(CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addGroupEntry(CinderscapesBlocks.SMOKY_QUARTZ_BRICKS, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addGroupEntry(CinderscapesBlocks.SMOKY_QUARTZ_PILLAR, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addGroupEntry(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addGroupEntry(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_STAIRS, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addGroupEntry(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_SLAB, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addGroupEntry(CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);

		// Storage Blocks
		addGroupEntry(CinderscapesBlocks.SULFUR_BLOCK, ItemGroups.BUILDING_BLOCKS, BUILDING_NETHER_STORAGE_BLOCK);


		// NATURAL

		// Ores
		addGroupEntry(CinderscapesBlocks.SULFUR_QUARTZ_ORE, ItemGroups.NATURAL, NATURAL_QUARTZ_ORE);
		addGroupEntry(CinderscapesBlocks.ROSE_QUARTZ_ORE, ItemGroups.NATURAL, NATURAL_QUARTZ_ORE);
		addGroupEntry(CinderscapesBlocks.SMOKY_QUARTZ_ORE, ItemGroups.NATURAL, NATURAL_QUARTZ_ORE);
		addGroupEntry(CinderscapesBlocks.SULFUR_ORE, ItemGroups.NATURAL, NATURAL_QUARTZ_ORE);
		addGroupEntry(CinderscapesBlocks.SULFUR_BLOCK, ItemGroups.NATURAL, NATURAL_QUARTZ_ORE);

		// Snow-like
		addGroupEntry(CinderscapesBlocks.ASH_BLOCK, ItemGroups.NATURAL, NATURAL_SNOWLIKE);
		addGroupEntry(CinderscapesBlocks.ASH, ItemGroups.NATURAL, NATURAL_SNOWLIKE);

		// Nylium
		addGroupEntry(CinderscapesBlocks.UMBRAL_NYLIUM, ItemGroups.NATURAL, NATURAL_NYLIUM);
		if (CinderscapesConfig.INSTANCE.easterEggs) {
			addGroupEntry(CinderscapesBlocks.NODZOL, ItemGroups.NATURAL, NATURAL_NYLIUM);
		}

		// Stems and worldgen Hyphae
		addGroupEntry(CinderscapesBlocks.SCORCHED_STEM, ItemGroups.NATURAL, NATURAL_STEM);
		addGroupEntry(CinderscapesBlocks.SCORCHED_HYPHAE, ItemGroups.NATURAL, NATURAL_STEM);
		addGroupEntry(CinderscapesBlocks.UMBRAL_STEM, ItemGroups.NATURAL, NATURAL_STEM);
		addGroupEntry(CinderscapesBlocks.UMBRAL_HYPHAE, ItemGroups.NATURAL, NATURAL_STEM);

		// Fungus
		addGroupEntry(CinderscapesBlocks.UMBRAL_FUNGUS, ItemGroups.NATURAL, NATURAL_FUNGUS);

		// Wart
		addGroupEntry(CinderscapesBlocks.UMBRAL_WART_BLOCK, ItemGroups.NATURAL, NATURAL_WART_BLOCK);
		addGroupEntry(CinderscapesBlocks.UMBRAL_FLESH_BLOCK, ItemGroups.NATURAL, NATURAL_WART_BLOCK);

		// Vegetation
		addGroupEntry(CinderscapesBlocks.TWILIGHT_FESCUES, ItemGroups.NATURAL, NATURAL_NETHER_VEGETATION);
		addGroupEntry(CinderscapesBlocks.TWILIGHT_TENDRILS, ItemGroups.NATURAL, NATURAL_NETHER_VEGETATION);
		addGroupEntry(CinderscapesBlocks.SCORCHED_SPROUTS, ItemGroups.NATURAL, NATURAL_NETHER_VEGETATION);
		addGroupEntry(CinderscapesBlocks.SCORCHED_TENDRILS, ItemGroups.NATURAL, NATURAL_NETHER_VEGETATION);
		addGroupEntry(CinderscapesBlocks.PHOTOFERN, ItemGroups.NATURAL, NATURAL_NETHER_VEGETATION);
		addGroupEntry(CinderscapesBlocks.SCORCHED_SHRUB, ItemGroups.NATURAL, NATURAL_NETHER_VEGETATION);
		addGroupEntry(CinderscapesBlocks.PYRACINTH, ItemGroups.NATURAL, NATURAL_NETHER_VEGETATION);
		addGroupEntry(CinderscapesBlocks.CRYSTINIUM, ItemGroups.NATURAL, NATURAL_NETHER_VEGETATION);
		addGroupEntry(CinderscapesBlocks.POLYPITE_QUARTZ, ItemGroups.NATURAL, NATURAL_NETHER_VEGETATION);
		addGroupEntry(CinderscapesBlocks.POLYPITE_SULFUR_QUARTZ, ItemGroups.NATURAL, NATURAL_NETHER_VEGETATION);
		addGroupEntry(CinderscapesBlocks.POLYPITE_ROSE_QUARTZ, ItemGroups.NATURAL, NATURAL_NETHER_VEGETATION);
		addGroupEntry(CinderscapesBlocks.POLYPITE_SMOKY_QUARTZ, ItemGroups.NATURAL, NATURAL_NETHER_VEGETATION);
		addGroupEntry(CinderscapesBlocks.TWILIGHT_VINE_BLOCK, ItemGroups.NATURAL, NATURAL_NETHER_VEGETATION);
		addGroupEntry(CinderscapesBlocks.GHASTLY_ECTOPLASM, ItemGroups.NATURAL, NATURAL_NETHER_VEGETATION);

		// Tall Plants
		addGroupEntry(CinderscapesBlocks.TALL_PHOTOFERN, ItemGroups.NATURAL, NATURAL_TALL_VEGETATION);
		addGroupEntry(CinderscapesBlocks.LUMINOUS_POD, ItemGroups.NATURAL, NATURAL_TALL_VEGETATION);

		// Berries
		addGroupEntry(CinderscapesItems.BRAMBLE_BERRIES, ItemGroups.NATURAL, NATURAL_BERRIES);


		// FUNCTIONAL

		// Wood Items
		addGroupEntry(CinderscapesBlocks.SCORCHED_SIGN, ItemGroups.FUNCTIONAL, FUNCTIONAL_NETHER_SIGN);
		addGroupEntry(CinderscapesBlocks.SCORCHED_HANGING_SIGN, ItemGroups.FUNCTIONAL, FUNCTIONAL_NETHER_SIGN);
		addGroupEntry(CinderscapesBlocks.UMBRAL_SIGN, ItemGroups.FUNCTIONAL, FUNCTIONAL_NETHER_SIGN);
		addGroupEntry(CinderscapesBlocks.UMBRAL_HANGING_SIGN, ItemGroups.FUNCTIONAL, FUNCTIONAL_NETHER_SIGN);


		// REDSTONE


		// HOTBAR


		// SEARCH


		// TOOLS


		// COMBAT


		// FOOD AND DRINK

		// Berries
		addGroupEntry(CinderscapesItems.BRAMBLE_BERRIES, ItemGroups.FOOD_AND_DRINK, FOOD_BERRIES);


		// INGREDIENTS

		// Quartz
		addGroupEntry(CinderscapesItems.SULFUR_QUARTZ, ItemGroups.INGREDIENTS, INGREDIENTS_QUARTZ);
		addGroupEntry(CinderscapesItems.ROSE_QUARTZ, ItemGroups.INGREDIENTS, INGREDIENTS_QUARTZ);
		addGroupEntry(CinderscapesItems.SMOKY_QUARTZ, ItemGroups.INGREDIENTS, INGREDIENTS_QUARTZ);
		addGroupEntry(CinderscapesItems.SULFUR, ItemGroups.INGREDIENTS, INGREDIENTS_QUARTZ);

		// SPAWN EGGS


		// INVENTORY


		/*
		 * Add the items configured above to the Vanilla item groups.
		 */
		for (RegistryKey<ItemGroup> group : ITEM_GROUP_ENTRY_MAPS.keySet()) {
			ItemGroupEvents.modifyEntriesEvent(group).register((content) -> {
				FeatureSet featureSet = content.getEnabledFeatures();
				HashMap<ItemConvertible, ItemGroupEntries> entryMap = ITEM_GROUP_ENTRY_MAPS.get(group);

				for (ItemConvertible relative : entryMap.keySet()) {
					ItemGroupEntries entries = entryMap.get(relative);

					// FAPI does not give us a way to add at a feature-flag-disabled location.
					// So, below we have to adjust for any items which may be disabled.
					if (relative == null) {
						// Target the end of the Item Group
						content.addAll(entries.getCollection());
					} else {
						//Cinderscapes.LOGGER.warn("About to add to Vanilla Item Group '{}' after Item '{}': '{}'", group.getId(), relative, entries.getCollection().stream().map(ItemStack::getItem).collect(Collectors.toList()));
						content.addAfter(relative, entries.getCollection());
					}
				}
			});
		}


		/*
		 * Also add all the items to Cinderscapes' own item group.
		 */
		Registry.register(Registries.ITEM_GROUP, ITEM_GROUP, FabricItemGroup.builder()
				.displayName(Text.literal("Cinderscapes"))
				.icon(() -> CinderscapesBlocks.UMBRAL_FUNGUS.asItem().getDefaultStack())
				.entries((context, entries) -> {
					ITEM_GROUP_ENTRY_MAPS.values().stream()
							.map(HashMap::values).flatMap(Collection::stream)
							.map(ItemGroupEntries::getCollection).flatMap(Collection::stream)
							.collect(Collectors.groupingByConcurrent(ItemStack::getItem)).keySet().stream()
							.sorted(Comparator.comparing((item) -> item.getName().getString())).forEach(entries::add);
				}).build()
		);
	}

	public static void addGroupEntry(ItemConvertible item, RegistryKey<ItemGroup> group) {
		// Appends the item to the bottom of the group.
		addGroupEntry(item, group, null);
	}

	public static void addGroupEntry(ItemConvertible item, RegistryKey<ItemGroup> group, @Nullable ItemConvertible relative) {
		HashMap<ItemConvertible, ItemGroupEntries> entryMap = ITEM_GROUP_ENTRY_MAPS.computeIfAbsent(group, (key) -> new HashMap<>(32));
		ItemGroupEntries entries = entryMap.computeIfAbsent(relative, ItemGroupEntries::empty);
		entries.addItem(item);
	}

	public static void init() { }
}
