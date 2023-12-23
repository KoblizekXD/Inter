package lol.koblizek.inter.event;

import java.util.*;

public final class EventManager {

    private static boolean isInit = false;

    private Map<Class<?>, List<Hook.Info>> hooks;

    public EventManager() {
        if (isInit) {
            throw new IllegalStateException("EventManager is already initialized");
        } else {
            isInit = true;
            hooks = new HashMap<>();
        }
    }

    public <E extends Event> void addHook(Class<E> e, Hook<E> hook) {
        hooks.putIfAbsent(e, new ArrayList<>());
        hooks.get(e).add(new Hook.Info(hook, Hook.Priority.NORMAL));
        hooks.get(e).sort(Comparator.comparing(Hook.Info::getPriority));
    }

    public <E extends Event> void addHook(Class<E> e, Hook<E> hook, Hook.Priority priority) {
        hooks.putIfAbsent(e, new ArrayList<>());
        hooks.get(e).add(new Hook.Info(hook, priority));
        hooks.get(e).sort(Comparator.comparing(Hook.Info::getPriority));
    }

    public void invoke(Event e) {
        for (Hook.Info info : hooks.getOrDefault(e.getClass(), new ArrayList<>())) {
            if (info.getHook().call(e) == Hook.TypedResult.CANCEL) {
                break;
            }
        }
    }
}
