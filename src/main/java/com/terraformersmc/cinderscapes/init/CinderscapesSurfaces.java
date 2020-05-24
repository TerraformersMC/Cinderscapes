package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.surfacebuilder.AshyShoalsSurfaceBuilder;
import com.terraformersmc.cinderscapes.surfacebuilder.BlackstoneShalesSurfaceBuilder;
import com.terraformersmc.cinderscapes.surfacebuilder.config.EmptySurfaceConfig;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * [REVIEWED]
 *
 * Contains all of the surface builders and surface configs added by Cinderscapes
 *
 * @author <Wtoll> Will Toll on 2020-05-02
 * @project Cinderscapes
 */
public class CinderscapesSurfaces {
    // Acts as a kind of local registry for surface builders added by Cinderscapes
    private static final Map<Identifier, SurfaceBuilder<? extends SurfaceConfig>> SURFACE_BUILDERS = new HashMap<>();

    /////////////////////
    // SURFACE CONFIGS //
    /////////////////////
    public static final TernarySurfaceConfig WITHERED_WASTES_CONFIG = new TernarySurfaceConfig(CinderscapesBlocks.WITHERED_NYLIUM.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), Blocks.NETHERRACK.getDefaultState());
    public static final TernarySurfaceConfig LUMINOUS_NYLIUM_CONFIG = new TernarySurfaceConfig(CinderscapesBlocks.UMBRAL_NYLIUM.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), CinderscapesBlocks.UMBRAL_WART_BLOCK.getDefaultState());

    //////////////////////
    // SURFACE BUILDERS //
    //////////////////////
    public static final SurfaceBuilder<EmptySurfaceConfig> BLACKSTONE_SHALES = add("blackstone_shales", new BlackstoneShalesSurfaceBuilder());
    public static final SurfaceBuilder<EmptySurfaceConfig> ASHY_SHOALS = add("ashy_shoals", new AshyShoalsSurfaceBuilder());

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
