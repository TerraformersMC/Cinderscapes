package com.terraformersmc.cinderscapes.tag;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockItemTagId;
import net.minecraft.tags.TagKey;
import org.jspecify.annotations.NullMarked;

@NullMarked
@SuppressWarnings("unused")
public class CinderscapesBlockItemTags {
    // Conventional tags provided by Fabric (but we want them as BlockItemTags)
    public static final BlockItemTagId ORES = from(ConventionalBlockTags.ORES);
    public static final BlockItemTagId ORES_IN_GROUND_NETHERRACK = from(ConventionalBlockTags.ORES_IN_GROUND_NETHERRACK);
    public static final BlockItemTagId QUARTZ_ORES = from(ConventionalBlockTags.QUARTZ_ORES);
    public static final BlockItemTagId STRIPPED_LOGS = from(ConventionalBlockTags.STRIPPED_LOGS);
    public static final BlockItemTagId STRIPPED_WOODS = from(ConventionalBlockTags.STRIPPED_WOODS);

    // Conventional tags not provided by Fabric
    public static final BlockItemTagId SULFURS_ORES = create(Identifier.fromNamespaceAndPath("c", "ores/sulfurs"));

    // Unconventional tags
    public static final BlockItemTagId SCORCHED_STEMS = create("scorched_stems");
    public static final BlockItemTagId UMBRAL_STEMS = create("umbral_stems");

    @SuppressWarnings("UnnecessaryReturnStatement")
    private CinderscapesBlockItemTags() {
        return;
    }

    private static BlockItemTagId create(String path) {
        return create(Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, path));
    }

    private static BlockItemTagId create(Identifier id) {
        return BlockItemTagId.create(id, id);
    }

    private static BlockItemTagId from(TagKey<?> key) {
        return create(key.location());
    }
}
