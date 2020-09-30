package com.zlgspace.mirrorwechat.net.socket;

import androidx.annotation.UiThread;

import com.zlgspace.mirrorwechat.net.msgpraser.MsgParserAdapter;
import com.zlgspace.msgpraser.MsgParser;
import com.zlgspace.singleinstancehelper.annotation.SingleInstance;

@SingleInstance(clzName = "Net",fieldName = "INIT")
public class NetInitialize {

    @UiThread
    public void init(){
        MsgParser.init(new MsgParserAdapter());
    }

}
