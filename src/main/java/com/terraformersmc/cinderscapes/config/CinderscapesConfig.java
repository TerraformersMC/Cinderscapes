package com.terraformersmc.cinderscapes.config;

import com.terraformersmc.cinderscapes.Cinderscapes;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;

@Config(name = Cinderscapes.NAMESPACE)
public class CinderscapesConfig implements ConfigData {
    @ConfigEntry.Gui.Excluded
    public static CinderscapesConfig INSTANCE;

    @ConfigEntry.Gui.CollapsibleObject
    public BiomeOptions biomes = new BiomeOptions();

    public boolean enableAshFall = true;

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
