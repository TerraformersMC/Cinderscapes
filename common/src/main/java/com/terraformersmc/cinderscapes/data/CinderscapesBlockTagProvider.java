package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.tag.CinderscapesBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class CinderscapesBlockTagProvider extends FabricTagProvider.BlockTagProvider {
	protected CinderscapesBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	public void configure(RegistryWrapper.WrapperLookup registries) {
		// basic block tags
		getOrCreateTagBuilder(BlockTags.ENDERMAN_HOLDABLE)
			.add(CinderscapesBlocks.NODZOL)
			.add(CinderscapesBlocks.UMBRAL_FUNGUS)
			.add(CinderscapesBlocks.UMBRAL_NYLIUM);

		getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
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

		getOrCreateTagBuilder(BlockTags.INSIDE_STEP_SOUND_BLOCKS)
			.add(CinderscapesBlocks.ASH)
			.add(CinderscapesBlocks.SCORCHED_SPROUTS)
			.add(CinderscapesBlocks.SCORCHED_TENDRILS)
			.add(CinderscapesBlocks.TWILIGHT_FESCUES)
			.add(CinderscapesBlocks.TWILIGHT_TENDRILS);

		getOrCreateTagBuilder(BlockTags.LOGS)
			.add(CinderscapesBlocks.SCORCHED_HYPHAE)
			.add(CinderscapesBlocks.SCORCHED_STEM)
			.add(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE)
			.add(CinderscapesBlocks.STRIPPED_SCORCHED_STEM)
			.add(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE)
			.add(CinderscapesBlocks.STRIPPED_UMBRAL_STEM)
			.add(CinderscapesBlocks.UMBRAL_HYPHAE)
			.add(CinderscapesBlocks.UMBRAL_STEM);

		getOrCreateTagBuilder(BlockTags.MUSHROOM_GROW_BLOCK)
			.add(CinderscapesBlocks.NODZOL);

		getOrCreateTagBuilder(BlockTags.NETHER_CARVER_REPLACEABLES)
			.add(CinderscapesBlocks.UMBRAL_NYLIUM)
			.add(CinderscapesBlocks.UMBRAL_WART_BLOCK);

		getOrCreateTagBuilder(BlockTags.NYLIUM)
			.add(CinderscapesBlocks.UMBRAL_NYLIUM);

		getOrCreateTagBuilder(BlockTags.PLANKS)
			.add(CinderscapesBlocks.UMBRAL_PLANKS)
			.add(CinderscapesBlocks.SCORCHED_PLANKS);

		getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS)
			.add(CinderscapesBlocks.SCORCHED_HANGING_SIGN)
			.add(CinderscapesBlocks.UMBRAL_HANGING_SIGN);

		getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS)
			.add(CinderscapesBlocks.SCORCHED_WALL_HANGING_SIGN)
			.add(CinderscapesBlocks.UMBRAL_WALL_HANGING_SIGN);

		getOrCreateTagBuilder(BlockTags.STANDING_SIGNS)
			.add(CinderscapesBlocks.SCORCHED_SIGN)
			.add(CinderscapesBlocks.UMBRAL_SIGN);

		getOrCreateTagBuilder(BlockTags.WALL_SIGNS)
			.add(CinderscapesBlocks.SCORCHED_WALL_SIGN)
			.add(CinderscapesBlocks.UMBRAL_WALL_SIGN);

		getOrCreateTagBuilder(BlockTags.SLABS)
			.add(CinderscapesBlocks.ROSE_QUARTZ_SLAB)
			.add(CinderscapesBlocks.SMOKY_QUARTZ_SLAB)
			.add(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_SLAB)
			.add(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_SLAB)
			.add(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_SLAB)
			.add(CinderscapesBlocks.SULFUR_QUARTZ_SLAB);

		getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS)
			.add(CinderscapesBlocks.CRYSTINIUM)
			.add(CinderscapesBlocks.PYRACINTH)
			.add(CinderscapesBlocks.SCORCHED_TENDRILS)
			.add(CinderscapesBlocks.TWILIGHT_TENDRILS);

		getOrCreateTagBuilder(BlockTags.STAIRS)
			.add(CinderscapesBlocks.ROSE_QUARTZ_STAIRS)
			.add(CinderscapesBlocks.SMOKY_QUARTZ_STAIRS)
			.add(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_STAIRS)
			.add(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_STAIRS)
			.add(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_STAIRS)
			.add(CinderscapesBlocks.SULFUR_QUARTZ_STAIRS);

		getOrCreateTagBuilder(BlockTags.WART_BLOCKS)
			.add(CinderscapesBlocks.UMBRAL_WART_BLOCK);

		getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
			.add(CinderscapesBlocks.SCORCHED_BUTTON)
			.add(CinderscapesBlocks.UMBRAL_BUTTON);

		getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
			.add(CinderscapesBlocks.SCORCHED_DOOR)
			.add(CinderscapesBlocks.UMBRAL_DOOR);

		getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
			.add(CinderscapesBlocks.SCORCHED_FENCE)
			.add(CinderscapesBlocks.UMBRAL_FENCE);

		getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
			.add(CinderscapesBlocks.SCORCHED_PRESSURE_PLATE)
			.add(CinderscapesBlocks.UMBRAL_PRESSURE_PLATE);

		getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
			.add(CinderscapesBlocks.SCORCHED_SLAB)
			.add(CinderscapesBlocks.UMBRAL_SLAB);

		getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
			.add(CinderscapesBlocks.SCORCHED_STAIRS)
			.add(CinderscapesBlocks.UMBRAL_STAIRS);

		getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
			.add(CinderscapesBlocks.SCORCHED_TRAPDOOR)
			.add(CinderscapesBlocks.UMBRAL_TRAPDOOR);


		// tool block tags
		getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
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

		getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
			.add(CinderscapesBlocks.UMBRAL_FLESH_BLOCK)
			.add(CinderscapesBlocks.UMBRAL_WART_BLOCK);

		getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
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

		getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
			.add(CinderscapesBlocks.ASH)
			.add(CinderscapesBlocks.ASH_BLOCK);


		// conventional tags
		getOrCreateTagBuilder(ConventionalBlockTags.ORES)
			.add(CinderscapesBlocks.SULFUR_ORE);

		getOrCreateTagBuilder(ConventionalBlockTags.QUARTZ_ORES)
			.add(CinderscapesBlocks.ROSE_QUARTZ_ORE)
			.add(CinderscapesBlocks.SMOKY_QUARTZ_ORE)
			.add(CinderscapesBlocks.SULFUR_QUARTZ_ORE);

		getOrCreateTagBuilder(CinderscapesBlockTags.STRIPPED_LOGS)
			.add(CinderscapesBlocks.STRIPPED_SCORCHED_STEM)
			.add(CinderscapesBlocks.STRIPPED_UMBRAL_STEM);

		getOrCreateTagBuilder(CinderscapesBlockTags.STRIPPED_WOOD)
			.add(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE)
			.add(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE);


		// local block tags
		getOrCreateTagBuilder(CinderscapesBlockTags.ASH_PERMEABLE)
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
			.add(CinderscapesBlocks.NODZOL)
			.add(Blocks.SOUL_SAND)
			.add(Blocks.SOUL_SOIL);

		getOrCreateTagBuilder(CinderscapesBlockTags.SCORCHED_STEMS)
			.add(CinderscapesBlocks.SCORCHED_HYPHAE)
			.add(CinderscapesBlocks.SCORCHED_STEM)
			.add(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE)
			.add(CinderscapesBlocks.STRIPPED_SCORCHED_STEM);

		getOrCreateTagBuilder(CinderscapesBlockTags.UMBRAL_STEMS)
			.add(CinderscapesBlocks.UMBRAL_HYPHAE)
			.add(CinderscapesBlocks.UMBRAL_STEM)
			.add(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE)
			.add(CinderscapesBlocks.STRIPPED_UMBRAL_STEM);
	}
}
