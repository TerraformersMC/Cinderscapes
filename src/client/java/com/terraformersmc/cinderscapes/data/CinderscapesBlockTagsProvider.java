package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.init.CinderscapesBlockIds;
import com.terraformersmc.cinderscapes.init.CinderscapesBlockItemIds;
import com.terraformersmc.cinderscapes.tag.CinderscapesBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.tags.BlockItemTagsProvider;
import net.minecraft.references.BlockIds;
import net.minecraft.references.BlockItemIds;
import net.minecraft.tags.BlockTags;
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
		tag(BlockTags.ENDERMAN_HOLDABLE)
				.add(CinderscapesBlockItemIds.NODZOL.block())
				.add(CinderscapesBlockItemIds.UMBRAL_FUNGUS.block())
				.add(CinderscapesBlockItemIds.UMBRAL_NYLIUM.block());

		tag(BlockTags.FLOWER_POTS)
				.add(CinderscapesBlockIds.POTTED_CRYSTINIUM)
				.add(CinderscapesBlockIds.POTTED_LUMINOUS_POD)
				.add(CinderscapesBlockIds.POTTED_PHOTOFERN)
				.add(CinderscapesBlockIds.POTTED_POLYPITE_QUARTZ)
				.add(CinderscapesBlockIds.POTTED_POLYPITE_ROSE_QUARTZ)
				.add(CinderscapesBlockIds.POTTED_POLYPITE_SMOKY_QUARTZ)
				.add(CinderscapesBlockIds.POTTED_POLYPITE_SULFUR_QUARTZ)
				.add(CinderscapesBlockIds.POTTED_PYRACINTH)
				.add(CinderscapesBlockIds.POTTED_SCORCHED_SHRUB)
				.add(CinderscapesBlockIds.POTTED_SCORCHED_TENDRILS)
				.add(CinderscapesBlockIds.POTTED_TWILIGHT_TENDRILS)
				.add(CinderscapesBlockIds.POTTED_UMBRAL_FUNGUS);

		tag(BlockTags.HUGE_BROWN_MUSHROOM_CAN_PLACE_ON)
				.add(CinderscapesBlockItemIds.UMBRAL_NYLIUM.block());

		tag(BlockTags.HUGE_RED_MUSHROOM_CAN_PLACE_ON)
				.add(CinderscapesBlockItemIds.UMBRAL_NYLIUM.block());

		tag(BlockTags.INSIDE_STEP_SOUND_BLOCKS)
				.add(CinderscapesBlockItemIds.ASH.block())
				.add(CinderscapesBlockItemIds.SCORCHED_SPROUTS.block())
				.add(CinderscapesBlockItemIds.SCORCHED_TENDRILS.block())
				.add(CinderscapesBlockItemIds.TWILIGHT_FESCUES.block())
				.add(CinderscapesBlockItemIds.TWILIGHT_TENDRILS.block());

		tag(BlockTags.NETHER_CARVER_REPLACEABLES)
				.add(CinderscapesBlockItemIds.UMBRAL_NYLIUM.block())
				.add(CinderscapesBlockItemIds.UMBRAL_WART_BLOCK.block());

		tag(BlockTags.NYLIUM)
				.add(CinderscapesBlockItemIds.UMBRAL_NYLIUM.block());

		tag(BlockTags.OVERRIDES_MUSHROOM_LIGHT_REQUIREMENT)
				.add(CinderscapesBlockItemIds.NODZOL.block());

		tag(BlockTags.CEILING_HANGING_SIGNS)
				.add(CinderscapesBlockItemIds.SCORCHED_HANGING_SIGN.block())
				.add(CinderscapesBlockItemIds.UMBRAL_HANGING_SIGN.block());

		tag(BlockTags.WALL_HANGING_SIGNS)
				.add(CinderscapesBlockIds.SCORCHED_WALL_HANGING_SIGN)
				.add(CinderscapesBlockIds.UMBRAL_WALL_HANGING_SIGN);

		tag(BlockTags.STANDING_SIGNS)
				.add(CinderscapesBlockItemIds.SCORCHED_SIGN.block())
				.add(CinderscapesBlockItemIds.UMBRAL_SIGN.block());

		tag(BlockTags.WALL_SIGNS)
				.add(CinderscapesBlockIds.SCORCHED_WALL_SIGN)
				.add(CinderscapesBlockIds.UMBRAL_WALL_SIGN);


		/*
		 * Tool block tags
		 */
		tag(BlockTags.MINEABLE_WITH_AXE)
				.add(CinderscapesBlockItemIds.SCORCHED_HYPHAE.block())
				.add(CinderscapesBlockItemIds.SCORCHED_STEM.block())
				.add(CinderscapesBlockItemIds.STRIPPED_SCORCHED_HYPHAE.block())
				.add(CinderscapesBlockItemIds.STRIPPED_SCORCHED_STEM.block())
				.add(CinderscapesBlockItemIds.STRIPPED_UMBRAL_HYPHAE.block())
				.add(CinderscapesBlockItemIds.STRIPPED_UMBRAL_STEM.block())
				.add(CinderscapesBlockItemIds.TWILIGHT_VINE_BLOCK.block())
				.add(CinderscapesBlockItemIds.UMBRAL_FUNGUS.block())
				.add(CinderscapesBlockItemIds.UMBRAL_HYPHAE.block())
				.add(CinderscapesBlockItemIds.UMBRAL_STEM.block());

		tag(BlockTags.MINEABLE_WITH_HOE)
				.add(CinderscapesBlockItemIds.UMBRAL_FLESH_BLOCK.block())
				.add(CinderscapesBlockItemIds.UMBRAL_WART_BLOCK.block());

		tag(BlockTags.MINEABLE_WITH_PICKAXE)
				.add(CinderscapesBlockItemIds.CHISELED_ROSE_QUARTZ_BLOCK.block())
				.add(CinderscapesBlockItemIds.CHISELED_SMOKY_QUARTZ_BLOCK.block())
				.add(CinderscapesBlockItemIds.CHISELED_SULFUR_QUARTZ_BLOCK.block())
				.add(CinderscapesBlockItemIds.CRYSTALLINE_QUARTZ.block())
				.add(CinderscapesBlockItemIds.CRYSTALLINE_ROSE_QUARTZ.block())
				.add(CinderscapesBlockItemIds.CRYSTALLINE_SMOKY_QUARTZ.block())
				.add(CinderscapesBlockItemIds.CRYSTALLINE_SULFUR_QUARTZ.block())
				.add(CinderscapesBlockItemIds.NODZOL.block())
				.add(CinderscapesBlockItemIds.POLYPITE_QUARTZ.block())
				.add(CinderscapesBlockItemIds.POLYPITE_ROSE_QUARTZ.block())
				.add(CinderscapesBlockItemIds.POLYPITE_SMOKY_QUARTZ.block())
				.add(CinderscapesBlockItemIds.POLYPITE_SULFUR_QUARTZ.block())
				.add(CinderscapesBlockItemIds.ROSE_QUARTZ_BLOCK.block())
				.add(CinderscapesBlockItemIds.ROSE_QUARTZ_BRICKS.block())
				.add(CinderscapesBlockItemIds.ROSE_QUARTZ_ORE.block())
				.add(CinderscapesBlockItemIds.ROSE_QUARTZ_PILLAR.block())
				.add(CinderscapesBlockItemIds.ROSE_QUARTZ_SLAB.block())
				.add(CinderscapesBlockItemIds.ROSE_QUARTZ_STAIRS.block())
				.add(CinderscapesBlockItemIds.SMOKY_QUARTZ_BLOCK.block())
				.add(CinderscapesBlockItemIds.SMOKY_QUARTZ_BRICKS.block())
				.add(CinderscapesBlockItemIds.SMOKY_QUARTZ_ORE.block())
				.add(CinderscapesBlockItemIds.SMOKY_QUARTZ_PILLAR.block())
				.add(CinderscapesBlockItemIds.SMOKY_QUARTZ_SLAB.block())
				.add(CinderscapesBlockItemIds.SMOKY_QUARTZ_STAIRS.block())
				.add(CinderscapesBlockItemIds.SMOOTH_ROSE_QUARTZ.block())
				.add(CinderscapesBlockItemIds.SMOOTH_ROSE_QUARTZ_SLAB.block())
				.add(CinderscapesBlockItemIds.SMOOTH_ROSE_QUARTZ_STAIRS.block())
				.add(CinderscapesBlockItemIds.SMOOTH_SMOKY_QUARTZ.block())
				.add(CinderscapesBlockItemIds.SMOOTH_SMOKY_QUARTZ_SLAB.block())
				.add(CinderscapesBlockItemIds.SMOOTH_SMOKY_QUARTZ_STAIRS.block())
				.add(CinderscapesBlockItemIds.SMOOTH_SULFUR_QUARTZ.block())
				.add(CinderscapesBlockItemIds.SMOOTH_SULFUR_QUARTZ_SLAB.block())
				.add(CinderscapesBlockItemIds.SMOOTH_SULFUR_QUARTZ_STAIRS.block())
				.add(CinderscapesBlockItemIds.SULFUR_ORE.block())
				.add(CinderscapesBlockItemIds.SULFUR_QUARTZ_BLOCK.block())
				.add(CinderscapesBlockItemIds.SULFUR_QUARTZ_BRICKS.block())
				.add(CinderscapesBlockItemIds.SULFUR_QUARTZ_ORE.block())
				.add(CinderscapesBlockItemIds.SULFUR_QUARTZ_PILLAR.block())
				.add(CinderscapesBlockItemIds.SULFUR_QUARTZ_SLAB.block())
				.add(CinderscapesBlockItemIds.SULFUR_QUARTZ_STAIRS.block())
				.add(CinderscapesBlockItemIds.UMBRAL_NYLIUM.block());

		tag(BlockTags.MINEABLE_WITH_SHOVEL)
				.add(CinderscapesBlockItemIds.ASH.block())
				.add(CinderscapesBlockItemIds.ASH_BLOCK.block());


		/*
		 * Local block tags
		 */
		tag(CinderscapesBlockTags.ASH_PERMEABLE)
				.addTag(BlockTags.NYLIUM)
				.add(CinderscapesBlockItemIds.ASH.block())
				.add(CinderscapesBlockItemIds.ASH_BLOCK.block())
				.add(BlockItemIds.BASALT.block())
				.add(BlockItemIds.BEDROCK.block())
				.add(BlockItemIds.BLACKSTONE.block())
				.add(BlockItemIds.GLOWSTONE.block())
				.add(BlockItemIds.GRAVEL.block())
				.add(BlockIds.LAVA)
				.add(BlockItemIds.NETHERRACK.block())
				.add(CinderscapesBlockItemIds.NODZOL.block())
				.add(BlockItemIds.SOUL_SAND.block())
				.add(BlockItemIds.SOUL_SOIL.block());

		tag(CinderscapesBlockTags.SUPPORTS_UMBRAL_FUNGUS)
				.addOptionalTag(BlockTags.SUPPORTS_WARPED_FUNGUS);

		/*
		 * Run BlockItem block tags
		 */
		new CinderscapesBlockItemTagsProvider(tagId -> BlockItemTagsProvider.wrapForBlocks(this.tag(tagId.block()))).run();
	}

	@Override
	public String getName() {
		return "Cinderscapes Block Tags";
	}
}
