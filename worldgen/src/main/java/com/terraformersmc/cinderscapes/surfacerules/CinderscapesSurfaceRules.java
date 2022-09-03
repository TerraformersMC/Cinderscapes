package com.terraformersmc.cinderscapes.surfacerules;

import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

// Contains all of the surface rules used by Cinderscapes
public class CinderscapesSurfaceRules {
    public static final MaterialRules.MaterialRule LUMINOUS_GROVE = MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR,
        MaterialRules.condition(MaterialRules.biome(CinderscapesBiomes.LUMINOUS_GROVE),
            MaterialRules.condition(MaterialRules.not(MaterialRules.noiseThreshold(NoiseParametersKeys.NETHERRACK, 0.54D)),
                MaterialRules.condition(MaterialRules.aboveY(YOffset.fixed(31), 0),
                    MaterialRules.condition(MaterialRules.not(MaterialRules.aboveY(YOffset.fixed(127), 0)),
                        MaterialRules.sequence(
                            MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.NETHER_WART, 0.385D, 0.405D),
                                MaterialRules.block(CinderscapesBlocks.UMBRAL_WART_BLOCK.getDefaultState())),
                            MaterialRules.block(CinderscapesBlocks.UMBRAL_NYLIUM.getDefaultState())))))));

    // TODO: Actually ATM there are no active Cinderscapes surface rules.  TerraBlender when present overwrites them.
    //       When we migrate to TerraBlender, consider whether to migrate back from surface builders to surface rules...
    // At the moment, there's just Luminous Grove.  To add another, wrap them in MaterialRules.sequence()
    public static final MaterialRules.MaterialRule CINDERSCAPES_NETHER_RULES = LUMINOUS_GROVE;

	public static MaterialRules.MaterialRule createRules() {
        return CINDERSCAPES_NETHER_RULES;
	}

    // Initializes the surface builders added by Cinderscapes
    public static void init() {
    }
}
