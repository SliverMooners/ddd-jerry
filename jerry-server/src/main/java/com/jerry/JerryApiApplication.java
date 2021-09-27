package com.jerry;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

/**
 * @author jerry
 */
@Slf4j
@EnableDubbo(scanBasePackages = "com.tom.api.service")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class JerryApiApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(JerryApiApplication.class, args);
        printBeans(ctx);
    }
    public static void printBeans(ApplicationContext ctx) {
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            if (beanName.contains("omRepository")) {
                log.info("beanName: {}", beanName);
            }
        }
    }
}
