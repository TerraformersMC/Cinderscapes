package com.terraformersmc.cinderscapes.item;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.config.CinderscapesConfig;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.init.CinderscapesItems;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import org.jspecify.annotations.Nullable;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;

public class CinderscapesCreativeModeTabs {
	private static final ResourceKey<CreativeModeTab> CREATIVE_MODE_TAB = ResourceKey.create(Registries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, "items"));
	private static final HashMap<ResourceKey<CreativeModeTab>, HashMap<ItemLike, CreativeModeTabEntries>> CREATIVE_MODE_TAB_MAPS;

	static {
		CREATIVE_MODE_TAB_MAPS = new HashMap<>(8);

		/*
		 * These items are the last Vanilla item of a "similar" type to items we add to Vanilla groups.
		 * Each is used to build a collection of items which will be inserted below the Vanilla item.
		 */
		final Item BUILDING_NETHER_WOOD = Items.WARPED_BUTTON;
		final Item BUILDING_NETHER_QUARTZ = Items.SMOOTH_QUARTZ_SLAB;
		final Item BUILDING_NETHER_STORAGE_BLOCK = Items.NETHERITE_BLOCK;
		final Item FUNCTIONAL_NETHER_SIGN = Items.WARPED_HANGING_SIGN;
		final Item FUNCTIONAL_NETHER_SHELF = Items.WARPED_SHELF;
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
		addTabEntry(CinderscapesBlocks.SCORCHED_STEM, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addTabEntry(CinderscapesBlocks.SCORCHED_HYPHAE, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addTabEntry(CinderscapesBlocks.STRIPPED_SCORCHED_STEM, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addTabEntry(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addTabEntry(CinderscapesBlocks.SCORCHED_PLANKS, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addTabEntry(CinderscapesBlocks.SCORCHED_STAIRS, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addTabEntry(CinderscapesBlocks.SCORCHED_SLAB, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addTabEntry(CinderscapesBlocks.SCORCHED_FENCE, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addTabEntry(CinderscapesBlocks.SCORCHED_FENCE_GATE, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addTabEntry(CinderscapesBlocks.SCORCHED_DOOR, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addTabEntry(CinderscapesBlocks.SCORCHED_TRAPDOOR, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addTabEntry(CinderscapesBlocks.SCORCHED_PRESSURE_PLATE, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addTabEntry(CinderscapesBlocks.SCORCHED_BUTTON, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);

		addTabEntry(CinderscapesBlocks.UMBRAL_STEM, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addTabEntry(CinderscapesBlocks.UMBRAL_HYPHAE, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addTabEntry(CinderscapesBlocks.STRIPPED_UMBRAL_STEM, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addTabEntry(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addTabEntry(CinderscapesBlocks.UMBRAL_PLANKS, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addTabEntry(CinderscapesBlocks.UMBRAL_STAIRS, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addTabEntry(CinderscapesBlocks.UMBRAL_SLAB, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addTabEntry(CinderscapesBlocks.UMBRAL_FENCE, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addTabEntry(CinderscapesBlocks.UMBRAL_FENCE_GATE, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addTabEntry(CinderscapesBlocks.UMBRAL_DOOR, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addTabEntry(CinderscapesBlocks.UMBRAL_TRAPDOOR, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addTabEntry(CinderscapesBlocks.UMBRAL_PRESSURE_PLATE, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);
		addTabEntry(CinderscapesBlocks.UMBRAL_BUTTON, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_WOOD);

		// Quartz Items
		addTabEntry(CinderscapesBlocks.CRYSTALLINE_QUARTZ, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);

		addTabEntry(CinderscapesBlocks.SULFUR_QUARTZ_BLOCK, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addTabEntry(CinderscapesBlocks.SULFUR_QUARTZ_STAIRS, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addTabEntry(CinderscapesBlocks.SULFUR_QUARTZ_SLAB, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addTabEntry(CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addTabEntry(CinderscapesBlocks.SULFUR_QUARTZ_BRICKS, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addTabEntry(CinderscapesBlocks.SULFUR_QUARTZ_PILLAR, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addTabEntry(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addTabEntry(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_STAIRS, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addTabEntry(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_SLAB, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addTabEntry(CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);

		addTabEntry(CinderscapesBlocks.ROSE_QUARTZ_BLOCK, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addTabEntry(CinderscapesBlocks.ROSE_QUARTZ_STAIRS, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addTabEntry(CinderscapesBlocks.ROSE_QUARTZ_SLAB, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addTabEntry(CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addTabEntry(CinderscapesBlocks.ROSE_QUARTZ_BRICKS, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addTabEntry(CinderscapesBlocks.ROSE_QUARTZ_PILLAR, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addTabEntry(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addTabEntry(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_STAIRS, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addTabEntry(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_SLAB, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addTabEntry(CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);

		addTabEntry(CinderscapesBlocks.SMOKY_QUARTZ_BLOCK, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addTabEntry(CinderscapesBlocks.SMOKY_QUARTZ_STAIRS, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addTabEntry(CinderscapesBlocks.SMOKY_QUARTZ_SLAB, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addTabEntry(CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addTabEntry(CinderscapesBlocks.SMOKY_QUARTZ_BRICKS, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addTabEntry(CinderscapesBlocks.SMOKY_QUARTZ_PILLAR, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addTabEntry(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addTabEntry(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_STAIRS, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addTabEntry(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_SLAB, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);
		addTabEntry(CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_QUARTZ);

		// Storage Blocks
		addTabEntry(CinderscapesBlocks.SULFUR_BLOCK, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_NETHER_STORAGE_BLOCK);


		// NATURAL

		// Ores
		addTabEntry(CinderscapesBlocks.SULFUR_QUARTZ_ORE, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_QUARTZ_ORE);
		addTabEntry(CinderscapesBlocks.ROSE_QUARTZ_ORE, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_QUARTZ_ORE);
		addTabEntry(CinderscapesBlocks.SMOKY_QUARTZ_ORE, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_QUARTZ_ORE);
		addTabEntry(CinderscapesBlocks.SULFUR_ORE, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_QUARTZ_ORE);
		addTabEntry(CinderscapesBlocks.SULFUR_BLOCK, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_QUARTZ_ORE);

		// Snow-like
		addTabEntry(CinderscapesBlocks.ASH_BLOCK, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_SNOWLIKE);
		addTabEntry(CinderscapesBlocks.ASH, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_SNOWLIKE);

		// Nylium
		addTabEntry(CinderscapesBlocks.UMBRAL_NYLIUM, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_NYLIUM);
		if (CinderscapesConfig.INSTANCE.easterEggs) {
			addTabEntry(CinderscapesBlocks.NODZOL, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_NYLIUM);
		}

		// Stems and worldgen Hyphae
		addTabEntry(CinderscapesBlocks.SCORCHED_STEM, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_STEM);
		addTabEntry(CinderscapesBlocks.SCORCHED_HYPHAE, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_STEM);
		addTabEntry(CinderscapesBlocks.UMBRAL_STEM, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_STEM);
		addTabEntry(CinderscapesBlocks.UMBRAL_HYPHAE, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_STEM);

		// Fungus
		addTabEntry(CinderscapesBlocks.UMBRAL_FUNGUS, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_FUNGUS);

		// Wart
		addTabEntry(CinderscapesBlocks.UMBRAL_WART_BLOCK, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_WART_BLOCK);
		addTabEntry(CinderscapesBlocks.UMBRAL_FLESH_BLOCK, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_WART_BLOCK);

		// Vegetation
		addTabEntry(CinderscapesBlocks.TWILIGHT_FESCUES, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_NETHER_VEGETATION);
		addTabEntry(CinderscapesBlocks.TWILIGHT_TENDRILS, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_NETHER_VEGETATION);
		addTabEntry(CinderscapesBlocks.SCORCHED_SPROUTS, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_NETHER_VEGETATION);
		addTabEntry(CinderscapesBlocks.SCORCHED_TENDRILS, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_NETHER_VEGETATION);
		addTabEntry(CinderscapesBlocks.PHOTOFERN, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_NETHER_VEGETATION);
		addTabEntry(CinderscapesBlocks.SCORCHED_SHRUB, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_NETHER_VEGETATION);
		addTabEntry(CinderscapesBlocks.PYRACINTH, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_NETHER_VEGETATION);
		addTabEntry(CinderscapesBlocks.CRYSTINIUM, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_NETHER_VEGETATION);
		addTabEntry(CinderscapesBlocks.POLYPITE_QUARTZ, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_NETHER_VEGETATION);
		addTabEntry(CinderscapesBlocks.POLYPITE_SULFUR_QUARTZ, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_NETHER_VEGETATION);
		addTabEntry(CinderscapesBlocks.POLYPITE_ROSE_QUARTZ, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_NETHER_VEGETATION);
		addTabEntry(CinderscapesBlocks.POLYPITE_SMOKY_QUARTZ, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_NETHER_VEGETATION);
		addTabEntry(CinderscapesBlocks.TWILIGHT_VINE_BLOCK, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_NETHER_VEGETATION);
		addTabEntry(CinderscapesBlocks.GHASTLY_ECTOPLASM, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_NETHER_VEGETATION);

		// Tall Plants
		addTabEntry(CinderscapesBlocks.TALL_PHOTOFERN, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_TALL_VEGETATION);
		addTabEntry(CinderscapesBlocks.LUMINOUS_POD, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_TALL_VEGETATION);

		// Berries
		addTabEntry(CinderscapesItems.BRAMBLE_BERRIES, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_BERRIES);


		// FUNCTIONAL

		// Wood Items
		addTabEntry(CinderscapesBlocks.SCORCHED_SHELF, CreativeModeTabs.FUNCTIONAL_BLOCKS, FUNCTIONAL_NETHER_SHELF);
		addTabEntry(CinderscapesBlocks.SCORCHED_SIGN, CreativeModeTabs.FUNCTIONAL_BLOCKS, FUNCTIONAL_NETHER_SIGN);
		addTabEntry(CinderscapesBlocks.SCORCHED_HANGING_SIGN, CreativeModeTabs.FUNCTIONAL_BLOCKS, FUNCTIONAL_NETHER_SIGN);
		addTabEntry(CinderscapesBlocks.UMBRAL_SHELF, CreativeModeTabs.FUNCTIONAL_BLOCKS, FUNCTIONAL_NETHER_SHELF);
		addTabEntry(CinderscapesBlocks.UMBRAL_SIGN, CreativeModeTabs.FUNCTIONAL_BLOCKS, FUNCTIONAL_NETHER_SIGN);
		addTabEntry(CinderscapesBlocks.UMBRAL_HANGING_SIGN, CreativeModeTabs.FUNCTIONAL_BLOCKS, FUNCTIONAL_NETHER_SIGN);


		// REDSTONE


		// HOTBAR


		// SEARCH


		// TOOLS


		// COMBAT


		// FOOD AND DRINK

		// Berries
		addTabEntry(CinderscapesItems.BRAMBLE_BERRIES, CreativeModeTabs.FOOD_AND_DRINKS, FOOD_BERRIES);


		// INGREDIENTS

		// Quartz
		addTabEntry(CinderscapesItems.SULFUR_QUARTZ, CreativeModeTabs.INGREDIENTS, INGREDIENTS_QUARTZ);
		addTabEntry(CinderscapesItems.ROSE_QUARTZ, CreativeModeTabs.INGREDIENTS, INGREDIENTS_QUARTZ);
		addTabEntry(CinderscapesItems.SMOKY_QUARTZ, CreativeModeTabs.INGREDIENTS, INGREDIENTS_QUARTZ);
		addTabEntry(CinderscapesItems.SULFUR, CreativeModeTabs.INGREDIENTS, INGREDIENTS_QUARTZ);

		// SPAWN EGGS


		// INVENTORY


		/*
		 * Add the items configured above to the Vanilla item groups.
		 */
		for (ResourceKey<CreativeModeTab> group : CREATIVE_MODE_TAB_MAPS.keySet()) {
			CreativeModeTabEvents.modifyOutputEvent(group).register((output) -> {
				FeatureFlagSet featureSet = output.getEnabledFeatures();
				HashMap<ItemLike, CreativeModeTabEntries> entryMap = CREATIVE_MODE_TAB_MAPS.get(group);

				for (ItemLike relative : entryMap.keySet()) {
					CreativeModeTabEntries entries = entryMap.get(relative);

					// FAPI does not give us a way to add at a feature-flag-disabled location.
					// So, below we have to adjust for any items which may be disabled.
					if (relative == null) {
						// Target the end of the Item Group
						output.acceptAll(entries.getStackCollection());
					} else {
						//Cinderscapes.LOGGER.warn("About to add to Vanilla Item Group '{}' after Item '{}': '{}'", group.getId(), relative, entries.getCollection().stream().map(ItemStack::getItem).collect(Collectors.toList()));
						output.insertAfter(relative, entries.getStackCollection());
					}
				}
			});
		}


		/*
		 * Also add all the items to Cinderscapes' own item group.
		 */
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CREATIVE_MODE_TAB, FabricCreativeModeTab.builder()
				.title(Component.literal("Cinderscapes"))
				.icon(() -> CinderscapesBlocks.UMBRAL_FUNGUS.asItem().getDefaultInstance())
				.displayItems((context, output) ->
					CREATIVE_MODE_TAB_MAPS.values().stream()
                        	.map(HashMap::values).flatMap(Collection::stream)
							.flatMap(CreativeModeTabEntries::getItemStream).distinct()
							.sorted(Comparator.comparing(ItemLike::toString))
							.forEach(output::accept)
				).build()
		);
	}

	public static void addTabEntry(ItemLike item, ResourceKey<CreativeModeTab> group) {
		// Appends the item to the bottom of the group.
		addTabEntry(item, group, null);
	}

	public static void addTabEntry(ItemLike item, ResourceKey<CreativeModeTab> group, @Nullable ItemLike relative) {
		HashMap<ItemLike, CreativeModeTabEntries> entryMap = CREATIVE_MODE_TAB_MAPS.computeIfAbsent(group, (key) -> new HashMap<>(32));
		CreativeModeTabEntries entries = entryMap.computeIfAbsent(relative, CreativeModeTabEntries::empty);
		entries.addItem(item);
	}

	public static void init() { }
}
