package com.wealth.common.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.ReflectionUtils;

import com.wealth.common.constants.QueryConstants;
import com.wealth.common.constants.SchemaConstants;
import com.wealth.common.generic.BaseError;
import com.wealth.common.generic.GrowxException;
import com.wealth.common.logger.GrowxLogger;
import com.wealth.common.model.dao.IfGenericDao;
import com.wealth.common.model.entity.GenericEntity;
import com.wealth.common.model.entity.PagedResult;
import com.wealth.common.utils.generic.RequestHeaderUtil;

public class GenericRepository<T extends GenericEntity> implements IfGenericDao<T> {

	private static final GrowxLogger logger = new GrowxLogger(GenericRepository.class);

	protected final JdbcTemplate jdbcTemplate;
	protected final Class<T> type;
	protected final String tableName;
	protected final String pk;

	public GenericRepository(JdbcTemplate jdbcTemplate, Class<T> type) {
		this.jdbcTemplate = jdbcTemplate;
		this.type = type;
		try {
			this.tableName = type.getDeclaredConstructor().newInstance().tableName();
			this.pk = type.getDeclaredConstructor().newInstance().primaryKey();
		} catch (Exception e) {
			logger.error("Failed to initialize repository for type: " + type.getName(), e);
			throw new GrowxException(BaseError.UNKNOWN_ERROR);
		}

	}
	public String getTableNameWithSchema() {
		String resolvedSchema = getSchema();
		if (resolvedSchema == null) {
			return tableName;
		}
		return resolvedSchema + "." + tableName;
	}

	public String getSchema() {
		String schemaForTable = SchemaConstants.getValueByKey(tableName);
		if (schemaForTable == null) {
			return null;
		}
		String headerSchema = RequestHeaderUtil.getSchemaName();
		if (headerSchema == null) {
			headerSchema = "growx";
		}
		return headerSchema + "_" + schemaForTable;
	}
	
	
	@Override
	public <T extends GenericEntity> T updateWithOutChanges(T entity) {
		logger.info("Entering updateWithOutChanges for entity: {}", entity);
		populateAuditFields1(entity, false);
		StringBuilder sql = new StringBuilder("UPDATE " + getTableNameWithSchema() + " SET ");
		List<Object> params = new ArrayList<>();

		for (Field field : getAllFields(entity.getClass())) {
			field.setAccessible(true);
			String fieldName = field.getName();

			if (fieldName.equalsIgnoreCase(pk) || fieldName.equals("crtdBy") || fieldName.equals("crtdDt")
					|| fieldName.equals("crtdIp")) {
				continue;
			}

			try {
				Object value = field.get(entity);
				if (value != null) {
					sql.append(camelToSnake(fieldName)).append(" = ?, ");
					params.add(value);
				}
			} catch (IllegalAccessException e) {
				throw new RuntimeException("Failed to access field: " + fieldName, e);
			}
		}

		sql.setLength(sql.length() - 2); // Remove trailing comma and space
		sql.append(" WHERE ").append(camelToSnake(pk)).append(" = ?");

		Object id = getPrimaryKeyValue(entity);

		params.add(id);
		int status = jdbcTemplate.update(sql.toString(), params.toArray());
		logger.info("Updated, Count: {}, PK: {}", status, id);
		logger.debug("Exiting updateWithOutChanges for entity: {}", entity);
		return (T) findById(Integer.valueOf(id.toString()));
	}

	@Override
	public <T extends GenericEntity> T update(T entity) {
		logger.debug("Entering update for entity: {}", entity);
		populateAuditFields(entity, false);

		StringBuilder sql = new StringBuilder("UPDATE " + getTableNameWithSchema() + " SET ");
		List<Object> params = new ArrayList<>();

		for (Field field : getAllFields(entity.getClass())) {
			field.setAccessible(true);
			try {
				Object value = field.get(entity);
				if (value != null) {
					sql.append(camelToSnake(field.getName())).append(" = ?, ");
					params.add(value);
				}
			} catch (IllegalAccessException e) {
				throw new RuntimeException("Failed to access field: " + field.getName(), e);
			}
		}

		sql.setLength(sql.length() - 2); // remove last comma
		sql.append(" WHERE ").append(camelToSnake(pk)).append(" = ?");
		Object id = getPrimaryKeyValue(entity);
		params.add(id);

		int status = jdbcTemplate.update(sql.toString(), params.toArray());
		logger.info("Updated, Count: {}, PK: {}", status, id);
		logger.debug("Exiting update for entity: {}", entity);
		return (T) findById(Integer.valueOf(id.toString()));
	}

