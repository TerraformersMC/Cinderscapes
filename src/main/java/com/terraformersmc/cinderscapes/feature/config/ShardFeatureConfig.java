package com.terraformersmc.cinderscapes.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
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

    public static final Codec<ShardFeatureConfig> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(BlockState.field_24734.fieldOf("shard_state").forGetter((config) -> {
            return config.shardMaterial;
        }), BlockState.field_24734.listOf().fieldOf("ground_state").forGetter((config) -> {
            return config.groundMaterials;
        })).apply(instance, ShardFeatureConfig::new);
    });
}
