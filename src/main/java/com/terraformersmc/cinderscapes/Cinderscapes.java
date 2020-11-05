package com.terraformersmc.cinderscapes;

import com.terraformersmc.cinderscapes.config.CinderscapesConfig;
import com.terraformersmc.cinderscapes.modules.luminousgrove.LuminousGrove;
import com.terraformersmc.cinderscapes.modules.magmaticmire.MagmaticMire;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cinderscapes implements ModInitializer, ClientModInitializer {

    public static final String NAMESPACE = "cinderscapes";
    public static final Logger LOGGER = LogManager.getLogger(StringUtils.capitalize(NAMESPACE));

    public static final CinderscapesConfig CONFIG;

    public static final LuminousGrove LUMINOUS_GROVE = new LuminousGrove();
    public static final MagmaticMire MAGMATIC_MIRE = new MagmaticMire();

    @Override
    public void onInitialize() {
        //TODO: Do a cool thing that automatically finds all of the modules using the implementation
        LUMINOUS_GROVE.onInitialize();
        MAGMATIC_MIRE.onInitialize();
    }

    @Override
    public void onInitializeClient() {
        LUMINOUS_GROVE.onInitializeClient();
    }

    public static Identifier id(String path) {
        return new Identifier(NAMESPACE, path);
    }

    static {
        AutoConfig.register(CinderscapesConfig.class, GsonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(CinderscapesConfig.class).getConfig();
    }
}