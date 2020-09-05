package com.terraformersmc.cinderscapes.util.shapelib;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author <Wtoll> Will Toll on 2020-05-23
 * @project Cinderscapes
 */
public class Shape extends ArrayList<BlockPos> {
    /**
     * Rotates all of the positions in the shape by the quaternion
     * @param q The quaternion to rotate by
     * @return The rotated shape
     */
    public Shape rotateBy(Quaternion q) {
        Shape shape = new Shape();
        forEach((pos) -> shape.add(Quaternion.of(pos).rotateBy(q).toBlockPos()));
        return shape;
    }

    /**
     * Rotates all of the positions in the shape around the given point using a quaternion.
     * Translates all of the values to relative positions around the given origin point,
     * then rotates the points and then translates them back.
     * @param q   The quaternion to rotate the shape by
     * @param pos The origin point to rotate the shape around
     * @return The rotated shape
     */
    public Shape rotateBy(Quaternion q, BlockPos pos) {
        return translateBy(new BlockPos(-pos.getX(), -pos.getY(), -pos.getZ())).rotateBy(q).translateBy(pos);
    }

    /**
     * Translated all of the positions in the shape from based at the origin to based at the point
     * @param pos The point given to rebase the shape off of
     * @return The translated shape
     */
    public Shape translateBy(BlockPos pos) {
        Shape shape = new Shape();
        forEach((ipos) -> shape.add(ipos.add(pos)));
        return shape;
    }

    public Shape translateDown(int i) {
        return translateBy(new BlockPos(0, -i, 0));
    }

    public Shape translateUp(int i) {
        return translateBy(new BlockPos(0, i, 0));
    }

    public Shape translateNorth(int i) {
        return translateBy(new BlockPos(0, 0, -i));
    }

    public Shape translateSouth(int i) {
        return translateBy(new BlockPos(0, 0, i));
    }

    public Shape translateWest(int i) {
        return translateBy(new BlockPos(-i, 0, 0));
    }

    public Shape translateEast(int i) {
        return translateBy(new BlockPos(i, 0, 0));
    }

    public void fill(BlockState state, StructureWorldAccess world) {
        forEach((pos) -> world.setBlockState(pos, state, 0));
    }

    public void fillUpdate(BlockState state, StructureWorldAccess world) {
        forEach((pos) -> {
            world.setBlockState(pos, state, 2);
            world.updateNeighbors(pos, state.getBlock());
        });
    }

    public void fillWhitelist(BlockState state, StructureWorldAccess world, List<BlockState> whitelist) {
        forEach((pos) -> {
            BlockState currentState = world.getBlockState(pos);
            if (whitelist.contains(currentState)) world.setBlockState(pos, state, 0);
        });
    }

    public void fillBlacklist(BlockState state, StructureWorldAccess world, List<BlockState> blacklist) {
        forEach((pos) -> {
            BlockState currentState = world.getBlockState(pos);
            if (!blacklist.contains(currentState)) world.setBlockState(pos, state, 0);
        });
    }

    public void fillIfAir(BlockState state, StructureWorldAccess world) {
        forEach((pos) -> {
            BlockState currentState = world.getBlockState(pos);
            if (currentState.isAir()) world.setBlockState(pos, state, 0);
        });
    }

    public boolean fillIfSafeWhitelist(BlockState state, StructureWorldAccess world, List<BlockState> whitelist) {
        boolean safe = true;
        for (BlockPos pos : this) {
            BlockState currentState = world.getBlockState(pos);
            if (!whitelist.contains(currentState)) safe = false;
        }
        if (safe) fill(state, world);
        return safe;
    }

    public boolean isSafeWhitelist(StructureWorldAccess world, List<BlockState> whitelist) {
        boolean safe = true;
        for (BlockPos pos : this) {
            BlockState currentState = world.getBlockState(pos);
            if (!whitelist.contains(currentState)) safe = false;
        }
        return safe;
    }

    /**
     * If the list already contains an identical item then don't add it again
     * @param pos The position to be added
     * @return A boolean as to whether the item was added/was already contained in the list
     */
    @Override
    public boolean add(BlockPos pos) {
        return contains(pos) || super.add(pos);
    }

    @Override
    public boolean addAll(Collection<? extends BlockPos> blocks) {
        blocks.forEach(this::add);
        return true;
    }

    public Shape copy() {
        Shape shape = new Shape();
        shape.addAll(this);
        return shape;
    }

    public Shape join(Shape s) {
        this.addAll(s);
        return this;
    }

    public Shape subtract(Shape s) {
        s.forEach(this::remove);
        return this;
    }

    public Shape intersect(Shape s) {
        Shape shape = new Shape();
        s.forEach((pos) -> {
            if (this.contains(pos)) shape.add(pos);
        });
        return shape;
    }

    public Shape inverseIntersect(Shape s) {
        Shape intersect = this.copy();
        intersect.intersect(s);
        Shape join = this.copy();
        join.join(s);
        return join.subtract(intersect);
    }
}
