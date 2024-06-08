package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.init.CinderscapesArmorTrimMaterials;
import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import com.terraformersmc.cinderscapes.init.CinderscapesConfiguredFeatures;
import com.terraformersmc.cinderscapes.init.CinderscapesPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CinderscapesDynamicRegistryProvider extends FabricDynamicRegistryProvider {
	protected CinderscapesDynamicRegistryProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	public static void buildRegistry(RegistryBuilder registryBuilder) {
		// worldgen
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, CinderscapesConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, CinderscapesPlacedFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.BIOME, CinderscapesBiomes::bootstrap);

		// other registries
		registryBuilder.addRegistry(RegistryKeys.TRIM_MATERIAL, CinderscapesArmorTrimMaterials::bootstrap);
	}

	@Override
	public void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
		// worldgen
		addAll(entries, registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE), Cinderscapes.MOD_ID);
		addAll(entries, registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE), Cinderscapes.MOD_ID);
		addAll(entries, registries.getWrapperOrThrow(RegistryKeys.BIOME), Cinderscapes.MOD_ID);

		// other registries
		addAll(entries, registries.getWrapperOrThrow(RegistryKeys.TRIM_MATERIAL), Cinderscapes.MOD_ID);
	}

	@Override
	public String getName() {
		return "Cinderscapes";
	}

	/**
	 * Version of FabricDynamicRegistryProvider.Entries.addAll() using specified mod ID.
	 */
	@SuppressWarnings("UnusedReturnValue")
	public <T> List<RegistryEntry<T>> addAll(Entries entries, RegistryWrapper.Impl<T> registry, String modId) {
		return registry.streamKeys()
				.filter(registryKey -> registryKey.getValue().getNamespace().equals(modId))
				.map(key -> entries.add(registry, key))
				.toList();
	}
}
