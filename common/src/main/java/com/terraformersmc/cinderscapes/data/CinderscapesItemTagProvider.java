package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.init.CinderscapesItems;
import com.terraformersmc.cinderscapes.tag.CinderscapesItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.tag.ItemTags;

public class CinderscapesItemTagProvider extends FabricTagProvider.ItemTagProvider {
	public CinderscapesItemTagProvider(FabricDataGenerator dataGenerator) {
		super(dataGenerator);
	}

	@Override
	protected void generateTags() {
		// local item tags
		this.getOrCreateTagBuilder(CinderscapesItemTags.ROSE_QUARTZ_CONVERTIBLES)
			.add(CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK.asItem())
			.add(CinderscapesBlocks.ROSE_QUARTZ_BLOCK.asItem())
			.add(CinderscapesBlocks.ROSE_QUARTZ_PILLAR.asItem());

		this.getOrCreateTagBuilder(CinderscapesItemTags.SCORCHED_STEMS)
			.add(CinderscapesBlocks.SCORCHED_HYPHAE.asItem())
			.add(CinderscapesBlocks.SCORCHED_STEM.asItem())
			.add(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE.asItem())
			.add(CinderscapesBlocks.STRIPPED_SCORCHED_STEM.asItem());

		this.getOrCreateTagBuilder(CinderscapesItemTags.SMOKY_QUARTZ_CONVERTIBLES)
			.add(CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK.asItem())
			.add(CinderscapesBlocks.SMOKY_QUARTZ_BLOCK.asItem())
			.add(CinderscapesBlocks.SMOKY_QUARTZ_PILLAR.asItem());

		this.getOrCreateTagBuilder(CinderscapesItemTags.SULFUR_QUARTZ_CONVERTIBLES)
			.add(CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK.asItem())
			.add(CinderscapesBlocks.SULFUR_QUARTZ_BLOCK.asItem())
			.add(CinderscapesBlocks.SULFUR_QUARTZ_PILLAR.asItem());

		this.getOrCreateTagBuilder(CinderscapesItemTags.UMBRAL_STEMS)
			.add(CinderscapesBlocks.UMBRAL_HYPHAE.asItem())
			.add(CinderscapesBlocks.UMBRAL_STEM.asItem())
			.add(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE.asItem())
			.add(CinderscapesBlocks.STRIPPED_UMBRAL_STEM.asItem());


		// common item tags
		this.getOrCreateTagBuilder(CinderscapesItemTags.DARK_ASHES_DUSTS)
			.add(CinderscapesItems.ASH_PILE);

		this.getOrCreateTagBuilder(CinderscapesItemTags.QUARTZ)
			.add(Items.QUARTZ)
			.add(CinderscapesItems.ROSE_QUARTZ)
			.add(CinderscapesItems.SMOKY_QUARTZ)
			.add(CinderscapesItems.SULFUR_QUARTZ);

		this.getOrCreateTagBuilder(CinderscapesItemTags.QUARTZ_BLOCKS)
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

		this.getOrCreateTagBuilder(CinderscapesItemTags.QUARTZ_ORES)
			.add(CinderscapesBlocks.ROSE_QUARTZ_ORE.asItem())
			.add(CinderscapesBlocks.SMOKY_QUARTZ_ORE.asItem())
			.add(CinderscapesBlocks.SULFUR_QUARTZ_ORE.asItem());

		this.getOrCreateTagBuilder(CinderscapesItemTags.STRIPPED_LOGS)
			.add(CinderscapesBlocks.STRIPPED_SCORCHED_STEM.asItem())
			.add(CinderscapesBlocks.STRIPPED_UMBRAL_STEM.asItem());

		this.getOrCreateTagBuilder(CinderscapesItemTags.STRIPPED_WOOD)
			.add(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE.asItem())
			.add(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE.asItem());

		this.getOrCreateTagBuilder(CinderscapesItemTags.SULFUR_ORES)
			.add(CinderscapesBlocks.SULFUR_ORE.asItem());

		this.getOrCreateTagBuilder(CinderscapesItemTags.SULFURS)
			.add(CinderscapesItems.SULFUR);


		// vanilla item tags
		this.getOrCreateTagBuilder(ItemTags.FOX_FOOD)
			.add(CinderscapesBlocks.BRAMBLE_BERRIES);

		this.getOrCreateTagBuilder(ItemTags.LOGS)
			.addTag(CinderscapesItemTags.SCORCHED_STEMS)
			.addTag(CinderscapesItemTags.UMBRAL_STEMS);

		this.getOrCreateTagBuilder(ItemTags.NON_FLAMMABLE_WOOD)
			.add(CinderscapesBlocks.SCORCHED_BUTTON.asItem())
			.add(CinderscapesBlocks.SCORCHED_DOOR.asItem())
			.add(CinderscapesBlocks.SCORCHED_FENCE.asItem())
			.add(CinderscapesBlocks.SCORCHED_FENCE_GATE.asItem())
			.add(CinderscapesBlocks.SCORCHED_HYPHAE.asItem())
			.add(CinderscapesBlocks.SCORCHED_PLANKS.asItem())
			.add(CinderscapesBlocks.SCORCHED_PRESSURE_PLATE.asItem())
			.add(CinderscapesBlocks.SCORCHED_SIGN.asItem())
			.add(CinderscapesBlocks.SCORCHED_SLAB.asItem())
			.add(CinderscapesBlocks.SCORCHED_STAIRS.asItem())
			.add(CinderscapesBlocks.SCORCHED_STEM.asItem())
			.add(CinderscapesBlocks.SCORCHED_TRAPDOOR.asItem())
			.add(CinderscapesBlocks.SCORCHED_WALL_SIGN.asItem())
			.add(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE.asItem())
			.add(CinderscapesBlocks.STRIPPED_SCORCHED_STEM.asItem())
			.add(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE.asItem())
			.add(CinderscapesBlocks.STRIPPED_UMBRAL_STEM.asItem())
			.add(CinderscapesBlocks.UMBRAL_BUTTON.asItem())
			.add(CinderscapesBlocks.UMBRAL_DOOR.asItem())
			.add(CinderscapesBlocks.UMBRAL_FENCE.asItem())
			.add(CinderscapesBlocks.UMBRAL_FENCE_GATE.asItem())
			.add(CinderscapesBlocks.UMBRAL_HYPHAE.asItem())
			.add(CinderscapesBlocks.UMBRAL_PLANKS.asItem())
			.add(CinderscapesBlocks.UMBRAL_PRESSURE_PLATE.asItem())
			.add(CinderscapesBlocks.UMBRAL_SIGN.asItem())
			.add(CinderscapesBlocks.UMBRAL_SLAB.asItem())
			.add(CinderscapesBlocks.UMBRAL_STAIRS.asItem())
			.add(CinderscapesBlocks.UMBRAL_STEM.asItem())
			.add(CinderscapesBlocks.UMBRAL_TRAPDOOR.asItem())
			.add(CinderscapesBlocks.UMBRAL_WALL_SIGN.asItem());

		this.getOrCreateTagBuilder(ItemTags.PLANKS)
			.add(CinderscapesBlocks.SCORCHED_PLANKS.asItem())
			.add(CinderscapesBlocks.UMBRAL_PLANKS.asItem());

		this.getOrCreateTagBuilder(ItemTags.SIGNS)
			.add(CinderscapesBlocks.SCORCHED_SIGN.asItem())
			.add(CinderscapesBlocks.UMBRAL_SIGN.asItem());

		this.getOrCreateTagBuilder(ItemTags.SLABS)
			.add(CinderscapesBlocks.ROSE_QUARTZ_SLAB.asItem())
			.add(CinderscapesBlocks.SMOKY_QUARTZ_SLAB.asItem())
			.add(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_SLAB.asItem())
			.add(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_SLAB.asItem())
			.add(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_SLAB.asItem())
			.add(CinderscapesBlocks.SULFUR_QUARTZ_SLAB.asItem());

		this.getOrCreateTagBuilder(ItemTags.SMALL_FLOWERS)
			.add(CinderscapesBlocks.CRYSTINIUM.asItem())
			.add(CinderscapesBlocks.PYRACINTH.asItem())
			.add(CinderscapesBlocks.SCORCHED_TENDRILS.asItem())
			.add(CinderscapesBlocks.TWILIGHT_TENDRILS.asItem());

		this.getOrCreateTagBuilder(ItemTags.STAIRS)
			.add(CinderscapesBlocks.ROSE_QUARTZ_STAIRS.asItem())
			.add(CinderscapesBlocks.SMOKY_QUARTZ_STAIRS.asItem())
			.add(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_STAIRS.asItem())
			.add(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_STAIRS.asItem())
			.add(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_STAIRS.asItem())
			.add(CinderscapesBlocks.SULFUR_QUARTZ_STAIRS.asItem());

		this.getOrCreateTagBuilder(ItemTags.WART_BLOCKS)
			.add(CinderscapesBlocks.UMBRAL_WART_BLOCK.asItem());

		this.getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS)
			.add(CinderscapesBlocks.SCORCHED_BUTTON.asItem())
			.add(CinderscapesBlocks.UMBRAL_BUTTON.asItem());

