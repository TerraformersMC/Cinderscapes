package com.terraformersmc.cinderscapes.surfacebuilders;

import com.terraformersmc.biolith.api.surface.BiolithSurfaceBuilder;
import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.block.AshLayerBlock;
import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class CinderscapesSurfaceBuilders {
	private static final HashMap<Identifier, BiolithSurfaceBuilder> builders = new HashMap<>(8);

	public static void init() {
		builders.put(Identifier.of(Cinderscapes.MOD_ID, "surface/ashy_shoals"),
				new AshyShoalsSurfaceBuilder(
						CinderscapesBlocks.ASH.getDefaultState().with(AshLayerBlock.LAYERS, 1),
						Blocks.MAGMA_BLOCK.getDefaultState(),
						Blocks.LAVA.getDefaultState()
				).setBiomeKey(CinderscapesBiomes.ASHY_SHOALS));

		builders.put(Identifier.of(Cinderscapes.MOD_ID, "surface/luminous_grove"),
				new LuminousGroveSurfaceBuilder(
						CinderscapesBlocks.UMBRAL_NYLIUM.getDefaultState(),
						CinderscapesBlocks.UMBRAL_WART_BLOCK.getDefaultState(),
						Blocks.NETHERRACK.getDefaultState()
				).setBiomeKey(CinderscapesBiomes.LUMINOUS_GROVE));
	}

	public static HashMap<Identifier, BiolithSurfaceBuilder> getBuilders() {
		return builders;
	}
}
