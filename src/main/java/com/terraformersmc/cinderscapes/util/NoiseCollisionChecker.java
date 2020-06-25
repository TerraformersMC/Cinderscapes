package com.terraformersmc.cinderscapes.util;

import com.terraformersmc.cinderscapes.mixin.BiomeAccessor;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO: Check
@SuppressWarnings("unchecked")
public class NoiseCollisionChecker {
    private static final Map<Biome, Long> HASHES = new HashMap<>();

    public static void init() {
        for (Biome biome : Registry.BIOME) {
            if (biome.getCategory() == Biome.Category.NETHER) {
                check(biome);
            }
        }

        RegistryEntryAddedCallback.event(Registry.BIOME).register(((i, identifier, biome) -> {
            if (biome.getCategory() == Biome.Category.NETHER) {
                check(biome);
            }
        }));
    }

    private static void check(Biome biome) {
        List<Biome.MixedNoisePoint> points = ((BiomeAccessor) biome).getNoisePoints();
        //biomes can have multiple noise points so we hash all of them
        long hash = 0;
        for (Biome.MixedNoisePoint point : points) {
            hash += point.hashCode();
        }

        // ensure the biomes have distinct hashes
        long finalHash = hash;
        HASHES.forEach((cachedBiome, biomeHash) -> {
            if (finalHash == biomeHash) {
                System.out.println("WARNING: " + biome.getTranslationKey() + " and " + cachedBiome.getTranslationKey() + " have the same mixed noise points! They won't generate properly!!!!");
            }
        });

        HASHES.put(biome, hash);

    }
}
