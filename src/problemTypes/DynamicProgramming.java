package problemTypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface DynamicProgramming {
    int dimension() default 1;
}
