package com.jerry.infrastructure.config;

import com.jerry.common.utils.SpringEnvHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 全局支持性配置
 * 通常在这里配置一些数据库的底层支持,常用基本配置,工具类, 第三方库类支持
 */
@Configuration
public class GlobalSupportConfig {


    /**
     * Spring环境工具类Bean
     */
    @Bean
    public SpringEnvHelper springEnvHelper() {
        return new SpringEnvHelper();
    }
}
