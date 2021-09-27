package com.jerry.api.service;

import com.jerry.api.dto.jerry.JerryDto;
import com.jerry.api.dto.jerry.TomQueryByIdCommand;
import com.jerry.common.base.resp.RespBody;

/**
 * @author fanc
 * @date 2021/9/17 5:42 下午
 * @Description
 */
public interface TomInnerService {

    RespBody<JerryDto> getById(TomQueryByIdCommand jerryQueryByIdCommand);

}
