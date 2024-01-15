package lol.koblizek.inter.core;

import lol.koblizek.inter.Inter;

public abstract class Registry<T extends Identifiable> {

    static <E extends Identifiable> void register(Registry<E> registry, E entry) {
        if (!registry.isFrozen())
            registry.register(entry);
        else
            Inter.getSystemLogger().error("Cannot register {} after registry is frozen", entry.getKey().getResource());
    }

    abstract void register(T entry);
    abstract void freeze();
    abstract boolean isFrozen();
    abstract T get(Key key);
}
