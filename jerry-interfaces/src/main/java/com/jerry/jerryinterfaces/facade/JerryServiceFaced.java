package com.jerry.jerryinterfaces.facade;

import com.jerry.api.dto.JerryCommend;
import com.jerry.api.service.TomOutService;
import com.jerry.api.service.TomInnerService;
import com.jerry.api.dto.jerry.JerryDto;
import com.jerry.api.dto.jerry.TomQueryByIdCommand;
import com.jerry.api.service.jerry.out.JerryOutManager;
import com.jerry.common.base.resp.RespBody;
import com.jerry.infrastructure.config.mysql.DynamicMysqlAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author fanc
 * @date 2021/9/9 11:12 上午
 * @Description
 */
@RequestMapping("/jerry")
@RestController
public class JerryServiceFaced {

    @Resource
    private JerryOutManager jerryOutManager;

    @GetMapping("/get")
    public RespBody<String> getById(@RequestParam("id") String id){
        JerryCommend jerryCommend = new JerryCommend();
        jerryCommend.setId(id);
        return RespBody.ok(jerryOutManager.getById(jerryCommend));
    }

}
