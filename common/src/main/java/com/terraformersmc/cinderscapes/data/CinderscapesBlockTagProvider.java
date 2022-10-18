package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.tag.CinderscapesBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.tag.BlockTags;

public class CinderscapesBlockTagProvider extends FabricTagProvider.BlockTagProvider {

	public CinderscapesBlockTagProvider(FabricDataGenerator dataGenerator) {
		super(dataGenerator);
	}

	@Override
	protected void generateTags() {
		// basic block tags
		this.getOrCreateTagBuilder(BlockTags.ENDERMAN_HOLDABLE)
			.add(CinderscapesBlocks.UMBRAL_FUNGUS)
			.add(CinderscapesBlocks.UMBRAL_NYLIUM);

		this.getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
			.add(CinderscapesBlocks.POTTED_CRYSTINIUM)
			.add(CinderscapesBlocks.POTTED_LUMINOUS_POD)
			.add(CinderscapesBlocks.POTTED_PHOTOFERN)
			.add(CinderscapesBlocks.POTTED_POLYPITE_QUARTZ)
			.add(CinderscapesBlocks.POTTED_POLYPITE_ROSE_QUARTZ)
			.add(CinderscapesBlocks.POTTED_POLYPITE_SMOKY_QUARTZ)
			.add(CinderscapesBlocks.POTTED_POLYPITE_SULFUR_QUARTZ)
			.add(CinderscapesBlocks.POTTED_PYRACINTH)
			.add(CinderscapesBlocks.POTTED_SCORCHED_SHRUB)
			.add(CinderscapesBlocks.POTTED_SCORCHED_TENDRILS)
			.add(CinderscapesBlocks.POTTED_TWILIGHT_TENDRILS)
			.add(CinderscapesBlocks.POTTED_UMBRAL_FUNGUS);

		this.getOrCreateTagBuilder(BlockTags.LOGS)
			.add(CinderscapesBlocks.SCORCHED_HYPHAE)
			.add(CinderscapesBlocks.SCORCHED_STEM)
			.add(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE)
			.add(CinderscapesBlocks.STRIPPED_SCORCHED_STEM)
			.add(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE)
			.add(CinderscapesBlocks.STRIPPED_UMBRAL_STEM)
			.add(CinderscapesBlocks.UMBRAL_HYPHAE)
			.add(CinderscapesBlocks.UMBRAL_STEM);

		this.getOrCreateTagBuilder(BlockTags.NON_FLAMMABLE_WOOD)
			.add(CinderscapesBlocks.SCORCHED_BUTTON)
			.add(CinderscapesBlocks.SCORCHED_DOOR)
			.add(CinderscapesBlocks.SCORCHED_FENCE)
			.add(CinderscapesBlocks.SCORCHED_FENCE_GATE)
			.add(CinderscapesBlocks.SCORCHED_HYPHAE)
			.add(CinderscapesBlocks.SCORCHED_PLANKS)
			.add(CinderscapesBlocks.SCORCHED_PRESSURE_PLATE)
			.add(CinderscapesBlocks.SCORCHED_SIGN)
			.add(CinderscapesBlocks.SCORCHED_SLAB)
			.add(CinderscapesBlocks.SCORCHED_STAIRS)
			.add(CinderscapesBlocks.SCORCHED_STEM)
			.add(CinderscapesBlocks.SCORCHED_TRAPDOOR)
			.add(CinderscapesBlocks.SCORCHED_WALL_SIGN)
			.add(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE)
			.add(CinderscapesBlocks.STRIPPED_SCORCHED_STEM)
			.add(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE)
			.add(CinderscapesBlocks.STRIPPED_UMBRAL_STEM)
			.add(CinderscapesBlocks.UMBRAL_BUTTON)
			.add(CinderscapesBlocks.UMBRAL_DOOR)
			.add(CinderscapesBlocks.UMBRAL_FENCE)
			.add(CinderscapesBlocks.UMBRAL_FENCE_GATE)
			.add(CinderscapesBlocks.UMBRAL_HYPHAE)
			.add(CinderscapesBlocks.UMBRAL_PLANKS)
			.add(CinderscapesBlocks.UMBRAL_PRESSURE_PLATE)
			.add(CinderscapesBlocks.UMBRAL_SIGN)
			.add(CinderscapesBlocks.UMBRAL_SLAB)
			.add(CinderscapesBlocks.UMBRAL_STAIRS)
			.add(CinderscapesBlocks.UMBRAL_STEM)
			.add(CinderscapesBlocks.UMBRAL_TRAPDOOR)
			.add(CinderscapesBlocks.UMBRAL_WALL_SIGN);

		this.getOrCreateTagBuilder(BlockTags.NYLIUM)
			.add(CinderscapesBlocks.UMBRAL_NYLIUM);

		this.getOrCreateTagBuilder(BlockTags.PLANKS)
			.add(CinderscapesBlocks.UMBRAL_PLANKS)
			.add(CinderscapesBlocks.SCORCHED_PLANKS);

		this.getOrCreateTagBuilder(BlockTags.SLABS)
			.add(CinderscapesBlocks.ROSE_QUARTZ_SLAB)
			.add(CinderscapesBlocks.SMOKY_QUARTZ_SLAB)
			.add(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_SLAB)
			.add(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_SLAB)
			.add(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_SLAB)
			.add(CinderscapesBlocks.SULFUR_QUARTZ_SLAB);

		this.getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS)
			.add(CinderscapesBlocks.CRYSTINIUM)
			.add(CinderscapesBlocks.PYRACINTH)
			.add(CinderscapesBlocks.SCORCHED_TENDRILS)
			.add(CinderscapesBlocks.TWILIGHT_TENDRILS);

