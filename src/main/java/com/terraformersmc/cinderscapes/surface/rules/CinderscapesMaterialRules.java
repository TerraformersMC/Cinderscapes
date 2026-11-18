package com.terraformersmc.cinderscapes.surface.rules;

import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.material.VanillaMaterialConditions;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.material.MaterialRules;
import net.minecraft.world.level.levelgen.material.condition.MaterialCondition;
import net.minecraft.world.level.levelgen.material.rule.MaterialRule;

// Contains all of the material rules used by Cinderscapes
public class CinderscapesMaterialRules {
    public static MaterialRule bootstrap(RegistryAccess registryAccess) {
        HolderGetter<Biome> biomes = registryAccess.lookupOrThrow(Registries.BIOME);
        HolderGetter<MaterialCondition> conditions = registryAccess.lookupOrThrow(Registries.MATERIAL_CONDITION);

        MaterialCondition onFloor = MaterialRules.getCondition(conditions, VanillaMaterialConditions.ON_FLOOR);

        MaterialRule luminousGrove = MaterialRules.ifTrue(onFloor,
                    MaterialRules.ifTrue(MaterialRules.isBiome(biomes, CinderscapesBiomes.LUMINOUS_GROVE),
                            MaterialRules.ifTrue(MaterialRules.not(MaterialRules.noiseCondition2d(Noises.NETHERRACK, 0.54D)),
                                    MaterialRules.ifTrue(MaterialRules.yBlockCheck(VerticalAnchor.absolute(31), 0),
                                            MaterialRules.ifTrue(MaterialRules.not(MaterialRules.yBlockCheck(VerticalAnchor.absolute(127), 0)),
                                                    MaterialRules.sequence(
                                                            MaterialRules.ifTrue(MaterialRules.noiseCondition2d(Noises.NETHER_WART, 0.385D, 0.405D),
                                                                    MaterialRules.state(CinderscapesBlocks.UMBRAL_WART_BLOCK.defaultBlockState())),
                                                            MaterialRules.state(CinderscapesBlocks.UMBRAL_NYLIUM.defaultBlockState())))))));

        // At the moment, all surface gen is via surface builders.  These rules are never installed.
        // Here's an example Luminous Grove.  To add another, wrap them in MaterialRules.sequence()
        return luminousGrove;
    }
}
