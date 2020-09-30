package com.zlgspace.mirrorwechat.net.socket;


import com.zlgspace.logadapter.LogPrint;
import com.zlgspace.mirrorwechat.base.utils.GsonUtils;
import com.zlgspace.mirrorwechat.net.constants.ReqConstants;
import com.zlgspace.mirrorwechat.net.entity.req.LoginEntity;
import com.zlgspace.mirrorwechat.net.entity.req.MsgEntity;
import com.zlgspace.mirrorwechat.net.entity.req.RegisterEntity;
import com.zlgspace.simplesocket.SimpleSocket;
import com.zlgspace.singleinstancehelper.annotation.SingleInstance;


@SingleInstance(clzName = "Net",fieldName = "REQUESTER")
public class NetRequseter {

    private SimpleSocket socket;

    void bindSocket(SimpleSocket socket){
        synchronized (this){
            this.socket = socket;
        }
    }

    void unBindSocket(){
        synchronized (this){
            this.socket = null;
        }
    }

    public void reqRegister(RegisterEntity register){
        String bodyStr = GsonUtils.toJson(register);
        req(ReqConstants.onReqRegister,bodyStr);
    }

    public void reqLogin(LoginEntity loginEntity){
        String bodyStr = GsonUtils.toJson(loginEntity);
        req(ReqConstants.onReqLogin,bodyStr);
    }

    public void reqFriendList(String username){
        req(ReqConstants.onReqFirendList,username);
    }


    public void req(ReqConstants reqEvent,String msgBody){
        MsgEntity msgEntity = new MsgEntity();
        msgEntity.setMsgId(reqEvent.toString());
        msgEntity.setMsgBody(msgBody);
        synchronized (this) {
            if(socket!=null&&socket.isConnected())
                socket.sendMsg(GsonUtils.toJson(msgEntity));
            else
                LogPrint.w("NetRequseter","req "+reqEvent.toString()+" failed,socket is null or not connected!");
        }
    }
}
