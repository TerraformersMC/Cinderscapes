package com.terraformersmc.cinderscapes.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.NetherrackBlock;
import net.minecraft.registry.tag.BlockTags;
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
    @Inject(method = "grow", at = @At("RETURN"))
    private void cinderscapes$growNetherrackAction(ServerWorld world, Random random, BlockPos pos, BlockState state, CallbackInfo ci) {
        BlockState vanillaState = world.getBlockState(pos);
        List<BlockState> potentialStates = new ArrayList<>();

        // Build a list of the default states of any surrounding Nylium variants.
        for (BlockPos testPos : BlockPos.iterate(pos.add(-1, -1, -1), pos.add(1, 1, 1))) {
            BlockState testState = world.getBlockState(testPos).getBlock().getDefaultState();
            if (testState.isIn(BlockTags.NYLIUM) && !potentialStates.contains(testState)) {
                potentialStates.add(testState);
            }
        }

        // If another mod has changed the block state to something not a default Nylium state, leave it be.
        if (potentialStates.size() > 0 && (vanillaState.isOf(Blocks.NETHERRACK) || potentialStates.contains(vanillaState))) {
            world.setBlockState(pos, potentialStates.get(random.nextInt(potentialStates.size())), 3);
        }
    }
}
