package com.zlgspace.mirrorwechat.net.constants;


import com.zlgspace.mirrorwechat.net.entity.rsp.FileDownloadRspEntity;
import com.zlgspace.mirrorwechat.net.entity.rsp.FriendListEntity;
import com.zlgspace.mirrorwechat.net.entity.rsp.LoginRspEntity;
import com.zlgspace.mirrorwechat.net.entity.rsp.RegisterRspEntity;
import com.zlgspace.mirrorwechat.net.entity.rsp.UserInfoEntity;
import com.zlgspace.msgpraser.annotation.BindEntity;
import com.zlgspace.msgpraser.annotation.MessageDescription;

@MessageDescription
public enum  RspConstants {
    @BindEntity(LoginRspEntity.class) onloginRsp,
    @BindEntity(RegisterRspEntity.class) onRegisterRsp,
    @BindEntity(UserInfoEntity.class) onDetailedRsp,
    @BindEntity(FriendListEntity.class) onFriendListRsp,
    @BindEntity(FileDownloadRspEntity.class) onFileDownloadRsp,
}
