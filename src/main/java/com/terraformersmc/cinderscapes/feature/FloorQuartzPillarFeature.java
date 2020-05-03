package com.terraformersmc.cinderscapes.feature;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import com.terraformersmc.terraform.util.Shapes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

//TODO: Rewrite using the upcoming shapes library
public class FloorQuartzPillarFeature extends QuartzPillarFeature {
	public FloorQuartzPillarFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> configDeserializer) {
		super(configDeserializer);
	}

	@Override
	public boolean generate(IWorld world, StructureAccessor accessor, ChunkGenerator<? extends ChunkGeneratorConfig> generator, Random random, BlockPos pos, DefaultFeatureConfig config) {
		int height = random.nextInt(8) + 14;

		BlockPos.Mutable origin = pos.mutableCopy();
		double maxRadius = 1; //this can vary if you want it to
		for (int i = 0; i < height; i++) {
			Shapes.circle(origin.mutableCopy(), maxRadius * radius(i / (float) height), position -> setIfAir(world, position));
			origin.move(Direction.UP);
			//and other offset stuff for angles if you want
		}

		return true;
	}
}
