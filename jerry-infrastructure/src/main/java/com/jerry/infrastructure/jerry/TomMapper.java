package com.jerry.infrastructure.jerry;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author fanc
 */
@Mapper
public interface TomMapper {

  public TomDo getById(String cusjerryerId);
}
