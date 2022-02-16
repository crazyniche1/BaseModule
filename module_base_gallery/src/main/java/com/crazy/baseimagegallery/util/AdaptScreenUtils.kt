package com.crazy.baseimagegallery.util

import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.Log
import java.lang.reflect.Field

/**
 * Copyright (C), 2015-2022, 博彦科技
 * FileName: AdaptScreenUtils
 * Author: zy
 * Date: 2022/2/16 9:53
 * Description:
 * History:

 */
class AdaptScreenUtils {

    private var isInitMiui = false
    private var mTmpMetricsField: Field? = null

    /**
     * Adapt for the horizontal screen, and call it in [android.app.Activity.getResources].
     */
    fun adaptWidth(resources: Resources, designWidth: Int): Resources? {
        val dm = getDisplayMetrics(resources)
        dm.xdpi = dm.widthPixels * 72f / designWidth
        val newXdpi = dm.xdpi
        setAppDmXdpi(newXdpi)
        return resources
    }

    /**
     * Adapt for the vertical screen, and call it in [android.app.Activity.getResources].
     */
    fun adaptHeight(resources: Resources, designHeight: Int): Resources? {
        val dm = getDisplayMetrics(resources)
        dm.xdpi = dm.heightPixels * 72f / designHeight
        val newXdpi = dm.xdpi
        setAppDmXdpi(newXdpi)
        return resources
    }

    /**
     * @param resources The resources.
     * @return the resource
     */
    fun closeAdapt(resources: Resources): Resources? {
        val dm = getDisplayMetrics(resources)
        dm.xdpi = dm.density * 72
        val newXdpi = dm.xdpi
        setAppDmXdpi(newXdpi)
        return resources
    }

    /**
     * Value of pt to value of px.
     *
     * @param ptValue The value of pt.
     * @return value of px
     */
    fun pt2Px(ptValue: Float): Int {
        val metrics: DisplayMetrics = Utils().getApp()!!.getResources().getDisplayMetrics()
        return (ptValue * metrics.xdpi / 72f + 0.5).toInt()
    }

    /**
     * Value of px to value of pt.
     *
     * @param pxValue The value of px.
     * @return value of pt
     */
    fun px2Pt(pxValue: Float): Int {
        val metrics: DisplayMetrics = Utils().getApp()!!.getResources().getDisplayMetrics()
        return (pxValue * 72 / metrics.xdpi + 0.5).toInt()
    }

    private fun setAppDmXdpi(xdpi: Float) {
        Utils().getApp()!!.getResources().getDisplayMetrics().xdpi = xdpi
    }

    private fun getDisplayMetrics(resources: Resources): DisplayMetrics {
        return getMiuiTmpMetrics(resources) ?: return resources.displayMetrics
    }

    @Deprecated("这个方法 暂时不用")
    private fun getMiuiTmpMetrics(resources: Resources): DisplayMetrics? {
        if (!isInitMiui) {
            var ret: DisplayMetrics? = null
            val simpleName = resources.javaClass.simpleName
            if ("MiuiResources" == simpleName || "XResources" == simpleName) {
                try {
                    mTmpMetricsField = Resources::class.java.getDeclaredField("mTmpMetrics")
//                    mTmpMetricsField.setAccessible(true)
//                    ret = mTmpMetricsField.get(resources) as DisplayMetrics
                } catch (e: Exception) {
                    Log.e("AdaptScreenUtils", "no field of mTmpMetrics in resources.")
                }
            }
            isInitMiui = true
            return ret
        }
        return if (mTmpMetricsField == null) {
            null
        } else try {
            mTmpMetricsField!![resources] as DisplayMetrics
        } catch (e: Exception) {
            null
        }
    }

}