package com.zlgspace.mirrorweichat.state;

import com.zlgspace.singleinstancehelper.annotation.SingleInstance;

@SingleInstance(clzName = "MirrorWeiChatCtroller",fieldName = "STATE")
public class State {

    private boolean isConnect2Svr = false;

    private boolean isAppForeground = false;

    private boolean isLogin = false;

    private boolean isWelcomeShowd = false;

    public boolean isConnect2Svr() {
        return isConnect2Svr;
    }

    public void setConnect2Svr(boolean connect2Svr) {
        isConnect2Svr = connect2Svr;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public boolean isWelcomeShowd() {
        return isWelcomeShowd;
    }

    public void setWelcomeShowd(boolean welcomeShowd) {
        isWelcomeShowd = welcomeShowd;
    }

    public boolean isAppForeground() {
        return isAppForeground;
    }

    public void setAppForeground(boolean appForeground) {
        isAppForeground = appForeground;
    }

}
