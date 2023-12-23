package lol.koblizek.inter;

import lol.koblizek.inter.api.API;
import lol.koblizek.inter.api.InterVersion;
import lol.koblizek.inter.event.EventManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
}
