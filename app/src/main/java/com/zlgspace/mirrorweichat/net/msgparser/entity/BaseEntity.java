package com.zlgspace.mirrorweichat.net.msgparser.entity;

import com.zlgspace.mirrorweichat.utils.GsonUtil;

public class BaseEntity {
    @Override
    public String toString() {
        return GsonUtil.toJson(this);
    }
}
