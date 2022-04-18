package com.crazy.commonapplication

import android.app.Service
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import com.beyondsoft.smarthome.utils.logs.LogTag
import com.crazy.commonapplication.services.LocalService

class MyService2 : Service() {

    override fun onCreate() {
        super.onCreate()
        LogTag.d("MyService_onCreate")
    }
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
        LogTag.d("MyService_onBind")
    }

    override fun unbindService(conn: ServiceConnection) {
        super.unbindService(conn)
        LogTag.d("MyService_unbindService")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        LogTag.d("MyService_onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        LogTag.d("MyService_onDestroy")
    }
}