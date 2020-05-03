package com.terraformersmc.cinderscapes.util;

import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO: Check
@SuppressWarnings("unchecked")
public class NoiseCollisionChecker {
    private static Map<Biome, Long> Hashes = new HashMap<>();

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
        //use cursed reflection to make sure no biomes have noise collisions
        try {
            Field noisePoints = Biome.class.getDeclaredField("noisePoints");
            noisePoints.setAccessible(true);
            List<Biome.MixedNoisePoint> points = (List<Biome.MixedNoisePoint>) noisePoints.get(biome);
            //biomes can have multiple noise points so we hash all of them
            long hash = 0;
            for (Biome.MixedNoisePoint point : points) {
                hash += point.hashCode();
            }

            // ensure the biomes have distinct hashes
            long finalHash = hash;
            Hashes.forEach((cachedBiome, biomeHash) -> {
                if (finalHash == biomeHash) {
                    System.out.println("WARNING: " + biome.getTranslationKey() + " and " + cachedBiome.getTranslationKey() + " have the same mixed noise points! They won't generate properly!!!!");
                }
            });

            Hashes.put(biome, hash);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
