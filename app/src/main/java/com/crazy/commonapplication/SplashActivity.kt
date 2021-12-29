package com.crazy.commonapplication

import android.os.Build
import android.os.CountDownTimer
import android.view.View
import android.view.WindowInsets
import com.alibaba.android.arouter.launcher.ARouter
import com.beyondsoft.smarthome.utils.logs.LogTag
import com.crazy.baseimagegallery.base.ui.activity.BaseActivity
import com.crazy.baseimagegallery.util.arouter.RouterPath
import com.crazy.commonapplication.databinding.ActivitySplashBinding

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: SplashActivity
 * Author: zy
 * Date: 2021/11/12 16:59
 * Description: 启动页
 * History:

 */
class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    private val countDownInterval: Long = 1 * 1000
    override fun getViewBinding(): ActivitySplashBinding {
        return ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun isSetPaddingTop(): Boolean {
        return false
    }

    override fun initView() {
        hideBottomUIMenu()
    }

    override fun initData() {

        object : CountDownTimer(countDownInterval,1000) {
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
//                val intent = Intent(mContext,MainActivity::class.java)
//                startActivity(intent)
                ARouter.getInstance().build(RouterPath.Home.home).navigation()
                ARouter.getInstance().build(RouterPath.Service.s1).navigation()
//                finish()
            }
        }.start()
    }

    /**
     *隐藏底部虚拟键并全屏
     */

    fun hideBottomUIMenu() {
        if (Build.VERSION.SDK_INT in 12..18) {
            val view = this.window.decorView
            view.systemUiVisibility = View.GONE

        } else if (Build.VERSION.SDK_INT >= 19) {
            val decorView = window.decorView
            val uiOptions = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)

            decorView.systemUiVisibility = uiOptions
        }else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {


        } else  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val view =this.window.decorView
            val wic = view.windowInsetsController
//            val isVisible =  view.onApplyWindowInsets(this.viewBing.root.rootWindowInsets).isVisible(WindowInsets.Type.statusBars())
            wic?.hide(WindowInsets.Type.statusBars())
        }

    }
}
