package lol.koblizek.inter.api;

import java.lang.annotation.*;

/**
 * Indicates that the annotated element is only available in the specified {@link Environment}
 * or {@link MetaLoader}.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD,
        ElementType.MODULE, ElementType.PACKAGE})
@Documented
public @interface OnlyIn {
    Environment side() default Environment.BOTH;
    MetaLoader loader() default MetaLoader.ALL;
}
