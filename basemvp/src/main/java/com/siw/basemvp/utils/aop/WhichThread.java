package com.siw.basemvp.utils.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface WhichThread {
    WhichThreadEnum thread() default WhichThreadEnum.IO;

    public enum WhichThreadEnum{
        IO,MainThread,NewThread,Single
    }
}
