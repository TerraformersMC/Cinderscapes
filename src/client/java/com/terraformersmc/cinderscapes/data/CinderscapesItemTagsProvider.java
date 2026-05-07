package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.init.CinderscapesItems;
import com.terraformersmc.cinderscapes.tag.CinderscapesBlockTags;
import com.terraformersmc.cinderscapes.tag.CinderscapesItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

@NullMarked
public class CinderscapesItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
	protected CinderscapesItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture, BlockTagsProvider blockTagProvider) {
		super(output, registriesFuture, blockTagProvider);
	}

	@Override
	public void addTags(HolderLookup.Provider registries) {
		/*
		 * Vanilla item tags
		 */
		copy(BlockTags.FENCE_GATES, ItemTags.FENCE_GATES);

		valueLookupBuilder(ItemTags.FOX_FOOD)
				.add(CinderscapesItems.BRAMBLE_BERRIES);

		copy(BlockTags.LOGS, ItemTags.LOGS);

		valueLookupBuilder(ItemTags.NON_FLAMMABLE_WOOD)
				.add(CinderscapesBlocks.SCORCHED_BUTTON.asItem())
				.add(CinderscapesBlocks.SCORCHED_DOOR.asItem())
				.add(CinderscapesBlocks.SCORCHED_FENCE.asItem())
				.add(CinderscapesBlocks.SCORCHED_FENCE_GATE.asItem())
				.add(CinderscapesBlocks.SCORCHED_HANGING_SIGN.asItem())
				.add(CinderscapesBlocks.SCORCHED_HYPHAE.asItem())
				.add(CinderscapesBlocks.SCORCHED_PLANKS.asItem())
				.add(CinderscapesBlocks.SCORCHED_PRESSURE_PLATE.asItem())
				.add(CinderscapesBlocks.SCORCHED_SIGN.asItem())
				.add(CinderscapesBlocks.SCORCHED_SLAB.asItem())
				.add(CinderscapesBlocks.SCORCHED_STAIRS.asItem())
				.add(CinderscapesBlocks.SCORCHED_STEM.asItem())
				.add(CinderscapesBlocks.SCORCHED_TRAPDOOR.asItem())
				.add(CinderscapesBlocks.SCORCHED_WALL_HANGING_SIGN.asItem())
				.add(CinderscapesBlocks.SCORCHED_WALL_SIGN.asItem())
				.add(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE.asItem())
				.add(CinderscapesBlocks.STRIPPED_SCORCHED_STEM.asItem())
				.add(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE.asItem())
				.add(CinderscapesBlocks.STRIPPED_UMBRAL_STEM.asItem())
				.add(CinderscapesBlocks.UMBRAL_BUTTON.asItem())
				.add(CinderscapesBlocks.UMBRAL_DOOR.asItem())
				.add(CinderscapesBlocks.UMBRAL_FENCE.asItem())
				.add(CinderscapesBlocks.UMBRAL_FENCE_GATE.asItem())
				.add(CinderscapesBlocks.UMBRAL_HANGING_SIGN.asItem())
				.add(CinderscapesBlocks.UMBRAL_HYPHAE.asItem())
				.add(CinderscapesBlocks.UMBRAL_PLANKS.asItem())
				.add(CinderscapesBlocks.UMBRAL_PRESSURE_PLATE.asItem())
				.add(CinderscapesBlocks.UMBRAL_SIGN.asItem())
				.add(CinderscapesBlocks.UMBRAL_SLAB.asItem())
				.add(CinderscapesBlocks.UMBRAL_STAIRS.asItem())
				.add(CinderscapesBlocks.UMBRAL_STEM.asItem())
				.add(CinderscapesBlocks.UMBRAL_TRAPDOOR.asItem())
				.add(CinderscapesBlocks.UMBRAL_WALL_HANGING_SIGN.asItem())
				.add(CinderscapesBlocks.UMBRAL_WALL_SIGN.asItem());

		copy(BlockTags.PLANKS, ItemTags.PLANKS);

		copy(BlockTags.STANDING_SIGNS, ItemTags.SIGNS);

		copy(BlockTags.CEILING_HANGING_SIGNS, ItemTags.HANGING_SIGNS);

		copy(BlockTags.SLABS, ItemTags.SLABS);

		copy(BlockTags.SMALL_FLOWERS, ItemTags.SMALL_FLOWERS);

		copy(BlockTags.STAIRS, ItemTags.STAIRS);

		valueLookupBuilder(ItemTags.TRIM_MATERIALS)
				.add(CinderscapesItems.ROSE_QUARTZ)
				.add(CinderscapesItems.SMOKY_QUARTZ)
				.add(CinderscapesItems.SULFUR_QUARTZ);

		copy(BlockTags.WART_BLOCKS, ItemTags.WART_BLOCKS);

		copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);

		copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);

		copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);

		copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);

		copy(BlockTags.WOODEN_SHELVES, ItemTags.WOODEN_SHELVES);

		copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);

		copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);

		copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);


		/*
		 * Conventional item tags
		 */
		valueLookupBuilder(ConventionalItemTags.BERRY_FOODS)
				.add(CinderscapesItems.BRAMBLE_BERRIES);

		valueLookupBuilder(CinderscapesItemTags.DARK_ASHES_DUSTS)
				.add(CinderscapesItems.ASH_PILE);

		valueLookupBuilder(ConventionalItemTags.DUSTS)
				.add(CinderscapesItems.ASH_PILE);

		valueLookupBuilder(ConventionalItemTags.FOODS)
				.add(CinderscapesItems.BRAMBLE_BERRIES);

		valueLookupBuilder(ConventionalItemTags.QUARTZ_GEMS)
				.add(Items.QUARTZ)
				.add(CinderscapesItems.ROSE_QUARTZ)
				.add(CinderscapesItems.SMOKY_QUARTZ)
				.add(CinderscapesItems.SULFUR_QUARTZ);

		valueLookupBuilder(CinderscapesItemTags.QUARTZ_BLOCKS)
				.add(CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK.asItem())
				.add(CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK.asItem())
				.add(CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK.asItem())
				.add(CinderscapesBlocks.ROSE_QUARTZ_BLOCK.asItem())
				.add(CinderscapesBlocks.ROSE_QUARTZ_BRICKS.asItem())
				.add(CinderscapesBlocks.ROSE_QUARTZ_PILLAR.asItem())
				.add(CinderscapesBlocks.SMOKY_QUARTZ_BLOCK.asItem())
				.add(CinderscapesBlocks.SMOKY_QUARTZ_BRICKS.asItem())
				.add(CinderscapesBlocks.SMOKY_QUARTZ_PILLAR.asItem())
				.add(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ.asItem())
				.add(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ.asItem())
				.add(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ.asItem())
				.add(CinderscapesBlocks.SULFUR_QUARTZ_BLOCK.asItem())
				.add(CinderscapesBlocks.SULFUR_QUARTZ_BRICKS.asItem())
				.add(CinderscapesBlocks.SULFUR_QUARTZ_PILLAR.asItem());

		valueLookupBuilder(ConventionalItemTags.ORES_IN_GROUND_NETHERRACK)
				.add(CinderscapesBlocks.ROSE_QUARTZ_ORE.asItem())
				.add(CinderscapesBlocks.SMOKY_QUARTZ_ORE.asItem())
				.add(CinderscapesBlocks.SULFUR_QUARTZ_ORE.asItem())
				.add(CinderscapesBlocks.SULFUR_ORE.asItem());

		valueLookupBuilder(ConventionalItemTags.QUARTZ_ORES)
				.add(CinderscapesBlocks.ROSE_QUARTZ_ORE.asItem())
				.add(CinderscapesBlocks.SMOKY_QUARTZ_ORE.asItem())
				.add(CinderscapesBlocks.SULFUR_QUARTZ_ORE.asItem());

		valueLookupBuilder(ConventionalItemTags.STORAGE_BLOCKS)
				.add(CinderscapesBlocks.SULFUR_BLOCK.asItem());

		valueLookupBuilder(CinderscapesItemTags.STORAGE_BLOCKS_SULFUR)
				.add(CinderscapesBlocks.SULFUR_BLOCK.asItem());

		copy(ConventionalBlockTags.STRIPPED_LOGS, ConventionalItemTags.STRIPPED_LOGS);

		copy(ConventionalBlockTags.STRIPPED_WOODS, ConventionalItemTags.STRIPPED_WOODS);

		valueLookupBuilder(CinderscapesItemTags.SULFURS_ORES)
				.add(CinderscapesBlocks.SULFUR_ORE.asItem());

		valueLookupBuilder(CinderscapesItemTags.SULFURS)
				.add(CinderscapesItems.SULFUR);


		/*
		 * Local item tags
		 */
		valueLookupBuilder(CinderscapesItemTags.ROSE_QUARTZ_CONVERTIBLES)
				.add(CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK.asItem())
				.add(CinderscapesBlocks.ROSE_QUARTZ_BLOCK.asItem())
				.add(CinderscapesBlocks.ROSE_QUARTZ_PILLAR.asItem());

		copy(CinderscapesBlockTags.SCORCHED_STEMS, CinderscapesItemTags.SCORCHED_STEMS);

		valueLookupBuilder(CinderscapesItemTags.SMOKY_QUARTZ_CONVERTIBLES)
				.add(CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK.asItem())
				.add(CinderscapesBlocks.SMOKY_QUARTZ_BLOCK.asItem())
				.add(CinderscapesBlocks.SMOKY_QUARTZ_PILLAR.asItem());

		valueLookupBuilder(CinderscapesItemTags.SULFUR_QUARTZ_CONVERTIBLES)
				.add(CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK.asItem())
				.add(CinderscapesBlocks.SULFUR_QUARTZ_BLOCK.asItem())
				.add(CinderscapesBlocks.SULFUR_QUARTZ_PILLAR.asItem());

		copy(CinderscapesBlockTags.UMBRAL_STEMS, CinderscapesItemTags.UMBRAL_STEMS);
	}

	@Override
	public String getName() {
		return "Cinderscapes Item Tags";
	}
}
