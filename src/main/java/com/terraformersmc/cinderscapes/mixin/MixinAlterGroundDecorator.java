package com.terraformersmc.cinderscapes.mixin;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.treedecorators.AlterGroundDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(AlterGroundDecorator.class)
public class MixinAlterGroundDecorator {
    @Inject(method = "placeBlockAt",
            at = @At(
                    value = "INVOKE_ASSIGN",
                    target = "Lnet/minecraft/core/BlockPos;above(I)Lnet/minecraft/core/BlockPos;",
                    shift = At.Shift.AFTER
            ),
            cancellable = true,
            locals = LocalCapture.CAPTURE_FAILHARD
    )
    private void cinderscapes$netherrackConversion(TreeDecorator.Context generator, BlockPos origin, CallbackInfo ci, int i, BlockPos pos) {
        if (generator.level().isStateAtPosition(pos, (state) -> state.is(Blocks.NETHERRACK))) {
            generator.setBlock(pos, CinderscapesBlocks.NODZOL.defaultBlockState());
            ci.cancel();
        }
    }
}
