package com.crazy.baseimagegallery.util

/**
 * Copyright (C), 2015-2022, 博彦科技
 * FileName: BroadCastUtil
 * Author: zy
 * Date: 2022/3/29 11:11
 * Description:
 * History:

 */
object BroadCastUtil {

    /*高版本会有延时且只能监听屏幕熄灭 ，监听屏幕唤醒和熄灭 ，不稳定 */
//    private fun registSreenStatusReceiver() {
//        val mScreenStatusReceiver = BootUpReceiver()
//        val screenStatusIF = IntentFilter()
//        screenStatusIF.addAction(Intent.ACTION_SCREEN_ON)
//        screenStatusIF.addAction(Intent.ACTION_SCREEN_OFF)
//        registerReceiver(mScreenStatusReceiver, screenStatusIF)
//    }
//    //监听网络变化
//    fun netChange(){
//        val intentFilter = IntentFilter()
//        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE")
//        val bootUpReceiver = BootUpReceiver()
//        registerReceiver(bootUpReceiver, intentFilter)
//
//        registerBlueToothStateReceiver(activity = this)
//    }
//
//    //注册广播接收器，用于监听蓝牙状态变化
//    fun registerBlueToothStateReceiver(activity: Activity) {
//        val blueToothStateReceiver = BootUpReceiver()
//        val filter = IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED)
//        activity.registerReceiver(blueToothStateReceiver, filter)
//
//    }
}