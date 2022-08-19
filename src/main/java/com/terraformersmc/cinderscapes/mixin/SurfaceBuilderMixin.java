package com.terraformersmc.cinderscapes.mixin;

import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeAccess;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.HeightContext;
import net.minecraft.world.gen.chunk.BlockColumn;
import net.minecraft.world.gen.chunk.ChunkNoiseSampler;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(SurfaceBuilder.class)
public class SurfaceBuilderMixin {
    @Final
    @Shadow
    private BlockState defaultState;

    @Inject(method = "buildSurface", at = @At(value = "INVOKE", target = "Lnet/minecraft/fluid/FluidState;isEmpty()Z", shift = At.Shift.BY, by = 2), locals = LocalCapture.CAPTURE_FAILHARD)
    private void cinderscapes$injectFluidCheck(BiomeAccess biomeAccess, Registry<Biome> biomeRegistry, boolean useLegacyRandom, HeightContext context, Chunk chunk, ChunkNoiseSampler chunkNoiseSampler, MaterialRules.MaterialRule surfaceRule, CallbackInfo ci,
                                               BlockPos.Mutable mutable, ChunkPos chunkPos, int i, int j, BlockColumn blockColumn, MaterialRules.MaterialRuleContext materialRuleContext, MaterialRules.BlockStateRule blockStateRule, BlockPos.Mutable mutable2,
                                               int k, int l, int x, int z, int o, RegistryEntry<Biome> registryEntry, int p, int q, int r, int s, int t, int y, BlockState blockState){
        if (registryEntry.matchesKey(CinderscapesBiomes.ASHY_SHOALS)){
            if (biomeAccess.getBiome(new BlockPos(x, y, z)).matchesKey(CinderscapesBiomes.ASHY_SHOALS)){
                if (r == Integer.MIN_VALUE){
                    r = y + 1;
                }
                if (y < 30) return;
                BlockState blockState2;
                int v;
                v = y - s + 1;
                materialRuleContext.initVerticalContext(++q, v, r, x, y, z);
                if (blockState != this.defaultState && blockState != Blocks.LAVA.getDefaultState()) return;
                blockState2 = blockStateRule.tryApply(x, y, z);
                if (blockState2 == null || blockState2.getBlock() != Blocks.MAGMA_BLOCK) return;
                blockColumn.setState(y, blockState2);
                //Cinderscapes.LOGGER.info("Successfully injected inside fluid not empty if loop");
            }

        }

    }
}
