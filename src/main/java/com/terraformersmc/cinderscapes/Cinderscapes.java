package com.terraformersmc.cinderscapes;

import com.terraformersmc.cinderscapes.command.MapBiomesCommand;
import com.terraformersmc.cinderscapes.command.ShapeCommand;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.init.CinderscapesDecorators;
import com.terraformersmc.cinderscapes.init.CinderscapesFeatures;
import com.terraformersmc.cinderscapes.init.CinderscapesGroups;
import com.terraformersmc.cinderscapes.init.CinderscapesItems;
import com.terraformersmc.cinderscapes.init.CinderscapesSurfaces;
import com.terraformersmc.cinderscapes.init.CinderscapesTags;
import com.terraformersmc.cinderscapes.util.NoiseCollisionChecker;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * [REVIEWED]
 *
 * @author <Wtoll> Will Toll on 2020-05-02
 * @project Cinderscapes
 */
public class Cinderscapes implements ModInitializer {

    public static final String MOD_ID = "cinderscapes";
    public static final Logger LOGGER = LogManager.getLogger(StringUtils.capitalize(MOD_ID));

    /**
     * Initializes the custom content in the mod
     */
    @Override
    public void onInitialize() {
        CinderscapesItems.init();
        CinderscapesBlocks.init();
        CinderscapesTags.init();
        CinderscapesDecorators.init();
        CinderscapesFeatures.init();
        CinderscapesSurfaces.init();
        CinderscapesGroups.init();

        MapBiomesCommand.register();
        ShapeCommand.register();
        NoiseCollisionChecker.init();
    }

    /**
     * Creates an identifier value using the Cinderscapes namespace
     * @param s The string representing the path of the identifier within the Cinderscapes namespace
     * @return An identifier with namespace equal to the Cinderscapes mod id and path equal to s
     */
    public static Identifier id(String s) {
        return new Identifier(MOD_ID, s);
    }
}