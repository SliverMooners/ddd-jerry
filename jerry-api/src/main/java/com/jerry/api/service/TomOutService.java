package com.jerry.api.service;

import com.jerry.api.dto.JerryCommend;
import com.jerry.common.base.resp.RespBody;

/**
 * @author fanc
 * @date 2021/9/14 10:45 下午
 * @Description
 */
public interface TomOutService {

    RespBody<String> getName(JerryCommend jerryCommend);

}
