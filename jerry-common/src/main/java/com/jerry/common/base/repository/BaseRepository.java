package com.jerry.common.base.repository;

import com.jerry.common.base.entity.BaseEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Date;
import java.util.List;

/**
 * 仓储接口的统一接口。
 *
 * @author jerry
 * @param <T> 实体类型参数。
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends BaseAnyRepository<T> {
    /**
     * 通过主键数组获取实体。
     *
     * @param ids 主键数组。
     * @return 实体列表。
     */
    @Query("select t from #{#entityName} t where t.dr = 0 and t.id in ?1")
    List<T> findByIdIn(String[] ids);

    /**
     * 获取指定主键的实体。
     *
     * @param id 主键
     * @return 指定主键的实体
     */
    @Query("select t from #{#entityName} t where t.dr = 0 and t.id = ?1")
    T findOne(String id);

    /**
     * 获取指定主键和时间戳的实体数量。
     *
     * @param id 主键
     * @param ts 时间戳
     * @return 指定主键和时间戳的实体数量
     */
    @Query("select count(t) from #{#entityName} t where t.dr = 0 and t.id = ?1 and t.ts <= ?2")
    long countByIdAndTs(String id, Date ts);
}
