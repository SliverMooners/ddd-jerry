package com.jerry.jerryinterfaces.facade;

import com.jerry.api.dto.TomCommend;
import com.jerry.api.service.TomOutService;
import com.jerry.api.service.TomInnerService;
import com.jerry.api.dto.jerry.TomDto;
import com.jerry.api.dto.jerry.TomQueryByIdCommand;
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
public class TomInnerServiceFaced {

    private final static Logger logger = LoggerFactory.getLogger(TomInnerServiceFaced.class);

    @Resource
    private TomInnerService jerryInnerService;

    @Resource
    private TomOutService jerryOutService;

    @DynamicMysqlAnnotation("dataSourceFirst")
    @GetMapping("/get")
    public RespBody<TomDto> getById(@RequestParam("id") String id){
        TomQueryByIdCommand jerryInnerCommand = new TomQueryByIdCommand();
        jerryInnerCommand.setId(id);
        logger.info("测试日志: {}", id);
        return jerryInnerService.getById(jerryInnerCommand);
    }

    @DynamicMysqlAnnotation
    @GetMapping("/out")
    public RespBody<String> getOutById(@RequestParam("id") String id){
        TomCommend commend = new TomCommend();
        commend.setId(id);
        return jerryOutService.getName(commend);
    }
}
