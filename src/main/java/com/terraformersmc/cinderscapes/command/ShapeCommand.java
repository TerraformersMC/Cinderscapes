package com.terraformersmc.cinderscapes.command;

import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.terraformersmc.cinderscapes.util.shapelib.Quaternion;
import com.terraformersmc.cinderscapes.util.shapelib.Shape;
import com.terraformersmc.cinderscapes.util.shapelib.Shapes;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.loot.v1.FabricLootSupplier;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.command.arguments.BlockPosArgumentType;
import net.minecraft.command.arguments.BlockStateArgument;
import net.minecraft.command.arguments.BlockStateArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.server.command.CommandSource;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static net.minecraft.server.command.CommandManager.*;

/**
 * @author <Wtoll> Will Toll on 2020-06-01
 * @project Cinderscapes
 */
public class ShapeCommand {
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> dispatcher.register(builder()));
    }

    public static LiteralArgumentBuilder<ServerCommandSource> builder() {
        return literal("shape")
            .requires((source) -> source.hasPermissionLevel(2))
            .then(literal("line")
                .executes(ShapeCommand::line))
            .then(literal("ellipsoid")
                .then(argument("origin", BlockPosArgumentType.blockPos())
                .then(argument("a", FloatArgumentType.floatArg())
                .then(argument("b", FloatArgumentType.floatArg())
                .then(argument("c", FloatArgumentType.floatArg())
                    .executes((context) -> ellipsoid(
                        context.getSource().getWorld(),
                        BlockPosArgumentType.getBlockPos(context, "origin"),
                        FloatArgumentType.getFloat(context, "a"),
                        FloatArgumentType.getFloat(context, "b"),
                        FloatArgumentType.getFloat(context, "c"),
                        Quaternion.NONE))
                .then(argument("w", FloatArgumentType.floatArg())
                .then(argument("i", FloatArgumentType.floatArg())
                .then(argument("j", FloatArgumentType.floatArg())
                .then(argument("k", FloatArgumentType.floatArg())
                    .executes((context) -> ellipsoid(
                        context.getSource().getWorld(),
                        BlockPosArgumentType.getBlockPos(context, "origin"),
                        FloatArgumentType.getFloat(context, "a"),
                        FloatArgumentType.getFloat(context, "b"),
                        FloatArgumentType.getFloat(context, "c"),
                        Quaternion.of(
                            FloatArgumentType.getFloat(context, "w"),
                            FloatArgumentType.getFloat(context, "i"),
                            FloatArgumentType.getFloat(context, "j"),
                            FloatArgumentType.getFloat(context, "k")))))))))))))
            .then(literal("ellipse")
                .then(argument("block", BlockStateArgumentType.blockState())
                .then(argument("origin", BlockPosArgumentType.blockPos())
                .then(argument("a", FloatArgumentType.floatArg())
                .then(argument("b", FloatArgumentType.floatArg())
                    .executes((context) -> ellipse(
                        context.getSource().getWorld(),
                        BlockStateArgumentType.getBlockState(context, "block").getBlockState(),
                        BlockPosArgumentType.getBlockPos(context, "origin"),
                        FloatArgumentType.getFloat(context, "a"),
                        FloatArgumentType.getFloat(context, "b"),
                        Quaternion.NONE
                    ))
                .then(argument("w", FloatArgumentType.floatArg())
                .then(argument("i", FloatArgumentType.floatArg())
                .then(argument("j", FloatArgumentType.floatArg())
                .then(argument("k", FloatArgumentType.floatArg())
                    .executes((context) -> ellipse(
                        context.getSource().getWorld(),
                            BlockStateArgumentType.getBlockState(context, "block").getBlockState(),
                            BlockPosArgumentType.getBlockPos(context, "origin"),
                            FloatArgumentType.getFloat(context, "a"),
                            FloatArgumentType.getFloat(context, "b"),
                            Quaternion.of(
                                FloatArgumentType.getFloat(context,"w"),
                                FloatArgumentType.getFloat(context, "i"),
                                FloatArgumentType.getFloat(context, "j"),
                                FloatArgumentType.getFloat(context, "k")))))))))))));

    }

    public static int ellipse(ServerWorldAccess world, BlockState state, BlockPos origin, float a, float b, Quaternion q) {
        Shape shape = new Shape();

        
        shape.join(Shapes.ellipseSolid(a * 2, b * 2).rotateBy(q).translateBy(origin));


        shape.fillUpdate(state, world);
        return 1;
    }

    public static int ellipsoid(ServerWorldAccess world, BlockPos origin, float a, float b, float c, Quaternion q) {
        Shape shape = Shapes.ellipsoidSolidRoatated(a, b, c, q).translateBy(origin);
        shape.fillUpdate(Blocks.DIRT.getDefaultState(), world);
        return 1;
    }

    public static int line(CommandContext context) {
        return 1;
    }

}
