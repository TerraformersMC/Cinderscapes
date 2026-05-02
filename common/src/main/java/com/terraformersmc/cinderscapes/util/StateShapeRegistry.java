package com.terraformersmc.cinderscapes.util;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;

public class StateShapeRegistry {
    private static final Map<Block, StateShapeSupplier> SUPPLIER_MAP = new IdentityHashMap<>();

    public static StateShapeSupplier put(Block block, StateShapeSupplier shapeSupplier) {
        Objects.requireNonNull(block);

        return SUPPLIER_MAP.put(block, shapeSupplier);
    }

    public static StateShapeSupplier put(BlockState state, StateShapeSupplier shapeSupplier) {
        return put(state.getBlock(), shapeSupplier);
    }

    public static StateShapeSupplier get(Block block) {
        Objects.requireNonNull(block);

        return SUPPLIER_MAP.get(block);
    }

    public static StateShapeSupplier get(BlockState state) {
        return get(state.getBlock());
    }

    public static VoxelShape getShape(BlockState state) {
        Objects.requireNonNull(state.getBlock());

        StateShapeSupplier shapeSupplier = SUPPLIER_MAP.get(state.getBlock());

        return shapeSupplier != null ? shapeSupplier.apply(state) : Shapes.empty();
    }

    public static StateShapeSupplier remove(Block block) {
        Objects.requireNonNull(block);

        return SUPPLIER_MAP.remove(block);
    }

    public static StateShapeSupplier remove(BlockState state) {
        return remove(state.getBlock());
    }
}
