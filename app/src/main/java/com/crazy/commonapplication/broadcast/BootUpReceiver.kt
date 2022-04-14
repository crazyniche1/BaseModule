package com.crazy.commonapplication.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.beyondsoft.smarthome.utils.logs.LogTag

/**
 * 开机自启动
 */
class BootUpReceiver : BroadcastReceiver() {
    var SCREEN_ON = "android.intent.action.SCREEN_ON"
    var SCREEN_OFF = "android.intent.action.SCREEN_OFF"

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        LogTag.d("通过广播启动应用")
        if (SCREEN_ON.equals(intent.getAction())) {
            LogTag.d("ppp","ppp-屏幕亮了");
        }
        else if (SCREEN_OFF.equals(intent.getAction())) {
            LogTag.d("ppp","ppp-屏幕暗了");
        }
    }
}