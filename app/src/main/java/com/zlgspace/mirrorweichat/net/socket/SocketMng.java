package com.zlgspace.mirrorweichat.net.socket;

import com.zlgspace.logadapter.LogPrint;
import com.zlgspace.mirrorweichat.net.msgparser.MsgDefine;
import com.zlgspace.msgpraser.MsgParser;
import com.zlgspace.simplesocket.MsgAnalysisAdapter;
import com.zlgspace.simplesocket.SimpleSocket;

public final class SocketMng {

    private static final int PORT = 55564;

    private static final String SERVER_IP = "127.0.0.1";

    private static SimpleSocket simpleSocket;

    private static SimpleSocket.Callback<String> callback = new SimpleSocket.Callback<String>(){
        @Override
        public void onSocketInited() {
            MsgParser.sendEmptyMsg(MsgDefine.onSocketInited.toString());
        }

        @Override
        public void onSocketConnected() {
            MsgParser.sendEmptyMsg(MsgDefine.onSocketConnected.toString());
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
        simpleSocket.connect();
    }


    public static void close(){
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
