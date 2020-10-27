package com.terraformersmc.cinderscapes.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.NetherrackBlock;
import net.minecraft.block.NyliumBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Mixin(NetherrackBlock.class)
public class NetherrackBlockMixin {
    @Inject(method = "Lnet/minecraft/block/NetherrackBlock;grow(Lnet/minecraft/server/world/ServerWorld;Ljava/util/Random;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)V", at = @At("HEAD"), cancellable = true)
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state, CallbackInfo callback) {

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