	@Override
	public T findById(int id) {
		logger.debug("Finding entity by id: {}", id);
		String sql = QueryConstants.FIND_ALL + getTableNameWithSchema() + " WHERE " + camelToSnake(pk) + " = ?";

		try {
			return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(type), id);
		} catch (EmptyResultDataAccessException e) {
			return null; // return null when no result
		}
	}

	


	@Override
	public int deleteById(int id) {
		logger.debug("Soft deleting entity by id: {}", id);
		String sql = "UPDATE " + getTableNameWithSchema() + " SET RECORD_STATE = 'D' WHERE " + camelToSnake(pk) + " = ?";
		return jdbcTemplate.update(sql, id);
	}

	@Override
	public List<T> findAll() {
		logger.debug("Finding all entities");
		String sql = QueryConstants.FIND_ALL + getTableNameWithSchema()+" WHERE tenant_id = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(type), RequestHeaderUtil.getAppId());
	}

	@Override
	public List<T> findByIds(List<Integer> ids) {
		logger.debug("Finding entities by ids: {}", ids);

		if (ids == null || ids.isEmpty()) {
			return Collections.emptyList();
		}
		String inClause = ids.stream().map(id -> "?").collect(Collectors.joining(", "));

		String sql = "SELECT * FROM " + getTableNameWithSchema() + " WHERE " + camelToSnake(pk) + 
				" IN (" + inClause + ")";

		if (tableName.equalsIgnoreCase("GXSYS_MODULE")) {
			sql += " ORDER BY order_sequence ASC";
		}
		
		return jdbcTemplate.query(sql, ids.toArray(), new BeanPropertyRowMapper<>(type));
	}

	@Override
	public List<T> findByFields(T filterObj) {
	    logger.debug("Finding entities by fields: {}", filterObj);

	    StringBuilder sql = new StringBuilder("SELECT * FROM ")
	            .append(getTableNameWithSchema())
	            .append(" WHERE tenant_id = ?");

	    List<Object> params = new ArrayList<>();
	    params.add(RequestHeaderUtil.getAppId()); 

	    List<Field> sortedFields = getAllFields(filterObj.getClass())
	            .stream()
	            .filter(f -> !f.getName().equalsIgnoreCase(pk))
	            .sorted(Comparator.comparing(Field::getName))
	            .toList();

	    for (Field field : sortedFields) {
	        field.setAccessible(true);
	        try {
	            Object value = field.get(filterObj);

	            if (value != null && !(value instanceof Number num && num.doubleValue() == 0)) {
	                sql.append(" AND ")
	                   .append(camelToSnake(field.getName()))
	                   .append(" = ?");
	                params.add(value);
	            }

	        } catch (IllegalAccessException e) {
	            throw new RuntimeException("Failed to access field: " + field.getName(), e);
	        }
	    }

	    return jdbcTemplate.query(
	            sql.toString(),
	            new BeanPropertyRowMapper<>(type),
	            params.toArray()
	    );
	}


	@Override
	public List<T> findByFieldsList(List<T> filterList) {
	    logger.debug("Finding entities by fields list: {}", filterList);
	    if (filterList == null || filterList.isEmpty()) {
	        return Collections.emptyList();
	    }

	    StringBuilder sql = new StringBuilder("SELECT * FROM ")
	            .append(getTableNameWithSchema())
	            .append(" WHERE tenant_id = ?"); // enforce tenant filter

	    List<Object> params = new ArrayList<>();
	    params.add(RequestHeaderUtil.getAppId()); // tenant ID always first

	    StringBuilder orConditions = new StringBuilder();

	    for (T filterObj : filterList) {
	        List<Field> sortedFields = getAllFields(filterObj.getClass()).stream()
	                .filter(f -> !f.getName().equalsIgnoreCase(pk))
	                .sorted(Comparator.comparing(Field::getName))
	                .toList();

	        boolean hasConditions = false;
	        StringBuilder condition = new StringBuilder("(");

	        for (Field field : sortedFields) {
	            field.setAccessible(true);
	            try {
	                Object value = field.get(filterObj);
	                if (value != null && !(value instanceof Number num && num.doubleValue() == 0)) {
	                    condition.append(camelToSnake(field.getName())).append(" = ? AND ");
	                    params.add(value);
	                    hasConditions = true;
	                }
	            } catch (IllegalAccessException e) {
	                throw new RuntimeException("Failed to access field: " + field.getName(), e);
	            }
	        }

	        if (hasConditions) {
	            condition.setLength(condition.length() - 5); // remove last " AND "
	            condition.append(")");
	            if (orConditions.length() > 0) {
	                orConditions.append(" OR ");
	            }
	            orConditions.append(condition);
	        }
	    }

	    if (params.size() == 1) { // only tenant param
	        throw new IllegalArgumentException("No fields to search for in the given list");
	    }

	    if (orConditions.length() > 0) {
	        sql.append(" AND (").append(orConditions).append(")");
	    }

	    return jdbcTemplate.query(sql.toString(), params.toArray(), new BeanPropertyRowMapper<>(type));
	}


	// Helper Methods

	private void populateAuditFields(GenericEntity entity, boolean isInsert) {
		Timestamp now = new Timestamp(System.currentTimeMillis());
		int userId = RequestHeaderUtil.getUserId();
			if (isInsert) {
				entity.setCrtdBy(userId);
				entity.setCrtdDt(now);
				entity.setCrtdIp(RequestHeaderUtil.getIp());
				if (entity.getRecordState() == '\u0000') {
					entity.setRecordState('A');
				}

			}
			entity.setTenantId(RequestHeaderUtil.getAppId());
			entity.setUpdtBy(userId);
			entity.setUpdtDt(now);
			entity.setUpdtIp(RequestHeaderUtil.getIp());
		
	}

	private void populateAuditFields1(GenericEntity entity, boolean isInsert) {
		Timestamp now = new Timestamp(System.currentTimeMillis());
		int userId = 1;
		try {
			if (isInsert) {
				char status = Character.toUpperCase(entity.getRecordState());

				if (status == 'P') {
					entity.setRecordState('P');
				} else if (status == 0 || status == ' ') {
					entity.setRecordState('A');
				}

				entity.setCrtdBy(userId);
				entity.setCrtdDt(now);
				entity.setCrtdIp("127.0.0.1");
			}
			entity.setTenantId(RequestHeaderUtil.getAppId());
			entity.setUpdtBy(userId);
			entity.setUpdtDt(now);
			entity.setUpdtIp("127.0.0.1");

		} catch (Exception e) {
			throw new RuntimeException("Failed to populate audit fields", e);
		}
	}

	private void populateAuditFieldsCustom(GenericEntity entity, boolean isInsert) {

	    Timestamp now = new Timestamp(System.currentTimeMillis());
	    int userId = 1;

	    if (isInsert) {
	        entity.setCrtdBy(userId);
	        entity.setCrtdDt(now);
	        entity.setCrtdIp("127.0.0.1");
			if (entity.getRecordState() == '\u0000') {
				entity.setRecordState('A');
			}
	        
	    }
		entity.setTenantId(RequestHeaderUtil.getAppId());
	    entity.setUpdtBy(userId);
	    entity.setUpdtDt(now);
	    entity.setUpdtIp("127.0.0.1");
	}


	private String generateInsertSQLWithPk(Class<?> clazz) {

//	    List<Field> fields = getAllFields(clazz);
	    List<Field> fields = getAllFields(clazz).stream()
	            .filter(f -> !Modifier.isStatic(f.getModifiers()) && !Modifier.isTransient(f.getModifiers()))
	            .collect(Collectors.toList());
	    String columns =
	            fields.stream()
	                    .map(field -> camelToSnake(field.getName()))
	                    .collect(Collectors.joining(", "));

	    String placeholders =
	            fields.stream()
	                    .map(field -> "?")
	                    .collect(Collectors.joining(", "));

	    return String.format(
	            "INSERT INTO %s (%s) VALUES (%s);",
	            getTableNameWithSchema(),
	            columns,
	            placeholders
	    );
	}


//	private Object[] getFieldValuesWithPk(Object obj) {
//		return getAllFields(obj.getClass()).stream().map(f -> {
//			try {
//				f.setAccessible(true);
//				return f.get(obj);
//			} catch (IllegalAccessException e) {
//				throw new RuntimeException("Failed to access field: " + f.getName(), e);
//			}
//		}).toArray();
//	}

	private Object[] getFieldValuesWithPk(Object obj) {
	    return getAllFields(obj.getClass()).stream()
	        // --- ADD THIS FILTER ---
	        .filter(f -> !Modifier.isStatic(f.getModifiers()) && !Modifier.isTransient(f.getModifiers()))
	        .map(f -> {
	            try {
	                f.setAccessible(true);
	                return f.get(obj);
	            } catch (IllegalAccessException e) {
	                throw new RuntimeException("Failed to access field: " + f.getName(), e);
	            }
	        }).toArray();
	}
	private Field getPrimaryKeyField(GenericEntity entity) {
		Class<?> clazz = entity.getClass();
		while (clazz != null) {
			try {
				return clazz.getDeclaredField(pk);
			} catch (NoSuchFieldException e) {
				clazz = clazz.getSuperclass();
			}
		}
		throw new IllegalStateException(
				"Primary key field '" + pk + "' not found in entity class: " + entity.getClass().getName());
	}

	private Object getPrimaryKeyValue(GenericEntity entity) {
		try {
			Field primaryKeyField = getPrimaryKeyField(entity);
			primaryKeyField.setAccessible(true);
			return primaryKeyField.get(entity);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("Failed to access primary key field: " + pk, e);
		}
	}

	/** Column-name conversion for GrowX SQL. Does NOT split a digit boundary
	 *  (pass1Matched -> pass1matched); external payloads use camelToSnakeForExternalApi. */
	private static String camelToSnake(String str) {
		return str.replaceAll("([a-z])([A-Z]+)", "$1_$2").toLowerCase();
	}

	/** camelCase to snake_case for EXTERNAL API payloads, not SQL; splits a digit boundary
	 *  (pass1Matched -> pass1_matched). Separate method and placement are DELIBERATE. */
	public static String camelToSnakeForExternalApi(String str) {
		if (str == null || str.isEmpty()) {
			return str;
		}
		StringBuilder out = new StringBuilder(str.length() + 8);
		boolean previousWasTranslated = false;
		for (int i = 0; i < str.length(); i++) {
			char current = str.charAt(i);
			if (Character.isUpperCase(current)) {
				if (!previousWasTranslated && out.length() > 0 && out.charAt(out.length() - 1) != '_') {
					out.append('_');
				}
				out.append(Character.toLowerCase(current));
				previousWasTranslated = true;
			} else {
				out.append(current);
				previousWasTranslated = false;
			}
		}
		return out.toString();
	}

