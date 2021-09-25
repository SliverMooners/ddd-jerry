package com.jerry.infrastructure.jerry;

import com.jerry.common.utils.BeanCopyUtils;
import com.jerry.domain.jerry.Tom;
import com.jerry.domain.jerry.repository.TomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author fanc
 * @date 2021/9/17 8:22 下午
 * @Description
 */
@Component
public class TomRepositoryImpl implements TomRepository {

    @Autowired
    private TomMapper jerryMapper;

    @Override
    public Tom getById(String id) {
        TomDo jerryDo = jerryMapper.getById(id);
        return BeanCopyUtils.convert(jerryDo,Tom.class);
    }

}
