package com.terraformersmc.cinderscapes.init;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.resources.Identifier;
import net.ramixin.mixson.Mixson;
import net.ramixin.mixson.MixsonCodecs;
import net.ramixin.mixson.enums.ErrorPolicy;
import net.ramixin.mixson.enums.Lifetime;

import java.util.List;

public final class CinderscapesArmorTrimItemModels {
    private static final List<String> ARMORS = List.of("helmet", "chestplate", "leggings", "boots");
    private static final List<String> ARMOR_MATERIALS = List.of("leather", "copper", "chainmail", "iron", "golden", "diamond", "netherite");
    @SuppressWarnings("UnnecessaryReturnStatement")
    private CinderscapesArmorTrimItemModels() {
        return;
    }

    public static void init() {
        ARMORS.forEach(armor -> ARMOR_MATERIALS.forEach(armorMaterial -> registerAddTrimsToArmor(armor, armorMaterial)));

        registerAddTrimsToArmor("helmet", "turtle");
        /*
         * Add trim materials to vanilla atlases.
         */
        registerAddTrimsToAtlas("armor_trims");
        registerAddTrimsToAtlas("items");
    }

    private static void registerAddTrimsToArmor(String armor, String armorMaterial) {
        Mixson.registerEvent(
            MixsonCodecs.JSON_ELEMENT,
            Mixson.DEFAULT_PRIORITY,
            Lifetime.PERSISTENT,
            ErrorPolicy.LOG,
            Cinderscapes.MOD_ID + ":add_trims_to_" + armorMaterial + "_" + armor,
            index -> Identifier.withDefaultNamespace("items/" + armorMaterial + "_" + armor).equals(index.id()),
            context -> {
                JsonElement elem = context.getFile();
                JsonObject root = elem.getAsJsonObject();
                JsonObject model = root.getAsJsonObject("model");
                JsonArray cases = model.getAsJsonArray("cases");
                JsonObject case0 = cases.get(0).getAsJsonObject();

                CinderscapesArmorTrimMaterials.TRIM_MATERIALS.forEach(trim -> {
                    JsonObject newCase = case0.deepCopy();

                    newCase.addProperty("when", trimMaterialId(trim).toString());
                    newCase.getAsJsonObject("model")
                        .addProperty("model", itemModelId(armor, armorMaterial, trim).toString());

                    cases.add(newCase);
                });
            }
        );
    }

    private static void registerAddTrimsToAtlas(String name) {
        Mixson.registerEvent(
                MixsonCodecs.JSON_ELEMENT,
                Mixson.DEFAULT_PRIORITY,
                Lifetime.PERSISTENT,
                ErrorPolicy.LOG,
                Cinderscapes.MOD_ID + ":add_trims_to_" + name + "_atlas",
                index -> Identifier.withDefaultNamespace("atlases/" + name).equals(index.id()),
            context -> {
                JsonElement elem = context.getFile();
                JsonObject root = elem.getAsJsonObject();
                JsonArray sources = root.getAsJsonArray("sources");

                for (int i = 0; i < sources.size(); ++i) {
                    JsonObject source = sources.get(i).getAsJsonObject();

                    if ("minecraft:paletted_permutations".equals(source.getAsJsonPrimitive("type").getAsString())) {
                        JsonObject permutations = source.getAsJsonObject("permutations");

                        CinderscapesArmorTrimMaterials.TRIM_MATERIALS.forEach(trim ->
                                permutations.addProperty(trim, paletteId(trim).toString())
                        );

                        break;
                    }
                }
            }
        );
    }
    private static Identifier trimMaterialId(String trim) {
        return Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, trim);
    }

    private static Identifier itemModelId(String armor, String armorMaterial, String trim) {
        return Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, "item/" + armorMaterial + "_" + armor + "_" + trim + "_trim");
    }

    private static Identifier paletteId(String trim) {
        return Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, "trims/color_palettes/" + trim);
    }
}
