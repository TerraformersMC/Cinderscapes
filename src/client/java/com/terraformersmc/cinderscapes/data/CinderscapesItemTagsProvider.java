package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.init.CinderscapesBlockItemIds;
import com.terraformersmc.cinderscapes.init.CinderscapesItemIds;
import com.terraformersmc.cinderscapes.tag.CinderscapesItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.tags.BlockItemTagsProvider;
import net.minecraft.references.ItemIds;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
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
		tag(ItemTags.FOX_FOOD)
				.add(CinderscapesItemIds.BRAMBLE_BERRIES);

		tag(ItemTags.NON_FLAMMABLE_WOOD)
				.add(CinderscapesBlockItemIds.SCORCHED_BUTTON.item())
				.add(CinderscapesBlockItemIds.SCORCHED_DOOR.item())
				.add(CinderscapesBlockItemIds.SCORCHED_FENCE.item())
				.add(CinderscapesBlockItemIds.SCORCHED_FENCE_GATE.item())
				.add(CinderscapesBlockItemIds.SCORCHED_HANGING_SIGN.item())
				.add(CinderscapesBlockItemIds.SCORCHED_HYPHAE.item())
				.add(CinderscapesBlockItemIds.SCORCHED_PLANKS.item())
				.add(CinderscapesBlockItemIds.SCORCHED_PRESSURE_PLATE.item())
				.add(CinderscapesBlockItemIds.SCORCHED_SIGN.item())
				.add(CinderscapesBlockItemIds.SCORCHED_SLAB.item())
				.add(CinderscapesBlockItemIds.SCORCHED_STAIRS.item())
				.add(CinderscapesBlockItemIds.SCORCHED_STEM.item())
				.add(CinderscapesBlockItemIds.SCORCHED_TRAPDOOR.item())
				.add(CinderscapesBlockItemIds.STRIPPED_SCORCHED_HYPHAE.item())
				.add(CinderscapesBlockItemIds.STRIPPED_SCORCHED_STEM.item())
				.add(CinderscapesBlockItemIds.STRIPPED_UMBRAL_HYPHAE.item())
				.add(CinderscapesBlockItemIds.STRIPPED_UMBRAL_STEM.item())
				.add(CinderscapesBlockItemIds.UMBRAL_BUTTON.item())
				.add(CinderscapesBlockItemIds.UMBRAL_DOOR.item())
				.add(CinderscapesBlockItemIds.UMBRAL_FENCE.item())
				.add(CinderscapesBlockItemIds.UMBRAL_FENCE_GATE.item())
				.add(CinderscapesBlockItemIds.UMBRAL_HANGING_SIGN.item())
				.add(CinderscapesBlockItemIds.UMBRAL_HYPHAE.item())
				.add(CinderscapesBlockItemIds.UMBRAL_PLANKS.item())
				.add(CinderscapesBlockItemIds.UMBRAL_PRESSURE_PLATE.item())
				.add(CinderscapesBlockItemIds.UMBRAL_SIGN.item())
				.add(CinderscapesBlockItemIds.UMBRAL_SLAB.item())
				.add(CinderscapesBlockItemIds.UMBRAL_STAIRS.item())
				.add(CinderscapesBlockItemIds.UMBRAL_STEM.item())
				.add(CinderscapesBlockItemIds.UMBRAL_TRAPDOOR.item());

		copy(BlockTags.STANDING_SIGNS, ItemTags.SIGNS);

		copy(BlockTags.CEILING_HANGING_SIGNS, ItemTags.HANGING_SIGNS);

		tag(ItemTags.TRIM_MATERIALS)
				.add(CinderscapesItemIds.ROSE_QUARTZ)
				.add(CinderscapesItemIds.SMOKY_QUARTZ)
				.add(CinderscapesItemIds.SULFUR_QUARTZ);


		/*
		 * Conventional item tags
		 */
		tag(ConventionalItemTags.BERRY_FOODS)
				.add(CinderscapesItemIds.BRAMBLE_BERRIES);

		tag(CinderscapesItemTags.DARK_ASHES_DUSTS)
				.add(CinderscapesItemIds.ASH_PILE);

		tag(ConventionalItemTags.DUSTS)
				.add(CinderscapesItemIds.ASH_PILE);

		tag(ConventionalItemTags.FOODS)
				.add(CinderscapesItemIds.BRAMBLE_BERRIES);

		tag(ConventionalItemTags.QUARTZ_GEMS)
				.add(ItemIds.QUARTZ)
				.add(CinderscapesItemIds.ROSE_QUARTZ)
				.add(CinderscapesItemIds.SMOKY_QUARTZ)
				.add(CinderscapesItemIds.SULFUR_QUARTZ);

		tag(CinderscapesItemTags.QUARTZ_BLOCKS)
				.add(CinderscapesBlockItemIds.CHISELED_ROSE_QUARTZ_BLOCK.item())
				.add(CinderscapesBlockItemIds.CHISELED_SMOKY_QUARTZ_BLOCK.item())
				.add(CinderscapesBlockItemIds.CHISELED_SULFUR_QUARTZ_BLOCK.item())
				.add(CinderscapesBlockItemIds.ROSE_QUARTZ_BLOCK.item())
				.add(CinderscapesBlockItemIds.ROSE_QUARTZ_BRICKS.item())
				.add(CinderscapesBlockItemIds.ROSE_QUARTZ_PILLAR.item())
				.add(CinderscapesBlockItemIds.SMOKY_QUARTZ_BLOCK.item())
				.add(CinderscapesBlockItemIds.SMOKY_QUARTZ_BRICKS.item())
				.add(CinderscapesBlockItemIds.SMOKY_QUARTZ_PILLAR.item())
				.add(CinderscapesBlockItemIds.SMOOTH_ROSE_QUARTZ.item())
				.add(CinderscapesBlockItemIds.SMOOTH_SMOKY_QUARTZ.item())
				.add(CinderscapesBlockItemIds.SMOOTH_SULFUR_QUARTZ.item())
				.add(CinderscapesBlockItemIds.SULFUR_QUARTZ_BLOCK.item())
				.add(CinderscapesBlockItemIds.SULFUR_QUARTZ_BRICKS.item())
				.add(CinderscapesBlockItemIds.SULFUR_QUARTZ_PILLAR.item());

		tag(ConventionalItemTags.STORAGE_BLOCKS)
				.add(CinderscapesBlockItemIds.SULFUR_BLOCK.item());

		tag(CinderscapesItemTags.STORAGE_BLOCKS_SULFUR)
				.add(CinderscapesBlockItemIds.SULFUR_BLOCK.item());

		tag(CinderscapesItemTags.SULFURS)
				.add(CinderscapesItemIds.SULFUR);


		/*
		 * Local item tags
		 */
		tag(CinderscapesItemTags.ROSE_QUARTZ_CONVERTIBLES)
				.add(CinderscapesBlockItemIds.CHISELED_ROSE_QUARTZ_BLOCK.item())
				.add(CinderscapesBlockItemIds.ROSE_QUARTZ_BLOCK.item())
				.add(CinderscapesBlockItemIds.ROSE_QUARTZ_PILLAR.item());

		tag(CinderscapesItemTags.SMOKY_QUARTZ_CONVERTIBLES)
				.add(CinderscapesBlockItemIds.CHISELED_SMOKY_QUARTZ_BLOCK.item())
				.add(CinderscapesBlockItemIds.SMOKY_QUARTZ_BLOCK.item())
				.add(CinderscapesBlockItemIds.SMOKY_QUARTZ_PILLAR.item());

		tag(CinderscapesItemTags.SULFUR_QUARTZ_CONVERTIBLES)
				.add(CinderscapesBlockItemIds.CHISELED_SULFUR_QUARTZ_BLOCK.item())
				.add(CinderscapesBlockItemIds.SULFUR_QUARTZ_BLOCK.item())
				.add(CinderscapesBlockItemIds.SULFUR_QUARTZ_PILLAR.item());

		/*
		 * Run BlockItem item tags
		 */
		new CinderscapesBlockItemTagsProvider(tagId -> BlockItemTagsProvider.wrapForItems(this.tag(tagId.item()))).run();
	}

	@Override
	public String getName() {
		return "Cinderscapes Item Tags";
	}
}
