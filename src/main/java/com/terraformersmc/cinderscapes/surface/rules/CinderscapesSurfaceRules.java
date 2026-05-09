package com.terraformersmc.cinderscapes.surface.rules;

import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

// Contains all of the surface rules used by Cinderscapes
public class CinderscapesSurfaceRules {
    public static final SurfaceRules.RuleSource LUMINOUS_GROVE = SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
        SurfaceRules.ifTrue(SurfaceRules.isBiome(CinderscapesBiomes.LUMINOUS_GROVE),
            SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(Noises.NETHERRACK, 0.54D)),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(31), 0),
                    SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(127), 0)),
                        SurfaceRules.sequence(
                            SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.NETHER_WART, 0.385D, 0.405D),
                                SurfaceRules.state(CinderscapesBlocks.UMBRAL_WART_BLOCK.defaultBlockState())),
                            SurfaceRules.state(CinderscapesBlocks.UMBRAL_NYLIUM.defaultBlockState())))))));

    // At the moment, all surface gen is via surface builders.  These rules are never installed.
    // Here's an example Luminous Grove.  To add another, wrap them in MaterialRules.sequence()
    public static final SurfaceRules.RuleSource CINDERSCAPES_NETHER_RULES = LUMINOUS_GROVE;

	public static SurfaceRules.RuleSource createRules() {
        return CINDERSCAPES_NETHER_RULES;
	}
}
