package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.surfacebuilder.AshyShoalsSurfaceBuilder;
import com.terraformersmc.cinderscapes.surfacebuilder.IvoryShallowsSurfaceBuilder;

import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import java.util.HashMap;
import java.util.Map;

// Contains all of the surface builders and surface configs added by Cinderscapes
public class CinderscapesSurfaces {
    // Acts as a kind of local registry for surface builders added by Cinderscapes
    private static final Map<Identifier, SurfaceBuilder<? extends SurfaceConfig>> SURFACE_BUILDERS = new HashMap<>();
    private static final Map<Identifier, ConfiguredSurfaceBuilder<? extends SurfaceConfig>> CONFIGURED_SURFACE_BUILDERS = new HashMap<>();

    /////////////////////
    // SURFACE CONFIGS //
    /////////////////////
    public static final TernarySurfaceConfig LUMINOUS_NYLIUM_CONFIG = new TernarySurfaceConfig(CinderscapesBlocks.UMBRAL_NYLIUM.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), CinderscapesBlocks.UMBRAL_WART_BLOCK.getDefaultState());
    private static final TernarySurfaceConfig ASHY_SHOALS_CONFIG = new TernarySurfaceConfig(Blocks.NETHERRACK.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), Blocks.MAGMA_BLOCK.getDefaultState());
    private static final TernarySurfaceConfig IVORY_SHALLOWS_CONFIG = new TernarySurfaceConfig(CinderscapesBlocks.IVORY_BLOCK.getDefaultState(), CinderscapesBlocks.IVORY_BLOCK.getDefaultState(), CinderscapesBlocks.IVORY_BLOCK.getDefaultState());
    
    //////////////////////
    // SURFACE BUILDERS //
    //////////////////////
    public static final SurfaceBuilder<TernarySurfaceConfig> ASHY_SHOALS = add("ashy_shoals", new AshyShoalsSurfaceBuilder());
    
    public static final SurfaceBuilder<TernarySurfaceConfig> IVORY_SHALLOWS = add("ivory_shallows", new IvoryShallowsSurfaceBuilder());

    public static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> CONFIGURED_ASHY_SHOALS = add("ashy_shoals", ASHY_SHOALS.withConfig(ASHY_SHOALS_CONFIG));

    public static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> CONFIGURED_LUMINOUS_GROVE = add("luminous_grove", SurfaceBuilder.NETHER_FOREST.withConfig(LUMINOUS_NYLIUM_CONFIG));

    public static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> CONFIGURED_IVORY_SHALLOWS = add("ivory_shallows", IVORY_SHALLOWS.withConfig(IVORY_SHALLOWS_CONFIG));
    
    /**
     * Adds a surface builder to the Cinderscapes local registry
     * @param name    The path of the surface builder within the Cinderscapes namespace
     * @param s       The surface builder to be added to the local registry
     * @param <S>     The specific class type of the surface builder
     * @return The surface builder that was registered in the Cinderscapes local surface builder registry
     */
    private static <S extends SurfaceBuilder<? extends SurfaceConfig>> S add(String name, S s) {
        SURFACE_BUILDERS.put(Cinderscapes.id(name), s);
        return s;
    }

    private static <SC extends SurfaceConfig> ConfiguredSurfaceBuilder<SC> add(String name, ConfiguredSurfaceBuilder<SC> s) {
        CONFIGURED_SURFACE_BUILDERS.put(Cinderscapes.id(name), s);
        return s;
    }

    /**
     * Initializes the surface builders added by Cinderscapes
     */
    public static void init() {
        // Registers all of the surface builders within Cinderscapes local registry with the greater surface builder registry
        for (Identifier id : SURFACE_BUILDERS.keySet()) {
            Registry.register(Registry.SURFACE_BUILDER, id, SURFACE_BUILDERS.get(id));
        }
    }
}
