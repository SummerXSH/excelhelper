package com.summer.excelhelper.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates what you want  mapping from excel to java object. You can use at class , set method or field.
 *
 * @author xiashanhao
 * @date 2019-04-30 15:49
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface ImportField {

    /**
     * @return an index value, the index will decide from where to get value
     */
    int index() default 0;
}
