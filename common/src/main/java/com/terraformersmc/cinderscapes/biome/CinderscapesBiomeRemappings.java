package com.terraformersmc.cinderscapes.biome;

import com.google.common.collect.ImmutableMap;
import com.terraformersmc.terraform.biomeremapper.api.BiomeRemapperApi;
import com.terraformersmc.terraform.biomeremapper.api.DataVersions;
import com.terraformersmc.cinderscapes.Cinderscapes;

public class CinderscapesBiomeRemappings implements BiomeRemapperApi {
	public void init() {
		register(Cinderscapes.MOD_ID, DataVersions.V_1_18_2, ImmutableMap.<String, String>builder()
				.put("cinderscapes:quartz_canyon", "cinderscapes:quartz_cavern")
				.build());
	}
}