//	private static List<Field> getAllFields(Class<?> type) {
//		List<Field> fields = new ArrayList<>();
//		while (type != null && type != Object.class) {
//			fields.addAll(Arrays.asList(type.getDeclaredFields()));
//			type = type.getSuperclass();
//		}
//		return fields;
//	}

	private static List<Field> getAllFields(Class<?> type) {
	    List<Field> fields = new ArrayList<>();
	    while (type != null && type != Object.class) {
	        // Filter out STATIC (serialVersionUID) and TRANSIENT fields
	        List<Field> filteredFields = Arrays.stream(type.getDeclaredFields())
	                .filter(f -> !Modifier.isStatic(f.getModifiers()))
	                .filter(f -> !Modifier.isTransient(f.getModifiers()))
	                .collect(Collectors.toList());
	        
	        fields.addAll(filteredFields);
	        type = type.getSuperclass();
	    }
	    return fields;
	}
	@Override
	public List<T> findByFieldsSearch(T filterObj) {

	    StringBuilder sql = new StringBuilder("SELECT * FROM ")
	            .append(getTableNameWithSchema())
	            .append(" WHERE tenant_id = ?"); // ✅ enforce tenant filter

	    List<Object> params = new ArrayList<>();
	    params.add(RequestHeaderUtil.getAppId()); // tenant ID always first

	    List<Field> sortedFields = getAllFields(filterObj.getClass())
	            .stream()
	            .sorted(Comparator.comparing(Field::getName))
	            .toList();

	    for (Field field : sortedFields) {
	        field.setAccessible(true);

	        try {
	            Object value = field.get(filterObj);

	            boolean skip =
	                    value == null
	                    || (value instanceof String str && str.isBlank())
	                    || (value instanceof Number num && num.doubleValue() == 0)
	                    || (value instanceof Boolean bool && !bool);

	            if (skip) {
	                continue;
	            }

	            String column = camelToSnake(field.getName());

	            if (value instanceof String strValue) {
	                sql.append(" AND ").append(column).append(" LIKE ?");
	                params.add("%" + strValue + "%");
	            } else {
	                sql.append(" AND ").append(column).append(" = ?");
	                params.add(value);
	            }

	        } catch (IllegalAccessException e) {
	            throw new RuntimeException("Failed to access field: " + field.getName(), e);
	        }
	    }

	    return jdbcTemplate.query(
	            sql.toString(),
	            params.toArray(),
	            new BeanPropertyRowMapper<>(type)
	    );
	}



	public <T extends GenericEntity> List<T> saveAllWithOutChanges(List<T> entities) {
	
		    if (entities == null || entities.isEmpty()) {
		        return Collections.emptyList();
		    }

		    // 1. Populate audit fields
		    for (T entity : entities) {
		        populateAuditFields1(entity, true);
		    }

		    T firstEntity = entities.get(0);
		    List<Field> insertFields =
		            getAllFields(firstEntity.getClass());

		    String columns =
		            insertFields.stream()
		                    .map(f -> camelToSnake(f.getName()))
		                    .collect(Collectors.joining(", "));

		    String placeholders =
		            insertFields.stream()
		                    .map(f -> "?")
		                    .collect(Collectors.joining(", "));

		    // 2. Prepare PK handling
		    Field pkField = getPrimaryKeyField(firstEntity);
		    pkField.setAccessible(true);
		    String sequenceName = getSchema()+"."+camelToSnake(pk) + "_seq";

		    for (T entity : entities) {
		        Long nextId =
		                jdbcTemplate.queryForObject(
		                        "SELECT NEXTVAL('" + sequenceName + "')",
		                        Long.class
		                );

		        if (nextId == null) {
		            throw new GrowxException(BaseError.GENERATE_SQL_PK_ERROR);
		        }

		        try {
		            pkField.set(
		                    entity,
		                    castValueToFieldType(pkField, nextId)
		            );
		        } catch (IllegalAccessException e) {
		            throw new GrowxException(
		                    BaseError.GENERATE_SQL_PK_ERROR,
		                    e
		            );
		        }
		    }

		    // 3. Build SQL
		    StringBuilder sql =
		            new StringBuilder()
		                    .append("INSERT INTO ")
		                    .append(getTableNameWithSchema())
		                    .append(" (")
		                    .append(columns)
		                    .append(") VALUES ");

		    List<Object> allValues = new ArrayList<>();

		    for (int i = 0; i < entities.size(); i++) {
		        sql.append("(").append(placeholders).append(")");
		        if (i < entities.size() - 1) {
		            sql.append(", ");
		        }

		        T entity = entities.get(i);
		        for (Field field : insertFields) {
		        	field.setAccessible(true);
		            allValues.add(
		                    ReflectionUtils.getField(field, entity)
		            );
		        }
		    }

		    // 4. Execute insert
		    jdbcTemplate.update(
		            sql.toString(),
		            allValues.toArray()
		    );

		    return entities;
		}

	

	public <T extends GenericEntity> List<T> saveAll(List<T> entities) {
		if (entities == null || entities.isEmpty()) {
			return Collections.emptyList();
		}
		for (T entity : entities) {
			populateAuditFields(entity, true);
		}
		T firstEntity = entities.get(0);
		Class<?> clazz = firstEntity.getClass();
		List<Field> fields = getAllFields(clazz);
		List<Field> insertFields = fields;
		String columns = insertFields.stream().map(field -> camelToSnake(field.getName()))
				.collect(Collectors.joining(", "));
		String placeholders = insertFields.stream().map(field -> "?").collect(Collectors.joining(", "));
		Field primaryKeyField = getPrimaryKeyField(firstEntity);
		primaryKeyField.setAccessible(true);
		String sequenceName = getSchema()+"."+camelToSnake(pk) + "_seq";
		for (T entity : entities) {
			Long nextId = jdbcTemplate.queryForObject("SELECT NEXTVAL('" + sequenceName + "')", Long.class);
			try {
				primaryKeyField.set(entity, castValueToFieldType(primaryKeyField, nextId));
			} catch (Exception e) {
				try {
					primaryKeyField.set(entity, Integer.valueOf(String.valueOf(nextId)));
				} catch (Exception e1) {
					throw new GrowxException(BaseError.GENERATE_SQL_PK_ERROR);
				}
			}
		}
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ").append(getTableNameWithSchema()).append(" (").append(columns).append(") VALUES ");

		List<Object> allValues = new ArrayList<>();
		for (int i = 0; i < entities.size(); i++) {
			sql.append("(").append(placeholders).append(")");
			if (i < entities.size() - 1) {
				sql.append(", ");
			}
			for (Field field : insertFields) {
				field.setAccessible(true);
				try {
					allValues.add(field.get(entities.get(i)));
				} catch (IllegalAccessException e) {
					throw new GrowxException(BaseError.UNKNOWN_QUESTION);
				}
			}
		}
		jdbcTemplate.update(sql.toString(), allValues.toArray());
		return entities;
	}

	public <T extends GenericEntity> List<T> updateAll(List<T> entities) {
		if (entities == null || entities.isEmpty()) {
			return Collections.emptyList();
		}

		for (T entity : entities) {
			populateAuditFields(entity, false);
		}

		T firstEntity = entities.get(0);
		Class<?> clazz = firstEntity.getClass();
		List<Field> fields = getAllFields(clazz);

		Field pkField = getPrimaryKeyField(firstEntity);
		pkField.setAccessible(true);
		String pkColumn = camelToSnake(pk);

		List<Field> updateFields = fields.stream().filter(f -> !f.getName().equals(pk)).collect(Collectors.toList());

		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE ").append(getTableNameWithSchema()).append(" SET ");

		String setClause = updateFields.stream().map(f -> camelToSnake(f.getName()) + " = ?")
				.collect(Collectors.joining(", "));

		sql.append(setClause);
		sql.append(" WHERE ").append(pkColumn).append(" = ?");

		List<Object[]> batchArgs = new ArrayList<>();

		for (T entity : entities) {
			List<Object> values = new ArrayList<>();

			for (Field field : updateFields) {
				field.setAccessible(true);
				try {
					values.add(field.get(entity));
				} catch (IllegalAccessException e) {
					throw new GrowxException(BaseError.UNKNOWN_QUESTION);
				}
			}

			try {
				values.add(pkField.get(entity));
			} catch (IllegalAccessException e) {
				throw new GrowxException(BaseError.UNKNOWN_QUESTION);
			}

			batchArgs.add(values.toArray());
		}

		jdbcTemplate.batchUpdate(sql.toString(), batchArgs);

		return entities;
	}
	
	public <T extends GenericEntity> List<T> updateAllWithChanges(List<T> entities) {
		if (entities == null || entities.isEmpty()) {
			return Collections.emptyList();
		}

		T firstEntity = entities.get(0);
		Class<?> clazz = firstEntity.getClass();
		List<Field> fields = getAllFields(clazz);

		Field pkField = getPrimaryKeyField(firstEntity);
		pkField.setAccessible(true);
		String pkColumn = camelToSnake(pk);

		List<Field> updateFields = fields.stream().filter(f -> !f.getName().equals(pk)).collect(Collectors.toList());

		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE ").append(getTableNameWithSchema()).append(" SET ");

		String setClause = updateFields.stream().map(f -> camelToSnake(f.getName()) + " = ?")
				.collect(Collectors.joining(", "));

		sql.append(setClause);
		sql.append(" WHERE ").append(pkColumn).append(" = ?");

		List<Object[]> batchArgs = new ArrayList<>();

		for (T entity : entities) {
			List<Object> values = new ArrayList<>();

			for (Field field : updateFields) {
				field.setAccessible(true);
				try {
					values.add(field.get(entity));
				} catch (IllegalAccessException e) {
					throw new GrowxException(BaseError.UNKNOWN_QUESTION);
				}
			}

			try {
				values.add(pkField.get(entity));
			} catch (IllegalAccessException e) {
				throw new GrowxException(BaseError.UNKNOWN_QUESTION);
			}

			batchArgs.add(values.toArray());
		}

		jdbcTemplate.batchUpdate(sql.toString(), batchArgs);

		return entities;
	}

	@Override
	public <T extends GenericEntity> T updateForWorkflow(T entity) {
		logger.debug("Entering updateForWorkflow for entity: {}", entity);

		// 1. Populate audit fields for update
		populateAuditFields(entity, false);

		// 2. Extract class + fields
		Class<?> clazz = entity.getClass();
		List<Field> fields = getAllFields(clazz);

		// 3. Get primary key
		Field pkField = getPrimaryKeyField(entity);
		pkField.setAccessible(true);
		String pkColumn = camelToSnake(pkField.getName());

		// 4. Exclude PK from SET clause
		List<Field> updateFields = fields.stream().filter(f -> !f.getName().equals(pkField.getName()))
				.collect(Collectors.toList());

		// 5. Build SQL
		StringBuilder sql = new StringBuilder("UPDATE ").append(getTableNameWithSchema()).append(" SET ");
		String setClause = updateFields.stream().map(f -> camelToSnake(f.getName()) + " = ?")
				.collect(Collectors.joining(", "));
		sql.append(setClause).append(" WHERE ").append(pkColumn).append(" = ?");

		// 6. Collect parameter values
		List<Object> params = new ArrayList<>();
		for (Field field : updateFields) {
			field.setAccessible(true);
			params.add(ReflectionUtils.getField(field, entity));
		}
		params.add(ReflectionUtils.getField(pkField, entity)); // PK in WHERE

		// 7. Execute update
		int updated = jdbcTemplate.update(sql.toString(), params.toArray());
		logger.info("Workflow update completed. Updated: {}, PK: {}", updated,
				ReflectionUtils.getField(pkField, entity));

		// 8. Return fresh entity from DB
		Object id = ReflectionUtils.getField(pkField, entity);
		return (T) findById(Integer.valueOf(id.toString()));
	}

	@Override
	public <T extends GenericEntity> T updateWithCustomAudit(T entity) {
		logger.debug("Entering updateForWorkflow for entity: {}", entity);

		// 1. Populate audit fields for update
		populateAuditFieldsCustom(entity, false);

		// 2. Extract class + fields
		Class<?> clazz = entity.getClass();
		List<Field> fields = getAllFields(clazz);

		// 3. Get primary key
		Field pkField = getPrimaryKeyField(entity);
		pkField.setAccessible(true);
		String pkColumn = camelToSnake(pkField.getName());

		// 4. Exclude PK from SET clause
		List<Field> updateFields = fields.stream().filter(f -> !f.getName().equals(pkField.getName()))
				.collect(Collectors.toList());

		// 5. Build SQL
		StringBuilder sql = new StringBuilder("UPDATE ").append(getTableNameWithSchema()).append(" SET ");
		String setClause = updateFields.stream().map(f -> camelToSnake(f.getName()) + " = ?")
				.collect(Collectors.joining(", "));
		sql.append(setClause).append(" WHERE ").append(pkColumn).append(" = ?");

		// 6. Collect parameter values
		List<Object> params = new ArrayList<>();
		for (Field field : updateFields) {
			field.setAccessible(true);
			params.add(ReflectionUtils.getField(field, entity));
		}
		params.add(ReflectionUtils.getField(pkField, entity)); // PK in WHERE

		// 7. Execute update
		int updated = jdbcTemplate.update(sql.toString(), params.toArray());
		logger.info("Workflow update completed. Updated: {}, PK: {}", updated,
				ReflectionUtils.getField(pkField, entity));

		// 8. Return fresh entity from DB
		Object id = ReflectionUtils.getField(pkField, entity);
		return (T) findById(Integer.valueOf(id.toString()));
	}

	@Override
	public <T extends GenericEntity> List<T> updateAllForWorkflow(List<T> entities) {
		if (entities == null || entities.isEmpty()) {
			return Collections.emptyList();
		}

		// 1. Populate audit fields for update (false → update mode)
		entities.forEach(e -> populateAuditFields(e, false));

		// 2. Use first entity to extract metadata
		T firstEntity = entities.get(0);
		Class<?> clazz = firstEntity.getClass();
		List<Field> fields = getAllFields(clazz);

		// 3. Find primary key field
		Field pkField = getPrimaryKeyField(firstEntity);
		pkField.setAccessible(true);
		String pkColumn = camelToSnake(pkField.getName());

		// 4. Exclude PK from update set
		List<Field> updateFields = fields.stream().filter(f -> !f.getName().equals(pkField.getName()))
				.collect(Collectors.toList());

		// 5. Build SQL
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE ").append(getTableNameWithSchema()).append(" SET ");

		String setClause = updateFields.stream().map(f -> camelToSnake(f.getName()) + " = ?")
				.collect(Collectors.joining(", "));

		sql.append(setClause);
		sql.append(" WHERE ").append(pkColumn).append(" = ?");

		// 6. Collect batch values
		List<Object[]> batchArgs = new ArrayList<>();
		for (T entity : entities) {
			List<Object> values = new ArrayList<>();

			for (Field field : updateFields) {
				field.setAccessible(true);
				values.add(ReflectionUtils.getField(field, entity));
			}

			values.add(ReflectionUtils.getField(pkField, entity)); // PK for WHERE clause
			batchArgs.add(values.toArray());
		}

		// 7. Execute batch update
		int[] updatedRows = jdbcTemplate.batchUpdate(sql.toString(), batchArgs);
		logger.info("Bulk update completed. Records: {}, Updated: {}", entities.size(),
				Arrays.stream(updatedRows).sum());

		return entities;
	}

	public Long getNextId() {
		return jdbcTemplate.queryForObject("SELECT NEXTVAL('" + getSchema()+"."+camelToSnake(pk) + "_seq')", Long.class);
	}

	public Long getNextId(String fieldName) {
		return jdbcTemplate.queryForObject("SELECT NEXTVAL('" + getSchema()+"."+camelToSnake(fieldName) + "_seq')", Long.class);
	}

	private Object castValueToFieldType(Field field, Object value) {

	    Class<?> fieldType = field.getType();

	    if (fieldType == Integer.class || fieldType == int.class) {
	        return Integer.valueOf(value.toString());
	    } else if (fieldType == Long.class || fieldType == long.class) {
	        return Long.valueOf(value.toString());
	    } else if (fieldType == String.class) {
	        return value.toString();
	    }

	    return value;
	}


	public Long resolveUserIdFromCode() {
		String userCode = RequestHeaderUtil.getUserCode();
		String sql = QueryConstants.GET_USER_ID_FROM_USER_CODE;

		try {
			return jdbcTemplate.queryForObject(sql, Long.class, userCode);
		} catch (Exception e) {
			throw new RuntimeException("User not found in either table for user_code: " + userCode, e);
		}
	}

	// ------------------------------------------------------paged-------------------------------------------------------------------------------------
