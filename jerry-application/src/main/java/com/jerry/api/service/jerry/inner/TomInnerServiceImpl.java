package com.jerry.api.service.jerry.inner;

import com.jerry.api.dto.jerry.JerryDto;
import com.jerry.api.dto.jerry.TomQueryByIdCommand;
import com.jerry.api.service.TomInnerService;
import com.jerry.common.base.resp.RespBody;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author fanc
 * @date 2021/9/17 6:58 下午
 * @Description
 */
@Service(group = "jerry",version = "1.0.0", timeout = 500)
public class TomInnerServiceImpl implements TomInnerService {

    @Autowired
    TomInnerManager jerryQueryManager;

    @Override
    public RespBody<JerryDto> getById(TomQueryByIdCommand jerryQueryByIdCommand) {
        return RespBody.ok(jerryQueryManager.getById(jerryQueryByIdCommand));
    }
}
