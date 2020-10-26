package com.terraformersmc.cinderscapes.init;

import java.util.HashMap;
import java.util.Map;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.biome.AshyShoalsBiome;
import com.terraformersmc.cinderscapes.biome.BlackstoneShalesBiome;
import com.terraformersmc.cinderscapes.biome.IvoryShallowsBiome;
import com.terraformersmc.cinderscapes.biome.LuminousGroveBiome;
import com.terraformersmc.cinderscapes.biome.QuartzCanyonBiome;
import com.terraformersmc.cinderscapes.config.CinderscapesConfig;

import net.fabricmc.fabric.api.biome.v1.NetherBiomes;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

public class CinderscapesBiomes {

    // Acts as a kind of local registry for Cinderscape's custom biomes
    private static final Map<Identifier, Pair<Biome, Biome.MixedNoisePoint>> BIOMES = new HashMap<>();

    public static final RegistryKey<Biome> BLACKSTONE_SHALES = add("blackstone_shales", BlackstoneShalesBiome.create());
    public static final RegistryKey<Biome> QUARTZ_CANYON = add("quartz_canyon", QuartzCanyonBiome.create());
    public static final RegistryKey<Biome> LUMINOUS_GROVE = add("luminous_grove", LuminousGroveBiome.create());
    public static final RegistryKey<Biome> ASHY_SHOALS = add("ashy_shoals", AshyShoalsBiome.create());
    public static final RegistryKey<Biome> IVORY_SHALLOWS = add("ivory_shallows", IvoryShallowsBiome.create());

    // Required because something referencing this class has to be called in order to force the
    // static initializer to run (Minecraft's Bootstrap class does similar things)
    public static void init() {
        if (CinderscapesConfig.INSTANCE.enableAshyShoals) {
            NetherBiomes.addNetherBiome(RegistryKey.of(Registry.BIOME_KEY, Cinderscapes.id("ashy_shoals")), AshyShoalsBiome.NOISE_POINT);
        }
        if (CinderscapesConfig.INSTANCE.enableLuminousGrove) {
            NetherBiomes.addNetherBiome(RegistryKey.of(Registry.BIOME_KEY, Cinderscapes.id("luminous_grove")), LuminousGroveBiome.NOISE_POINT);
        }
        if (CinderscapesConfig.INSTANCE.enableQuartzCanyon) {
            NetherBiomes.addNetherBiome(RegistryKey.of(Registry.BIOME_KEY, Cinderscapes.id("quartz_canyon")), QuartzCanyonBiome.NOISE_POINT);
        }
        if (CinderscapesConfig.INSTANCE.enableBlackstoneShales) {
            NetherBiomes.addNetherBiome(RegistryKey.of(Registry.BIOME_KEY, Cinderscapes.id("blackstone_shales")), BlackstoneShalesBiome.NOISE_POINT);
        }
        if (CinderscapesConfig.INSTANCE.enableIvoryShallows) {
            NetherBiomes.addNetherBiome(RegistryKey.of(Registry.BIOME_KEY, Cinderscapes.id("ivory_shallows")), IvoryShallowsBiome.NOISE_POINT);
        }
    }

    /**
     * Adds a biome to Cinderscapes local biome registry
     *
     * @param s  A string representing the path of the biome under the cinderscapes namespace
     * @param b  The biome to be added to the local registry
     * @return The biome that was registered with the local biome registry
     */
    private static RegistryKey<Biome> add(String s, Biome b) {
        Identifier id = Cinderscapes.id(s);
        Registry.register(BuiltinRegistries.BIOME, id, b);
        RegistryKey<Biome> key = RegistryKey.of(Registry.BIOME_KEY, id);
        return key;
    }

}
