package lol.koblizek.inter.client.event;

import lol.koblizek.inter.Inter;
import lol.koblizek.inter.client.AbstractClient;
import lol.koblizek.inter.event.Event;

/**
 * Common base class for all client events.
 */
public class ClientEvent extends Event {
    private final AbstractClient client;

    public ClientEvent() {
        client = Inter.getInstance().getClient();
    }

    /**
     * Gets the client instance, won't be null.
     * @return The client instance.
     */
    public AbstractClient getClient() {
        return client;
    }
}
