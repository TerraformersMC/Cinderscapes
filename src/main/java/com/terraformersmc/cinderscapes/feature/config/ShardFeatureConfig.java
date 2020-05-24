package com.terraformersmc.cinderscapes.feature.config;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.FeatureConfig;

import java.util.Arrays;
import java.util.List;


/**
 * [REVIEWED]
 *
 * The feature configurator for various shard features
 *
 * @author <Wtoll> Will Toll
 * @project Cinderscapes
 */
public class ShardFeatureConfig implements FeatureConfig {

    public final BlockState shardMaterial;
    public final List<BlockState> groundMaterials;


    public ShardFeatureConfig(BlockState shardMaterial, BlockState... groundMaterials) {
        this(shardMaterial, Arrays.asList(groundMaterials));
    }

    public ShardFeatureConfig(BlockState shardMaterial, List<BlockState> groundMaterials) {
        this.shardMaterial = shardMaterial;
        this.groundMaterials = groundMaterials;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
        return new Dynamic(ops, ops.createMap(new ImmutableMap.Builder()
                .put(ops.createString("shard_block"), BlockState.serialize(ops, this.shardMaterial).getValue())
                .put(ops.createString("ground_blocks"), ops.createList(this.groundMaterials.stream().map((state) -> BlockState.serialize(ops, state).getValue())))
                .build()
        ));
    }

    public static <T> ShardFeatureConfig deserialize(Dynamic<T> dynamic) {
        BlockState shardMaterial = dynamic.get("shard_block").map(BlockState::deserialize).orElse(Blocks.AIR.getDefaultState());
        List<BlockState> groundMaterials = dynamic.get("ground_blocks").asList(BlockState::deserialize);
        return new ShardFeatureConfig(shardMaterial, (BlockState[]) groundMaterials.toArray());
    }
}
