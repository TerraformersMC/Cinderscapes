package com.terraformersmc.cinderscapes.biomes.ashyshoals;

public class AshyShoals {
    public static void onInitializeCommon() {
        AshyShoalsBlocks.onInitializeCommon();
        AshyShoalsItems.onInitializeCommon();
    }

    public static void onInitializeClient() {
        AshyShoalsBlocks.onInitializeClient();
    }
}