		this.getOrCreateTagBuilder(BlockTags.STAIRS)
			.add(CinderscapesBlocks.ROSE_QUARTZ_STAIRS)
			.add(CinderscapesBlocks.SMOKY_QUARTZ_STAIRS)
			.add(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_STAIRS)
			.add(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_STAIRS)
			.add(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_STAIRS)
			.add(CinderscapesBlocks.SULFUR_QUARTZ_STAIRS);

		this.getOrCreateTagBuilder(BlockTags.STANDING_SIGNS)
			.add(CinderscapesBlocks.SCORCHED_SIGN)
			.add(CinderscapesBlocks.UMBRAL_SIGN);

		this.getOrCreateTagBuilder(BlockTags.STANDING_SIGNS)
			.add(CinderscapesBlocks.SCORCHED_WALL_SIGN)
			.add(CinderscapesBlocks.UMBRAL_WALL_SIGN);

		this.getOrCreateTagBuilder(BlockTags.WART_BLOCKS)
			.add(CinderscapesBlocks.UMBRAL_WART_BLOCK);

		this.getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
			.add(CinderscapesBlocks.SCORCHED_BUTTON)
			.add(CinderscapesBlocks.UMBRAL_BUTTON);

		this.getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
			.add(CinderscapesBlocks.SCORCHED_DOOR)
			.add(CinderscapesBlocks.UMBRAL_DOOR);

		this.getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
			.add(CinderscapesBlocks.SCORCHED_FENCE)
			.add(CinderscapesBlocks.UMBRAL_FENCE);

		this.getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
			.add(CinderscapesBlocks.SCORCHED_PRESSURE_PLATE)
			.add(CinderscapesBlocks.UMBRAL_PRESSURE_PLATE);

		this.getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
			.add(CinderscapesBlocks.SCORCHED_SLAB)
			.add(CinderscapesBlocks.UMBRAL_SLAB);

		this.getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
			.add(CinderscapesBlocks.SCORCHED_STAIRS)
			.add(CinderscapesBlocks.UMBRAL_STAIRS);

		this.getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
			.add(CinderscapesBlocks.SCORCHED_TRAPDOOR)
			.add(CinderscapesBlocks.UMBRAL_TRAPDOOR);


		// tool block tags
		this.getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
			.add(CinderscapesBlocks.SCORCHED_HYPHAE)
			.add(CinderscapesBlocks.SCORCHED_STEM)
			.add(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE)
			.add(CinderscapesBlocks.STRIPPED_SCORCHED_STEM)
			.add(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE)
			.add(CinderscapesBlocks.STRIPPED_UMBRAL_STEM)
			.add(CinderscapesBlocks.TWILIGHT_VINE_BLOCK)
			.add(CinderscapesBlocks.UMBRAL_FUNGUS)
			.add(CinderscapesBlocks.UMBRAL_HYPHAE)
			.add(CinderscapesBlocks.UMBRAL_STEM);

