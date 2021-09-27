package com.jerry.api.service.jerry.out;

import com.jerry.api.dto.JerryCommend;
import com.jerry.api.service.TomOutService;
import com.jerry.common.base.resp.RespBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fanc
 * @date 2021/9/18 10:46 上午
 * @Description
 */
@Service
public class TomOutServiceImpl implements TomOutService {

    @Autowired
    JerryOutManager jerryOutManager;

    @Override
    public RespBody<String> getName(JerryCommend jerryCommend) {
        return RespBody.ok(jerryOutManager.getById(jerryCommend));
    }
}
