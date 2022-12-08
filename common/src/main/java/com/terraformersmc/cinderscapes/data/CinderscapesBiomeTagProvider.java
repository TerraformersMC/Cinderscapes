package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.world.biome.Biome;

import java.util.concurrent.CompletableFuture;

public class CinderscapesBiomeTagProvider extends FabricTagProvider<Biome> {
	protected CinderscapesBiomeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, RegistryKeys.BIOME, registriesFuture);
	}

	@Override
	public void configure(RegistryWrapper.WrapperLookup registries) {
		/*
		 * Vanilla biome categories
		 */
		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.IS_NETHER.id()))
			.addOptional(CinderscapesBiomes.ASHY_SHOALS)
			.addOptional(CinderscapesBiomes.BLACKSTONE_SHALES)
			.addOptional(CinderscapesBiomes.LUMINOUS_GROVE)
			.addOptional(CinderscapesBiomes.QUARTZ_CAVERN);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, ConventionalBiomeTags.NETHER_FORESTS.id()))
			.addOptional(CinderscapesBiomes.LUMINOUS_GROVE);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, ConventionalBiomeTags.WASTELAND.id()))
			.addOptional(CinderscapesBiomes.ASHY_SHOALS);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, ConventionalBiomeTags.VEGETATION_SPARSE.id()))
			.addOptional(CinderscapesBiomes.BLACKSTONE_SHALES);


		/*
		 * Biome structure generation tags
		 */
		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.BASTION_REMNANT_HAS_STRUCTURE.id()))
			.addOptional(CinderscapesBiomes.ASHY_SHOALS)
			.addOptional(CinderscapesBiomes.LUMINOUS_GROVE);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.NETHER_FORTRESS_HAS_STRUCTURE.id()))
			.addOptional(CinderscapesBiomes.BLACKSTONE_SHALES);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.NETHER_FOSSIL_HAS_STRUCTURE.id()))
			.addOptional(CinderscapesBiomes.ASHY_SHOALS)
			.addOptional(CinderscapesBiomes.BLACKSTONE_SHALES);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BIOME, BiomeTags.RUINED_PORTAL_NETHER_HAS_STRUCTURE.id()))
			.addOptional(CinderscapesBiomes.ASHY_SHOALS);
	}
}
