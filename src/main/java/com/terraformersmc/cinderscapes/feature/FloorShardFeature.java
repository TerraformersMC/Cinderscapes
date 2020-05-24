package com.terraformersmc.cinderscapes.feature;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import com.terraformersmc.cinderscapes.feature.config.ShardFeatureConfig;
import com.terraformersmc.cinderscapes.util.shapelib.Quaternion;
import com.terraformersmc.cinderscapes.util.shapelib.Shape;
import com.terraformersmc.cinderscapes.util.shapelib.Shapes;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

//TODO: Rewrite using the upcoming shapes library
public class FloorShardFeature extends CeilingShardFeature {
	public FloorShardFeature(Function<Dynamic<?>, ? extends ShardFeatureConfig> configDeserializer) {
		super(configDeserializer);
	}

	@Override
	public boolean generate(IWorld world, StructureAccessor accessor, ChunkGenerator<? extends ChunkGeneratorConfig> generator, Random random, BlockPos pos, ShardFeatureConfig config) {
		int amount = random.nextInt(3) + 2;
		Shape shape = new Shape();
		for (int i = 0; i < amount; i++) {
			int height = random.nextInt(8) + 14;
			float radius = random.nextFloat() * 2 + 2;
			float ztheta = (random.nextFloat() * 30) + 15;
			float ytheta = random.nextFloat() * 360;
			shape.join(Shapes.coneSolidRotated(radius, height, new Quaternion(0, ytheta, ztheta, true)));
		}
		shape.translateBy(pos).translateDown(2).fillIfSafeWhitelist(config.shardMaterial, world, config.groundMaterials);
		return true;
	}
}
