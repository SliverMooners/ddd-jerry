package com.jerry.infrastructure.jerry;

import com.jerry.common.base.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * @author fanc
 * @date 2021/9/7 7:16 下午
 * @Description
 */
@Data
public class TomDo extends BaseEntity {
    /**
     * 名称
     */
    @Column(name = "name")
    @Size(max = 40)
    private String name;

}
