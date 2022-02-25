package com.crazy.baseimagegallery.mvvm.view

import android.app.Activity
import android.content.res.Resources
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.crazy.baseimagegallery.base.BaseApplication
import com.crazy.baseimagegallery.base.ui.activity.BaseActivity
import com.crazy.baseimagegallery.base.ui.fragment.BaseFragment
import com.crazy.baseimagegallery.databinding.ActivityMainBinding
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
 abstract class BaseVMFragment<V: ViewBinding> :BaseFragment<V>() {
    var mActivityProvider: ViewModelProvider? = null
    var mApplicationProvider: ViewModelProvider? = null
    val mActivity: FragmentActivity = this.activity!!

    open fun <T : ViewModel> getFragmentScopeViewModel( ml :Class<T> ) :T{
        if (mActivityProvider == null) {
            mActivityProvider = ViewModelProvider(this)

        }
        return mActivityProvider!![ml]
    }


    open fun <T : ViewModel> getActivityScopeViewModel( ml :Class<T> ) :T{
        if (mActivityProvider == null) {
            mActivityProvider = ViewModelProvider(mActivity)

        }
        return mActivityProvider!![ml]
    }

    fun <T : ViewModel> getApplicationScopeViewModel( ml :Class<T> ) :T{
        if (mApplicationProvider == null) {
            mApplicationProvider = ViewModelProvider(mActivity.applicationContext as BaseApplication)

        }
        return mApplicationProvider!![ml]
    }



}