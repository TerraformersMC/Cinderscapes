package com.terraformersmc.cinderscapes.mixin;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.config.CinderscapesConfig;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.world.attribute.AmbientParticle;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(AmbientParticle.class)
public class MixinAmbientParticle {
    @Shadow
    @Mutable
    @Final
    private float probability;

    @Unique
    private static final float ASH_PARTICLE_LIMIT = 0.125f;

    @Inject(method = "<init>", at = @At("TAIL"), locals = LocalCapture.NO_CAPTURE)
    private void cinderscapes$configurableAshParticle(ParticleEffect particle, float probability, CallbackInfo ci) {
        if (CinderscapesConfig.INSTANCE.limitAshParticles && probability > ASH_PARTICLE_LIMIT) {
            Cinderscapes.LOGGER.info("Limiting ash particle probability from {} to {}", probability, ASH_PARTICLE_LIMIT);

            this.probability = ASH_PARTICLE_LIMIT;
        }
    }
}
