package com.terraformersmc.cinderscapes.tag;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class CinderscapesBlockTags {
    public static final TagKey<Block> ASH_PERMEABLE = CinderscapesBlockTags.of("ash_permeable");
    public static final TagKey<Block> SCORCHED_STEMS = CinderscapesBlockTags.of("scorched_stems");
    public static final TagKey<Block> UMBRAL_STEMS = CinderscapesBlockTags.of("umbral_stems");

    public static final TagKey<Block> STRIPPED_LOGS = CinderscapesBlockTags.of(Identifier.of("c", "stripped_logs"));
    public static final TagKey<Block> STRIPPED_WOOD = CinderscapesBlockTags.of(Identifier.of("c", "stripped_wood"));

    @SuppressWarnings("UnnecessaryReturnStatement")
    private CinderscapesBlockTags() {
        return;
    }

    private static TagKey<Block> of(String path) {
        return CinderscapesBlockTags.of(Identifier.of(Cinderscapes.MOD_ID, path));
    }

    private static TagKey<Block> of(Identifier id) {
        return TagKey.of(RegistryKeys.BLOCK, id);
    }
}
