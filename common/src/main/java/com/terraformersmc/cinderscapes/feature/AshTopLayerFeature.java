package com.terraformersmc.cinderscapes.feature;

import com.google.common.base.Suppliers;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.init.CinderscapesPlacedFeatures;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class AshTopLayerFeature extends Feature<DefaultFeatureConfig> {
    public AshTopLayerFeature() {
        super(DefaultFeatureConfig.CODEC);
    }

    // Suppress placement validity check because we are evaluating multiple positions.
    @Override
    public boolean generateIfValid(DefaultFeatureConfig config, StructureWorldAccess world, ChunkGenerator chunkGenerator, Random random, BlockPos pos) {
        return this.generate(new FeatureContext<>(Optional.empty(), world, chunkGenerator, random, pos, config));
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos origin = context.getOrigin();
        BlockPos.Mutable pos = new BlockPos.Mutable();
        BlockPos.Mutable posBelow = new BlockPos.Mutable();

        for (int offsetX = 0; offsetX < 16; ++offsetX) {
            for (int offsetZ = 0; offsetZ < 16; ++offsetZ) {
                int x = origin.getX() + offsetX;
                int z = origin.getZ() + offsetZ;
                int topY = world.getTopY(Heightmap.Type.MOTION_BLOCKING, x, z);
                pos.set(x, topY, z);
                posBelow.set(x, topY - 1, z);

                while (pos.getY() > world.getBottomY()) {
                    if (    world.isValidForSetBlock(pos) &&
                            world.isAir(pos) &&
                            world.getBlockState(posBelow).isSideSolidFullSquare(world, posBelow, Direction.UP) &&
                            getValidBiomes(world).contains(world.getBiome(pos).value())) {
                        world.setBlockState(pos, CinderscapesBlocks.ASH.getDefaultState(), 2);
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

    private static Set<Biome> getValidBiomes(StructureWorldAccess world) {
        return Suppliers.memoize(() -> world.getRegistryManager().getOrThrow(RegistryKeys.BIOME).stream()
                .filter(biome -> biome.getGenerationSettings()
                        .isFeatureAllowed(world.getRegistryManager().getOrThrow(RegistryKeys.PLACED_FEATURE)
                                .getValueOrThrow(CinderscapesPlacedFeatures.ASH_TOP_LAYER)))
                .collect(Collectors.toSet())).get();
    }
}
