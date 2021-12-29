package com.crazy.baseimagegallery.base

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.crazy.baseimagegallery.BuildConfig
import com.crazy.baseimagegallery.inject.component.DaggerAppComponent
import com.crazy.baseimagegallery.inject.module.AppMoudle
import com.crazy.baseimagegallery.util.AppConstants
import com.crazy.baseimagegallery.util.CommonUtil
import com.crazy.baseimagegallery.util.toast.ToastUtil
import com.tencent.bugly.crashreport.CrashReport
import com.tencent.mmkv.MMKV
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
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
    internal lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    lateinit var appComponent: DaggerAppComponent

    override fun onCreate() {
        super.onCreate()
        initDagger()

        initMMKV()

        ToastUtil.init(this)

        initARouter()

        initBugly()
    }

    private fun initBugly() {
        val st = setStrategy()
        CrashReport.initCrashReport(this, AppConstants.Bugly_AppId, BuildConfig.DEBUG ,st)
    }

    /**
     * 多进程应用仅仅在主线程显示log
     */
    private fun setStrategy() :CrashReport.UserStrategy{
        val  processName  = CommonUtil.getProcessName(android.os.Process.myPid())
        val crs = CrashReport.UserStrategy(this)
        crs.isUploadProcess  = processName == null || processName == packageName
        return crs
    }

    private fun initARouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
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

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)

    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun activityInjector(): AndroidInjector<Activity> =activityDispatchingAndroidInjector

}