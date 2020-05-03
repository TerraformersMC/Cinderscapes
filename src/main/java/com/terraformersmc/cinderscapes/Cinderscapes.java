package com.terraformersmc.cinderscapes;

import com.terraformersmc.cinderscapes.init.*;
import com.terraformersmc.cinderscapes.command.MapBiomesCommand;
import com.terraformersmc.cinderscapes.util.NoiseCollisionChecker;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

/**
 * [REVIEWED]
 *
 * @author <Wtoll> Will Toll on 2020-05-02
 * @project Cinderscapes
 */
public class Cinderscapes implements ModInitializer {

    public static final String MOD_ID = "cinderscapes";

    /**
     * Initializes the custom content in the mod
     */
    @Override
    public void onInitialize() {
        CinderscapesBlocks.init();
        CinderscapesDecorators.init();
        CinderscapesFeatures.init();
        CinderscapesSurfaces.init();
        CinderscapesBiomes.init();
        CinderscapesGroups.init();

        // TODO: Move to Terraform
        MapBiomesCommand.register();
        NoiseCollisionChecker.init();
    }

    /**
     * Creates an identifier value using the Cinderscapes namespace
     * @param s The string representing the path of the identifier
     * @return An identifier with namespace equal to the Cinderscapes mod id and path equal to s
     */
    public static Identifier id(String s) {
        return new Identifier(MOD_ID, s);
    }
}
