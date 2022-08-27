package com.terraformersmc.cinderscapes.surfacebuilders;

import com.terraformersmc.cinderscapes.block.AshLayerBlock;
import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.minecraft.block.Blocks;

import java.util.ArrayList;

public class CinderscapesSurfaceBuilders {
	private static final ArrayList<CinderscapesSurfaceBuilder> builders = new ArrayList<>(2);

	public static void init() {
		builders.add(new AshyShoalsSurfaceBuilder(
				CinderscapesBlocks.ASH.getDefaultState().with(AshLayerBlock.LAYERS, 1),
				Blocks.MAGMA_BLOCK.getDefaultState(),
				Blocks.LAVA.getDefaultState()
			).setBiomeKey(CinderscapesBiomes.ASHY_SHOALS));
	}

	public static ArrayList<CinderscapesSurfaceBuilder> getBuilders() {
		return builders;
	}
}
