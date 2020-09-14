package com.zlgspace.mirrorweichat.net.msgparser;

import com.zlgspace.msgpraser.annotation.BindEntity;
import com.zlgspace.msgpraser.annotation.MessageDescription;

@MessageDescription
public enum MsgDefine {
    @BindEntity onSocketInited,
    @BindEntity onSocketConnected,
    @BindEntity onSocketDisConnected,
}
