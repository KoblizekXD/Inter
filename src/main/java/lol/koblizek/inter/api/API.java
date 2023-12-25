package lol.koblizek.inter.api;

import java.lang.annotation.*;

/**
 * Marking a class, method etc. can tell you which version it was added in.
 * This way, you can check if the class is supported by your game version.
 * Calling method which is not supported by your game version will log a warning and
 * the method won't be invoked or/and will return null.<br><br>
 * Please note that this annotation is not checked at runtime, and is only used for documentation,
 * all the checks are done in the subsequent implementations.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD,
        ElementType.MODULE, ElementType.PACKAGE, ElementType.FIELD})
@Documented
public @interface API {
    InterVersion since() default InterVersion.DEFAULT;
    MinecraftVersion sinceGame() default MinecraftVersion.DEFAULT;
}
