package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.biome.Biome;

import java.util.concurrent.CompletableFuture;

public class CinderscapesBiomeTagProvider extends FabricTagProvider<Biome> {
	protected CinderscapesBiomeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, RegistryKeys.BIOME, registriesFuture);
	}

	@Override
	public void configure(RegistryWrapper.WrapperLookup registries) {
		/*
		 * Vanilla and Conventional biome categories
		 */
		getOrCreateTagBuilder(BiomeTags.IS_NETHER)
			.addOptional(CinderscapesBiomes.ASHY_SHOALS)
			.addOptional(CinderscapesBiomes.BLACKSTONE_SHALES)
			.addOptional(CinderscapesBiomes.LUMINOUS_GROVE)
			.addOptional(CinderscapesBiomes.QUARTZ_CAVERN);

		getOrCreateTagBuilder(ConventionalBiomeTags.IS_NETHER_FOREST)
			.addOptional(CinderscapesBiomes.LUMINOUS_GROVE);

		getOrCreateTagBuilder(ConventionalBiomeTags.IS_WASTELAND)
			.addOptional(CinderscapesBiomes.ASHY_SHOALS);

		getOrCreateTagBuilder(ConventionalBiomeTags.IS_VEGETATION_SPARSE)
			.addOptional(CinderscapesBiomes.BLACKSTONE_SHALES);


		/*
		 * Biome structure generation tags
		 */
		getOrCreateTagBuilder(BiomeTags.BASTION_REMNANT_HAS_STRUCTURE)
			.addOptional(CinderscapesBiomes.ASHY_SHOALS)
			.addOptional(CinderscapesBiomes.LUMINOUS_GROVE);

		getOrCreateTagBuilder(BiomeTags.NETHER_FORTRESS_HAS_STRUCTURE)
			.addOptional(CinderscapesBiomes.BLACKSTONE_SHALES);

		getOrCreateTagBuilder(BiomeTags.NETHER_FOSSIL_HAS_STRUCTURE)
			.addOptional(CinderscapesBiomes.ASHY_SHOALS)
			.addOptional(CinderscapesBiomes.BLACKSTONE_SHALES);

		getOrCreateTagBuilder(BiomeTags.RUINED_PORTAL_NETHER_HAS_STRUCTURE)
			.addOptional(CinderscapesBiomes.ASHY_SHOALS);
	}
}
