package lol.koblizek.inter.event;

import java.util.*;

public final class EventManager {

    private static boolean isInit = false;

    private final Map<Class<?>, List<Hook.Info>> hooks;

    public EventManager() {
        if (isInit) {
            throw new IllegalStateException("EventManager is already initialized");
        } else {
            isInit = true;
            hooks = new HashMap<>();
        }
    }

    /**
     * Adds a hook to hook listing with default {@link Hook.Priority}
     *
     * @param e Event class
     * @param hook Hook to be added
     * @param <E> Event type
     * @see #addHook(Class, Hook, Hook.Priority)
     */
    public <E extends Event> void addHook(Class<E> e, Hook<E> hook) {
        hooks.putIfAbsent(e, new ArrayList<>());
        hooks.get(e).add(new Hook.Info(hook, Hook.Priority.NORMAL));
        hooks.get(e).sort(Comparator.comparing(Hook.Info::getPriority));
    }

    /**
     * Adds a hook to hook listing with custom {@link Hook.Priority}
     *
     * @param e Event class
     * @param hook Hook to be added
     * @param priority Priority of the hook
     * @param <E> Event type
     * @see #addHook(Class, Hook)
     * @see Hook.Priority
     */
    public <E extends Event> void addHook(Class<E> e, Hook<E> hook, Hook.Priority priority) {
        hooks.putIfAbsent(e, new ArrayList<>());
        hooks.get(e).add(new Hook.Info(hook, priority));
        hooks.get(e).sort(Comparator.comparing(Hook.Info::getPriority));
    }

    /**
     * Invokes all hooks for the given event.
     *
     * @param e Instance of the event to be invoked
     */
    public void invoke(Event e) {
        for (Hook.Info info : hooks.getOrDefault(e.getClass(), new ArrayList<>())) {
            if (info.getHook().call(e) == Hook.TypedResult.CANCEL) {
                break;
            }
        }
    }
}
