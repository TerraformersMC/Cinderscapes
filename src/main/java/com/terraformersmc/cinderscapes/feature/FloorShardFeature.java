package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.feature.config.SimpleStateFeatureConfig;
import com.terraformersmc.cinderscapes.util.shapelib.Quaternion;
import com.terraformersmc.cinderscapes.util.shapelib.Shape;
import com.terraformersmc.cinderscapes.util.shapelib.Shapes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;

import java.util.Random;

//TODO: Rewrite using the upcoming shapes library
public class FloorShardFeature extends CeilingShardFeature {
	public FloorShardFeature() {
	}

	@Override
	public boolean generate(StructureWorldAccess world, ChunkGenerator generator, Random random, BlockPos pos, SimpleStateFeatureConfig config) {
		int amount = random.nextInt(3) + 2;
		Shape shape = new Shape();
		for (int i = 0; i < amount; i++) {
			int height = random.nextInt(8) + 14;
			float radius = random.nextFloat() * 2 + 2;
			float ztheta = (random.nextFloat() * 30) + 15;
			float ytheta = random.nextFloat() * 360;
			shape.join(Shapes.coneSolidRotated(radius, height, new Quaternion(0, ytheta, ztheta, true)));
		}
		shape.translateBy(pos).translateDown(2).fillIfSafeWhitelist(config.state, world, config.replaceableBlocks);
		return true;
	}
}
