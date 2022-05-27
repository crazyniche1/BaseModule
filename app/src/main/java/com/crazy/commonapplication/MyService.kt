package com.crazy.commonapplication

import android.app.*
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.beyondsoft.smarthome.utils.logs.LogTag
import java.util.*


class MyService : Service() {
    override fun onCreate() {
//        if (!EventBus.getDefault().isRegistered(this)){
//            EventBus.getDefault().register(this)
//        }

        super.onCreate()


        LogTag.d("MyService_onCreate")
    }

    override fun unbindService(conn: ServiceConnection) {
        super.unbindService(conn)
        LogTag.d("MyService_unbindService")
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val nc = notification(pendingIntent())
//        NotificationManagerCompat.from(this).notify()
        startForeground(123,nc)

        return super.onStartCommand(intent, flags, startId)
    }

    private fun notification(intent: PendingIntent): Notification {
        var notificationChannel: NotificationChannel?
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel = NotificationChannel(
                "setChannelId",
                "前台服务", NotificationManager.IMPORTANCE_HIGH
            )
            notificationChannel.lockscreenVisibility = Notification.VISIBILITY_PUBLIC
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(notificationChannel)

        }


         return   NotificationCompat.Builder(this,"setChannelId")
                .setContentText("ContentText")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(intent)
                .setTicker("Ticker")
                .build()
    }

    private fun pendingIntent(): PendingIntent {
        return Intent(this, MainActivity2::class.java).let { notificationIntent ->
            PendingIntent.getActivity(this, 0, notificationIntent, 0)
        }
    }


    override fun onDestroy() {
//        EventBus.getDefault().unregister(this)
        super.onDestroy()
        LogTag.d("MyService_onDestroy")
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}