package com.crazy.baseimagegallery.template

import android.text.Editable
import android.text.TextWatcher
import com.crazy.baseimagegallery.base.ui.activity.BaseActivity
import com.crazy.baseimagegallery.databinding.ActivityMainBinding
import com.tencent.bugly.crashreport.CrashReport

class TMainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {
        viewBing.button.setOnClickListener {
//            SharedUtil<Any>(this,).image("https://upload-images.jianshu.io/upload_images/3708736-e18ae9e2ab80e87d.png?imageMogr2/auto-orient/strip|imageView2/2/w/345/format/webp")

            CrashReport.testJavaCrash()
        }

        viewBing.etv.addTextChangedListener(object :xxx(){
            override fun afterTextChanged(s: Editable?) {
                super.afterTextChanged(s)
            }
        })

    }

    override fun initData() {

    }

}

open class xxx :TextWatcher{
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(s: Editable?) {
    }

}