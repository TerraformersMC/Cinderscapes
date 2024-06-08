package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.item.trim.ArmorTrimMaterial;
import net.minecraft.item.trim.ArmorTrimMaterials;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Style;
import net.minecraft.util.Identifier;

public class CinderscapesArmorTrimMaterials {
    public static final RegistryKey<ArmorTrimMaterial> ROSE_QUARTZ = createRegistryKey("rose_quartz");
    public static final RegistryKey<ArmorTrimMaterial> SMOKY_QUARTZ = createRegistryKey("smoky_quartz");
    public static final RegistryKey<ArmorTrimMaterial> SULFUR_QUARTZ = createRegistryKey("sulfur_quartz");

    public static void bootstrap(Registerable<ArmorTrimMaterial> registerable) {
        ArmorTrimMaterials.register(registerable, ROSE_QUARTZ, CinderscapesItems.ROSE_QUARTZ, Style.EMPTY.withColor(0xE77391), 0.40666f);
        ArmorTrimMaterials.register(registerable, SMOKY_QUARTZ, CinderscapesItems.SMOKY_QUARTZ, Style.EMPTY.withColor(0x5a4b46), 0.30666f);
        ArmorTrimMaterials.register(registerable, SULFUR_QUARTZ, CinderscapesItems.SULFUR_QUARTZ, Style.EMPTY.withColor(0xbaa938), 0.60666f);
    }

    private static RegistryKey<ArmorTrimMaterial> createRegistryKey(String id) {
        return RegistryKey.of(RegistryKeys.TRIM_MATERIAL, Identifier.of(Cinderscapes.MOD_ID, id));
    }
}
