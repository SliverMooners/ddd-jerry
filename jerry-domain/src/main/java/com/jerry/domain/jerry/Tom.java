package com.jerry.domain.jerry;

import com.jerry.common.base.error.BusinessException;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @author fanc
 * @date 2021/9/7 7:16 下午
 * @Description
 */
@Data
public class Tom {

    private String name;

    public static void checkLength(String name) {
        if (StringUtils.isBlank(name) || name.length() > 40) {
            throw new BusinessException("500","名称过长");
        }
    }
}
