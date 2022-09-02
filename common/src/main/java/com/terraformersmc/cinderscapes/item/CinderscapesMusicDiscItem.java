package com.terraformersmc.cinderscapes.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Rarity;

public class CinderscapesMusicDiscItem extends MusicDiscItem {
    public CinderscapesMusicDiscItem(int comparatorOutput, SoundEvent sound) {
        // TODO: Do I really have to tell Minecraft how long the disc is?
        super(comparatorOutput, sound, new FabricItemSettings().maxCount(1).group(ItemGroup.MISC).rarity(Rarity.RARE), 300);
    }
}
