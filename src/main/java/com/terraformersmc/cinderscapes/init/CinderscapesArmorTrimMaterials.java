package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.minecraft.world.item.equipment.trim.TrimMaterials;

import java.util.List;

public class CinderscapesArmorTrimMaterials {
    public static final List<String> TRIM_MATERIALS = List.of("cinderscapes_rose_quartz", "cinderscapes_smoky_quartz", "cinderscapes_sulfur_quartz");

    public static final ResourceKey<TrimMaterial> ROSE_QUARTZ = createRegistryKey("cinderscapes_rose_quartz");
    public static final ResourceKey<TrimMaterial> SMOKY_QUARTZ = createRegistryKey("cinderscapes_smoky_quartz");
    public static final ResourceKey<TrimMaterial> SULFUR_QUARTZ = createRegistryKey("cinderscapes_sulfur_quartz");

    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        TrimMaterials.register(context, ROSE_QUARTZ, Style.EMPTY.withColor(0xE77391), CinderscapesArmorTrimAssets.ROSE_QUARTZ);
        TrimMaterials.register(context, SMOKY_QUARTZ, Style.EMPTY.withColor(0x5a4b46), CinderscapesArmorTrimAssets.SMOKY_QUARTZ);
        TrimMaterials.register(context, SULFUR_QUARTZ, Style.EMPTY.withColor(0xbaa938), CinderscapesArmorTrimAssets.SULFUR_QUARTZ);
    }

    private static ResourceKey<TrimMaterial> createRegistryKey(String id) {
        return ResourceKey.create(Registries.TRIM_MATERIAL, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, id));
    }
}
