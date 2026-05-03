package com.terraformersmc.cinderscapes.init;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.resources.Identifier;
import net.ramixin.mixson.Mixson;
import net.ramixin.mixson.MixsonCodecs;
import net.ramixin.mixson.enums.DebugOption;
import net.ramixin.mixson.enums.ErrorPolicy;
import net.ramixin.mixson.enums.Lifetime;

public final class CinderscapesArmorTrimItemModels {
    @SuppressWarnings("UnnecessaryReturnStatement")
    private CinderscapesArmorTrimItemModels() {
        return;
    }

    public static void init() {
        Mixson.enableDebugOption(DebugOption.EXPORT_PATCHED_FILE);
        /*
         * Add trim materials to vanilla atlases.
         */
        registerAddTrimsToAtlas("armor_trims");
        registerAddTrimsToAtlas("items");
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

    private static Identifier paletteId(String trim) {
        return Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, "trims/color_palettes/" + trim);
    }
}
