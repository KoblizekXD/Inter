package lol.koblizek.inter.event;

/**
 * Represents a hook that can be called when an event is fired
 * <p>
 *     Hooks are called in order of their priority, from highest to lowest.
 *     If a hook returns {@link TypedResult#CANCEL}, the event will not be
 *     passed to any more hooks.
 * </p>
 * @param <E> Type of event
 */
@FunctionalInterface
public interface Hook<E extends Event> {
    TypedResult call(E event);

    /**
     * Represents a result of a hook call.
     * <p>
     *     If a hook returns {@link TypedResult#CANCEL}, the event will not be passed to any more hooks.
     * </p>
     */
    enum TypedResult {
        PASS,
        CANCEL
    }

    /**
     * Represents a priority of a hook, which determines the order in which hooks are called.
     */
    enum Priority {
        HIGHEST,
        HIGH,
        NORMAL;
    }

    class Info {
        private final Hook hook;
        private final Priority priority;

        public Info(Hook h, Priority p) {
            hook = h;
            priority = p;
        }

        public Hook getHook() {
            return hook;
        }

        public Priority getPriority() {
            return priority;
        }
    }
}
