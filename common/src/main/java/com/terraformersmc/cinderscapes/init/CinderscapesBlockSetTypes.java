package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.minecraft.block.BlockSetType;
import net.minecraft.util.Identifier;

public class CinderscapesBlockSetTypes {
	public static final BlockSetType SCORCHED = BlockSetTypeBuilder.copyOf(BlockSetType.CRIMSON)
			.register(Identifier.of(Cinderscapes.MOD_ID, "scorched"));
	public static final BlockSetType UMBRAL = BlockSetTypeBuilder.copyOf(BlockSetType.CRIMSON)
			.register(Identifier.of(Cinderscapes.MOD_ID, "umbral"));
}
