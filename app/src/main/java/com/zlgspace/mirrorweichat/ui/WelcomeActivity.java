package com.zlgspace.mirrorweichat.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.zlgspace.mirrorweichat.R;
import com.zlgspace.mirrorweichat.state.MirrorWeiChatCtroller;
import com.zlgspace.mirrorweichat.ui.base.BaseActivity;
import com.zlgspace.timerprincekin.TimeTask;
import com.zlgspace.timerprincekin.TimerPrincekin;

public class WelcomeActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        if(MirrorWeiChatCtroller.isWelcomeShowd())
            toNextActivity();
        else
            TimerPrincekin.addTask(new TimeTask(5 * 1000, () -> toNextActivity()));
    }

    private void toNextActivity(){
        runOnUiThread(() -> {
            if(MirrorWeiChatCtroller.isLogin()){
                MirrorWeiChatCtroller.startActivity(MainActivity.class,true);
            }else{
                MirrorWeiChatCtroller.startActivity(LoginActivity.class,true);
            }
        });
    }
}
