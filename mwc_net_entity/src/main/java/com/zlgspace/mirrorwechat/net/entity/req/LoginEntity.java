package com.zlgspace.mirrorwechat.net.entity.req;

import com.zlgspace.mirrorwechat.net.entity.BaseEntity;

/**
 * Created by zl on 2020/9/30.
 */
public class LoginEntity extends BaseEntity {
    private String username;
    private String password;//md5

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
