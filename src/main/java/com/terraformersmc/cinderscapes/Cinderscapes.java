package com.terraformersmc.cinderscapes;

import com.terraformersmc.cinderscapes.init.*;
import com.terraformersmc.cinderscapes.command.MapBiomesCommand;
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
        CinderscapesBiomes.init();
        CinderscapesGroups.init();

        // TODO: Move to Terraform
        LogManager.getLogger("Terraform").info("Fabric biome mods! Assemble!");
        LogManager.getLogger("Terrestria").info("I am Terrestria with the power of vibrant and enhanced biomes that are out of this world!");
        LogManager.getLogger("Traverse").info("I am Traverse with the power of intriguing and mysterious biomes that mimic the vanilla feel!");
        LogManager.getLogger("Cinderscapes").info("I am Cinderscapes with the power of frighteningly beautiful nether biomes that surpass even the nether update itself!");
        LogManager.getLogger("Campanion").info("I am Campanion with the power of immersive and expansive blocks and items to enhance the vanilla exploration experience!");
        LogManager.getLogger("Terraform").info("And with our powers combined we are the biome mods of the fabric mod loader, with powers vastly superior to that of the biome mods of the other mod loader that should not be named!");

        MapBiomesCommand.register();
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