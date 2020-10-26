package com.terraformersmc.cinderscapes.feature;

import java.util.Random;

import com.terraformersmc.cinderscapes.block.IvoryTeethBlock;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class IvoryToothFeature extends Feature<DefaultFeatureConfig> {
   public IvoryToothFeature() {
      super(DefaultFeatureConfig.CODEC);
   }

   public boolean generate(StructureWorldAccess structureWorldAccess, ChunkGenerator chunkGenerator, Random random, BlockPos blockPos, DefaultFeatureConfig defaultFeatureConfig) {
      return generateVines(structureWorldAccess, random, blockPos, 8, 4, 8);
   }

   public static boolean generateVines(WorldAccess worldAccess, Random random, BlockPos blockPos, int i, int j, int k) {
      if (isNotSuitable(worldAccess, blockPos)) {
         return false;
      } else {
         generateVinesInArea(worldAccess, random, blockPos, i, j, k);
         return true;
      }
   }

   private static void generateVinesInArea(WorldAccess worldAccess, Random random, BlockPos blockPos, int i, int j, int k) {
      BlockPos.Mutable mutable = new BlockPos.Mutable();

      for(int l = 0; l < i * i; ++l) {
         mutable.set(blockPos).move(MathHelper.nextInt(random, -i, i), MathHelper.nextInt(random, -j, j), MathHelper.nextInt(random, -i, i));
         if (method_27220(worldAccess, mutable) && !isNotSuitable(worldAccess, mutable)) {
            int m = MathHelper.nextInt(random, 1, k);
            if (random.nextInt(6) == 0) {
               m *= 2;
            }

            if (random.nextInt(5) == 0) {
               m = 1;
            }

            generateVineColumn(worldAccess, random, mutable, m);
         }
      }

   }

   private static boolean method_27220(WorldAccess worldAccess, BlockPos.Mutable mutable) {
      do {
         mutable.move(0, -1, 0);
         if (World.isHeightInvalid(mutable)) {
            return false;
         }
      } while(worldAccess.getBlockState(mutable).isAir());

      mutable.move(0, 1, 0);
      return true;
   }

   public static void generateVineColumn(WorldAccess world, Random random, BlockPos.Mutable pos, int maxLength) {
      for(int i = 1; i <= maxLength; ++i) {
         if (world.isAir(pos)) {
            if (i == maxLength || !world.isAir(pos.up())) {
               world.setBlockState(pos, CinderscapesBlocks.IVORY_TEETH.getDefaultState().with(IvoryTeethBlock.TYPE, IvoryTeethBlock.Type.TOP), 2);
               break;
            }
            if (world.getBlockState(pos.down()).isOf(CinderscapesBlocks.IVORY_TEETH)) {
                world.setBlockState(pos, CinderscapesBlocks.IVORY_TEETH.getDefaultState().with(IvoryTeethBlock.TYPE, IvoryTeethBlock.Type.MIDDLE), 2);
            } else {
                world.setBlockState(pos, CinderscapesBlocks.IVORY_TEETH.getDefaultState().with(IvoryTeethBlock.TYPE, IvoryTeethBlock.Type.BOTTOM), 2);
            }
         }
         pos.move(Direction.UP);
      }

   }

   private static boolean isNotSuitable(WorldAccess worldAccess, BlockPos blockPos) {
      if (!worldAccess.isAir(blockPos)) {
         return true;
      } else {
         BlockState blockState = worldAccess.getBlockState(blockPos.down());
         return !blockState.isOf(CinderscapesBlocks.IVORY_MARROW_BLOCK) && !blockState.isOf(CinderscapesBlocks.IVORY_BLOCK);
      }
   }
}
