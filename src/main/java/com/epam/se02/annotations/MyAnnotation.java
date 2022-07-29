package com.epam.se02.annotations;

import java.lang.annotation.*;

@Documented
@Target(value = {ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String param() default "123";
}
