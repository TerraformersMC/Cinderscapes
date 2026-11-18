package com.terraformersmc.cinderscapes.init;

import com.mojang.serialization.MapCodec;
import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.placementmodifier.SafelistRangeCeilingPlacementModifier;
import com.terraformersmc.cinderscapes.placementmodifier.SafelistRangeFloorPlacementModifier;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class CinderscapesPlacementModifierTypes {
    public static final ResourceKey<MapCodec<? extends PlacementModifier>> COUNT_CEILING_MODIFIER = resourceKey("count_ceiling_modifier");
    public static final ResourceKey<MapCodec<? extends PlacementModifier>> COUNT_FLOOR_MODIFIER = resourceKey("count_floor_modifier");

    public static void init() {
        Registry.register(BuiltInRegistries.PLACEMENT_MODIFIER_TYPE, COUNT_CEILING_MODIFIER, SafelistRangeCeilingPlacementModifier.CODEC);
        Registry.register(BuiltInRegistries.PLACEMENT_MODIFIER_TYPE, COUNT_FLOOR_MODIFIER, SafelistRangeFloorPlacementModifier.CODEC);
    }

    private static ResourceKey<MapCodec<? extends PlacementModifier>> resourceKey(String path) {
        return ResourceKey.create(Registries.PLACEMENT_MODIFIER_TYPE, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, path));
    }
}
