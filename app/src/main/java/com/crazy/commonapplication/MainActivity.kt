package com.crazy.commonapplication

import com.crazy.baseimagegallery.base.ui.activity.BaseActivity
import com.crazy.commonapplication.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {


    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {
        viewBing.tv.text = "测试测试测试测试测试测试测试"

    }

    override fun initData() {

    }

}