package com.jerry.common.base.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 批量启用/停用 Repository 的接口。（需要启用/停用的 Repository 应继承该接口，且确保实体里的启用字段名称为 isEnable）
 */
@NoRepositoryBean
public interface BatchEnableRepository {
    /**
     * 批量启用。
     *
     * @param ids 需要批量启用的实体主键数组。
     * @param currentUserId 当前用户的主键。
     */
    @Modifying
    @Query("update #{#entityName} t set t.isEnable = 1, t.ts = ?3, t.modifier = ?2, t.modifiedTime = ?3 " +
            "where t.dr = 0 and t.id in ?1")
    @Transactional(rollbackFor = Exception.class)
    void batchEnable(String[] ids, String currentUserId, Date date);

    /**
     * 批量停用。
     *
     * @param ids 需要批量停用的实体主键数组。
     * @param currentUserId 当前用户的主键。
     */
    @Modifying
    @Query("update #{#entityName} t set t.isEnable = 2, t.ts = ?3, t.modifier = ?2, t.modifiedTime = ?3 " +
            "where t.dr = 0 and t.id in ?1")
    @Transactional(rollbackFor = Exception.class)
    void batchDisable(String[] ids, String currentUserId, Date date);
}
