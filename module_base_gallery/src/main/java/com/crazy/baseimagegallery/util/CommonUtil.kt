package com.crazy.baseimagegallery.util

import android.app.ProgressDialog
import android.content.Context
import android.os.Process
import com.crazy.baseimagegallery.util.activity.ActivityManager
import kotlin.system.exitProcess

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: CommonUtil
 * Author: zy
 * Date: 2021/6/21 16:56
 * Description:
 * History:

 */
object CommonUtil {

    fun showLoadingDialog(context: Context?): ProgressDialog {
        val progressDialog = ProgressDialog(context)
        progressDialog.let {

            it.isIndeterminate = true
            it.setCancelable(false)
            it.setCanceledOnTouchOutside(false)
            it.show()
            return it
        }
    }

      fun buildStringNotNull (string: String?) :String {
        if (string.isNullOrEmpty()) {
            return ""
        }
        return string
    }

    /**
     * 退出应用
     */
    fun exitApp() {
        ActivityManager.instance.finishAll()
        Process.killProcess(Process.myPid())
        exitProcess(0)
    }
}