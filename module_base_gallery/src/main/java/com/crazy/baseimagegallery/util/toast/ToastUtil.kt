package com.crazy.baseimagegallery.util.toast

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import com.beyondsoft.smarthome.utils.logs.LogTag

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: ToastUtil
 * Author: zy
 * Date: 2021/12/21 17:26
 * Description: 吐司
 * History:

 */
object ToastUtil {

    private  var mAapplication: Context? =null

    fun init(application:Context): ToastUtil {
        mAapplication = application
        return ToastUtil
    }

    //普通展示
    private fun mShow(cs: CharSequence, duration: Int) {
        Toast.makeText(mAapplication,cs,duration).show()
    }

    private fun show(t:String, duration: Int) {
        mShow(if (t.isNullOrEmpty()) "" else t,duration)
    }

    fun showShort(@StringRes resId:Int) {
        LogTag.d(""+mAapplication)
        mAapplication?.resources?.let { mShow(it?.getText(resId),Toast.LENGTH_SHORT) }
    }

    fun showShort(t:String) {
        show(t,Toast.LENGTH_SHORT)
    }
    fun showLong(@StringRes resId:Int) {
        mAapplication?.resources?.let { mShow(it?.getText(resId),Toast.LENGTH_LONG) }
    }
    fun showLong(t:String) {
        show(t,Toast.LENGTH_LONG)
    }


}