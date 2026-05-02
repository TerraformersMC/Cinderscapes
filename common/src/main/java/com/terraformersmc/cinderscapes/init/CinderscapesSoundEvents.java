package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.Identifier;

public class CinderscapesSoundEvents {
	public static final Holder<SoundEvent> ASHY_SHOALS_MUSIC = add("music.nether.ashy_shoals");
	public static final Holder<SoundEvent> BLACKSTONE_SHALES_MUSIC = add("music.nether.blackstone_shales");
	public static final Holder<SoundEvent> LUMINOUS_GROVE_MUSIC = add("music.nether.luminous_grove");
	public static final Holder<SoundEvent> QUARTZ_CAVERN_MUSIC = add("music.nether.quartz_cavern");

	public static final Holder<SoundEvent> MENU_MUSIC = add("music.menu");

	public static final Holder<SoundEvent> MUSIC_DISC_LUMINOUS_PLANTATION = add("music_disc.luminous_plantation");
	public static final Holder<SoundEvent> MUSIC_DISC_CHILLING_IN_HELL = add("music_disc.chilling_in_hell");

	private static Holder<SoundEvent> add(String path) {
		Identifier id = Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, path);
		SoundEvent event = SoundEvent.createVariableRangeEvent(id);

		return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, id, event);
	}

	public static void init() {
	}
}
