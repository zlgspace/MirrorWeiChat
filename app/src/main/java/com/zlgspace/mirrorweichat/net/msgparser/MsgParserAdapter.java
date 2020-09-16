package com.zlgspace.mirrorweichat.net.msgparser;

import android.os.Handler;

import androidx.annotation.UiThread;

import com.zlgspace.mirrorweichat.net.msgparser.entity.MsgEntity;
import com.mirrorweichat.wxservice.utils.GsonUtil;
import com.zlgspace.msgpraser.base.CallbackMsg;

public class MsgParserAdapter extends com.zlgspace.msgpraser.base.MsgParserAdapter<String,String> {

    private Handler handler = new Handler();

    @UiThread
    public MsgParserAdapter(){

    }

    @Override
    public CallbackMsg preParser(String msg) {
        MsgEntity me = GsonUtil.fromJson(msg, MsgEntity.class);
        CallbackMsg cm = new CallbackMsg();
        cm.setMsgHead(me.getMsgId());
        cm.setMsgBody(me.getMsgBody());
        return cm;
    }

    @Override
    public Object parser(String msg, Class clz) {
        return GsonUtil.fromJson(msg,clz);
    }

    @Override
    public boolean dispatchRstToMainThread(Runnable runable) {
        handler.post(runable);
        return true;
    }
}
