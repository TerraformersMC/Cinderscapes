package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.init.CinderscapesBlockItemIds;
import com.terraformersmc.cinderscapes.tag.CinderscapesBlockItemTags;
import net.minecraft.data.tags.BlockItemTagsProvider;
import net.minecraft.tags.BlockItemTagId;
import net.minecraft.tags.BlockItemTags;
import org.jspecify.annotations.NullMarked;

import java.util.function.Function;

@NullMarked
public class CinderscapesBlockItemTagsProvider extends BlockItemTagsProvider {
    protected CinderscapesBlockItemTagsProvider(Function<BlockItemTagId, CombinedAppender> tagSupplier) {
        super(tagSupplier);
    }

    protected void run() {
        /*
         * Basic block tags
         */
        tag(BlockItemTags.FENCE_GATES)
                .add(CinderscapesBlockItemIds.SCORCHED_FENCE_GATE)
                .add(CinderscapesBlockItemIds.UMBRAL_FENCE_GATE);

        tag(BlockItemTags.LOGS)
                .add(CinderscapesBlockItemIds.SCORCHED_HYPHAE)
                .add(CinderscapesBlockItemIds.SCORCHED_STEM)
                .add(CinderscapesBlockItemIds.STRIPPED_SCORCHED_HYPHAE)
                .add(CinderscapesBlockItemIds.STRIPPED_SCORCHED_STEM)
                .add(CinderscapesBlockItemIds.STRIPPED_UMBRAL_HYPHAE)
                .add(CinderscapesBlockItemIds.STRIPPED_UMBRAL_STEM)
                .add(CinderscapesBlockItemIds.UMBRAL_HYPHAE)
                .add(CinderscapesBlockItemIds.UMBRAL_STEM);

        tag(BlockItemTags.PLANKS)
                .add(CinderscapesBlockItemIds.UMBRAL_PLANKS)
                .add(CinderscapesBlockItemIds.SCORCHED_PLANKS);

        tag(BlockItemTags.SLABS)
                .add(CinderscapesBlockItemIds.ROSE_QUARTZ_SLAB)
                .add(CinderscapesBlockItemIds.SMOKY_QUARTZ_SLAB)
                .add(CinderscapesBlockItemIds.SMOOTH_ROSE_QUARTZ_SLAB)
                .add(CinderscapesBlockItemIds.SMOOTH_SMOKY_QUARTZ_SLAB)
                .add(CinderscapesBlockItemIds.SMOOTH_SULFUR_QUARTZ_SLAB)
                .add(CinderscapesBlockItemIds.SULFUR_QUARTZ_SLAB);

        tag(BlockItemTags.SMALL_FLOWERS)
                .add(CinderscapesBlockItemIds.CRYSTINIUM)
                .add(CinderscapesBlockItemIds.PYRACINTH)
                .add(CinderscapesBlockItemIds.SCORCHED_TENDRILS)
                .add(CinderscapesBlockItemIds.TWILIGHT_TENDRILS);

        tag(BlockItemTags.STAIRS)
                .add(CinderscapesBlockItemIds.ROSE_QUARTZ_STAIRS)
                .add(CinderscapesBlockItemIds.SMOKY_QUARTZ_STAIRS)
                .add(CinderscapesBlockItemIds.SMOOTH_ROSE_QUARTZ_STAIRS)
                .add(CinderscapesBlockItemIds.SMOOTH_SMOKY_QUARTZ_STAIRS)
                .add(CinderscapesBlockItemIds.SMOOTH_SULFUR_QUARTZ_STAIRS)
                .add(CinderscapesBlockItemIds.SULFUR_QUARTZ_STAIRS);

        tag(BlockItemTags.WART_BLOCKS)
                .add(CinderscapesBlockItemIds.UMBRAL_WART_BLOCK);

        tag(BlockItemTags.WOODEN_BUTTONS)
                .add(CinderscapesBlockItemIds.SCORCHED_BUTTON)
                .add(CinderscapesBlockItemIds.UMBRAL_BUTTON);

        tag(BlockItemTags.WOODEN_DOORS)
                .add(CinderscapesBlockItemIds.SCORCHED_DOOR)
                .add(CinderscapesBlockItemIds.UMBRAL_DOOR);

        tag(BlockItemTags.WOODEN_FENCES)
                .add(CinderscapesBlockItemIds.SCORCHED_FENCE)
                .add(CinderscapesBlockItemIds.UMBRAL_FENCE);

        tag(BlockItemTags.WOODEN_PRESSURE_PLATES)
                .add(CinderscapesBlockItemIds.SCORCHED_PRESSURE_PLATE)
                .add(CinderscapesBlockItemIds.UMBRAL_PRESSURE_PLATE);

        tag(BlockItemTags.WOODEN_SHELVES)
                .add(CinderscapesBlockItemIds.SCORCHED_SHELF)
                .add(CinderscapesBlockItemIds.UMBRAL_SHELF);

        tag(BlockItemTags.WOODEN_SLABS)
                .add(CinderscapesBlockItemIds.SCORCHED_SLAB)
                .add(CinderscapesBlockItemIds.UMBRAL_SLAB);

        tag(BlockItemTags.WOODEN_STAIRS)
                .add(CinderscapesBlockItemIds.SCORCHED_STAIRS)
                .add(CinderscapesBlockItemIds.UMBRAL_STAIRS);

        tag(BlockItemTags.WOODEN_TRAPDOORS)
                .add(CinderscapesBlockItemIds.SCORCHED_TRAPDOOR)
                .add(CinderscapesBlockItemIds.UMBRAL_TRAPDOOR);


        /*
         * Conventional block tags
         */
        tag(CinderscapesBlockItemTags.ORES)
                .add(CinderscapesBlockItemIds.SULFUR_ORE);

        tag(CinderscapesBlockItemTags.ORES_IN_GROUND_NETHERRACK)
                .add(CinderscapesBlockItemIds.ROSE_QUARTZ_ORE)
                .add(CinderscapesBlockItemIds.SMOKY_QUARTZ_ORE)
                .add(CinderscapesBlockItemIds.SULFUR_QUARTZ_ORE)
                .add(CinderscapesBlockItemIds.SULFUR_ORE);

        tag(CinderscapesBlockItemTags.QUARTZ_ORES)
                .add(CinderscapesBlockItemIds.ROSE_QUARTZ_ORE)
                .add(CinderscapesBlockItemIds.SMOKY_QUARTZ_ORE)
                .add(CinderscapesBlockItemIds.SULFUR_QUARTZ_ORE);

        tag(CinderscapesBlockItemTags.STRIPPED_LOGS)
                .add(CinderscapesBlockItemIds.STRIPPED_SCORCHED_STEM)
                .add(CinderscapesBlockItemIds.STRIPPED_UMBRAL_STEM);

        tag(CinderscapesBlockItemTags.STRIPPED_WOODS)
                .add(CinderscapesBlockItemIds.STRIPPED_SCORCHED_HYPHAE)
                .add(CinderscapesBlockItemIds.STRIPPED_UMBRAL_HYPHAE);

        tag(CinderscapesBlockItemTags.SULFURS_ORES)
                .add(CinderscapesBlockItemIds.SULFUR_ORE);


        /*
         * Local block tags
         */
        tag(CinderscapesBlockItemTags.SCORCHED_STEMS)
                .add(CinderscapesBlockItemIds.SCORCHED_HYPHAE)
                .add(CinderscapesBlockItemIds.SCORCHED_STEM)
                .add(CinderscapesBlockItemIds.STRIPPED_SCORCHED_HYPHAE)
                .add(CinderscapesBlockItemIds.STRIPPED_SCORCHED_STEM);

        tag(CinderscapesBlockItemTags.UMBRAL_STEMS)
                .add(CinderscapesBlockItemIds.UMBRAL_HYPHAE)
                .add(CinderscapesBlockItemIds.UMBRAL_STEM)
                .add(CinderscapesBlockItemIds.STRIPPED_UMBRAL_HYPHAE)
                .add(CinderscapesBlockItemIds.STRIPPED_UMBRAL_STEM);
    }
}
