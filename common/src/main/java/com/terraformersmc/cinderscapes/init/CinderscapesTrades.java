package com.terraformersmc.cinderscapes.init;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

public class CinderscapesTrades {
    public static void init() {

        LootTableEvents.MODIFY.register((key, supplier, setter) -> {
            if (LootTables.PIGLIN_BARTERING_GAMEPLAY.equals(key)) {
                supplier.modifyPools((pools) ->
                    pools   .with(ItemEntry.builder(CinderscapesItems.ROSE_QUARTZ).weight(20).quality(0).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5, 12))).build())
                            .with(ItemEntry.builder(CinderscapesItems.SMOKY_QUARTZ).weight(20).quality(0).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5, 12))).build())
                            .with(ItemEntry.builder(CinderscapesItems.SULFUR_QUARTZ).weight(20).quality(0).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5, 12))).build())
                );
            }
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, (factories) -> {
            factories.add((entity, random) -> new TradeOffer(new TradedItem(CinderscapesItems.ROSE_QUARTZ, 12), new ItemStack(Items.EMERALD), 12, 30, 0.05F));
            factories.add((entity, random) -> new TradeOffer(new TradedItem(CinderscapesItems.SULFUR_QUARTZ, 12), new ItemStack(Items.EMERALD), 12, 30, 0.05F));
            factories.add((entity, random) -> new TradeOffer(new TradedItem(CinderscapesItems.SMOKY_QUARTZ, 12), new ItemStack(Items.EMERALD), 12, 30, 0.05F));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 5, (factories) -> {
            factories.add((entity, random) -> new TradeOffer(new TradedItem(Items.EMERALD, 1), new ItemStack(CinderscapesBlocks.ROSE_QUARTZ_PILLAR, 1), 12, 30, 0.05F));
            factories.add((entity, random) -> new TradeOffer(new TradedItem(Items.EMERALD, 1), new ItemStack(CinderscapesBlocks.ROSE_QUARTZ_BLOCK, 1), 12, 30, 0.05F));
            factories.add((entity, random) -> new TradeOffer(new TradedItem(Items.EMERALD, 1), new ItemStack(CinderscapesBlocks.SULFUR_QUARTZ_PILLAR, 1), 12, 30, 0.05F));
            factories.add((entity, random) -> new TradeOffer(new TradedItem(Items.EMERALD, 1), new ItemStack(CinderscapesBlocks.SULFUR_QUARTZ_BLOCK, 1), 12, 30, 0.05F));
            factories.add((entity, random) -> new TradeOffer(new TradedItem(Items.EMERALD, 1), new ItemStack(CinderscapesBlocks.SMOKY_QUARTZ_PILLAR, 1), 12, 30, 0.05F));
            factories.add((entity, random) -> new TradeOffer(new TradedItem(Items.EMERALD, 1), new ItemStack(CinderscapesBlocks.SMOKY_QUARTZ_BLOCK, 1), 12, 30, 0.05F));
        });
    }
}
