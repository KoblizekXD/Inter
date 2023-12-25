package lol.koblizek.inter;

import lol.koblizek.inter.api.*;
import lol.koblizek.inter.client.AbstractClient;
import lol.koblizek.inter.event.EventManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

@API(since = InterVersion.V_1_0)
public abstract class Inter {

    private static final Logger SYSTEM_LOGGER
            = LoggerFactory.getLogger("Inter API");
    private EventManager eventManager;
    private static Inter instance;

    /**
     * Returns the configured instance of Inter.
     * Instance is configured <b>automatically</b>.
     *
     * @return Inter instance
     */
    public static Inter getInstance() {
        return instance;
    }

    /**
     * Sets the Inter API implementation. This is done automatically,
     * and any other calls of this method will throw an exception.
     *
     * @param i Inter implementation
     * @throws IllegalStateException if the instance is already set
     */
    public static void setInstance(Inter i) {
        if (instance == null) {
            instance = i;
            instance.eventManager = new EventManager();
        } else throw new IllegalStateException("Inter instance is already set");
    }

    public static Logger getSystemLogger() {
        return SYSTEM_LOGGER;
    }

    /**
     * Returns the instance of the EventManager, which is used to register/invoke events.
     * @return EventManager instance
     */
    public EventManager getEventManager() {
        return eventManager;
    }

    /**
     * @return Type of the environment currently running
     */
    public abstract Environment getEnvironment();

    /**
     * @return Minecraft version
     */
    public abstract MinecraftVersion getMinecraftVersion();

    /**
     * @return Version of the Inter API
     */
    public abstract InterVersion getInterVersion();

    /**
     * @return MetaLoader instance
     */
    public abstract MetaLoader getMetaLoader();

    public Path getInterDirectory() {
        return new File("inter/").toPath();
    }

    public Path getPluginDirectory() {
        return getInterDirectory().resolve("plugins/");
    }

    public Path getConfigDirectory() {
        return getInterDirectory().resolve("config/");
    }

    public abstract List<Mod> getPlugins();
    public abstract Mod.Metadata getMetadata(Mod mod);

    public void checkEnvironment(Environment required) {
        if (getEnvironment() != Environment.BOTH || required != getEnvironment()) {
            getSystemLogger().warn("Plugin has attempted to invoke a call that is not supported in current environment");
            getSystemLogger().warn("Required: " + required + ", current: " + getEnvironment());
        }
    }

    /**
     * Returns the client-side API used to interact with the client in various ways,
     * such as:
     * <ul>
     *     <li>Rendering</li>
     *     <li>Input</li>
     *     <li>GUI/Overlays</li>
     * </ul>
     * This method is only available to in the client environment, any calls to this method
     * in the server environment will return null.
     * @return Instance of the client-side API
     */
    @OnlyIn(side = Environment.CLIENT)
    public abstract AbstractClient getClient();
}
