package com.siw.basemvp.utils.aop;

import com.siw.basemvp.utils.PermissionUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {

    /**
     * @return 权限组的String数组，这里传入的是一个权限组数组，详细传参如{PermissionGroup.STORAGE,PermissionGroup.CALENDAR},基本上这里传一个就好，更多参数请看{@link PermissionUtils.PermissionGroup}
     */
    String[] value() ;

    int requestCode() default 999;
}
