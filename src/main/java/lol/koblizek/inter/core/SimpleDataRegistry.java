package lol.koblizek.inter.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleDataRegistry<T extends Identifiable> extends Registry<T> {

    private final Map<Key, T> entries;
    private boolean frozen;

    SimpleDataRegistry() {
        entries = new HashMap<>();
        frozen = false;
    }

    @Override
    void register(T entry) {
        entries.put(entry.getKey(), entry);
    }

    @Override
    void freeze() {
        frozen = true;
    }

    @Override
    boolean isFrozen() {
        return frozen;
    }

    @Override
    T get(Key key) {
        return entries.get(key);
    }
}
