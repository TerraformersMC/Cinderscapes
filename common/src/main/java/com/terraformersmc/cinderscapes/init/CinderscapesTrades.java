package com.terraformersmc.cinderscapes.init;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.entity.npc.villager.VillagerProfession;

public class CinderscapesTrades {
    public static void init() {

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (BuiltInLootTables.PIGLIN_BARTERING.equals(key)) {
                tableBuilder.modifyPools((pools) ->
                    pools   .with(LootItem.lootTableItem(CinderscapesItems.ROSE_QUARTZ).setWeight(20).setQuality(0).apply(SetItemCountFunction.setCount(UniformGenerator.between(5, 12))).build())
                            .with(LootItem.lootTableItem(CinderscapesItems.SMOKY_QUARTZ).setWeight(20).setQuality(0).apply(SetItemCountFunction.setCount(UniformGenerator.between(5, 12))).build())
                            .with(LootItem.lootTableItem(CinderscapesItems.SULFUR_QUARTZ).setWeight(20).setQuality(0).apply(SetItemCountFunction.setCount(UniformGenerator.between(5, 12))).build())
                );
            }
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 4, (factories) -> {
            factories.add((world, entity, random) -> new MerchantOffer(new ItemCost(CinderscapesItems.ROSE_QUARTZ, 12), new ItemStack(Items.EMERALD), 12, 30, 0.05F));
            factories.add((world, entity, random) -> new MerchantOffer(new ItemCost(CinderscapesItems.SULFUR_QUARTZ, 12), new ItemStack(Items.EMERALD), 12, 30, 0.05F));
            factories.add((world, entity, random) -> new MerchantOffer(new ItemCost(CinderscapesItems.SMOKY_QUARTZ, 12), new ItemStack(Items.EMERALD), 12, 30, 0.05F));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 5, (factories) -> {
            factories.add((world, entity, random) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), new ItemStack(CinderscapesBlocks.ROSE_QUARTZ_PILLAR, 1), 12, 30, 0.05F));
            factories.add((world, entity, random) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), new ItemStack(CinderscapesBlocks.ROSE_QUARTZ_BLOCK, 1), 12, 30, 0.05F));
            factories.add((world, entity, random) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), new ItemStack(CinderscapesBlocks.SULFUR_QUARTZ_PILLAR, 1), 12, 30, 0.05F));
            factories.add((world, entity, random) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), new ItemStack(CinderscapesBlocks.SULFUR_QUARTZ_BLOCK, 1), 12, 30, 0.05F));
            factories.add((world, entity, random) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), new ItemStack(CinderscapesBlocks.SMOKY_QUARTZ_PILLAR, 1), 12, 30, 0.05F));
            factories.add((world, entity, random) -> new MerchantOffer(new ItemCost(Items.EMERALD, 1), new ItemStack(CinderscapesBlocks.SMOKY_QUARTZ_BLOCK, 1), 12, 30, 0.05F));
        });
    }
}
