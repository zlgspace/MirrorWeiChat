package com.zlgspace.mirrorweichat.msgparser.entity;

import com.mirrorweichat.wxservice.utils.GsonUtil;

public class BaseEntity {
    @Override
    public String toString() {
        return GsonUtil.toJson(this);
    }
}
