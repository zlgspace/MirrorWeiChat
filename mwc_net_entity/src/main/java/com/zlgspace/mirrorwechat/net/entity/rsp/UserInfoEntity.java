package com.zlgspace.mirrorwechat.net.entity.rsp;


import com.zlgspace.mirrorwechat.net.entity.BaseEntity;

/**
 * Created by zl on 2020/9/30.
 */
public class UserInfoEntity extends BaseEntity {
    private String username;//用户名
    private String nikename;//昵称
    private String imgUrl;//图像链接
    private String remarkName;//备注
    private String signature;//签名

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNikename() {
        return nikename;
    }

    public void setNikename(String nikename) {
        this.nikename = nikename;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getRemarkName() {
        return remarkName;
    }

    public void setRemarkName(String remarkName) {
        this.remarkName = remarkName;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
