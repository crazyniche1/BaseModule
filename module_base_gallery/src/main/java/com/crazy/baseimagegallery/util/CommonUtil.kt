package com.crazy.baseimagegallery.util

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.widget.ProgressBar
//import com.crazy.baseimagegallery.R

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
            it.show()
            it.isIndeterminate = true
            it.setCancelable(false)
            it.setCanceledOnTouchOutside(false)
            return it
        }
    }

      fun buildStringNotNull (string: String) :String {
        if (string.isNullOrEmpty()) {
            return ""
        }
        return string
    }
}