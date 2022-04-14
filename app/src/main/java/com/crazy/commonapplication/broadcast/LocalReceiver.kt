package com.crazy.commonapplication.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.beyondsoft.smarthome.utils.logs.LogTag

/**
 * Copyright (C), 2015-2022, 博彦科技
 * FileName: LocalReceiver
 * Author: zy
 * Date: 2022/3/29 11:26
 * Description:
 * History:

 */
class LocalReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        TODO("Not yet implemented")
        LogTag.d("通过本地广播启动应用")
    }
}