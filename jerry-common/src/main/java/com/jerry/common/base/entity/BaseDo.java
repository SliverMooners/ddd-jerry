package com.jerry.common.base.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author fanc
 * @date 2021/9/15 5:25 下午
 * @Description
 */
@Data
public class  BaseDo {
    protected String id;
    protected Integer dr = 0;
    protected Date ts;
    protected String creator;
    protected Date creationTime;
    protected String modifier;
    protected Date modifiedTime;
}
