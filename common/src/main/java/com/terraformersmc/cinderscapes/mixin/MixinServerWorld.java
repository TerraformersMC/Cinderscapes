package com.terraformersmc.cinderscapes.mixin;

import com.terraformersmc.cinderscapes.config.CinderscapesConfig;
import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.tag.CinderscapesBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.world.MutableWorldProperties;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.function.Supplier;

@Mixin(ServerWorld.class)
public abstract class MixinServerWorld extends World {
    protected MixinServerWorld(MutableWorldProperties properties, RegistryKey<World> registryRef, DynamicRegistryManager registryManager, RegistryEntry<DimensionType> dimensionEntry, Supplier<Profiler> profiler, boolean isClient, boolean debugWorld, long biomeAccess, int maxChainedNeighborUpdates) {
        super(properties, registryRef, registryManager, dimensionEntry, profiler, isClient, debugWorld, biomeAccess, maxChainedNeighborUpdates);
    }

    /*
     * NOTE: Unlike this mixin, vanilla evaluates the tick only at the surface Y level.
     * This means there is no utility for us in reusing vanilla's calculations.
     */
    @Inject(method="tickIceAndSnow", at = @At(value = "HEAD"), locals = LocalCapture.NO_CAPTURE)
    private void cinderscapes$tickAsh(BlockPos tickPos, CallbackInfo ci) {
        if (CinderscapesConfig.INSTANCE.enableAshFall) {
            BlockPos pos = tickPos.mutableCopy();
            BlockState state = getBlockState(pos);
            RegistryEntry<Biome> biome = this.getBiome(pos);

            while (pos.getY() < 127 && !(
                    biome.matchesKey(CinderscapesBiomes.ASHY_SHOALS) &&
                    state.isSideSolidFullSquare(this, pos, Direction.UP) &&
                    blockAbove(pos).isIn(CinderscapesBlockTags.ASH_PERMEABLE) &&
                    this.getBlockState(pos.up()).isAir() &&
                    CinderscapesBlocks.ASH.getDefaultState().canPlaceAt(this, pos.up()))) {
                pos = pos.up();
                state = getBlockState(pos);
                biome = this.getBiome(pos);
            }

            if (pos.getY() < 127) {
                this.setBlockState(pos.up(), CinderscapesBlocks.ASH.getDefaultState());
            }
        }
    }

    private BlockState blockAbove(BlockPos pos) {
        BlockPos iPos = pos.mutableCopy().up();

        //noinspection StatementWithEmptyBody
        for (; isAir(iPos) && iPos.getY() < 127; iPos = iPos.up());

        return getBlockState(iPos);
    }
}