@Override
public PagedResult<T> findByFields(T filterObj, int pageNumber, int pageSize) {

    logger.debug("Finding entities by fields: {}", filterObj);

    StringBuilder baseSql = new StringBuilder("SELECT t.*, COUNT(*) OVER() AS total_count FROM ")
            .append(getTableNameWithSchema())
            .append(" t WHERE t.tenant_id = ?"); // ✅ enforce tenant filter

    List<Object> params = new ArrayList<>();
    params.add(RequestHeaderUtil.getAppId()); // tenant ID always first

    List<Field> sortedFields = getAllFields(filterObj.getClass())
            .stream()
            .filter(f -> !f.getName().equalsIgnoreCase(pk)) // skip PK
            .sorted(Comparator.comparing(Field::getName))
            .toList();

    for (Field field : sortedFields) {
        field.setAccessible(true);

        try {
            Object value = field.get(filterObj);

            boolean skip =
                    value == null
                    || (value instanceof String s && s.isBlank())
                    || (value instanceof Number num && num.doubleValue() == 0)
                    || (value instanceof Boolean b && !b);

            if (skip) {
                continue;
            }

            String column = camelToSnake(field.getName());

            if (value instanceof String s) {
                baseSql.append(" AND ").append(column).append(" LIKE ?");
                params.add("%" + s + "%");
            } else {
                baseSql.append(" AND ").append(column).append(" = ?");
                params.add(value);
            }

        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to access field: " + field.getName(), e);
        }
    }

    return executePagedQuery(
            baseSql.toString(),
            params,
            pageNumber,
            pageSize
    );
}

	@Override
	public PagedResult<T> findByIds(List<Integer> ids, int pageNumber, int pageSize) {
		logger.debug("Finding entities by ids: {}", ids);
		if (ids == null || ids.isEmpty()) {
			return new PagedResult<>(Collections.emptyList(), 0);
		}

		String inClause = ids.stream().map(id -> "?").collect(Collectors.joining(", "));

		String baseSql = "SELECT t.*, COUNT(*) OVER() AS total_count " + "FROM " + getTableNameWithSchema() + " t " + "WHERE "
				+ camelToSnake(pk) + " IN (" + inClause + ")";

		List<Object> params = new ArrayList<>(ids);

		return executePagedQuery(baseSql, params, pageNumber, pageSize);
	}

	@Override
	public PagedResult<T> findAll(int pageNumber, int pageSize) {
	    logger.debug("Finding all entities with pagination");
	    String sql = "SELECT t.*, COUNT(*) OVER() AS total_count FROM "
	            + getTableNameWithSchema()
	            + " t WHERE t.tenant_id = ? ORDER BY t.updt_dt DESC";

	    List<Object> params = new ArrayList<>();
	    params.add(RequestHeaderUtil.getAppId());

	    return executePagedQuery(sql, params, pageNumber, pageSize);
	}


	@Override
	public PagedResult<T> findByFieldsSearch(T filterObj, int pageNumber, int pageSize) {
	    List<Object> params = new ArrayList<>();

	    // ✅ enforce tenant filter
	    String baseSql = "SELECT t.*, COUNT(*) OVER() AS total_count FROM "
	            + getTableNameWithSchema()
	            + " t WHERE t.tenant_id = ?"
	            + buildWhereClauseFromObject(filterObj, params, true); // LIKE search

	    // tenant ID always first
	    params.add(0, RequestHeaderUtil.getAppId());

	    return executePagedQuery(baseSql, params, pageNumber, pageSize);
	}

