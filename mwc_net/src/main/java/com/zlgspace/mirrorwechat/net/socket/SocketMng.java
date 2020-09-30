package com.zlgspace.mirrorwechat.net.socket;

import com.zlgspace.logadapter.LogPrint;
import com.zlgspace.mirrorwechat.net.constants.MsgDefine;
import com.zlgspace.msgpraser.MsgParser;
import com.zlgspace.simplesocket.MsgAnalysisAdapter;
import com.zlgspace.simplesocket.SimpleSocket;
import com.zlgspace.timerprincekin.TimeTask;
import com.zlgspace.timerprincekin.TimerPrincekin;

public final class SocketMng {
    private static final int PORT = 55564;
    private static final String SERVER_IP = "127.0.0.1";
    private static final long RECONNECT_TIME = 3*1000;

    private static SimpleSocket simpleSocket;
    private static boolean isManualStop = false;

    private static SimpleSocket.Callback<String> callback = new SimpleSocket.Callback<String>(){
        @Override
        public void onSocketInited() {
            MsgParser.sendEmptyMsg(MsgDefine.onSocketInited.toString());
        }

        @Override
        public void onSocketConnected() {
            MsgParser.sendEmptyMsg(MsgDefine.onSocketConnected.toString());
            Net.REQUESTER.bindSocket(simpleSocket);
        }

        @Override
        public void onSocketRcvMsg(String s) {
            LogPrint.d("SimpleSocketMng","onSocketRcvMsg,接收到来自服务端的消息："+s);
            MsgParser.parser(s);
        }

        @Override
        public void onSocketError(Exception e) {
            LogPrint.e("SimpleSocketMng","onSocketError",e);
        }

        @Override
        public void onSocketDisConnected() {
            MsgParser.sendEmptyMsg(MsgDefine.onSocketDisConnected.toString());
            Net.REQUESTER.unBindSocket();
            close();
            if(!isManualStop){
                TimeTask tt = new TimeTask();
                tt.setDelay(RECONNECT_TIME);
                tt.setExeCount(-1);//一直
                tt.setTask(() -> connect());
                //异常断链，每隔三秒重新链接
                TimerPrincekin.addTask(tt);
            }
        }

        @Override
        public void onSocketDestory() {
            LogPrint.d("SimpleSocketMng","onSocketDestory");
        }
    };

    public static void connect(){
        if(simpleSocket==null){
            simpleSocket = new SimpleSocket();
            simpleSocket.setSvrIp(SERVER_IP);
            simpleSocket.setSvrPort(PORT);
            simpleSocket.setCallback(callback);
            simpleSocket.setMsgAnalysisAdapter(new AnalysisAdapter());
        }
        isManualStop = false;
        simpleSocket.connect();
    }


    public static void close(){
        isManualStop = true;
        simpleSocket.close();
        simpleSocket = null;
    }

    private SocketMng(){}

    private static class AnalysisAdapter extends MsgAnalysisAdapter<String> {
        public String analysisMsg(byte msg[]){
            if(msg==null)
                return "NULL";
            return new String(msg);
        }
    }
}
