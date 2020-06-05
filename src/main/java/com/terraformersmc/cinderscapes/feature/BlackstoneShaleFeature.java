package com.terraformersmc.cinderscapes.feature;

import com.terraformersmc.cinderscapes.util.shapelib.Quaternion;
import com.terraformersmc.cinderscapes.util.shapelib.Shape;
import com.terraformersmc.cinderscapes.util.shapelib.Shapes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Arrays;
import java.util.Random;


/**
 * [REVIEWED]
 *
 * A large scale like stone feature
 *
 * @author <Wtoll> Will Toll
 * @project Cinderscapes
 */
public class BlackstoneShaleFeature extends Feature<DefaultFeatureConfig> {

    public BlackstoneShaleFeature() {
        super(DefaultFeatureConfig.CODEC);
    }

    // TODO: Rewrite using the upcoming shapes library
    // TODO: Rewrite using the CountFloorDecorator
    @Override
    public boolean generate(ServerWorldAccess world, StructureAccessor accessor, ChunkGenerator generator, Random random, BlockPos pos, DefaultFeatureConfig config) {
        Shape shape = new Shape();
        int height = random.nextInt(4) + 4;
        int thickness = random.nextInt(1) + 1;

        shape.join(Shapes.ellipsoidSolidRoatated(height, 0.75f * height, thickness, new Quaternion(random.nextFloat() * 30 + 90, random.nextFloat() * 360, 0, true)));

        System.out.println();
        shape.translateBy(pos).translateDown(2).fill(Blocks.BLUE_CONCRETE.getDefaultState(), world);

        return true;
    }
}
