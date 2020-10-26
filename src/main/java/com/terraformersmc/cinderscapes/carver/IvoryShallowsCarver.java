package com.terraformersmc.cinderscapes.carver;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.carver.NetherCaveCarver;

public class IvoryShallowsCarver extends NetherCaveCarver {
	
   public IvoryShallowsCarver(Codec<ProbabilityConfig> codec) {
      super(codec);
   }

   @Override
   protected int getMaxCaveCount() {
      return 35;
   }

   @Override
   protected float getTunnelSystemWidth(Random random) {
      return (random.nextFloat() * 2.5F + random.nextFloat()) * 2.5F;
   }

   @Override
   protected double getTunnelSystemHeightWidthRatio() {
      return 8.5D;
   }

}
