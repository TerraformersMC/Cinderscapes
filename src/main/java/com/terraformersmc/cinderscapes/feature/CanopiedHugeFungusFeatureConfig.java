package com.terraformersmc.cinderscapes.feature;

import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.FeatureConfig;

import java.util.Map;

public class CanopiedHugeFungusFeatureConfig implements FeatureConfig {

    public final BlockState soilBlock;
    public final BlockState stemBlock;
    public final BlockState canopyBlock;
    public final BlockState fleshBlock;
    public final BlockState decorationBlock;
    public final boolean planted;

    public CanopiedHugeFungusFeatureConfig(BlockState soilBlock, BlockState stemBlock, BlockState canopyBlock, BlockState fleshBlock, BlockState decorationBlock, boolean planted) {
        this.soilBlock = soilBlock;
        this.stemBlock = stemBlock;
        this.canopyBlock = canopyBlock;
        this.fleshBlock = fleshBlock;
        this.decorationBlock = decorationBlock;
        this.planted = planted;
    }

    @Override
    public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
        return new Dynamic(ops, ops.createMap(Map.of(
                ops.createString("soil_block"), BlockState.serialize(ops, this.soilBlock).getValue(),
                ops.createString("stem_block"), BlockState.serialize(ops, this.stemBlock).getValue(),
                ops.createString("canopy_block"), BlockState.serialize(ops, this.canopyBlock).getValue(),
                ops.createString("decoration_block"), BlockState.serialize(ops, this.decorationBlock).getValue(),
                ops.createString("planted"), ops.createBoolean(this.planted))));
    }

    public static <T> CanopiedHugeFungusFeatureConfig deserialize(Dynamic<T> dynamic) {
        BlockState soilBlock = (BlockState)dynamic.get("soil_block").map(BlockState::deserialize).orElse(Blocks.AIR.getDefaultState());
        BlockState stemBlock = (BlockState)dynamic.get("stem_block").map(BlockState::deserialize).orElse(Blocks.AIR.getDefaultState());
        BlockState canopyBlock = (BlockState)dynamic.get("canopy_block").map(BlockState::deserialize).orElse(Blocks.AIR.getDefaultState());
        BlockState fleshBlock = (BlockState)dynamic.get("flesh_block").map(BlockState::deserialize).orElse(Blocks.AIR.getDefaultState());
        BlockState decorationBlock = (BlockState)dynamic.get("decoration_block").map(BlockState::deserialize).orElse(Blocks.AIR.getDefaultState());
        boolean planted = dynamic.get("planted").asBoolean(false);
        return new CanopiedHugeFungusFeatureConfig(soilBlock, stemBlock, canopyBlock, fleshBlock, decorationBlock, planted);
    }
}
