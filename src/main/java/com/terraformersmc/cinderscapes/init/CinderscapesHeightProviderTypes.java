package com.terraformersmc.cinderscapes.init;


import com.terraformersmc.cinderscapes.placementModifier.SafelistRangeCeilingPlacementModifier;
import com.terraformersmc.cinderscapes.placementModifier.SafelistRangeFloorPlacementModifier;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.placementmodifier.PlacementModifierType;


// TODO: Check
public class CinderscapesHeightProviderTypes {
    public static PlacementModifierType<SafelistRangeCeilingPlacementModifier> COUNT_CEILING;
    public static PlacementModifierType<SafelistRangeFloorPlacementModifier> COUNT_FLOOR;

    public static void init() {
        COUNT_CEILING = Registry.register(Registry.PLACEMENT_MODIFIER_TYPE, new Identifier("cinderscapes", "safelist_range_ceiling"), () -> SafelistRangeCeilingPlacementModifier.UNIFORM_CODEC);
        COUNT_FLOOR = Registry.register(Registry.PLACEMENT_MODIFIER_TYPE, new Identifier("cinderscapes", "safelist_range_floor"), () -> SafelistRangeFloorPlacementModifier.UNIFORM_CODEC);
    }
}
