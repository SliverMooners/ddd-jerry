package com.jerry.common.base.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

/**
 * 原生sql仓储接口的统一接口
 * @author jerry
 */
@Slf4j
public class BaseNativeRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Modifying
	public void executeUpdate(String sql) {
		try {
			Query query = entityManager.createNativeQuery(sql);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
	}


	@SuppressWarnings("unchecked")
	public List<Object[]> queryList(String sql) {
		List<Object[]> resultList = null;
		try {
			Query querys = entityManager.createNativeQuery(sql);
			resultList = querys.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		return resultList;
	}

	@SuppressWarnings("unchecked")
	public List<String> queryStringList(String sql) {
		List<String> resultList = null;
		try {
			Query querys = entityManager.createNativeQuery(sql);
			resultList = querys.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		return resultList;
	}


	public int queryForInt(String sql) {
		int ret = -1;
		try {
			Query query = entityManager.createNativeQuery(sql);
			BigDecimal count = (BigDecimal) query.getSingleResult();
			ret = count.intValue();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		return ret;
	}


	public String queryForString(String sql) {
		String ret = null;
		try {
			Query querys = entityManager.createNativeQuery(sql);
			ret = (String) querys.getSingleResult();
		} catch (Exception e) {
			log.info(e.getMessage());
			//e.printStackTrace();
		} finally {
			entityManager.close();
		}
		return ret;
	}

	public Object queryForObject(String sql) {
		Object ret = null;
		try {
			Query querys = entityManager.createNativeQuery(sql);
			ret = querys.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		return ret;
	}
}
