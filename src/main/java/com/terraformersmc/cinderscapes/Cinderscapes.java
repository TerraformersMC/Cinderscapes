package com.terraformersmc.cinderscapes;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.command.MapBiomesCommand;
import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import com.terraformersmc.cinderscapes.init.CinderscapesDecorators;
import com.terraformersmc.cinderscapes.init.CinderscapesFeatures;
import com.terraformersmc.cinderscapes.util.NoiseCollisionChecker;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;

public class Cinderscapes implements ModInitializer {

    private static final String MOD_ID = "cinderscapes";

    @Override
    public void onInitialize() {
        CinderscapesBlocks.init();
        CinderscapesDecorators.init();
        CinderscapesFeatures.init();
        CinderscapesBiomes.init();
        MapBiomesCommand.register();

        NoiseCollisionChecker.init();

        FabricItemGroupBuilder.create(new Identifier(MOD_ID, "items")).icon(() -> CinderscapesBlocks.UMBRAL_FUNGUS.asItem().getStackForRender()).appendItems(stacks -> Registry.ITEM.forEach(item -> {
            if (Registry.ITEM.getId(item).getNamespace().equals(MOD_ID)) {
                item.appendStacks(item.getGroup(), (DefaultedList<ItemStack>) stacks);
            }
        })).build();
    }

    public static Identifier id(String s) {
        return new Identifier(MOD_ID, s);
    }
}
