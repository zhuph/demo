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


