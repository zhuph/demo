package com.example.demo.utils;

import org.apache.ibatis.jdbc.SQL;

/**
 * @author 朱鹏辉
 * @date 2019/11/9 23:34
 */
public class SqlUtil {
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