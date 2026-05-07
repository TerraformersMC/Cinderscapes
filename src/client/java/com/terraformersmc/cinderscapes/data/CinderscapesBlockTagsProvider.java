package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.tag.CinderscapesBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

@NullMarked
public class CinderscapesBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
	protected CinderscapesBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	public void addTags(HolderLookup.Provider registries) {
		/*
		 * Basic block tags
		 */
		valueLookupBuilder(BlockTags.ENDERMAN_HOLDABLE)
				.add(CinderscapesBlocks.NODZOL)
				.add(CinderscapesBlocks.UMBRAL_FUNGUS)
				.add(CinderscapesBlocks.UMBRAL_NYLIUM);

		valueLookupBuilder(BlockTags.FENCE_GATES)
				.add(CinderscapesBlocks.SCORCHED_FENCE_GATE)
				.add(CinderscapesBlocks.UMBRAL_FENCE_GATE);

		valueLookupBuilder(BlockTags.FLOWER_POTS)
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

		valueLookupBuilder(BlockTags.INSIDE_STEP_SOUND_BLOCKS)
				.add(CinderscapesBlocks.ASH)
				.add(CinderscapesBlocks.SCORCHED_SPROUTS)
				.add(CinderscapesBlocks.SCORCHED_TENDRILS)
				.add(CinderscapesBlocks.TWILIGHT_FESCUES)
				.add(CinderscapesBlocks.TWILIGHT_TENDRILS);

		valueLookupBuilder(BlockTags.LOGS)
				.add(CinderscapesBlocks.SCORCHED_HYPHAE)
				.add(CinderscapesBlocks.SCORCHED_STEM)
				.add(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE)
				.add(CinderscapesBlocks.STRIPPED_SCORCHED_STEM)
				.add(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE)
				.add(CinderscapesBlocks.STRIPPED_UMBRAL_STEM)
				.add(CinderscapesBlocks.UMBRAL_HYPHAE)
				.add(CinderscapesBlocks.UMBRAL_STEM);

		valueLookupBuilder(BlockTags.NETHER_CARVER_REPLACEABLES)
				.add(CinderscapesBlocks.UMBRAL_NYLIUM)
				.add(CinderscapesBlocks.UMBRAL_WART_BLOCK);

		valueLookupBuilder(BlockTags.NYLIUM)
				.add(CinderscapesBlocks.UMBRAL_NYLIUM);

		valueLookupBuilder(BlockTags.OVERRIDES_MUSHROOM_LIGHT_REQUIREMENT)
				.add(CinderscapesBlocks.NODZOL);

		valueLookupBuilder(BlockTags.PLANKS)
				.add(CinderscapesBlocks.UMBRAL_PLANKS)
				.add(CinderscapesBlocks.SCORCHED_PLANKS);

		valueLookupBuilder(BlockTags.CEILING_HANGING_SIGNS)
				.add(CinderscapesBlocks.SCORCHED_HANGING_SIGN)
				.add(CinderscapesBlocks.UMBRAL_HANGING_SIGN);

		valueLookupBuilder(BlockTags.WALL_HANGING_SIGNS)
				.add(CinderscapesBlocks.SCORCHED_WALL_HANGING_SIGN)
				.add(CinderscapesBlocks.UMBRAL_WALL_HANGING_SIGN);

		valueLookupBuilder(BlockTags.STANDING_SIGNS)
				.add(CinderscapesBlocks.SCORCHED_SIGN)
				.add(CinderscapesBlocks.UMBRAL_SIGN);

		valueLookupBuilder(BlockTags.WALL_SIGNS)
				.add(CinderscapesBlocks.SCORCHED_WALL_SIGN)
				.add(CinderscapesBlocks.UMBRAL_WALL_SIGN);

		valueLookupBuilder(BlockTags.SLABS)
				.add(CinderscapesBlocks.ROSE_QUARTZ_SLAB)
				.add(CinderscapesBlocks.SMOKY_QUARTZ_SLAB)
				.add(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_SLAB)
				.add(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_SLAB)
				.add(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_SLAB)
				.add(CinderscapesBlocks.SULFUR_QUARTZ_SLAB);

		valueLookupBuilder(BlockTags.SMALL_FLOWERS)
				.add(CinderscapesBlocks.CRYSTINIUM)
				.add(CinderscapesBlocks.PYRACINTH)
				.add(CinderscapesBlocks.SCORCHED_TENDRILS)
				.add(CinderscapesBlocks.TWILIGHT_TENDRILS);

		valueLookupBuilder(BlockTags.STAIRS)
				.add(CinderscapesBlocks.ROSE_QUARTZ_STAIRS)
				.add(CinderscapesBlocks.SMOKY_QUARTZ_STAIRS)
				.add(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_STAIRS)
				.add(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_STAIRS)
				.add(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_STAIRS)
				.add(CinderscapesBlocks.SULFUR_QUARTZ_STAIRS);

		valueLookupBuilder(BlockTags.WART_BLOCKS)
				.add(CinderscapesBlocks.UMBRAL_WART_BLOCK);

		valueLookupBuilder(BlockTags.WOODEN_BUTTONS)
				.add(CinderscapesBlocks.SCORCHED_BUTTON)
				.add(CinderscapesBlocks.UMBRAL_BUTTON);

		valueLookupBuilder(BlockTags.WOODEN_DOORS)
				.add(CinderscapesBlocks.SCORCHED_DOOR)
				.add(CinderscapesBlocks.UMBRAL_DOOR);

		valueLookupBuilder(BlockTags.WOODEN_FENCES)
				.add(CinderscapesBlocks.SCORCHED_FENCE)
				.add(CinderscapesBlocks.UMBRAL_FENCE);

		valueLookupBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
				.add(CinderscapesBlocks.SCORCHED_PRESSURE_PLATE)
				.add(CinderscapesBlocks.UMBRAL_PRESSURE_PLATE);

		valueLookupBuilder(BlockTags.WOODEN_SHELVES)
				.add(CinderscapesBlocks.SCORCHED_SHELF)
				.add(CinderscapesBlocks.UMBRAL_SHELF);

		valueLookupBuilder(BlockTags.WOODEN_SLABS)
				.add(CinderscapesBlocks.SCORCHED_SLAB)
				.add(CinderscapesBlocks.UMBRAL_SLAB);

		valueLookupBuilder(BlockTags.WOODEN_STAIRS)
				.add(CinderscapesBlocks.SCORCHED_STAIRS)
				.add(CinderscapesBlocks.UMBRAL_STAIRS);

		valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS)
				.add(CinderscapesBlocks.SCORCHED_TRAPDOOR)
				.add(CinderscapesBlocks.UMBRAL_TRAPDOOR);


		/*
		 * Tool block tags
		 */
		valueLookupBuilder(BlockTags.MINEABLE_WITH_AXE)
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

		valueLookupBuilder(BlockTags.MINEABLE_WITH_HOE)
				.add(CinderscapesBlocks.UMBRAL_FLESH_BLOCK)
				.add(CinderscapesBlocks.UMBRAL_WART_BLOCK);

		valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
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

		valueLookupBuilder(BlockTags.MINEABLE_WITH_SHOVEL)
				.add(CinderscapesBlocks.ASH)
				.add(CinderscapesBlocks.ASH_BLOCK);


		/*
		 * Conventional block tags
		 */
		valueLookupBuilder(ConventionalBlockTags.ORES)
				.add(CinderscapesBlocks.SULFUR_ORE);

		valueLookupBuilder(ConventionalBlockTags.ORES_IN_GROUND_NETHERRACK)
				.add(CinderscapesBlocks.ROSE_QUARTZ_ORE)
				.add(CinderscapesBlocks.SMOKY_QUARTZ_ORE)
				.add(CinderscapesBlocks.SULFUR_QUARTZ_ORE)
				.add(CinderscapesBlocks.SULFUR_ORE);

		valueLookupBuilder(ConventionalBlockTags.QUARTZ_ORES)
				.add(CinderscapesBlocks.ROSE_QUARTZ_ORE)
				.add(CinderscapesBlocks.SMOKY_QUARTZ_ORE)
				.add(CinderscapesBlocks.SULFUR_QUARTZ_ORE);

		valueLookupBuilder(ConventionalBlockTags.STRIPPED_LOGS)
				.add(CinderscapesBlocks.STRIPPED_SCORCHED_STEM)
				.add(CinderscapesBlocks.STRIPPED_UMBRAL_STEM);

		valueLookupBuilder(ConventionalBlockTags.STRIPPED_WOODS)
				.add(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE)
				.add(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE);


		/*
		 * Local block tags
		 */
		valueLookupBuilder(CinderscapesBlockTags.ASH_PERMEABLE)
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

		valueLookupBuilder(CinderscapesBlockTags.SCORCHED_STEMS)
				.add(CinderscapesBlocks.SCORCHED_HYPHAE)
				.add(CinderscapesBlocks.SCORCHED_STEM)
				.add(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE)
				.add(CinderscapesBlocks.STRIPPED_SCORCHED_STEM);

		valueLookupBuilder(CinderscapesBlockTags.SUPPORTS_UMBRAL_FUNGUS)
				.addOptionalTag(BlockTags.SUPPORTS_WARPED_FUNGUS);

		valueLookupBuilder(CinderscapesBlockTags.UMBRAL_STEMS)
				.add(CinderscapesBlocks.UMBRAL_HYPHAE)
				.add(CinderscapesBlocks.UMBRAL_STEM)
				.add(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE)
				.add(CinderscapesBlocks.STRIPPED_UMBRAL_STEM);
	}

	@Override
	public String getName() {
		return "Cinderscapes Block Tags";
	}
}
