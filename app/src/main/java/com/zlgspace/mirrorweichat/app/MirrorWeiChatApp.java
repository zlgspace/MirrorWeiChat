package com.zlgspace.mirrorweichat.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.zlgspace.logadapter.LogPrint;
import com.zlgspace.mirrorweichat.log.CustomLogAdapter;
import com.zlgspace.mirrorweichat.net.msgparser.MsgParserAdapter;
import com.zlgspace.msgpraser.MsgParser;
import com.zlgspace.msgpraser.annotation.CallbackMethod;
import com.zlgspace.timerprincekin.TimerPrincekin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MirrorWeiChatApp extends Application {

    private static  MirrorWeiChatApp instance;

    public static MirrorWeiChatApp getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //日志
        LogPrint.init(new CustomLogAdapter());
        //初始化消息解析器
        MsgParser.init(new MsgParserAdapter());
        //注册全局消息监听器，用来维护状态或者消息记录
        MsgParser.register(new MirrorWeiChatAppGlobal());
        //启动定时管理器TimeTask:计时任务，TimerTask：定时任务
        TimerPrincekin.start();
        //前后台状态监听器
        registerForegroundObserver();
        //链接服务器
//        SocketMng.connect();
        LogPrint.v("MirrorWeiChatApp","MirrorWeiChatApp inited!");
    }

    private void registerForegroundObserver(){
        registerActivityLifecycleCallbacks(new ForegroundObserver());
    }
}
