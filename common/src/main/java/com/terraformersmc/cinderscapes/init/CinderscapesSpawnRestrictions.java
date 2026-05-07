package com.terraformersmc.cinderscapes.init;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Zoglin;
import net.minecraft.world.level.levelgen.Heightmap;

public class CinderscapesSpawnRestrictions {
    public static void init() {
            register(EntityType.ZOGLIN, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Zoglin::checkMobSpawnRules);
    }

    // Register ignoring if somebody else has already done so.
    private static <T extends Mob> void register(EntityType<T> type, SpawnPlacementType location, Heightmap.Types heightmapType, SpawnPlacements.SpawnPredicate<T> predicate) {
        try {
            SpawnPlacements.register(type, location, heightmapType, predicate);
        } catch (IllegalStateException ignored) { }
    }
}
