package com.crazy.baseimagegallery.base

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context
import com.crazy.baseimagegallery.inject.component.DaggerAppComponent
import com.crazy.baseimagegallery.inject.module.AppMoudle
import com.tencent.mmkv.MMKV
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import org.jetbrains.annotations.Contract
import javax.inject.Inject


/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: BaseApplication
 * Author: zy
 * Date: 2021/6/17 17:22
 * Description: application基类
 * History:
 */
class BaseApplication : Application() , HasActivityInjector {

    @Inject
    lateinit internal var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    lateinit var appComponent: DaggerAppComponent

    override fun onCreate() {
        super.onCreate()
        initDagger()

        initMMKV()
    }

    private fun initMMKV (){
        val rootDir = MMKV.initialize(this)
        print("mmkv root:$rootDir")
    }

    /**
     * 初始化 dagger 库
     */
    private fun initDagger() {
        appComponent = DaggerAppComponent.builder()
            .appMoudle(AppMoudle(this))
            .build() as DaggerAppComponent
//        DaggerAppComponent.builder()
//            .application(this)
//            .build()
//            .inject(this)
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun activityInjector(): AndroidInjector<Activity> =activityDispatchingAndroidInjector

    open fun xixi(): Context {
        return applicationContext
    }
}