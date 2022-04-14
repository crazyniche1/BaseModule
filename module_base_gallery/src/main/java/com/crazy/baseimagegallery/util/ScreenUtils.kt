package com.crazy.baseimagegallery.util

import android.Manifest.permission
import android.annotation.SuppressLint
import android.app.Activity
import android.app.KeyguardManager
import android.content.Context
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Point
import android.provider.Settings
import android.provider.Settings.SettingNotFoundException
import android.util.DisplayMetrics
import android.view.Surface
import android.view.WindowManager
import androidx.annotation.RequiresPermission

/**
 * Copyright (C), 2015-2022, 博彦科技
 * FileName: ScreenUtils
 * Author: zy
 * Date: 2022/2/15 17:55
 * Description:
 * History:

 */
class ScreenUtils {

    private fun ScreenUtils() {
        throw UnsupportedOperationException("u can't instantiate me...")
    }

    /**
     * Return the width of screen, in pixel.
     *
     * @return the width of screen, in pixel
     */
    fun getScreenWidth(): Int {
        val wm = Utils().getApp()!!.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val point = Point()
        wm.defaultDisplay.getRealSize(point)
        return point.x
    }

    /**
     * Return the height of screen, in pixel.
     *
     * @return the height of screen, in pixel
     */
    fun getScreenHeight(): Int {
        val wm = Utils().getApp()!!.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val point = Point()
        wm.defaultDisplay.getRealSize(point)
        return point.y
    }

    /**
     * Return the density of screen.
     *
     * @return the density of screen
     */
    fun getScreenDensity(): Float {
        return Resources.getSystem().displayMetrics.density
    }

    /**
     * Return the screen density expressed as dots-per-inch.
     *
     * @return the screen density expressed as dots-per-inch
     */
    fun getScreenDensityDpi(): Int {
        return Resources.getSystem().displayMetrics.densityDpi
    }

    /**
     * Set full screen.
     *
     * @param activity The activity.
     */
    fun setFullScreen(activity: Activity) {
        activity.window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    /**
     * Set non full screen.
     *
     * @param activity The activity.
     */
    fun setNonFullScreen(activity: Activity) {
        activity.window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    /**
     * Toggle full screen.
     *
     * @param activity The activity.
     */
    fun toggleFullScreen(activity: Activity) {
        val fullScreenFlag = WindowManager.LayoutParams.FLAG_FULLSCREEN
        val window = activity.window
        if (window.attributes.flags and fullScreenFlag == fullScreenFlag) {
            window.clearFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN
                        or WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        } else {
            window.addFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN
                        or WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
    }

    /**
     * Return whether screen is full.
     *
     * @param activity The activity.
     * @return `true`: yes<br></br>`false`: no
     */
    fun isFullScreen(activity: Activity): Boolean {
        val fullScreenFlag = WindowManager.LayoutParams.FLAG_FULLSCREEN
        return (activity.window.attributes.flags and fullScreenFlag) == fullScreenFlag
    }

    /**
     * Return whether screen is landscape.
     *
     * @return `true`: yes<br></br>`false`: no
     */
    fun isLandscape(): Boolean {
        return (Utils().getApp()!!.getResources().getConfiguration().orientation
                === Configuration.ORIENTATION_LANDSCAPE)
    }

    /**
     * Set the screen to landscape.
     *
     * @param activity The activity.
     */
    fun setLandscape(activity: Activity) {
        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }

    /**
     * Return whether screen is portrait.
     *
     * @return `true`: yes<br></br>`false`: no
     */
    fun isPortrait(): Boolean {
        return (Utils().getApp()!!.getResources().getConfiguration().orientation
                === Configuration.ORIENTATION_PORTRAIT)
    }

    /**
     * Set the screen to portrait.
     *
     * @param activity The activity.
     */
    fun setPortrait(activity: Activity) {
        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    /**
     * Return the rotation of screen.
     *
     * @param activity The activity.
     * @return the rotation of screen
     */
    @SuppressLint("SwitchIntDef")
    fun getScreenRotation(activity: Activity): Int {
        when (activity.windowManager.defaultDisplay.rotation) {
            Surface.ROTATION_90 -> return 90
            Surface.ROTATION_180 -> return 180
            Surface.ROTATION_270 -> return 270
            else -> return 0
        }
    }

    /**
     * Return the bitmap of screen.
     *
     * @param activity The activity.
     * @return the bitmap of screen
     */
    fun screenShot(activity: Activity): Bitmap? {
        return screenShot(activity, false)
    }

    /**
     * Return the bitmap of screen.
     *
     * @param activity          The activity.
     * @param isDeleteStatusBar True to delete status bar, false otherwise.
     * @return the bitmap of screen
     */
    fun screenShot(activity: Activity, isDeleteStatusBar: Boolean): Bitmap? {
        val decorView = activity.window.decorView
        decorView.isDrawingCacheEnabled = true
        decorView.setWillNotCacheDrawing(false)
        val bmp = decorView.drawingCache ?: return null
        val dm = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(dm)
        val ret: Bitmap
        if (isDeleteStatusBar) {
            val resources = activity.resources
            val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
            val statusBarHeight = resources.getDimensionPixelSize(resourceId)
            ret = Bitmap.createBitmap(
                bmp,
                0,
                statusBarHeight,
                dm.widthPixels,
                dm.heightPixels - statusBarHeight
            )
        } else {
            ret = Bitmap.createBitmap(bmp, 0, 0, dm.widthPixels, dm.heightPixels)
        }
        decorView.destroyDrawingCache()
        return ret
    }

    /**
     * Return whether screen is locked.
     *
     * @return `true`: yes<br></br>`false`: no
     */
    fun isScreenLock(): Boolean {
        val km = Utils().getApp()!!.getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
        return km.inKeyguardRestrictedInputMode()
    }

    /**
     * Return the duration of sleep.
     *
     * @return the duration of sleep.
     */
    fun getSleepDuration(): Int {
        try {
            return Settings.System.getInt(
                Utils().getApp()!!.getContentResolver(),
                Settings.System.SCREEN_OFF_TIMEOUT
            )
        } catch (e: SettingNotFoundException) {
            e.printStackTrace()
            return -123
        }
    }

    /**
     * Set the duration of sleep.
     *
     * Must hold `<uses-permission android:name="android.permission.WRITE_SETTINGS" />`
     *
     * @param duration The duration.
     */
    @RequiresPermission(permission.WRITE_SETTINGS)
    fun setSleepDuration(duration: Int) {
        Settings.System.putInt(
            Utils().getApp()!!.getContentResolver(),
            Settings.System.SCREEN_OFF_TIMEOUT,
            duration
        )
    }

    /**
     * Return whether device is tablet.
     *
     * @return `true`: yes<br></br>`false`: no
     */
    fun isTablet(): Boolean {
        return ((Utils().getApp()!!.getResources().getConfiguration().screenLayout
                and Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE)
    }
}