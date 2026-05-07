package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.init.CinderscapesArmorTrimMaterials;
import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import com.terraformersmc.cinderscapes.init.CinderscapesConfiguredFeatures;
import com.terraformersmc.cinderscapes.init.CinderscapesPlacedFeatures;
import com.terraformersmc.cinderscapes.villager.CinderscapesVillagerTrades;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import org.jspecify.annotations.NullMarked;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@NullMarked
public class CinderscapesDynamicRegistryProvider extends FabricDynamicRegistryProvider {
	protected CinderscapesDynamicRegistryProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	public static void buildRegistry(RegistrySetBuilder registryBuilder) {
		// worldgen
		registryBuilder.add(Registries.CONFIGURED_FEATURE, CinderscapesConfiguredFeatures::bootstrap);
		registryBuilder.add(Registries.PLACED_FEATURE, CinderscapesPlacedFeatures::bootstrap);
		registryBuilder.add(Registries.BIOME, CinderscapesBiomes::bootstrap);
		registryBuilder.add(Registries.VILLAGER_TRADE, CinderscapesVillagerTrades::bootstrap);

		// other registries
		registryBuilder.add(Registries.TRIM_MATERIAL, CinderscapesArmorTrimMaterials::bootstrap);
	}

	@Override
	public void configure(HolderLookup.Provider registries, Entries entries) {
		// worldgen
		addAll(entries, registries.lookupOrThrow(Registries.CONFIGURED_FEATURE), Cinderscapes.MOD_ID);
		addAll(entries, registries.lookupOrThrow(Registries.PLACED_FEATURE), Cinderscapes.MOD_ID);
		addAll(entries, registries.lookupOrThrow(Registries.BIOME), Cinderscapes.MOD_ID);
		addAll(entries, registries.lookupOrThrow(Registries.VILLAGER_TRADE), Cinderscapes.MOD_ID);

		// other registries
		addAll(entries, registries.lookupOrThrow(Registries.TRIM_MATERIAL), Cinderscapes.MOD_ID);
	}

	@Override
	public String getName() {
		return "Cinderscapes Dynamic Registries";
	}

	/**
	 * Version of FabricDynamicRegistryProvider.Entries.addAll() using specified mod ID.
	 */
	@SuppressWarnings("UnusedReturnValue")
	public <T> List<Holder<T>> addAll(Entries entries, HolderLookup.RegistryLookup<T> registry, String modId) {
		return registry.listElementIds()
				.filter(registryKey -> registryKey.identifier().getNamespace().equals(modId))
				.map(key -> entries.add(registry, key))
				.toList();
	}
}
