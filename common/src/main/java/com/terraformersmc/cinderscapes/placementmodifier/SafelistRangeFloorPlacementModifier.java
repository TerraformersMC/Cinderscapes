package com.terraformersmc.cinderscapes.placementmodifier;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.terraformersmc.cinderscapes.init.CinderscapesPlacementModifierTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import org.jspecify.annotations.NullMarked;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@NullMarked
public class SafelistRangeFloorPlacementModifier extends PlacementModifier {
    public static final MapCodec<SafelistRangeFloorPlacementModifier> MODIFIER_CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    VerticalAnchor.CODEC.fieldOf("min_inclusive").forGetter(provider -> provider.minOffset),
                    VerticalAnchor.CODEC.fieldOf("max_inclusive").forGetter(provider -> provider.maxOffset),
                    BlockState.CODEC.listOf().fieldOf("safelist").forGetter(provider -> provider.safelist)
            ).apply(instance, SafelistRangeFloorPlacementModifier::new)
    );
    private final List<BlockState> safelist;
    private final VerticalAnchor minOffset;
    private final VerticalAnchor maxOffset;

    public SafelistRangeFloorPlacementModifier(VerticalAnchor minOffset, VerticalAnchor maxOffset, List<BlockState> safelist) {
        this.safelist = safelist;
        this.minOffset = minOffset;
        this.maxOffset = maxOffset;
    }

    @Override
    public Stream<BlockPos> getPositions(PlacementContext context, RandomSource random, BlockPos pos) {

        int x = pos.getX();
        int z = pos.getZ();
        BlockPos.MutableBlockPos testPos = new BlockPos.MutableBlockPos(x, 0, z);
        BlockPos.MutableBlockPos offsetPos = new BlockPos.MutableBlockPos(x, 0, z);
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
        return Stream.of(testPos);
    }

    @Override
    public PlacementModifierType<?> type() {
        return CinderscapesPlacementModifierTypes.COUNT_FLOOR;
    }
}
