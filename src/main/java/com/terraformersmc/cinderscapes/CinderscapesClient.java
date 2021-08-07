package com.terraformersmc.cinderscapes.impl;

import com.terraformersmc.cinderscapes.impl.witheredwastes.WitheredWastes;
import net.fabricmc.api.ClientModInitializer;

public class CinderscapesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        WitheredWastes.onInitializeClient();
    }
}
