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

    @ConfigEntry.Gui.CollapsibleObject
    public BiomeOptions biomes = new BiomeOptions();

    public boolean enableAshFall = true;

    public final boolean easterEggs = false;

    public static void init() {
        AutoConfig.register(CinderscapesConfig.class, GsonConfigSerializer::new);
        INSTANCE = AutoConfig.getConfigHolder(CinderscapesConfig.class).getConfig();
    }

    public static class BiomeOptions {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enableAshyShoals = true;
        @ConfigEntry.Gui.RequiresRestart
        public boolean enableBlackstoneShales = true;
        @ConfigEntry.Gui.RequiresRestart
        public boolean enableLuminousGrove = true;
        @ConfigEntry.Gui.RequiresRestart
        public boolean enableQuartzCanyon = true;
    }
}
