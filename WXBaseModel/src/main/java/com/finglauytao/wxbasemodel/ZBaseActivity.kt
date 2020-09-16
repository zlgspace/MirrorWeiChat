package com.finglauytao.wxbasemodel

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.finglauytao.wxbasemodel.life.ZLifeActivity

/**
 * Create on 2020/9/16
 *
 * @author RedTomatoCat
 * @date 2020/9/16
 * @version 1.0.0
 **/
abstract class ZBaseActivity : ZLifeActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(iniLayout())
        initView()
        initData()
    }

    @LayoutRes abstract fun iniLayout(): Int
    abstract fun initView()
    abstract fun initData()
}