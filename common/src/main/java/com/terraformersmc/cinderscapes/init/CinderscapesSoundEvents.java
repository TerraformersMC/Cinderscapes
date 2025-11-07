package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class CinderscapesSoundEvents {
	public static final RegistryEntry<SoundEvent> ASHY_SHOALS_MUSIC = add("music.nether.ashy_shoals");
	public static final RegistryEntry<SoundEvent> BLACKSTONE_SHALES_MUSIC = add("music.nether.blackstone_shales");
	public static final RegistryEntry<SoundEvent> LUMINOUS_GROVE_MUSIC = add("music.nether.luminous_grove");
	public static final RegistryEntry<SoundEvent> QUARTZ_CAVERN_MUSIC = add("music.nether.quartz_cavern");

	public static final RegistryEntry<SoundEvent> MENU_MUSIC = add("music.menu");

	public static final RegistryEntry<SoundEvent> MUSIC_DISC_LUMINOUS_PLANTATION = add("music_disc.luminous_plantation");
	public static final RegistryEntry<SoundEvent> MUSIC_DISC_CHILLING_IN_HELL = add("music_disc.chilling_in_hell");

	private static RegistryEntry<SoundEvent> add(String path) {
		Identifier id = Identifier.of(Cinderscapes.MOD_ID, path);
		SoundEvent event = SoundEvent.of(id);

		return Registry.registerReference(Registries.SOUND_EVENT, id, event);
	}

	public static void init() {
	}
}