		this.getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
			.add(CinderscapesBlocks.UMBRAL_FLESH_BLOCK)
			.add(CinderscapesBlocks.UMBRAL_WART_BLOCK);

		this.getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
			.add(CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK)
			.add(CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK)
			.add(CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK)
			.add(CinderscapesBlocks.CRYSTALLINE_QUARTZ)
			.add(CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ)
			.add(CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ)
			.add(CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ)
			.add(CinderscapesBlocks.NODZOL)
			.add(CinderscapesBlocks.POLYPITE_QUARTZ)
			.add(CinderscapesBlocks.POLYPITE_ROSE_QUARTZ)
			.add(CinderscapesBlocks.POLYPITE_SMOKY_QUARTZ)
			.add(CinderscapesBlocks.POLYPITE_SULFUR_QUARTZ)
			.add(CinderscapesBlocks.ROSE_QUARTZ_BLOCK)
			.add(CinderscapesBlocks.ROSE_QUARTZ_BRICKS)
			.add(CinderscapesBlocks.ROSE_QUARTZ_ORE)
			.add(CinderscapesBlocks.ROSE_QUARTZ_PILLAR)
			.add(CinderscapesBlocks.ROSE_QUARTZ_SLAB)
			.add(CinderscapesBlocks.ROSE_QUARTZ_STAIRS)
			.add(CinderscapesBlocks.SMOKY_QUARTZ_BLOCK)
			.add(CinderscapesBlocks.SMOKY_QUARTZ_BRICKS)
			.add(CinderscapesBlocks.SMOKY_QUARTZ_ORE)
			.add(CinderscapesBlocks.SMOKY_QUARTZ_PILLAR)
			.add(CinderscapesBlocks.SMOKY_QUARTZ_SLAB)
			.add(CinderscapesBlocks.SMOKY_QUARTZ_STAIRS)
			.add(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ)
			.add(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_SLAB)
			.add(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_STAIRS)
			.add(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ)
			.add(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_SLAB)
			.add(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_STAIRS)
			.add(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ)
			.add(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_SLAB)
			.add(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_STAIRS)
			.add(CinderscapesBlocks.SULFUR_ORE)
			.add(CinderscapesBlocks.SULFUR_QUARTZ_BLOCK)
			.add(CinderscapesBlocks.SULFUR_QUARTZ_BRICKS)
			.add(CinderscapesBlocks.SULFUR_QUARTZ_ORE)
			.add(CinderscapesBlocks.SULFUR_QUARTZ_PILLAR)
			.add(CinderscapesBlocks.SULFUR_QUARTZ_SLAB)
			.add(CinderscapesBlocks.SULFUR_QUARTZ_STAIRS)
			.add(CinderscapesBlocks.UMBRAL_NYLIUM);

		this.getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
			.add(CinderscapesBlocks.ASH)
			.add(CinderscapesBlocks.ASH_BLOCK);


		// local block tags
		this.getOrCreateTagBuilder(CinderscapesBlockTags.ASH_PERMEABLE)
			.addTag(BlockTags.NYLIUM)
			.add(CinderscapesBlocks.ASH)
			.add(CinderscapesBlocks.ASH_BLOCK)
			.add(Blocks.BASALT)
			.add(Blocks.BEDROCK)
			.add(Blocks.BLACKSTONE)
			.add(Blocks.GLOWSTONE)
			.add(Blocks.GRAVEL)
			.add(Blocks.LAVA)
			.add(Blocks.NETHERRACK)
			.add(Blocks.SOUL_SAND)
			.add(Blocks.SOUL_SOIL);

		this.getOrCreateTagBuilder(CinderscapesBlockTags.SCORCHED_STEMS)
			.add(CinderscapesBlocks.SCORCHED_HYPHAE)
			.add(CinderscapesBlocks.SCORCHED_STEM)
			.add(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE)
			.add(CinderscapesBlocks.STRIPPED_SCORCHED_STEM);

		this.getOrCreateTagBuilder(CinderscapesBlockTags.UMBRAL_STEMS)
			.add(CinderscapesBlocks.UMBRAL_HYPHAE)
			.add(CinderscapesBlocks.UMBRAL_STEM)
			.add(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE)
			.add(CinderscapesBlocks.STRIPPED_UMBRAL_STEM);
	}
}
