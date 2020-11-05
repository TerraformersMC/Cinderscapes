package com.terraformersmc.cinderscapes.helper;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.mixin.SoundEventAccessor;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

public class RegistryHelper {

    public static <B extends Block> B register(String blockName, B block) {
        return Registry.register(Registry.BLOCK, Cinderscapes.id(blockName), block);
    }

    public static <I extends Item> I register(String itemName, I item) {
        return Registry.register(Registry.ITEM, Cinderscapes.id(itemName), item);
    }

    public static <B extends Block> B register(String blockName, B block, Item.Settings settings) {
        register(blockName, new BlockItem(block, settings));
        return register(blockName, block);
    }

    public static <B extends Block> B register(String blockName, B block, ItemGroup group) {
        return register(blockName, block, new FabricItemSettings().group(group));
    }

    public static <B extends Block> B register(String blockName, B block, String itemName, Item.Settings settings) {
        register(itemName, new AliasedBlockItem(block, settings));
        return register(blockName, block);
    }

    public static <S extends SoundEvent> S register(S soundEvent) {
        return Registry.register(Registry.SOUND_EVENT, ((SoundEventAccessor) soundEvent).getId(), soundEvent);
    }

    // TODO: I like the idea of storing everything as a registry key from now on

    public static RegistryKey<Biome> register(String biomeName, Biome biome) {
        Registry.register(BuiltinRegistries.BIOME, Cinderscapes.id(biomeName), biome);
        return RegistryKey.of(Registry.BIOME_KEY, Cinderscapes.id(biomeName));
    }

}
