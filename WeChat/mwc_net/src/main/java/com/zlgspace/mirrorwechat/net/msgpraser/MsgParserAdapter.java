package com.zlgspace.mirrorwechat.net.msgpraser;

import android.os.Handler;

import androidx.annotation.UiThread;

import com.zlgspace.mirrorwechat.base.utils.GsonUtils;
import com.zlgspace.mirrorwechat.net.entity.req.MsgEntity;
import com.zlgspace.msgpraser.base.CallbackMsg;

public class MsgParserAdapter extends com.zlgspace.msgpraser.base.MsgParserAdapter<String,String> {

    private Handler handler = new Handler();

    @UiThread
    public MsgParserAdapter(){

    }

    @Override
    public CallbackMsg preParser(String msg) {
        MsgEntity me = GsonUtils.fromJson(msg, MsgEntity.class);
        CallbackMsg cm = new CallbackMsg();
        cm.setMsgHead(me.getMsgId());
        cm.setMsgBody(me.getMsgBody());
        return cm;
    }

    @Override
    public Object parser(String msg, Class clz) {
        return GsonUtils.fromJson(msg,clz);
    }

    @Override
    public boolean dispatchRstToMainThread(Runnable runable) {
        handler.post(runable);
        return true;
    }
}
