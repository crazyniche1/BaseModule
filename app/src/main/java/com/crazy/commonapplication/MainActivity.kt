package com.crazy.commonapplication

import android.os.Build.VERSION
import android.os.StrictMode
import com.crazy.baseimagegallery.base.ui.activity.BaseActivity
import com.crazy.baseimagegallery.util.share.SharedUtil
//import com.crazy.baseimagegallery.util.share.SharedUtil
import com.crazy.commonapplication.databinding.ActivityMainBinding
import com.crazy.mshare.concreteBuilder.ConcreteShareBuilder


class MainActivity : BaseActivity<ActivityMainBinding>() {

    private var isNight =false
    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {
//        viewBing.tv.text = "测试测试测试测试测试测试测试"
//        viewBing.tv.setTextColor(resources.getColor(R.color.red))
//        val builder = VmPolicy.Builder()
//        StrictMode.setVmPolicy(builder.build())
//        builder.detectFileUriExposure()
        //针对android 7 分享图片读取文件时会引发崩溃。7.0适配-应用之间共享文件
        if (VERSION.SDK_INT >= 24) {
            val builder = StrictMode.VmPolicy.Builder()
            StrictMode.setVmPolicy(builder.build())
        }
        viewBing.bt.setOnClickListener {

//            AppCompatDelegate.setDefaultNightMode( AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
//            SharedUtil<Any>(this).imageAPP("https://upload-images.jianshu.io/upload_images/3708736-e18ae9e2ab80e87d.png")
//            SharedUtil<Any>(this).toInstallWebView("http://weixin.qq.com/download")


            ConcreteShareBuilder(this).create().shareText("nihao").show()
        }
    }

    override fun initData() {

    }

}