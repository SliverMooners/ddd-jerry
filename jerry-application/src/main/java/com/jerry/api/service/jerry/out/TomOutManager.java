package com.jerry.api.service.jerry.out;

import com.jerry.api.dto.TomCommend;
import com.jerry.api.dto.jerry.TomDto;
import com.jerry.domain.jerry.Tom;
import com.jerry.domain.jerry.repository.TomRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author fanc 相当于聚合一层
 */
@Component
public class TomOutManager {

    @Autowired
    TomRepository jerryRepository;

    public TomDto getById (TomCommend jerryCommend){
        Tom jerry = jerryRepository.getById(jerryCommend.getId());
        TomDto dto = new TomDto();
        BeanUtils.copyProperties(jerry,dto);
        return dto;
    }

}