@Override
public PagedResult<T> findByFieldsList(List<T> filterList, int pageNumber, int pageSize) {

    logger.debug("Finding entities by fields list: {}", filterList);

    if (filterList == null || filterList.isEmpty()) {
        return new PagedResult<>(Collections.emptyList(), 0);
    }

    StringBuilder baseSql =
            new StringBuilder(
                    "SELECT t.*, COUNT(*) OVER() AS total_count FROM "
                            + getTableNameWithSchema()
                            + " t WHERE "
            );

    List<Object> params = new ArrayList<>();
    List<String> orGroups = new ArrayList<>();

    for (T filterObj : filterList) {

        List<Field> sortedFields =
                getAllFields(filterObj.getClass())
                        .stream()
                        .filter(f -> !f.getName().equalsIgnoreCase(pk))
                        .sorted(Comparator.comparing(Field::getName))
                        .toList();

        List<String> andConditions = new ArrayList<>();

        for (Field field : sortedFields) {
            field.setAccessible(true);

            try {
                Object value = field.get(filterObj);

                boolean skip =
                        value == null
                                || (value instanceof String s && s.isBlank())
                                || (value instanceof Number num && num.doubleValue() == 0)
                                || (value instanceof Boolean b && !b);

                if (skip) {
                    continue; // ✅ single continue
                }

                String column = camelToSnake(field.getName());

                if (value instanceof String s) {
                    if (s.length() >= 3) {
                        andConditions.add(column + " ILIKE ?");
                        params.add("%" + s + "%");
                    } else {
                        andConditions.add(column + " = ?");
                        params.add(s);
                    }
                } else {
                    andConditions.add(column + " = ?");
                    params.add(value);
                }

            } catch (IllegalAccessException e) {
                throw new RuntimeException(
                        "Failed to access field: " + field.getName(),
                        e
                );
            }
        }

        if (!andConditions.isEmpty()) {
            orGroups.add("(" + String.join(" AND ", andConditions) + ")");
        }
    }

    if (orGroups.isEmpty()) {
        throw new IllegalArgumentException(
                "No fields to search for in the given list"
        );
    }

    baseSql.append(String.join(" OR ", orGroups));

    return executePagedQuery(
            baseSql.toString(),
            params,
            pageNumber,
            pageSize
    );
}

	public PagedResult<T> executePagedQuery(String baseSql, List<Object> params, int pageNumber, int pageSize) {
		boolean paginate = pageNumber > 0 && pageSize > 0;

		String sql = baseSql + (paginate ? " LIMIT ? OFFSET ?" : "");
		if (paginate) {
			params.add(pageSize);
			params.add((pageNumber - 1) * pageSize);
		}

		final long[] total = { 0 };

		List<T> data = jdbcTemplate.query(sql, rs -> {
			List<T> list = new ArrayList<>();
			BeanPropertyRowMapper<T> mapper = new BeanPropertyRowMapper<>(type);
			int rowNum = 0;
			while (rs.next()) {
				if (rowNum == 0)
					total[0] = rs.getLong("total_count");
				list.add(mapper.mapRow(rs, rowNum++));
			}
			return list;
		}, params.toArray());

		return new PagedResult<>(data, total[0]);
	}

	public <T> PagedResult<T> executePagedQuery(String baseSql, List<Object> params, int pageNumber, int pageSize,
			Class<T> classType) {
		boolean paginate = pageNumber > 0 && pageSize > 0;
		String sql = baseSql + (paginate ? " LIMIT ? OFFSET ?" : "");

		if (paginate) {
			params.add(pageSize);
			params.add((pageNumber - 1) * pageSize);
		}

		final long[] total = { 0 };

		List<T> data = jdbcTemplate.query(sql, rs -> {
			List<T> list = new ArrayList<>();
			BeanPropertyRowMapper<T> mapper = new BeanPropertyRowMapper<>(classType);
			int rowNum = 0;
			while (rs.next()) {
				if (rowNum == 0) {
					total[0] = rs.getLong("total_count");
				}
				list.add(mapper.mapRow(rs, rowNum++));
			}
			return list;
		}, params.toArray());

		// Always return a non-null PagedResult
		return new PagedResult<>(data != null ? data : Collections.emptyList(), total[0]);
	}

	private String buildWhereClauseFromObject(
        Object filterObj,
        List<Object> params,
        boolean useLike) {

    StringBuilder where = new StringBuilder();

    List<Field> sortedFields =
            getAllFields(filterObj.getClass())
                    .stream()
                    .filter(f -> !f.getName().equalsIgnoreCase(pk)) // skip PK
                    .sorted(Comparator.comparing(Field::getName))
                    .toList();

    for (Field field : sortedFields) {
        field.setAccessible(true);

        try {
            Object value = field.get(filterObj);

            boolean skip =
                    value == null
                            || (value instanceof String s && s.isBlank())
                            || (value instanceof Number n && n.doubleValue() == 0)
                            || (value instanceof Boolean b && !b);

            if (skip) {
                continue; // ✅ single continue
            }

            String column = camelToSnake(field.getName());

            if (useLike && value instanceof String s) {
                where.append(" AND ").append(column).append(" LIKE ?");
                params.add("%" + s + "%");
            } else {
                where.append(" AND ").append(column).append(" = ?");
                params.add(value);
            }

        } catch (IllegalAccessException e) {
            throw new RuntimeException(
                    "Failed to access field: " + field.getName(),
                    e
            );
        }
    }

    return where.toString();
}

