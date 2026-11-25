package com.wealth.common.model.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.repository.NoRepositoryBean;

import com.wealth.common.model.dto.system.SysLookupDTO;
import com.wealth.common.model.entity.GenericEntity;
import com.wealth.common.model.entity.PagedResult;
import com.wealth.common.model.entity.system.SysBankEntity;
@NoRepositoryBean
public interface IfGenericDao<T> {
    T findById(int id);
    List<T> findAll();// done
    int deleteById(int id);
    int hardDeleteById(int id);
    int hardDeleteByKeyValue(T entity, String key, Object value);
    public <T extends GenericEntity> T updateWithOutChanges(T entity) ;
    public <T extends GenericEntity> T saveWithOutChanges(T entity) ;
    public List<T> findByFieldsSearch(T filterObj); //done
    public List<T> findByFields(T filterObj) ;
	List<T> findByIds(List<Integer> ids);
	<T extends GenericEntity> T update(T savedUser);
	List<T> findByFieldsList(List<T> filterList);
	 public <T extends GenericEntity> T save(T entity) ;
	 public <T extends GenericEntity> List<T> saveAll(List<T> entities) ;
	 public <T extends GenericEntity> List<T> updateAll(List<T> entities) ;
	 public <T extends GenericEntity> List<T> updateAllWithChanges(List<T> entities) ;
	 public Long resolveUserIdFromCode() ;
	 PagedResult<T> findAll(int pageNumber, int pageSize);
	 PagedResult<T> findByFieldsSearch(T filterObj, int pageNumber, int pageSize);
	 PagedResult<T> findByFieldsList(List<T> filterList, int pageNumber, int pageSize);
	 PagedResult<T> findByIds(List<Integer> ids, int pageNumber, int pageSize);
	 PagedResult<T> findByFields(T filterObj, int pageNumber, int pageSize);
	 public Long getNextId();
	 public Long getNextId(String fieldName);
	 T saveOrUpdateByKeyValue(T entity, String key, Object value);
	 <T extends GenericEntity> T saveForWorkflow(T entity);
	 <T extends GenericEntity> List<T> saveAllForWorkflow(List<T> entities);
	 <T extends GenericEntity> List<T> saveAllForWorkflowWithoutChanges(List<T> entities);
	 <T extends GenericEntity> List<T> saveAllWithOutChanges(List<T> entities);
	 T saveOrUpdateByKeyValue(T entity, Map<String, Object> keyValues);
	<T extends GenericEntity> List<T> updateAllForWorkflow(List<T> entities);
	<T extends GenericEntity> T updateForWorkflow(T entity);
	public Long getCurrentSequence();//nk
	<T extends GenericEntity> T saveWithCustomAudit(T entity);
	<T extends GenericEntity> T updateWithCustomAudit(T entity);
	int hardDeleteWorkflowByWkfId(int wkfId);
	<T extends GenericEntity> T saveForWkfCustomAudit(T entity);


	<T extends GenericEntity> T saveWithChanges(T entity);
	<T extends GenericEntity> List<T> saveAllForWorkflow1(List<T> entities);
	

}
