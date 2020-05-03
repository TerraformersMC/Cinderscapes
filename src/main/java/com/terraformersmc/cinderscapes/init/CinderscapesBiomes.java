package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.biome.LuminousGroveBiome;
import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.biome.BlackstoneShalesBiome;
import com.terraformersmc.cinderscapes.biome.QuartzCanyonBiome;
import com.terraformersmc.cinderscapes.biome.SulfurousPitsBiome;
import com.terraformersmc.cinderscapes.biome.WitheredWastesBiome;
import net.fabricmc.fabric.api.biomes.v1.NetherBiomes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

import java.util.HashMap;
import java.util.Map;

/**
 * [REVIEWED]
 *
 * Contains the biomes added by Cinderscapes
 *
 * @author Will Toll
 */
public class CinderscapesBiomes {

    // Acts as a kind of local registry for Cinderscape's custom biomes
    private static final Map<Identifier, Biome> BIOMES = new HashMap<>();

    public static final Biome BLACKSTONE_SHALES = add("blackstone_shales", new BlackstoneShalesBiome());
    public static final Biome QUARTZ_CANYON = add("quartz_canyon", new QuartzCanyonBiome());
    public static final Biome WITHERED_WASTES = add("withered_wastes", new WitheredWastesBiome());
    public static final Biome LUMINOUS_GROVE = add("luminous_grove", new LuminousGroveBiome());
    public static final Biome SULFUROUS_PITS = add("sulfurous_pits", new SulfurousPitsBiome());

    /**
     * Adds a biome to Cinderscapes local biome registry
     * @param s   A string representing the path of the biome under the cinderscapes namespace
     * @param b   The biome to be added to the local registry
     * @param <B> The class type of the biome
     * @return The biome that was registered with the local biome registry
     */
    private static <B extends Biome> B add(String s, B b) {
        BIOMES.put(Cinderscapes.id(s), b);
        return b;
    }

    /**
     * Initializes the biomes added by Cinderscapes
     */
    @SuppressWarnings("deprecation")
    public static void init() {
        // Registers all of the biomes within Cinderscapes local biome registry with the greater biome registry and the nether biome registry
        BIOMES.forEach((id, b) -> {
            Registry.register(Registry.BIOME, id, b);
            NetherBiomes.addNetherBiome(b);
        });
    }
}
