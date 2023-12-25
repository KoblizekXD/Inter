package lol.koblizek.inter.util;

import lol.koblizek.inter.Inter;
import lol.koblizek.inter.api.API;

public final class Reflect {

    public static API getApiInstanceForType(Class<?> type) {
        if (type.isAnnotationPresent(API.class)) {
            return type.getAnnotation(API.class);
        } else {
            Inter.getSystemLogger().warn("Class {} is not annotated with @API!", type.getSimpleName());
            return null;
        }
    }
}
