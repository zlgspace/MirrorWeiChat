package com.zlgspace.mirrorweichat.ui;

import android.os.Bundle;

import com.zlgspace.mirrorweichat.R;
import com.zlgspace.mirrorweichat.ui.base.BaseActivity;
import com.zlgspace.msgpraser.annotation.CallbackMethod;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @CallbackMethod
    public void onSocketDisConnected() {
        super.onSocketDisConnected();
    }
}
