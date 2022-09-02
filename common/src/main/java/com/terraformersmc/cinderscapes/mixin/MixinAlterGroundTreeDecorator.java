package com.terraformersmc.cinderscapes.mixin;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.AlterGroundTreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AlterGroundTreeDecorator.class)
public class MixinAlterGroundTreeDecorator {

    @Inject(method = "setColumn", at = @At(value = "TAIL"))
    private void cinderscapes$setColumn(TreeDecorator.Generator generator, BlockPos origin, CallbackInfo callback) {
        for(int i = 2; i >= -3; --i) {
            BlockPos blockPos = origin.up(i);
            if (generator.getWorld().testBlockState(blockPos, (state) -> state.isOf(Blocks.NETHERRACK))) {
                generator.replace(blockPos, CinderscapesBlocks.NODZOL.getDefaultState());
                break;
            }

            if (!generator.isAir(blockPos) && i < 0) {
                break;
            }
        }
    }
}
