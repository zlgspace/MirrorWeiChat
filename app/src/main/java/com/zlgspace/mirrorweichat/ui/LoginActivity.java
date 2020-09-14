package com.zlgspace.mirrorweichat.ui;

import android.Manifest;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.zlgspace.easyreqpermission.EasyReqPermission;
import com.zlgspace.easyreqpermission.annotation.ForbidPermission;
import com.zlgspace.easyreqpermission.annotation.NeedPermission;
import com.zlgspace.easyreqpermission.annotation.ProclaimPermission;
import com.zlgspace.easyreqpermission.annotation.RefusePermission;
import com.zlgspace.mirrorweichat.R;
import com.zlgspace.mirrorweichat.state.MirrorWeiChatCtroller;
import com.zlgspace.mirrorweichat.ui.base.BaseActivity;
import com.zlgspace.msgpraser.annotation.CallbackMethod;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class LoginActivity extends BaseActivity {

    public Button toMainBtn;

    private LoginActivity_ReqPermission reqPermission;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        reqPermission = EasyReqPermission.bind(this);

        toMainBtn = findViewById(R.id.toMainBtn);
        toMainBtn.setOnClickListener(view -> reqPermission.toMainActivity());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        reqPermission.onRequestPermissionsResult(requestCode,permissions,grantResults);
    }


    //需要权限
    @NeedPermission(permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE},identifier = "toMainActivity")
    public void toMainActivity(){
        MirrorWeiChatCtroller.startActivity(MainActivity.class,true);
    }

    //宣告权限
    @ProclaimPermission(identifier = "toMainActivity")
    public void proclaimToMainActivityPermission(){
//        MirrorWeiChatCtroller.startActivity(MainActivity.class,true);
        new AlertDialog.Builder(this)
                .setTitle("重要")
                .setMessage("MirrorWeiChat 正常运行需要文件读写权限")
                .setPositiveButton("允许", (dialogInterface, i) -> {
                    reqPermission.goOn();
                })
                .setNegativeButton("拒绝", (dialogInterface, i) -> {
                    refuseToMainActivityPermission();
                    reqPermission.end();
                })
                .show();
    }

    //拒绝权限
    @RefusePermission(identifier = "toMainActivity")
    public void refuseToMainActivityPermission(){
        Toast.makeText(this, "拒绝了权限！", Toast.LENGTH_SHORT).show();
    }

    //禁用权限--应该提示跳转到系统设置权限处
    @ForbidPermission(identifier = "toMainActivity")
    public void forbidToMainActivityPermission(){
        Toast.makeText(this, "禁用了权限！", Toast.LENGTH_SHORT).show();
    }

    //MsgParser 有Bug，必须有@CallbackMethod函数，否则会报错，这个后续改下
    @CallbackMethod
    public void onSocketConnected() {
        super.onSocketConnected();
    }

    @CallbackMethod
    public void onSocketDisConnected() {
        super.onSocketDisConnected();
    }
}
