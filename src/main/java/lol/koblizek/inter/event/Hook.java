package lol.koblizek.inter.event;

@FunctionalInterface
public interface Hook<E extends Event> {
    TypedResult call(E event);

    enum TypedResult {
        PASS,
        CANCEL
    }

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
