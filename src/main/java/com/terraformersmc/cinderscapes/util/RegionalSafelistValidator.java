package com.terraformersmc.cinderscapes.util;

import com.terraformersmc.terraform.shapes.api.Shape;
import com.terraformersmc.terraform.shapes.api.validator.Validator;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Arrays;
import java.util.List;

// Specialized version of Terraform Shapes API's SafelistValidator to ensure uncrowded placement.
public class RegionalSafelistValidator implements Validator {

    private final List<BlockState> safeStates;
    private final LevelSimulatedReader level;
    private final Direction dir;

    public RegionalSafelistValidator(LevelSimulatedReader level, Direction dir, List<BlockState> safeStates) {
        this.safeStates = safeStates;
        this.level = level;
        this.dir = dir;
    }

    public RegionalSafelistValidator(LevelSimulatedReader level, Direction dir, BlockState...safeStates) {
        this(level, dir, Arrays.asList(safeStates));
    }

    @Override
    public boolean validate(Shape shape) {
        return shape.stream().allMatch((position) -> {
            double height = shape.max().getY() - shape.min().getY();
            double width = shape.max().getZ() - shape.min().getZ();
            double depth = shape.max().getX() - shape.min().getX();

            return switch (dir) {
                case UP -> level.isStateAtPosition(position.toBlockPos(), (state) -> position.getY() > shape.min().getY() + height / 4 ? state.isAir() : safeStates.contains(state) || state.isAir());
                case DOWN -> level.isStateAtPosition(position.toBlockPos(), (state) -> position.getY() < shape.min().getY() + height * 3 / 4 ? state.isAir() : safeStates.contains(state) || state.isAir());
                case SOUTH -> level.isStateAtPosition(position.toBlockPos(), (state) -> position.getZ() > shape.min().getZ() + width / 4 ? state.isAir() : safeStates.contains(state) || state.isAir());
                case NORTH -> level.isStateAtPosition(position.toBlockPos(), (state) -> position.getZ() < shape.min().getZ() + width * 3 / 4 ? state.isAir() : safeStates.contains(state) || state.isAir());
                case EAST -> level.isStateAtPosition(position.toBlockPos(), (state) -> position.getX() > shape.min().getX() + depth / 4 ? state.isAir() : safeStates.contains(state) || state.isAir());
                case WEST -> level.isStateAtPosition(position.toBlockPos(), (state) -> position.getX() < shape.min().getX() + depth * 3 / 4 ? state.isAir() : safeStates.contains(state) || state.isAir());
            };
        });
    }
}
