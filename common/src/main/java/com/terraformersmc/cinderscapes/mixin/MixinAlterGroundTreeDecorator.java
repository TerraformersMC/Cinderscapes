package com.terraformersmc.cinderscapes.mixin;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.treedecorator.AlterGroundTreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(AlterGroundTreeDecorator.class)
public class MixinAlterGroundTreeDecorator {
    @Inject(method = "setColumn",
            at = @At(
                    value = "INVOKE_ASSIGN",
                    target = "Lnet/minecraft/util/math/BlockPos;up(I)Lnet/minecraft/util/math/BlockPos;",
                    shift = At.Shift.AFTER
            ),
            cancellable = true,
            locals = LocalCapture.CAPTURE_FAILHARD
    )
    private void cinderscapes$netherrackConversion(TreeDecorator.Generator generator, BlockPos origin, CallbackInfo ci, int i, BlockPos pos) {
        if (generator.getWorld().testBlockState(pos, (state) -> state.isOf(Blocks.NETHERRACK))) {
            generator.replace(pos, CinderscapesBlocks.NODZOL.getDefaultState());
            ci.cancel();
        }
    }
}
