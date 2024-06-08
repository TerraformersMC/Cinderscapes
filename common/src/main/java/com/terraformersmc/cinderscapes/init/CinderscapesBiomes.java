package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.biome.AshyShoalsBiome;
import com.terraformersmc.cinderscapes.biome.BlackstoneShalesBiome;
import com.terraformersmc.cinderscapes.biome.LuminousGroveBiome;
import com.terraformersmc.cinderscapes.biome.QuartzCavernBiome;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

import java.util.List;

public class CinderscapesBiomes {
    public static final RegistryKey<Biome> ASHY_SHOALS = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(Cinderscapes.MOD_ID, "ashy_shoals"));
    public static final RegistryKey<Biome> BLACKSTONE_SHALES = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(Cinderscapes.MOD_ID, "blackstone_shales"));
    public static final RegistryKey<Biome> LUMINOUS_GROVE = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(Cinderscapes.MOD_ID, "luminous_grove"));
    public static final RegistryKey<Biome> QUARTZ_CAVERN = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(Cinderscapes.MOD_ID, "quartz_cavern"));

    @SuppressWarnings("unused")
    public static final List<RegistryKey<Biome>> BIOMES = List.of(
            ASHY_SHOALS,
            BLACKSTONE_SHALES,
            LUMINOUS_GROVE,
            QUARTZ_CAVERN
    );

    public static void bootstrap(Registerable<Biome> registerable) {
        registerable.register(ASHY_SHOALS, AshyShoalsBiome.create(registerable));
        registerable.register(BLACKSTONE_SHALES, BlackstoneShalesBiome.create(registerable));
        registerable.register(LUMINOUS_GROVE, LuminousGroveBiome.create(registerable));
        registerable.register(QUARTZ_CAVERN, QuartzCavernBiome.create(registerable));
    }
}

/*
 * Nether biome noise points for future reference:
 *
 * |--  -2/+2  ---------------------| |--  =0=  -------------------------------------------------------|  |--  0/+1  --|
 * float temperature, float humidity, float continentalness, float erosion, float depth, float weirdness, float offset
 *
 *  == VANILLA ==
 *
 *  TEMP  HUMIDI  CONTIN  EROSI  DEPTH  WEIRD  OFFSET  BIOME
 *  0.0f,   0.0f,  0.0f,  0.0f,  0.0f,  0.0f,  0.0f    NETHER_WASTES
 *  0.0f,  -0.5f,  0.0f,  0.0f,  0.0f,  0.0f,  0.0f    SOUL_SAND_VALLEY
 *  0.4f,   0.0f,  0.0f,  0.0f,  0.0f,  0.0f,  0.0f    CRIMSON_FOREST
 *  0.0f,   0.5f,  0.0f,  0.0f,  0.0f,  0.0f,  0.375f  WARPED_FOREST
 * -0.5f,   0.0f,  0.0f,  0.0f,  0.0f,  0.0f,  0.175f  BASALT_DELTAS
 *
 *  == 1.18 ==
 *
 *  TEMP  HUMIDI  CONTIN  EROSI  DEPTH  WEIRD  OFFSET  BIOME
 * -0.35F,  0.0F,  0.2F,  0.0F,  0.35F, 0.0F,  0.0F    ASHY_SHOALS
 *  0.15F,  0.05F, 0.2F,  0.0F,  0.25F, 0.05F, 0.0F    BLACKSTONE_SHALES
 *  0.35F,  0.35F, 0.0F,  0.0F,  0.0F,  0.0F,  0.2F    LUMINOUS_GROVE
 *  0.0F,   0.0F,  0.0F,  0.0F,  0.35F, 0.35F, 0.2F    QUARTZ_CAVERN
 *
 *  == 1.19 ==
 *
 *  TEMP  HUMIDI  CONTIN  EROSI  DEPTH  WEIRD  OFFSET  BIOME
 * -0.35F, -0.3F,  0.0F,  0.0F,  0.0F,  0.0F,  0.2F    ASHY_SHOALS
 *  0.1F,  -0.05F, 0.0F,  0.0F,  0.0F,  0.0F,  0.0F    BLACKSTONE_SHALES
 *  0.35F,  0.3F,  0.0F,  0.0F,  0.0F,  0.0F,  0.225F  LUMINOUS_GROVE
 * -0.225F, 0.0F,  0.0F,  0.0F,  0.0F,  0.0F,  0.1F    QUARTZ_CAVERN
 */