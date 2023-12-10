package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.init.CinderscapesArmorTrimMaterials;
import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import com.terraformersmc.cinderscapes.init.CinderscapesConfiguredFeatures;
import com.terraformersmc.cinderscapes.init.CinderscapesPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class CinderscapesDynamicRegistryProvider extends FabricDynamicRegistryProvider {
	protected CinderscapesDynamicRegistryProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	public void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
		// worldgen
		CinderscapesConfiguredFeatures.populate(entries);
		CinderscapesPlacedFeatures.populate(entries);
		CinderscapesBiomes.populate(entries);

		// other registries
		CinderscapesArmorTrimMaterials.populate(entries);
	}

	@Override
	public String getName() {
		return "Cinderscapes";
	}
}
