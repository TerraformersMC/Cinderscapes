package com.terraformersmc.cinderscapes;

import com.terraformersmc.cinderscapes.biomes.quartzcavern.QuartzCavern;
import com.terraformersmc.cinderscapes.biomes.luminousgrove.LuminousGrove;
import net.fabricmc.api.ClientModInitializer;

public class CinderscapesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        LuminousGrove.onInitializeClient();
        QuartzCavern.onInitializeClient();
    }
}
