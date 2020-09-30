package com.zlgspace.mirrorwechat.net.entity.rsp;

import com.zlgspace.mirrorwechat.net.entity.BaseEntity;

/**
 * Created by zl on 2020/9/30.
 */
public class LoginRspEntity extends BaseEntity {
    public static final int ERROR_CODE_UNKNOWN = -1;
    public static final int ERROR_CODE_SUCCESS = 0;
    public static final int ERROR_CODE_USERNAME_NOT_EXIST = 1;
    public static final int ERROR_CODE_PASSWORD_ERROR = 2;

    private String username;
    private boolean loginRst;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isLoginRst() {
        return loginRst;
    }

    public void setLoginRst(boolean loginRst) {
        this.loginRst = loginRst;
    }
}
