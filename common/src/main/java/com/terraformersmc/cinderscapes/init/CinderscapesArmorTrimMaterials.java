package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;
import net.minecraft.item.trim.ArmorTrimMaterial;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

@SuppressWarnings("UnstableApiUsage")
public class CinderscapesArmorTrimMaterials {
    public static final RegistryKey<ArmorTrimMaterial> ROSE_QUARTZ = CinderscapesArmorTrimMaterials.of("rose_quartz");
    public static final RegistryKey<ArmorTrimMaterial> SMOKY_QUARTZ = CinderscapesArmorTrimMaterials.of("smoky_quartz");
    public static final RegistryKey<ArmorTrimMaterial> SULFUR_QUARTZ = CinderscapesArmorTrimMaterials.of("sulfur_quartz");

    public static void populate(FabricDynamicRegistryProvider.Entries entries) {
        register(entries, ROSE_QUARTZ, CinderscapesItems.ROSE_QUARTZ, Style.EMPTY.withColor(0xE77391), 0.40666f);
        register(entries, SMOKY_QUARTZ, CinderscapesItems.SMOKY_QUARTZ, Style.EMPTY.withColor(0x5a4b46), 0.30666f);
        register(entries, SULFUR_QUARTZ, CinderscapesItems.SULFUR_QUARTZ, Style.EMPTY.withColor(0xbaa938), 0.60666f);
    }

    private static void register(FabricDynamicRegistryProvider.Entries entries, RegistryKey<ArmorTrimMaterial> key, Item ingredient, Style style, float itemModelIndex) {
        register(entries, key, ingredient, style, itemModelIndex, Map.of());
    }

    private static void register(FabricDynamicRegistryProvider.Entries entries, RegistryKey<ArmorTrimMaterial> key, Item ingredient, Style style, float itemModelIndex, Map<ArmorMaterials, String> overrideArmorMaterials) {
        ArmorTrimMaterial lv = ArmorTrimMaterial.of(key.getValue().getPath(), ingredient, itemModelIndex, Text.translatable(Util.createTranslationKey("trim_material", key.getValue())).fillStyle(style), overrideArmorMaterials);
        entries.add(key, lv);
    }

    private static RegistryKey<ArmorTrimMaterial> of(String id) {
        return RegistryKey.of(RegistryKeys.TRIM_MATERIAL, Identifier.of(Cinderscapes.NAMESPACE, id));
    }
}
