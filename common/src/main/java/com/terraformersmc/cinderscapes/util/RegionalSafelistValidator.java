package com.terraformersmc.cinderscapes.util;

import com.terraformersmc.terraform.shapes.api.Shape;
import com.terraformersmc.terraform.shapes.api.validator.Validator;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.Direction;
import net.minecraft.world.TestableWorld;

import java.util.Arrays;
import java.util.List;

public class RegionalSafelistValidator implements Validator {

    private final List<BlockState> safeStates;
    private final TestableWorld testableWorld;
    private final Direction dir;

    public RegionalSafelistValidator(TestableWorld world, Direction dir, List<BlockState> safeStates) {
        this.safeStates = safeStates;
        this.testableWorld = world;
        this.dir = dir;
    }

    public RegionalSafelistValidator(TestableWorld world, Direction dir, BlockState ...safeStates) {
        this(world, dir, Arrays.asList(safeStates));
    }

    @Override
    public boolean validate(Shape shape) {
        return shape.stream().allMatch((position) -> {
            double height = shape.max().getY() - shape.min().getY();
            double width = shape.max().getZ() - shape.min().getZ();
            double depth = shape.max().getX() - shape.min().getX();

            return switch (dir) {
                case UP -> testableWorld.testBlockState(position.toBlockPos(), (state) -> position.getY() > shape.min().getY() + height / 4 ? state.isAir() : safeStates.contains(state) || state.isAir());
                case DOWN -> testableWorld.testBlockState(position.toBlockPos(), (state) -> position.getY() < shape.min().getY() + height * 3 / 4 ? state.isAir() : safeStates.contains(state) || state.isAir());
                case SOUTH -> testableWorld.testBlockState(position.toBlockPos(), (state) -> position.getZ() > shape.min().getZ() + width / 4 ? state.isAir() : safeStates.contains(state) || state.isAir());
                case NORTH -> testableWorld.testBlockState(position.toBlockPos(), (state) -> position.getZ() < shape.min().getZ() + width * 3 / 4 ? state.isAir() : safeStates.contains(state) || state.isAir());
                case EAST -> testableWorld.testBlockState(position.toBlockPos(), (state) -> position.getX() > shape.min().getX() + depth / 4 ? state.isAir() : safeStates.contains(state) || state.isAir());
                case WEST -> testableWorld.testBlockState(position.toBlockPos(), (state) -> position.getX() < shape.min().getX() + depth * 3 / 4 ? state.isAir() : safeStates.contains(state) || state.isAir());
            };
        });
    }
}
