package com.terraformersmc.cinderscapes.util;

import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.StructureConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;

public class RegistrationHelper {

    private final String namespace;

    public RegistrationHelper(String namespace) {
        this.namespace = namespace;
    }

    public <I extends Item> I register(I i, String name) {
        return Registry.register(Registry.ITEM, new Identifier(this.namespace, name), i);
    }

    public <B extends Block> B register(B b, String name, Item.Settings settings) {
        register(new BlockItem(b, settings), name);
        return register(b, name);
    }

    public <B extends Block> B register(B b, String name) {
        return Registry.register(Registry.BLOCK, new Identifier(this.namespace, name), b);
    }

    public <F extends Feature<?>> F register(F f, String name) {
        return Registry.register(Registry.FEATURE, new Identifier(this.namespace, name), f);
    }

    public <CF extends ConfiguredFeature<?, ?>> CF register(CF f, String name) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(this.namespace, name), f);
    }

    public <CS extends ConfiguredSurfaceBuilder<?>> CS register(CS s, String name) {
        return Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier(this.namespace, name), s);
    }

    public StructurePieceType register(StructurePieceType type, String name) {
        return Registry.register(Registry.STRUCTURE_PIECE, new Identifier(this.namespace, name), type);
    }

    public <FC extends FeatureConfig, F extends StructureFeature<FC>> ConfiguredStructureFeature<FC, F> register(ConfiguredStructureFeature<FC, F> s, String name, int spacing, int separation) {
        Identifier id = new Identifier(this.namespace, name);

        FabricStructureBuilder.create(id, s.feature)
                .step(GenerationStep.Feature.SURFACE_STRUCTURES)
                .defaultConfig(new StructureConfig(spacing, separation, 21345))
                .superflatFeature(s)
                .register();

        return BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, id, s);
    }

    public Biome register(Biome b, String name) {
        return Registry.register(BuiltinRegistries.BIOME, new Identifier(this.namespace, name), b);
    }

    public SoundEvent register(String s) {
        Identifier id = new Identifier(this.namespace, s);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }
}
