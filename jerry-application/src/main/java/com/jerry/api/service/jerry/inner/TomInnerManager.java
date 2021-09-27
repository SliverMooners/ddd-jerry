package com.jerry.api.service.jerry.inner;

import com.jerry.api.dto.jerry.JerryDto;
import com.jerry.api.dto.jerry.TomQueryByIdCommand;
import com.jerry.common.utils.BeanCopyUtils;
import com.jerry.domain.jerry.Tom;
import com.jerry.domain.jerry.repository.TomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author fanc 相当于聚合一层
 */
@Component
public class TomInnerManager {

    @Autowired
    TomRepository jerryRepository;

    public JerryDto getById (TomQueryByIdCommand jerryQueryByIdCommand){
        Tom jerry = jerryRepository.getById(jerryQueryByIdCommand.getId());
        return BeanCopyUtils.convert(jerry, JerryDto.class);
    }

}
