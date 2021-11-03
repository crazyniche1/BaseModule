package com.crazy.baseimagegallery.template

import com.crazy.baseimagegallery.base.ui.activity.BaseActivity
import com.crazy.baseimagegallery.databinding.ActivityMainBinding

class TMainActivity : BaseActivity<ActivityMainBinding>() {


    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {
        viewBing.button.setOnClickListener {
//            SharedUtil<Any>(this,).image("https://upload-images.jianshu.io/upload_images/3708736-e18ae9e2ab80e87d.png?imageMogr2/auto-orient/strip|imageView2/2/w/345/format/webp")
        }

    }

    override fun initData() {

    }

}