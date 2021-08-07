package com.terraformersmc.cinderscapes.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.sound.SoundEvent;

public class CinderscapesMusicDiscItem extends MusicDiscItem {
    public CinderscapesMusicDiscItem(SoundEvent sound) {
        super(0, sound, new FabricItemSettings().maxCount(1));
    }
}
