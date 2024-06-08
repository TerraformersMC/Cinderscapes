package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.mixin.SoundEventAccessor;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import java.util.LinkedHashMap;
import java.util.Map;

public class CinderscapesSoundEvents {
	// Acts as a kind of local registry for sound events added by Cinderscapes
	private static final Map<Identifier, SoundEvent> SOUND_EVENTS = new LinkedHashMap<>();

	public static final SoundEvent ASHY_SHOALS_MUSIC = add(SoundEvent.of(Identifier.of(Cinderscapes.MOD_ID, "music.nether.ashy_shoals")));
	public static final SoundEvent BLACKSTONE_SHALES_MUSIC = add(SoundEvent.of(Identifier.of(Cinderscapes.MOD_ID, "music.nether.blackstone_shales")));
	public static final SoundEvent LUMINOUS_GROVE_MUSIC = add(SoundEvent.of(Identifier.of(Cinderscapes.MOD_ID, "music.nether.luminous_grove")));
	public static final SoundEvent QUARTZ_CAVERN_MUSIC = add(SoundEvent.of(Identifier.of(Cinderscapes.MOD_ID, "music.nether.quartz_cavern")));

	public static final SoundEvent MENU_MUSIC = add(SoundEvent.of(Identifier.of(Cinderscapes.MOD_ID, "music.menu")));

	public static final SoundEvent MUSIC_DISC_LUMINOUS_PLANTATION = add(SoundEvent.of(Identifier.of(Cinderscapes.MOD_ID, "music_disc.luminous_plantation")));
	public static final SoundEvent MUSIC_DISC_CHILLING_IN_HELL = add(SoundEvent.of(Identifier.of(Cinderscapes.MOD_ID, "music_disc.chilling_in_hell")));

	private static <S extends SoundEvent> S add(S sound_event) {
		SOUND_EVENTS.put(((SoundEventAccessor) sound_event).cinderscapes$getId(), sound_event);
		return sound_event;
	}

	public static void init() {
		for (Identifier id : SOUND_EVENTS.keySet()) {
			Registry.register(Registries.SOUND_EVENT, id, SOUND_EVENTS.get(id));
		}
	}
}
