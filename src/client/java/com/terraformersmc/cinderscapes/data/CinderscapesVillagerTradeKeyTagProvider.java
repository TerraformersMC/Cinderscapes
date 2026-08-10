package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.villager.CinderscapesVillagerTrades;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.VillagerTradeTags;
import net.minecraft.world.item.trading.VillagerTrade;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

@NullMarked
public class CinderscapesVillagerTradeKeyTagProvider extends FabricTagsProvider<VillagerTrade> {
    protected CinderscapesVillagerTradeKeyTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
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
