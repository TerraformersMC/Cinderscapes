package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.item.equipment.trim.ArmorTrimMaterial;
import net.minecraft.item.equipment.trim.ArmorTrimMaterials;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Style;
import net.minecraft.util.Identifier;

import java.util.List;

public class CinderscapesArmorTrimMaterials {
    public static final List<String> TRIM_MATERIALS = List.of("cinderscapes_rose_quartz", "cinderscapes_smoky_quartz", "cinderscapes_sulfur_quartz");

    public static final RegistryKey<ArmorTrimMaterial> ROSE_QUARTZ = createRegistryKey("cinderscapes_rose_quartz");
    public static final RegistryKey<ArmorTrimMaterial> SMOKY_QUARTZ = createRegistryKey("cinderscapes_smoky_quartz");
    public static final RegistryKey<ArmorTrimMaterial> SULFUR_QUARTZ = createRegistryKey("cinderscapes_sulfur_quartz");

    public static void bootstrap(Registerable<ArmorTrimMaterial> registerable) {
        ArmorTrimMaterials.register(registerable, ROSE_QUARTZ, Style.EMPTY.withColor(0xE77391), CinderscapesArmorTrimAssets.ROSE_QUARTZ);
        ArmorTrimMaterials.register(registerable, SMOKY_QUARTZ, Style.EMPTY.withColor(0x5a4b46), CinderscapesArmorTrimAssets.SMOKY_QUARTZ);
        ArmorTrimMaterials.register(registerable, SULFUR_QUARTZ, Style.EMPTY.withColor(0xbaa938), CinderscapesArmorTrimAssets.SULFUR_QUARTZ);
    }

    private static RegistryKey<ArmorTrimMaterial> createRegistryKey(String id) {
        return RegistryKey.of(RegistryKeys.TRIM_MATERIAL, Identifier.of(Cinderscapes.MOD_ID, id));
    }
}
