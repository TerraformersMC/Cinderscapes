package com.terraformersmc.cinderscapes.mixin;

import com.terraformersmc.cinderscapes.config.CinderscapesConfig;
import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.tag.CinderscapesBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.util.registry.RegistryEntry;
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

@Mixin(ServerWorld.class)
public abstract class MixinServerWorld extends World {

    public MixinServerWorld(MutableWorldProperties properties, RegistryKey<World> registryRef, RegistryEntry<DimensionType> dimensionType, Supplier<Profiler> profiler, boolean isClient, boolean debugWorld, long seed) {
        super(properties, registryRef, dimensionType, profiler, isClient, debugWorld, seed);
    }

    // TODO: Revisit this and make it easier to read
    @Inject(method="tickChunk", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/server/world/ServerWorld;getBiome(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/util/registry/RegistryEntry;", ordinal = 0), locals = LocalCapture.CAPTURE_FAILHARD)
    private void cinderscapes$tickChunk(WorldChunk chunk, int randomTickSpeed, CallbackInfo callback, ChunkPos chunkPos, boolean bl, int i, int j, Profiler profiler, BlockPos blockPos2, BlockPos blockPos3) {
        if (CinderscapesConfig.INSTANCE.enableAshFall) {
            BlockPos pos = this.getRandomPosInChunk(i, 0, j, 15);
            BlockState state = getBlockState(pos);
            RegistryEntry<Biome> biome = this.getBiome(pos);

            while (!(
                    biome.matchesKey(CinderscapesBiomes.ASHY_SHOALS) &&
                            state.isSideSolidFullSquare(this, pos, Direction.UP) &&
                            blockAbove(pos).isIn(CinderscapesBlockTags.ASH_PERMEABLE) &&
                            this.getBlockState(pos.up()).isAir() &&
                            CinderscapesBlocks.ASH.getDefaultState().canPlaceAt(this, pos.up())) &&
                    pos.getY() < 127) {
                pos = pos.up();
                state = getBlockState(pos);
                biome = this.getBiome(pos);
            }
            if (pos.getY() < 127) this.setBlockState(pos.up(), CinderscapesBlocks.ASH.getDefaultState());
        }
    }

    private BlockState blockAbove(BlockPos pos) {
        BlockPos iPos = pos.mutableCopy();
        while(isAir(iPos.up()) && iPos.getY() < 127) {
            iPos = iPos.up();
        }
        return getBlockState(iPos.up());
    }

}