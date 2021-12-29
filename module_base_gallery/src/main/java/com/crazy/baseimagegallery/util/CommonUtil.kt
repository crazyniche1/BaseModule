package com.crazy.baseimagegallery.util

import android.app.ProgressDialog
import android.content.Context
import android.text.TextUtils
import com.crazy.baseimagegallery.util.activity.ActivityManager
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: CommonUtil
 * Author: zy
 * Date: 2021/6/21 16:56
 * Description:
 * History:

 */
object CommonUtil {

    /**
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
     fun getProcessName(pid: Int): String? {
        var reader: BufferedReader? = null
        try {
            reader = BufferedReader(FileReader("/proc/$pid/cmdline"))
            var processName: String = reader.readLine()
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim { it <= ' ' }
            }
            return processName
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
        } finally {
            try {
                if (reader != null) {
                    reader.close()
                }
            } catch (exception: IOException) {
                exception.printStackTrace()
            }
        }
        return null
    }

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
//        Process.killProcess(Process.myPid())
//        exitProcess(0)
    }
}