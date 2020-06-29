package com.terraformersmc.cinderscapes.mixin;


import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.terraformersmc.cinderscapes.client.GlStateManagerHelper;
import com.terraformersmc.cinderscapes.mixinterface.FogDensityBiome;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * [APPROVED AS OF 1.1.0]
 */
@Mixin(BackgroundRenderer.class)
public class BackgroundRendererMixin {

    /**
     * A mixin that overrides the default fog rendering functionality
     * @param camera The camera that the fog is being rendered to
     * @param fogType The fog type
     * @param viewDistance The player configurable view distance
     * @param thickFog
     * @param callback The callback for the mixin
     */
    @Inject(method = "Lnet/minecraft/client/render/BackgroundRenderer;applyFog(Lnet/minecraft/client/render/Camera;Lnet/minecraft/client/render/BackgroundRenderer$FogType;FZ)V", at = @At("HEAD"), cancellable = true)
    private static void applyFog(Camera camera, BackgroundRenderer.FogType fogType, float viewDistance, boolean thickFog, CallbackInfo callback) {

        BlockPos pos = camera.getBlockPos();
        FluidState fluidState = camera.getSubmergedFluidState();
        Entity entity = camera.getFocusedEntity();
        World world = entity.getEntityWorld();

        float density = 1.0f;

        // If the biome that the entity is in wants to override the fog density
        Biome biome = world.getBiome(pos);
        if (biome instanceof FogDensityBiome) {
            // Set the density to that biome's desired density
            density = ((FogDensityBiome) biome).fogMultiplier();
        }

        // If the entity is not inside of a fluid
        if (fluidState.getFluid() == Fluids.EMPTY) {
            // If the entity doesn't have the blindness effect
            if (!(entity instanceof LivingEntity && ((LivingEntity) entity).hasStatusEffect(StatusEffects.BLINDNESS))) {
                // At this point the entity is guaranteed to be existing in normal circumstances so we are safe to override the normal fog
                float start = viewDistance * 0.05F * density;
                float end = Math.min(viewDistance, 192.0F) * 0.5F * density;

                float oldStart = GlStateManagerHelper.getFogStart();
                float oldEnd = GlStateManagerHelper.getFogEnd();

                RenderSystem.fogStart(oldStart + (start - oldStart) * 0.025f);
                RenderSystem.fogEnd(oldEnd + (end - oldEnd) * 0.025f);

                RenderSystem.fogMode(GlStateManager.FogMode.LINEAR);
                RenderSystem.setupNvFogDistance();

                callback.cancel();
            }
        }
    }
}
