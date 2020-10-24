package com.terraformersmc.cinderscapes.loottables;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.terraformersmc.cinderscapes.init.CinderscapesTrades;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntryType;
import net.minecraft.loot.entry.LootPoolEntryTypes;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.registry.Registry;

import java.util.function.Consumer;

public class IntegratedEntry extends LeafEntry {
    private final Item item;

    public IntegratedEntry(Item item, int weight, int quality, LootCondition[] conditions, LootFunction[] functions) {
        super(weight, quality, conditions, functions);
        this.item = item;
    }

    @Override
    public LootPoolEntryType getType() {
        return CinderscapesTrades.INTEGRATED;
    }

    @Override
    protected void generateLoot(Consumer<ItemStack> lootConsumer, LootContext context) {
        lootConsumer.accept(new ItemStack(this.item));
    }

    public static class Serializer extends LeafEntry.Serializer<IntegratedEntry> {
        public void addEntryFields(JsonObject jsonObject, IntegratedEntry itemEntry, JsonSerializationContext jsonSerializationContext) {
            super.addEntryFields(jsonObject, itemEntry, jsonSerializationContext);
            Identifier identifier = Registry.ITEM.getId(itemEntry.item);
            if (identifier == null) {
                throw new IllegalArgumentException("Can't serialize unknown item " + itemEntry.item);
            } else {
                jsonObject.addProperty("name", identifier.toString());
            }
        }

        protected IntegratedEntry fromJson(JsonObject jsonObject, JsonDeserializationContext jsonDeserializationContext, int i, int j, LootCondition[] lootConditions, LootFunction[] lootFunctions) {
            Item item = JsonHelper.getItem(jsonObject, "name");
            return new IntegratedEntry(item, i, j, lootConditions, lootFunctions);
        }
    }
}
