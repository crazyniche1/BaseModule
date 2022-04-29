package com.crazy.baseimagegallery.util

import android.app.Activity
import android.app.ActivityManager
import android.app.Service
import android.content.Context

/**
 * Copyright (C), 2015-2022, 博彦科技
 * FileName: AppUtils
 * Author: zy
 * Date: 2022/4/8 17:21
 * Description:
 * History:

 */
class AppUtils(private var mActivity:Context) {
    /**
     * 服务是否运行
     */

     fun serviceIsRun(clazz: String): Boolean {
        var isRun =false
        val amc = mActivity.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        var services :List<ActivityManager.RunningServiceInfo> = amc.getRunningServices(Int.MAX_VALUE)

        for (service in  services ){
            if (service.service.className == clazz) return true
        }
        return isRun
    }

    fun getVersion( pk:String): String? {
         return mActivity.packageManager.getPackageInfo(pk,0).versionName

    }
}