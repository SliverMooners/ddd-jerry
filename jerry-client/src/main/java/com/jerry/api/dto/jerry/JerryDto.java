package com.jerry.api.dto.jerry;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fanc
 * @date 2021/9/17 5:44 下午
 * @Description
 */
@Data
public class JerryDto implements Serializable {
    private static final long serialVersionUID = -3048491701622546551L;
    
    private String name;
}
