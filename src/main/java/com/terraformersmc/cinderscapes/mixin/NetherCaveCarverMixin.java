package com.terraformersmc.cinderscapes.mixin;

import com.mojang.serialization.Codec;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.carver.CaveCarver;
import net.minecraft.world.gen.carver.NetherCaveCarver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashSet;

@Mixin(NetherCaveCarver.class)
public abstract class NetherCaveCarverMixin extends CaveCarver {

    public NetherCaveCarverMixin(Codec<ProbabilityConfig> codec, int i) {
        super(codec, i);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    public void constructor(CallbackInfo callback) {
        this.alwaysCarvableBlocks = new HashSet<>(this.alwaysCarvableBlocks);
        this.alwaysCarvableBlocks.add(CinderscapesBlocks.UMBRAL_NYLIUM);
    }
}
