package com.terraformersmc.cinderscapes.config;

import com.terraformersmc.cinderscapes.Cinderscapes;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;

@Config(name = Cinderscapes.NAMESPACE)
public class CinderscapesConfig implements ConfigData {
    public static CinderscapesConfig INSTANCE;

    public boolean enableAshyShoals = true;
    public boolean enableBlackstoneShales = true;
    public boolean enableLuminousGrove = true;
    public boolean enableQuartzCanyon = true;
    public boolean enableIvoryShallows = true;

    public boolean enableAshFall = true;

    public static void init() {
        AutoConfig.register(CinderscapesConfig.class, GsonConfigSerializer::new);
        INSTANCE = AutoConfig.getConfigHolder(CinderscapesConfig.class).getConfig();
    }
}
