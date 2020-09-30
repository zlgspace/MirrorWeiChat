package com.zlgspace.mirrorweichat.state;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.zlgspace.logadapter.LogPrint;
import com.zlgspace.singleinstancehelper.annotation.SingleInstance;

import java.util.ArrayList;

@SingleInstance(clzName = "MirrorWeiChatCtroller",fieldName = "ACTIVITYSTACK")
public class ActivityStack {

    ArrayList<Activity> activityStack = new ArrayList<>();

    private Activity foregroundActivity;

    public void addActivityToStack(Activity activity){
        activityStack.add(activity);
    }

    public void removeActivityFromStack(Activity activity){
        activityStack.remove(activity);
    }

    public void removeAllActivityFromStack(){
        for(Activity activity:activityStack){
            activity.finish();
        }
        activityStack.clear();
    }

    public Activity getForegroundActivity(){
        return foregroundActivity;
    }

    public void setForegroundActivity(Activity activity){
        foregroundActivity = activity;
    }

    public void startActivity(Class<? extends Activity> clz){
        startActivity(clz,null);
    }

    public void startActivity(Class<? extends Activity> clz,boolean isFinish){
        startActivity(clz,null,isFinish);
    }

    public void startActivity(Class<? extends Activity> clz,Bundle bundle){
        startActivity(clz,bundle,false);
    }

    public void startActivity(Class<? extends Activity> clz,Bundle bundle,boolean isFinish){
        if(foregroundActivity==null){
            LogPrint.w("ActivityStack","start Activity failed! foregroundActivity is null");
            return ;
        }
        Intent intent = new Intent(foregroundActivity,clz);
        if(bundle!=null)
            intent.putExtras(bundle);
        foregroundActivity.startActivity(intent);
        if(isFinish)
            foregroundActivity.finish();
    }

}
