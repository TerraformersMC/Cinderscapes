package com.terraformersmc.cinderscapes.mixin;

import com.terraformersmc.cinderscapes.config.CinderscapesConfig;
import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.tag.CinderscapesBlockTags;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Holder;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.world.RandomSequences;
import net.minecraft.world.level.storage.WritableLevelData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.storage.ServerLevelData;
import net.minecraft.world.level.storage.LevelStorageSource;
import net.minecraft.world.level.CustomSpawner;
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

@Mixin(ServerLevel.class)
public abstract class MixinServerLevel extends Level {
    @Unique
    private static Predicate<Holder<Biome>> ASHY_SHOALS_PREDICATE;

    protected MixinServerLevel(WritableLevelData properties, ResourceKey<Level> registryRef, RegistryAccess registryManager, Holder<DimensionType> dimensionEntry, boolean isClient, boolean debugWorld, long biomeAccess, int maxChainedNeighborUpdates) {
        super(properties, registryRef, registryManager, dimensionEntry, isClient, debugWorld, biomeAccess, maxChainedNeighborUpdates);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void cinderscapes$cacheAshyShoalsEntry(MinecraftServer server, Executor workerExecutor, LevelStorageSource.LevelStorageAccess session, ServerLevelData properties, ResourceKey<Level> worldKey, LevelStem dimensionOptions, boolean debugWorld, long seed, List<CustomSpawner> spawners, boolean shouldTickTime, @Nullable RandomSequences randomSequenceState, CallbackInfo ci) {
        ASHY_SHOALS_PREDICATE = Predicate.isEqual(registryAccess().lookupOrThrow(Registries.BIOME).get(CinderscapesBiomes.ASHY_SHOALS).orElseThrow());
    }

    /*
     * NOTE: Unlike this mixin, vanilla evaluates the tick only at the surface Y level.
     * This means there is no utility for us in reusing vanilla's calculations.
     */
    @Inject(method = "tickPrecipitation", at = @At("HEAD"), locals = LocalCapture.NO_CAPTURE)
    private void cinderscapes$tickAsh(BlockPos tickPos, CallbackInfo ci) {
        if (!CinderscapesConfig.INSTANCE.enableAshFall) {
            return;
        }

        BlockPos.MutableBlockPos pos = tickPos.mutable();
        LevelChunkSection[] sections = getChunk(tickPos).getSections();
        int sectionIndex;

        for (pos.setY(pos.getY() + 1); pos.getY() < 127; pos.setY(pos.getY() + 1)) {
            sectionIndex = SectionPos.blockToSectionCoord(pos.getY());

            if (sections[sectionIndex].hasOnlyAir() || !sections[sectionIndex].getBiomes().maybeHas(ASHY_SHOALS_PREDICATE)) {
                pos.setY(SectionPos.sectionToBlockCoord(sectionIndex + 1) - 1);
                continue;
            }

            if (canPlaceAshAt(pos) && getBiome(pos).is(CinderscapesBiomes.ASHY_SHOALS)) {
                setBlockAndUpdate(pos, CinderscapesBlocks.ASH.defaultBlockState());
                break;
            }
        }
    }

    @Unique
    private boolean canPlaceAshAt(BlockPos.MutableBlockPos pos) {
        return getBlockState(pos).isAir() &&
                blockAbove(pos).is(CinderscapesBlockTags.ASH_PERMEABLE) &&
                CinderscapesBlocks.ASH.defaultBlockState().canSurvive(this, pos);
    }

    @Unique
    private BlockState blockAbove(BlockPos.MutableBlockPos pos) {
        int originalY = pos.getY();
        BlockState stateAbove;

        //noinspection StatementWithEmptyBody
        for (; isEmptyBlock(pos) && pos.getY() < 127; pos.setY(pos.getY() + 1));

        stateAbove = getBlockState(pos);
        pos.setY(originalY);

        return stateAbove;
    }
}