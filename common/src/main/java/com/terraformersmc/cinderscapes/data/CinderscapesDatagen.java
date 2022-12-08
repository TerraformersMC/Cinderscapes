package com.terraformersmc.cinderscapes.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class CinderscapesDatagen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
		FabricDataGenerator.Pack pack = dataGenerator.createPack();

		pack.addProvider(CinderscapesDynamicRegistryProvider::new);
		pack.addProvider(CinderscapesBiomeTagProvider::new);
		pack.addProvider(CinderscapesBlockLootTableProvider::new);
		CinderscapesBlockTagProvider blockTagProvider = pack.addProvider(CinderscapesBlockTagProvider::new);
		pack.addProvider((output, registries) -> new CinderscapesItemTagProvider(output, registries, blockTagProvider));
		pack.addProvider(CinderscapesRecipeProvider::new);
	}
}
