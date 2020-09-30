package com.zlgspace.mirrorwechat.net.constants;

import com.zlgspace.mirrorwechat.net.entity.req.LoginEntity;
import com.zlgspace.mirrorwechat.net.entity.rsp.FileDownloadRspEntity;
import com.zlgspace.mirrorwechat.net.entity.rsp.FriendListEntity;
import com.zlgspace.mirrorwechat.net.entity.rsp.LoginRspEntity;
import com.zlgspace.mirrorwechat.net.entity.rsp.RegisterRspEntity;
import com.zlgspace.mirrorwechat.net.entity.rsp.UserInfoEntity;
import com.zlgspace.msgpraser.annotation.BindEntity;
import com.zlgspace.msgpraser.annotation.MessageDescription;

@MessageDescription
public enum MsgDefine {
    @BindEntity onSocketInited,
    @BindEntity onSocketConnected,
    @BindEntity onSocketDisConnected,
}
