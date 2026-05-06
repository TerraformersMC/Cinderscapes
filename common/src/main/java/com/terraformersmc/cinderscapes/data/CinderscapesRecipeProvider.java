package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.init.CinderscapesBlockFamilies;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.init.CinderscapesItems;
import com.terraformersmc.cinderscapes.tag.CinderscapesItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.resources.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CinderscapesRecipeProvider extends FabricRecipeProvider {
	protected CinderscapesRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	public RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
		return new RecipeProvider(registryLookup, exporter) {
			@Override
			public void buildRecipes() {
				// We don't really use feature sets, so this is good enough...
				FeatureFlagSet enabledFeatures = FeatureFlagSet.of(FeatureFlags.VANILLA);

				// vanilla recipes
				shaped(RecipeCategory.REDSTONE, Items.COMPARATOR, 1)
						.pattern(" T ")
						.pattern("TQT")
						.pattern("SSS")
						.define('T', Items.REDSTONE_TORCH)
						.define('Q', ConventionalItemTags.QUARTZ_GEMS)
						.define('S', Items.STONE)
						.unlockedBy("has_quartz", this.has(ConventionalItemTags.QUARTZ_GEMS))
						.save(output);

				shaped(RecipeCategory.REDSTONE, Items.DAYLIGHT_DETECTOR, 1)
						.pattern("GGG")
						.pattern("QQQ")
						.pattern("WWW")
						.define('G', Items.GLASS)
						.define('Q', ConventionalItemTags.QUARTZ_GEMS)
						.define('W', ItemTags.WOODEN_SLABS)
						.unlockedBy("has_quartz", this.has(ConventionalItemTags.QUARTZ_GEMS))
						.save(output);

				shaped(RecipeCategory.REDSTONE, Items.OBSERVER, 1)
						.pattern("CCC")
						.pattern("RRQ")
						.pattern("CCC")
						.define('C', Items.COBBLESTONE)
						.define('Q', ConventionalItemTags.QUARTZ_GEMS)
						.define('R', Items.REDSTONE)
						.unlockedBy("has_quartz", this.has(ConventionalItemTags.QUARTZ_GEMS))
						.save(output);


				// misc. recipes
				shaped(RecipeCategory.DECORATIONS, CinderscapesBlocks.ASH, 6)
						.pattern("AAA")
						.define('A', CinderscapesBlocks.ASH_BLOCK)
						.unlockedBy("has_ash_blocks", this.has(CinderscapesBlocks.ASH_BLOCK))
						.save(output);

				shaped(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.ASH_BLOCK, 1)
						.pattern("aa")
						.pattern("aa")
						.define('a', CinderscapesItems.ASH_PILE)
						.unlockedBy("has_ash_piles", this.has(CinderscapesItems.ASH_PILE))
						.save(output);

				shapeless(RecipeCategory.MISC, Items.GUNPOWDER, 1)
						.requires(CinderscapesItemTags.SULFURS)
						.requires(ItemTags.COALS)
						.requires(Items.BONE_MEAL)
						.unlockedBy("has_sulfurs", this.has(CinderscapesItemTags.SULFURS))
						.save(output);

				nineBlockStorageRecipes(RecipeCategory.MISC,
						CinderscapesItems.SULFUR,
						RecipeCategory.BUILDING_BLOCKS,
						CinderscapesBlocks.SULFUR_BLOCK);

				oreBlasting(List.of(CinderscapesItems.SULFUR_ORE),
						RecipeCategory.MISC,
						CinderscapesItems.SULFUR,
						0.1f, 100, "blasting");

				oreSmelting(List.of(CinderscapesItems.SULFUR_ORE),
						RecipeCategory.MISC,
						CinderscapesItems.SULFUR,
						0.1f, 200, "smelting");


				// quartz recipes
				chiseled(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK, CinderscapesBlocks.ROSE_QUARTZ_SLAB);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK, CinderscapesBlocks.ROSE_QUARTZ_BLOCK);
				oreSmelting(List.of(CinderscapesBlocks.ROSE_QUARTZ_ORE), RecipeCategory.MISC, CinderscapesItems.ROSE_QUARTZ, 0.2f, 200, "misc");
				shaped(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.ROSE_QUARTZ_BLOCK, 1)
						.pattern("qq")
						.pattern("qq")
						.define('q', CinderscapesItems.ROSE_QUARTZ)
						.unlockedBy("has_quartz", this.has(CinderscapesItems.ROSE_QUARTZ))
						.save(output);
				polished(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.ROSE_QUARTZ_BRICKS, CinderscapesBlocks.ROSE_QUARTZ_BLOCK);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.ROSE_QUARTZ_BRICKS, CinderscapesBlocks.ROSE_QUARTZ_BLOCK);
				oreBlasting(List.of(CinderscapesBlocks.ROSE_QUARTZ_ORE), RecipeCategory.MISC, CinderscapesItems.ROSE_QUARTZ, 0.2f, 100, "misc");
				shaped(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.ROSE_QUARTZ_PILLAR, 2)
						.pattern("Q")
						.pattern("Q")
						.define('Q', CinderscapesBlocks.ROSE_QUARTZ_BLOCK)
						.unlockedBy("has_quartz_blocks", this.has(CinderscapesBlocks.ROSE_QUARTZ_BLOCK))
						.save(output);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.ROSE_QUARTZ_PILLAR, CinderscapesBlocks.ROSE_QUARTZ_BLOCK);
				slabBuilder(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.ROSE_QUARTZ_SLAB, Ingredient.of(CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK, CinderscapesBlocks.ROSE_QUARTZ_BLOCK, CinderscapesBlocks.ROSE_QUARTZ_PILLAR))
						.unlockedBy("has_quartz_blocks", this.has(CinderscapesItemTags.ROSE_QUARTZ_CONVERTIBLES))
						.save(output);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.ROSE_QUARTZ_SLAB, CinderscapesBlocks.ROSE_QUARTZ_BLOCK, 2);
				stairBuilder(CinderscapesBlocks.ROSE_QUARTZ_STAIRS, Ingredient.of(CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK, CinderscapesBlocks.ROSE_QUARTZ_BLOCK, CinderscapesBlocks.ROSE_QUARTZ_PILLAR))
						.unlockedBy("has_quartz_blocks", this.has(CinderscapesItemTags.ROSE_QUARTZ_CONVERTIBLES))
						.save(output);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.ROSE_QUARTZ_STAIRS, CinderscapesBlocks.ROSE_QUARTZ_BLOCK);
				oreSmelting(List.of(CinderscapesBlocks.ROSE_QUARTZ_BLOCK), RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOOTH_ROSE_QUARTZ, 0.1f, 200, "building_blocks");
				slab(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_SLAB, CinderscapesBlocks.SMOOTH_ROSE_QUARTZ);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_SLAB, CinderscapesBlocks.SMOOTH_ROSE_QUARTZ, 2);
				stairBuilder(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_STAIRS, Ingredient.of(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ))
						.unlockedBy("has_smooth_quartz", this.has(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ))
						.save(output);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_STAIRS, CinderscapesBlocks.SMOOTH_ROSE_QUARTZ);

				chiseled(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK, CinderscapesBlocks.SMOKY_QUARTZ_SLAB);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK, CinderscapesBlocks.SMOKY_QUARTZ_BLOCK);
				oreSmelting(List.of(CinderscapesBlocks.SMOKY_QUARTZ_ORE), RecipeCategory.MISC, CinderscapesItems.SMOKY_QUARTZ, 0.2f, 200, "misc");
				shaped(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOKY_QUARTZ_BLOCK, 1)
						.pattern("qq")
						.pattern("qq")
						.define('q', CinderscapesItems.SMOKY_QUARTZ)
						.unlockedBy("has_quartz", this.has(CinderscapesItems.SMOKY_QUARTZ))
						.save(output);
				polished(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOKY_QUARTZ_BRICKS, CinderscapesBlocks.SMOKY_QUARTZ_BLOCK);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOKY_QUARTZ_BRICKS, CinderscapesBlocks.SMOKY_QUARTZ_BLOCK);
				oreBlasting(List.of(CinderscapesBlocks.SMOKY_QUARTZ_ORE), RecipeCategory.MISC, CinderscapesItems.SMOKY_QUARTZ, 0.2f, 100, "misc");
				shaped(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOKY_QUARTZ_PILLAR, 2)
						.pattern("Q")
						.pattern("Q")
						.define('Q', CinderscapesBlocks.SMOKY_QUARTZ_BLOCK)
						.unlockedBy("has_quartz_blocks", this.has(CinderscapesBlocks.SMOKY_QUARTZ_BLOCK))
						.save(output);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOKY_QUARTZ_PILLAR, CinderscapesBlocks.SMOKY_QUARTZ_BLOCK);
				slabBuilder(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOKY_QUARTZ_SLAB, Ingredient.of(CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK, CinderscapesBlocks.SMOKY_QUARTZ_BLOCK, CinderscapesBlocks.SMOKY_QUARTZ_PILLAR))
						.unlockedBy("has_quartz_blocks", this.has(CinderscapesItemTags.SMOKY_QUARTZ_CONVERTIBLES))
						.save(output);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOKY_QUARTZ_SLAB, CinderscapesBlocks.SMOKY_QUARTZ_BLOCK, 2);
				stairBuilder(CinderscapesBlocks.SMOKY_QUARTZ_STAIRS, Ingredient.of(CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK, CinderscapesBlocks.SMOKY_QUARTZ_BLOCK, CinderscapesBlocks.SMOKY_QUARTZ_PILLAR))
						.unlockedBy("has_quartz_blocks", this.has(CinderscapesItemTags.SMOKY_QUARTZ_CONVERTIBLES))
						.save(output);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOKY_QUARTZ_STAIRS, CinderscapesBlocks.SMOKY_QUARTZ_BLOCK);
				oreSmelting(List.of(CinderscapesBlocks.SMOKY_QUARTZ_BLOCK), RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ, 0.1f, 200, "building_blocks");
				slab(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_SLAB, CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_SLAB, CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ, 2);
				stairBuilder(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_STAIRS, Ingredient.of(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ))
						.unlockedBy("has_smooth_quartz", this.has(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ))
						.save(output);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_STAIRS, CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ);

				chiseled(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK, CinderscapesBlocks.SULFUR_QUARTZ_SLAB);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK, CinderscapesBlocks.SULFUR_QUARTZ_BLOCK);
				oreSmelting(List.of(CinderscapesBlocks.SULFUR_QUARTZ_ORE), RecipeCategory.MISC, CinderscapesItems.SULFUR_QUARTZ, 0.2f, 200, "misc");
				shaped(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SULFUR_QUARTZ_BLOCK, 1)
						.pattern("qq")
						.pattern("qq")
						.define('q', CinderscapesItems.SULFUR_QUARTZ)
						.unlockedBy("has_quartz", this.has(CinderscapesItems.SULFUR_QUARTZ))
						.save(output);
				polished(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SULFUR_QUARTZ_BRICKS, CinderscapesBlocks.SULFUR_QUARTZ_BLOCK);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SULFUR_QUARTZ_BRICKS, CinderscapesBlocks.SULFUR_QUARTZ_BLOCK);
				oreBlasting(List.of(CinderscapesBlocks.SULFUR_QUARTZ_ORE), RecipeCategory.MISC, CinderscapesItems.SULFUR_QUARTZ, 0.2f, 100, "misc");
				shaped(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SULFUR_QUARTZ_PILLAR, 2)
						.pattern("Q")
						.pattern("Q")
						.define('Q', CinderscapesBlocks.SULFUR_QUARTZ_BLOCK)
						.unlockedBy("has_quartz_blocks", this.has(CinderscapesBlocks.SULFUR_QUARTZ_BLOCK))
						.save(output);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SULFUR_QUARTZ_PILLAR, CinderscapesBlocks.SULFUR_QUARTZ_BLOCK);
				slabBuilder(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SULFUR_QUARTZ_SLAB, Ingredient.of(CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK, CinderscapesBlocks.SULFUR_QUARTZ_BLOCK, CinderscapesBlocks.SULFUR_QUARTZ_PILLAR))
						.unlockedBy("has_quartz_blocks", this.has(CinderscapesItemTags.SULFUR_QUARTZ_CONVERTIBLES))
						.save(output);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SULFUR_QUARTZ_SLAB, CinderscapesBlocks.SULFUR_QUARTZ_BLOCK, 2);
				stairBuilder(CinderscapesBlocks.SULFUR_QUARTZ_STAIRS, Ingredient.of(CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK, CinderscapesBlocks.SULFUR_QUARTZ_BLOCK, CinderscapesBlocks.SULFUR_QUARTZ_PILLAR))
						.unlockedBy("has_quartz_blocks", this.has(CinderscapesItemTags.SULFUR_QUARTZ_CONVERTIBLES))
						.save(output);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SULFUR_QUARTZ_STAIRS, CinderscapesBlocks.SULFUR_QUARTZ_BLOCK);
				oreSmelting(List.of(CinderscapesBlocks.SULFUR_QUARTZ_BLOCK), RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ, 0.1f, 200, "building_blocks");
				slab(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_SLAB, CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_SLAB, CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ, 2);
				stairBuilder(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_STAIRS, Ingredient.of(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ))
						.unlockedBy("has_smooth_quartz", this.has(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ))
						.save(output);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_STAIRS, CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ);


				// wood recipes
				generateRecipes(CinderscapesBlockFamilies.SCORCHED, enabledFeatures);
				planksFromLogs(CinderscapesBlocks.SCORCHED_PLANKS, CinderscapesItemTags.SCORCHED_STEMS, 4);
				woodFromLogs(CinderscapesBlocks.SCORCHED_HYPHAE, CinderscapesBlocks.SCORCHED_STEM);
				woodFromLogs(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE, CinderscapesBlocks.STRIPPED_SCORCHED_STEM);
				// (no scorched boat at this time)
				hangingSign(CinderscapesItems.SCORCHED_HANGING_SIGN, CinderscapesBlocks.STRIPPED_SCORCHED_STEM);
				shelf(CinderscapesBlocks.SCORCHED_SHELF, CinderscapesItems.STRIPPED_SCORCHED_STEM);

				generateRecipes(CinderscapesBlockFamilies.UMBRAL, enabledFeatures);
				planksFromLogs(CinderscapesBlocks.UMBRAL_PLANKS, CinderscapesItemTags.UMBRAL_STEMS, 4);
				woodFromLogs(CinderscapesBlocks.UMBRAL_HYPHAE, CinderscapesBlocks.UMBRAL_STEM);
				woodFromLogs(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE, CinderscapesBlocks.STRIPPED_UMBRAL_STEM);
				// (no umbral boat at this time)
				hangingSign(CinderscapesItems.UMBRAL_HANGING_SIGN, CinderscapesBlocks.STRIPPED_UMBRAL_STEM);
				shelf(CinderscapesBlocks.UMBRAL_SHELF, CinderscapesItems.STRIPPED_UMBRAL_STEM);
			}
		};
	}


	@Override
	public String getName() {
		return "Cinderscapes Recipes";
	}

	@Override
	protected Identifier getRecipeIdentifier(Identifier identifier) {
		return Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, identifier.getPath());
	}
}
