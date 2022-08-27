package com.terraformersmc.cinderscapes.surfacerules;

import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

import java.util.Random;

// Contains all of the surface rules used by Cinderscapes
public class CinderscapesSurfaceRules {
    static Random random = new Random();

    public static final MaterialRules.MaterialRule LUMINOUS_GROVE = MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR,
        MaterialRules.condition(MaterialRules.biome(CinderscapesBiomes.LUMINOUS_GROVE),
            MaterialRules.condition(MaterialRules.not(MaterialRules.noiseThreshold(NoiseParametersKeys.NETHERRACK, 0.54)),
                MaterialRules.condition(MaterialRules.aboveY(YOffset.fixed(31), 0),
                    MaterialRules.sequence(
                        MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.NETHER_WART, 1.17),
                            MaterialRules.block(CinderscapesBlocks.UMBRAL_WART_BLOCK.getDefaultState())),
                        MaterialRules.block(CinderscapesBlocks.UMBRAL_NYLIUM.getDefaultState()))))));

    // At the moment, there's just Luminous Grove.  To add another, wrap them in MaterialRules.sequence()
    public static final MaterialRules.MaterialRule CINDERSCAPES_NETHER_RULES = LUMINOUS_GROVE;

	public static MaterialRules.MaterialRule createRules() {
        return CINDERSCAPES_NETHER_RULES;
	}

    // Initializes the surface builders added by Cinderscapes
    public static void init() {
    }
}
