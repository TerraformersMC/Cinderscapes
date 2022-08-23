package com.terraformersmc.cinderscapes.biome;

import com.google.common.collect.ImmutableMap;
import com.terraformersmc.terraform.biomeremapper.api.BiomeRemapperApi;
import com.terraformersmc.terraform.biomeremapper.api.DataVersions;
import com.terraformersmc.cinderscapes.Cinderscapes;

public class CinderscapesBiomeRemappings implements BiomeRemapperApi {
	public void init() {
// TODO: rename Quartz Canyon to Quartz Cavern as per Vaerian's 1.17 repo?
//
//		register(Cinderscapes.NAMESPACE, DataVersions.V_1_18_2, ImmutableMap.<String, String>builder()
//				.put("cinderscapes:quartz_canyon", "cinderscapes:quartz_cavern")
//				.build());
	}
}
