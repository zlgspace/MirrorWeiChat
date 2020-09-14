package com.zlgspace.mirrorweichat.msgparser.entity;

import com.zlgspace.mirrorweichat.utils.GsonUtil;

public class BaseEntity {
    @Override
    public String toString() {
        return GsonUtil.toJson(this);
    }
}
