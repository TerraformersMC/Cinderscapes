package com.terraformersmc.cinderscapes.placementmodifier;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import org.jspecify.annotations.NullMarked;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

@NullMarked
public class SafelistRangeFloorPlacementModifier implements PlacementModifier {
    public static final MapCodec<SafelistRangeFloorPlacementModifier> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    VerticalAnchor.CODEC.fieldOf("min_inclusive").forGetter(provider -> provider.minOffset),
                    VerticalAnchor.CODEC.fieldOf("max_inclusive").forGetter(provider -> provider.maxOffset),
                    BlockState.CODEC.listOf().fieldOf("safelist").forGetter(provider -> provider.safelist)
            ).apply(instance, SafelistRangeFloorPlacementModifier::new)
    );
    private final List<BlockState> safelist;
    private final VerticalAnchor minOffset;
    private final VerticalAnchor maxOffset;

    private SafelistRangeFloorPlacementModifier(VerticalAnchor minOffset, VerticalAnchor maxOffset, List<BlockState> safelist) {
        this.safelist = safelist;
        this.minOffset = minOffset;
        this.maxOffset = maxOffset;
    }

    public static SafelistRangeFloorPlacementModifier of(VerticalAnchor minOffset, VerticalAnchor maxOffset, List<BlockState> safelist) {
        return new SafelistRangeFloorPlacementModifier(minOffset, maxOffset, safelist);
    }

    @Override
    public MapCodec<? extends PlacementModifier> codec() {
        return CODEC;
    }

    @Override
    public void modify(PlacementContext context, RandomSource random, BlockPos origin, Consumer<BlockPos> output) {
        BlockPos.MutableBlockPos testPos = origin.mutable();
        BlockPos.MutableBlockPos offsetPos = origin.mutable();

        List<Integer> ys = IntStream.range(minOffset.resolveY(context), maxOffset.resolveY(context)).filter((y) -> {
            testPos.setY(y);
            offsetPos.setY(y - 1);

            BlockState testState = context.getBlockState(testPos);
            BlockState offsetState = context.getBlockState(offsetPos);

            return testState.isAir() && offsetState.canOcclude() && safelist.contains(offsetState);
        }).boxed().toList();

        if (ys.size() > 0) {
            testPos.setY(ys.get(random.nextInt(ys.size())));
        } else {
            testPos.setY(0);
        }

        output.accept(testPos);
    }
}
