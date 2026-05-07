package com.terraformersmc.cinderscapes.init;

import net.minecraft.world.level.block.entity.BlockEntityType;

public class CinderscapesBlockEntityTypes {
	public static void init() {
		BlockEntityType.SHELF.addValidBlock(CinderscapesBlocks.SCORCHED_SHELF);
		BlockEntityType.SHELF.addValidBlock(CinderscapesBlocks.UMBRAL_SHELF);
	}
}
