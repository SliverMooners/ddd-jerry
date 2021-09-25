package com.jerry.jerryinterfaces.facade;

import com.alibaba.fastjson.JSON;
import com.jerry.api.dto.jerry.TomDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fanc
 * @date 2021/9/22 5:16 下午
 * @Description
 */
@RequestMapping("/redis")
@RestController
public class RedisTemplateFaced {

    @Autowired
    RedisTemplate redisTemplate;


    @GetMapping("/get")
    public String getRedisStr(@RequestParam("key") String key){
        Object o = redisTemplate.opsForValue().get(key);
        return JSON.parseObject(o.toString(),TomDto.class).getName();
    }

    @GetMapping("/set")
    public String setRedisStr(@RequestParam("key") String key){
        TomDto jerryDto = new TomDto();
        jerryDto.setName("我是名称");
        redisTemplate.opsForValue().set(key,JSON.toJSONString(jerryDto));
        return "添加成功";
    }

}