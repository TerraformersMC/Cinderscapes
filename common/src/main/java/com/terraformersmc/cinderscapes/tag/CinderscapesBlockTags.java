package com.terraformersmc.cinderscapes.tag;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.Identifier;

public class CinderscapesBlockTags {
    public static final TagKey<Block> ASH_PERMEABLE = CinderscapesBlockTags.of("ash_permeable");
    public static final TagKey<Block> SCORCHED_STEMS = CinderscapesBlockTags.of("scorched_stems");
    public static final TagKey<Block> UMBRAL_STEMS = CinderscapesBlockTags.of("umbral_stems");

    @SuppressWarnings("UnnecessaryReturnStatement")
    private CinderscapesBlockTags() {
        return;
    }

    private static TagKey<Block> of(String path) {
        return CinderscapesBlockTags.of(Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, path));
    }

    private static TagKey<Block> of(Identifier id) {
        return TagKey.create(Registries.BLOCK, id);
    }
}
