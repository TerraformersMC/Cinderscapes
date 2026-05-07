package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.villager.CinderscapesVillagerTrades;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.KeyTagProvider;
import net.minecraft.tags.VillagerTradeTags;
import net.minecraft.world.item.trading.VillagerTrade;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

@NullMarked
public class CinderscapesVillagerTradeKeyTagProvider extends KeyTagProvider<VillagerTrade> {
    protected CinderscapesVillagerTradeKeyTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, Registries.VILLAGER_TRADE, lookupProvider);
    }

    @Override
    public void addTags(HolderLookup.Provider registries) {
        this.tag(VillagerTradeTags.MASON_LEVEL_4)
                .add(CinderscapesVillagerTrades.MASON_4_ROSE_QUARTZ_EMERALD)
                .add(CinderscapesVillagerTrades.MASON_4_SMOKY_QUARTZ_EMERALD)
                .add(CinderscapesVillagerTrades.MASON_4_SULFUR_QUARTZ_EMERALD);

        this.tag(VillagerTradeTags.MASON_LEVEL_5)
                .add(CinderscapesVillagerTrades.MASON_5_EMERALD_ROSE_QUARTZ_PILLAR)
                .add(CinderscapesVillagerTrades.MASON_5_EMERALD_SMOKY_QUARTZ_PILLAR)
                .add(CinderscapesVillagerTrades.MASON_5_EMERALD_SULFUR_QUARTZ_PILLAR)
                .add(CinderscapesVillagerTrades.MASON_5_EMERALD_ROSE_QUARTZ_BLOCK)
                .add(CinderscapesVillagerTrades.MASON_5_EMERALD_SMOKY_QUARTZ_BLOCK)
                .add(CinderscapesVillagerTrades.MASON_5_EMERALD_SULFUR_QUARTZ_BLOCK);
        }
    }
