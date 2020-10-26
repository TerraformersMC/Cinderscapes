package com.terraformersmc.cinderscapes.init;

import java.util.LinkedHashMap;
import java.util.Map;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.carver.IvoryShallowsCarver;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.carver.Carver;
import net.minecraft.world.gen.carver.ConfiguredCarver;

public class CinderscapesCarvers {

    /////////////
    // CARVERS //
    /////////////
	
	// Acts as a kind of local registry for Configured Carvers added by Cinderscapes
	private static final Map<Identifier, Carver<ProbabilityConfig>> CARVERS = new LinkedHashMap<>();

	public static final Carver<ProbabilityConfig> IVORY_SHALLOWS_CARVER = add("ivory_shallows", new IvoryShallowsCarver(ProbabilityConfig.CODEC));

    ////////////////////
    // CONFIG CARVERS //
    ////////////////////
	
	// Acts as a kind of local registry for configured carvers added by Cinderscapes
	private static final Map<Identifier, ConfiguredCarver<ProbabilityConfig>> CONFIGURED_CARVERS = new LinkedHashMap<>();
	
	public static final ConfiguredCarver<ProbabilityConfig> IVORY_SHALLOWS_CONFIGURED_CARVER = add("ivory_shallows", IVORY_SHALLOWS_CARVER.method_28614(new ProbabilityConfig(0.2F)));
	
	private static <C extends ConfiguredCarver<ProbabilityConfig>> C add(String name, C configured_carver) {
		CONFIGURED_CARVERS.put(Cinderscapes.id(name), configured_carver);
		return configured_carver;
	}

	private static <C extends Carver<ProbabilityConfig>> C add(String name, C carver) {
		CARVERS.put(Cinderscapes.id(name), carver);
		return carver;
	}

	public static void init() {
		for (Identifier id : CARVERS.keySet()) {
			Registry.register(Registry.CARVER, id, CARVERS.get(id));
		}
		for (Identifier id : CONFIGURED_CARVERS.keySet()) {
			Registry.register(BuiltinRegistries.CONFIGURED_CARVER, id, CONFIGURED_CARVERS.get(id));
		}
	}
}
