package com.jerry.common.utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author fanc
 */
@Slf4j
public class BeanCopyUtils {

    /**
     * 单个类转换
     *
     * @param sourceObj
     * @param targetClass
     * @param <T>
     * @return
     */
    public static <T> T convert(Object sourceObj, Class<T> targetClass) {
        T targetObj = null;
        try {
            targetObj = targetClass.newInstance();
        } catch (InstantiationException e) {
            log.error("sourceObj:{},targetClass:{},InstantiationException errMsg:{}", sourceObj, targetClass, e);
        } catch (IllegalAccessException e) {
            log.error("sourceObj:{},targetClass:{},IllegalAccessException errMsg:{}", sourceObj, targetClass, e);
        }
        if (sourceObj != null) {
            BeanUtils.copyProperties(sourceObj, targetObj);
        }
        return targetObj;
    }

    /**
     * List之间转换
     *
     * @param sourceList
     * @param targetClass
     * @param <T>
     * @return
     */
    public static <T> List<T> convertList(List<?> sourceList, Class<T> targetClass) {
        if (CollectionUtils.isEmpty(sourceList) || targetClass == null) {
            return Collections.emptyList();
        }
        return sourceList.stream().map(sourceObj -> convert(sourceObj, targetClass)).collect(Collectors.toList());
    }
}