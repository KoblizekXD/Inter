package lol.koblizek.inter.api;

/**
 * Represents the side of the class.
 */
public enum Environment {
    CLIENT(true, false),
    SERVER(false, true),
    BOTH(true, true);

    private final boolean client;
    private final boolean server;

    Environment(boolean client, boolean server) {
        this.client = client;
        this.server = server;
    }

    public boolean isClient() {
        return client;
    }

    public boolean isServer() {
        return server;
    }
}
