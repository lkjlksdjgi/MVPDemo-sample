package com.siw.basemvp.utils.aop;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SingleClick {
    //禁止多次点击的间隔时间，默认600毫秒
    int intervalTime() default 600;
}
