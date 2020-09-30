package com.zlgspace.mirrorwechat.net.entity.rsp;


import com.zlgspace.mirrorwechat.net.entity.BaseEntity;

/**
 * Created by zl on 2020/9/30.
 */
public class RegisterRspEntity extends BaseEntity {
    public static final int ERROR_CODE_UNKNOWN = -1;
    public static final int ERROR_CODE_SUCCESS = 0;
    public static final int ERROR_CODE_USERNAME_EXIST = 1;

    private boolean registerRst;
    private int errCode;

    public boolean isRegisterRst() {
        return registerRst;
    }

    public void setRegisterRst(boolean registerRst) {
        this.registerRst = registerRst;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }
}
