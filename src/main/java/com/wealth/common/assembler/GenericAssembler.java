package com.wealth.common.assembler;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.wealth.common.generic.BaseError;
import com.wealth.common.generic.GrowxException;

@Component
public class GenericAssembler {

    private static final Map<Class<?>, Map<String, Field>> FIELD_CACHE = new HashMap<>();
    private static final Map<String, List<FieldPair>> FIELD_PAIR_CACHE = new HashMap<>();
    private static final Map<Class<?>, java.lang.reflect.Constructor<?>> CONSTRUCTOR_CACHE = new HashMap<>();

    /* ===================== LIST CONVERSIONS ===================== */

    public static <D, E> List<E> toEntityList(List<D> dtoList, Class<E> entityClass) {
        List<E> entityList = new ArrayList<>();
        for (D dto : dtoList) {
            entityList.add(toEntity(dto, entityClass));
        }
        return entityList;
    }

    public static <E, D> List<D> toDTOList(List<E> entityList, Class<D> dtoClass) {
        return entityList
                .stream()
                .map(entity -> toDTO(entity, dtoClass))
                .toList(); // ✅ Sonar fix
    }

    /* ===================== SINGLE CONVERSIONS ===================== */

    public static <D, E> E toEntity(D dto, Class<E> entityClass) {
        E entity = newInstance(entityClass);
        copyFields(dto, entity);
        return entity;
    }

    public static <E, D> D toDTO(E entity, Class<D> dtoClass) {
        D dto = newInstance(dtoClass);
        copyFields(entity, dto);
        return dto;
    }

    /* ===================== FIELD COPY ===================== */

    public static void copyFields(Object source, Object target) {
        List<FieldPair> pairs =
                getCachedFieldPairs(source.getClass(), target.getClass());

        for (FieldPair pair : pairs) {
            try {
                Object value = pair.source.get(source);
                applyValue(pair.source, pair.target, value, target);
            } catch (IllegalAccessException ignored) {
                // intentionally ignored
            }
        }
    }

    /* ===================== TYPE HANDLING ===================== */

    private static void applyValue(
            Field sourceField,
            Field targetField,
            Object value,
            Object target) throws IllegalAccessException {

        if (handleSpecialConversions(sourceField, targetField, value, target)) {
            return;
        }

        if (targetField.getType().isAssignableFrom(sourceField.getType())) {
            targetField.set(target, value);
        }
    }

    private static boolean handleSpecialConversions(
            Field sourceField,
            Field targetField,
            Object value,
            Object target) throws IllegalAccessException {

        Class<?> src = sourceField.getType();
        Class<?> tgt = targetField.getType();

        if (src == Integer.class && tgt == Boolean.class) {
            targetField.set(target, value != null && ((Integer) value) == 1);
            return true;
        }

        if (src == Boolean.class && tgt == Integer.class) {
            targetField.set(target, Boolean.TRUE.equals(value) ? 1 : 0);
            return true;
        }

        if (src == String.class && tgt == char.class) {
            String str = (String) value;
            targetField.setChar(target,
                    (str != null && !str.isEmpty()) ? str.charAt(0) : '\0');
            return true;
        }

        if (src == String.class && tgt == Character.class) {
            String str = (String) value;
            targetField.set(target,
                    (str != null && !str.isEmpty()) ? str.charAt(0) : null);
            return true;
        }

        return false;
    }

    /* ===================== CACHING ===================== */

    private static Map<String, Field> getCachedFields(Class<?> clazz) {
        return FIELD_CACHE.computeIfAbsent(clazz, c -> {
            Map<String, Field> map = new HashMap<>();
            Class<?> current = c;

            while (current != null && current != Object.class) {
                for (Field field : current.getDeclaredFields()) {
                    field.setAccessible(true);
                    map.putIfAbsent(field.getName(), field);
                }
                current = current.getSuperclass();
            }
            return map;
        });
    }

    private static List<FieldPair> getCachedFieldPairs(
            Class<?> sourceClass,
            Class<?> targetClass) {

        String key = sourceClass.getName() + "->" + targetClass.getName();

        return FIELD_PAIR_CACHE.computeIfAbsent(key, k -> {
            Map<String, Field> targetFields =
                    getCachedFields(targetClass);

            List<FieldPair> pairs = new ArrayList<>();
            Class<?> current = sourceClass;

            while (current != null && current != Object.class) {
                for (Field sf : current.getDeclaredFields()) {
                    Field tf = targetFields.get(sf.getName());
                    if (tf != null) {
                        sf.setAccessible(true);
                        tf.setAccessible(true);
                        pairs.add(new FieldPair(sf, tf));
                    }
                }
                current = current.getSuperclass();
            }
            return pairs;
        });
    }

    /* ===================== INSTANTIATION ===================== */

    private static <T> T newInstance(Class<T> clazz) {
        try {
            var constructor =
                    CONSTRUCTOR_CACHE.computeIfAbsent(clazz, c -> {
                        try {
                            var ctor = c.getDeclaredConstructor();
                            ctor.setAccessible(true);
                            return ctor;
                        } catch (Exception e) {
                            throw new GrowxException(BaseError.ASSEMBLER_ERROR);
                        }
                    });

            @SuppressWarnings("unchecked")
            T instance = (T) constructor.newInstance();
            return instance;

        } catch (InstantiationException
                 | IllegalAccessException
                 | InvocationTargetException e) {
            throw new GrowxException(BaseError.ASSEMBLER_ERROR);
        }
    }

    /* ===================== HELPER ===================== */

    private static final class FieldPair {
        private final Field source;
        private final Field target;

        private FieldPair(Field source, Field target) {
            this.source = source;
            this.target = target;
        }
    }
}
