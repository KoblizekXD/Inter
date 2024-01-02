package lol.koblizek.inter.core;

/**
 * Represents a resource key.
 * Can be used to identify items, blocks, etc.
 * <p>
 *     It's value is used to represent identifier, such as "minecraft:stone".
 * </p>
 */
public final class Key {
    private final String namespace;
    private final String name;
    private final String resource;

    public Key(String namespace, String name) {
        this.namespace = namespace;
        this.name = name;
        this.resource = namespace + ":" + name;
    }

    public Key(String resource) {
        this.namespace = resource.split(":")[0];
        this.name = resource.split(":")[1];
        this.resource = resource;
    }

    public String getNamespace() {
        return namespace;
    }

    public String getName() {
        return name;
    }

    public String getResource() {
        return resource;
    }
}
