package com.terraformersmc.cinderscapes.integration;

import com.terraformersmc.cinderscapes.config.CinderscapesConfig;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfigClient;

public class CinderscapesModMenu implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return (parent) -> AutoConfigClient.getConfigScreen(CinderscapesConfig.class, parent).get();
    }
}
