package com.terraformersmc.cinderscapes.block;

import com.terraformersmc.cinderscapes.init.CinderscapesFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.BonemealSource;
import net.minecraft.world.level.block.NyliumBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class CinderscapesNyliumBlock extends NyliumBlock {
    public CinderscapesNyliumBlock(Properties settings) {
        super(settings);
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state, BonemealSource source) {
        BlockPos abovePos = pos.above();
        ChunkGenerator generator = level.getChunkSource().getGenerator();
        Registry<Feature> configuredFeatures = level.registryAccess().lookupOrThrow(Registries.FEATURE);

        // Why did Mojang abstract out NyliumBlock.place() then make it private?!
        if (level.isInsideBuildHeight(pos)) {
            configuredFeatures.get(CinderscapesFeatures.UMBRAL_NYLIUM_BONEMEAL)
                    .ifPresent(ref -> ref.value().place(level, generator, random, abovePos));
        }
    }
}
