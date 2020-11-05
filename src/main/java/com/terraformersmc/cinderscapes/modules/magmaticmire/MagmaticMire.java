package com.terraformersmc.cinderscapes.modules.magmaticmire;

import com.terraformersmc.cinderscapes.init.CommonModule;

public class MagmaticMire implements CommonModule {

    public static MagmaticMire COMMON;

    @Override
    public void onInitialize() {
        COMMON = this;
        System.out.println("Magmatic Mire common");
    }
}
