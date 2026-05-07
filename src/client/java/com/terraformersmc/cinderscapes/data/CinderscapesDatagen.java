package com.terraformersmc.cinderscapes.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class CinderscapesDatagen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
		FabricDataGenerator.Pack pack = dataGenerator.createPack();

		pack.addProvider(CinderscapesDynamicRegistryProvider::new);
		pack.addProvider(CinderscapesBiomeTagsProvider::new);
		pack.addProvider(CinderscapesBlockLootSubProvider::new);
		CinderscapesBlockTagsProvider blockTagProvider = pack.addProvider(CinderscapesBlockTagsProvider::new);
		pack.addProvider((output, registries) -> new CinderscapesItemTagsProvider(output, registries, blockTagProvider));
		pack.addProvider(CinderscapesVillagerTradeKeyTagProvider::new);
		pack.addProvider(CinderscapesModelProvider::new);
		pack.addProvider(CinderscapesRecipeProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		CinderscapesDynamicRegistryProvider.buildRegistry(registryBuilder);
	}
}
