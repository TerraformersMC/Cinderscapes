package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.decorator.CountCeilingDecorator;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;

public class CinderscapesDecorators {
    public static Decorator<CountDecoratorConfig> COUNT_CEILING;

    public static void init() {
        COUNT_CEILING = Registry.register(Registry.DECORATOR, new Identifier("cinderscapes", "count_ceiling"), new CountCeilingDecorator(CountDecoratorConfig::deserialize));
    }
}
