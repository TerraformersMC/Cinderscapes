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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class CeilingIvoryTuskFeature extends Feature<DefaultFeatureConfig> {
	public CeilingIvoryTuskFeature() {
		super(DefaultFeatureConfig.CODEC);
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
		float arc = MathHelper.clamp((random.nextFloat() * 360) + 10, 15, 300);
		float rotation = random.nextFloat() * 360;

		if (longTusk) {
			length = length + random.nextInt(15);
			boolean thiccTusk = random.nextBoolean();
			if (thiccTusk) {
				length = length + random.nextInt(10);
				width = width + random.nextInt(10);
			}
		}

		float height = random.nextBoolean() ? width - random.nextInt(2) : width + random.nextInt(2);

		shape = shape.applyLayer(new AddLayer(bentCone(width, height, length, arc).applyLayer(new RotateLayer(Quaternion.of(0, rotation, 0, true)))));

		shape.applyLayer(new RotateLayer(Quaternion.of(0, 0, 0, 1))).applyLayer(new TranslateLayer(Position.of(pos)))
				.applyLayer(new TranslateLayer(Position.of(0, 2, 0)))
				.validate(new SafelistValidator(world, WHITELIST), (validShape) -> {
					validShape.fill(new SimpleFiller(world, CinderscapesBlocks.IVORY_BLOCK.getDefaultState()));
				});

		return true;
	}

	public static Shape bentCone(float a, float b, float length, float degrees) {
		return Shape.of((pos) -> {
			double dist = Math.sqrt(pos.getX() * pos.getX() + pos.getY() + pos.getY() + pos.getZ() + pos.getZ());
			pos = pos.rotateBy(Quaternion.of(0, 0, degrees * (dist / length), true));
			return pos.getX() * pos.getX() / (a * (1.0D - pos.getY() / length) * a * (1.0D - pos.getY() / length))
					+ pos.getZ() * pos.getZ()
							/ (b * (1.0D - pos.getY() / length) * b * (1.0D - pos.getY() / length)) < 1.0D
					&& pos.getY() > 0.0D && pos.getY() < length;
		}, Position.of(-length, -length, -length), Position.of(length, length, length));
	}
}
