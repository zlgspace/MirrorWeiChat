package com.zlgspace.mirrorweichat.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.zlgspace.logadapter.LogPrint;
import com.zlgspace.mirrorweichat.state.MirrorWeiChatCtroller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * 目前只能start-pause,来管控APP是否在前台
 */
public class ForegroundObserver implements Application.ActivityLifecycleCallbacks {
    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        MirrorWeiChatCtroller.addActivityToStack(activity);
        LogPrint.v("ForegroundObserver",activity.getClass().getSimpleName()+" add to stack!");
    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {
        MirrorWeiChatCtroller.setForegroundActivity(activity);
        if(!MirrorWeiChatCtroller.isAppForeground()) {
            MirrorWeiChatCtroller.setAppForeground(true);
            LogPrint.v("ForegroundObserver","app enter the foreground！");
        }
    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {
    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {
    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {
        if(MirrorWeiChatCtroller.getForegroundActivity() == activity){
            MirrorWeiChatCtroller.setForegroundActivity(null);
            MirrorWeiChatCtroller.setAppForeground(false);
            LogPrint.v("ForegroundObserver","app exit to the background！");
        }
    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {
        MirrorWeiChatCtroller.removeActivityFromStack(activity);
        LogPrint.v("ForegroundObserver",activity.getClass().getSimpleName()+" remove from stack!");
    }
}
