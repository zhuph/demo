package com.example.demo.domain;

import cn.hutool.core.clone.CloneRuntimeException;
import cn.hutool.core.clone.CloneSupport;
import cn.hutool.core.clone.Cloneable;
import lombok.Data;

/**
 * @author 朱鹏辉
 * @date 2019/11/4 10:08
 */
@Data
public class User implements Cloneable<User> {

    private User user;

    @Override
    public User clone() {
        try {
            return (User) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new CloneRuntimeException(e);
        }
    }
}
