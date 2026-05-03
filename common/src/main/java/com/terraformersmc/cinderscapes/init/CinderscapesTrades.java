package com.terraformersmc.cinderscapes.init;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class CinderscapesTrades {
    public static void init() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (BuiltInLootTables.PIGLIN_BARTERING.equals(key)) {
                tableBuilder.modifyPools((pools) ->
                    pools.add(LootItem.lootTableItem(CinderscapesItems.ROSE_QUARTZ).setWeight(20).setQuality(0).apply(SetItemCountFunction.setCount(UniformGenerator.between(5, 12))).build())
                            .add(LootItem.lootTableItem(CinderscapesItems.SMOKY_QUARTZ).setWeight(20).setQuality(0).apply(SetItemCountFunction.setCount(UniformGenerator.between(5, 12))).build())
                            .add(LootItem.lootTableItem(CinderscapesItems.SULFUR_QUARTZ).setWeight(20).setQuality(0).apply(SetItemCountFunction.setCount(UniformGenerator.between(5, 12))).build())
                );
            }
        });
    }
}
