package com.crazy.commonapplication

import com.crazy.baseimagegallery.base.ui.activity.BaseActivity
import com.crazy.commonapplication.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {


    override fun getLayoutId(): Int  = R.layout.activity_main

    override fun getViewBinding(): ActivityMainBinding  = ActivityMainBinding.inflate(layoutInflater)

    override fun initView() {

    }

    override fun initData() {

    }

}