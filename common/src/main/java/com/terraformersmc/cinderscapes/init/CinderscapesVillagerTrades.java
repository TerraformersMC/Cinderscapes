package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.TradeCost;
import net.minecraft.world.item.trading.VillagerTrade;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Optional;

public class CinderscapesVillagerTrades {
    public static final ResourceKey<VillagerTrade> MASON_4_ROSE_QUARTZ_EMERALD = resourceKey("mason/4/rose_quartz_emerald");
    public static final ResourceKey<VillagerTrade> MASON_4_SULFUR_QUARTZ_EMERALD = resourceKey("mason/4/sulfur_quartz_emerald");
    public static final ResourceKey<VillagerTrade> MASON_4_SMOKY_QUARTZ_EMERALD = resourceKey("mason/4/smoky_quartz_emerald");

    public static final ResourceKey<VillagerTrade> MASON_5_EMERALD_ROSE_QUARTZ_PILLAR = resourceKey("mason/5/emerald_rose_quartz_pillar");
    public static final ResourceKey<VillagerTrade> MASON_5_EMERALD_ROSE_QUARTZ_BLOCK = resourceKey("mason/5/emerald_rose_quartz_block");
    public static final ResourceKey<VillagerTrade> MASON_5_EMERALD_SULFUR_QUARTZ_PILLAR = resourceKey("mason/5/emerald_sulfur_quartz_pillar");
    public static final ResourceKey<VillagerTrade> MASON_5_EMERALD_SULFUR_QUARTZ_BLOCK = resourceKey("mason/5/emerald_sulfur_quartz_block");
    public static final ResourceKey<VillagerTrade> MASON_5_EMERALD_SMOKY_QUARTZ_PILLAR = resourceKey("mason/5/emerald_smoky_quartz_pillar");
    public static final ResourceKey<VillagerTrade> MASON_5_EMERALD_SMOKY_QUARTZ_BLOCK = resourceKey("mason/5/emerald_smoky_quartz_block");

    public static void bootstrap(BootstrapContext<VillagerTrade> context) {
        for (Pair<ResourceKey<VillagerTrade>, Item> pair : List.of(
            Pair.of(MASON_4_ROSE_QUARTZ_EMERALD, CinderscapesItems.ROSE_QUARTZ),
            Pair.of(MASON_4_SULFUR_QUARTZ_EMERALD, CinderscapesItems.SULFUR_QUARTZ),
            Pair.of(MASON_4_SMOKY_QUARTZ_EMERALD, CinderscapesItems.SMOKY_QUARTZ)
        )) {
            context.register(pair.getLeft(), new VillagerTrade(
                new TradeCost(pair.getRight(), 12),
                new ItemStackTemplate(Items.EMERALD),
                12,
                30,
                0.05F,
                Optional.empty(),
                List.of()
            ));
        }

        for (Pair<ResourceKey<VillagerTrade>, BlockItem> pair : List.of(
            Pair.of(MASON_5_EMERALD_ROSE_QUARTZ_PILLAR, CinderscapesItems.ROSE_QUARTZ_PILLAR),
            Pair.of(MASON_5_EMERALD_ROSE_QUARTZ_BLOCK, CinderscapesItems.ROSE_QUARTZ_BLOCK),
            Pair.of(MASON_5_EMERALD_SULFUR_QUARTZ_PILLAR, CinderscapesItems.SULFUR_QUARTZ_PILLAR),
            Pair.of(MASON_5_EMERALD_SULFUR_QUARTZ_BLOCK, CinderscapesItems.SULFUR_QUARTZ_BLOCK),
            Pair.of(MASON_5_EMERALD_SMOKY_QUARTZ_PILLAR, CinderscapesItems.SMOKY_QUARTZ_PILLAR),
            Pair.of(MASON_5_EMERALD_SMOKY_QUARTZ_BLOCK, CinderscapesItems.SMOKY_QUARTZ_BLOCK)
        )) {
            context.register(pair.getLeft(), new VillagerTrade(
                new TradeCost(Items.EMERALD, 1),
                new ItemStackTemplate(pair.getRight()),
                12,
                30,
                0.05F,
                Optional.empty(),
                List.of()
            ));
        }
    }

    public static ResourceKey<VillagerTrade> resourceKey(final String path) {
        return ResourceKey.create(Registries.VILLAGER_TRADE, Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, path));
    }
}
