package com.terraformersmc.cinderscapes;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

@Config(name = Cinderscapes.NAMESPACE)
public final class CinderscapesConfig implements ConfigData {

    @ConfigEntry.Gui.Excluded
    public static CinderscapesConfig INSTANCE;

    public final boolean easterEggs = false;

    public static void init() {
        AutoConfig.register(CinderscapesConfig.class, GsonConfigSerializer::new);
        INSTANCE = AutoConfig.getConfigHolder(CinderscapesConfig.class).getConfig();
    }
}
