package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Util;
import net.minecraft.world.item.equipment.trim.TrimMaterial;

public class CinderscapesTrimMaterials {
    public static final ResourceKey<TrimMaterial> ROSE_QUARTZ = key("cinderscapes_rose_quartz");
    public static final ResourceKey<TrimMaterial> SMOKY_QUARTZ = key("cinderscapes_smoky_quartz");
    public static final ResourceKey<TrimMaterial> SULFUR_QUARTZ = key("cinderscapes_sulfur_quartz");

    public static final Identifier ROSE_QUARTZ_PALETTE = paletteId("cinderscapes_rose_quartz");
    public static final Identifier SMOKY_QUARTZ_PALETTE = paletteId("cinderscapes_smoky_quartz");
    public static final Identifier SULFUR_QUARTZ_PALETTE = paletteId("cinderscapes_sulfur_quartz");

    private static ResourceKey<TrimMaterial> key(String name) {
        return ResourceKey.create(Registries.TRIM_MATERIAL, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, name));
    }

    private static Identifier paletteId(String name) {
        return Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, "trim/" + name);
    }

    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        register(context, ROSE_QUARTZ, ROSE_QUARTZ_PALETTE, 0xE77391);
        register(context, SMOKY_QUARTZ, SMOKY_QUARTZ_PALETTE, 0x5a4b46);
        register(context, SULFUR_QUARTZ, SULFUR_QUARTZ_PALETTE, 0xbaa938);
    }

    private static void register(BootstrapContext<TrimMaterial> context, ResourceKey<TrimMaterial> key, Identifier paletteId, int color) {
        Component description = Component.translatable(Util.makeDescriptionId("trim_material", key.identifier()))
                .withStyle(Style.EMPTY.withColor(color));

        context.register(key, new TrimMaterial(paletteId, description));
    }
}
