package com.terraformersmc.cinderscapes.init;

import net.minecraft.world.level.block.entity.BlockEntityTypes;

public class CinderscapesBlockEntityTypes {
	public static void init() {
		BlockEntityTypes.SHELF.addValidBlock(CinderscapesBlocks.SCORCHED_SHELF);
		BlockEntityTypes.SHELF.addValidBlock(CinderscapesBlocks.UMBRAL_SHELF);
	}
}
