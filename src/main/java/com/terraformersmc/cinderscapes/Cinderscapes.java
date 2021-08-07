package com.terraformersmc.cinderscapes;

import com.terraformersmc.cinderscapes.biomes.ashyshoals.AshyShoals;
import com.terraformersmc.cinderscapes.biomes.blackstoneshales.BlackstoneShales;
import com.terraformersmc.cinderscapes.biomes.quartzcavern.QuartzCavern;
import com.terraformersmc.cinderscapes.init.CinderscapesMusicEvents;
import com.terraformersmc.cinderscapes.biomes.luminousgrove.LuminousGrove;
import com.terraformersmc.cinderscapes.biomes.luminousgrove.LuminousGroveBlocks;
import com.terraformersmc.cinderscapes.util.RegistrationHelper;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

public class Cinderscapes implements ModInitializer {

	public static final String NAMESPACE = "cinderscapes";
	public static final Logger LOGGER = LogManager.getLogger(StringUtils.capitalize(NAMESPACE));
	public static final RegistrationHelper REGISTRATION_HELPER = new RegistrationHelper(NAMESPACE);

	public static ItemGroup GROUP;

	@Override
	public void onInitialize() {
		CinderscapesMusicEvents.onInitializeCommon();

		LuminousGrove.onInitializeCommon();
		QuartzCavern.onInitializeCommon();
		BlackstoneShales.onInitializeCommon();
		AshyShoals.onInitializeCommon();

		GROUP = FabricItemGroupBuilder.create(id("items"))
				.icon(() -> new ItemStack(LuminousGroveBlocks.UMBRAL_FUNGUS))
				.appendItems((stacks) -> stacks.addAll(Registry.ITEM
						.getIds()
						.stream()
						.filter((identifier) -> identifier.getNamespace().equals(NAMESPACE))
						.map(Registry.ITEM::get)
						.map(ItemStack::new)
						.collect(Collectors.toList())
				))
				.build();
	}

	public static Identifier id(String path) {
		return new Identifier(NAMESPACE, path);
	}
}