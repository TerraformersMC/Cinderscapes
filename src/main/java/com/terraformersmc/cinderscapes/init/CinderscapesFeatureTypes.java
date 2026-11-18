package com.terraformersmc.cinderscapes.init;

import com.mojang.serialization.MapCodec;
import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.feature.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.Feature;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class CinderscapesFeatureTypes {
    public static final ResourceKey<MapCodec<? extends Feature>> ASH_PILE = resourceKey("ash_pile");
    public static final ResourceKey<MapCodec<? extends Feature>> ASH_TOP_LAYER = resourceKey("ash_top_layer");
    public static final ResourceKey<MapCodec<? extends Feature>> BLACKSTONE_WEEPING_VINES = resourceKey("blackstone_weeping_vines");
    public static final ResourceKey<MapCodec<? extends Feature>> CANOPIED_HUGE_FUNGUS = resourceKey("canopied_huge_fungus");
    public static final ResourceKey<MapCodec<? extends Feature>> CRYSTAL_SHARD = resourceKey("crystal_shard");
    public static final ResourceKey<MapCodec<? extends Feature>> DEAD_TREE = resourceKey("dead_tree");
    public static final ResourceKey<MapCodec<? extends Feature>> POLYPITE_QUARTZ = resourceKey("polypite_quartz");
    public static final ResourceKey<MapCodec<? extends Feature>> SHALE = resourceKey("shale");
    public static final ResourceKey<MapCodec<? extends Feature>> SHROOMLIGHT_BUSH = resourceKey("shroomlight_bush");
    public static final ResourceKey<MapCodec<? extends Feature>> UMBRAL_VINE = resourceKey("umbral_vine");
    public static final ResourceKey<MapCodec<? extends Feature>> VEGETATION = resourceKey("vegetation");

    public static void init() {
        Registry.register(BuiltInRegistries.FEATURE_TYPE, ASH_PILE, AshPileFeature.CODEC);
        Registry.register(BuiltInRegistries.FEATURE_TYPE, ASH_TOP_LAYER, AshTopLayerFeature.CODEC);
        Registry.register(BuiltInRegistries.FEATURE_TYPE, BLACKSTONE_WEEPING_VINES, BlackstoneWeepingVinesFeature.CODEC);
        Registry.register(BuiltInRegistries.FEATURE_TYPE, CANOPIED_HUGE_FUNGUS, CanopiedHugeFungusFeature.CODEC);
        Registry.register(BuiltInRegistries.FEATURE_TYPE, CRYSTAL_SHARD, CrystalShardFeature.CODEC);
        Registry.register(BuiltInRegistries.FEATURE_TYPE, DEAD_TREE, DeadTreeFeature.CODEC);
        Registry.register(BuiltInRegistries.FEATURE_TYPE, POLYPITE_QUARTZ, PolypiteQuartzFeature.CODEC);
        Registry.register(BuiltInRegistries.FEATURE_TYPE, SHALE, ShaleFeature.CODEC);
        Registry.register(BuiltInRegistries.FEATURE_TYPE, SHROOMLIGHT_BUSH, ShroomlightBushFeature.CODEC);
        Registry.register(BuiltInRegistries.FEATURE_TYPE, UMBRAL_VINE, UmbralVineFeature.CODEC);
        Registry.register(BuiltInRegistries.FEATURE_TYPE, VEGETATION, VegetationFeature.CODEC);
    }

    private static ResourceKey<MapCodec<? extends Feature>> resourceKey(String path) {
        return ResourceKey.create(Registries.FEATURE_TYPE, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, path));
    }
}
