package com.terraformersmc.cinderscapes.patches;

import net.fabricmc.fabric.mixin.object.builder.SpawnRestrictionAccessor;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.ZoglinEntity;
import net.minecraft.world.Heightmap;

public class PatchZoglinSpawning {
    public static void onInitialize() {
        try { SpawnRestrictionAccessor.callRegister(EntityType.ZOGLIN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ZoglinEntity::canMobSpawn); } catch (IllegalStateException e) { }
    }
}
