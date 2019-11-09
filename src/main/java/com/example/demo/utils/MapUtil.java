package com.example.demo.utils;

import java.util.Map;

/**
 * @author 朱鹏辉
 * @date 2019/11/9 23:56
 */
public class MapUtil {

    /**
     * 正常获取键值对的值value，可能为null，为null时，给对象setValue时可能会出现NPE（空指针异常）--不安全
     *
     * @param map
     * @param key
     * @param <T>
     * @param <K>
     * @return
     */
    public static <T, K extends T> K getValue(Map<T, K> map, T key) {
        Assert.notNull(key, "键key不能为空");
        Assert.cannotEmpty(map, "集合map不能为空");
        Assert.mustContain(map, key, "键值对map中必须存在这个key");
        return map.get(key);
    }

    /**
     * 在getValue((Map<T, K> map, T key)在此封装一次，在value为null时返回一个"null"字符串--安全
     *
     * @param map
     * @param key
     * @param <T>
     * @param <K>
     * @return
     */
    public static <T, K extends T> K getSafeValueToStringNull(Map<T, K> map, T key) {
        return getValue(map, key) == null ? (K) "null" : getValue(map, key);
    }
}