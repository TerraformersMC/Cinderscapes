package com.terraformersmc.cinderscapes.feature;

import com.google.common.base.Suppliers;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.init.CinderscapesPlacedFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import org.jspecify.annotations.NullMarked;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@NullMarked
public class AshTopLayerFeature extends Feature<NoneFeatureConfiguration> {
    public AshTopLayerFeature() {
        super(NoneFeatureConfiguration.CODEC);
    }

    // Suppress placement validity check because we are evaluating multiple positions.
    @Override
    public boolean place(NoneFeatureConfiguration config, WorldGenLevel level, ChunkGenerator chunkGenerator, RandomSource random, BlockPos pos) {
        return this.place(new FeaturePlaceContext<>(Optional.empty(), level, chunkGenerator, random, pos, config));
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        BlockPos.MutableBlockPos posBelow = new BlockPos.MutableBlockPos();

        for (int offsetX = 0; offsetX < 16; ++offsetX) {
            for (int offsetZ = 0; offsetZ < 16; ++offsetZ) {
                int x = origin.getX() + offsetX;
                int z = origin.getZ() + offsetZ;
                int topY = level.getHeight(Heightmap.Types.MOTION_BLOCKING, x, z);
                pos.set(x, topY, z);
                posBelow.set(x, topY - 1, z);

                while (pos.getY() > level.getMinY()) {
                    if (    level.ensureCanWrite(pos) &&
                            level.isEmptyBlock(pos) &&
                            level.getBlockState(posBelow).isFaceSturdy(level, posBelow, Direction.UP) &&
                            getValidBiomes(level).contains(level.getBiome(pos).value())) {
                        level.setBlock(pos, CinderscapesBlocks.ASH.defaultBlockState(), 2);
                        pos.setY(pos.getY() - 2);
                    } else {
                        pos.setY(pos.getY() - 1);
                    }
                    posBelow.setY(pos.getY() - 1);
                }
            }
        }

        return true;
    }

    private static Set<Biome> getValidBiomes(WorldGenLevel level) {
        return Suppliers.memoize(() -> level.registryAccess().lookupOrThrow(Registries.BIOME).stream()
                .filter(biome -> biome.getGenerationSettings()
                        .hasFeature(level.registryAccess().lookupOrThrow(Registries.PLACED_FEATURE)
                                .getValueOrThrow(CinderscapesPlacedFeatures.ASH_TOP_LAYER)))
                .collect(Collectors.toSet())).get();
    }
}
