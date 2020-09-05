package com.terraformersmc.cinderscapes.mixinterface;

import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.WorldView;
import net.minecraft.world.biome.Biome;

/**
 * @author <Wtoll> Will Toll on 2020-05-23
 * @project Cinderscapes
 */
public final class AshyBiomes {

    private AshyBiomes() {
    }

    public static boolean isAshyBiome(RegistryKey<Biome> biome) {
        return biome == CinderscapesBiomes.ASHY_SHOALS;
    }

    public static boolean canSetAsh(RegistryKey<Biome> biome, WorldView world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos);
        return blockState.isAir() && CinderscapesBlocks.ASH.getDefaultState().canPlaceAt(world, pos);
    }

}
