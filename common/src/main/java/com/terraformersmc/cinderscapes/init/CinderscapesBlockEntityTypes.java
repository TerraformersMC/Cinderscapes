package com.terraformersmc.cinderscapes.init;

import net.minecraft.block.entity.BlockEntityType;

public class CinderscapesBlockEntityTypes {
	public static void init() {
		BlockEntityType.SHELF.addSupportedBlock(CinderscapesBlocks.SCORCHED_SHELF);
		BlockEntityType.SHELF.addSupportedBlock(CinderscapesBlocks.UMBRAL_SHELF);
	}
}
