package com.terraformersmc.cinderscapes.decorator;

import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CountCeilingDecorator extends Decorator<CountDecoratorConfig> {
    public CountCeilingDecorator(Function<Dynamic<?>, ? extends CountDecoratorConfig> configDeserializer) {
        super(configDeserializer);
    }

    @Override
    public Stream<BlockPos> getPositions(IWorld world, ChunkGenerator<? extends ChunkGeneratorConfig> generator, Random random, CountDecoratorConfig config, BlockPos pos) {
        //TODO: optimize this using a mutable. it's a basic implementation and can be made faster.
        return IntStream.range(0, config.count).mapToObj((i) -> {
            //randomize x and z
            int x = random.nextInt(16) + pos.getX();
            int z = random.nextInt(16) + pos.getZ();

            List<BlockPos> positions = new ArrayList<>();

            //iterate downwards and grab all of the positions with a solid block above.
            for (int y = 127; y > 30; y--) {
                if (world.getBlockState(new BlockPos(x, y + 1, z)).isOpaque()) {

                    if (world.getBlockState(new BlockPos(x, y, z)).isAir()) {
                        positions.add(new BlockPos(x, y, z));
                    }
                }
            }

            if (positions.size() == 0) {
                return new BlockPos(x, 0, z);
            }

            return positions.get(random.nextInt(positions.size()));
        });
    }
}
