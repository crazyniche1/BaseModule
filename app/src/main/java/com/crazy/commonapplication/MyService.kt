package com.crazy.commonapplication

import android.app.Service
import android.content.Intent
import android.content.ServiceConnection
import android.os.Handler
import android.os.IBinder
import com.beyondsoft.smarthome.utils.logs.LogTag
import kotlinx.coroutines.delay
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import java.util.*
import kotlin.collections.ArrayList

class MyService : Service() {
    override fun onCreate() {
        if (!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this)
        }

        super.onCreate()


        LogTag.d("MyService_onCreate")
    }

    @Subscribe
    fun startReadonInventoryTag(scanBusEventBean: EventBusType?) {
    }
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
        LogTag.d("MyService_onBind")
    }

    override fun unbindService(conn: ServiceConnection) {
        super.unbindService(conn)
        LogTag.d("MyService_unbindService")
    }


    private var epcIDMap: HashMap<String, Any> = HashMap()
    private var epcIDList: ArrayList<String> = ArrayList()
    private var i  = 1
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        sendData()
        val task: TimerTask = object : TimerTask() {
            override fun run() {
                i++
                val hexStr = i.toString()
                epcIDList.add(hexStr)
//            epcIDMap[hexStr] = 0
                onStartCommand(intent, flags, startId)
            }
        }
        val timer = Timer()
        timer.schedule(task, 300)

        return super.onStartCommand(intent, flags, startId)
    }

    fun sendData() {

        val task: TimerTask = object : TimerTask() {
            override fun run() {
                EventBus.getDefault().post(EventBusType(epcIDList))
                epcIDList.clear()
                sendData()
            }
        }
        val timer = Timer()
        timer.schedule(task, 3000)


    }

    override fun onDestroy() {
        EventBus.getDefault().unregister(this)
        super.onDestroy()
        LogTag.d("MyService_onDestroy")
    }
}