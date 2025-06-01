package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.block.WoodType;
import net.minecraft.util.Identifier;

public class CinderscapesWoodTypes {
	public static final WoodType SCORCHED = WoodTypeBuilder.copyOf(WoodType.CRIMSON)
			.register(Identifier.of(Cinderscapes.MOD_ID, "scorched"), CinderscapesBlockSetTypes.SCORCHED);
	public static final WoodType UMBRAL = WoodTypeBuilder.copyOf(WoodType.CRIMSON)
			.register(Identifier.of(Cinderscapes.MOD_ID, "umbral"), CinderscapesBlockSetTypes.UMBRAL);
}
