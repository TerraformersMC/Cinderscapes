package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;

import java.util.concurrent.CompletableFuture;

public class CinderscapesBiomeTagProvider extends FabricTagsProvider<Biome> {
	protected CinderscapesBiomeTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, Registries.BIOME, registriesFuture);
	}

	@Override
	public void addTags(HolderLookup.Provider registries) {
		/*
		 * Vanilla biome tags
		 */
		builder(BiomeTags.IS_NETHER)
				.addOptional(CinderscapesBiomes.ASHY_SHOALS)
				.addOptional(CinderscapesBiomes.BLACKSTONE_SHALES)
				.addOptional(CinderscapesBiomes.LUMINOUS_GROVE)
				.addOptional(CinderscapesBiomes.QUARTZ_CAVERN);


		/*
		 * Conventional biome tags
		 */
		builder(ConventionalBiomeTags.IS_NETHER_FOREST)
				.addOptional(CinderscapesBiomes.LUMINOUS_GROVE);

		builder(ConventionalBiomeTags.IS_VEGETATION_SPARSE)
				.addOptional(CinderscapesBiomes.BLACKSTONE_SHALES);

		builder(ConventionalBiomeTags.IS_WASTELAND)
				.addOptional(CinderscapesBiomes.ASHY_SHOALS);


		/*
		 * Biome structure generation tags
		 */
		builder(BiomeTags.HAS_BASTION_REMNANT)
				.addOptional(CinderscapesBiomes.ASHY_SHOALS)
				.addOptional(CinderscapesBiomes.LUMINOUS_GROVE);

		builder(BiomeTags.HAS_NETHER_FORTRESS)
				.addOptional(CinderscapesBiomes.BLACKSTONE_SHALES);

		builder(BiomeTags.HAS_NETHER_FOSSIL)
				.addOptional(CinderscapesBiomes.ASHY_SHOALS)
				.addOptional(CinderscapesBiomes.BLACKSTONE_SHALES);

		builder(BiomeTags.HAS_RUINED_PORTAL_NETHER)
				.addOptional(CinderscapesBiomes.ASHY_SHOALS);
	}

	@Override
	public String getName() {
		return "Cinderscapes Biome Tags";
	}
}
