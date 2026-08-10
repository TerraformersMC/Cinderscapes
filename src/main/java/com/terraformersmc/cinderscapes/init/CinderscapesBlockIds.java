package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.*;
import org.jspecify.annotations.NullMarked;

@NullMarked
@SuppressWarnings("unused")
public class CinderscapesBlockIds {

    /*///////////////
    // Ashy Shoals //
    ///////////////*/

    public static final ResourceKey<Block> BRAMBLE_BERRY_BUSH = create(id("bramble_berry_bush"));

    public static final ResourceKey<Block> SCORCHED_WALL_SIGN = create(id("scorched_wall_sign"));
    public static final ResourceKey<Block> SCORCHED_WALL_HANGING_SIGN = create(id("scorched_wall_hanging_sign"));

    public static final ResourceKey<Block> POTTED_PYRACINTH = create(id("potted_pyracinth"));
    public static final ResourceKey<Block> POTTED_SCORCHED_SHRUB = create(id("potted_scorched_shrub"));
    public static final ResourceKey<Block> POTTED_SCORCHED_TENDRILS = create(id("potted_scorched_tendrils"));

    /*//////////////////
    // Luminous Grove //
    //////////////////*/

    public static final ResourceKey<Block> POTTED_LUMINOUS_POD = create(id("potted_luminous_pod"));
    public static final ResourceKey<Block> POTTED_PHOTOFERN = create(id("potted_photofern"));
    public static final ResourceKey<Block> POTTED_TWILIGHT_TENDRILS = create(id("potted_twilight_tendrils"));
    public static final ResourceKey<Block> POTTED_UMBRAL_FUNGUS = create(id("potted_umbral_fungus"));

    public static final ResourceKey<Block> UMBRAL_WALL_SIGN = create(id("umbral_wall_sign"));
    public static final ResourceKey<Block> UMBRAL_WALL_HANGING_SIGN = create(id("umbral_wall_hanging_sign"));

    /*/////////////////
    // Quartz Cavern //
    /////////////////*/

    public static final ResourceKey<Block> POTTED_CRYSTINIUM = create(id("potted_crystinium"));
    public static final ResourceKey<Block> POTTED_POLYPITE_QUARTZ = create(id("potted_polypite_quartz"));
    public static final ResourceKey<Block> POTTED_POLYPITE_ROSE_QUARTZ = create(id("potted_polypite_rose_quartz"));
    public static final ResourceKey<Block> POTTED_POLYPITE_SMOKY_QUARTZ = create(id("potted_polypite_smoky_quartz"));
    public static final ResourceKey<Block> POTTED_POLYPITE_SULFUR_QUARTZ = create(id("potted_polypite_sulfur_quartz"));


    private static ResourceKey<Block> create(final Identifier id) {
        return ResourceKey.create(Registries.BLOCK, id);
    }

    private static ResourceKey<Block> create(final String name) {
        return create(id(name));
    }

    private static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(Cinderscapes.MOD_ID, path);
    }
}
