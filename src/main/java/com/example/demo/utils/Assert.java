package com.example.demo.utils;

import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Map;

/**
 * org.springframework.util.ObjectUtils
 * org.springframework.util.CollectionUtils
 * 条件判断 expression
 * 字符串 String
 * 枚举 Enum
 * 数组 Array
 * 集合 collection(List Set)
 * 键值对 Map
 *
 * @author 朱鹏辉
 * @date 2019/11/8 18:07
 */
public class Assert {

    /**
     * 表达式必须正确
     *
     * @param expression
     * @param message
     */
    public static void mustTrue(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 表达式必须错误
     *
     * @param expression
     * @param message
     */
    public static void mustFalse(boolean expression, String message) {
        if (expression) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 对象必须为空
     *
     * @param object
     * @param message
     */
    public static void mustNull(Object object, String message) {
        if (!StringUtils.isEmpty(object)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 对象不能为空
     *
     * @param object
     * @param message
     */
    public static void notNull(Object object, String message) {
        if (StringUtils.isEmpty(object)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 枚举判断
     *
     * @param enumValues 枚举类（多实例）
     * @param constant   是否区分大小写
     * @param message    错误提示
     */
    public static void mustContain(Enum<?>[] enumValues, String constant, String message) {
        if (!ObjectUtils.containsConstant(enumValues, constant, true)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 此数组不能为空
     *
     * @param array
     * @param message
     */
    public static void cannotEmpty(Object[] array, String message) {
        if (ObjectUtils.isEmpty(array)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 此数组必须包含此元素
     *
     * @param array
     * @param element
     * @param message
     */
    public static void mustContain(Object[] array, Object element, String message) {
        if (!ObjectUtils.containsElement(array, element)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 此数组不能包含此对象
     *
     * @param array
     * @param element
     * @param message
     */
    public static void cannotContain(Object[] array, Object element, String message) {
        if (ObjectUtils.containsElement(array, element)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 此集合不能为空
     *
     * @param collection
     * @param message
     */
    public static void cannotEmpty(Collection<?> collection, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 此集合必须包含此对象
     *
     * @param collection
     * @param element
     * @param message
     */
    public static void mustContain(Collection<?> collection, Object element, String message) {
        if (!CollectionUtils.containsInstance(collection, element)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 此集合不能包含此对象
     *
     * @param collection
     * @param element
     * @param message
     */
    public static void cannotContain(Collection<?> collection, Object element, String message) {
        cannotEmpty(collection, "map不能为空");
        if (CollectionUtils.containsInstance(collection, element)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 此键值对不能为空
     *
     * @param map
     * @param message
     */
    public static void cannotEmpty(Map<?, ?> map, String message) {
        if (CollectionUtils.isEmpty(map)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 此键值对中必须得包含这个键
     *
     * @param map
     * @param key
     * @param message
     */
    public static void mustContain(Map<?, ?> map, Object key, String message) {
        cannotEmpty(map, "map不能为空");
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 此键值对中不能包含这个键
     *
     * @param map
     * @param key
     * @param message
     */
    public static void cannotContain(Map<?, ?> map, Object key, String message) {
        cannotEmpty(map, "map不能为空");
        if (map.containsKey(key)) {
            throw new IllegalArgumentException(message);
        }
    }
}


