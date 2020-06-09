package com.terraformersmc.cinderscapes.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

/**
 * @author <Wtoll> Will Toll on 2020-06-01
 * @project Cinderscapes
 */
public class CinderscapesTransparentBlock extends TransparentBlock {
    public CinderscapesTransparentBlock(Settings settings) {
        super(settings);
    }
}