		this.getOrCreateTagBuilder(ItemTags.WOODEN_DOORS)
			.add(CinderscapesBlocks.SCORCHED_DOOR.asItem())
			.add(CinderscapesBlocks.UMBRAL_DOOR.asItem());

		this.getOrCreateTagBuilder(ItemTags.WOODEN_FENCES)
			.add(CinderscapesBlocks.SCORCHED_FENCE.asItem())
			.add(CinderscapesBlocks.UMBRAL_FENCE.asItem());
		this.getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
			.add(CinderscapesBlocks.SCORCHED_PRESSURE_PLATE.asItem())
			.add(CinderscapesBlocks.UMBRAL_PRESSURE_PLATE.asItem());

		this.getOrCreateTagBuilder(ItemTags.WOODEN_SLABS)
			.add(CinderscapesBlocks.SCORCHED_SLAB.asItem())
			.add(CinderscapesBlocks.UMBRAL_SLAB.asItem());

		this.getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS)
			.add(CinderscapesBlocks.SCORCHED_STAIRS.asItem())
			.add(CinderscapesBlocks.UMBRAL_STAIRS.asItem());

		this.getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS)
			.add(CinderscapesBlocks.SCORCHED_TRAPDOOR.asItem())
			.add(CinderscapesBlocks.UMBRAL_TRAPDOOR.asItem());
	}
}
