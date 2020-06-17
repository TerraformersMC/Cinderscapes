package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.decorator.CountSafelistRangeCeilingDecorator;
import com.terraformersmc.cinderscapes.decorator.CountSafelistRangeFloorDecorator;
import com.terraformersmc.cinderscapes.decorator.config.CountSafelistRangeDecoratorConfig;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.Decorator;

// TODO: Check
public class CinderscapesDecorators {
    public static Decorator<CountSafelistRangeDecoratorConfig> COUNT_CEILING;
    public static Decorator<CountSafelistRangeDecoratorConfig> COUNT_FLOOR;

    public static void init() {
        COUNT_CEILING = Registry.register(Registry.DECORATOR, new Identifier("cinderscapes", "count_safelist_range_ceiling"), new CountSafelistRangeCeilingDecorator());
        COUNT_FLOOR = Registry.register(Registry.DECORATOR, new Identifier("cinderscapes", "count_safelist_range_floor"), new CountSafelistRangeFloorDecorator());
    }
}
