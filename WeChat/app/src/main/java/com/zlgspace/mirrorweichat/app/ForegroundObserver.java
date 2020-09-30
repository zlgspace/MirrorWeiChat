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
        MirrorWeiChatCtroller.ACTIVITYSTACK.addActivityToStack(activity);
        LogPrint.v("ForegroundObserver",activity.getClass().getSimpleName()+" add to stack!");
    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {
        MirrorWeiChatCtroller.ACTIVITYSTACK.setForegroundActivity(activity);
        if(!MirrorWeiChatCtroller.STATE.isAppForeground()) {
            MirrorWeiChatCtroller.STATE.setAppForeground(true);
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
        if(MirrorWeiChatCtroller.ACTIVITYSTACK.getForegroundActivity() == activity){
            MirrorWeiChatCtroller.ACTIVITYSTACK.setForegroundActivity(null);
            MirrorWeiChatCtroller.STATE.setAppForeground(false);
            LogPrint.v("ForegroundObserver","app exit to the background！");
        }
    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {
        MirrorWeiChatCtroller.ACTIVITYSTACK.removeActivityFromStack(activity);
        LogPrint.v("ForegroundObserver",activity.getClass().getSimpleName()+" remove from stack!");
    }
}
