package com.crazy.baseimagegallery.util.activity

import android.app.Activity
import java.util.*

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: ActivityManager
 * Author: zy
 * Date: 2021/12/1 14:05
 * Description:
 * History:
 *

 */
class ActivityManager {
    private val activityStace :Stack<Activity> =Stack()
    //單例模式
    companion object {
        val instance : ActivityManager by lazy { ActivityManager() }
    }


    fun addActivity(activity: Activity) {
        activityStace.add(activity)
    }

    fun removeActivity(activity: Activity) {
        activityStace.remove(activity)
    }
    fun currentActivity() : Activity {
       return activityStace.lastElement()
    }


    fun finishAll() {
        for (activity in activityStace){
            activity.finish()
        }
        activityStace.clear()
    }

}