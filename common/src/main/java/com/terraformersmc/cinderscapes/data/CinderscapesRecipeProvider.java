package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.init.CinderscapesBlockFamilies;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.init.CinderscapesItems;
import com.terraformersmc.cinderscapes.tag.CinderscapesItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CinderscapesRecipeProvider extends FabricRecipeProvider {
	protected CinderscapesRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	public RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
		return new RecipeGenerator(registryLookup, exporter) {
			@Override
			public void generate() {
				// We don't really use feature sets, so this is good enough...
				FeatureSet enabledFeatures = FeatureSet.of(FeatureFlags.VANILLA);

				// vanilla recipes
				createShaped(RecipeCategory.REDSTONE, Items.COMPARATOR, 1)
						.pattern(" T ")
						.pattern("TQT")
						.pattern("SSS")
						.input('T', Items.REDSTONE_TORCH)
						.input('Q', ConventionalItemTags.QUARTZ_GEMS)
						.input('S', Items.STONE)
						.criterion("has_quartz", this.conditionsFromTag(ConventionalItemTags.QUARTZ_GEMS))
						.offerTo(exporter);

				createShaped(RecipeCategory.REDSTONE, Items.DAYLIGHT_DETECTOR, 1)
						.pattern("GGG")
						.pattern("QQQ")
						.pattern("WWW")
						.input('G', Items.GLASS)
						.input('Q', ConventionalItemTags.QUARTZ_GEMS)
						.input('W', ItemTags.WOODEN_SLABS)
						.criterion("has_quartz", this.conditionsFromTag(ConventionalItemTags.QUARTZ_GEMS))
						.offerTo(exporter);

				createShaped(RecipeCategory.REDSTONE, Items.OBSERVER, 1)
						.pattern("CCC")
						.pattern("RRQ")
						.pattern("CCC")
						.input('C', Items.COBBLESTONE)
						.input('Q', ConventionalItemTags.QUARTZ_GEMS)
						.input('R', Items.REDSTONE)
						.criterion("has_quartz", this.conditionsFromTag(ConventionalItemTags.QUARTZ_GEMS))
						.offerTo(exporter);


				// misc. recipes
				createShaped(RecipeCategory.DECORATIONS, CinderscapesBlocks.ASH, 6)
						.pattern("AAA")
						.input('A', CinderscapesBlocks.ASH_BLOCK)
						.criterion("has_ash_blocks", this.conditionsFromItem(CinderscapesBlocks.ASH_BLOCK))
						.offerTo(exporter);

				createShaped(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.ASH_BLOCK, 1)
						.pattern("aa")
						.pattern("aa")
						.input('a', CinderscapesItems.ASH_PILE)
						.criterion("has_ash_piles", this.conditionsFromItem(CinderscapesItems.ASH_PILE))
						.offerTo(exporter);

				createShapeless(RecipeCategory.MISC, Items.GUNPOWDER, 1)
						.input(CinderscapesItemTags.SULFURS)
						.input(ItemTags.COALS)
						.input(Items.BONE_MEAL)
						.criterion("has_sulfurs", this.conditionsFromTag(CinderscapesItemTags.SULFURS))
						.offerTo(exporter);

				offerReversibleCompactingRecipes(RecipeCategory.MISC,
						CinderscapesItems.SULFUR,
						RecipeCategory.BUILDING_BLOCKS,
						CinderscapesBlocks.SULFUR_BLOCK);

				offerBlasting(List.of(CinderscapesItems.SULFUR_ORE),
						RecipeCategory.MISC,
						CinderscapesItems.SULFUR,
						0.1f, 100, "blasting");

				offerSmelting(List.of(CinderscapesItems.SULFUR_ORE),
						RecipeCategory.MISC,
						CinderscapesItems.SULFUR,
						0.1f, 200, "smelting");


				// quartz recipes
				offerChiseledBlockRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK, CinderscapesBlocks.ROSE_QUARTZ_SLAB);
				offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK, CinderscapesBlocks.ROSE_QUARTZ_BLOCK);
				offerSmelting(List.of(CinderscapesBlocks.ROSE_QUARTZ_ORE), RecipeCategory.MISC, CinderscapesItems.ROSE_QUARTZ, 0.2f, 200, "misc");
				createShaped(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.ROSE_QUARTZ_BLOCK, 1)
						.pattern("qq")
						.pattern("qq")
						.input('q', CinderscapesItems.ROSE_QUARTZ)
						.criterion("has_quartz", this.conditionsFromItem(CinderscapesItems.ROSE_QUARTZ))
						.offerTo(exporter);
				offerPolishedStoneRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.ROSE_QUARTZ_BRICKS, CinderscapesBlocks.ROSE_QUARTZ_BLOCK);
				offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.ROSE_QUARTZ_BRICKS, CinderscapesBlocks.ROSE_QUARTZ_BLOCK);
				offerBlasting(List.of(CinderscapesBlocks.ROSE_QUARTZ_ORE), RecipeCategory.MISC, CinderscapesItems.ROSE_QUARTZ, 0.2f, 100, "misc");
				createShaped(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.ROSE_QUARTZ_PILLAR, 2)
						.pattern("Q")
						.pattern("Q")
						.input('Q', CinderscapesBlocks.ROSE_QUARTZ_BLOCK)
						.criterion("has_quartz_blocks", this.conditionsFromItem(CinderscapesBlocks.ROSE_QUARTZ_BLOCK))
						.offerTo(exporter);
				offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.ROSE_QUARTZ_PILLAR, CinderscapesBlocks.ROSE_QUARTZ_BLOCK);
				createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.ROSE_QUARTZ_SLAB, Ingredient.ofItems(CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK, CinderscapesBlocks.ROSE_QUARTZ_BLOCK, CinderscapesBlocks.ROSE_QUARTZ_PILLAR))
						.criterion("has_quartz_blocks", this.conditionsFromTag(CinderscapesItemTags.ROSE_QUARTZ_CONVERTIBLES))
						.offerTo(exporter);
				offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.ROSE_QUARTZ_SLAB, CinderscapesBlocks.ROSE_QUARTZ_BLOCK, 2);
				createStairsRecipe(CinderscapesBlocks.ROSE_QUARTZ_STAIRS, Ingredient.ofItems(CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK, CinderscapesBlocks.ROSE_QUARTZ_BLOCK, CinderscapesBlocks.ROSE_QUARTZ_PILLAR))
						.criterion("has_quartz_blocks", this.conditionsFromTag(CinderscapesItemTags.ROSE_QUARTZ_CONVERTIBLES))
						.offerTo(exporter);
				offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.ROSE_QUARTZ_STAIRS, CinderscapesBlocks.ROSE_QUARTZ_BLOCK);
				offerSmelting(List.of(CinderscapesBlocks.ROSE_QUARTZ_BLOCK), RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOOTH_ROSE_QUARTZ, 0.1f, 200, "building_blocks");
				offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_SLAB, CinderscapesBlocks.SMOOTH_ROSE_QUARTZ);
				offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_SLAB, CinderscapesBlocks.SMOOTH_ROSE_QUARTZ, 2);
				createStairsRecipe(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_STAIRS, Ingredient.ofItems(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ))
						.criterion("has_smooth_quartz", this.conditionsFromItem(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ))
						.offerTo(exporter);
				offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_STAIRS, CinderscapesBlocks.SMOOTH_ROSE_QUARTZ);

				offerChiseledBlockRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK, CinderscapesBlocks.SMOKY_QUARTZ_SLAB);
				offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK, CinderscapesBlocks.SMOKY_QUARTZ_BLOCK);
				offerSmelting(List.of(CinderscapesBlocks.SMOKY_QUARTZ_ORE), RecipeCategory.MISC, CinderscapesItems.SMOKY_QUARTZ, 0.2f, 200, "misc");
				createShaped(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOKY_QUARTZ_BLOCK, 1)
						.pattern("qq")
						.pattern("qq")
						.input('q', CinderscapesItems.SMOKY_QUARTZ)
						.criterion("has_quartz", this.conditionsFromItem(CinderscapesItems.SMOKY_QUARTZ))
						.offerTo(exporter);
				offerPolishedStoneRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOKY_QUARTZ_BRICKS, CinderscapesBlocks.SMOKY_QUARTZ_BLOCK);
				offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOKY_QUARTZ_BRICKS, CinderscapesBlocks.SMOKY_QUARTZ_BLOCK);
				offerBlasting(List.of(CinderscapesBlocks.SMOKY_QUARTZ_ORE), RecipeCategory.MISC, CinderscapesItems.SMOKY_QUARTZ, 0.2f, 100, "misc");
				createShaped(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOKY_QUARTZ_PILLAR, 2)
						.pattern("Q")
						.pattern("Q")
						.input('Q', CinderscapesBlocks.SMOKY_QUARTZ_BLOCK)
						.criterion("has_quartz_blocks", this.conditionsFromItem(CinderscapesBlocks.SMOKY_QUARTZ_BLOCK))
						.offerTo(exporter);
				offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOKY_QUARTZ_PILLAR, CinderscapesBlocks.SMOKY_QUARTZ_BLOCK);
				createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOKY_QUARTZ_SLAB, Ingredient.ofItems(CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK, CinderscapesBlocks.SMOKY_QUARTZ_BLOCK, CinderscapesBlocks.SMOKY_QUARTZ_PILLAR))
						.criterion("has_quartz_blocks", this.conditionsFromTag(CinderscapesItemTags.SMOKY_QUARTZ_CONVERTIBLES))
						.offerTo(exporter);
				offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOKY_QUARTZ_SLAB, CinderscapesBlocks.SMOKY_QUARTZ_BLOCK, 2);
				createStairsRecipe(CinderscapesBlocks.SMOKY_QUARTZ_STAIRS, Ingredient.ofItems(CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK, CinderscapesBlocks.SMOKY_QUARTZ_BLOCK, CinderscapesBlocks.SMOKY_QUARTZ_PILLAR))
						.criterion("has_quartz_blocks", this.conditionsFromTag(CinderscapesItemTags.SMOKY_QUARTZ_CONVERTIBLES))
						.offerTo(exporter);
				offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOKY_QUARTZ_STAIRS, CinderscapesBlocks.SMOKY_QUARTZ_BLOCK);
				offerSmelting(List.of(CinderscapesBlocks.SMOKY_QUARTZ_BLOCK), RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ, 0.1f, 200, "building_blocks");
				offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_SLAB, CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ);
				offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_SLAB, CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ, 2);
				createStairsRecipe(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_STAIRS, Ingredient.ofItems(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ))
						.criterion("has_smooth_quartz", this.conditionsFromItem(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ))
						.offerTo(exporter);
				offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_STAIRS, CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ);

				offerChiseledBlockRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK, CinderscapesBlocks.SULFUR_QUARTZ_SLAB);
				offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK, CinderscapesBlocks.SULFUR_QUARTZ_BLOCK);
				offerSmelting(List.of(CinderscapesBlocks.SULFUR_QUARTZ_ORE), RecipeCategory.MISC, CinderscapesItems.SULFUR_QUARTZ, 0.2f, 200, "misc");
				createShaped(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SULFUR_QUARTZ_BLOCK, 1)
						.pattern("qq")
						.pattern("qq")
						.input('q', CinderscapesItems.SULFUR_QUARTZ)
						.criterion("has_quartz", this.conditionsFromItem(CinderscapesItems.SULFUR_QUARTZ))
						.offerTo(exporter);
				offerPolishedStoneRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SULFUR_QUARTZ_BRICKS, CinderscapesBlocks.SULFUR_QUARTZ_BLOCK);
				offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SULFUR_QUARTZ_BRICKS, CinderscapesBlocks.SULFUR_QUARTZ_BLOCK);
				offerBlasting(List.of(CinderscapesBlocks.SULFUR_QUARTZ_ORE), RecipeCategory.MISC, CinderscapesItems.SULFUR_QUARTZ, 0.2f, 100, "misc");
				createShaped(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SULFUR_QUARTZ_PILLAR, 2)
						.pattern("Q")
						.pattern("Q")
						.input('Q', CinderscapesBlocks.SULFUR_QUARTZ_BLOCK)
						.criterion("has_quartz_blocks", this.conditionsFromItem(CinderscapesBlocks.SULFUR_QUARTZ_BLOCK))
						.offerTo(exporter);
				offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SULFUR_QUARTZ_PILLAR, CinderscapesBlocks.SULFUR_QUARTZ_BLOCK);
				createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SULFUR_QUARTZ_SLAB, Ingredient.ofItems(CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK, CinderscapesBlocks.SULFUR_QUARTZ_BLOCK, CinderscapesBlocks.SULFUR_QUARTZ_PILLAR))
						.criterion("has_quartz_blocks", this.conditionsFromTag(CinderscapesItemTags.SULFUR_QUARTZ_CONVERTIBLES))
						.offerTo(exporter);
				offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SULFUR_QUARTZ_SLAB, CinderscapesBlocks.SULFUR_QUARTZ_BLOCK, 2);
				createStairsRecipe(CinderscapesBlocks.SULFUR_QUARTZ_STAIRS, Ingredient.ofItems(CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK, CinderscapesBlocks.SULFUR_QUARTZ_BLOCK, CinderscapesBlocks.SULFUR_QUARTZ_PILLAR))
						.criterion("has_quartz_blocks", this.conditionsFromTag(CinderscapesItemTags.SULFUR_QUARTZ_CONVERTIBLES))
						.offerTo(exporter);
				offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SULFUR_QUARTZ_STAIRS, CinderscapesBlocks.SULFUR_QUARTZ_BLOCK);
				offerSmelting(List.of(CinderscapesBlocks.SULFUR_QUARTZ_BLOCK), RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ, 0.1f, 200, "building_blocks");
				offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_SLAB, CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ);
				offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_SLAB, CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ, 2);
				createStairsRecipe(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_STAIRS, Ingredient.ofItems(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ))
						.criterion("has_smooth_quartz", this.conditionsFromItem(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ))
						.offerTo(exporter);
				offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_STAIRS, CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ);


				// wood recipes
				generateFamily(CinderscapesBlockFamilies.SCORCHED, enabledFeatures);
				offerPlanksRecipe(CinderscapesBlocks.SCORCHED_PLANKS, CinderscapesItemTags.SCORCHED_STEMS, 4);
				offerBarkBlockRecipe(CinderscapesBlocks.SCORCHED_HYPHAE, CinderscapesBlocks.SCORCHED_STEM);
				offerBarkBlockRecipe(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE, CinderscapesBlocks.STRIPPED_SCORCHED_STEM);
				// (no scorched boat at this time)
				offerHangingSignRecipe(CinderscapesItems.SCORCHED_HANGING_SIGN, CinderscapesBlocks.STRIPPED_SCORCHED_STEM);
				offerShelfRecipe(CinderscapesBlocks.SCORCHED_SHELF, CinderscapesItems.STRIPPED_SCORCHED_STEM);

				generateFamily(CinderscapesBlockFamilies.UMBRAL, enabledFeatures);
				offerPlanksRecipe(CinderscapesBlocks.UMBRAL_PLANKS, CinderscapesItemTags.UMBRAL_STEMS, 4);
				offerBarkBlockRecipe(CinderscapesBlocks.UMBRAL_HYPHAE, CinderscapesBlocks.UMBRAL_STEM);
				offerBarkBlockRecipe(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE, CinderscapesBlocks.STRIPPED_UMBRAL_STEM);
				// (no umbral boat at this time)
				offerHangingSignRecipe(CinderscapesItems.UMBRAL_HANGING_SIGN, CinderscapesBlocks.STRIPPED_UMBRAL_STEM);
				offerShelfRecipe(CinderscapesBlocks.UMBRAL_SHELF, CinderscapesItems.STRIPPED_UMBRAL_STEM);
			}
		};
	}


	@Override
	public String getName() {
		return "Cinderscapes Recipes";
	}

	@Override
	protected Identifier getRecipeIdentifier(Identifier identifier) {
		return Identifier.of(Cinderscapes.MOD_ID, identifier.getPath());
	}
}
