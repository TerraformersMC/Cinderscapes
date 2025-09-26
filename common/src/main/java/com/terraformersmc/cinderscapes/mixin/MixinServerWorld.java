package com.terraformersmc.cinderscapes.mixin;

import com.terraformersmc.cinderscapes.config.CinderscapesConfig;
import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.tag.CinderscapesBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkSectionPos;
import net.minecraft.util.math.random.RandomSequencesState;
import net.minecraft.world.MutableWorldProperties;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkSection;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.level.ServerWorldProperties;
import net.minecraft.world.level.storage.LevelStorage;
import net.minecraft.world.spawner.SpecialSpawner;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.function.Predicate;

@Mixin(ServerWorld.class)
public abstract class MixinServerWorld extends World {
    @Unique
    private static Predicate<RegistryEntry<Biome>> ASHY_SHOALS_PREDICATE;

    protected MixinServerWorld(MutableWorldProperties properties, RegistryKey<World> registryRef, DynamicRegistryManager registryManager, RegistryEntry<DimensionType> dimensionEntry, boolean isClient, boolean debugWorld, long biomeAccess, int maxChainedNeighborUpdates) {
        super(properties, registryRef, registryManager, dimensionEntry, isClient, debugWorld, biomeAccess, maxChainedNeighborUpdates);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void cinderscapes$cacheAshyShoalsEntry(MinecraftServer server, Executor workerExecutor, LevelStorage.Session session, ServerWorldProperties properties, RegistryKey<World> worldKey, DimensionOptions dimensionOptions, boolean debugWorld, long seed, List<SpecialSpawner> spawners, boolean shouldTickTime, @Nullable RandomSequencesState randomSequenceState, CallbackInfo ci) {
        ASHY_SHOALS_PREDICATE = Predicate.isEqual(getRegistryManager().getOrThrow(RegistryKeys.BIOME).getOptional(CinderscapesBiomes.ASHY_SHOALS).orElseThrow());
    }

    /*
     * NOTE: Unlike this mixin, vanilla evaluates the tick only at the surface Y level.
     * This means there is no utility for us in reusing vanilla's calculations.
     */
    @Inject(method = "tickIceAndSnow", at = @At("HEAD"), locals = LocalCapture.NO_CAPTURE)
    private void cinderscapes$tickAsh(BlockPos tickPos, CallbackInfo ci) {
        if (!CinderscapesConfig.INSTANCE.enableAshFall) {
            return;
        }

        BlockPos.Mutable pos = tickPos.mutableCopy();
        ChunkSection[] sections = getChunk(tickPos).getSectionArray();
        int sectionIndex;

        for (pos.setY(pos.getY() + 1); pos.getY() < 127; pos.setY(pos.getY() + 1)) {
            sectionIndex = ChunkSectionPos.getSectionCoord(pos.getY());

            if (sections[sectionIndex].isEmpty() || !sections[sectionIndex].getBiomeContainer().hasAny(ASHY_SHOALS_PREDICATE)) {
                pos.setY(ChunkSectionPos.getBlockCoord(sectionIndex + 1) - 1);
                continue;
            }

            if (canPlaceAshAt(pos) && getBiome(pos).matchesKey(CinderscapesBiomes.ASHY_SHOALS)) {
                setBlockState(pos, CinderscapesBlocks.ASH.getDefaultState());
                break;
            }
        }
    }

    @Unique
    private boolean canPlaceAshAt(BlockPos.Mutable pos) {
        return getBlockState(pos).isAir() &&
                blockAbove(pos).isIn(CinderscapesBlockTags.ASH_PERMEABLE) &&
                CinderscapesBlocks.ASH.getDefaultState().canPlaceAt(this, pos);
    }

    @Unique
    private BlockState blockAbove(BlockPos.Mutable pos) {
        int originalY = pos.getY();
        BlockState stateAbove;

        //noinspection StatementWithEmptyBody
        for (; isAir(pos) && pos.getY() < 127; pos.setY(pos.getY() + 1));

        stateAbove = getBlockState(pos);
        pos.setY(originalY);

        return stateAbove;
    }
}