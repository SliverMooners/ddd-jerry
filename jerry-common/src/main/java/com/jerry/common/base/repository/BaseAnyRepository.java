package com.jerry.common.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.QueryByExampleExecutor;

/**
 * 任意类型的仓储接口的统一接口。
 * @author jerry
 * @param <T> 实体类型参数。
 */
@NoRepositoryBean
public interface BaseAnyRepository<T>
        extends JpaRepository<T, String>, JpaSpecificationExecutor<T>, QueryByExampleExecutor<T> {
}
