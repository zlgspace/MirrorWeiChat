package com.zlgspace.mirrorweichat.app;

import android.app.Application;

import com.zlgspace.logadapter.LogPrint;
import com.zlgspace.mirrorweichat.log.CustomLogAdapter;
import com.zlgspace.mirrorweichat.msgparser.MsgParserAdapter;
import com.zlgspace.msgpraser.MsgParser;
import com.zlgspace.msgpraser.annotation.CallbackMethod;
import com.zlgspace.timerprincekin.TimerPrincekin;

public class MirrorWeiChatApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //日志
        LogPrint.init(new CustomLogAdapter());
        //初始化消息解析器
        MsgParser.init(new MsgParserAdapter());
        //启动定时管理器TimeTask:计时任务，TimerTask：定时任务
        TimerPrincekin.start();
        //链接服务器
//        SocketMng.connect();

        LogPrint.v("MirrorWeiChatApp","MirrorWeiChatApp inited!");
    }

    @CallbackMethod
    public void onSocketConnected(){
        LogPrint.d("MirrorWeiChatApp","onSocketConnected");
    }

    @CallbackMethod
    public void onSocketDisConnected(){
        LogPrint.d("MirrorWeiChatApp","onSocketDisConnected");
    }
}
