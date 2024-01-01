package lol.koblizek.inter.client.event;

import lol.koblizek.inter.Inter;
import lol.koblizek.inter.client.AbstractClient;
import lol.koblizek.inter.event.Event;

public class ClientEvent extends Event {
    private final AbstractClient client;

    public ClientEvent() {
        client = Inter.getInstance().getClient();
    }

    public AbstractClient getClient() {
        return client;
    }
}
