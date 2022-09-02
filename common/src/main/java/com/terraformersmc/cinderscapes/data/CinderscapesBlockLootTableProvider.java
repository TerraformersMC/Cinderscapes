package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.block.AshLayerBlock;
import com.terraformersmc.cinderscapes.block.BrambleBerryBushBlock;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.init.CinderscapesItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.AlternativeEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.predicate.item.EnchantmentPredicate;
import net.minecraft.predicate.item.ItemPredicate;

public class CinderscapesBlockLootTableProvider extends FabricBlockLootTableProvider {
	protected CinderscapesBlockLootTableProvider(FabricDataGenerator dataGenerator) {
		super(dataGenerator);
	}

	@Override
	protected void generateBlockLootTables() {
		// simple blocks
		addDrop(CinderscapesBlocks.ASH_BLOCK);
		addDrop(CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK);
		addDrop(CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK);
		addDrop(CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK);
		addDrop(CinderscapesBlocks.CRYSTALLINE_QUARTZ, block -> oreDrops(block, Items.QUARTZ));
		addDrop(CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ, block -> oreDrops(block, CinderscapesItems.ROSE_QUARTZ));
		addDrop(CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ, block -> oreDrops(block, CinderscapesItems.SMOKY_QUARTZ));
		addDrop(CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ, block -> oreDrops(block, CinderscapesItems.SULFUR_QUARTZ));
		addDrop(CinderscapesBlocks.CRYSTINIUM);
		addDrop(CinderscapesBlocks.GHASTLY_ECTOPLASM, BlockLootTableGenerator::dropsWithShears);
		addDrop(CinderscapesBlocks.PHOTOFERN, BlockLootTableGenerator::dropsWithShears);
		addDrop(CinderscapesBlocks.POLYPITE_QUARTZ, block -> oreDrops(block, Items.QUARTZ));
		addDrop(CinderscapesBlocks.POLYPITE_ROSE_QUARTZ, block -> oreDrops(block, CinderscapesItems.ROSE_QUARTZ));
		addDrop(CinderscapesBlocks.POLYPITE_SMOKY_QUARTZ, block -> oreDrops(block, CinderscapesItems.SMOKY_QUARTZ));
		addDrop(CinderscapesBlocks.POLYPITE_SULFUR_QUARTZ, block -> oreDrops(block, CinderscapesItems.SULFUR_QUARTZ));
		addDrop(CinderscapesBlocks.PYRACINTH);
		addDrop(CinderscapesBlocks.ROSE_QUARTZ_BLOCK);
		addDrop(CinderscapesBlocks.ROSE_QUARTZ_BRICKS);
		addDrop(CinderscapesBlocks.ROSE_QUARTZ_ORE, block -> oreDrops(block, CinderscapesItems.ROSE_QUARTZ));
		addDrop(CinderscapesBlocks.ROSE_QUARTZ_PILLAR);
		addDrop(CinderscapesBlocks.ROSE_QUARTZ_SLAB, BlockLootTableGenerator::slabDrops);
		addDrop(CinderscapesBlocks.ROSE_QUARTZ_STAIRS);
		addDrop(CinderscapesBlocks.SCORCHED_SHRUB, BlockLootTableGenerator::dropsWithShears);
		addDrop(CinderscapesBlocks.SCORCHED_SPROUTS, BlockLootTableGenerator::dropsWithShears);
		addDrop(CinderscapesBlocks.SCORCHED_TENDRILS, BlockLootTableGenerator::dropsWithShears);
		addDrop(CinderscapesBlocks.SMOKY_QUARTZ_BLOCK);
		addDrop(CinderscapesBlocks.SMOKY_QUARTZ_BRICKS);
		addDrop(CinderscapesBlocks.SMOKY_QUARTZ_ORE, block -> oreDrops(block, CinderscapesItems.SMOKY_QUARTZ));
		addDrop(CinderscapesBlocks.SMOKY_QUARTZ_PILLAR);
		addDrop(CinderscapesBlocks.SMOKY_QUARTZ_SLAB, BlockLootTableGenerator::slabDrops);
		addDrop(CinderscapesBlocks.SMOKY_QUARTZ_STAIRS);
		addDrop(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ);
		addDrop(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_SLAB, BlockLootTableGenerator::slabDrops);
		addDrop(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_STAIRS);
		addDrop(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ);
		addDrop(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_SLAB, BlockLootTableGenerator::slabDrops);
		addDrop(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_STAIRS);
		addDrop(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ);
		addDrop(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_SLAB, BlockLootTableGenerator::slabDrops);
		addDrop(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_STAIRS);
		addDrop(CinderscapesBlocks.SULFUR_BLOCK);
		addDrop(CinderscapesBlocks.SULFUR_ORE, block -> oreDrops(block, CinderscapesItems.SULFUR));
		addDrop(CinderscapesBlocks.SULFUR_QUARTZ_BLOCK);
		addDrop(CinderscapesBlocks.SULFUR_QUARTZ_BRICKS);
		addDrop(CinderscapesBlocks.SULFUR_QUARTZ_ORE, block -> oreDrops(block, CinderscapesItems.SULFUR_QUARTZ));
		addDrop(CinderscapesBlocks.SULFUR_QUARTZ_PILLAR);
		addDrop(CinderscapesBlocks.SULFUR_QUARTZ_SLAB, BlockLootTableGenerator::slabDrops);
		addDrop(CinderscapesBlocks.SULFUR_QUARTZ_STAIRS);
		addDrop(CinderscapesBlocks.TWILIGHT_FESCUES, BlockLootTableGenerator::dropsWithShears);
		addDrop(CinderscapesBlocks.TWILIGHT_TENDRILS, BlockLootTableGenerator::dropsWithShears);
		addDrop(CinderscapesBlocks.TWILIGHT_VINE_BLOCK);
		addDrop(CinderscapesBlocks.UMBRAL_FLESH_BLOCK);
		addDropWithSilkTouch(CinderscapesBlocks.UMBRAL_NYLIUM, Blocks.NETHERRACK);
		addDrop(CinderscapesBlocks.UMBRAL_NYLIUM, block -> drops(block, Items.NETHERRACK));
		addDrop(CinderscapesBlocks.UMBRAL_WART_BLOCK);


		// wood building blocks
		// TODO: Consider bringing over the WoodBlocks interface from Terrestria
		addDrop(CinderscapesBlocks.SCORCHED_BUTTON);
		addDrop(CinderscapesBlocks.SCORCHED_DOOR, BlockLootTableGenerator::doorDrops);
		addDrop(CinderscapesBlocks.SCORCHED_FENCE);
		addDrop(CinderscapesBlocks.SCORCHED_FENCE_GATE);
		addDrop(CinderscapesBlocks.SCORCHED_HYPHAE);
		addDrop(CinderscapesBlocks.SCORCHED_PLANKS);
		addDrop(CinderscapesBlocks.SCORCHED_PRESSURE_PLATE);
		addDrop(CinderscapesBlocks.SCORCHED_SIGN);
		addDrop(CinderscapesBlocks.SCORCHED_SLAB, BlockLootTableGenerator::slabDrops);
		addDrop(CinderscapesBlocks.SCORCHED_STAIRS);
		addDrop(CinderscapesBlocks.SCORCHED_STEM);
		addDrop(CinderscapesBlocks.SCORCHED_TRAPDOOR);
		addDrop(CinderscapesBlocks.SCORCHED_WALL_SIGN);
		addDrop(CinderscapesBlocks.STRIPPED_SCORCHED_STEM);
		addDrop(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE);

		addDrop(CinderscapesBlocks.UMBRAL_BUTTON);
		addDrop(CinderscapesBlocks.UMBRAL_DOOR, BlockLootTableGenerator::doorDrops);
		addDrop(CinderscapesBlocks.UMBRAL_FENCE);
		addDrop(CinderscapesBlocks.UMBRAL_FENCE_GATE);
		addDrop(CinderscapesBlocks.UMBRAL_FUNGUS);
		addDrop(CinderscapesBlocks.UMBRAL_HYPHAE);
		addDrop(CinderscapesBlocks.UMBRAL_PLANKS);
		addDrop(CinderscapesBlocks.UMBRAL_PRESSURE_PLATE);
		addDrop(CinderscapesBlocks.UMBRAL_SIGN);
		addDrop(CinderscapesBlocks.UMBRAL_SLAB, BlockLootTableGenerator::slabDrops);
		addDrop(CinderscapesBlocks.UMBRAL_STAIRS);
		addDrop(CinderscapesBlocks.UMBRAL_STEM);
		addDrop(CinderscapesBlocks.UMBRAL_TRAPDOOR);
		addDrop(CinderscapesBlocks.UMBRAL_WALL_SIGN);
		addDrop(CinderscapesBlocks.STRIPPED_UMBRAL_STEM);
		addDrop(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE);


		// potted things
		addPottedPlantDrop(CinderscapesBlocks.POTTED_CRYSTINIUM);
		addPottedPlantDrop(CinderscapesBlocks.POTTED_LUMINOUS_POD);
		addPottedPlantDrop(CinderscapesBlocks.POTTED_PHOTOFERN);
		addPottedPlantDrop(CinderscapesBlocks.POTTED_POLYPITE_QUARTZ);
		addPottedPlantDrop(CinderscapesBlocks.POTTED_POLYPITE_ROSE_QUARTZ);
		addPottedPlantDrop(CinderscapesBlocks.POTTED_POLYPITE_SMOKY_QUARTZ);
		addPottedPlantDrop(CinderscapesBlocks.POTTED_POLYPITE_SULFUR_QUARTZ);
		addPottedPlantDrop(CinderscapesBlocks.POTTED_PYRACINTH);
		addPottedPlantDrop(CinderscapesBlocks.POTTED_SCORCHED_SHRUB);
		addPottedPlantDrop(CinderscapesBlocks.POTTED_SCORCHED_TENDRILS);
		addPottedPlantDrop(CinderscapesBlocks.POTTED_TWILIGHT_TENDRILS);
		addPottedPlantDrop(CinderscapesBlocks.POTTED_UMBRAL_FUNGUS);


		// tall plant drops
		addDrop(CinderscapesBlocks.LUMINOUS_POD, block -> dropsWithShears(block).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2))));
		addDrop(CinderscapesBlocks.TALL_PHOTOFERN, dropsWithShears(CinderscapesBlocks.PHOTOFERN).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2))));


		// berry drops
		addDrop(CinderscapesBlocks.BRAMBLE_BERRY_BUSH, block -> BlockLootTableGenerator.applyExplosionDecay(block, LootTable.builder()
			.pool(
				LootPool.builder().conditionally(BlockStatePropertyLootCondition.builder(CinderscapesBlocks.BRAMBLE_BERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(BrambleBerryBushBlock.AGE, 3)))
					.with(ItemEntry.builder(CinderscapesItems.BRAMBLE_BERRIES)).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 3.0f)))
					.apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE))
			)
			.pool(
				LootPool.builder().conditionally(BlockStatePropertyLootCondition.builder(CinderscapesBlocks.BRAMBLE_BERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(BrambleBerryBushBlock.AGE, 2)))
					.with(ItemEntry.builder(CinderscapesItems.BRAMBLE_BERRIES)).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)))
					.apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE))
			)
		));


		// multi-layer drops
		addDrop(CinderscapesBlocks.ASH, block -> LootTable.builder().pool(LootPool.builder().conditionally(
			EntityPropertiesLootCondition
				.create(LootContext.EntityTarget.THIS)).with(AlternativeEntry.builder(AlternativeEntry.builder(
                    ItemEntry.builder(CinderscapesItems.ASH_PILE).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(AshLayerBlock.LAYERS, 1))),
                	ItemEntry.builder(CinderscapesItems.ASH_PILE).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(AshLayerBlock.LAYERS, 2)))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2))),
                	ItemEntry.builder(CinderscapesItems.ASH_PILE).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(AshLayerBlock.LAYERS, 3)))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(3))),
                	ItemEntry.builder(CinderscapesItems.ASH_PILE).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(AshLayerBlock.LAYERS, 4)))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(4))),
                	ItemEntry.builder(CinderscapesItems.ASH_PILE).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(AshLayerBlock.LAYERS, 5)))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(5))),
                	ItemEntry.builder(CinderscapesItems.ASH_PILE).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(AshLayerBlock.LAYERS, 6)))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(6))),
                	ItemEntry.builder(CinderscapesItems.ASH_PILE).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(AshLayerBlock.LAYERS, 7)))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(7))),
	                ItemEntry.builder(CinderscapesItems.ASH_PILE).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(8)))
				)
				.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.atLeast(1)))).invert()),
                	AlternativeEntry.builder(
                        ItemEntry.builder(CinderscapesBlocks.ASH).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(AshLayerBlock.LAYERS, 1))),
                        ItemEntry.builder(CinderscapesBlocks.ASH).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2))).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(AshLayerBlock.LAYERS, 2))),
                        ItemEntry.builder(CinderscapesBlocks.ASH).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(3))).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(AshLayerBlock.LAYERS, 3))),
                        ItemEntry.builder(CinderscapesBlocks.ASH).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(4))).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(AshLayerBlock.LAYERS, 4))),
                        ItemEntry.builder(CinderscapesBlocks.ASH).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(5))).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(AshLayerBlock.LAYERS, 5))),
                        ItemEntry.builder(CinderscapesBlocks.ASH).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(6))).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(AshLayerBlock.LAYERS, 6))),
                        ItemEntry.builder(CinderscapesBlocks.ASH).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(7))).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(AshLayerBlock.LAYERS, 7))),
                        ItemEntry.builder(CinderscapesBlocks.ASH_BLOCK)
                	)
        		))
		));
	}
}
