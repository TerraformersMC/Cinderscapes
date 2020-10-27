package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.loottables.IntegratedEntry;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootSupplierBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.mixin.loot.table.LootSupplierBuilderHooks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.UniformLootTableRange;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntryType;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import java.util.List;

public class CinderscapesTrades {

    private static final Identifier BARTERING_LOOT_TABLE_ID = new Identifier("minecraft", "gameplay/piglin_bartering");

    public static final LootPoolEntryType INTEGRATED = Registry.register(Registry.LOOT_POOL_ENTRY_TYPE, Cinderscapes.id("integrated"), new LootPoolEntryType(new IntegratedEntry.Serializer()));

    public static void init() {

        LootTableLoadingCallback.EVENT.register((resourceManager, manager, id, supplier, setter) -> {
            if (BARTERING_LOOT_TABLE_ID.equals(id)) {
                List<LootPool> pools = ((LootSupplierBuilderHooks) supplier).getPools();
                pools.set(0, FabricLootPoolBuilder.of(pools.get(0))
                        .withEntry(new IntegratedEntry(CinderscapesItems.ROSE_QUARTZ, 20, 0, new LootCondition[]{}, new LootFunction[]{SetCountLootFunction.builder(new UniformLootTableRange(5, 12)).build()}))
                        .withEntry(new IntegratedEntry(CinderscapesItems.SMOKY_QUARTZ, 20, 0, new LootCondition[]{}, new LootFunction[]{SetCountLootFunction.builder(new UniformLootTableRange(5, 12)).build()}))
                        .withEntry(new IntegratedEntry(CinderscapesItems.SULFUR_QUARTZ, 20, 0, new LootCondition[]{}, new LootFunction[]{SetCountLootFunction.builder(new UniformLootTableRange(5, 12)).build()}))
                        .build());
                setter.set(FabricLootSupplierBuilder.builder().withPools(pools).build());
            }
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, (factories) -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(CinderscapesItems.ROSE_QUARTZ, 12), new ItemStack(Items.EMERALD), 12, 30, 0.05F));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(CinderscapesItems.SULFUR_QUARTZ, 12), new ItemStack(Items.EMERALD), 12, 30, 0.05F));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(CinderscapesItems.SMOKY_QUARTZ, 12), new ItemStack(Items.EMERALD), 12, 30, 0.05F));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 5, (factories) -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(CinderscapesBlocks.ROSE_QUARTZ_PILLAR, 1), 12, 30, 0.05F));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(CinderscapesBlocks.ROSE_QUARTZ_BLOCK, 1), 12, 30, 0.05F));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(CinderscapesBlocks.SULFUR_QUARTZ_PILLAR, 1), 12, 30, 0.05F));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(CinderscapesBlocks.SULFUR_QUARTZ_BLOCK, 1), 12, 30, 0.05F));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(CinderscapesBlocks.SMOKY_QUARTZ_PILLAR, 1), 12, 30, 0.05F));
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(CinderscapesBlocks.SMOKY_QUARTZ_BLOCK, 1), 12, 30, 0.05F));
        });
    }
}
