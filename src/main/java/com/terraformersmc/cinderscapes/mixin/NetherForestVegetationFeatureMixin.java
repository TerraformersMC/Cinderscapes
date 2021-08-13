package com.terraformersmc.cinderscapes.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.BlockPileFeatureConfig;
import net.minecraft.world.gen.feature.NetherForestVegetationFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Random;

@Mixin(NetherForestVegetationFeature.class)
public class NetherForestVegetationFeatureMixin {
    @Inject(method = "Lnet/minecraft/world/gen/feature/NetherForestVegetationFeature;generate(Lnet/minecraft/world/WorldAccess;Ljava/util/Random;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/world/gen/feature/BlockPileFeatureConfig;II)Z", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/world/WorldAccess;setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;I)Z"), locals = LocalCapture.CAPTURE_FAILHARD)
    private static void generate(WorldAccess world, Random random, BlockPos pos, BlockPileFeatureConfig config, int i, int j, CallbackInfoReturnable<Boolean> callback, int k, int l, int m, BlockPos blockPos, BlockState blockState2) {
        if (blockState2.getBlock() instanceof TallPlantBlock) {
            if (world.isAir(blockPos.up())) {
                world.setBlockState(blockPos.up(), blockState2.with(TallPlantBlock.HALF, DoubleBlockHalf.UPPER), 2);
            } else {
                world.setBlockState(blockPos, Blocks.AIR.getDefaultState(), 2);
            }
        }
    }
}
