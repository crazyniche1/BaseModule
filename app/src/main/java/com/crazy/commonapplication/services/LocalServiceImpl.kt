package com.crazy.commonapplication.services

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import com.alibaba.android.arouter.facade.annotation.Route
import com.beyondsoft.smarthome.utils.logs.LogTag
import com.crazy.baseimagegallery.util.AppUtils
import com.crazy.baseimagegallery.util.arouter.RouterPath
import com.crazy.commonapplication.MyService

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: LocalServiceImpl
 * Author: zy
 * Date: 2021/12/29 11:22
 * Description:
 * History:

 */
@Route(path = RouterPath.Service.s1,name = "测试服务")
open class LocalService:Sprovider {
    override fun initService(name: String): String {
        LogTag.d("初始化接口${name}")
        return name
    }

    /**
     * startService  方式
     */
    override fun init(context: Context?) {
        LogTag.d("ARouter初始化函数${Thread.currentThread().name}")
            context?. startService(Intent(context, MyService::class.java))


    }


}