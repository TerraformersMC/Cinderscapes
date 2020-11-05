package com.terraformersmc.cinderscapes.modules.luminousgrove;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.helper.RegistryHelper;
import net.minecraft.sound.SoundEvent;

public class LuminousGroveSoundEvents {

    public static final SoundEvent AMBIENT_MUSIC = RegistryHelper.register(new SoundEvent(Cinderscapes.id("music.nether.luminous_grove")));
    public static final SoundEvent MUSIC_DISC_LUMINOUS_PLANTATION = RegistryHelper.register(new SoundEvent(Cinderscapes.id("music_disc.luminous_plantation")));

    public static void onInitialize() { }
}
