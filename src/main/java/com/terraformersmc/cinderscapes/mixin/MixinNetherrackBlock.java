package com.terraformersmc.cinderscapes.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.NetherrackBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(NetherrackBlock.class)
public class MixinNetherrackBlock {
    @Inject(method = "performBonemeal", at = @At("RETURN"))
    private void cinderscapes$growNetherrackAction(ServerLevel world, RandomSource random, BlockPos pos, BlockState state, CallbackInfo ci) {
        BlockState vanillaState = world.getBlockState(pos);
        List<BlockState> potentialStates = new ArrayList<>();

        // Build a list of the default states of any surrounding Nylium variants.
        for (BlockPos testPos : BlockPos.betweenClosed(pos.offset(-1, -1, -1), pos.offset(1, 1, 1))) {
            BlockState testState = world.getBlockState(testPos).getBlock().defaultBlockState();
            if (testState.is(BlockTags.NYLIUM) && !potentialStates.contains(testState)) {
                potentialStates.add(testState);
            }
        }

        // If another mod has changed the block state to something not a default Nylium state, leave it be.
        if (potentialStates.size() > 0 && (vanillaState.is(Blocks.NETHERRACK) || potentialStates.contains(vanillaState))) {
            world.setBlock(pos, potentialStates.get(random.nextInt(potentialStates.size())), 3);
        }
    }
}
