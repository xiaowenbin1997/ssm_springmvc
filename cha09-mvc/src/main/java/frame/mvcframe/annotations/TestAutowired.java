package frame.mvcframe.annotations;

import java.lang.annotation.*;

/**
 * @author xwb
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TestAutowired {
    String value() default "";
}
