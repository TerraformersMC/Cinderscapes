package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.decorator.CountCeilingDecorator;
import com.terraformersmc.cinderscapes.decorator.CountFloorDecorator;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;

// TODO: Check
public class CinderscapesDecorators {
    public static Decorator<CountDecoratorConfig> COUNT_CEILING;
    public static Decorator<CountDecoratorConfig> COUNT_FLOOR;

    public static void init() {
        COUNT_CEILING = Registry.register(Registry.DECORATOR, new Identifier("cinderscapes", "count_ceiling"), new CountCeilingDecorator());
        COUNT_FLOOR = Registry.register(Registry.DECORATOR, new Identifier("cinderscapes", "count_floor"), new CountFloorDecorator());
    }
}
