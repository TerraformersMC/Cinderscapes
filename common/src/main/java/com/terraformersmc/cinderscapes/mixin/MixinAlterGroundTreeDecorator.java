package com.terraformersmc.cinderscapes.mixin;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.AlterGroundTreeDecorator;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;
import java.util.function.BiConsumer;

@Mixin(AlterGroundTreeDecorator.class)
public class MixinAlterGroundTreeDecorator {

    @Shadow
    @Final
    private BlockStateProvider provider;

    @Inject(method = "setColumn", at = @At(value = "TAIL"))
    private void cinderscapes$setColumn(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, BlockPos pos, CallbackInfo callback) {
        for(int i = 2; i >= -3; --i) {
            BlockPos blockPos = pos.up(i);
            if (world.testBlockState(blockPos, (state) -> state.isOf(Blocks.NETHERRACK))) {
                replacer.accept(blockPos, CinderscapesBlocks.NODZOL.getDefaultState());
                break;
            }

            if (!Feature.isAir(world, blockPos) && i < 0) {
                break;
            }
        }
    }
}
