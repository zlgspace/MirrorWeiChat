package com.zlgspace.mirrorweichat.state;

import com.zlgspace.singleinstancehelper.annotation.SingleInstance;

@SingleInstance("MirrorWeiChatCtroller")
public class State {

    private boolean isConnect2Svr = false;

    private boolean isAppForeground = false;

    public boolean isConnect2Svr() {
        return isConnect2Svr;
    }

    public void setConnect2Svr(boolean connect2Svr) {
        isConnect2Svr = connect2Svr;
    }

    public boolean isAppForeground() {
        return isAppForeground;
    }

    public void setAppForeground(boolean appForeground) {
        isAppForeground = appForeground;
    }
}
