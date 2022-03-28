package com.terraformersmc.cinderscapes.mixin;

import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(MaterialRules.MaterialRuleContext.class)
public interface MaterialRuleContextAccessor {

    @Accessor
    Chunk getChunk();
}
