package com.terraformersmc.cinderscapes;

import net.fabricmc.api.ModInitializer;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cinderscapes implements ModInitializer {

    public static final String NAMESPACE = "cinderscapes";
    public static final Logger LOGGER = LogManager.getLogger(StringUtils.capitalize(NAMESPACE));

    @Override
    public void onInitialize() {

    }

    public static Identifier id(String path) {
        return new Identifier(NAMESPACE, path);
    }
}