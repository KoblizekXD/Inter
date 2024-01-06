package lol.koblizek.inter.core;

public abstract class Registry<T extends Identifiable> {

    static <E extends Identifiable> void register(Registry<E> registry, E entry) {
        registry.register(entry);
    }

    abstract void register(T entry);
}
