package com.terraformersmc.cinderscapes.mixin;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.VegetationBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VegetationBlock.class)
public class MixinVegetationBlock {
    @Inject(method = "mayPlaceOn", at = @At(value = "RETURN"), cancellable = true)
    protected void cinderscapes$canPlantOnTop(BlockState floor, BlockGetter level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (floor.is(CinderscapesBlocks.NODZOL)) {
            cir.setReturnValue(true);
        }
    }
}
