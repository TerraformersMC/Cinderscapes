package com.terraformersmc.cinderscapes.client;

import com.mojang.blaze3d.systems.RenderSystem;
import org.lwjgl.opengl.GL11;

/**
 * @author <Wtoll> Will Toll on 2020-06-29
 * @project cinderscapes
 */
public class GlStateManagerHelper {
    public static float getFogStart() {
        RenderSystem.assertThread(RenderSystem::isOnRenderThread);
        return GL11.glGetFloat(GL11.GL_FOG_START);
    }

    public static float getFogEnd() {
        RenderSystem.assertThread(RenderSystem::isOnRenderThread);
        return GL11.glGetFloat(GL11.GL_FOG_END);
    }
}
