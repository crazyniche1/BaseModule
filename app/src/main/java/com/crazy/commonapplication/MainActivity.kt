package com.crazy.commonapplication

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatDelegate
import com.crazy.baseimagegallery.base.ui.activity.BaseActivity
import com.crazy.commonapplication.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private var isNight =false
    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {
//        viewBing.tv.text = "测试测试测试测试测试测试测试"
//        viewBing.tv.setTextColor(resources.getColor(R.color.red))

        viewBing.bt.setOnClickListener {

            AppCompatDelegate.setDefaultNightMode( AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }
    }

    override fun initData() {

    }

}