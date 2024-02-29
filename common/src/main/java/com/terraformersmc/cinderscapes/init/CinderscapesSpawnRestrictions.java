package com.terraformersmc.cinderscapes.init;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnLocation;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.ZoglinEntity;
import net.minecraft.world.Heightmap;

public class CinderscapesSpawnRestrictions {
    public static void init() {
            register(EntityType.ZOGLIN, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ZoglinEntity::canMobSpawn);
    }

    // Register ignoring if somebody else has already done so.
    private static <T extends MobEntity> void register(EntityType<T> type, SpawnLocation location, Heightmap.Type heightmapType, SpawnRestriction.SpawnPredicate<T> predicate) {
        try {
            SpawnRestriction.register(type, location, heightmapType, predicate);
        } catch (IllegalStateException ignored) { }
    }
}
