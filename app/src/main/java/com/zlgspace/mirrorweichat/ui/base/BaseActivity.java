package com.zlgspace.mirrorweichat.ui.base;


import android.os.Bundle;

import com.zlgspace.logadapter.LogPrint;
import com.zlgspace.msgpraser.MsgParser;

import androidx.annotation.Nullable;

public class BaseActivity extends MsgAdapterActivity {

    protected final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogPrint.v(TAG,"onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogPrint.v(TAG,"onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogPrint.v(TAG,"onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogPrint.v(TAG,"onResume");
        MsgParser.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogPrint.v(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogPrint.v(TAG,"onStop");
        MsgParser.unRegister(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogPrint.v(TAG,"onDestroy");
    }
}
