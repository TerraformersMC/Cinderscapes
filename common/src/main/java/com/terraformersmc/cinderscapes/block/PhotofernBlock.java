package com.terraformersmc.cinderscapes.block;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.util.StateShapeRegistry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;

public class PhotofernBlock extends CinderscapesNetherPlantBlock implements BonemealableBlock {

	public PhotofernBlock(Properties settings) {
		super(settings);

		StateShapeRegistry.put(this, (state) -> Block.box(2.0, 0.0, 2.0, 14.0, 12.0, 14.0));
	}

	@Override
	public boolean isValidBonemealTarget(LevelReader world, BlockPos pos, BlockState state) {
		return true;
	}

	@Override
	public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState state) {
		return true;
	}

	@Override
	public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState state) {
		CinderscapesNetherTallPlantBlock tallPhotofern = (CinderscapesNetherTallPlantBlock) CinderscapesBlocks.TALL_PHOTOFERN;
		if (tallPhotofern.defaultBlockState().canSurvive(world, pos) && world.isEmptyBlock(pos.above())) {
			DoublePlantBlock.placeAt(world, tallPhotofern.defaultBlockState(), pos, 2);
		}
	}
}
