package com.terraformersmc.cinderscapes.mixin;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.init.CinderscapesTags;
import com.terraformersmc.cinderscapes.mixinterface.AshyBiomes;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.MutableWorldProperties;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.WorldChunk;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.function.Supplier;

/**
 * @author <Wtoll> Will Toll on 2020-05-23
 * @project Cinderscapes
 */
@SuppressWarnings("unused")
@Mixin(ServerWorld.class)
public abstract class ServerWorldMixin extends World {

    public ServerWorldMixin(MutableWorldProperties properties, RegistryKey<World> registryRef, DimensionType dimensionType, Supplier<Profiler> profiler, boolean isClient, boolean debugWorld, long seed) {
        super(properties, registryRef, dimensionType, profiler, isClient, debugWorld, seed);
    }

    @Inject(method="tickChunk", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/server/world/ServerWorld;getBiome(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/world/biome/Biome;", ordinal = 0), locals = LocalCapture.CAPTURE_FAILHARD)
    private void tickChunk(WorldChunk chunk, int randomTickSpeed, CallbackInfo callback, ChunkPos chunkPos, boolean bl, int i, int j, Profiler profiler, BlockPos blockPos2, BlockPos blockPos3, Biome biome2) {

        BlockPos pos = this.getRandomPosInChunk(i, 0, j, 15);
        BlockState state = getBlockState(pos);
        RegistryKey<Biome> biome = this.method_31081(pos).orElse(null);

        while (!( AshyBiomes.isAshyBiome(biome) && state.isSideSolidFullSquare(this, pos, Direction.UP) && CinderscapesTags.ASH_BLOCKER.contains(blockAbove(pos).getBlock()) && AshyBiomes.canSetAsh(biome, this, pos.up())) && pos.getY() < 128) {
            pos = pos.up();
            state = getBlockState(pos);
            biome = this.method_31081(pos).orElse(null);
        }
        if (pos.getY() < 128) this.setBlockState(pos.up(), CinderscapesBlocks.ASH.getDefaultState());
    }

    private BlockState blockAbove(BlockPos pos) {
        BlockPos iPos = pos.mutableCopy();
        while(isAir(iPos.up()) && iPos.getY() < 128) {
            iPos = iPos.up();
        }
        return getBlockState(iPos.up());
    }

}
