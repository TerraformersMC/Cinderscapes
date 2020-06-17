package com.terraformersmc.cinderscapes.decorator;

import com.terraformersmc.cinderscapes.decorator.config.UberCountDecoratorConfig;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.decorator.Decorator;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author <Wtoll> Will Toll on 2020-06-16
 * @project Cinderscapes
 */
public class UberCountDecorator extends Decorator<UberCountDecoratorConfig> {
    public UberCountDecorator() {
        super(UberCountDecoratorConfig.CODEC);
    }

    @Override
    public Stream<BlockPos> getPositions(WorldAccess world, ChunkGenerator generator, Random random, UberCountDecoratorConfig config, BlockPos pos) {
        List<BlockPos> potentialPosition = BlockPos.stream(pos.getX(), config.bottomOffset, pos.getZ(), pos.getX() + 16, (config.maximum - config.topOffset), pos.getZ() + 16).filter((testPos) -> {
            return testStream(testPos, config.offset, config.radius).allMatch((offsetPos) -> {
                return world.isAir(offsetPos) || config.replaceableList.stream().anyMatch((state) -> state.equals(world.getBlockState(offsetPos)));
            }) && offsetStream(testPos, config.offset, config.radius).allMatch((offsetPos) -> {
                return config.placeableList.stream().anyMatch((state) -> state.equals(world.getBlockState(offsetPos)));
            });
        }).collect(Collectors.toList());
        return potentialPosition.size() > 0 ? IntStream.range(0, config.count).mapToObj((i) -> {
            return potentialPosition.get(random.nextInt(potentialPosition.size()));
        }) : Stream.empty();
    }

    private Stream<BlockPos> offsetStream(BlockPos pos, Direction direction, int radius) {
        return BlockPos.stream(
                pos.add(new BlockPos(direction.getOffsetX() == 0 ? -radius : direction.getOffsetX(), direction.getOffsetY() == 0 ? -radius : direction.getOffsetY(), direction.getOffsetZ() == 0 ? -radius : direction.getOffsetZ())),
                pos.add(new BlockPos(direction.getOffsetX() == 0 ? radius : direction.getOffsetX(), direction.getOffsetY() == 0 ? radius : direction.getOffsetY(), direction.getOffsetZ() == 0 ? radius : direction.getOffsetZ()))
        );
    }

    private Stream<BlockPos> testStream(BlockPos pos, Direction direction, int radius) {
        return BlockPos.stream(
                pos.add(new BlockPos(direction.getOffsetX() == 0 ? -radius : 0, direction.getOffsetY() == 0 ? -radius : 0, direction.getOffsetZ() == 0 ? -radius : 0)),
                pos.add(new BlockPos(direction.getOffsetX() == 0 ? radius : 0, direction.getOffsetY() == 0 ? radius : 0, direction.getOffsetZ() == 0 ? radius : 0))
        );
    }
}
