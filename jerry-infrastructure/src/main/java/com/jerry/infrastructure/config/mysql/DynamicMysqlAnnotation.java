package com.jerry.infrastructure.config.mysql;

import java.lang.annotation.*;

/**
 * @author fanc
 * @date 2021/9/18 3:23 下午
 * @Description
 */
@Retention(RetentionPolicy.RUNTIME) //在运行时可以获取
@Target({ ElementType.TYPE, ElementType.METHOD}) //作用到类，方法，接口上等
@Inherited //子类会继承
public @interface DynamicMysqlAnnotation {

    String value() default "dataSourceSecond";

}
