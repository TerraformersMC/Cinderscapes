package com.terraformersmc.cinderscapes.mixin;

import com.google.common.base.Suppliers;
import com.llamalad7.mixinextras.sugar.Local;
import com.terraformersmc.cinderscapes.config.CinderscapesConfig;
import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.tag.CinderscapesBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.SectionPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.storage.WritableLevelData;
import org.jspecify.annotations.NullMarked;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Predicate;
import java.util.function.Supplier;

@NullMarked
@Mixin(ServerLevel.class)
public abstract class MixinServerLevel extends Level {
    @Shadow
    public abstract ServerChunkCache getChunkSource();

    @Unique
    private static final Predicate<Holder<Biome>> ASHY_SHOALS_PREDICATE =
            biome -> biome.is(CinderscapesBiomes.ASHY_SHOALS);

    // This is a cached check whether a given ServerLevel can possibly contain the Ashy Shoals biome.
    // We memoize to delay evaluation until after modded biome registration.
    @Unique
    private final Supplier<Boolean> hasAshyShoals = Suppliers.memoize(() ->
            this.getChunkSource().getGenerator().getBiomeSource().possibleBiomes().stream().anyMatch(ASHY_SHOALS_PREDICATE));

    protected MixinServerLevel(WritableLevelData properties, ResourceKey<Level> registryRef, RegistryAccess registryManager, Holder<DimensionType> dimensionEntry, boolean isClient, boolean debugWorld, long biomeAccess, int maxChainedNeighborUpdates) {
        super(properties, registryRef, registryManager, dimensionEntry, isClient, debugWorld, biomeAccess, maxChainedNeighborUpdates);
    }

    /*
     * NOTE: Unlike this mixin, vanilla evaluates the tick only at the surface Y level.
     * This means there is no utility for us in reusing vanilla's calculations.
     */
    @Inject(method = "tickPrecipitation",
            at = @At(
                    value = "INVOKE_ASSIGN",
                    target = "Lnet/minecraft/server/level/ServerLevel;getBiome(Lnet/minecraft/core/BlockPos;)Lnet/minecraft/core/Holder;",
                    ordinal = 0
            )
    )
    @SuppressWarnings("LocalMayBeArgsOnly")
    private void cinderscapes$tickAsh(BlockPos tickPos, CallbackInfo ci, @Local(name = "topPos") BlockPos topPos) {
        if (!(hasAshyShoals.get() && CinderscapesConfig.INSTANCE.enableAshFall)) {
            return;
        }

        ChunkAccess chunk = this.getChunk(tickPos);
        LevelChunkSection[] sections = chunk.getSections();
        int maxY = Math.min(topPos.getY() + 1, chunk.getMaxY());

        BlockPos.MutableBlockPos pos = tickPos.mutable();
        int sectionIndex;

        for (pos.setY(pos.getY() + 1); pos.getY() < maxY; pos.setY(pos.getY() + 1)) {
            sectionIndex = SectionPos.blockToSectionCoord(pos.getY());

            if (sections[sectionIndex].hasOnlyAir() || !sections[sectionIndex].getBiomes().maybeHas(ASHY_SHOALS_PREDICATE)) {
                pos.setY(SectionPos.sectionToBlockCoord(sectionIndex + 1) - 1);
                continue;
            }

            if (this.canPlaceAshAt(pos, maxY) && this.getBiome(pos).is(CinderscapesBiomes.ASHY_SHOALS)) {
                this.setBlockAndUpdate(pos, CinderscapesBlocks.ASH.defaultBlockState());
                break;
            }
        }
    }

    @Unique
    private boolean canPlaceAshAt(BlockPos.MutableBlockPos pos, int maxY) {
        return this.getBlockState(pos).isAir() &&
                this.blockAbove(pos, maxY).is(CinderscapesBlockTags.ASH_PERMEABLE) &&
                CinderscapesBlocks.ASH.defaultBlockState().canSurvive(this, pos);
    }

    @Unique
    private BlockState blockAbove(BlockPos.MutableBlockPos pos, int maxY) {
        int originalY = pos.getY();
        BlockState stateAbove;

        //noinspection StatementWithEmptyBody
        for (; this.isEmptyBlock(pos) && pos.getY() <= maxY; pos.setY(pos.getY() + 1));

        stateAbove = this.getBlockState(pos);
        pos.setY(originalY);

        return stateAbove;
    }
}