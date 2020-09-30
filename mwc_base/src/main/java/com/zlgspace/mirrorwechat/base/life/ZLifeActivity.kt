package com.zlgspace.mirrorwechat.base.life

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner

/**
 * Create on 2020/9/16
 *
 * @author RedTomatoCat
 * @date 2020/9/16
 * @version 1.0.0
 **/
open class ZLifeActivity : AppCompatActivity(), LifecycleOwner, ZFullLifecycleObserver {

    private var mZFullLifecycleObserver: ZFullLifecycleObserver? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(this)
    }

    fun setLifeCallBack(observer: ZFullLifecycleObserver?) {
        mZFullLifecycleObserver = observer
    }

    override fun onCreate(owner: LifecycleOwner?) {
        if (mZFullLifecycleObserver != null) mZFullLifecycleObserver!!.onCreate(owner)
    }

    override fun onStart(owner: LifecycleOwner?) {
        if (mZFullLifecycleObserver != null) mZFullLifecycleObserver!!.onStart(owner)
    }

    override fun onResume(owner: LifecycleOwner?) {
        if (mZFullLifecycleObserver != null) mZFullLifecycleObserver!!.onResume(owner)
    }

    override fun onPause(owner: LifecycleOwner?) {
        if (mZFullLifecycleObserver != null) mZFullLifecycleObserver!!.onPause(owner)
    }

    override fun onStop(owner: LifecycleOwner?) {
        if (mZFullLifecycleObserver != null) mZFullLifecycleObserver!!.onStop(owner)
    }

    override fun onDestroy(owner: LifecycleOwner?) {
        if (mZFullLifecycleObserver != null) mZFullLifecycleObserver!!.onDestroy(owner)
    }

}