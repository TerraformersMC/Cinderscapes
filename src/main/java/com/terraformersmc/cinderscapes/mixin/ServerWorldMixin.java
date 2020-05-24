package com.terraformersmc.cinderscapes.mixin;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.mixinterface.AshyBiome;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_5268;
import net.minecraft.class_5269;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.WorldGenerationProgressListener;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkManager;
import net.minecraft.world.chunk.WorldChunk;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.level.storage.LevelStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.concurrent.Executor;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * @author <Wtoll> Will Toll on 2020-05-23
 * @project Cinderscapes
 */
@SuppressWarnings("unused")
@Mixin(ServerWorld.class)
public abstract class ServerWorldMixin extends World {

    private ServerWorldMixin(class_5269 levelProperties, DimensionType dimensionType, BiFunction<World, Dimension, ChunkManager> chunkManagerProvider, Supplier<Profiler> profiler, boolean isClient) {
        super(levelProperties, dimensionType, chunkManagerProvider, profiler, isClient);
    }

    @Inject(method="tickChunk", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/server/world/ServerWorld;getBiome(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/world/biome/Biome;", ordinal = 0), locals = LocalCapture.CAPTURE_FAILHARD)
    private void tickChunk(WorldChunk chunk, int randomTickSpeed, CallbackInfo callback, ChunkPos chunkPos, boolean bl, int i, int j, Profiler profiler, BlockPos blockPos2, BlockPos blockPos3, Biome biome2) {
        BlockPos pos = this.getRandomPosInChunk(i, 0, j, 15).up();
        BlockState state = getBlockState(pos);
        Biome biome = this.getBiome(pos);
        while (biome instanceof AshyBiome && pos.getY() <= 128 && !(((AshyBiome) biome).canSetAsh(this, pos) && state.isAir())) {
            pos = pos.up();
            state = getBlockState(pos);
            biome = this.getBiome(pos);
        }
        if (biome instanceof AshyBiome && ((AshyBiome) biome).canSetAsh(this, pos)) {
            this.setBlockState(pos, CinderscapesBlocks.ASH.getDefaultState());
        }
    }
}
