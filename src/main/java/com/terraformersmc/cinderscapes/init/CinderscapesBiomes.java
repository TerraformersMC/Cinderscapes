package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.biome.AshyShoalsBiome;
import com.terraformersmc.cinderscapes.biome.BlackstoneShalesBiome;
import com.terraformersmc.cinderscapes.biome.LuminousGroveBiome;
import com.terraformersmc.cinderscapes.biome.QuartzCanyonBiome;
import net.fabricmc.fabric.api.biomes.v1.NetherBiomes;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

import java.util.HashMap;
import java.util.Map;

/**
 * [REVIEWED]
 * <p>
 * Contains the biomes added by Cinderscapes
 *
 * @author Will Toll
 */
public class CinderscapesBiomes {

    // Acts as a kind of local registry for Cinderscape's custom biomes
    private static final Map<Identifier, Pair<Biome, Biome.MixedNoisePoint>> BIOMES = new HashMap<>();

    public static final RegistryKey<Biome> BLACKSTONE_SHALES = add("blackstone_shales", BlackstoneShalesBiome.create(), BlackstoneShalesBiome.NOISE_POINT);
    public static final RegistryKey<Biome> QUARTZ_CANYON = add("quartz_canyon", QuartzCanyonBiome.create(), QuartzCanyonBiome.NOISE_POINT);
    public static final RegistryKey<Biome> LUMINOUS_GROVE = add("luminous_grove", LuminousGroveBiome.create(), LuminousGroveBiome.NOISE_POINT);
    public static final RegistryKey<Biome> ASHY_SHOALS = add("ashy_shoals", AshyShoalsBiome.create(), AshyShoalsBiome.NOISE_POINT);

    /**
     * Adds a biome to Cinderscapes local biome registry
     *
     * @param s  A string representing the path of the biome under the cinderscapes namespace
     * @param b  The biome to be added to the local registry
     * @param np The noise point to use for generation in the nether
     * @return The biome that was registered with the local biome registry
     */
    private static RegistryKey<Biome> add(String s, Biome b, Biome.MixedNoisePoint np) {
        Identifier id = Cinderscapes.id(s);
        Registry.register(BuiltinRegistries.BIOME, id, b);
        RegistryKey<Biome> key = RegistryKey.of(Registry.BIOME_KEY, id);
        NetherBiomes.addNetherBiome(key, np);
        return key;
    }

}
