package com.terraformersmc.cinderscapes.feature;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.terraform.shapes.api.Position;
import com.terraformersmc.terraform.shapes.api.Quaternion;
import com.terraformersmc.terraform.shapes.api.Shape;
import com.terraformersmc.terraform.shapes.impl.filler.SimpleFiller;
import com.terraformersmc.terraform.shapes.impl.layer.pathfinder.AddLayer;
import com.terraformersmc.terraform.shapes.impl.layer.transform.RotateLayer;
import com.terraformersmc.terraform.shapes.impl.layer.transform.TranslateLayer;
import com.terraformersmc.terraform.shapes.impl.validator.SafelistValidator;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

public class FloorIvoryTuskFeature extends CeilingIvoryTuskFeature {
	public FloorIvoryTuskFeature() {
	}

	@Override
	public boolean generate(StructureWorldAccess world, ChunkGenerator chunkGenerator, Random random, BlockPos pos,
			DefaultFeatureConfig config) {

		List<BlockState> WHITELIST = Arrays.asList(CinderscapesBlocks.IVORY_BLOCK.getDefaultState(),
				Blocks.AIR.getDefaultState());

		Shape shape = Shape.of((point) -> false, Position.of(0, 0, 0), Position.of(0, 0, 0));

		boolean longTusk = random.nextBoolean();

		float width = random.nextInt(3) + 2;
		float length = random.nextInt(3) + 2;
		float degrees = random.nextFloat() * 360;

		if (longTusk) {
			length = length + random.nextInt(15);
			boolean thiccTusk = random.nextBoolean();
			if (thiccTusk) {
				length = length + random.nextInt(10);
				width = width + random.nextInt(10);
			}
		}

		float height = random.nextBoolean() ? width - random.nextInt(2) : width + random.nextInt(2);

		int ivory_marrow_axis = random.nextInt(2);

		BlockState ivory_marrow = ivory_marrow_axis == 0
				? CinderscapesBlocks.IVORY_MARROW_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.X)
				: ivory_marrow_axis == 1
						? CinderscapesBlocks.IVORY_MARROW_BLOCK.getDefaultState().with(PillarBlock.AXIS,
								Direction.Axis.Y)
						: CinderscapesBlocks.IVORY_MARROW_BLOCK.getDefaultState().with(PillarBlock.AXIS,
								Direction.Axis.Z);

		shape = shape.applyLayer(new AddLayer(
				bentCone(width, height, length, degrees).applyLayer(new RotateLayer(Quaternion.of(1, 0, 0, 0)))));

		shape.applyLayer(new TranslateLayer(Position.of(pos))).applyLayer(new TranslateLayer(Position.of(0, -2, 0)))
				.validate(new SafelistValidator(world, WHITELIST), (validShape) -> {
					validShape.fill(new SimpleFiller(world, ivory_marrow));
				});

		for (int w = (int) -width; w < width; w++) {
			for (int h = (int) -height; h < height; h++) {
				for (int l = (int) -length; l < length; l++) {

					pos = pos.add(w, h, l);

					BlockState new_ivory_marrow = CinderscapesBlocks.IVORY_MARROW_BLOCK.getDefaultState();

					switch (random.nextInt(2)) {
					case 0:
						new_ivory_marrow = new_ivory_marrow.with(PillarBlock.AXIS, Direction.Axis.X);
						break;
					case 1:
						new_ivory_marrow = new_ivory_marrow.with(PillarBlock.AXIS, Direction.Axis.Y);
						break;
					case 2:
						new_ivory_marrow = new_ivory_marrow.with(PillarBlock.AXIS, Direction.Axis.Z);
						break;
					}

					if (world.getBlockState(pos).isOf(CinderscapesBlocks.IVORY_MARROW_BLOCK)) {
						world.setBlockState(pos, new_ivory_marrow, 2);
					}

					pos = pos.add(-w, -h, -l);

				}
			}
		}

		return true;
	}
}
