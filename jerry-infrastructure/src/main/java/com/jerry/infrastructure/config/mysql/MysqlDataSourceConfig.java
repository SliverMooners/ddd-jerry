package com.jerry.infrastructure.config.mysql;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fanc
 * @date 2021/9/18 2:46 下午
 * 遇到的问题: 1. 配置文件后缀: url ---> jdbc-url
 *           2. 别忘记引入: starter-aop
 *           3. 启动类上添加MapperScan
 *           4. 一般引用相关组件直接添加stater即可
 *           5. 扫描配置文件mybatis.config-location=classpath:mybatis/mybatis-config.xml
 * @Description
 */
@Slf4j
@Configuration
public class MysqlDataSourceConfig {

    @Bean("dataSourceFirst")
    @ConfigurationProperties(prefix = "spring.datasource.fanc1")
    DataSource dataSourceFirst() {
        log.info("create fanc1 datasource...");
        return DataSourceBuilder.create().build();
    }

    @Bean("dataSourceSecond")
    @ConfigurationProperties(prefix = "spring.datasource.fanc2")
    DataSource dataSourceSecond() {
        log.info("create fanc2 datasource...");
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    DataSource primaryDataSource(
            @Autowired @Qualifier("dataSourceSecond") DataSource dataSourceSecond,
            @Autowired @Qualifier("dataSourceFirst") DataSource dataSourceFirst
    ) {
        log.info("create routing datasource...");
        Map<Object, Object> map = new HashMap<>(5);
        map.put("dataSourceFirst", dataSourceFirst);
        map.put("dataSourceSecond", dataSourceSecond);
        RoutingDataSource routing = new RoutingDataSource();
        routing.setTargetDataSources(map);
        routing.setDefaultTargetDataSource(dataSourceFirst);
        return routing;
    }

}
