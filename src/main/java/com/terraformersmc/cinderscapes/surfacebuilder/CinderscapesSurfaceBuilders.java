package com.terraformersmc.cinderscapes.surfacebuilder;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import java.util.HashMap;
import java.util.Map;

public class CinderscapesSurfaceBuilders {
    private static final Map<Identifier, SurfaceBuilder<? extends SurfaceConfig>> SURFACE_BUILDERS = new HashMap<>();

    public static final TernarySurfaceConfig BLACKSTONE_CONFIG = new TernarySurfaceConfig(Blocks.BLACKSTONE.getDefaultState(), Blocks.BLACKSTONE.getDefaultState(), Blocks.NETHERRACK.getDefaultState());

    public static final SurfaceBuilder<TernarySurfaceConfig> BLACKSTONE_SHALES = add("blackstone_shales", new BlackstoneShalesSurfaceBuilder(TernarySurfaceConfig::deserialize));

    private static <S extends SurfaceBuilder<? extends SurfaceConfig>> S add(String name, S feature) {
        SURFACE_BUILDERS.put(Cinderscapes.id(name), feature);
        return feature;
    }

    public static void register() {
        for (Identifier id : SURFACE_BUILDERS.keySet()) {
            Registry.register(Registry.SURFACE_BUILDER, id, SURFACE_BUILDERS.get(id));
        }
    }
}
