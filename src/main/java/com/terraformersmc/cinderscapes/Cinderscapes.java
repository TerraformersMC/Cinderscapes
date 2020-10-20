package com.terraformersmc.cinderscapes;

import com.terraformersmc.cinderscapes.init.CommonModule;
import com.terraformersmc.cinderscapes.init.Module;
import com.terraformersmc.cinderscapes.modules.luminousgrove.LuminousGrove;
import com.terraformersmc.cinderscapes.modules.magmaticmire.MagmaticMire;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;

public class Cinderscapes implements ModInitializer {

    public static final String NAMESPACE = "cinderscapes";
    public static final Logger LOGGER = LogManager.getLogger(StringUtils.capitalize(NAMESPACE));

    @Override
    public void onInitialize() {

        List<Class<?>> classes = Arrays.asList(LuminousGrove.class, MagmaticMire.class);
        classes.forEach((clazz) -> {
            Annotation anno = clazz.getAnnotation(Module.class);
            if (CommonModule.class.isAssignableFrom(clazz)) {
                try {
                    ((CommonModule) clazz.newInstance()).onInitialize();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

        /*
        Optional<ModContainer> option = FabricLoader.getInstance().getModContainer(NAMESPACE);
        if (option.isPresent()) {
            ModContainer cinderscapes = option.get();
            try {
                Path root = cinderscapes.getRootPath();
                Files.walk(cinderscapes.getPath("com/terraformersmc/cinderscapes")).forEach((path) -> {
                    Path small = Paths.get(path.toString().replaceFirst(root.toString(), ""));
                    if (small.toString().endsWith(".class")) {
                        System.out.println(small);
                        try {
                            Class<?> clazz = Class.forName(small.toString().substring(1).replace(".class", "").replace("/", "."));
                            System.out.println(clazz.getName());
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Couldn't find Cinderscapes anywhere");
        }*/
    }

    public static Identifier id(String path) {
        return new Identifier(NAMESPACE, path);
    }
}