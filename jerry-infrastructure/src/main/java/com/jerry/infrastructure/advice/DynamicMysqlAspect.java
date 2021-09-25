package com.jerry.infrastructure.advice;

import com.jerry.infrastructure.config.mysql.DynamicMysqlAnnotation;
import com.jerry.infrastructure.config.mysql.RoutingDataSourceContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author fanc
 * @date 2021/9/18 3:24 下午
 * @Description
 */
@Aspect
@Component
public class DynamicMysqlAspect {

    @Around("@annotation(dynamicMysqlAnnotation)")
    public Object routingWithDataSource(ProceedingJoinPoint joinPoint, DynamicMysqlAnnotation dynamicMysqlAnnotation) throws Throwable {
        String key = dynamicMysqlAnnotation.value();
        try (RoutingDataSourceContext ctx = new RoutingDataSourceContext(key)) {
            return joinPoint.proceed();
        }
    }
}