//-----------------------------------------------------------with getnext val-------------------------------------------------------------------

	@Override
	public <T extends GenericEntity> T save(T entity) {
		logger.debug("Entering saveWithPreFetchedId for entity: {}", entity);
		populateAuditFields(entity, true);
		String sequenceName = getSchema()+"."+camelToSnake(pk) + "_seq";
		Long nextId = jdbcTemplate.queryForObject("SELECT NEXTVAL('" + sequenceName + "')", Long.class);
		Field primaryKeyField = getPrimaryKeyField(entity);
		primaryKeyField.setAccessible(true);
		try {
			primaryKeyField.set(entity, nextId);
		} catch (Exception e) {
			try {
				primaryKeyField.set(entity, Integer.parseInt(String.valueOf(nextId)));
			} catch (Exception e1) {
				throw new GrowxException(BaseError.GENERATE_SQL_PK_ERROR);
			}
		}

		String sql = generateInsertSQLWithPk(entity.getClass());
		int status = jdbcTemplate.update(sql, getFieldValuesWithPk(entity));
		logger.info("Inserted, Count: {}, PID: {}", status, nextId);
		return entity;
	}

	@Override
	public <T extends GenericEntity> T saveForWorkflow(T entity) {
		logger.debug("Entering saveWithPreFetchedId for entity: {}", entity);
		populateAuditFields(entity, true);
		Field primaryKeyField = getPrimaryKeyField(entity);
		primaryKeyField.setAccessible(true);
		String sql = generateInsertSQLWithPk(entity.getClass());
		int status = jdbcTemplate.update(sql, getFieldValuesWithPk(entity));
		Object pkValue = ReflectionUtils.getField(primaryKeyField, entity);
		logger.info("Inserted, Count: {}, PID: {}", status, pkValue);
		return entity;
	}
