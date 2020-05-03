package com.terraformersmc.cinderscapes.util;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Quaternion;
import net.minecraft.world.IWorld;
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class Shapes {
    public static void drawLine(IWorld world, BlockState state, BlockPos to, BlockPos from) {
        int dx = to.getX() - from.getX();
        int dy = to.getY() - from.getY();
        int dz = to.getZ() - from.getZ();
        int dt = Math.max(Math.max(Math.abs(dx), Math.abs(dy)), Math.abs(dz));

        for (int t = 0; t < dt; t++) {
            BlockPos pos = new BlockPos( from.getX() + ((float)dx/dt)*t, from.getY() + ((float)dy/dt)*t, from.getZ() + ((float)dz/dt)*t );
            world.setBlockState(pos, state, 0);
        }
    }


}
