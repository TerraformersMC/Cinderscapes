package com.terraformersmc.cinderscapes.modules.luminousgrove;

import com.terraformersmc.cinderscapes.init.ClientModule;
import com.terraformersmc.cinderscapes.init.CommonModule;

public class LuminousGrove implements CommonModule, ClientModule {

    public static LuminousGrove COMMON;
    public static LuminousGrove CLIENT;

    @Override
    public void onInitialize() {
        COMMON = this;

        LuminousGroveBlocks.onInitialize();
        LuminousGroveItems.onInitialize();
        LuminousGroveGeneration.onInitialize();
        LuminousGroveBiome.onInitialize();
    }

    @Override
    public void onInitializeClient() {
        CLIENT = this;

        LuminousGroveBlocks.onInitializeClient();
    }
}