//
	@Override
	public <T extends GenericEntity> List<T> saveAllForWorkflow(List<T> entities) {
		if (entities == null || entities.isEmpty()) {
			return Collections.emptyList();
		}

		// 1. Populate audit fields for all entities
		entities.forEach(e -> populateAuditFields(e, true));

		// 2. Use the first entity to determine fields & table
		T firstEntity = entities.get(0);
		List<Field> fields = getAllFields(firstEntity.getClass());
		List<Field> insertFields = fields; // adjust if you need to exclude PK for auto-gen

		// 3. Build SQL
		String columns = insertFields.stream().map(f -> camelToSnake(f.getName())).collect(Collectors.joining(", "));

		String placeholders = insertFields.stream().map(f -> "?").collect(Collectors.joining(", "));

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ").append(getTableNameWithSchema()).append(" (").append(columns).append(") VALUES ");

		for (int i = 0; i < entities.size(); i++) {
			sql.append("(").append(placeholders).append(")");
			if (i < entities.size() - 1) {
				sql.append(", ");
			}
		}

		// 4. Collect all values
		List<Object> allValues = new ArrayList<>();
		for (T entity : entities) {
			for (Field field : insertFields) {
				field.setAccessible(true);
				allValues.add(ReflectionUtils.getField(field, entity));
			}
		}

		// 5. Execute insert
		int inserted = jdbcTemplate.update(sql.toString(), allValues.toArray());
		logger.info("Bulk insert completed. Expected: {}, Inserted: {}", entities.size(), inserted);

		return entities;
	}

	
	@Override
	public <T extends GenericEntity> List<T> saveAllForWorkflow1(List<T> entities) {
		if (entities == null || entities.isEmpty()) {
			return Collections.emptyList();
		}

		// 1. Populate audit fields for all entities
		entities.forEach(e -> populateAuditFields1(e, true));

		// 2. Use the first entity to determine fields & table
		T firstEntity = entities.get(0);
		List<Field> fields = getAllFields(firstEntity.getClass());
		List<Field> insertFields = fields; // adjust if you need to exclude PK for auto-gen

		// 3. Build SQL
		String columns = insertFields.stream().map(f -> camelToSnake(f.getName())).collect(Collectors.joining(", "));

		String placeholders = insertFields.stream().map(f -> "?").collect(Collectors.joining(", "));

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ").append(getTableNameWithSchema()).append(" (").append(columns).append(") VALUES ");

		for (int i = 0; i < entities.size(); i++) {
			sql.append("(").append(placeholders).append(")");
			if (i < entities.size() - 1) {
				sql.append(", ");
			}
		}

		// 4. Collect all values
		List<Object> allValues = new ArrayList<>();
		for (T entity : entities) {
			for (Field field : insertFields) {
				field.setAccessible(true);
				allValues.add(ReflectionUtils.getField(field, entity));
			}
		}

		// 5. Execute insert
		int inserted = jdbcTemplate.update(sql.toString(), allValues.toArray());
		logger.info("Bulk insert completed. Expected: {}, Inserted: {}", entities.size(), inserted);

		return entities;
	}

	
	@Override
	public T saveOrUpdateByKeyValue(T entity, String key, Object value) {
		String sql = "SELECT * FROM " + getTableNameWithSchema() + " WHERE " + camelToSnake(key) + " = ? LIMIT 1";
		List<T> results = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(type), value);
		T found = results.isEmpty() ? null : results.get(0);
		if (found != null) {
			Object pkValue = getPrimaryKeyValue(found);
			try {
				Field pkField = getPrimaryKeyField(entity);
				pkField.setAccessible(true);
				pkField.set(entity, pkValue);
			} catch (Exception e) {
				throw new GrowxException(BaseError.UNKNOWN_QUESTION);
			}
			return updateWithOutChanges(entity);
		} else {
			return saveWithOutChanges(entity);
		}
	}

	@Override
	public <T extends GenericEntity> T saveWithOutChanges(T entity) {
		logger.debug("Entering saveWithPreFetchedId for entity: {}", entity);
		populateAuditFields1(entity, true);
		String sequenceName = getSchema()+"."+camelToSnake(pk) + "_seq";
		Long nextId = jdbcTemplate.queryForObject("SELECT NEXTVAL('" + sequenceName + "')", Long.class);
		Field primaryKeyField = getPrimaryKeyField(entity);
		primaryKeyField.setAccessible(true);
		try {
			primaryKeyField.set(entity, nextId);
		} catch (Exception e) {
			try {
				primaryKeyField.set(entity, Integer.parseInt(String.valueOf(nextId)));
			} catch (Exception e1) {
				throw new GrowxException(BaseError.GENERATE_SQL_PK_ERROR);
			}
		}

		Object[] fieldValues = getFieldValuesWithPk(entity);

		// Log each field value and its length
		for (int i = 0; i < fieldValues.length; i++) {
			Object value = fieldValues[i];
			logger.debug("Param[{}]: '{}', Length: {}", i, value,
					value != null && value instanceof String ? ((String) value).length() : "N/A");
		}
		String sql = generateInsertSQLWithPk(entity.getClass());
	
		int status = jdbcTemplate.update(sql, getFieldValuesWithPk(entity));
		logger.info("Inserted, Count: {}, PID: {}", status, nextId);
		return entity;
	}
	
	@Override
	public <T extends GenericEntity> T saveWithChanges(T entity) {
		logger.debug("Entering saveWithPreFetchedId for entity: {}", entity);
		//populateAuditFields1(entity, true);
		String sequenceName = getSchema()+"."+camelToSnake(pk) + "_seq";
		Long nextId = jdbcTemplate.queryForObject("SELECT NEXTVAL('" + sequenceName + "')", Long.class);
		Field primaryKeyField = getPrimaryKeyField(entity);
		primaryKeyField.setAccessible(true);
		try {
			primaryKeyField.set(entity, nextId);
		} catch (Exception e) {
			try {
				primaryKeyField.set(entity, Integer.parseInt(String.valueOf(nextId)));
			} catch (Exception e1) {
				throw new GrowxException(BaseError.GENERATE_SQL_PK_ERROR);
			}
		}

		Object[] fieldValues = getFieldValuesWithPk(entity);

		// Log each field value and its length
		for (int i = 0; i < fieldValues.length; i++) {
			Object value = fieldValues[i];
			logger.debug("Param[{}]: '{}', Length: {}", i, value,
					value != null && value instanceof String ? ((String) value).length() : "N/A");
		}
		String sql = generateInsertSQLWithPk(entity.getClass());
	
		int status = jdbcTemplate.update(sql, getFieldValuesWithPk(entity));
		logger.info("Inserted, Count: {}, PID: {}", status, nextId);
		return entity;
	}

	@Override
	public <T extends GenericEntity> T saveWithCustomAudit(T entity) {
		    logger.debug(
		            "Entering saveWithPreFetchedId for entity: {}",
		            entity
		    );

		    // 1. Populate audit fields
		    populateAuditFieldsCustom(entity, true);

		    // 2. Fetch sequence
		    String sequenceName = getSchema()+"."+camelToSnake(pk) + "_seq";
		    Long nextId =
		            jdbcTemplate.queryForObject(
		                    "SELECT NEXTVAL('" + sequenceName + "')",
		                    Long.class
		            );

		    if (nextId == null) {
		        throw new GrowxException(BaseError.GENERATE_SQL_PK_ERROR);
		    }

		    // 3. Set primary key
		    Field pkField = getPrimaryKeyField(entity);

		    try {
		        pkField.setAccessible(true);
		        Object castedValue = castValueToFieldType(pkField, nextId);
		        pkField.set(entity, castedValue);
		    } catch (IllegalAccessException e) {
		        throw new GrowxException(
		                BaseError.GENERATE_SQL_PK_ERROR,
		                e
		        );
		    }

		    // 4. Build SQL + values
		    String sql =
		            generateInsertSQLWithPk(
		                    entity.getClass()
		            );

		    Object[] fieldValues =
		            getFieldValuesWithPk(entity);

		    // 5. Debug logging (unchanged behavior)
		    for (int i = 0; i < fieldValues.length; i++) {
		        Object value = fieldValues[i];
		        logger.debug(
		                "Param[{}]: '{}', Length: {}",
		                i,
		                value,
		                value instanceof String s ? s.length() : "N/A"
		        );
		    }

		    // 6. Execute insert
		    int status =
		            jdbcTemplate.update(
		                    sql,
		                    fieldValues
		            );

		    logger.info(
		            "Inserted, Count: {}, PID: {}",
		            status,
		            nextId
		    );

		    return entity;
		}


	@Override
	public <T extends GenericEntity> T saveForWkfCustomAudit(T entity) {
		logger.debug("Entering saveForWkfCustomAudit for entity: {}", entity);

		// DO NOT generate new PK — assume PK is already present
		populateAuditFieldsCustom(entity, true);

		Field primaryKeyField = getPrimaryKeyField(entity);
		primaryKeyField.setAccessible(true);

		Object pkValue;
		try {
			pkValue = primaryKeyField.get(entity);
		} catch (Exception e) {
			throw new GrowxException(BaseError.GENERATE_SQL_PK_ERROR);
		}

		if (pkValue == null) {
			throw new GrowxException("Primary Key must be set before calling saveForWkfCustomAudit()");
		}

		String sql = generateInsertSQLWithPk(entity.getClass());
		Object[] fieldValues = getFieldValuesWithPk(entity);

		int status = jdbcTemplate.update(sql, fieldValues);
		logger.info("Inserted with existing PK, Count: {}, PID: {}", status, pkValue);

		return entity;
	}

	@Override
	public T saveOrUpdateByKeyValue(T entity, Map<String, Object> keyValues) {
		if (entity == null || keyValues == null || keyValues.isEmpty()) {
			throw new IllegalArgumentException("Entity and keyValues must not be null or empty");
		}

		// Build dynamic WHERE clause
		StringBuilder whereClause = new StringBuilder();
		List<Object> params = new ArrayList<>();

		for (Map.Entry<String, Object> entry : keyValues.entrySet()) {
		    if (!whereClause.isEmpty()) {
		        whereClause.append(" AND ");
		    }
		    whereClause.append(camelToSnake(entry.getKey())).append(" = ?");
		    params.add(entry.getValue());
		}


		String sql = "SELECT * FROM " + getTableNameWithSchema() + " WHERE " + whereClause + " LIMIT 1";
		List<T> results = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(type), params.toArray());
		T found = results.isEmpty() ? null : results.get(0);

		if (found != null) {
			Object pkValue = getPrimaryKeyValue(found);
			if (pkValue == null) {
				throw new IllegalStateException("Primary key value is null for existing entity");
			}

			try {
				Field pkField = getPrimaryKeyField(entity);
				pkField.setAccessible(true);
				pkField.set(entity, pkValue);
			} catch (Exception e) {
				throw new GrowxException(BaseError.UNKNOWN_QUESTION);
			}

			return updateWithOutChanges(entity);
		} else {
			return saveWithOutChanges(entity);
		}
	}

	@Override
	public int hardDeleteById(int id) {
	    logger.debug("Hard deleting entity by id: {}", id);

	    String sql = "DELETE FROM " + getTableNameWithSchema()
	            + " WHERE tenant_id = ? AND " + camelToSnake(pk) + " = ?";

	    return jdbcTemplate.update(sql,
	            RequestHeaderUtil.getAppId(), // ✅ tenant ID first
	            id);
	}


	@Override
	public int hardDeleteByKeyValue(T entity, String key, Object value) {
	    logger.debug("Hard deleting entity by key: {}, value: {}", key, value);

	    String deleteSql = "DELETE FROM " + getTableNameWithSchema()
	            + " t WHERE tenant_id = ? AND " + camelToSnake(key) + " = ?";

	    return jdbcTemplate.update(
	            deleteSql,
	            RequestHeaderUtil.getAppId(), // ✅ tenant ID first
	            value
	    );
	}


	@Override
	public int hardDeleteWorkflowByWkfId(int wkfId) {
		logger.debug("Hard deleting workflow records by wkfId: {}", wkfId);
		String sql = "DELETE FROM " + getTableNameWithSchema() + " WHERE wkf_id = ?";
		int rowsDeleted = jdbcTemplate.update(sql, wkfId);
		logger.info("Deleted {} record(s) with wkf_id={}", rowsDeleted, wkfId);
		return rowsDeleted;
	}


	@Override
	public Long getCurrentSequence() {
		String seqName = getSchema()+"."+camelToSnake(pk) + "_seq";
		String sql = "SELECT last_value FROM " + seqName;
		return jdbcTemplate.queryForObject(sql, Long.class);
	}

	@Override
	public <T extends GenericEntity> List<T> saveAllForWorkflowWithoutChanges(List<T> entities) {
	
		    if (entities == null || entities.isEmpty()) {
		        return Collections.emptyList();
		    }

		    // 1. Fetch sequence ONCE
		    String sequenceName = getSchema()+"."+camelToSnake(pk) + "_seq";
		    Long nextId =
		            jdbcTemplate.queryForObject(
		                    "SELECT NEXTVAL('" + sequenceName + "')",
		                    Long.class
		            );

		    if (nextId == null) {
		        throw new GrowxException(BaseError.GENERATE_SQL_PK_ERROR);
		    }

		    // 2. Set SAME PK for all entities
		    Field pkField = getPrimaryKeyField(entities.get(0));

		    for (T entity : entities) {
		        try {
		            pkField.set(
		                    entity,
		                    castValueToFieldType(pkField, nextId)
		            );
		        } catch (IllegalAccessException e) {
		            throw new GrowxException(BaseError.GENERATE_SQL_PK_ERROR, e);
		        }
		    }

		    // 3. Populate audit fields
		    entities.forEach(e -> populateAuditFields1(e, true));

		    // 4. Prepare insert metadata
		    T firstEntity = entities.get(0);
		    List<Field> insertFields =
		            getAllFields(firstEntity.getClass());

		    String columns =
		            insertFields.stream()
		                    .map(f -> camelToSnake(f.getName()))
		                    .collect(Collectors.joining(", "));

		    String placeholders =
		            insertFields.stream()
		                    .map(f -> "?")
		                    .collect(Collectors.joining(", "));

		    StringBuilder sql =
		            new StringBuilder()
		                    .append("INSERT INTO ")
		                    .append(getTableNameWithSchema())
		                    .append(" (")
		                    .append(columns)
		                    .append(") VALUES ");

		    for (int i = 0; i < entities.size(); i++) {
		        sql.append("(").append(placeholders).append(")");
		        if (i < entities.size() - 1) {
		            sql.append(", ");
		        }
		    }

		    // 5. Collect values
		    List<Object> allValues = new ArrayList<>();

		    for (T entity : entities) {
		        for (Field field : insertFields) {
		            allValues.add(
		                    ReflectionUtils.getField(field, entity)
		            );
		        }
		    }

		    // 6. Execute insert
		    int inserted =
		            jdbcTemplate.update(
		                    sql.toString(),
		                    allValues.toArray()
		            );

		    logger.info(
		            "Bulk insert completed. Expected: {}, Inserted: {}",
		            entities.size(),
		            inserted
		    );

		    return entities;
		}

}