package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.init.CinderscapesItems;
import com.terraformersmc.cinderscapes.tag.CinderscapesBlockTags;
import com.terraformersmc.cinderscapes.tag.CinderscapesItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class CinderscapesItemTagProvider extends FabricTagProvider.ItemTagProvider {
	protected CinderscapesItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture, BlockTagProvider blockTagProvider) {
		super(output, registriesFuture, blockTagProvider);
	}

	@Override
	public void configure(RegistryWrapper.WrapperLookup registries) {
		// basic block tags
		getOrCreateTagBuilder(ItemTags.FOX_FOOD)
			.add(CinderscapesItems.BRAMBLE_BERRIES);

		copy(BlockTags.LOGS, ItemTags.LOGS);

		getOrCreateTagBuilder(ItemTags.NON_FLAMMABLE_WOOD)
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

		getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS)
			.add(CinderscapesItems.ROSE_QUARTZ)
			.add(CinderscapesItems.SMOKY_QUARTZ)
			.add(CinderscapesItems.SULFUR_QUARTZ);

		copy(BlockTags.WART_BLOCKS, ItemTags.WART_BLOCKS);

		copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);

		copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);

		copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);

		copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);

		copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);

		copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);

		copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);


		// conventional tags
		getOrCreateTagBuilder(ConventionalItemTags.BERRIES_FOODS)
			.add(CinderscapesItems.BRAMBLE_BERRIES);

		getOrCreateTagBuilder(CinderscapesItemTags.DARK_ASHES_DUSTS)
			.add(CinderscapesItems.ASH_PILE);

		getOrCreateTagBuilder(ConventionalItemTags.DUSTS)
			.add(CinderscapesItems.ASH_PILE);

		getOrCreateTagBuilder(ConventionalItemTags.FOODS)
			.add(CinderscapesItems.BRAMBLE_BERRIES);

		getOrCreateTagBuilder(ConventionalItemTags.QUARTZ_GEMS)
			.add(Items.QUARTZ)
			.add(CinderscapesItems.ROSE_QUARTZ)
			.add(CinderscapesItems.SMOKY_QUARTZ)
			.add(CinderscapesItems.SULFUR_QUARTZ);

		getOrCreateTagBuilder(CinderscapesItemTags.QUARTZ_BLOCKS)
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

		getOrCreateTagBuilder(ConventionalItemTags.QUARTZ_ORES)
			.add(CinderscapesBlocks.ROSE_QUARTZ_ORE.asItem())
			.add(CinderscapesBlocks.SMOKY_QUARTZ_ORE.asItem())
			.add(CinderscapesBlocks.SULFUR_QUARTZ_ORE.asItem());

		getOrCreateTagBuilder(ConventionalItemTags.STORAGE_BLOCKS)
			.add(CinderscapesBlocks.SULFUR_BLOCK.asItem());

		getOrCreateTagBuilder(CinderscapesItemTags.STORAGE_BLOCKS_SULFUR)
			.add(CinderscapesBlocks.SULFUR_BLOCK.asItem());

		copy(CinderscapesBlockTags.STRIPPED_LOGS, CinderscapesItemTags.STRIPPED_LOGS);

		copy(CinderscapesBlockTags.STRIPPED_WOOD, CinderscapesItemTags.STRIPPED_WOOD);

		getOrCreateTagBuilder(CinderscapesItemTags.SULFURS_ORES)
			.add(CinderscapesBlocks.SULFUR_ORE.asItem());

		getOrCreateTagBuilder(CinderscapesItemTags.SULFURS)
			.add(CinderscapesItems.SULFUR);


		// local item tags
		getOrCreateTagBuilder(CinderscapesItemTags.ROSE_QUARTZ_CONVERTIBLES)
			.add(CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK.asItem())
			.add(CinderscapesBlocks.ROSE_QUARTZ_BLOCK.asItem())
			.add(CinderscapesBlocks.ROSE_QUARTZ_PILLAR.asItem());

		copy(CinderscapesBlockTags.SCORCHED_STEMS, CinderscapesItemTags.SCORCHED_STEMS);

		getOrCreateTagBuilder(CinderscapesItemTags.SMOKY_QUARTZ_CONVERTIBLES)
			.add(CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK.asItem())
			.add(CinderscapesBlocks.SMOKY_QUARTZ_BLOCK.asItem())
			.add(CinderscapesBlocks.SMOKY_QUARTZ_PILLAR.asItem());

		getOrCreateTagBuilder(CinderscapesItemTags.SULFUR_QUARTZ_CONVERTIBLES)
			.add(CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK.asItem())
			.add(CinderscapesBlocks.SULFUR_QUARTZ_BLOCK.asItem())
			.add(CinderscapesBlocks.SULFUR_QUARTZ_PILLAR.asItem());

		copy(CinderscapesBlockTags.UMBRAL_STEMS, CinderscapesItemTags.UMBRAL_STEMS);


		// TODO: DEPRECATED as of 1.21
		getOrCreateTagBuilder(CinderscapesItemTags.QUARTZ)
			.add(Items.QUARTZ)
			.add(CinderscapesItems.ROSE_QUARTZ)
			.add(CinderscapesItems.SMOKY_QUARTZ)
			.add(CinderscapesItems.SULFUR_QUARTZ);
		getOrCreateTagBuilder(CinderscapesItemTags.SULFUR_ORES)
			.add(CinderscapesBlocks.SULFUR_ORE.asItem());
	}
}
