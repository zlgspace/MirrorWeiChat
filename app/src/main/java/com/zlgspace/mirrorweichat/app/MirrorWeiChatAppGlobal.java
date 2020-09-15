package com.zlgspace.mirrorweichat.app;


import com.zlgspace.logadapter.LogPrint;
import com.zlgspace.mirrorweichat.state.MirrorWeiChatCtroller;
import com.zlgspace.msgpraser.annotation.CallbackMethod;

public class MirrorWeiChatAppGlobal extends BaseMirrorWeiChatAppGlobal {

    @CallbackMethod
    public void onSocketConnected(){
        LogPrint.d("MirrorWeiChatApp","onSocketConnected");
        MirrorWeiChatCtroller.setConnect2Svr(true);
    }

    @CallbackMethod
    public void onSocketDisConnected(){
        LogPrint.d("MirrorWeiChatApp","onSocketDisConnected");
        MirrorWeiChatCtroller.setConnect2Svr(false);
    }

}
