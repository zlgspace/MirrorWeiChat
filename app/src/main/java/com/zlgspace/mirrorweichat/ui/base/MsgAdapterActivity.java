package com.zlgspace.mirrorweichat.ui.base;

import android.app.Activity;

import com.zlgspace.mirrorwechat.net.constants.MsgDefine_Callback;
import com.zlgspace.mirrorwechat.net.constants.RspConstants_Callback;
import com.zlgspace.mirrorwechat.net.entity.rsp.FileDownloadRspEntity;
import com.zlgspace.mirrorwechat.net.entity.rsp.FriendListEntity;
import com.zlgspace.mirrorwechat.net.entity.rsp.LoginRspEntity;
import com.zlgspace.mirrorwechat.net.entity.rsp.RegisterRspEntity;
import com.zlgspace.mirrorwechat.net.entity.rsp.UserInfoEntity;


public class MsgAdapterActivity extends Activity implements MsgDefine_Callback, RspConstants_Callback {
    @Override
    public void onSocketInited() {

    }

    @Override
    public void onSocketConnected() {

    }

    @Override
    public void onSocketDisConnected() {

    }

    @Override
    public void onloginRsp(LoginRspEntity arg) {

    }

    @Override
    public void onRegisterRsp(RegisterRspEntity arg) {

    }

    @Override
    public void onDetailedRsp(UserInfoEntity arg) {

    }

    @Override
    public void onFriendListRsp(FriendListEntity arg) {

    }

    @Override
    public void onFileDownloadRsp(FileDownloadRspEntity arg) {

    }
}
