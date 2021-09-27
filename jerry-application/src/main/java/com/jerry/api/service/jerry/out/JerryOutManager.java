package com.jerry.api.service.jerry.out;

import com.jerry.api.dto.JerryCommend;
import com.tom.api.dto.TomCommend;
import com.tom.api.service.TomOutService;
import com.tom.common.base.resp.RespBody;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;


/**
 * @author fanc 相当于聚合一层
 */
@Component("jerryOutManager")
public class JerryOutManager {

    @DubboReference(version = "1.0.0",check = false)
    TomOutService tomOutService;

    public String getById (JerryCommend jerryCommend){
        TomCommend tomCommend = new TomCommend();
        tomCommend.setId(jerryCommend.getId());
        RespBody<String> tomResp = tomOutService.getName(tomCommend);
        return tomResp.getBody();
    }

}
