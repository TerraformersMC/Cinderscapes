package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.block.AshLayerBlock;
import com.terraformersmc.cinderscapes.block.BrambleBerryBushBlock;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.init.CinderscapesItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

@NullMarked
public class CinderscapesBlockLootTableProvider extends FabricBlockLootSubProvider {
	protected CinderscapesBlockLootTableProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	public void generate() {
		HolderLookup.RegistryLookup<Enchantment> enchantmentRegistry = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

		// simple blocks
		dropSelf(CinderscapesBlocks.ASH_BLOCK);
		dropSelf(CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK);
		dropSelf(CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK);
		dropSelf(CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK);
		add(CinderscapesBlocks.CRYSTALLINE_QUARTZ, block -> createOreDrop(block, Items.QUARTZ));
		add(CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ, block -> createOreDrop(block, CinderscapesItems.ROSE_QUARTZ));
		add(CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ, block -> createOreDrop(block, CinderscapesItems.SMOKY_QUARTZ));
		add(CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ, block -> createOreDrop(block, CinderscapesItems.SULFUR_QUARTZ));
		dropSelf(CinderscapesBlocks.CRYSTINIUM);
		add(CinderscapesBlocks.GHASTLY_ECTOPLASM, this::createShearsOnlyDrop);
		add(CinderscapesBlocks.PHOTOFERN, this::createShearsOnlyDrop);
		add(CinderscapesBlocks.POLYPITE_QUARTZ, block -> createOreDrop(block, Items.QUARTZ));
		add(CinderscapesBlocks.POLYPITE_ROSE_QUARTZ, block -> createOreDrop(block, CinderscapesItems.ROSE_QUARTZ));
		add(CinderscapesBlocks.POLYPITE_SMOKY_QUARTZ, block -> createOreDrop(block, CinderscapesItems.SMOKY_QUARTZ));
		add(CinderscapesBlocks.POLYPITE_SULFUR_QUARTZ, block -> createOreDrop(block, CinderscapesItems.SULFUR_QUARTZ));
		dropSelf(CinderscapesBlocks.PYRACINTH);
		dropSelf(CinderscapesBlocks.ROSE_QUARTZ_BLOCK);
		dropSelf(CinderscapesBlocks.ROSE_QUARTZ_BRICKS);
		add(CinderscapesBlocks.ROSE_QUARTZ_ORE, block -> createOreDrop(block, CinderscapesItems.ROSE_QUARTZ));
		dropSelf(CinderscapesBlocks.ROSE_QUARTZ_PILLAR);
		add(CinderscapesBlocks.ROSE_QUARTZ_SLAB, this::createSlabItemTable);
		dropSelf(CinderscapesBlocks.ROSE_QUARTZ_STAIRS);
		add(CinderscapesBlocks.SCORCHED_SHRUB, this::createShearsOnlyDrop);
		add(CinderscapesBlocks.SCORCHED_SPROUTS, this::createShearsOnlyDrop);
		dropSelf(CinderscapesBlocks.SCORCHED_TENDRILS);
		dropSelf(CinderscapesBlocks.SMOKY_QUARTZ_BLOCK);
		dropSelf(CinderscapesBlocks.SMOKY_QUARTZ_BRICKS);
		add(CinderscapesBlocks.SMOKY_QUARTZ_ORE, block -> createOreDrop(block, CinderscapesItems.SMOKY_QUARTZ));
		dropSelf(CinderscapesBlocks.SMOKY_QUARTZ_PILLAR);
		add(CinderscapesBlocks.SMOKY_QUARTZ_SLAB, this::createSlabItemTable);
		dropSelf(CinderscapesBlocks.SMOKY_QUARTZ_STAIRS);
		dropSelf(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ);
		add(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_SLAB, this::createSlabItemTable);
		dropSelf(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_STAIRS);
		dropSelf(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ);
		add(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_SLAB, this::createSlabItemTable);
		dropSelf(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_STAIRS);
		dropSelf(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ);
		add(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_SLAB, this::createSlabItemTable);
		dropSelf(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_STAIRS);
		dropSelf(CinderscapesBlocks.SULFUR_BLOCK);
		add(CinderscapesBlocks.SULFUR_ORE, block -> createOreDrop(block, CinderscapesItems.SULFUR));
		dropSelf(CinderscapesBlocks.SULFUR_QUARTZ_BLOCK);
		dropSelf(CinderscapesBlocks.SULFUR_QUARTZ_BRICKS);
		add(CinderscapesBlocks.SULFUR_QUARTZ_ORE, block -> createOreDrop(block, CinderscapesItems.SULFUR_QUARTZ));
		dropSelf(CinderscapesBlocks.SULFUR_QUARTZ_PILLAR);
		add(CinderscapesBlocks.SULFUR_QUARTZ_SLAB, this::createSlabItemTable);
		dropSelf(CinderscapesBlocks.SULFUR_QUARTZ_STAIRS);
		add(CinderscapesBlocks.TWILIGHT_FESCUES, this::createShearsOnlyDrop);
		dropSelf(CinderscapesBlocks.TWILIGHT_TENDRILS);
		dropSelf(CinderscapesBlocks.TWILIGHT_VINE_BLOCK);
		dropSelf(CinderscapesBlocks.UMBRAL_FLESH_BLOCK);
		otherWhenSilkTouch(CinderscapesBlocks.UMBRAL_NYLIUM, Blocks.NETHERRACK);
		add(CinderscapesBlocks.UMBRAL_NYLIUM, block -> createSingleItemTableWithSilkTouch(block, Items.NETHERRACK));
		dropSelf(CinderscapesBlocks.UMBRAL_WART_BLOCK);


		// wood building blocks
		// TODO: Consider bringing over the WoodBlocks interface from Terrestria
		dropSelf(CinderscapesBlocks.SCORCHED_BUTTON);
		add(CinderscapesBlocks.SCORCHED_DOOR, this::createDoorTable);
		dropSelf(CinderscapesBlocks.SCORCHED_FENCE);
		dropSelf(CinderscapesBlocks.SCORCHED_FENCE_GATE);
		dropSelf(CinderscapesBlocks.SCORCHED_HANGING_SIGN);
		dropSelf(CinderscapesBlocks.SCORCHED_HYPHAE);
		dropSelf(CinderscapesBlocks.SCORCHED_PLANKS);
		dropSelf(CinderscapesBlocks.SCORCHED_PRESSURE_PLATE);
		dropSelf(CinderscapesBlocks.SCORCHED_SHELF);
		dropSelf(CinderscapesBlocks.SCORCHED_SIGN);
		add(CinderscapesBlocks.SCORCHED_SLAB, this::createSlabItemTable);
		dropSelf(CinderscapesBlocks.SCORCHED_STAIRS);
		dropSelf(CinderscapesBlocks.SCORCHED_STEM);
		dropSelf(CinderscapesBlocks.SCORCHED_TRAPDOOR);
		dropSelf(CinderscapesBlocks.SCORCHED_WALL_HANGING_SIGN);
		dropSelf(CinderscapesBlocks.SCORCHED_WALL_SIGN);
		dropSelf(CinderscapesBlocks.STRIPPED_SCORCHED_STEM);
		dropSelf(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE);

		dropSelf(CinderscapesBlocks.UMBRAL_BUTTON);
		add(CinderscapesBlocks.UMBRAL_DOOR, this::createDoorTable);
		dropSelf(CinderscapesBlocks.UMBRAL_FENCE);
		dropSelf(CinderscapesBlocks.UMBRAL_FENCE_GATE);
		dropSelf(CinderscapesBlocks.UMBRAL_FUNGUS);
		dropSelf(CinderscapesBlocks.UMBRAL_HANGING_SIGN);
		dropSelf(CinderscapesBlocks.UMBRAL_HYPHAE);
		dropSelf(CinderscapesBlocks.UMBRAL_PLANKS);
		dropSelf(CinderscapesBlocks.UMBRAL_PRESSURE_PLATE);
		dropSelf(CinderscapesBlocks.UMBRAL_SHELF);
		dropSelf(CinderscapesBlocks.UMBRAL_SIGN);
		add(CinderscapesBlocks.UMBRAL_SLAB, this::createSlabItemTable);
		dropSelf(CinderscapesBlocks.UMBRAL_STAIRS);
		dropSelf(CinderscapesBlocks.UMBRAL_STEM);
		dropSelf(CinderscapesBlocks.UMBRAL_TRAPDOOR);
		dropSelf(CinderscapesBlocks.UMBRAL_WALL_HANGING_SIGN);
		dropSelf(CinderscapesBlocks.UMBRAL_WALL_SIGN);
		dropSelf(CinderscapesBlocks.STRIPPED_UMBRAL_STEM);
		dropSelf(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE);


		// potted things
		dropPottedContents(CinderscapesBlocks.POTTED_CRYSTINIUM);
		dropPottedContents(CinderscapesBlocks.POTTED_LUMINOUS_POD);
		dropPottedContents(CinderscapesBlocks.POTTED_PHOTOFERN);
		dropPottedContents(CinderscapesBlocks.POTTED_POLYPITE_QUARTZ);
		dropPottedContents(CinderscapesBlocks.POTTED_POLYPITE_ROSE_QUARTZ);
		dropPottedContents(CinderscapesBlocks.POTTED_POLYPITE_SMOKY_QUARTZ);
		dropPottedContents(CinderscapesBlocks.POTTED_POLYPITE_SULFUR_QUARTZ);
		dropPottedContents(CinderscapesBlocks.POTTED_PYRACINTH);
		dropPottedContents(CinderscapesBlocks.POTTED_SCORCHED_SHRUB);
		dropPottedContents(CinderscapesBlocks.POTTED_SCORCHED_TENDRILS);
		dropPottedContents(CinderscapesBlocks.POTTED_TWILIGHT_TENDRILS);
		dropPottedContents(CinderscapesBlocks.POTTED_UMBRAL_FUNGUS);


		// tall plant drops
		add(CinderscapesBlocks.LUMINOUS_POD, block -> createShearsOnlyDrop(block).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2))));
		add(CinderscapesBlocks.TALL_PHOTOFERN, createShearsOnlyDrop(CinderscapesBlocks.PHOTOFERN).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2))));


		// berry drops
		add(CinderscapesBlocks.BRAMBLE_BERRY_BUSH, block -> applyExplosionDecay(block, LootTable.lootTable()
			.withPool(
				LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(CinderscapesBlocks.BRAMBLE_BERRY_BUSH).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BrambleBerryBushBlock.AGE, 3)))
					.add(LootItem.lootTableItem(CinderscapesItems.BRAMBLE_BERRIES)).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 3.0f)))
					.apply(ApplyBonusCount.addUniformBonusCount(enchantmentRegistry.getOrThrow(Enchantments.FORTUNE)))
			)
			.withPool(
				LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(CinderscapesBlocks.BRAMBLE_BERRY_BUSH).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BrambleBerryBushBlock.AGE, 2)))
					.add(LootItem.lootTableItem(CinderscapesItems.BRAMBLE_BERRIES)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)))
					.apply(ApplyBonusCount.addUniformBonusCount(enchantmentRegistry.getOrThrow(Enchantments.FORTUNE)))
			)
		));


		// multi-layer drops
		add(CinderscapesBlocks.ASH, block -> LootTable.lootTable().withPool(LootPool.lootPool().when(
				LootItemEntityPropertyCondition.entityPresent(LootContext.EntityTarget.THIS))
					.add(AlternativesEntry.alternatives(
							AlternativesEntry.alternatives(
									AshLayerBlock.LAYERS.getPossibleValues(), layers -> LootItem.lootTableItem(CinderscapesItems.ASH_PILE)
											.when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(AshLayerBlock.LAYERS, layers)))
											.apply(SetItemCountFunction.setCount(ConstantValue.exactly(layers)))
							).when(doesNotHaveSilkTouch()),
								AlternativesEntry.alternatives(
										AshLayerBlock.LAYERS.getPossibleValues(), layers -> layers == 8 ? LootItem.lootTableItem(CinderscapesBlocks.ASH_BLOCK) : LootItem.lootTableItem(CinderscapesBlocks.ASH)
												.when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(AshLayerBlock.LAYERS, layers)))
												.apply(SetItemCountFunction.setCount(ConstantValue.exactly(layers)))
								)
					))
		));
	}

	@Override
	public String getName() {
		return "Cinderscapes Block Loot Tables";
	}
}
