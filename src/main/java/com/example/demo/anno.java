package com.example.demo;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE ;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * @Author: Evan Yang
 * @Description:
 * @Date: Create in 18:49 2018/7/6
 * @Modificd By:
 * @Param
 */


@Target(TYPE )
@Retention(SOURCE)
@Documented
public @interface anno {
    String value() default "";
}
