package com.jerry.infrastructure.config.mysql;

/**
 * @author fanc
 * @date 2021/9/18 3:05 下午
 * @Description
 */
public class RoutingDataSourceContext implements AutoCloseable {

    static final ThreadLocal<String> THREAD_LOCAL_DATA_SOURCE_KEY = new ThreadLocal<>();

    public static String getDataSourceRoutingKey() {
        String key = THREAD_LOCAL_DATA_SOURCE_KEY.get();
        return key == null ? "dataSourceSecond" : key;
    }

    public RoutingDataSourceContext(String key) {
        THREAD_LOCAL_DATA_SOURCE_KEY.set(key);
    }

    @Override
    public void close() {
        THREAD_LOCAL_DATA_SOURCE_KEY.remove();
    }
}
