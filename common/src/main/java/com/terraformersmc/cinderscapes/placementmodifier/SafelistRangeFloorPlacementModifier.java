package com.terraformersmc.cinderscapes.placementmodifier;

import com.mojang.logging.LogUtils;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.terraformersmc.cinderscapes.init.CinderscapesPlacementModifierTypes;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.FeaturePlacementContext;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifierType;
import org.slf4j.Logger;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SafelistRangeFloorPlacementModifier extends PlacementModifier {
    public static final Codec<SafelistRangeFloorPlacementModifier> UNIFORM_CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(YOffset.OFFSET_CODEC.fieldOf("min_inclusive").forGetter(provider -> {
            return provider.minOffset;
        }), YOffset.OFFSET_CODEC.fieldOf("max_inclusive").forGetter(provider -> {
            return provider.maxOffset;
        }), BlockState.CODEC.listOf().fieldOf("safelist").forGetter(provider -> {
            return provider.safelist;
        })).apply(instance, SafelistRangeFloorPlacementModifier::new);
    });
    private static final Logger LOGGER = LogUtils.getLogger();
    private final List<BlockState> safelist;
    private final YOffset minOffset;
    private final YOffset maxOffset;

    public SafelistRangeFloorPlacementModifier(YOffset minOffset, YOffset maxOffset, List<BlockState> safelist) {
        this.safelist = safelist;
        this.minOffset = minOffset;
        this.maxOffset = maxOffset;
    }

    @Override
    public Stream<BlockPos> getPositions(FeaturePlacementContext context, Random random, BlockPos pos) {

        int x = pos.getX();
        int z = pos.getZ();
        BlockPos.Mutable testPos = new BlockPos.Mutable(x, 0, z);
        BlockPos.Mutable offsetPos = new BlockPos.Mutable(x, 0, z);
        List<Integer> ys = IntStream.range(minOffset.getY(context), maxOffset.getY(context)).filter((y) -> {
            testPos.setY(y);
            offsetPos.setY(y - 1);

            BlockState testState = context.getBlockState(testPos);
            BlockState offsetState = context.getBlockState(offsetPos);

            return testState.isAir() && offsetState.isOpaque() && safelist.contains(offsetState);
        }).boxed().toList();
        if (ys.size() > 0) {
            testPos.setY(ys.get(random.nextInt(ys.size())));
        } else {
            testPos.setY(0);
        }
        return Stream.of(testPos);
    }

    @Override
    public PlacementModifierType<?> getType() {
        return CinderscapesPlacementModifierTypes.COUNT_FLOOR;
    }
}
