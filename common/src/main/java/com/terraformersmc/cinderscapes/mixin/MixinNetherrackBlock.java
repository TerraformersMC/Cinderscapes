package com.terraformersmc.cinderscapes.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.NetherrackBlock;
import net.minecraft.block.NyliumBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(NetherrackBlock.class)
public class MixinNetherrackBlock {
    @Inject(method = "grow(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/random/Random;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)V", at = @At("HEAD"), cancellable = true)
    public void cinderscapes$grow(ServerWorld world, Random random, BlockPos pos, BlockState state, CallbackInfo callback) {

        List<BlockState> potentialStates = new ArrayList<>();

        for (BlockPos testPos : BlockPos.iterate(pos.add(-1, -1, -1), pos.add(1, 1, 1))) {
            BlockState testState = world.getBlockState(testPos);
            if (testState.getBlock() instanceof NyliumBlock && !potentialStates.contains(testState)) potentialStates.add(testState);
        }
        if (potentialStates.size() > 0) {
            world.setBlockState(pos, potentialStates.get(random.nextInt(potentialStates.size())), 3);
        }

        callback.cancel();
    }
}
