package com.terraformersmc.cinderscapes.biomes.quartzcavern;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.biomes.quartzcavern.block.CrystiniumBlock;
import com.terraformersmc.cinderscapes.biomes.quartzcavern.block.PolypiteQuartzBlock;
import com.terraformersmc.terraform.TransparentBlock;
import com.terraformersmc.terraform.wood.block.TerraformStairsBlock;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Style;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.BlockView;

import java.util.Optional;

public class QuartzCavernBlocks {

    public static final Block QUARTZ_SAND = Cinderscapes.REGISTRATION_HELPER.register(new SandBlock(2, FabricBlockSettings.copyOf(Blocks.SAND)), "quartz_sand", new FabricItemSettings());

    public static final Block CRYSTINIUM = Cinderscapes.REGISTRATION_HELPER.register(new CrystiniumBlock(), "crystinium", new FabricItemSettings());
    public static final Block POTTED_CRYSTINIUM = Cinderscapes.REGISTRATION_HELPER.register(new FlowerPotBlock(CRYSTINIUM, FabricBlockSettings.copyOf(Blocks.WARPED_ROOTS)), "potted_crystinium");

    public static final Block CRYSTALLINE_QUARTZ = Cinderscapes.REGISTRATION_HELPER.register(new TransparentBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).sounds(BlockSoundGroup.GLASS).nonOpaque().allowsSpawning(QuartzCavernBlocks::never).solidBlock(QuartzCavernBlocks::never).suffocates(QuartzCavernBlocks::never).blockVision(QuartzCavernBlocks::never)), "crystalline_quartz", new FabricItemSettings());
    public static final Block POLYPITE_QUARTZ = add("polypite_quartz", new PolypiteQuartzBlock(FabricBlockSettings.copyOf(CRYSTALLINE_QUARTZ)), ItemGroup.DECORATIONS);
    public static final Block POTTED_POLYPITE_QUARTZ = add("potted_polypite_quartz", new FlowerPotBlock(POLYPITE_QUARTZ, FabricBlockSettings.copyOf(Blocks.FLOWER_POT)));

    // Sulfur Quartz

    public static final Block POLYPITE_SULFUR_QUARTZ = add("polypite_sulfur_quartz", new PolypiteQuartzBlock(FabricBlockSettings.copyOf(POLYPITE_QUARTZ).materialColor(MapColor.YELLOW)), ItemGroup.DECORATIONS);
    public static final Block POTTED_POLYPITE_SULFUR_QUARTZ = add("potted_polypite_sulfur_quartz", new FlowerPotBlock(POLYPITE_SULFUR_QUARTZ, FabricBlockSettings.copyOf(Blocks.FLOWER_POT)));

    public static final Block SULFUR_QUARTZ_ORE = Cinderscapes.REGISTRATION_HELPER.register(new OreBlock(FabricBlockSettings.copyOf(Blocks.NETHER_QUARTZ_ORE).materialColor(MapColor.YELLOW).breakByTool(FabricToolTags.PICKAXES, 1).sounds(BlockSoundGroup.NETHER_ORE).requiresTool(), UniformIntProvider.create(2, 5)), "sulfur_quartz_ore", new FabricItemSettings());
    public static final Block SULFUR_QUARTZ_BLOCK = add("sulfur_quartz_block", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).materialColor(MapColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block CHISELED_SULFUR_QUARTZ_BLOCK = add("chiseled_sulfur_quartz_block", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).materialColor(MapColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SULFUR_QUARTZ_PILLAR = add("sulfur_quartz_pillar", new PillarBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_PILLAR).materialColor(MapColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SULFUR_QUARTZ_STAIRS = add("sulfur_quartz_stairs", new TerraformStairsBlock(SULFUR_QUARTZ_BLOCK, FabricBlockSettings.copyOf(Blocks.QUARTZ_STAIRS).materialColor(MapColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SULFUR_QUARTZ_SLAB = add("sulfur_quartz_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_SLAB).materialColor(MapColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_SULFUR_QUARTZ = add("smooth_sulfur_quartz", new Block(FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ).materialColor(MapColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_SULFUR_QUARTZ_STAIRS = add("smooth_sulfur_quartz_stairs", new TerraformStairsBlock(SMOOTH_SULFUR_QUARTZ, FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_STAIRS).materialColor(MapColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_SULFUR_QUARTZ_SLAB = add("smooth_sulfur_quartz_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_SLAB).materialColor(MapColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SULFUR_QUARTZ_BRICKS = add("sulfur_quartz_bricks", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BRICKS).materialColor(MapColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block CRYSTALLINE_SULFUR_QUARTZ = add("crystalline_sulfur_quartz", new TransparentBlock(FabricBlockSettings.copyOf(CRYSTALLINE_QUARTZ).materialColor(MapColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);

    // Rose Quartz

    public static final Block POLYPITE_ROSE_QUARTZ = add("polypite_rose_quartz", new PolypiteQuartzBlock(FabricBlockSettings.copyOf(POLYPITE_QUARTZ).materialColor(MapColor.PINK)), ItemGroup.DECORATIONS);
    public static final Block POTTED_POLYPITE_ROSE_QUARTZ = add("potted_polypite_rose_quartz", new FlowerPotBlock(POLYPITE_ROSE_QUARTZ, FabricBlockSettings.copyOf(Blocks.FLOWER_POT)));

    public static final Block ROSE_QUARTZ_ORE = Cinderscapes.REGISTRATION_HELPER.register(new OreBlock(FabricBlockSettings.copyOf(Blocks.NETHER_QUARTZ_ORE).materialColor(MapColor.PINK).breakByTool(FabricToolTags.PICKAXES, 1).sounds(BlockSoundGroup.NETHER_ORE).requiresTool(), UniformIntProvider.create(2, 5)), "rose_quartz_ore", new FabricItemSettings());
    public static final Block ROSE_QUARTZ_BLOCK = add("rose_quartz_block", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).materialColor(MapColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block CHISELED_ROSE_QUARTZ_BLOCK = add("chiseled_rose_quartz_block", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).materialColor(MapColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block ROSE_QUARTZ_PILLAR = add("rose_quartz_pillar", new PillarBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_PILLAR).materialColor(MapColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block ROSE_QUARTZ_STAIRS = add("rose_quartz_stairs", new TerraformStairsBlock(ROSE_QUARTZ_BLOCK, FabricBlockSettings.copyOf(Blocks.QUARTZ_STAIRS).materialColor(MapColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block ROSE_QUARTZ_SLAB = add("rose_quartz_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_SLAB).materialColor(MapColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_ROSE_QUARTZ = add("smooth_rose_quartz", new Block(FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ).materialColor(MapColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_ROSE_QUARTZ_STAIRS = add("smooth_rose_quartz_stairs", new TerraformStairsBlock(SMOOTH_ROSE_QUARTZ, FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_STAIRS).materialColor(MapColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_ROSE_QUARTZ_SLAB = add("smooth_rose_quartz_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_SLAB).materialColor(MapColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block ROSE_QUARTZ_BRICKS = add("rose_quartz_bricks", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BRICKS).materialColor(MapColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block CRYSTALLINE_ROSE_QUARTZ = add("crystalline_rose_quartz", new TransparentBlock(FabricBlockSettings.copyOf(CRYSTALLINE_QUARTZ).materialColor(MapColor.PINK)), ItemGroup.BUILDING_BLOCKS);

    // Smoky Quartz

    public static final Block POLYPITE_SMOKY_QUARTZ = add("polypite_smoky_quartz", new PolypiteQuartzBlock(FabricBlockSettings.copyOf(POLYPITE_QUARTZ).materialColor(MapColor.GRAY)), ItemGroup.DECORATIONS);
    public static final Block POTTED_POLYPITE_SMOKY_QUARTZ = add("potted_polypite_smoky_quartz", new FlowerPotBlock(POLYPITE_SMOKY_QUARTZ, FabricBlockSettings.copyOf(Blocks.FLOWER_POT)));

    public static final Block SMOKY_QUARTZ_ORE = Cinderscapes.REGISTRATION_HELPER.register(new OreBlock(FabricBlockSettings.copyOf(Blocks.NETHER_QUARTZ_ORE).materialColor(MapColor.GRAY).breakByTool(FabricToolTags.PICKAXES, 1).sounds(BlockSoundGroup.NETHER_ORE).requiresTool(), UniformIntProvider.create(2, 5)), "smoky_quartz_ore", new FabricItemSettings());
    public static final Block SMOKY_QUARTZ_BLOCK = add("smoky_quartz_block", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).materialColor(MapColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block CHISELED_SMOKY_QUARTZ_BLOCK = add("chiseled_smoky_quartz_block", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).materialColor(MapColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOKY_QUARTZ_PILLAR = add("smoky_quartz_pillar", new PillarBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_PILLAR).materialColor(MapColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOKY_QUARTZ_STAIRS = add("smoky_quartz_stairs", new TerraformStairsBlock(SMOKY_QUARTZ_BLOCK, FabricBlockSettings.copyOf(Blocks.QUARTZ_STAIRS).materialColor(MapColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOKY_QUARTZ_SLAB = add("smoky_quartz_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_SLAB).materialColor(MapColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_SMOKY_QUARTZ = add("smooth_smoky_quartz", new Block(FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ).materialColor(MapColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_SMOKY_QUARTZ_STAIRS = add("smooth_smoky_quartz_stairs", new TerraformStairsBlock(SMOOTH_SMOKY_QUARTZ, FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_STAIRS).materialColor(MapColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_SMOKY_QUARTZ_SLAB = add("smooth_smoky_quartz_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_SLAB).materialColor(MapColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOKY_QUARTZ_BRICKS = add("smoky_quartz_bricks", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BRICKS).materialColor(MapColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block CRYSTALLINE_SMOKY_QUARTZ = add("crystalline_smoky_quartz", new TransparentBlock(FabricBlockSettings.copyOf(CRYSTALLINE_QUARTZ).materialColor(MapColor.GRAY)), ItemGroup.BUILDING_BLOCKS);

    public static final Block NODZOL = Cinderscapes.REGISTRATION_HELPER.register(new Block(FabricBlockSettings.copyOf(Blocks.NETHERRACK).breakByTool(FabricToolTags.PICKAXES)), "nodzol", new FabricItemSettings());

    private static Block add(String name, Block b, ItemGroup group) {
        return Cinderscapes.REGISTRATION_HELPER.register(b, name, new FabricItemSettings());
    }

    private static Block add(String name, Block b) {
        return Cinderscapes.REGISTRATION_HELPER.register(b, name);
    }

    private static boolean never(BlockState blockState, BlockView blockView, BlockPos pos) {
        return false;
    }

    private static boolean never(BlockState blockState, BlockView blockView, BlockPos pos, EntityType<?> entityType) {
        return false;
    }

    public static void onInitializeCommon() {
        if (Cinderscapes.CONFIG.easterEggs) {

        } else {
            Cinderscapes.HIDDEN_ITEMS.add(QuartzCavernBlocks.NODZOL.asItem());
        }
    }

    public static void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(),
                QuartzCavernBlocks.CRYSTALLINE_SULFUR_QUARTZ,
                QuartzCavernBlocks.CRYSTALLINE_QUARTZ,
                QuartzCavernBlocks.CRYSTALLINE_ROSE_QUARTZ,
                QuartzCavernBlocks.CRYSTALLINE_SMOKY_QUARTZ
        );

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                QuartzCavernBlocks.CRYSTINIUM,
                QuartzCavernBlocks.POLYPITE_ROSE_QUARTZ,
                QuartzCavernBlocks.POTTED_POLYPITE_ROSE_QUARTZ,
                QuartzCavernBlocks.POLYPITE_QUARTZ,
                QuartzCavernBlocks.POTTED_POLYPITE_QUARTZ,
                QuartzCavernBlocks.POLYPITE_SMOKY_QUARTZ,
                QuartzCavernBlocks.POTTED_POLYPITE_SMOKY_QUARTZ,
                QuartzCavernBlocks.POLYPITE_SULFUR_QUARTZ,
                QuartzCavernBlocks.POTTED_POLYPITE_SULFUR_QUARTZ
        );

        ItemTooltipCallback.EVENT.register((stack, context, lines) -> {
            if (stack.isOf(QuartzCavernBlocks.NODZOL.asItem())) {
                lines.add(new TranslatableText("block.cinderscapes.nodzol.description").setStyle(Style.EMPTY.withColor(Formatting.GRAY)));
            }
        });
    }

}
