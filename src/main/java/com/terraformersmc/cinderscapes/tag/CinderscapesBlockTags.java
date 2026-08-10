package com.terraformersmc.cinderscapes.tag;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NullMarked;

@NullMarked
@SuppressWarnings("unused")
public class CinderscapesBlockTags {
    public static final TagKey<Block> ASH_PERMEABLE = CinderscapesBlockTags.create("ash_permeable");
    public static final TagKey<Block> SUPPORTS_UMBRAL_FUNGUS = CinderscapesBlockTags.create("supports_umbral_fungus");

    @SuppressWarnings("UnnecessaryReturnStatement")
    private CinderscapesBlockTags() {
        return;
    }

    private static TagKey<Block> create(String path) {
        return create(Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, path));
    }

    private static TagKey<Block> create(Identifier id) {
        return TagKey.create(Registries.BLOCK, id);
    }
}
