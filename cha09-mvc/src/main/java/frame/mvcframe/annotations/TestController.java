package frame.mvcframe.annotations;

import java.lang.annotation.*;

/**
 * @author xwb
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TestController {
    String value() default "";
}
