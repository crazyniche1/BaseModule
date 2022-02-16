package com.crazy.baseimagegallery.mvvm.view

import android.content.res.Resources
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.crazy.baseimagegallery.base.BaseApplication
import com.crazy.baseimagegallery.base.ui.activity.BaseActivity
import com.crazy.baseimagegallery.util.AdaptScreenUtils
import com.crazy.baseimagegallery.util.ScreenUtils

/**
 * Copyright (C), 2015-2022, 博彦科技
 * FileName: BaseVMActivity
 * Author: zy
 * Date: 2022/2/11 17:37
 * Description:
 * 同时 获取viewModel 的 不同 * History:

 */
 abstract class BaseVMActivity<V: ViewBinding> :BaseActivity<V>() {
    var mActivityProvider: ViewModelProvider? = null
    var mApplicationProvider: ViewModelProvider? = null

    open fun <T : ViewModel> getActivityScopeViewModel( ml :Class<T> ) :T{
        if (mActivityProvider == null) {
            mActivityProvider = ViewModelProvider(this)

        }
        return mActivityProvider!![ml]
    }

    fun <T : ViewModel> getApplicationScopeViewModel( ml :Class<T> ) :T{
        if (mApplicationProvider == null) {
            mApplicationProvider = ViewModelProvider(this.applicationContext as BaseApplication)

        }
        return mApplicationProvider!![ml]
    }

//    override fun getResources(): Resources? {
//        return if (ScreenUtils().isPortrait()) {
//            AdaptScreenUtils().adaptHeight(super.getResources(), 360)
//        } else {
//            AdaptScreenUtils().adaptHeight(super.getResources(), 640)
//        }
//        return super.getResources()
//    }


}