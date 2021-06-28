package com.crazy.baseimagegallery.test

import android.util.Log
import android.view.Gravity
import android.view.View
import com.beyondsoft.smarthome.utils.logs.LogTag
import com.crazy.baseimagegallery.R
import com.crazy.baseimagegallery.base.ui.BaseMvpActivity
import com.crazy.baseimagegallery.databinding.ActivityMainBinding

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: testActivity
 * Author: zy
 * Date: 2021/6/23 17:41
 * Description:
 * History:

 */
class testActivity : BaseMvpActivity<testPresenter, ActivityMainBinding>() ,Contract.View  {

    override fun injectComponent() {
        DaggerTestComponent.builder()
            .activityComponent(mActivityComponent)
            .testModule(testModule(this))
            .build()
            .inject(this)
    }
    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate( layoutInflater)

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initView() {
        viewBing.tvTest.visibility = View.VISIBLE
    }

    override fun initData() {
        viewBing.tvTest.gravity = Gravity.CENTER
        viewBing.tvTest.text = "initData"
        LogTag.d("debug")

        mPresenter.getSongList("1",2)
    }

    override fun showSongList(data: List<String>) {
        LogTag.d("showSongList${data.size}")
    }

}