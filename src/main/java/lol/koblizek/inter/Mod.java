package lol.koblizek.inter;

import java.nio.file.Path;

/**
 * Represents the simplest form of mod or plugin.
 * <p>
 *     A mod is a collection of code that modifies the game in some way.
 *     These mods can be loaded and unloaded at runtime.
 * </p>
 * A simple mod can look like this:
 * <pre>{@code
 *     public class MyMod extends Mod {
 *         @Override
 *         public void onEnable() {
 *             getInter().getSystemLogger().info("Hello, world!");
 *         }
 *     }
 * }</pre>
 * <p>
 *     This api may look pretty similar to Bukkit's.
 * </p>
 */
public abstract class Mod {
    public void onEnable() {}
    public void onDisable() {}

    public final Inter getInter() {
        return Inter.getInstance();
    }


    public final Metadata getMetadata() {
        return getInter().getMetadata(this);
    }

    public final Path getDataDirectory() {
        return getInter().getConfigDirectory().resolve(getMetadata().name + "/");
    }

    public record Metadata(String name,
                           String pluginVersion,
                           String gameApi,
                           String description,
                           String author,
                           String entryClass) {
    }
}
