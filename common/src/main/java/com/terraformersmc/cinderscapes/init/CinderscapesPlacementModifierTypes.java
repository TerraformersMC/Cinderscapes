package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.placementmodifier.SafelistRangeCeilingPlacementModifier;
import com.terraformersmc.cinderscapes.placementmodifier.SafelistRangeFloorPlacementModifier;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.placementmodifier.PlacementModifierType;

// TODO: Check
public class CinderscapesPlacementModifierTypes {
    public static final PlacementModifierType<SafelistRangeCeilingPlacementModifier> COUNT_CEILING = () -> SafelistRangeCeilingPlacementModifier.UNIFORM_CODEC;
    public static final PlacementModifierType<SafelistRangeFloorPlacementModifier> COUNT_FLOOR  = () -> SafelistRangeFloorPlacementModifier.UNIFORM_CODEC;

    public static void init() {
        Registry.register(Registry.PLACEMENT_MODIFIER_TYPE, new Identifier("cinderscapes", "safelist_range_ceiling"), COUNT_CEILING);
        Registry.register(Registry.PLACEMENT_MODIFIER_TYPE, new Identifier("cinderscapes", "safelist_range_floor"), COUNT_FLOOR);
    }
}
