package com.zlgspace.mirrorwechat.net.entity.req;

import com.zlgspace.mirrorwechat.net.entity.BaseEntity;

/**
 * Created by zl on 2020/9/30.
 */
public class RegisterEntity extends BaseEntity {
    private String nickname;
    private String userName;
    private String password;//md5

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
