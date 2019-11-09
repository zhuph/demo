package com.example.demo.utils;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.lang.Nullable;

import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.util.Map;
import java.util.function.Predicate;

/**
 * sql 操作工具--仿写Fastsql
 *
 * @author 朱鹏辉
 * @date 2019/11/8 17:53
 */
public class Util {

}

class SqlUtil {
    /**
     * mybatis 自带SQL语句构建器类--建议自己在mapper中，自定义该方法
     *
     * @return
     */
    public static SQL getSql() {
        return new SQL();
    }

    /**
     * 模糊匹配
     *
     * @param likeField name
     * @return %name%
     */
    public static String bothPercent(String likeField) {
        return "%" + likeField + "%";
    }

    public static String leftPercent(String likeField) {
        return "%" + likeField;
    }

    public static String rightPercent(String likeField) {
        return likeField + "%";
    }


}

class StringUtil {


}

class ObjectUtil {

    /**
     * 安全获取对象属性，防止在给其他属性setValue时出现NPE(空指针异常)
     *
     * @param value
     * @param <T>
     * @param <K>
     * @return
     */
    public static <T, K extends T> T getValueOrSafeStringNull(T value) {
        if (null == value) {
            return (T) "null";
        } else {
            return value;
        }
    }

}

class MapUtil {

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